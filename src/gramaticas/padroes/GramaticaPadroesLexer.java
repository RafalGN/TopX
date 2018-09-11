// Generated from C:\Users\User\Dropbox\Federal\MESTRADO\Projeto\workspace\ProjetoFinal\src\gramaticas\padroes\GramaticaPadroes.g4 by ANTLR 4.0
package gramaticas.padroes;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GramaticaPadroesLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WS=1, PALAVRA=2, INTS=3, SIMBOLOS=4, TERMINAL=5, VIRGULA=6, MODELO=7, 
		NAO=8;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"WS", "PALAVRA", "INTS", "SIMBOLOS", "TERMINAL", "','", "MODELO", "'não'"
	};
	public static final String[] ruleNames = {
		"WS", "LetrasAcentuadas", "PALAVRA", "INTS", "SIMBOLOS", "TERMINAL", "VIRGULA", 
		"MODELO", "NAO"
	};


	public GramaticaPadroesLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "GramaticaPadroes.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 0: WS_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: skip(); break;
		}
	}

	public static final String _serializedATN =
		"\2\4\n=\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4"+
		"\t\t\t\4\n\t\n\3\2\3\2\3\2\3\3\3\3\3\4\3\4\6\4\35\n\4\r\4\16\4\36\3\5"+
		"\6\5\"\n\5\r\5\16\5#\3\5\3\5\6\5(\n\5\r\5\16\5)\5\5,\n\5\3\6\3\6\3\7\3"+
		"\7\3\b\3\b\3\t\3\t\6\t\66\n\t\r\t\16\t\67\3\n\3\n\3\n\3\n\2\13\3\3\2\5"+
		"\2\1\7\4\1\t\5\1\13\6\1\r\7\1\17\b\1\21\t\1\23\n\1\3\2\b\5\13\f\17\17"+
		"\"\"\21//\u00c2\u00c5\u00c9\u00c9\u00cb\u00cc\u00cf\u00cf\u00d5\u00d7"+
		"\u00dc\u00dc\u00de\u00de\u00e2\u00e5\u00e9\u00e9\u00eb\u00ec\u00ef\u00ef"+
		"\u00f5\u00f7\u00fc\u00fc\u00fe\u00fe\4C\\c|\f$-\61\61<<>@BB]_ab}}\177"+
		"\177\u00b6\u00b6\6##\60\60==AA\4C\\c|A\2\3\3\2\2\2\2\7\3\2\2\2\2\t\3\2"+
		"\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\3"+
		"\25\3\2\2\2\5\30\3\2\2\2\7\34\3\2\2\2\t!\3\2\2\2\13-\3\2\2\2\r/\3\2\2"+
		"\2\17\61\3\2\2\2\21\65\3\2\2\2\239\3\2\2\2\25\26\t\2\2\2\26\27\b\2\2\2"+
		"\27\4\3\2\2\2\30\31\t\3\2\2\31\6\3\2\2\2\32\35\t\4\2\2\33\35\5\5\3\2\34"+
		"\32\3\2\2\2\34\33\3\2\2\2\35\36\3\2\2\2\36\34\3\2\2\2\36\37\3\2\2\2\37"+
		"\b\3\2\2\2 \"\4\62;\2! \3\2\2\2\"#\3\2\2\2#!\3\2\2\2#$\3\2\2\2$+\3\2\2"+
		"\2%\'\7\60\2\2&(\4\62;\2\'&\3\2\2\2()\3\2\2\2)\'\3\2\2\2)*\3\2\2\2*,\3"+
		"\2\2\2+%\3\2\2\2+,\3\2\2\2,\n\3\2\2\2-.\t\5\2\2.\f\3\2\2\2/\60\t\6\2\2"+
		"\60\16\3\2\2\2\61\62\7.\2\2\62\20\3\2\2\2\63\64\t\7\2\2\64\66\4\62;\2"+
		"\65\63\3\2\2\2\66\67\3\2\2\2\67\65\3\2\2\2\678\3\2\2\28\22\3\2\2\29:\7"+
		"p\2\2:;\7\u00e5\2\2;<\7q\2\2<\24\3\2\2\2\t\2\34\36#)+\67";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}