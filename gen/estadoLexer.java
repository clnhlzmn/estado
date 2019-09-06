// Generated from C:/code/estado/src\estado.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class estadoLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, NATURAL=8, TEXT=9, 
		ID=10, WHITESPACE=11, COMMENT=12;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "NATURAL", "TEXT", 
			"EscapeSequence", "HexDigit", "HexEscape", "UnicodeEscape", "ID", "WHITESPACE", 
			"COMMENT"
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


	public estadoLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "estado.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\16\u008c\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7"+
		"\3\b\3\b\3\t\6\t:\n\t\r\t\16\t;\3\n\3\n\3\n\7\nA\n\n\f\n\16\nD\13\n\3"+
		"\n\3\n\3\13\3\13\3\13\3\13\5\13L\n\13\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\5\16g\n\16\3\17\3\17\7\17k\n\17\f\17\16\17n\13\17\3\17"+
		"\3\17\6\17r\n\17\r\17\16\17s\3\17\5\17w\n\17\3\20\3\20\3\20\3\20\3\21"+
		"\3\21\3\21\3\21\7\21\u0081\n\21\f\21\16\21\u0084\13\21\3\21\5\21\u0087"+
		"\n\21\3\21\3\21\3\21\3\21\2\2\22\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23"+
		"\13\25\2\27\2\31\2\33\2\35\f\37\r!\16\3\2\n\4\2$$^^\t\2$$^^ddhhppttvv"+
		"\5\2\62;CHch\5\2C\\aac|\6\2\62;C\\aac|\3\2bb\5\2\13\f\16\17\"\"\4\2\f"+
		"\f\17\17\2\u0092\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13"+
		"\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\35\3\2\2"+
		"\2\2\37\3\2\2\2\2!\3\2\2\2\3#\3\2\2\2\5)\3\2\2\2\7+\3\2\2\2\t-\3\2\2\2"+
		"\13\60\3\2\2\2\r\63\3\2\2\2\17\66\3\2\2\2\219\3\2\2\2\23=\3\2\2\2\25K"+
		"\3\2\2\2\27M\3\2\2\2\31O\3\2\2\2\33f\3\2\2\2\35v\3\2\2\2\37x\3\2\2\2!"+
		"|\3\2\2\2#$\7u\2\2$%\7v\2\2%&\7c\2\2&\'\7v\2\2\'(\7g\2\2(\4\3\2\2\2)*"+
		"\7}\2\2*\6\3\2\2\2+,\7\177\2\2,\b\3\2\2\2-.\7q\2\2./\7p\2\2/\n\3\2\2\2"+
		"\60\61\7/\2\2\61\62\7@\2\2\62\f\3\2\2\2\63\64\7>\2\2\64\65\7/\2\2\65\16"+
		"\3\2\2\2\66\67\7<\2\2\67\20\3\2\2\28:\4\62;\298\3\2\2\2:;\3\2\2\2;9\3"+
		"\2\2\2;<\3\2\2\2<\22\3\2\2\2=B\7$\2\2>A\5\25\13\2?A\n\2\2\2@>\3\2\2\2"+
		"@?\3\2\2\2AD\3\2\2\2B@\3\2\2\2BC\3\2\2\2CE\3\2\2\2DB\3\2\2\2EF\7$\2\2"+
		"F\24\3\2\2\2GH\7^\2\2HL\t\3\2\2IL\5\31\r\2JL\5\33\16\2KG\3\2\2\2KI\3\2"+
		"\2\2KJ\3\2\2\2L\26\3\2\2\2MN\t\4\2\2N\30\3\2\2\2OP\7^\2\2PQ\7z\2\2QR\5"+
		"\27\f\2RS\5\27\f\2S\32\3\2\2\2TU\7^\2\2UV\7w\2\2VW\5\27\f\2WX\5\27\f\2"+
		"XY\5\27\f\2YZ\5\27\f\2Zg\3\2\2\2[\\\7^\2\2\\]\7w\2\2]^\5\27\f\2^_\5\27"+
		"\f\2_`\5\27\f\2`a\5\27\f\2ab\5\27\f\2bc\5\27\f\2cd\5\27\f\2de\5\27\f\2"+
		"eg\3\2\2\2fT\3\2\2\2f[\3\2\2\2g\34\3\2\2\2hl\t\5\2\2ik\t\6\2\2ji\3\2\2"+
		"\2kn\3\2\2\2lj\3\2\2\2lm\3\2\2\2mw\3\2\2\2nl\3\2\2\2oq\7b\2\2pr\n\7\2"+
		"\2qp\3\2\2\2rs\3\2\2\2sq\3\2\2\2st\3\2\2\2tu\3\2\2\2uw\7b\2\2vh\3\2\2"+
		"\2vo\3\2\2\2w\36\3\2\2\2xy\t\b\2\2yz\3\2\2\2z{\b\20\2\2{ \3\2\2\2|}\7"+
		"\61\2\2}~\7\61\2\2~\u0082\3\2\2\2\177\u0081\n\t\2\2\u0080\177\3\2\2\2"+
		"\u0081\u0084\3\2\2\2\u0082\u0080\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0086"+
		"\3\2\2\2\u0084\u0082\3\2\2\2\u0085\u0087\7\17\2\2\u0086\u0085\3\2\2\2"+
		"\u0086\u0087\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u0089\7\f\2\2\u0089\u008a"+
		"\3\2\2\2\u008a\u008b\b\21\2\2\u008b\"\3\2\2\2\r\2;@BKflsv\u0082\u0086"+
		"\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}