// Generated from D:\Dropbox\Federal\MESTRADO\Projeto\workspace\ProjetoFinal\src\gramaticas\sentiLex\SentiLexPTParser.g4 by ANTLR 4.0
package gramaticas.sentiLex;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.Token;

public interface SentiLexPTParserVisitor<T> extends ParseTreeVisitor<T> {
	T visitPalavraEPoS(SentiLexPTParserParser.PalavraEPoSContext ctx);

	T visitLinha(SentiLexPTParserParser.LinhaContext ctx);

	T visitPol(SentiLexPTParserParser.PolContext ctx);

	T visitInit(SentiLexPTParserParser.InitContext ctx);

	T visitBlocoPol(SentiLexPTParserParser.BlocoPolContext ctx);

	T visitAnot(SentiLexPTParserParser.AnotContext ctx);

	T visitAlvo(SentiLexPTParserParser.AlvoContext ctx);

	T visitRev(SentiLexPTParserParser.RevContext ctx);
}