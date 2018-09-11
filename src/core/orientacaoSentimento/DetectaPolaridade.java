/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package core.orientacaoSentimento;

import core.model.Review;
import gramaticas.padroes.GramaticaPadroesLexer;
import gramaticas.preProcessor.GramaticaPreProcessorParser;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import util.banco.GravaCorpusBuscape;
import util.banco.GravaReviews;
import util.banco.GravaSentiLex;
import util.etiquetador.treeTagger.Etiquetador;
import util.preprocessamentos.LemmaTexto;

/**
 *
 * @author Rogerio
 */
public class DetectaPolaridade {

    private Map<String, Integer> lexico;
    private final LemmaTexto lemmatizador;
    private final HashMap<String, Double> modificadores;

    public DetectaPolaridade() {
        this.lexico = GravaSentiLex.selectLexico();
        System.out.println("Lexico Carregado");
        this.lemmatizador = new LemmaTexto();
        this.modificadores = carregaModificadores();
    }

//    public static void main(String[] args) {
//
//        /* Carregar Sentilex */
//        Map<String, Integer> lexico = GravaSentiLex.selectLexico();
//
////        executaAvalEspec(lexico);
//    }
    public void executaAvalLexicoNovo(List<Review> comments) {
        /*Carregar comentarios */
//        Map<Integer, String> comments = GravaReviews.selectComments();

        for (Review review : comments) {
            System.out.println(review.getId());
            try {
                double totaisPadroes = 0;
                for (String padrao : review.getPadroes()) {
                    double totalModificadores = 0;
                    double totalQualificadores = 0;

                    double polaridadePadrao;
//                    boolean inversor = false;

                    List<String> lemmas = lemmatizador.lemmaTxt(padrao);
                    for (String lem : lemmas) {
                        if (this.lexico.containsKey(lem.trim())) {
                            totalQualificadores = totalQualificadores + this.lexico.get(lem);
                        }
                        if (this.modificadores.containsKey(lem.trim())) {
                            totalModificadores = totalModificadores + this.modificadores.get(lem);
                        }
                    }
                    if (totalQualificadores > 0) {
                        polaridadePadrao = totalQualificadores + totalModificadores;
                    } else if (totalQualificadores < 0) {
                        polaridadePadrao = totalQualificadores - totalModificadores;
                    } else {
                        polaridadePadrao = 0;
                    }
                    
                    totaisPadroes += polaridadePadrao;
                }
                
                if (totaisPadroes > 0) {
                    review.setAvaliacaoAutomatica(1);
                } else if (totaisPadroes < 0) {
                    review.setAvaliacaoAutomatica(-1);
                } else {
                    review.setAvaliacaoAutomatica(0);
                }
                
            } catch (NullPointerException npe) {
                System.out.println("null");
                review.setAvaliacaoAutomatica(0);
            }
//            System.out.println(key + "\t" + polaridade);
        }

    }

    public void executaAvalLexico(List<Review> comments) {
        /*Carregar comentarios */
//        Map<Integer, String> comments = GravaReviews.selectComments();

        for (Review review : comments) {
            System.out.println(review.getId());
            try {
                /* Extrair Lemmas */
                List<String> lemmas = lemmaAllWords(review.getComentario().toLowerCase());

                /* Unir palavras */
                String comentario = "";
                for (String palavra : lemmas) {
                    comentario = comentario + palavra + " ";
                }

                /* Executa a verificação */
                int polaridade = 0;

                for (String lemmaLex : lexico.keySet()) {
                    if (comentario.contains(" " + lemmaLex + " ")) {
                        polaridade = polaridade + lexico.get(lemmaLex);
                    }
                }
                if (polaridade > 0) {
                    review.setAvaliacaoAutomatica(1);
                } else if (polaridade < 0) {
                    review.setAvaliacaoAutomatica(-1);
                } else {
                    review.setAvaliacaoAutomatica(0);
                }
            } catch (NullPointerException npe) {
                System.out.println("null");
                review.setAvaliacaoAutomatica(0);
            }
//            System.out.println(key + "\t" + polaridade);
        }

    }

//    public static void executaAvalEspec(Map<String, Integer> lexico) {
//
//        /*Carregar comentarios */
//        Map<Integer, String> positiveComments = GravaCorpusBuscape.selectPositivos();
//        Map<Integer, String> negativeComments = GravaCorpusBuscape.selectNegativos();
//        Map<Integer, String> neutralComments = GravaCorpusBuscape.selectPositivosNegativos();
//
//        List<Map<Integer, String>> listaPolaridadeComentarios = new ArrayList<Map<Integer, String>>();
//        listaPolaridadeComentarios.add(positiveComments);
//        listaPolaridadeComentarios.add(negativeComments);
//        listaPolaridadeComentarios.add(neutralComments);
//
//        for (Map<Integer, String> comments : listaPolaridadeComentarios) {
//            if(listaPolaridadeComentarios.indexOf(comments) == 0){
//                System.out.println("Positivos");
//            }else if(listaPolaridadeComentarios.indexOf(comments) == 1){
//                System.out.println("Negativos");
//            }else{
//                System.out.println("Neutros");
//            }
//            
//            for (Integer key : comments.keySet()) {
//                /* Extrair Lemmas */
//                List<String> lemmas = lemmaAllWords(comments.get(key).toLowerCase());
//
//                /* Unir palavras */
//                String comentario = "";
//                for (String palavra : lemmas) {
//                    comentario = comentario + palavra + " ";
//                }
//
////            System.out.println(comentario);
//
//                /* Executa a verificação */
//                int polaridade = 0;
//
//                for (String lemmaLex : lexico.keySet()) {
//                    if (comentario.contains(" " + lemmaLex + " ")) {
//                        polaridade = polaridade + lexico.get(lemmaLex);
//                    }
//                }
//                System.out.println(key + "\t" + polaridade);
//            }
//        }
//    }
    public static void executaAvalBuscape(Map<String, Integer> lexico) {
        /*Carregar comentarios */
        Map<Integer, String> comments = GravaReviews.selectComments();

        for (Integer key : comments.keySet()) {
            /* Extrair Lemmas */
            List<String> lemmas = lemmaAllWords(comments.get(key).toLowerCase());

            /* Unir palavras */
            String comentario = "";
            for (String palavra : lemmas) {
                comentario = comentario + palavra + " ";
            }

//            System.out.println(comentario);

            /* Executa a verificação */
            int polaridade = 0;

            for (String lemmaLex : lexico.keySet()) {
                if (comentario.contains(" " + lemmaLex + " ")) {
                    polaridade = polaridade + lexico.get(lemmaLex);
                }
            }
            System.out.println(key + "\t" + polaridade);
        }
    }

