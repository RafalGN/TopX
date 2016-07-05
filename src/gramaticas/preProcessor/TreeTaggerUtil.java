package gramaticas.preProcessor;

import java.util.ArrayList;
import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import util.etiquetador.treeTagger.Etiquetador;

/**
 *
 * @author Rogerio
 */
public class TreeTaggerUtil {
    
    
    public static void etiqueta(CommonTokenStream tokens) {
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
    }
   }
