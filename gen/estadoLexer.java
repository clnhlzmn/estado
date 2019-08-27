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
		T__0=1, T__1=2, T__2=3, T__3=4, NATURAL=5, TEXT=6, ID=7, WHITESPACE=8, 
		COMMENT=9;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "NATURAL", "TEXT", "EscapeSequence", 
			"HexDigit", "HexEscape", "UnicodeEscape", "ID", "WHITESPACE", "COMMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'state'", "'{'", "'}'", "'on'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, "NATURAL", "TEXT", "ID", "WHITESPACE", 
			"COMMENT"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\13~\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4"+
		"\3\5\3\5\3\5\3\6\6\6,\n\6\r\6\16\6-\3\7\3\7\3\7\7\7\63\n\7\f\7\16\7\66"+
		"\13\7\3\7\3\7\3\b\3\b\3\b\3\b\5\b>\n\b\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\5\13Y\n\13\3\f\3\f\7\f]\n\f\f\f\16\f`\13\f\3\f\3\f\6\f"+
		"d\n\f\r\f\16\fe\3\f\5\fi\n\f\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\7\16"+
		"s\n\16\f\16\16\16v\13\16\3\16\5\16y\n\16\3\16\3\16\3\16\3\16\2\2\17\3"+
		"\3\5\4\7\5\t\6\13\7\r\b\17\2\21\2\23\2\25\2\27\t\31\n\33\13\3\2\n\4\2"+
		"$$^^\t\2$$^^ddhhppttvv\5\2\62;CHch\5\2C\\aac|\6\2\62;C\\aac|\3\2bb\5\2"+
		"\13\f\16\17\"\"\4\2\f\f\17\17\2\u0084\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2"+
		"\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2"+
		"\33\3\2\2\2\3\35\3\2\2\2\5#\3\2\2\2\7%\3\2\2\2\t\'\3\2\2\2\13+\3\2\2\2"+
		"\r/\3\2\2\2\17=\3\2\2\2\21?\3\2\2\2\23A\3\2\2\2\25X\3\2\2\2\27h\3\2\2"+
		"\2\31j\3\2\2\2\33n\3\2\2\2\35\36\7u\2\2\36\37\7v\2\2\37 \7c\2\2 !\7v\2"+
		"\2!\"\7g\2\2\"\4\3\2\2\2#$\7}\2\2$\6\3\2\2\2%&\7\177\2\2&\b\3\2\2\2\'"+
		"(\7q\2\2()\7p\2\2)\n\3\2\2\2*,\4\62;\2+*\3\2\2\2,-\3\2\2\2-+\3\2\2\2-"+
		".\3\2\2\2.\f\3\2\2\2/\64\7$\2\2\60\63\5\17\b\2\61\63\n\2\2\2\62\60\3\2"+
		"\2\2\62\61\3\2\2\2\63\66\3\2\2\2\64\62\3\2\2\2\64\65\3\2\2\2\65\67\3\2"+
		"\2\2\66\64\3\2\2\2\678\7$\2\28\16\3\2\2\29:\7^\2\2:>\t\3\2\2;>\5\23\n"+
		"\2<>\5\25\13\2=9\3\2\2\2=;\3\2\2\2=<\3\2\2\2>\20\3\2\2\2?@\t\4\2\2@\22"+
		"\3\2\2\2AB\7^\2\2BC\7z\2\2CD\5\21\t\2DE\5\21\t\2E\24\3\2\2\2FG\7^\2\2"+
		"GH\7w\2\2HI\5\21\t\2IJ\5\21\t\2JK\5\21\t\2KL\5\21\t\2LY\3\2\2\2MN\7^\2"+
		"\2NO\7w\2\2OP\5\21\t\2PQ\5\21\t\2QR\5\21\t\2RS\5\21\t\2ST\5\21\t\2TU\5"+
		"\21\t\2UV\5\21\t\2VW\5\21\t\2WY\3\2\2\2XF\3\2\2\2XM\3\2\2\2Y\26\3\2\2"+
		"\2Z^\t\5\2\2[]\t\6\2\2\\[\3\2\2\2]`\3\2\2\2^\\\3\2\2\2^_\3\2\2\2_i\3\2"+
		"\2\2`^\3\2\2\2ac\7b\2\2bd\n\7\2\2cb\3\2\2\2de\3\2\2\2ec\3\2\2\2ef\3\2"+
		"\2\2fg\3\2\2\2gi\7b\2\2hZ\3\2\2\2ha\3\2\2\2i\30\3\2\2\2jk\t\b\2\2kl\3"+
		"\2\2\2lm\b\r\2\2m\32\3\2\2\2no\7\61\2\2op\7\61\2\2pt\3\2\2\2qs\n\t\2\2"+
		"rq\3\2\2\2sv\3\2\2\2tr\3\2\2\2tu\3\2\2\2ux\3\2\2\2vt\3\2\2\2wy\7\17\2"+
		"\2xw\3\2\2\2xy\3\2\2\2yz\3\2\2\2z{\7\f\2\2{|\3\2\2\2|}\b\16\2\2}\34\3"+
		"\2\2\2\r\2-\62\64=X^ehtx\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}