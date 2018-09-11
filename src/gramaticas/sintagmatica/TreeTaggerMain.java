package gramaticas.sintagmatica;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//import banco.GravaReviews;
import gramaticas.testRig.TesteTestRig;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
public class TreeTaggerMain {
    
    public static void main(String args[]) throws IOException, Exception {
//        ANTLRInputStream input = new ANTLRInputStream(new BufferedReader(new InputStreamReader(new FileInputStream("src\\sentiwords\\sintagmas\\test.txt"), "UTF-8")));
        
        HashMap<Integer, String> comentarios = retornaComentarios();
        
//        HashMap<Integer, String> comentarios = new HashMap<>();
//        comentarios.put(1, "Eu tenho um galaxy S3.");
        
        for (Integer id : comentarios.keySet()) {
            String texto = "Os telefones celulares foram evoluindo de uma forma muito rápida. Cada vez mais com funções,que ajudam no nosso dia-a-dia. Tudo que nós precisarmos está a apenas um clique,pagar contas,registrar momentos,";
//            ANTLRInputStream input = new ANTLRInputStream(comentarios.get(id).toLowerCase());
            ANTLRInputStream input = new ANTLRInputStream(texto.toLowerCase());
            
            GramaticaSintagmaticaLexer lexer = new GramaticaSintagmaticaLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            GramaticaSintagmaticaParser parser = new GramaticaSintagmaticaParser(tokens);
            
            System.out.println(id+": ");
            
            tokens.fill();
            etiqueta(tokens);
            ParseTree tree = parser.periodo();
//            System.out.println(tree.toStringTree(parser));
            
            /* Teste de Rig*/
            TesteTestRig tr = new TesteTestRig(new String[]{"GramaticaSintagmatica", "periodo", "-tree", "-gui", "-tokens"});
            tr.executa(lexer, GramaticaSintagmaticaParser.class, parser, texto.toLowerCase(), "UTF-8");
            /* */

            ParseTreeWalker walker = new ParseTreeWalker();
            GramaticaSintagmaticaInitialListener listen = new GramaticaSintagmaticaInitialListener();
            walker.walk(listen, tree);
            System.out.println("");
//            GravaReviews.gravaPares(id, listen.getPares());
//            System.out.println(tree.getChildCount());
//            geraOracoes(tree);
//            GravaReviews.gravaOracoes(id, geraOracoes(tree));

//            System.out.println(listen.rewriter.getText());
//            FileOutputStream fos = new FileOutputStream(new File(file.getAbsolutePath()+".html"));
//            OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
//            osw.write(listen.rewriter.getText());
//            fos.close();
//            osw.close();

        }
    }
    
    public static void etiqueta(CommonTokenStream tokens) {
        //Listagem dos tokens e adição a uma lista que permita ser enviada
        // para o etiquetador
        ArrayList<String> listTokensString = new ArrayList<String>();
        for (Token token : tokens.getTokens()) {
            listTokensString.add(token.getText().trim());
        }

        //Instanciação do Etiquetador
        Etiquetador tagger = new Etiquetador(listTokensString);
        //Chamada do método de Etiquetagem
        tagger.etiquetar();

        //Detecção e atribuição das etiquetas aos seus respectivos tokens
        for (int i = 0; i < tokens.getTokens().size() - 1; i++) {
            switch (tagger.getEtiquetas().get(i).charAt(0)) {
                case 'V':
                    ((CommonToken) tokens.getTokens().get(i)).setType(GramaticaSintagmaticaParser.VERB);
                    break;
                case 'N':
                    ((CommonToken) tokens.getTokens().get(i)).setType(GramaticaSintagmaticaParser.SUBS);
                    break;
                case 'D':
                    ((CommonToken) tokens.getTokens().get(i)).setType(GramaticaSintagmaticaParser.ART);
                    break;
                case 'P':
                    ((CommonToken) tokens.getTokens().get(i)).setType(GramaticaSintagmaticaParser.PRON);
                    break;
                case 'S':
                    ((CommonToken) tokens.getTokens().get(i)).setType(GramaticaSintagmaticaParser.PREP);
                    break;
                case 'A':
                    ((CommonToken) tokens.getTokens().get(i)).setType(GramaticaSintagmaticaParser.ADJ);
                    break;
                case 'Z':
                    ((CommonToken) tokens.getTokens().get(i)).setType(GramaticaSintagmaticaParser.NUM);
                    break;
                case 'C':
                    ((CommonToken) tokens.getTokens().get(i)).setType(GramaticaSintagmaticaParser.CONJ);
                    break;
                case 'F':
                    if (tagger.getEtiquetas().get(i).charAt(1) == 'c') {
                        ((CommonToken) tokens.getTokens().get(i)).setType(GramaticaSintagmaticaParser.VIRGULA);
                    } else if (tagger.getEtiquetas().get(i).charAt(1) == 'a') {
                        ((CommonToken) tokens.getTokens().get(i)).setType(GramaticaSintagmaticaParser.TERMINAL);
                    } else if (tagger.getEtiquetas().get(i).charAt(1) == 'p') {
                        ((CommonToken) tokens.getTokens().get(i)).setType(GramaticaSintagmaticaParser.TERMINAL);
                    } else if (tagger.getEtiquetas().get(i).charAt(1) == 'i') {
                        ((CommonToken) tokens.getTokens().get(i)).setType(GramaticaSintagmaticaParser.TERMINAL);
                    } else if (tagger.getEtiquetas().get(i).charAt(1) == 'x') {
                        ((CommonToken) tokens.getTokens().get(i)).setType(GramaticaSintagmaticaParser.TERMINAL);
                    } else {
                        ((CommonToken) tokens.getTokens().get(i)).setType(GramaticaSintagmaticaParser.SIMBOLOS);
                    }
                    break;
                case 'R':
                    ((CommonToken) tokens.getTokens().get(i)).setType(GramaticaSintagmaticaParser.ADV);
                    break;
            }
//            System.out.println(tokens.getTokens().get(i).getText() + " : " + tokens.getTokens().get(i).getType());
        }
    }

    /**
     * Retorna os comentários
     *
     * @return
     */
    private static HashMap<Integer, String> retornaComentarios() {
        HashMap<Integer, String> retorno = new HashMap<Integer, String>(GravaReviews.selectComments());
        return retorno;
    }

    /**
     *
     * @param pt
     * @return
     */
    public static List<String> geraOracoes(ParseTree pt) {
        ParseTree no = null;
        List<String> oracoes = new ArrayList<String>();
        for (int i = 0; i < pt.getChildCount(); i++) {
            no = pt.getChild(i);
            
            if (no.getChildCount() > 0) {
                oracoes.add(teste(no));
                System.out.println(oracoes.get(oracoes.size() - 1));
            }
        }
        return oracoes;
    }

    /**
     *
     * @param pt
     * @return
     */
    private static String teste(ParseTree pt) {
        if (pt == null) {
            return "";
        } else if (pt.getChildCount() <= 0) {
            String valor = pt.getText().trim();
            if (!valor.isEmpty()) {
                return pt.getText() + " ";
            } else {
                return "";
            }
        } else {
            String retorno = "";
            for (int i = 0; i <= pt.getChildCount(); i++) {
                retorno = retorno + teste(pt.getChild(i));
            }
            return retorno;
        }
    }
}
