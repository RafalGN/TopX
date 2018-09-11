// Generated from C:\Users\User\Dropbox\Federal\MESTRADO\Projeto\workspace\ProjetoFinal\src\gramaticas\sentiLex\SentiLexPTParser.g4 by ANTLR 4.0
package gramaticas.sentiLex;

import gramaticas.sentiLex.SentiLexPTParserParser.LinhaContext;
import java.util.ArrayList;
import java.util.List;
import org.antlr.v4.runtime.tree.*;
import gramaticas.sentiLex.SentiLexPTParserParser.BlocoContext;

public class SentiLexPTParserInitialVisitor<ObjetoSentiLex> extends AbstractParseTreeVisitor<ObjetoSentiLex> implements SentiLexPTParserVisitor<ObjetoSentiLex> {

    List<ObjetoSentiLex> objetos = new ArrayList<>();

    @Override
    public ObjetoSentiLex visitInit(SentiLexPTParserParser.InitContext ctx) {
        for (LinhaContext lc : ctx.linha()) {
            objetos.add(visit(lc));
        }

        return null;
    }
    
    @Override
    public ObjetoSentiLex visitPalavraEPoS(SentiLexPTParserParser.PalavraEPoSContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public ObjetoSentiLex visitLinha(SentiLexPTParserParser.LinhaContext ctx) {
        for (BlocoContext bc : ctx.bloco()){
            
        }
        return visitChildren(ctx);
    }

    @Override
    public ObjetoSentiLex visitPol(SentiLexPTParserParser.PolContext ctx) {
        return visitChildren(ctx);
    }


    @Override
    public ObjetoSentiLex visitBlocoPol(SentiLexPTParserParser.BlocoPolContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public ObjetoSentiLex visitAnot(SentiLexPTParserParser.AnotContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public ObjetoSentiLex visitAlvo(SentiLexPTParserParser.AlvoContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public ObjetoSentiLex visitRev(SentiLexPTParserParser.RevContext ctx) {
        return visitChildren(ctx);
    }
}