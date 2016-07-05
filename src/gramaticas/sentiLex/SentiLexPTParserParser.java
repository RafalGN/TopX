// Generated from D:\Dropbox\Federal\MESTRADO\Projeto\workspace\ProjetoFinal\src\gramaticas\sentiLex\SentiLexPTParser.g4 by ANTLR 4.0
package gramaticas.sentiLex;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SentiLexPTParserParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WS=1, POS=2, CLASSE=3, ALVO=4, HUM=5, TIPON=6, POL=7, ANOT=8, ANOTADOR=9, 
		REV=10, POLARIDADE=11, QL=12, PV=13, EQ=14, DP=15, PONTO=16, PALAVRA=17;
	public static final String[] tokenNames = {
		"<INVALID>", "WS", "'PoS'", "CLASSE", "'TG'", "'HUM'", "TIPON", "'POL'", 
		"'ANOT'", "ANOTADOR", "REV", "POLARIDADE", "'\n'", "';'", "'='", "':'", 
		"'.'", "PALAVRA"
	};
	public static final int
		RULE_init = 0, RULE_linha = 1, RULE_bloco = 2, RULE_blocoPol = 3;
	public static final String[] ruleNames = {
		"init", "linha", "bloco", "blocoPol"
	};

	@Override
	public String getGrammarFileName() { return "SentiLexPTParser.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public SentiLexPTParserParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class InitContext extends ParserRuleContext {
		public TerminalNode QL(int i) {
			return getToken(SentiLexPTParserParser.QL, i);
		}
		public List<LinhaContext> linha() {
			return getRuleContexts(LinhaContext.class);
		}
		public List<TerminalNode> QL() { return getTokens(SentiLexPTParserParser.QL); }
		public LinhaContext linha(int i) {
			return getRuleContext(LinhaContext.class,i);
		}
		public InitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_init; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SentiLexPTParserListener ) ((SentiLexPTParserListener)listener).enterInit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SentiLexPTParserListener ) ((SentiLexPTParserListener)listener).exitInit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SentiLexPTParserVisitor ) return ((SentiLexPTParserVisitor<? extends T>)visitor).visitInit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitContext init() throws RecognitionException {
		InitContext _localctx = new InitContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_init);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(11); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(8); linha();
				setState(9); match(QL);
				}
				}
				setState(13); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ALVO) | (1L << POL) | (1L << ANOT) | (1L << REV) | (1L << PV) | (1L << PALAVRA))) != 0) );
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

	public static class LinhaContext extends ParserRuleContext {
		public TerminalNode PV(int i) {
			return getToken(SentiLexPTParserParser.PV, i);
		}
		public List<TerminalNode> PV() { return getTokens(SentiLexPTParserParser.PV); }
		public BlocoContext bloco(int i) {
			return getRuleContext(BlocoContext.class,i);
		}
		public List<BlocoContext> bloco() {
			return getRuleContexts(BlocoContext.class);
		}
		public LinhaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_linha; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SentiLexPTParserListener ) ((SentiLexPTParserListener)listener).enterLinha(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SentiLexPTParserListener ) ((SentiLexPTParserListener)listener).exitLinha(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SentiLexPTParserVisitor ) return ((SentiLexPTParserVisitor<? extends T>)visitor).visitLinha(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LinhaContext linha() throws RecognitionException {
		LinhaContext _localctx = new LinhaContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_linha);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(18); 
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(15); bloco();
					setState(16); match(PV);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(20); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			} while ( _alt!=2 && _alt!=-1 );
			setState(22); bloco();
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

	public static class BlocoContext extends ParserRuleContext {
		public BlocoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloco; }
	 
		public BlocoContext() { }
		public void copyFrom(BlocoContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PalavraEPoSContext extends BlocoContext {
		public List<TerminalNode> PALAVRA() { return getTokens(SentiLexPTParserParser.PALAVRA); }
		public TerminalNode CLASSE() { return getToken(SentiLexPTParserParser.CLASSE, 0); }
		public TerminalNode PONTO() { return getToken(SentiLexPTParserParser.PONTO, 0); }
		public TerminalNode EQ() { return getToken(SentiLexPTParserParser.EQ, 0); }
		public TerminalNode POS() { return getToken(SentiLexPTParserParser.POS, 0); }
		public TerminalNode PALAVRA(int i) {
			return getToken(SentiLexPTParserParser.PALAVRA, i);
		}
		public PalavraEPoSContext(BlocoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SentiLexPTParserListener ) ((SentiLexPTParserListener)listener).enterPalavraEPoS(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SentiLexPTParserListener ) ((SentiLexPTParserListener)listener).exitPalavraEPoS(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SentiLexPTParserVisitor ) return ((SentiLexPTParserVisitor<? extends T>)visitor).visitPalavraEPoS(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PolContext extends BlocoContext {
		public TerminalNode PV() { return getToken(SentiLexPTParserParser.PV, 0); }
		public BlocoPolContext blocoPol(int i) {
			return getRuleContext(BlocoPolContext.class,i);
		}
		public List<BlocoPolContext> blocoPol() {
			return getRuleContexts(BlocoPolContext.class);
		}
		public PolContext(BlocoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SentiLexPTParserListener ) ((SentiLexPTParserListener)listener).enterPol(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SentiLexPTParserListener ) ((SentiLexPTParserListener)listener).exitPol(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SentiLexPTParserVisitor ) return ((SentiLexPTParserVisitor<? extends T>)visitor).visitPol(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AlvoContext extends BlocoContext {
		public List<TerminalNode> DP() { return getTokens(SentiLexPTParserParser.DP); }
		public List<TerminalNode> TIPON() { return getTokens(SentiLexPTParserParser.TIPON); }
		public TerminalNode DP(int i) {
			return getToken(SentiLexPTParserParser.DP, i);
		}
		public TerminalNode EQ() { return getToken(SentiLexPTParserParser.EQ, 0); }
		public TerminalNode ALVO() { return getToken(SentiLexPTParserParser.ALVO, 0); }
		public TerminalNode TIPON(int i) {
			return getToken(SentiLexPTParserParser.TIPON, i);
		}
		public TerminalNode HUM() { return getToken(SentiLexPTParserParser.HUM, 0); }
		public AlvoContext(BlocoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SentiLexPTParserListener ) ((SentiLexPTParserListener)listener).enterAlvo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SentiLexPTParserListener ) ((SentiLexPTParserListener)listener).exitAlvo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SentiLexPTParserVisitor ) return ((SentiLexPTParserVisitor<? extends T>)visitor).visitAlvo(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AnotContext extends BlocoContext {
		public TerminalNode EQ() { return getToken(SentiLexPTParserParser.EQ, 0); }
		public TerminalNode ANOT() { return getToken(SentiLexPTParserParser.ANOT, 0); }
		public TerminalNode ANOTADOR() { return getToken(SentiLexPTParserParser.ANOTADOR, 0); }
		public AnotContext(BlocoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SentiLexPTParserListener ) ((SentiLexPTParserListener)listener).enterAnot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SentiLexPTParserListener ) ((SentiLexPTParserListener)listener).exitAnot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SentiLexPTParserVisitor ) return ((SentiLexPTParserVisitor<? extends T>)visitor).visitAnot(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RevContext extends BlocoContext {
		public TerminalNode REV() { return getToken(SentiLexPTParserParser.REV, 0); }
		public RevContext(BlocoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SentiLexPTParserListener ) ((SentiLexPTParserListener)listener).enterRev(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SentiLexPTParserListener ) ((SentiLexPTParserListener)listener).exitRev(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SentiLexPTParserVisitor ) return ((SentiLexPTParserVisitor<? extends T>)visitor).visitRev(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlocoContext bloco() throws RecognitionException {
		BlocoContext _localctx = new BlocoContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_bloco);
		int _la;
		try {
			setState(53);
			switch (_input.LA(1)) {
			case PALAVRA:
				_localctx = new PalavraEPoSContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(25); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(24); match(PALAVRA);
					}
					}
					setState(27); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==PALAVRA );
				setState(29); match(PONTO);
				setState(30); match(POS);
				setState(31); match(EQ);
				setState(32); match(CLASSE);
				}
				break;
			case ALVO:
				_localctx = new AlvoContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(33); match(ALVO);
				setState(34); match(EQ);
				{
				setState(35); match(HUM);
				setState(38); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(36); match(DP);
					setState(37); match(TIPON);
					}
					}
					setState(40); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==DP );
				}
				}
				break;
			case POL:
				_localctx = new PolContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(42); blocoPol();
				setState(45);
				switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
				case 1:
					{
					setState(43); match(PV);
					setState(44); blocoPol();
					}
					break;
				}
				}
				break;
			case ANOT:
				_localctx = new AnotContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(47); match(ANOT);
				setState(48); match(EQ);
				setState(49); match(ANOTADOR);
				}
				break;
			case REV:
			case QL:
			case PV:
				_localctx = new RevContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(51);
				_la = _input.LA(1);
				if (_la==REV) {
					{
					setState(50); match(REV);
					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class BlocoPolContext extends ParserRuleContext {
		public TerminalNode POL() { return getToken(SentiLexPTParserParser.POL, 0); }
		public TerminalNode DP() { return getToken(SentiLexPTParserParser.DP, 0); }
		public TerminalNode POLARIDADE() { return getToken(SentiLexPTParserParser.POLARIDADE, 0); }
		public TerminalNode EQ() { return getToken(SentiLexPTParserParser.EQ, 0); }
		public TerminalNode TIPON() { return getToken(SentiLexPTParserParser.TIPON, 0); }
		public BlocoPolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blocoPol; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SentiLexPTParserListener ) ((SentiLexPTParserListener)listener).enterBlocoPol(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SentiLexPTParserListener ) ((SentiLexPTParserListener)listener).exitBlocoPol(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SentiLexPTParserVisitor ) return ((SentiLexPTParserVisitor<? extends T>)visitor).visitBlocoPol(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlocoPolContext blocoPol() throws RecognitionException {
		BlocoPolContext _localctx = new BlocoPolContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_blocoPol);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55); match(POL);
			setState(56); match(DP);
			setState(57); match(TIPON);
			setState(58); match(EQ);
			setState(59); match(POLARIDADE);
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
		"\2\3\23@\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\3\2\3\2\3\2\6\2\16\n\2\r\2\16"+
		"\2\17\3\3\3\3\3\3\6\3\25\n\3\r\3\16\3\26\3\3\3\3\3\4\6\4\34\n\4\r\4\16"+
		"\4\35\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\6\4)\n\4\r\4\16\4*\3\4\3\4\3"+
		"\4\5\4\60\n\4\3\4\3\4\3\4\3\4\5\4\66\n\4\5\48\n\4\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\2\6\2\4\6\b\2\2E\2\r\3\2\2\2\4\24\3\2\2\2\6\67\3\2\2\2\b9\3\2"+
		"\2\2\n\13\5\4\3\2\13\f\7\16\2\2\f\16\3\2\2\2\r\n\3\2\2\2\16\17\3\2\2\2"+
		"\17\r\3\2\2\2\17\20\3\2\2\2\20\3\3\2\2\2\21\22\5\6\4\2\22\23\7\17\2\2"+
		"\23\25\3\2\2\2\24\21\3\2\2\2\25\26\3\2\2\2\26\24\3\2\2\2\26\27\3\2\2\2"+
		"\27\30\3\2\2\2\30\31\5\6\4\2\31\5\3\2\2\2\32\34\7\23\2\2\33\32\3\2\2\2"+
		"\34\35\3\2\2\2\35\33\3\2\2\2\35\36\3\2\2\2\36\37\3\2\2\2\37 \7\22\2\2"+
		" !\7\4\2\2!\"\7\20\2\2\"8\7\5\2\2#$\7\6\2\2$%\7\20\2\2%(\7\7\2\2&\'\7"+
		"\21\2\2\')\7\b\2\2(&\3\2\2\2)*\3\2\2\2*(\3\2\2\2*+\3\2\2\2+8\3\2\2\2,"+
		"/\5\b\5\2-.\7\17\2\2.\60\5\b\5\2/-\3\2\2\2/\60\3\2\2\2\608\3\2\2\2\61"+
		"\62\7\n\2\2\62\63\7\20\2\2\638\7\13\2\2\64\66\7\f\2\2\65\64\3\2\2\2\65"+
		"\66\3\2\2\2\668\3\2\2\2\67\33\3\2\2\2\67#\3\2\2\2\67,\3\2\2\2\67\61\3"+
		"\2\2\2\67\65\3\2\2\28\7\3\2\2\29:\7\t\2\2:;\7\21\2\2;<\7\b\2\2<=\7\20"+
		"\2\2=>\7\r\2\2>\t\3\2\2\2\t\17\26\35*/\65\67";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}