// Generated from C:\Users\User\Dropbox\Federal\MESTRADO\Projeto\workspace\ProjetoFinal\src\gramaticas\padroes\GramaticaPadroes.g4 by ANTLR 4.0
package gramaticas.padroes;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GramaticaPadroesParser extends Parser {
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
		RULE_periodo = 0, RULE_padroes = 1, RULE_padrao1 = 2, RULE_padrao2 = 3, 
		RULE_padrao3 = 4, RULE_padrao4 = 5, RULE_padrao5 = 6, RULE_padrao6 = 7, 
		RULE_produtoComposto = 8;
	public static final String[] ruleNames = {
		"periodo", "padroes", "padrao1", "padrao2", "padrao3", "padrao4", "padrao5", 
		"padrao6", "produtoComposto"
	};

	@Override
	public String getGrammarFileName() { return "GramaticaPadroes.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public GramaticaPadroesParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class PeriodoContext extends ParserRuleContext {
		public PadroesContext padroes(int i) {
			return getRuleContext(PadroesContext.class,i);
		}
		public List<PadroesContext> padroes() {
			return getRuleContexts(PadroesContext.class);
		}
		public PeriodoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_periodo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaPadroesListener ) ((GramaticaPadroesListener)listener).enterPeriodo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaPadroesListener ) ((GramaticaPadroesListener)listener).exitPeriodo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaPadroesVisitor ) return ((GramaticaPadroesVisitor<? extends T>)visitor).visitPeriodo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PeriodoContext periodo() throws RecognitionException {
		PeriodoContext _localctx = new PeriodoContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_periodo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(21);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << WS) | (1L << PALAVRA) | (1L << INTS) | (1L << SIMBOLOS) | (1L << TERMINAL) | (1L << VIRGULA) | (1L << MODELO) | (1L << NAO) | (1L << ART) | (1L << ADJ) | (1L << SUBS) | (1L << VERB) | (1L << PREP) | (1L << PRON) | (1L << CONJ) | (1L << ADV) | (1L << NUM) | (1L << FABRICANTE))) != 0)) {
				{
				{
				setState(18); padroes();
				}
				}
				setState(23);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class PadroesContext extends ParserRuleContext {
		public Padrao3Context padrao3() {
			return getRuleContext(Padrao3Context.class,0);
		}
		public Padrao4Context padrao4() {
			return getRuleContext(Padrao4Context.class,0);
		}
		public Padrao1Context padrao1() {
			return getRuleContext(Padrao1Context.class,0);
		}
		public Padrao2Context padrao2() {
			return getRuleContext(Padrao2Context.class,0);
		}
		public Padrao5Context padrao5() {
			return getRuleContext(Padrao5Context.class,0);
		}
		public Padrao6Context padrao6() {
			return getRuleContext(Padrao6Context.class,0);
		}
		public PadroesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_padroes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaPadroesListener ) ((GramaticaPadroesListener)listener).enterPadroes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaPadroesListener ) ((GramaticaPadroesListener)listener).exitPadroes(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaPadroesVisitor ) return ((GramaticaPadroesVisitor<? extends T>)visitor).visitPadroes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PadroesContext padroes() throws RecognitionException {
		PadroesContext _localctx = new PadroesContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_padroes);
		try {
			setState(31);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(24); padrao1();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(25); padrao2();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(26); padrao3();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(27); padrao4();
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(28); padrao5();
				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(29); padrao6();
				}
				break;

			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(30);
				matchWildcard();
				}
				break;
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

	public static class Padrao1Context extends ParserRuleContext {
		public ProdutoCompostoContext produtoComposto() {
			return getRuleContext(ProdutoCompostoContext.class,0);
		}
		public TerminalNode ADJ() { return getToken(GramaticaPadroesParser.ADJ, 0); }
		public Padrao1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_padrao1; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaPadroesListener ) ((GramaticaPadroesListener)listener).enterPadrao1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaPadroesListener ) ((GramaticaPadroesListener)listener).exitPadrao1(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaPadroesVisitor ) return ((GramaticaPadroesVisitor<? extends T>)visitor).visitPadrao1(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Padrao1Context padrao1() throws RecognitionException {
		Padrao1Context _localctx = new Padrao1Context(_ctx, getState());
		enterRule(_localctx, 4, RULE_padrao1);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(33); match(ADJ);
			setState(34); produtoComposto();
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

	public static class Padrao2Context extends ParserRuleContext {
		public ProdutoCompostoContext produtoComposto() {
			return getRuleContext(ProdutoCompostoContext.class,0);
		}
		public TerminalNode ADV(int i) {
			return getToken(GramaticaPadroesParser.ADV, i);
		}
		public TerminalNode ADJ() { return getToken(GramaticaPadroesParser.ADJ, 0); }
		public List<TerminalNode> ADV() { return getTokens(GramaticaPadroesParser.ADV); }
		public Padrao2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_padrao2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaPadroesListener ) ((GramaticaPadroesListener)listener).enterPadrao2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaPadroesListener ) ((GramaticaPadroesListener)listener).exitPadrao2(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaPadroesVisitor ) return ((GramaticaPadroesVisitor<? extends T>)visitor).visitPadrao2(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Padrao2Context padrao2() throws RecognitionException {
		Padrao2Context _localctx = new Padrao2Context(_ctx, getState());
		enterRule(_localctx, 6, RULE_padrao2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36); match(ADV);
			setState(38);
			_la = _input.LA(1);
			if (_la==ADV) {
				{
				setState(37); match(ADV);
				}
			}

			setState(40); match(ADJ);
			setState(42);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(41); produtoComposto();
				}
				break;
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

	public static class Padrao3Context extends ParserRuleContext {
		public ProdutoCompostoContext produtoComposto() {
			return getRuleContext(ProdutoCompostoContext.class,0);
		}
		public TerminalNode ADV(int i) {
			return getToken(GramaticaPadroesParser.ADV, i);
		}
		public TerminalNode ADJ() { return getToken(GramaticaPadroesParser.ADJ, 0); }
		public List<TerminalNode> ADV() { return getTokens(GramaticaPadroesParser.ADV); }
		public Padrao3Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_padrao3; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaPadroesListener ) ((GramaticaPadroesListener)listener).enterPadrao3(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaPadroesListener ) ((GramaticaPadroesListener)listener).exitPadrao3(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaPadroesVisitor ) return ((GramaticaPadroesVisitor<? extends T>)visitor).visitPadrao3(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Padrao3Context padrao3() throws RecognitionException {
		Padrao3Context _localctx = new Padrao3Context(_ctx, getState());
		enterRule(_localctx, 8, RULE_padrao3);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44); produtoComposto();
			setState(45); match(ADJ);
			setState(46); match(ADV);
			setState(48);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(47); match(ADV);
				}
				break;
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

	public static class Padrao4Context extends ParserRuleContext {
		public TerminalNode ADJ(int i) {
			return getToken(GramaticaPadroesParser.ADJ, i);
		}
		public ProdutoCompostoContext produtoComposto() {
			return getRuleContext(ProdutoCompostoContext.class,0);
		}
		public List<TerminalNode> ADJ() { return getTokens(GramaticaPadroesParser.ADJ); }
		public TerminalNode ADV() { return getToken(GramaticaPadroesParser.ADV, 0); }
		public Padrao4Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_padrao4; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaPadroesListener ) ((GramaticaPadroesListener)listener).enterPadrao4(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaPadroesListener ) ((GramaticaPadroesListener)listener).exitPadrao4(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaPadroesVisitor ) return ((GramaticaPadroesVisitor<? extends T>)visitor).visitPadrao4(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Padrao4Context padrao4() throws RecognitionException {
		Padrao4Context _localctx = new Padrao4Context(_ctx, getState());
		enterRule(_localctx, 10, RULE_padrao4);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(50); produtoComposto();
			setState(52);
			_la = _input.LA(1);
			if (_la==ADV) {
				{
				setState(51); match(ADV);
				}
			}

			setState(55); 
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(54); match(ADJ);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(57); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			} while ( _alt!=2 && _alt!=-1 );
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

	public static class Padrao5Context extends ParserRuleContext {
		public TerminalNode VERB() { return getToken(GramaticaPadroesParser.VERB, 0); }
		public TerminalNode ADV() { return getToken(GramaticaPadroesParser.ADV, 0); }
		public Padrao5Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_padrao5; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaPadroesListener ) ((GramaticaPadroesListener)listener).enterPadrao5(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaPadroesListener ) ((GramaticaPadroesListener)listener).exitPadrao5(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaPadroesVisitor ) return ((GramaticaPadroesVisitor<? extends T>)visitor).visitPadrao5(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Padrao5Context padrao5() throws RecognitionException {
		Padrao5Context _localctx = new Padrao5Context(_ctx, getState());
		enterRule(_localctx, 12, RULE_padrao5);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59); match(ADV);
			setState(60); match(VERB);
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

	public static class Padrao6Context extends ParserRuleContext {
		public TerminalNode VERB() { return getToken(GramaticaPadroesParser.VERB, 0); }
		public TerminalNode ADV() { return getToken(GramaticaPadroesParser.ADV, 0); }
		public Padrao6Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_padrao6; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaPadroesListener ) ((GramaticaPadroesListener)listener).enterPadrao6(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaPadroesListener ) ((GramaticaPadroesListener)listener).exitPadrao6(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaPadroesVisitor ) return ((GramaticaPadroesVisitor<? extends T>)visitor).visitPadrao6(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Padrao6Context padrao6() throws RecognitionException {
		Padrao6Context _localctx = new Padrao6Context(_ctx, getState());
		enterRule(_localctx, 14, RULE_padrao6);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62); match(VERB);
			setState(63); match(ADV);
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

	public static class ProdutoCompostoContext extends ParserRuleContext {
		public String produto;
		public List<TerminalNode> PREP() { return getTokens(GramaticaPadroesParser.PREP); }
		public TerminalNode SUBS(int i) {
			return getToken(GramaticaPadroesParser.SUBS, i);
		}
		public List<TerminalNode> SUBS() { return getTokens(GramaticaPadroesParser.SUBS); }
		public TerminalNode PREP(int i) {
			return getToken(GramaticaPadroesParser.PREP, i);
		}
		public ProdutoCompostoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_produtoComposto; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaPadroesListener ) ((GramaticaPadroesListener)listener).enterProdutoComposto(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaPadroesListener ) ((GramaticaPadroesListener)listener).exitProdutoComposto(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaPadroesVisitor ) return ((GramaticaPadroesVisitor<? extends T>)visitor).visitProdutoComposto(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProdutoCompostoContext produtoComposto() throws RecognitionException {
		ProdutoCompostoContext _localctx = new ProdutoCompostoContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_produtoComposto);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(65); match(SUBS);
			setState(72);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(67);
					_la = _input.LA(1);
					if (_la==PREP) {
						{
						setState(66); match(PREP);
						}
					}

					setState(69); match(SUBS);
					}
					} 
				}
				setState(74);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
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
		"\2\3\24N\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t"+
		"\t\4\n\t\n\3\2\7\2\26\n\2\f\2\16\2\31\13\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\5\3\"\n\3\3\4\3\4\3\4\3\5\3\5\5\5)\n\5\3\5\3\5\5\5-\n\5\3\6\3\6\3\6\3"+
		"\6\5\6\63\n\6\3\7\3\7\5\7\67\n\7\3\7\6\7:\n\7\r\7\16\7;\3\b\3\b\3\b\3"+
		"\t\3\t\3\t\3\n\3\n\5\nF\n\n\3\n\7\nI\n\n\f\n\16\nL\13\n\3\n\2\13\2\4\6"+
		"\b\n\f\16\20\22\2\2R\2\27\3\2\2\2\4!\3\2\2\2\6#\3\2\2\2\b&\3\2\2\2\n."+
		"\3\2\2\2\f\64\3\2\2\2\16=\3\2\2\2\20@\3\2\2\2\22C\3\2\2\2\24\26\5\4\3"+
		"\2\25\24\3\2\2\2\26\31\3\2\2\2\27\25\3\2\2\2\27\30\3\2\2\2\30\3\3\2\2"+
		"\2\31\27\3\2\2\2\32\"\5\6\4\2\33\"\5\b\5\2\34\"\5\n\6\2\35\"\5\f\7\2\36"+
		"\"\5\16\b\2\37\"\5\20\t\2 \"\13\2\2\2!\32\3\2\2\2!\33\3\2\2\2!\34\3\2"+
		"\2\2!\35\3\2\2\2!\36\3\2\2\2!\37\3\2\2\2! \3\2\2\2\"\5\3\2\2\2#$\7\f\2"+
		"\2$%\5\22\n\2%\7\3\2\2\2&(\7\22\2\2\')\7\22\2\2(\'\3\2\2\2()\3\2\2\2)"+
		"*\3\2\2\2*,\7\f\2\2+-\5\22\n\2,+\3\2\2\2,-\3\2\2\2-\t\3\2\2\2./\5\22\n"+
		"\2/\60\7\f\2\2\60\62\7\22\2\2\61\63\7\22\2\2\62\61\3\2\2\2\62\63\3\2\2"+
		"\2\63\13\3\2\2\2\64\66\5\22\n\2\65\67\7\22\2\2\66\65\3\2\2\2\66\67\3\2"+
		"\2\2\679\3\2\2\28:\7\f\2\298\3\2\2\2:;\3\2\2\2;9\3\2\2\2;<\3\2\2\2<\r"+
		"\3\2\2\2=>\7\22\2\2>?\7\16\2\2?\17\3\2\2\2@A\7\16\2\2AB\7\22\2\2B\21\3"+
		"\2\2\2CJ\7\r\2\2DF\7\17\2\2ED\3\2\2\2EF\3\2\2\2FG\3\2\2\2GI\7\r\2\2HE"+
		"\3\2\2\2IL\3\2\2\2JH\3\2\2\2JK\3\2\2\2K\23\3\2\2\2LJ\3\2\2\2\13\27!(,"+
		"\62\66;EJ";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}