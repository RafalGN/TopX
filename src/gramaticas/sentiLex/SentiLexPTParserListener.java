// Generated from D:\Dropbox\Federal\MESTRADO\Projeto\workspace\ProjetoFinal\src\gramaticas\sentiLex\SentiLexPTParser.g4 by ANTLR 4.0
package gramaticas.sentiLex;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.Token;

public interface SentiLexPTParserListener extends ParseTreeListener {
	void enterPalavraEPoS(SentiLexPTParserParser.PalavraEPoSContext ctx);
	void exitPalavraEPoS(SentiLexPTParserParser.PalavraEPoSContext ctx);

	void enterLinha(SentiLexPTParserParser.LinhaContext ctx);
	void exitLinha(SentiLexPTParserParser.LinhaContext ctx);

	void enterPol(SentiLexPTParserParser.PolContext ctx);
	void exitPol(SentiLexPTParserParser.PolContext ctx);

	void enterInit(SentiLexPTParserParser.InitContext ctx);
	void exitInit(SentiLexPTParserParser.InitContext ctx);

	void enterBlocoPol(SentiLexPTParserParser.BlocoPolContext ctx);
	void exitBlocoPol(SentiLexPTParserParser.BlocoPolContext ctx);

	void enterAnot(SentiLexPTParserParser.AnotContext ctx);
	void exitAnot(SentiLexPTParserParser.AnotContext ctx);

	void enterAlvo(SentiLexPTParserParser.AlvoContext ctx);
	void exitAlvo(SentiLexPTParserParser.AlvoContext ctx);

	void enterRev(SentiLexPTParserParser.RevContext ctx);
	void exitRev(SentiLexPTParserParser.RevContext ctx);
}