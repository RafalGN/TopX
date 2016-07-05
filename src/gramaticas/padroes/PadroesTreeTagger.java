/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gramaticas.padroes;

import core.preProcessamentos.TextPreProcessors;
import static gramaticas.padroes.PadroesTreeTaggerUtil.etiqueta;
import java.util.HashMap;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

/**
 *
 * @author User
 */
public class PadroesTreeTagger {

    /**
     * 
     * @param texto
     * @return retorna um HashMap<String,String> no qual a primeira String é o 
     * tipo do padrão (padrao1, padrao2,...). A Segunda String é a expressão extraída.
     */
    public HashMap<String, String> extraiPadroes(String texto) {
        TextPreProcessors pre = new TextPreProcessors();

        String text = pre.cleanDirtyByPOS(texto);

        ANTLRInputStream input = new ANTLRInputStream(text.toLowerCase());

        GramaticaPadroesLexer lexer = new GramaticaPadroesLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        tokens.fill();
        etiqueta(tokens);

        GramaticaPadroesParser parser = new GramaticaPadroesParser(tokens);
        ParseTree tree = parser.periodo();

        ParseTreeWalker walker = new ParseTreeWalker();
        GramaticaPadroesInitialListener listen = new GramaticaPadroesInitialListener();
        walker.walk(listen, tree);

        HashMap<String, String> retorno = listen.pares;

        return retorno;
    }
}
