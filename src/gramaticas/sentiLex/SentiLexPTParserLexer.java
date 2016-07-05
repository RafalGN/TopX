// Generated from D:\Dropbox\Federal\MESTRADO\Projeto\workspace\ProjetoFinal\src\gramaticas\sentiLex\SentiLexPTParser.g4 by ANTLR 4.0
package gramaticas.sentiLex;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SentiLexPTParserLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WS=1, POS=2, CLASSE=3, ALVO=4, HUM=5, TIPON=6, POL=7, ANOT=8, ANOTADOR=9, 
		REV=10, POLARIDADE=11, QL=12, PV=13, EQ=14, DP=15, PONTO=16, PALAVRA=17;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"WS", "'PoS'", "CLASSE", "'TG'", "'HUM'", "TIPON", "'POL'", "'ANOT'", 
		"ANOTADOR", "REV", "POLARIDADE", "'\n'", "';'", "'='", "':'", "'.'", "PALAVRA"
	};
	public static final String[] ruleNames = {
		"WS", "POS", "CLASSE", "ALVO", "HUM", "TIPON", "POL", "ANOT", "ANOTADOR", 
		"REV", "POLARIDADE", "QL", "PV", "EQ", "DP", "PONTO", "LetrasAcentuadas", 
		"PALAVRA"
	};


	public SentiLexPTParserLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "SentiLexPTParser.g4"; }

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
		"\2\4\23\u0080\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b"+
		"\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20"+
		"\t\20\4\21\t\21\4\22\t\22\4\23\t\23\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\48\n\4\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3"+
		"\7\3\7\3\7\3\7\5\7E\n\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\5\nW\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\5\13g\n\13\3\f\3\f\3\f\3\f\5\fm\n\f\3\r\3"+
		"\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\6\23}\n"+
		"\23\r\23\16\23~\2\24\3\3\2\5\4\1\7\5\1\t\6\1\13\7\1\r\b\1\17\t\1\21\n"+
		"\1\23\13\1\25\f\1\27\r\1\31\16\1\33\17\1\35\20\1\37\21\1!\22\1#\2\1%\23"+
		"\1\3\2\6\4\13\13\17\17\4PPXX\21//\u00c2\u00c5\u00c9\u00c9\u00cb\u00cc"+
		"\u00cf\u00cf\u00d5\u00d7\u00dc\u00dc\u00de\u00de\u00e2\u00e5\u00e9\u00e9"+
		"\u00eb\u00ec\u00ef\u00ef\u00f5\u00f7\u00fc\u00fc\u00fe\u00fe\4C\\c|\u0087"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2%\3\2"+
		"\2\2\3\'\3\2\2\2\5*\3\2\2\2\7\67\3\2\2\2\t9\3\2\2\2\13<\3\2\2\2\rD\3\2"+
		"\2\2\17F\3\2\2\2\21J\3\2\2\2\23V\3\2\2\2\25f\3\2\2\2\27l\3\2\2\2\31n\3"+
		"\2\2\2\33p\3\2\2\2\35r\3\2\2\2\37t\3\2\2\2!v\3\2\2\2#x\3\2\2\2%|\3\2\2"+
		"\2\'(\t\2\2\2()\b\2\2\2)\4\3\2\2\2*+\7R\2\2+,\7q\2\2,-\7U\2\2-\6\3\2\2"+
		"\2./\7C\2\2/\60\7f\2\2\608\7l\2\2\618\t\3\2\2\62\63\7K\2\2\63\64\7F\2"+
		"\2\64\65\7K\2\2\65\66\7Q\2\2\668\7O\2\2\67.\3\2\2\2\67\61\3\2\2\2\67\62"+
		"\3\2\2\28\b\3\2\2\29:\7V\2\2:;\7I\2\2;\n\3\2\2\2<=\7J\2\2=>\7W\2\2>?\7"+
		"O\2\2?\f\3\2\2\2@A\7P\2\2AE\7\62\2\2BC\7P\2\2CE\7\63\2\2D@\3\2\2\2DB\3"+
		"\2\2\2E\16\3\2\2\2FG\7R\2\2GH\7Q\2\2HI\7N\2\2I\20\3\2\2\2JK\7C\2\2KL\7"+
		"P\2\2LM\7Q\2\2MN\7V\2\2N\22\3\2\2\2OP\7O\2\2PQ\7C\2\2QW\7P\2\2RS\7L\2"+
		"\2ST\7C\2\2TU\7N\2\2UW\7E\2\2VO\3\2\2\2VR\3\2\2\2W\24\3\2\2\2XY\7T\2\2"+
		"YZ\7G\2\2Z[\7X\2\2[\\\7?\2\2\\]\7C\2\2]^\7O\2\2^g\7D\2\2_`\7T\2\2`a\7"+
		"G\2\2ab\7X\2\2bc\7<\2\2cd\7R\2\2de\7Q\2\2eg\7N\2\2fX\3\2\2\2f_\3\2\2\2"+
		"g\26\3\2\2\2hm\7\63\2\2ij\7/\2\2jm\7\63\2\2km\7\62\2\2lh\3\2\2\2li\3\2"+
		"\2\2lk\3\2\2\2m\30\3\2\2\2no\7\f\2\2o\32\3\2\2\2pq\7=\2\2q\34\3\2\2\2"+
		"rs\7?\2\2s\36\3\2\2\2tu\7<\2\2u \3\2\2\2vw\7\60\2\2w\"\3\2\2\2xy\t\4\2"+
		"\2y$\3\2\2\2z}\t\5\2\2{}\5#\22\2|z\3\2\2\2|{\3\2\2\2}~\3\2\2\2~|\3\2\2"+
		"\2~\177\3\2\2\2\177&\3\2\2\2\n\2\67DVfl|~";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}