    /**
     * TODO: Depois acrescentar a escolha de classes, se quiser
     *
     * @param text
     * @return
     */
    public static List<String> lemmaAllWords(String text) {
        List<String> lemmas = new ArrayList<String>();
        ANTLRInputStream input = new ANTLRInputStream(text.toLowerCase());

        GramaticaPadroesLexer lexer = new GramaticaPadroesLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        tokens.fill();

        lemmas = etiqueta(tokens);

        return lemmas;
    }

    private HashMap<String, Double> carregaModificadores() {
        HashMap<String, Double> mapRetorno = new HashMap<>();

        try {
            Scanner sc = new Scanner(new File("./recursos/baseAdverbios.txt"));

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
//                System.out.println(line);
                String[] splitedLine = line.split("\t");
                mapRetorno.put(splitedLine[0], Double.parseDouble(splitedLine[1]));
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DetectaPolaridade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mapRetorno;
    }

    public static List<String> etiqueta(CommonTokenStream tokens) {

        ArrayList<String> lemmas = new ArrayList<String>();
        //Listagem dos tokens e adição a uma lista que permita ser enviada
        // para o etiquetador
        ArrayList<String> listTokensString = new ArrayList<String>();
        for (Token token : tokens.getTokens()) {
            listTokensString.add(token.getText());
        }

        //Instanciação do Etiquetador
        Etiquetador tagger = new Etiquetador(listTokensString);
        //Chamada do método de Etiquetagem
        tagger.etiquetar();

        //Detecção e atribuição das etiquetas aos seus respectivos tokens
        for (int i = 0; i < tokens.getTokens().size() - 1; i++) {
            switch (tagger.getEtiquetas().get(i).charAt(0)) {
                case 'V':
                    ((CommonToken) tokens.getTokens().get(i)).setType(GramaticaPreProcessorParser.VERB);
                    break;
                case 'N':
                    ((CommonToken) tokens.getTokens().get(i)).setType(GramaticaPreProcessorParser.SUBS);
                    break;
                case 'D':
                    ((CommonToken) tokens.getTokens().get(i)).setType(GramaticaPreProcessorParser.ART);
                    break;
                case 'P':
                    ((CommonToken) tokens.getTokens().get(i)).setType(GramaticaPreProcessorParser.PRON);
                    break;
                case 'S':
                    ((CommonToken) tokens.getTokens().get(i)).setType(GramaticaPreProcessorParser.PREP);
                    break;
                case 'A':
                    ((CommonToken) tokens.getTokens().get(i)).setType(GramaticaPreProcessorParser.ADJ);
                    break;
                case 'Z':
                    ((CommonToken) tokens.getTokens().get(i)).setType(GramaticaPreProcessorParser.NUM);
                    break;
                case 'C':
                    ((CommonToken) tokens.getTokens().get(i)).setType(GramaticaPreProcessorParser.CONJ);
                    break;
                case 'F':
                    if (tagger.getEtiquetas().get(i).charAt(1) == 'c') {
                        ((CommonToken) tokens.getTokens().get(i)).setType(GramaticaPreProcessorParser.VIRGULA);
                    } else if (tagger.getEtiquetas().get(i).charAt(1) == 'a') {
                        ((CommonToken) tokens.getTokens().get(i)).setType(GramaticaPreProcessorParser.TERMINAL);
                    } else if (tagger.getEtiquetas().get(i).charAt(1) == 'p') {
                        ((CommonToken) tokens.getTokens().get(i)).setType(GramaticaPreProcessorParser.TERMINAL);
                    } else if (tagger.getEtiquetas().get(i).charAt(1) == 'i') {
                        ((CommonToken) tokens.getTokens().get(i)).setType(GramaticaPreProcessorParser.TERMINAL);
                    } else if (tagger.getEtiquetas().get(i).charAt(1) == 'x') {
                        ((CommonToken) tokens.getTokens().get(i)).setType(GramaticaPreProcessorParser.TERMINAL);
                    } else {
                        ((CommonToken) tokens.getTokens().get(i)).setType(GramaticaPreProcessorParser.SIMBOLOS);
                    }
                    break;
                case 'R':
                    ((CommonToken) tokens.getTokens().get(i)).setType(GramaticaPreProcessorParser.ADV);
                    break;
            }
        }
        for (String tok : listTokensString) {
            lemmas.add(tagger.getLemmas().get(tok));
        }

        return lemmas;
    }
}
