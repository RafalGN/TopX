// Generated from C:\Users\User\Dropbox\Federal\MESTRADO\Projeto\workspace\SentiWords\src\sentiwords\Sintagmas\GramaticaSintagmatica.g4 by ANTLR 4.0
package gramaticas.sintagmatica;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GramaticaSintagmaticaParser extends Parser {
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
		RULE_periodo = 0, RULE_oracao = 1, RULE_nao_opc = 2, RULE_sn_opc = 3, 
		RULE_sn = 4, RULE_sn_suj = 5, RULE_det = 6, RULE_pre_det = 7, RULE_det_base = 8, 
		RULE_pos_det = 9, RULE_mod = 10, RULE_sp_opc = 11, RULE_sp = 12, RULE_sa_opc = 13, 
		RULE_sa = 14, RULE_intens = 15, RULE_sv = 16, RULE_complemento = 17;
	public static final String[] ruleNames = {
		"periodo", "oracao", "nao_opc", "sn_opc", "sn", "sn_suj", "det", "pre_det", 
		"det_base", "pos_det", "mod", "sp_opc", "sp", "sa_opc", "sa", "intens", 
		"sv", "complemento"
	};

	@Override
	public String getGrammarFileName() { return "GramaticaSintagmatica.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public GramaticaSintagmaticaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class PeriodoContext extends ParserRuleContext {
		public OracaoContext oracao(int i) {
			return getRuleContext(OracaoContext.class,i);
		}
		public List<OracaoContext> oracao() {
			return getRuleContexts(OracaoContext.class);
		}
		public PeriodoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_periodo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaSintagmaticaListener ) ((GramaticaSintagmaticaListener)listener).enterPeriodo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaSintagmaticaListener ) ((GramaticaSintagmaticaListener)listener).exitPeriodo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaSintagmaticaVisitor ) return ((GramaticaSintagmaticaVisitor<? extends T>)visitor).visitPeriodo(this);
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
			setState(40);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=1 && _alt!=-1 ) {
				if ( _alt==1+1 ) {
					{
					setState(38);
					switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
					case 1:
						{
						setState(36); oracao();
						}
						break;

					case 2:
						{
						setState(37);
						matchWildcard();
						}
						break;
					}
					} 
				}
				setState(42);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
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

	public static class OracaoContext extends ParserRuleContext {
		public Nao_opcContext nao_opc() {
			return getRuleContext(Nao_opcContext.class,0);
		}
		public SpContext sp() {
			return getRuleContext(SpContext.class,0);
		}
		public TerminalNode VIRGULA() { return getToken(GramaticaSintagmaticaParser.VIRGULA, 0); }
		public Sn_sujContext sn_suj() {
			return getRuleContext(Sn_sujContext.class,0);
		}
		public SvContext sv() {
			return getRuleContext(SvContext.class,0);
		}
		public Sp_opcContext sp_opc() {
			return getRuleContext(Sp_opcContext.class,0);
		}
		public OracaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oracao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaSintagmaticaListener ) ((GramaticaSintagmaticaListener)listener).enterOracao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaSintagmaticaListener ) ((GramaticaSintagmaticaListener)listener).exitOracao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaSintagmaticaVisitor ) return ((GramaticaSintagmaticaVisitor<? extends T>)visitor).visitOracao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OracaoContext oracao() throws RecognitionException {
		OracaoContext _localctx = new OracaoContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_oracao);
		int _la;
		try {
			setState(65);
			switch (_input.LA(1)) {
			case NAO:
			case ART:
			case SUBS:
			case VERB:
			case PRON:
			case NUM:
				enterOuterAlt(_localctx, 1);
				{
				setState(44);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ART) | (1L << SUBS) | (1L << PRON) | (1L << NUM))) != 0)) {
					{
					setState(43); sn_suj();
					}
				}

				setState(47);
				_la = _input.LA(1);
				if (_la==NAO) {
					{
					setState(46); nao_opc();
					}
				}

				setState(49); sv();
				setState(51);
				switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
				case 1:
					{
					setState(50); sp_opc();
					}
					break;
				}
				}
				break;
			case PREP:
			case ADV:
				enterOuterAlt(_localctx, 2);
				{
				setState(53); sp();
				setState(54); match(VIRGULA);
				setState(56);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ART) | (1L << SUBS) | (1L << PRON) | (1L << NUM))) != 0)) {
					{
					setState(55); sn_suj();
					}
				}

				setState(59);
				_la = _input.LA(1);
				if (_la==NAO) {
					{
					setState(58); nao_opc();
					}
				}

				setState(61); sv();
				setState(63);
				switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
				case 1:
					{
					setState(62); sp_opc();
					}
					break;
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

	public static class Nao_opcContext extends ParserRuleContext {
		public TerminalNode NAO() { return getToken(GramaticaSintagmaticaParser.NAO, 0); }
		public Nao_opcContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nao_opc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaSintagmaticaListener ) ((GramaticaSintagmaticaListener)listener).enterNao_opc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaSintagmaticaListener ) ((GramaticaSintagmaticaListener)listener).exitNao_opc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaSintagmaticaVisitor ) return ((GramaticaSintagmaticaVisitor<? extends T>)visitor).visitNao_opc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Nao_opcContext nao_opc() throws RecognitionException {
		Nao_opcContext _localctx = new Nao_opcContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_nao_opc);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67); match(NAO);
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

	public static class Sn_opcContext extends ParserRuleContext {
		public SnContext sn() {
			return getRuleContext(SnContext.class,0);
		}
		public Sn_opcContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sn_opc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaSintagmaticaListener ) ((GramaticaSintagmaticaListener)listener).enterSn_opc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaSintagmaticaListener ) ((GramaticaSintagmaticaListener)listener).exitSn_opc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaSintagmaticaVisitor ) return ((GramaticaSintagmaticaVisitor<? extends T>)visitor).visitSn_opc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Sn_opcContext sn_opc() throws RecognitionException {
		Sn_opcContext _localctx = new Sn_opcContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_sn_opc);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69); sn();
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

	public static class SnContext extends ParserRuleContext {
		public DetContext det() {
			return getRuleContext(DetContext.class,0);
		}
		public TerminalNode SUBS() { return getToken(GramaticaSintagmaticaParser.SUBS, 0); }
		public ModContext mod() {
			return getRuleContext(ModContext.class,0);
		}
		public Sa_opcContext sa_opc() {
			return getRuleContext(Sa_opcContext.class,0);
		}
		public SnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sn; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaSintagmaticaListener ) ((GramaticaSintagmaticaListener)listener).enterSn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaSintagmaticaListener ) ((GramaticaSintagmaticaListener)listener).exitSn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaSintagmaticaVisitor ) return ((GramaticaSintagmaticaVisitor<? extends T>)visitor).visitSn(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SnContext sn() throws RecognitionException {
		SnContext _localctx = new SnContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_sn);
		try {
			setState(80);
			switch (_input.LA(1)) {
			case SUBS:
				enterOuterAlt(_localctx, 1);
				{
				setState(71); match(SUBS);
				}
				break;
			case ART:
			case PRON:
			case NUM:
				enterOuterAlt(_localctx, 2);
				{
				setState(72); det();
				setState(74);
				switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
				case 1:
					{
					setState(73); sa_opc();
					}
					break;
				}
				setState(76); match(SUBS);
				setState(78);
				switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
				case 1:
					{
					setState(77); mod();
					}
					break;
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

	public static class Sn_sujContext extends ParserRuleContext {
		public List<TerminalNode> PREP() { return getTokens(GramaticaSintagmaticaParser.PREP); }
		public TerminalNode SUBS(int i) {
			return getToken(GramaticaSintagmaticaParser.SUBS, i);
		}
		public DetContext det() {
			return getRuleContext(DetContext.class,0);
		}
		public List<TerminalNode> SUBS() { return getTokens(GramaticaSintagmaticaParser.SUBS); }
		public ModContext mod() {
			return getRuleContext(ModContext.class,0);
		}
		public TerminalNode PREP(int i) {
			return getToken(GramaticaSintagmaticaParser.PREP, i);
		}
		public TerminalNode PRON() { return getToken(GramaticaSintagmaticaParser.PRON, 0); }
		public Sa_opcContext sa_opc() {
			return getRuleContext(Sa_opcContext.class,0);
		}
		public Sn_sujContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sn_suj; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaSintagmaticaListener ) ((GramaticaSintagmaticaListener)listener).enterSn_suj(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaSintagmaticaListener ) ((GramaticaSintagmaticaListener)listener).exitSn_suj(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaSintagmaticaVisitor ) return ((GramaticaSintagmaticaVisitor<? extends T>)visitor).visitSn_suj(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Sn_sujContext sn_suj() throws RecognitionException {
		Sn_sujContext _localctx = new Sn_sujContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_sn_suj);
		int _la;
		try {
			int _alt;
			setState(112);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(93);
				switch (_input.LA(1)) {
				case SUBS:
					{
					setState(82); match(SUBS);
					setState(89);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==SUBS || _la==PREP) {
						{
						{
						setState(84);
						_la = _input.LA(1);
						if (_la==PREP) {
							{
							setState(83); match(PREP);
							}
						}

						setState(86); match(SUBS);
						}
						}
						setState(91);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					break;
				case PRON:
					{
					setState(92); match(PRON);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(95); det();
				setState(97);
				switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
				case 1:
					{
					setState(96); sa_opc();
					}
					break;
				}
				setState(99); match(SUBS);
				setState(106);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
				while ( _alt!=2 && _alt!=-1 ) {
					if ( _alt==1 ) {
						{
						{
						setState(101);
						_la = _input.LA(1);
						if (_la==PREP) {
							{
							setState(100); match(PREP);
							}
						}

						setState(103); match(SUBS);
						}
						} 
					}
					setState(108);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
				}
				setState(110);
				switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
				case 1:
					{
					setState(109); mod();
					}
					break;
				}
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

	public static class DetContext extends ParserRuleContext {
		public Pre_detContext pre_det() {
			return getRuleContext(Pre_detContext.class,0);
		}
		public Det_baseContext det_base() {
			return getRuleContext(Det_baseContext.class,0);
		}
		public Pos_detContext pos_det() {
			return getRuleContext(Pos_detContext.class,0);
		}
		public DetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_det; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaSintagmaticaListener ) ((GramaticaSintagmaticaListener)listener).enterDet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaSintagmaticaListener ) ((GramaticaSintagmaticaListener)listener).exitDet(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaSintagmaticaVisitor ) return ((GramaticaSintagmaticaVisitor<? extends T>)visitor).visitDet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DetContext det() throws RecognitionException {
		DetContext _localctx = new DetContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_det);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(114); pre_det();
				}
				break;
			}
			setState(117); det_base();
			setState(119);
			_la = _input.LA(1);
			if (_la==PRON || _la==NUM) {
				{
				setState(118); pos_det();
				}
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

	public static class Pre_detContext extends ParserRuleContext {
		public Pre_detContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pre_det; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaSintagmaticaListener ) ((GramaticaSintagmaticaListener)listener).enterPre_det(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaSintagmaticaListener ) ((GramaticaSintagmaticaListener)listener).exitPre_det(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaSintagmaticaVisitor ) return ((GramaticaSintagmaticaVisitor<? extends T>)visitor).visitPre_det(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Pre_detContext pre_det() throws RecognitionException {
		Pre_detContext _localctx = new Pre_detContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_pre_det);
		try {
			enterOuterAlt(_localctx, 1);
			{
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

	public static class Det_baseContext extends ParserRuleContext {
		public TerminalNode ART() { return getToken(GramaticaSintagmaticaParser.ART, 0); }
		public TerminalNode PRON() { return getToken(GramaticaSintagmaticaParser.PRON, 0); }
		public TerminalNode NUM() { return getToken(GramaticaSintagmaticaParser.NUM, 0); }
		public Det_baseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_det_base; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaSintagmaticaListener ) ((GramaticaSintagmaticaListener)listener).enterDet_base(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaSintagmaticaListener ) ((GramaticaSintagmaticaListener)listener).exitDet_base(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaSintagmaticaVisitor ) return ((GramaticaSintagmaticaVisitor<? extends T>)visitor).visitDet_base(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Det_baseContext det_base() throws RecognitionException {
		Det_baseContext _localctx = new Det_baseContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_det_base);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ART) | (1L << PRON) | (1L << NUM))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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

	public static class Pos_detContext extends ParserRuleContext {
		public TerminalNode PRON() { return getToken(GramaticaSintagmaticaParser.PRON, 0); }
		public TerminalNode NUM() { return getToken(GramaticaSintagmaticaParser.NUM, 0); }
		public Pos_detContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pos_det; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaSintagmaticaListener ) ((GramaticaSintagmaticaListener)listener).enterPos_det(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaSintagmaticaListener ) ((GramaticaSintagmaticaListener)listener).exitPos_det(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaSintagmaticaVisitor ) return ((GramaticaSintagmaticaVisitor<? extends T>)visitor).visitPos_det(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Pos_detContext pos_det() throws RecognitionException {
		Pos_detContext _localctx = new Pos_detContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_pos_det);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			_la = _input.LA(1);
			if ( !(_la==PRON || _la==NUM) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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

	public static class ModContext extends ParserRuleContext {
		public SpContext sp() {
			return getRuleContext(SpContext.class,0);
		}
		public SaContext sa() {
			return getRuleContext(SaContext.class,0);
		}
		public ModContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mod; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaSintagmaticaListener ) ((GramaticaSintagmaticaListener)listener).enterMod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaSintagmaticaListener ) ((GramaticaSintagmaticaListener)listener).exitMod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaSintagmaticaVisitor ) return ((GramaticaSintagmaticaVisitor<? extends T>)visitor).visitMod(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ModContext mod() throws RecognitionException {
		ModContext _localctx = new ModContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_mod);
		try {
			setState(131);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(128);
				switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
				case 1:
					{
					setState(127); sa();
					}
					break;
				}
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(130); sp();
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

	public static class Sp_opcContext extends ParserRuleContext {
		public SpContext sp() {
			return getRuleContext(SpContext.class,0);
		}
		public Sp_opcContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sp_opc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaSintagmaticaListener ) ((GramaticaSintagmaticaListener)listener).enterSp_opc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaSintagmaticaListener ) ((GramaticaSintagmaticaListener)listener).exitSp_opc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaSintagmaticaVisitor ) return ((GramaticaSintagmaticaVisitor<? extends T>)visitor).visitSp_opc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Sp_opcContext sp_opc() throws RecognitionException {
		Sp_opcContext _localctx = new Sp_opcContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_sp_opc);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133); sp();
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

	public static class SpContext extends ParserRuleContext {
		public TerminalNode PREP() { return getToken(GramaticaSintagmaticaParser.PREP, 0); }
		public SnContext sn() {
			return getRuleContext(SnContext.class,0);
		}
		public Sp_opcContext sp_opc() {
			return getRuleContext(Sp_opcContext.class,0);
		}
		public TerminalNode ADV() { return getToken(GramaticaSintagmaticaParser.ADV, 0); }
		public SpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaSintagmaticaListener ) ((GramaticaSintagmaticaListener)listener).enterSp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaSintagmaticaListener ) ((GramaticaSintagmaticaListener)listener).exitSp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaSintagmaticaVisitor ) return ((GramaticaSintagmaticaVisitor<? extends T>)visitor).visitSp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SpContext sp() throws RecognitionException {
		SpContext _localctx = new SpContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_sp);
		try {
			setState(141);
			switch (_input.LA(1)) {
			case PREP:
				enterOuterAlt(_localctx, 1);
				{
				setState(135); match(PREP);
				setState(136); sn();
				}
				break;
			case ADV:
				enterOuterAlt(_localctx, 2);
				{
				setState(137); match(ADV);
				setState(139);
				switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
				case 1:
					{
					setState(138); sp_opc();
					}
					break;
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

	public static class Sa_opcContext extends ParserRuleContext {
		public SaContext sa() {
			return getRuleContext(SaContext.class,0);
		}
		public Sa_opcContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sa_opc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaSintagmaticaListener ) ((GramaticaSintagmaticaListener)listener).enterSa_opc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaSintagmaticaListener ) ((GramaticaSintagmaticaListener)listener).exitSa_opc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaSintagmaticaVisitor ) return ((GramaticaSintagmaticaVisitor<? extends T>)visitor).visitSa_opc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Sa_opcContext sa_opc() throws RecognitionException {
		Sa_opcContext _localctx = new Sa_opcContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_sa_opc);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				{
				setState(143); sa();
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

	public static class SaContext extends ParserRuleContext {
		public TerminalNode VIRGULA(int i) {
			return getToken(GramaticaSintagmaticaParser.VIRGULA, i);
		}
		public TerminalNode ADJ(int i) {
			return getToken(GramaticaSintagmaticaParser.ADJ, i);
		}
		public List<TerminalNode> CONJ() { return getTokens(GramaticaSintagmaticaParser.CONJ); }
		public List<TerminalNode> VIRGULA() { return getTokens(GramaticaSintagmaticaParser.VIRGULA); }
		public List<TerminalNode> ADJ() { return getTokens(GramaticaSintagmaticaParser.ADJ); }
		public IntensContext intens() {
			return getRuleContext(IntensContext.class,0);
		}
		public TerminalNode CONJ(int i) {
			return getToken(GramaticaSintagmaticaParser.CONJ, i);
		}
		public Sp_opcContext sp_opc() {
			return getRuleContext(Sp_opcContext.class,0);
		}
		public SaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sa; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaSintagmaticaListener ) ((GramaticaSintagmaticaListener)listener).enterSa(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaSintagmaticaListener ) ((GramaticaSintagmaticaListener)listener).exitSa(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaSintagmaticaVisitor ) return ((GramaticaSintagmaticaVisitor<? extends T>)visitor).visitSa(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SaContext sa() throws RecognitionException {
		SaContext _localctx = new SaContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_sa);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			_la = _input.LA(1);
			if (_la==ADV) {
				{
				setState(146); intens();
				}
			}

			setState(149); match(ADJ);
			setState(156);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(151);
					_la = _input.LA(1);
					if (_la==VIRGULA || _la==CONJ) {
						{
						setState(150);
						_la = _input.LA(1);
						if ( !(_la==VIRGULA || _la==CONJ) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						}
					}

					setState(153); match(ADJ);
					}
					} 
				}
				setState(158);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			}
			setState(160);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				{
				setState(159); sp_opc();
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

	public static class IntensContext extends ParserRuleContext {
		public TerminalNode ADV() { return getToken(GramaticaSintagmaticaParser.ADV, 0); }
		public IntensContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_intens; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaSintagmaticaListener ) ((GramaticaSintagmaticaListener)listener).enterIntens(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaSintagmaticaListener ) ((GramaticaSintagmaticaListener)listener).exitIntens(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaSintagmaticaVisitor ) return ((GramaticaSintagmaticaVisitor<? extends T>)visitor).visitIntens(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntensContext intens() throws RecognitionException {
		IntensContext _localctx = new IntensContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_intens);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162); match(ADV);
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

	public static class SvContext extends ParserRuleContext {
		public ComplementoContext complemento() {
			return getRuleContext(ComplementoContext.class,0);
		}
		public TerminalNode VERB() { return getToken(GramaticaSintagmaticaParser.VERB, 0); }
		public SvContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sv; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaSintagmaticaListener ) ((GramaticaSintagmaticaListener)listener).enterSv(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaSintagmaticaListener ) ((GramaticaSintagmaticaListener)listener).exitSv(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaSintagmaticaVisitor ) return ((GramaticaSintagmaticaVisitor<? extends T>)visitor).visitSv(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SvContext sv() throws RecognitionException {
		SvContext _localctx = new SvContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_sv);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164); match(VERB);
			setState(165); complemento();
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

	public static class ComplementoContext extends ParserRuleContext {
		public Sp_opcContext sp_opc() {
			return getRuleContext(Sp_opcContext.class,0);
		}
		public Sa_opcContext sa_opc() {
			return getRuleContext(Sa_opcContext.class,0);
		}
		public Sn_opcContext sn_opc() {
			return getRuleContext(Sn_opcContext.class,0);
		}
		public ComplementoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_complemento; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaSintagmaticaListener ) ((GramaticaSintagmaticaListener)listener).enterComplemento(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaSintagmaticaListener ) ((GramaticaSintagmaticaListener)listener).exitComplemento(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaSintagmaticaVisitor ) return ((GramaticaSintagmaticaVisitor<? extends T>)visitor).visitComplemento(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComplementoContext complemento() throws RecognitionException {
		ComplementoContext _localctx = new ComplementoContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_complemento);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				{
				setState(167); sa_opc();
				}
				break;
			}
			setState(171);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				{
				setState(170); sn_opc();
				}
				break;
			}
			setState(174);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				{
				setState(173); sp_opc();
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

	public static final String _serializedATN =
		"\2\3\24\u00b3\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b"+
		"\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t"+
		"\20\4\21\t\21\4\22\t\22\4\23\t\23\3\2\3\2\7\2)\n\2\f\2\16\2,\13\2\3\3"+
		"\5\3/\n\3\3\3\5\3\62\n\3\3\3\3\3\5\3\66\n\3\3\3\3\3\3\3\5\3;\n\3\3\3\5"+
		"\3>\n\3\3\3\3\3\5\3B\n\3\5\3D\n\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\5\6M\n\6"+
		"\3\6\3\6\5\6Q\n\6\5\6S\n\6\3\7\3\7\5\7W\n\7\3\7\7\7Z\n\7\f\7\16\7]\13"+
		"\7\3\7\5\7`\n\7\3\7\3\7\5\7d\n\7\3\7\3\7\5\7h\n\7\3\7\7\7k\n\7\f\7\16"+
		"\7n\13\7\3\7\5\7q\n\7\5\7s\n\7\3\b\5\bv\n\b\3\b\3\b\5\bz\n\b\3\t\3\t\3"+
		"\n\3\n\3\13\3\13\3\f\5\f\u0083\n\f\3\f\5\f\u0086\n\f\3\r\3\r\3\16\3\16"+
		"\3\16\3\16\5\16\u008e\n\16\5\16\u0090\n\16\3\17\5\17\u0093\n\17\3\20\5"+
		"\20\u0096\n\20\3\20\3\20\5\20\u009a\n\20\3\20\7\20\u009d\n\20\f\20\16"+
		"\20\u00a0\13\20\3\20\5\20\u00a3\n\20\3\21\3\21\3\22\3\22\3\22\3\23\5\23"+
		"\u00ab\n\23\3\23\5\23\u00ae\n\23\3\23\5\23\u00b1\n\23\3\23\3*\24\2\4\6"+
		"\b\n\f\16\20\22\24\26\30\32\34\36 \"$\2\5\5\13\13\20\20\23\23\4\20\20"+
		"\23\23\4\b\b\21\21\u00c2\2*\3\2\2\2\4C\3\2\2\2\6E\3\2\2\2\bG\3\2\2\2\n"+
		"R\3\2\2\2\fr\3\2\2\2\16u\3\2\2\2\20{\3\2\2\2\22}\3\2\2\2\24\177\3\2\2"+
		"\2\26\u0085\3\2\2\2\30\u0087\3\2\2\2\32\u008f\3\2\2\2\34\u0092\3\2\2\2"+
		"\36\u0095\3\2\2\2 \u00a4\3\2\2\2\"\u00a6\3\2\2\2$\u00aa\3\2\2\2&)\5\4"+
		"\3\2\')\13\2\2\2(&\3\2\2\2(\'\3\2\2\2),\3\2\2\2*+\3\2\2\2*(\3\2\2\2+\3"+
		"\3\2\2\2,*\3\2\2\2-/\5\f\7\2.-\3\2\2\2./\3\2\2\2/\61\3\2\2\2\60\62\5\6"+
		"\4\2\61\60\3\2\2\2\61\62\3\2\2\2\62\63\3\2\2\2\63\65\5\"\22\2\64\66\5"+
		"\30\r\2\65\64\3\2\2\2\65\66\3\2\2\2\66D\3\2\2\2\678\5\32\16\28:\7\b\2"+
		"\29;\5\f\7\2:9\3\2\2\2:;\3\2\2\2;=\3\2\2\2<>\5\6\4\2=<\3\2\2\2=>\3\2\2"+
		"\2>?\3\2\2\2?A\5\"\22\2@B\5\30\r\2A@\3\2\2\2AB\3\2\2\2BD\3\2\2\2C.\3\2"+
		"\2\2C\67\3\2\2\2D\5\3\2\2\2EF\7\n\2\2F\7\3\2\2\2GH\5\n\6\2H\t\3\2\2\2"+
		"IS\7\r\2\2JL\5\16\b\2KM\5\34\17\2LK\3\2\2\2LM\3\2\2\2MN\3\2\2\2NP\7\r"+
		"\2\2OQ\5\26\f\2PO\3\2\2\2PQ\3\2\2\2QS\3\2\2\2RI\3\2\2\2RJ\3\2\2\2S\13"+
		"\3\2\2\2T[\7\r\2\2UW\7\17\2\2VU\3\2\2\2VW\3\2\2\2WX\3\2\2\2XZ\7\r\2\2"+
		"YV\3\2\2\2Z]\3\2\2\2[Y\3\2\2\2[\\\3\2\2\2\\`\3\2\2\2][\3\2\2\2^`\7\20"+
		"\2\2_T\3\2\2\2_^\3\2\2\2`s\3\2\2\2ac\5\16\b\2bd\5\34\17\2cb\3\2\2\2cd"+
		"\3\2\2\2de\3\2\2\2el\7\r\2\2fh\7\17\2\2gf\3\2\2\2gh\3\2\2\2hi\3\2\2\2"+
		"ik\7\r\2\2jg\3\2\2\2kn\3\2\2\2lj\3\2\2\2lm\3\2\2\2mp\3\2\2\2nl\3\2\2\2"+
		"oq\5\26\f\2po\3\2\2\2pq\3\2\2\2qs\3\2\2\2r_\3\2\2\2ra\3\2\2\2s\r\3\2\2"+
		"\2tv\5\20\t\2ut\3\2\2\2uv\3\2\2\2vw\3\2\2\2wy\5\22\n\2xz\5\24\13\2yx\3"+
		"\2\2\2yz\3\2\2\2z\17\3\2\2\2{|\3\2\2\2|\21\3\2\2\2}~\t\2\2\2~\23\3\2\2"+
		"\2\177\u0080\t\3\2\2\u0080\25\3\2\2\2\u0081\u0083\5\36\20\2\u0082\u0081"+
		"\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0086\3\2\2\2\u0084\u0086\5\32\16\2"+
		"\u0085\u0082\3\2\2\2\u0085\u0084\3\2\2\2\u0086\27\3\2\2\2\u0087\u0088"+
		"\5\32\16\2\u0088\31\3\2\2\2\u0089\u008a\7\17\2\2\u008a\u0090\5\n\6\2\u008b"+
		"\u008d\7\22\2\2\u008c\u008e\5\30\r\2\u008d\u008c\3\2\2\2\u008d\u008e\3"+
		"\2\2\2\u008e\u0090\3\2\2\2\u008f\u0089\3\2\2\2\u008f\u008b\3\2\2\2\u0090"+
		"\33\3\2\2\2\u0091\u0093\5\36\20\2\u0092\u0091\3\2\2\2\u0092\u0093\3\2"+
		"\2\2\u0093\35\3\2\2\2\u0094\u0096\5 \21\2\u0095\u0094\3\2\2\2\u0095\u0096"+
		"\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u009e\7\f\2\2\u0098\u009a\t\4\2\2\u0099"+
		"\u0098\3\2\2\2\u0099\u009a\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u009d\7\f"+
		"\2\2\u009c\u0099\3\2\2\2\u009d\u00a0\3\2\2\2\u009e\u009c\3\2\2\2\u009e"+
		"\u009f\3\2\2\2\u009f\u00a2\3\2\2\2\u00a0\u009e\3\2\2\2\u00a1\u00a3\5\30"+
		"\r\2\u00a2\u00a1\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\37\3\2\2\2\u00a4\u00a5"+
		"\7\22\2\2\u00a5!\3\2\2\2\u00a6\u00a7\7\16\2\2\u00a7\u00a8\5$\23\2\u00a8"+
		"#\3\2\2\2\u00a9\u00ab\5\34\17\2\u00aa\u00a9\3\2\2\2\u00aa\u00ab\3\2\2"+
		"\2\u00ab\u00ad\3\2\2\2\u00ac\u00ae\5\b\5\2\u00ad\u00ac\3\2\2\2\u00ad\u00ae"+
		"\3\2\2\2\u00ae\u00b0\3\2\2\2\u00af\u00b1\5\30\r\2\u00b0\u00af\3\2\2\2"+
		"\u00b0\u00b1\3\2\2\2\u00b1%\3\2\2\2$(*.\61\65:=ACLPRV[_cglpruy\u0082\u0085"+
		"\u008d\u008f\u0092\u0095\u0099\u009e\u00a2\u00aa\u00ad\u00b0";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}