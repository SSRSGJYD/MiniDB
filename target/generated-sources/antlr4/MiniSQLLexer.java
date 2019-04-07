// Generated from MiniSQL.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MiniSQLLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, TABLENAME=6, ATTRNAME=7, TYPE=8, 
		WS=9;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "TABLENAME", "ATTRNAME", "TYPE", 
			"WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'create table'", "'('", "')'", "' '", "'primary key'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, "TABLENAME", "ATTRNAME", "TYPE", 
			"WS"
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


	public MiniSQLLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "MiniSQL.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\13_\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\6\7\66\n\7\r\7\16\7"+
		"\67\3\b\6\b;\n\b\r\b\16\b<\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\tW\n\t\3\n\6\n"+
		"Z\n\n\r\n\16\n[\3\n\3\n\2\2\13\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13"+
		"\3\2\4\3\2c|\5\2\13\f\17\17\"\"\2e\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2"+
		"\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3"+
		"\2\2\2\3\25\3\2\2\2\5\"\3\2\2\2\7$\3\2\2\2\t&\3\2\2\2\13(\3\2\2\2\r\65"+
		"\3\2\2\2\17:\3\2\2\2\21V\3\2\2\2\23Y\3\2\2\2\25\26\7e\2\2\26\27\7t\2\2"+
		"\27\30\7g\2\2\30\31\7c\2\2\31\32\7v\2\2\32\33\7g\2\2\33\34\7\"\2\2\34"+
		"\35\7v\2\2\35\36\7c\2\2\36\37\7d\2\2\37 \7n\2\2 !\7g\2\2!\4\3\2\2\2\""+
		"#\7*\2\2#\6\3\2\2\2$%\7+\2\2%\b\3\2\2\2&\'\7\"\2\2\'\n\3\2\2\2()\7r\2"+
		"\2)*\7t\2\2*+\7k\2\2+,\7o\2\2,-\7c\2\2-.\7t\2\2./\7{\2\2/\60\7\"\2\2\60"+
		"\61\7m\2\2\61\62\7g\2\2\62\63\7{\2\2\63\f\3\2\2\2\64\66\t\2\2\2\65\64"+
		"\3\2\2\2\66\67\3\2\2\2\67\65\3\2\2\2\678\3\2\2\28\16\3\2\2\29;\t\2\2\2"+
		":9\3\2\2\2;<\3\2\2\2<:\3\2\2\2<=\3\2\2\2=\20\3\2\2\2>?\7k\2\2?@\7p\2\2"+
		"@W\7v\2\2AB\7n\2\2BC\7q\2\2CD\7p\2\2DW\7i\2\2EF\7h\2\2FG\7n\2\2GH\7q\2"+
		"\2HI\7c\2\2IW\7v\2\2JK\7f\2\2KL\7q\2\2LM\7w\2\2MN\7d\2\2NO\7n\2\2OW\7"+
		"g\2\2PQ\7u\2\2QR\7v\2\2RS\7t\2\2ST\7k\2\2TU\7p\2\2UW\7i\2\2V>\3\2\2\2"+
		"VA\3\2\2\2VE\3\2\2\2VJ\3\2\2\2VP\3\2\2\2W\22\3\2\2\2XZ\t\3\2\2YX\3\2\2"+
		"\2Z[\3\2\2\2[Y\3\2\2\2[\\\3\2\2\2\\]\3\2\2\2]^\b\n\2\2^\24\3\2\2\2\7\2"+
		"\67<V[\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}