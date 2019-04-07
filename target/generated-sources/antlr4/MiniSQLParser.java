// Generated from MiniSQL.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MiniSQLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, TABLENAME=6, ATTRNAME=7, TYPE=8, 
		WS=9;
	public static final int
		RULE_sql = 0, RULE_schema = 1, RULE_attribute = 2, RULE_constraint = 3;
	private static String[] makeRuleNames() {
		return new String[] {
			"sql", "schema", "attribute", "constraint"
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

	@Override
	public String getGrammarFileName() { return "MiniSQL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MiniSQLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class SqlContext extends ParserRuleContext {
		public SqlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sql; }
	 
		public SqlContext() { }
		public void copyFrom(SqlContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class CreateContext extends SqlContext {
		public TerminalNode TABLENAME() { return getToken(MiniSQLParser.TABLENAME, 0); }
		public SchemaContext schema() {
			return getRuleContext(SchemaContext.class,0);
		}
		public CreateContext(SqlContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniSQLListener ) ((MiniSQLListener)listener).enterCreate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniSQLListener ) ((MiniSQLListener)listener).exitCreate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniSQLVisitor ) return ((MiniSQLVisitor<? extends T>)visitor).visitCreate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SqlContext sql() throws RecognitionException {
		SqlContext _localctx = new SqlContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_sql);
		try {
			_localctx = new CreateContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(8);
			match(T__0);
			setState(9);
			match(TABLENAME);
			setState(10);
			match(T__1);
			setState(11);
			schema();
			setState(12);
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

	public static class SchemaContext extends ParserRuleContext {
		public AttributeContext attribute() {
			return getRuleContext(AttributeContext.class,0);
		}
		public SchemaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_schema; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniSQLListener ) ((MiniSQLListener)listener).enterSchema(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniSQLListener ) ((MiniSQLListener)listener).exitSchema(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniSQLVisitor ) return ((MiniSQLVisitor<? extends T>)visitor).visitSchema(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SchemaContext schema() throws RecognitionException {
		SchemaContext _localctx = new SchemaContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_schema);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(14);
			attribute();
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

	public static class AttributeContext extends ParserRuleContext {
		public AttributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attribute; }
	 
		public AttributeContext() { }
		public void copyFrom(AttributeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class NormalattrContext extends AttributeContext {
		public TerminalNode ATTRNAME() { return getToken(MiniSQLParser.ATTRNAME, 0); }
		public TerminalNode TYPE() { return getToken(MiniSQLParser.TYPE, 0); }
		public NormalattrContext(AttributeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniSQLListener ) ((MiniSQLListener)listener).enterNormalattr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniSQLListener ) ((MiniSQLListener)listener).exitNormalattr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniSQLVisitor ) return ((MiniSQLVisitor<? extends T>)visitor).visitNormalattr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributeContext attribute() throws RecognitionException {
		AttributeContext _localctx = new AttributeContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_attribute);
		try {
			_localctx = new NormalattrContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(16);
			match(ATTRNAME);
			setState(17);
			match(T__3);
			setState(18);
			match(TYPE);
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

	public static class ConstraintContext extends ParserRuleContext {
		public ConstraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constraint; }
	 
		public ConstraintContext() { }
		public void copyFrom(ConstraintContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PrimarykeyContext extends ConstraintContext {
		public TerminalNode ATTRNAME() { return getToken(MiniSQLParser.ATTRNAME, 0); }
		public PrimarykeyContext(ConstraintContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniSQLListener ) ((MiniSQLListener)listener).enterPrimarykey(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniSQLListener ) ((MiniSQLListener)listener).exitPrimarykey(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniSQLVisitor ) return ((MiniSQLVisitor<? extends T>)visitor).visitPrimarykey(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstraintContext constraint() throws RecognitionException {
		ConstraintContext _localctx = new ConstraintContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_constraint);
		try {
			_localctx = new PrimarykeyContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(20);
			match(T__4);
			setState(21);
			match(T__1);
			setState(22);
			match(ATTRNAME);
			setState(23);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\13\34\4\2\t\2\4\3"+
		"\t\3\4\4\t\4\4\5\t\5\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\2\2\6\2\4\6\b\2\2\2\27\2\n\3\2\2\2\4\20\3\2\2\2"+
		"\6\22\3\2\2\2\b\26\3\2\2\2\n\13\7\3\2\2\13\f\7\b\2\2\f\r\7\4\2\2\r\16"+
		"\5\4\3\2\16\17\7\5\2\2\17\3\3\2\2\2\20\21\5\6\4\2\21\5\3\2\2\2\22\23\7"+
		"\t\2\2\23\24\7\6\2\2\24\25\7\n\2\2\25\7\3\2\2\2\26\27\7\7\2\2\27\30\7"+
		"\4\2\2\30\31\7\t\2\2\31\32\7\5\2\2\32\t\3\2\2\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}