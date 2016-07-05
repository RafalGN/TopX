package gramaticas.padroes;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//import banco.GravaReviews;
import core.preProcessamentos.TextPreProcessors;
import gramaticas.preProcessor.*;
import gramaticas.sintagmatica.GramaticaSintagmaticaInitialListener;
import gramaticas.testRig.TesteTestRig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import util.banco.GravaReviews;
import util.etiquetador.treeTagger.Etiquetador;

/**
 *
 * @author Rogerio
 */
public class PadroesTreeTaggerUtil {

    public static void main(String[] args) throws Exception {
        TextPreProcessors pre = new TextPreProcessors();

        HashMap<Integer, String> comentarios = new HashMap<Integer, String>(GravaReviews.selectComments());
        HashSet<String> todosADV = new HashSet<>();
        for (Integer id : comentarios.keySet()) {
//            id = 13;
            String text = pre.cleanDirtyByPOS(comentarios.get(id));

            ANTLRInputStream input = new ANTLRInputStream(text.toLowerCase());

            GramaticaPadroesLexer lexer = new GramaticaPadroesLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);

            tokens.fill();
            etiqueta(tokens);

            GramaticaPadroesParser parser = new GramaticaPadroesParser(tokens);
            ParseTree tree = parser.periodo();

            /* Teste de Rig*/
//        TesteTestRig tr = new TesteTestRig(new String[]{"GramaticaPadroes", "periodo", "-tree", "-gui", "-tokens"});
//        tr.executa(lexer, GramaticaPadroesParser.class, parser, text, "UTF-8");
        /* */

            ParseTreeWalker walker = new ParseTreeWalker();
            GramaticaPadroesInitialListener listen = new GramaticaPadroesInitialListener();
            walker.walk(listen, tree);

            HashMap<String, String> retorno = listen.pares;
            todosADV.addAll(listen.advs);
            System.out.println(todosADV.size());
//            GravaReviews.gravaParesNew(id, retorno);
        }
        for(String pa: todosADV){
            System.out.println(pa);
        }
//        System.out.println("foi");
    }

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
