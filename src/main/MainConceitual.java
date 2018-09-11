/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import core.fuzzy.CalculaImportancia;
import core.fuzzy.InputFuzzy;
import core.model.Review;
import core.model.comparator.ReviewImportanceComparator;
import core.orientacaoSentimento.DetectaPolaridade;
import core.preProcessamentos.ExtracaoFinalVarPadroes;
import static core.preProcessamentos.ExtracaoFinalVarPadroes.carregaFeatures;
import extracao.corretude.CorretudeCalculator;
import extracao.reputacao.AuthorReputation;
import gramaticas.padroes.PadroesTreeTagger;
import gramaticas.sintagmatica.GramaticaSintagmaticaTreeTagger;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import util.arquivos.UtilsArquivo;
import util.banco.BancoAutores;
import util.banco.GravaCorpusBuscape;
import util.banco.GravaReviews;

/**
 *
 * @author User
 */
public class MainConceitual {

    public static void main(String[] args) throws FileNotFoundException, Exception {
        DetectaPolaridade detecPol = new DetectaPolaridade();
        
//        List<Review> corpusBuscapePuro = GravaReviews.selectReviews();
        List<Review> corpusBuscapeRevisado = new ArrayList<>();
        corpusBuscapeRevisado.addAll(GravaCorpusBuscape.selectAvaliacaoConceitual());
//        corpusBuscapeRevisado.addAll(GravaCorpusBuscape.selectNegativos());
//        corpusBuscapeRevisado.addAll(GravaCorpusBuscape.selectPositivosNegativos());
        
        /*
         * Inicio
         */
//                List<Review> corpusBuscapeRevisado = GravaReviews.selectCommentsImportanciaManual();
        /*
         * Fim
         */

//        System.out.println("Polarização Puro: ");
//        detecPol.executaAvalLexico(corpusBuscapePuro);
        
//        calculaImportancia(corpusBuscapePuro);
        calculaImportancia(corpusBuscapeRevisado);

//        System.out.println("Polarização Buscapé Revisado: ");
//        detecPol.executaAvalLexicoNovo(corpusBuscapeRevisado);
        detecPol.executaAvalLexico(corpusBuscapeRevisado);
        
//        String corpusBPuroString = "";
        String corpusBRevisadoString = "";
        
        for(Review r : corpusBuscapeRevisado){
            corpusBRevisadoString = corpusBRevisadoString + r;
        }
        
//        for(Review r : corpusBuscapeRevisado){
//            corpusBRevisadoString = corpusBRevisadoString + r.getId() + "\t" +
//                    r.getAvaliacao_conceitual() + "\t" +
//                    r.getAvaliacao_conceitual_manual() +"\n";
////            corpusBRevisadoString = corpusBRevisadoString + r;
//        }
        
//        UtilsArquivo.salva("corpusBuscapePuro.txt", corpusBPuroString);
//        UtilsArquivo.salva("corpusBuscapeRevisado.txt", corpusBRevisadoString);
        UtilsArquivo.salva("corpusBuscapeConceitual.txt", corpusBRevisadoString);
        //calcular P, R, F
//        ReviewImportanceComparator ric = new ReviewImportanceComparator();
        
//        Collections.sort(corpusBuscapePuro,ric);

        
        System.out.println("Terminei");
    }
    
    /**
     * TODO: - Calcular a acuracia geral: Corretos/total
     *       - Calcular a acuracia dos Positivos: Acertos Positivos/Positivos Total
     *       - Calcular a acurácia dos Negativos: Acertos Negativos/Negativos Total
     * @param reviews 
     */
    public static void calcAcuracia(List<Review> reviews){
        
    }
    /* 
     * Ler comentários 
     * Extrair padrões ok
     * Extrair corretude ok
     * Rodar Fuzzy ok
     * 
     */

    public static void calculaImportancia(Review review) throws FileNotFoundException, Exception {
        String texto = review.getComentario();
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

        HashMap<String, String> pares = gstt.extraiPares(texto);
        HashMap<String, String> padroes = ptt.extraiPadroes(texto);

        List<String> features = carregaFeatures();

        int quantPadroes = extrator.contagemPadroes(new ArrayList(pares.keySet()), new ArrayList(padroes.keySet()), features);
        double corretude = cc.calculaCorretude(texto);
        int autor = ar.getQuantPostsAutores(review.getAutor());

        InputFuzzy ipf = new InputFuzzy(autor, quantPadroes, corretude);
        Map<Double, String> resultado = ci.executa(ipf, false);

        review.setImportancia((double) (new ArrayList(resultado.keySet())).get(0));
        review.setAvaliacao_conceitual_manual((String) (new ArrayList(resultado.values())).get(0));
//        System.out.println(extrator.contagemPadroes(new ArrayList(pares.keySet()), new ArrayList(padroes.keySet()), features));

//        System.out.println(cc.calculaCorretude(texto));
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
            System.out.println(review.getId());
            String texto = review.getComentario();
//            String texto = "";
            HashMap<String, String> pares = gstt.extraiPares(texto);
            HashMap<String, String> padroes = ptt.extraiPadroes(texto);

            List<String> listPadroes = extrator.contagemPadroesNovo(new ArrayList(pares.keySet()),pares ,new ArrayList(padroes.keySet()),padroes, features);
            review.setPadroes(listPadroes);
            int quantPadroes = listPadroes.size();
            double corretude = cc.calculaCorretude(texto);
            int autor = ar.getQuantPostsAutores(review.getAutor());

            InputFuzzy ipf = new InputFuzzy(autor, quantPadroes, corretude);
            Map<Double, String> resultado = ci.executa(ipf, false);

            review.setImportancia((double) (new ArrayList(resultado.keySet())).get(0));
            review.setAvaliacao_conceitual_manual((String) (new ArrayList(resultado.values())).get(0));
        }
//        System.out.println(extrator.contagemPadroes(new ArrayList(pares.keySet()), new ArrayList(padroes.keySet()), features));

//        System.out.println(cc.calculaCorretude(texto));
    }
}
