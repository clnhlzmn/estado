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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, NATURAL=7, TEXT=8, ID=9, 
		WHITESPACE=10, COMMENT=11;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "NATURAL", "TEXT", "EscapeSequence", 
			"HexDigit", "HexEscape", "UnicodeEscape", "ID", "WHITESPACE", "COMMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'state'", "'{'", "'}'", "'on'", "'->'", "'<-'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, "NATURAL", "TEXT", "ID", "WHITESPACE", 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\r\u0088\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7\3\b\6\b\66"+
		"\n\b\r\b\16\b\67\3\t\3\t\3\t\7\t=\n\t\f\t\16\t@\13\t\3\t\3\t\3\n\3\n\3"+
		"\n\3\n\5\nH\n\n\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\rc\n\r\3\16\3\16\7"+
		"\16g\n\16\f\16\16\16j\13\16\3\16\3\16\6\16n\n\16\r\16\16\16o\3\16\5\16"+
		"s\n\16\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\7\20}\n\20\f\20\16\20\u0080"+
		"\13\20\3\20\5\20\u0083\n\20\3\20\3\20\3\20\3\20\2\2\21\3\3\5\4\7\5\t\6"+
		"\13\7\r\b\17\t\21\n\23\2\25\2\27\2\31\2\33\13\35\f\37\r\3\2\n\4\2$$^^"+
		"\t\2$$^^ddhhppttvv\5\2\62;CHch\5\2C\\aac|\6\2\62;C\\aac|\3\2bb\5\2\13"+
		"\f\16\17\"\"\4\2\f\f\17\17\2\u008e\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2"+
		"\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\33\3"+
		"\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\3!\3\2\2\2\5\'\3\2\2\2\7)\3\2\2\2\t+"+
		"\3\2\2\2\13.\3\2\2\2\r\61\3\2\2\2\17\65\3\2\2\2\219\3\2\2\2\23G\3\2\2"+
		"\2\25I\3\2\2\2\27K\3\2\2\2\31b\3\2\2\2\33r\3\2\2\2\35t\3\2\2\2\37x\3\2"+
		"\2\2!\"\7u\2\2\"#\7v\2\2#$\7c\2\2$%\7v\2\2%&\7g\2\2&\4\3\2\2\2\'(\7}\2"+
		"\2(\6\3\2\2\2)*\7\177\2\2*\b\3\2\2\2+,\7q\2\2,-\7p\2\2-\n\3\2\2\2./\7"+
		"/\2\2/\60\7@\2\2\60\f\3\2\2\2\61\62\7>\2\2\62\63\7/\2\2\63\16\3\2\2\2"+
		"\64\66\4\62;\2\65\64\3\2\2\2\66\67\3\2\2\2\67\65\3\2\2\2\678\3\2\2\28"+
		"\20\3\2\2\29>\7$\2\2:=\5\23\n\2;=\n\2\2\2<:\3\2\2\2<;\3\2\2\2=@\3\2\2"+
		"\2><\3\2\2\2>?\3\2\2\2?A\3\2\2\2@>\3\2\2\2AB\7$\2\2B\22\3\2\2\2CD\7^\2"+
		"\2DH\t\3\2\2EH\5\27\f\2FH\5\31\r\2GC\3\2\2\2GE\3\2\2\2GF\3\2\2\2H\24\3"+
		"\2\2\2IJ\t\4\2\2J\26\3\2\2\2KL\7^\2\2LM\7z\2\2MN\5\25\13\2NO\5\25\13\2"+
		"O\30\3\2\2\2PQ\7^\2\2QR\7w\2\2RS\5\25\13\2ST\5\25\13\2TU\5\25\13\2UV\5"+
		"\25\13\2Vc\3\2\2\2WX\7^\2\2XY\7w\2\2YZ\5\25\13\2Z[\5\25\13\2[\\\5\25\13"+
		"\2\\]\5\25\13\2]^\5\25\13\2^_\5\25\13\2_`\5\25\13\2`a\5\25\13\2ac\3\2"+
		"\2\2bP\3\2\2\2bW\3\2\2\2c\32\3\2\2\2dh\t\5\2\2eg\t\6\2\2fe\3\2\2\2gj\3"+
		"\2\2\2hf\3\2\2\2hi\3\2\2\2is\3\2\2\2jh\3\2\2\2km\7b\2\2ln\n\7\2\2ml\3"+
		"\2\2\2no\3\2\2\2om\3\2\2\2op\3\2\2\2pq\3\2\2\2qs\7b\2\2rd\3\2\2\2rk\3"+
		"\2\2\2s\34\3\2\2\2tu\t\b\2\2uv\3\2\2\2vw\b\17\2\2w\36\3\2\2\2xy\7\61\2"+
		"\2yz\7\61\2\2z~\3\2\2\2{}\n\t\2\2|{\3\2\2\2}\u0080\3\2\2\2~|\3\2\2\2~"+
		"\177\3\2\2\2\177\u0082\3\2\2\2\u0080~\3\2\2\2\u0081\u0083\7\17\2\2\u0082"+
		"\u0081\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0085\7\f"+
		"\2\2\u0085\u0086\3\2\2\2\u0086\u0087\b\20\2\2\u0087 \3\2\2\2\r\2\67<>"+
		"Gbhor~\u0082\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}