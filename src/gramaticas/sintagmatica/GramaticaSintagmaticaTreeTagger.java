/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gramaticas.sintagmatica;

import static gramaticas.sintagmatica.TreeTaggerMain.etiqueta;
import java.util.HashMap;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

/**
 *
 * @author User
 */
public class GramaticaSintagmaticaTreeTagger {

    /**
     *
     * @param texto
     * @return HashMap<String,String> no qual a primeira string é 
     * a característica e a segunda é o qualificador
     */
    public HashMap<String, String> extraiPares(String texto) {

        ANTLRInputStream input = new ANTLRInputStream(texto.toLowerCase());

        GramaticaSintagmaticaLexer lexer = new GramaticaSintagmaticaLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        GramaticaSintagmaticaParser parser = new GramaticaSintagmaticaParser(tokens);

        tokens.fill();
        etiqueta(tokens);
        ParseTree tree = parser.periodo();

        ParseTreeWalker walker = new ParseTreeWalker();
        GramaticaSintagmaticaInitialListener listen = new GramaticaSintagmaticaInitialListener();
        walker.walk(listen, tree);

        return listen.getPares();
    }
}
