// Generated from C:/code/estado/src\estado.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class estadoParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, NATURAL=8, TEXT=9, 
		ID=10, WHITESPACE=11, COMMENT=12;
	public static final int
		RULE_file = 0, RULE_state = 1, RULE_handler = 2, RULE_transition = 3, 
		RULE_action = 4, RULE_statement = 5, RULE_instance = 6;
	private static String[] makeRuleNames() {
		return new String[] {
			"file", "state", "handler", "transition", "action", "statement", "instance"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'state'", "'{'", "'}'", "'on'", "'->'", "'<-'", "':'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, "NATURAL", "TEXT", "ID", 
			"WHITESPACE", "COMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "estado/grammar/estado.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public estadoParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class FileContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(estadoParser.EOF, 0); }
		public List<StateContext> state() {
			return getRuleContexts(StateContext.class);
		}
		public StateContext state(int i) {
			return getRuleContext(StateContext.class,i);
		}
		public FileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_file; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof estadoListener ) ((estadoListener)listener).enterFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof estadoListener ) ((estadoListener)listener).exitFile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof estadoVisitor ) return ((estadoVisitor<? extends T>)visitor).visitFile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FileContext file() throws RecognitionException {
		FileContext _localctx = new FileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_file);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(17);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(14);
				state();
				}
				}
				setState(19);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(20);
			match(EOF);
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

	public static class StateContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(estadoParser.ID, 0); }
		public List<InstanceContext> instance() {
			return getRuleContexts(InstanceContext.class);
		}
		public InstanceContext instance(int i) {
			return getRuleContext(InstanceContext.class,i);
		}
		public List<StateContext> state() {
			return getRuleContexts(StateContext.class);
		}
		public StateContext state(int i) {
			return getRuleContext(StateContext.class,i);
		}
		public List<HandlerContext> handler() {
			return getRuleContexts(HandlerContext.class);
		}
		public HandlerContext handler(int i) {
			return getRuleContext(HandlerContext.class,i);
		}
		public StateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_state; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof estadoListener ) ((estadoListener)listener).enterState(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof estadoListener ) ((estadoListener)listener).exitState(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof estadoVisitor ) return ((estadoVisitor<? extends T>)visitor).visitState(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StateContext state() throws RecognitionException {
		StateContext _localctx = new StateContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_state);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(22);
			match(T__0);
			setState(23);
			match(ID);
			setState(24);
			match(T__1);
			setState(30);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__3) | (1L << ID))) != 0)) {
				{
				setState(28);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case ID:
					{
					setState(25);
					instance();
					}
					break;
				case T__0:
					{
					setState(26);
					state();
					}
					break;
				case T__3:
					{
					setState(27);
					handler();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(32);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(33);
			match(T__2);
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

	public static class HandlerContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(estadoParser.ID, 0); }
		public TransitionContext transition() {
			return getRuleContext(TransitionContext.class,0);
		}
		public ActionContext action() {
			return getRuleContext(ActionContext.class,0);
		}
		public HandlerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_handler; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof estadoListener ) ((estadoListener)listener).enterHandler(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof estadoListener ) ((estadoListener)listener).exitHandler(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof estadoVisitor ) return ((estadoVisitor<? extends T>)visitor).visitHandler(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HandlerContext handler() throws RecognitionException {
		HandlerContext _localctx = new HandlerContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_handler);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			match(T__3);
			setState(36);
			match(ID);
			setState(38);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(37);
				transition();
				}
			}

			setState(41);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(40);
				action();
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

	public static class TransitionContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(estadoParser.ID, 0); }
		public TransitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_transition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof estadoListener ) ((estadoListener)listener).enterTransition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof estadoListener ) ((estadoListener)listener).exitTransition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof estadoVisitor ) return ((estadoVisitor<? extends T>)visitor).visitTransition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TransitionContext transition() throws RecognitionException {
		TransitionContext _localctx = new TransitionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_transition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
			match(T__4);
			setState(44);
			match(ID);
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

	public static class ActionContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ActionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_action; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof estadoListener ) ((estadoListener)listener).enterAction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof estadoListener ) ((estadoListener)listener).exitAction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof estadoVisitor ) return ((estadoVisitor<? extends T>)visitor).visitAction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ActionContext action() throws RecognitionException {
		ActionContext _localctx = new ActionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_action);
		int _la;
		try {
			setState(55);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				enterOuterAlt(_localctx, 1);
				{
				setState(46);
				match(T__1);
				setState(50);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==ID) {
					{
					{
					setState(47);
					statement();
					}
					}
					setState(52);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(53);
				match(T__2);
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(54);
				statement();
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

	public static class StatementContext extends ParserRuleContext {
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	 
		public StatementContext() { }
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class MessageStatementContext extends StatementContext {
		public List<TerminalNode> ID() { return getTokens(estadoParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(estadoParser.ID, i);
		}
		public MessageStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof estadoListener ) ((estadoListener)listener).enterMessageStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof estadoListener ) ((estadoListener)listener).exitMessageStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof estadoVisitor ) return ((estadoVisitor<? extends T>)visitor).visitMessageStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_statement);
		try {
			_localctx = new MessageStatementContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			match(ID);
			setState(58);
			match(T__5);
			setState(59);
			match(ID);
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

	public static class InstanceContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(estadoParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(estadoParser.ID, i);
		}
		public InstanceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instance; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof estadoListener ) ((estadoListener)listener).enterInstance(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof estadoListener ) ((estadoListener)listener).exitInstance(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof estadoVisitor ) return ((estadoVisitor<? extends T>)visitor).visitInstance(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstanceContext instance() throws RecognitionException {
		InstanceContext _localctx = new InstanceContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_instance);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			match(ID);
			setState(62);
			match(T__6);
			setState(63);
			match(ID);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\16D\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\7\2\22\n\2\f\2\16\2\25"+
		"\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\7\3\37\n\3\f\3\16\3\"\13\3\3\3\3"+
		"\3\3\4\3\4\3\4\5\4)\n\4\3\4\5\4,\n\4\3\5\3\5\3\5\3\6\3\6\7\6\63\n\6\f"+
		"\6\16\6\66\13\6\3\6\3\6\5\6:\n\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\2"+
		"\2\t\2\4\6\b\n\f\16\2\2\2D\2\23\3\2\2\2\4\30\3\2\2\2\6%\3\2\2\2\b-\3\2"+
		"\2\2\n9\3\2\2\2\f;\3\2\2\2\16?\3\2\2\2\20\22\5\4\3\2\21\20\3\2\2\2\22"+
		"\25\3\2\2\2\23\21\3\2\2\2\23\24\3\2\2\2\24\26\3\2\2\2\25\23\3\2\2\2\26"+
		"\27\7\2\2\3\27\3\3\2\2\2\30\31\7\3\2\2\31\32\7\f\2\2\32 \7\4\2\2\33\37"+
		"\5\16\b\2\34\37\5\4\3\2\35\37\5\6\4\2\36\33\3\2\2\2\36\34\3\2\2\2\36\35"+
		"\3\2\2\2\37\"\3\2\2\2 \36\3\2\2\2 !\3\2\2\2!#\3\2\2\2\" \3\2\2\2#$\7\5"+
		"\2\2$\5\3\2\2\2%&\7\6\2\2&(\7\f\2\2\')\5\b\5\2(\'\3\2\2\2()\3\2\2\2)+"+
		"\3\2\2\2*,\5\n\6\2+*\3\2\2\2+,\3\2\2\2,\7\3\2\2\2-.\7\7\2\2./\7\f\2\2"+
		"/\t\3\2\2\2\60\64\7\4\2\2\61\63\5\f\7\2\62\61\3\2\2\2\63\66\3\2\2\2\64"+
		"\62\3\2\2\2\64\65\3\2\2\2\65\67\3\2\2\2\66\64\3\2\2\2\67:\7\5\2\28:\5"+
		"\f\7\29\60\3\2\2\298\3\2\2\2:\13\3\2\2\2;<\7\f\2\2<=\7\b\2\2=>\7\f\2\2"+
		">\r\3\2\2\2?@\7\f\2\2@A\7\t\2\2AB\7\f\2\2B\17\3\2\2\2\t\23\36 (+\649";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}