/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package core.preProcessamentos;

import gramaticas.preProcessor.GramaticaPreProcessorLexer;
import gramaticas.preProcessor.GramaticaPreProcessorParser;
import gramaticas.preProcessor.TreeTaggerUtil;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import util.banco.GravaReviews;

/**
 * Classe responsável por agrupar todos os métodos relacionados ao
 * pré-processamento textual sobre o sistema.
 *
 * @author Rogério Figueredo
 */
public class TextPreProcessors {

    public static void main(String[] args) {
        TextPreProcessors pre = new TextPreProcessors();

        System.out.println(pre.cleanDirtyByPOS(GravaReviews.selectComments().get(45)));
    }

    /**
     * Limpar texto com base na retirada de algumas classes gramaticais
     *
     * @param text
     * @return texto sem pontuação (exceto vírgulas e simbolos finais) e sem as
     * classes (conjunções, número, pronomes)
     */
    public String cleanDirtyByPOS(String text) {
        ANTLRInputStream input = new ANTLRInputStream(text.toLowerCase());

        GramaticaPreProcessorLexer lexer = new GramaticaPreProcessorLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        GramaticaPreProcessorParser parser = new GramaticaPreProcessorParser(tokens);

        tokens.fill();
        TreeTaggerUtil.etiqueta(tokens);
        ParseTree tree = parser.periodo();

        List<Token> selecionados = tokens.getTokens(0, (tokens.size() - 1), new HashSet(Arrays.asList(13, 11, 12, 16, 8, 1, 10, 9, 6, 5)));

        String retorno = "";

        try {
            for (Token valor : selecionados) {
                retorno += valor.getText() + " ";
            }
        } catch (NullPointerException npe) {
            System.out.println(text);
        }

        return retorno.trim();
    }
}
