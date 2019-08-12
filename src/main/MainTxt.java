package main;

import core.fuzzy.CalculaImportancia;
import core.fuzzy.InputFuzzy;
import core.model.Review;
import core.preProcessamentos.ExtracaoFinalVarPadroes;
import static core.preProcessamentos.ExtracaoFinalVarPadroes.carregaFeatures;
import extracao.corretude.CorretudeCalculator;
import extracao.reputacao.AuthorReputation;
import gramaticas.padroes.PadroesTreeTagger;
import gramaticas.sintagmatica.GramaticaSintagmaticaTreeTagger;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.arquivos.UtilsArquivo;

/**
 *
 * @author Rogério
 */
public class MainTxt {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        HashMap todos = carregaArquivos();

        for (Object folder : todos.keySet()) {
            for (Object doc : ((HashMap) ((HashMap) todos).get(folder)).keySet()) {
                HashMap docs = (HashMap) todos.get(folder);
                List<Review> reviews = (List) docs.get(doc);
                
                try {
                    calculaImportancia(reviews);
                } catch (Exception ex) {
                    Logger.getLogger(MainTxt.class.getName()).log(Level.SEVERE, null, ex);
                }

                String result = "";
                for (Review rv : reviews) {
                    result = result + rv.getPostsAutor() + "\t" + rv.getPadroes().size()
                            + "\t" + rv.getPercentCorretude() + "\t" + rv.getImportancia() + "\n";
                }
                try {
                    UtilsArquivo.salva("recursos/Experimento 3/" + folder + "/" + doc +"_resultado.txt", result);
                } catch (IOException ex) {
                    Logger.getLogger(MainTxt.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    public static HashMap carregaArquivos() throws FileNotFoundException {
        HashMap map = new HashMap();
        map.put("O-Apanhador-no-Campo-de-Centeio", new HashMap<>());
        map.put("O-Outro-Lado-da-Meia-Noite", new HashMap<>());
        map.put("O-Reverso-da-Medalha", new HashMap<>());
        map.put("Se-Houver-Amanha", new HashMap<>());
//        map.put("Fala-Serio-Amiga", new HashMap<>());
//        map.put("Fala-Serio-Amor", new HashMap<>());
//        map.put("Fala-Serio-Mae", new HashMap<>());
//        map.put("Fala-Serio-Pai", new HashMap<>());

        for (Object chave : map.keySet()) {
            File folder = new File("recursos/Experimento 3/" + chave);
            File[] arrDocs = folder.listFiles();
            List listaDocs = Arrays.asList(arrDocs);
            for (Object doc : listaDocs) {
                Scanner sc = new Scanner((File) doc, "UTF-8");
                ArrayList<Review> reviews = new ArrayList<>();
                String primeira = sc.nextLine();
                int postsAutor = 1;
                try {
                    postsAutor = Integer.parseInt(primeira);
                } catch (NumberFormatException e) {
                    System.out.println(chave + ": " + ((File) doc).getName() + ": Sem quantidade.");
                    Review review = new Review();
                    review.setComentario(primeira);
                    review.setPostsAutor(postsAutor);
                    reviews.add(review);
                }

                String linha = "";

                while (sc.hasNext()) {
                    linha = sc.nextLine();
                    Review review = new Review();
                    review.setComentario(linha);
                    review.setPostsAutor(postsAutor);
                    reviews.add(review);
                }
                HashMap pt1 = (HashMap) map.get(chave);
                pt1.put(((File) doc).getName(), reviews);
            }
        }

        return map;
    }

    public static List<Review> carregaArquivo(int num) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("recursos/" + num + ".txt"), "UTF-8");
        ArrayList<Review> reviews = new ArrayList<>();
        String linha = "";
        while (sc.hasNext()) {
            linha = sc.nextLine();
            Review review = new Review();
            review.setComentario(linha.split("\t")[0]);
            review.setPostsAutor(Integer.parseInt(linha.split("\t")[1]));
            reviews.add(review);
        }
        return reviews;
    }

    public static void calculaImportancia(List<Review> reviews) throws FileNotFoundException, Exception {

        /* 
         * Extrair os padroes 
         */
        ExtracaoFinalVarPadroes extrator = new ExtracaoFinalVarPadroes();
        GramaticaSintagmaticaTreeTagger gstt = new GramaticaSintagmaticaTreeTagger();
        PadroesTreeTagger ptt = new PadroesTreeTagger();
//        
        CorretudeCalculator cc = new CorretudeCalculator();
        CalculaImportancia ci = new CalculaImportancia();
        AuthorReputation ar = new AuthorReputation();

        List<String> features = carregaFeatures();

        for (Review review : reviews) {
            //  System.out.println(review.getId());
            String texto = review.getComentario();
//            String texto = "";
            HashMap<String, String> pares = gstt.extraiPares(texto);
            HashMap<String, String> padroes = ptt.extraiPadroes(texto);

            List<String> listPadroes = extrator.contagemPadroesNovo(new ArrayList(pares.keySet()), pares, new ArrayList(padroes.keySet()), padroes, features);
            review.setPadroes(listPadroes);
            int quantPadroes = listPadroes.size();
            double corretude = cc.calculaCorretude(texto);
            int autor = review.getPostsAutor();

            InputFuzzy ipf = new InputFuzzy(autor, quantPadroes, corretude);
            Map<Double, String> resultado = ci.executa(ipf, false);

            review.setPercentCorretude(corretude);
            review.setPostsAutor(autor);
            review.setImportancia((double) (new ArrayList(resultado.keySet())).get(0));
            review.setAvaliacao_conceitual_manual((String) (new ArrayList(resultado.values())).get(0));
        }
//        System.out.println(extrator.contagemPadroes(new ArrayList(pares.keySet()), new ArrayList(padroes.keySet()), features));

//        System.out.println(cc.calculaCorretude(texto));
    }

}
