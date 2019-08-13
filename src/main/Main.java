/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import core.fuzzy.CalculaImportancia;
import core.fuzzy.InputFuzzy;
import core.model.Review;
import core.preProcessamentos.ExtracaoFinalVarPadroes;
import static core.preProcessamentos.ExtracaoFinalVarPadroes.carregaFeatures;
import extracao.corretude.CorretudeCalculator;
import gramaticas.padroes.PadroesTreeTagger;
import gramaticas.sintagmatica.GramaticaSintagmaticaTreeTagger;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.arquivos.UtilsArquivo;

/**
 *
 * @author User
 */
public class Main {

    public static void main(String[] args){
        
        System.out.println(args.length);
        if (args.length <= 0){
            System.out.println("Usage: java -jar topx.jar <filepath> \n" + "The structure of file is: text \\t number of posts \\n" + "\n");
            System.exit(1);
        }
        String filepath = args[0];
        
        List<Review> corpusApp = getReviews(filepath);
        calculaImportancia(corpusApp);

        String corpusAppOut = "Posts_Autor,Padrões,Corretude,Valor_Importância,Conceito_Importância\n";

        for (Review r : corpusApp) {
            corpusAppOut = corpusAppOut + r.getPostsAutor() + "," + r.getPadroes().size() + "," + r.getPercentCorretude()
                + "," + r.getImportancia() +","+ r.getAvaliacao_conceitual_manual() + "\n";
        }

        try {
            UtilsArquivo.salva(filepath+".res", corpusAppOut);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Ler o arquivo de reviews e criar a lista de reviews.
     * 
     * @param filename: Arquivo com 2 colunas separadas por tabulações. 
     * A primeira deve conter o texto e a segunda deve conter a quantidade de reviews do autor do comentário (pelo menos 1).
     * 
     * @return 
     */
    public static List<Review> getReviews(String filepath){
        Scanner sc = null;
        try {
            sc = new Scanner(new File(filepath), "UTF-8");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        List<Review> corpusApp = new ArrayList<Review>();
        while (sc.hasNextLine()){
            String linha = sc.nextLine();
            String[] str_linha = linha.split("\t");
            Review rev = new Review();
            rev.setComentario(str_linha[0].trim());
            rev.setPostsAutor(Integer.parseInt(str_linha[1].trim()));
            corpusApp.add(rev);
        }
        
        return corpusApp;
    }
    
    /* 
    * Extrair os padroes 
    */
    public static void calculaImportancia(List<Review> reviews){
        ExtracaoFinalVarPadroes extrator = new ExtracaoFinalVarPadroes();
        GramaticaSintagmaticaTreeTagger gstt = new GramaticaSintagmaticaTreeTagger();
        PadroesTreeTagger ptt = new PadroesTreeTagger();

        CorretudeCalculator cc = new CorretudeCalculator();
        CalculaImportancia ci = new CalculaImportancia();

        List<String> features = carregaFeatures();

        for (Review review : reviews) {
            String texto = review.getComentario();

            HashMap<String, String> pares = gstt.extraiPares(texto);
            HashMap<String, String> padroes = ptt.extraiPadroes(texto);

            List<String> listPadroes = extrator.contagemPadroes(new ArrayList(pares.keySet()), pares, new ArrayList(padroes.keySet()), padroes, features);
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
    }
}
