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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, NATURAL=6, TEXT=7, ID=8, WHITESPACE=9, 
		COMMENT=10;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "NATURAL", "TEXT", "EscapeSequence", 
			"HexDigit", "HexEscape", "UnicodeEscape", "ID", "WHITESPACE", "COMMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'state'", "'{'", "'}'", "'on'", "'->'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, "NATURAL", "TEXT", "ID", "WHITESPACE", 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\f\u0083\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\2\3\2\3\2\3\2\3\3"+
		"\3\3\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3\7\6\7\61\n\7\r\7\16\7\62\3\b\3"+
		"\b\3\b\7\b8\n\b\f\b\16\b;\13\b\3\b\3\b\3\t\3\t\3\t\3\t\5\tC\n\t\3\n\3"+
		"\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f^\n\f\3\r\3\r\7\rb\n\r\f\r\16\re\13"+
		"\r\3\r\3\r\6\ri\n\r\r\r\16\rj\3\r\5\rn\n\r\3\16\3\16\3\16\3\16\3\17\3"+
		"\17\3\17\3\17\7\17x\n\17\f\17\16\17{\13\17\3\17\5\17~\n\17\3\17\3\17\3"+
		"\17\3\17\2\2\20\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\2\23\2\25\2\27\2\31\n"+
		"\33\13\35\f\3\2\n\4\2$$^^\t\2$$^^ddhhppttvv\5\2\62;CHch\5\2C\\aac|\6\2"+
		"\62;C\\aac|\3\2bb\5\2\13\f\16\17\"\"\4\2\f\f\17\17\2\u0089\2\3\3\2\2\2"+
		"\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2"+
		"\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\3\37\3\2\2\2\5%\3\2\2\2\7"+
		"\'\3\2\2\2\t)\3\2\2\2\13,\3\2\2\2\r\60\3\2\2\2\17\64\3\2\2\2\21B\3\2\2"+
		"\2\23D\3\2\2\2\25F\3\2\2\2\27]\3\2\2\2\31m\3\2\2\2\33o\3\2\2\2\35s\3\2"+
		"\2\2\37 \7u\2\2 !\7v\2\2!\"\7c\2\2\"#\7v\2\2#$\7g\2\2$\4\3\2\2\2%&\7}"+
		"\2\2&\6\3\2\2\2\'(\7\177\2\2(\b\3\2\2\2)*\7q\2\2*+\7p\2\2+\n\3\2\2\2,"+
		"-\7/\2\2-.\7@\2\2.\f\3\2\2\2/\61\4\62;\2\60/\3\2\2\2\61\62\3\2\2\2\62"+
		"\60\3\2\2\2\62\63\3\2\2\2\63\16\3\2\2\2\649\7$\2\2\658\5\21\t\2\668\n"+
		"\2\2\2\67\65\3\2\2\2\67\66\3\2\2\28;\3\2\2\29\67\3\2\2\29:\3\2\2\2:<\3"+
		"\2\2\2;9\3\2\2\2<=\7$\2\2=\20\3\2\2\2>?\7^\2\2?C\t\3\2\2@C\5\25\13\2A"+
		"C\5\27\f\2B>\3\2\2\2B@\3\2\2\2BA\3\2\2\2C\22\3\2\2\2DE\t\4\2\2E\24\3\2"+
		"\2\2FG\7^\2\2GH\7z\2\2HI\5\23\n\2IJ\5\23\n\2J\26\3\2\2\2KL\7^\2\2LM\7"+
		"w\2\2MN\5\23\n\2NO\5\23\n\2OP\5\23\n\2PQ\5\23\n\2Q^\3\2\2\2RS\7^\2\2S"+
		"T\7w\2\2TU\5\23\n\2UV\5\23\n\2VW\5\23\n\2WX\5\23\n\2XY\5\23\n\2YZ\5\23"+
		"\n\2Z[\5\23\n\2[\\\5\23\n\2\\^\3\2\2\2]K\3\2\2\2]R\3\2\2\2^\30\3\2\2\2"+
		"_c\t\5\2\2`b\t\6\2\2a`\3\2\2\2be\3\2\2\2ca\3\2\2\2cd\3\2\2\2dn\3\2\2\2"+
		"ec\3\2\2\2fh\7b\2\2gi\n\7\2\2hg\3\2\2\2ij\3\2\2\2jh\3\2\2\2jk\3\2\2\2"+
		"kl\3\2\2\2ln\7b\2\2m_\3\2\2\2mf\3\2\2\2n\32\3\2\2\2op\t\b\2\2pq\3\2\2"+
		"\2qr\b\16\2\2r\34\3\2\2\2st\7\61\2\2tu\7\61\2\2uy\3\2\2\2vx\n\t\2\2wv"+
		"\3\2\2\2x{\3\2\2\2yw\3\2\2\2yz\3\2\2\2z}\3\2\2\2{y\3\2\2\2|~\7\17\2\2"+
		"}|\3\2\2\2}~\3\2\2\2~\177\3\2\2\2\177\u0080\7\f\2\2\u0080\u0081\3\2\2"+
		"\2\u0081\u0082\b\17\2\2\u0082\36\3\2\2\2\r\2\62\679B]cjmy}\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}