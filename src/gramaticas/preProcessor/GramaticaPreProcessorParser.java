// Generated from C:\Users\User\Dropbox\Federal\MESTRADO\Projeto\workspace\ProjetoFinal\src\gramaticas\preProcessor\GramaticaPreProcessor.g4 by ANTLR 4.0
package gramaticas.preProcessor;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GramaticaPreProcessorParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WS=1, PALAVRA=2, INTS=3, SIMBOLOS=4, TERMINAL=5, VIRGULA=6, MODELO=7, 
		NAO=8, ART=9, ADJ=10, SUBS=11, VERB=12, PREP=13, PRON=14, CONJ=15, ADV=16, 
		NUM=17, FABRICANTE=18;
	public static final String[] tokenNames = {
		"<INVALID>", "WS", "PALAVRA", "INTS", "SIMBOLOS", "TERMINAL", "','", "MODELO", 
		"'não'", "ART", "ADJ", "SUBS", "VERB", "PREP", "PRON", "CONJ", "ADV", 
		"NUM", "FABRICANTE"
	};
	public static final int
		RULE_periodo = 0;
	public static final String[] ruleNames = {
		"periodo"
	};

	@Override
	public String getGrammarFileName() { return "GramaticaPreProcessor.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public GramaticaPreProcessorParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class PeriodoContext extends ParserRuleContext {
		public PeriodoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_periodo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaPreProcessorListener ) ((GramaticaPreProcessorListener)listener).enterPeriodo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaPreProcessorListener ) ((GramaticaPreProcessorListener)listener).exitPeriodo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaPreProcessorVisitor ) return ((GramaticaPreProcessorVisitor<? extends T>)visitor).visitPeriodo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PeriodoContext periodo() throws RecognitionException {
		PeriodoContext _localctx = new PeriodoContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_periodo);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(5);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=1 && _alt!=-1 ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(2);
					matchWildcard();
					}
					} 
				}
				setState(7);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\2\3\24\13\4\2\t\2\3\2\7\2\6\n\2\f\2\16\2\t\13\2\3\2\3\7\3\2\2\2\n\2\7"+
		"\3\2\2\2\4\6\13\2\2\2\5\4\3\2\2\2\6\t\3\2\2\2\7\b\3\2\2\2\7\5\3\2\2\2"+
		"\b\3\3\2\2\2\t\7\3\2\2\2\3\7";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}