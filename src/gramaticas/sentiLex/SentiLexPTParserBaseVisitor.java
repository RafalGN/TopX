// Generated from D:\Dropbox\Federal\MESTRADO\Projeto\workspace\ProjetoFinal\src\gramaticas\sentiLex\SentiLexPTParser.g4 by ANTLR 4.0
package gramaticas.sentiLex;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.ParserRuleContext;

public class SentiLexPTParserBaseVisitor<T> extends AbstractParseTreeVisitor<T> implements SentiLexPTParserVisitor<T> {
	@Override public T visitPalavraEPoS(SentiLexPTParserParser.PalavraEPoSContext ctx) { return visitChildren(ctx); }

	@Override public T visitLinha(SentiLexPTParserParser.LinhaContext ctx) { return visitChildren(ctx); }

	@Override public T visitPol(SentiLexPTParserParser.PolContext ctx) { return visitChildren(ctx); }

	@Override public T visitInit(SentiLexPTParserParser.InitContext ctx) { return visitChildren(ctx); }

	@Override public T visitBlocoPol(SentiLexPTParserParser.BlocoPolContext ctx) { return visitChildren(ctx); }

	@Override public T visitAnot(SentiLexPTParserParser.AnotContext ctx) { return visitChildren(ctx); }

	@Override public T visitAlvo(SentiLexPTParserParser.AlvoContext ctx) { return visitChildren(ctx); }

	@Override public T visitRev(SentiLexPTParserParser.RevContext ctx) { return visitChildren(ctx); }
}