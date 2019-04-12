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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, Name=30, Number=31, 
		String=32, NEWLINE=33, WS=34;
	public static final int
		RULE_type = 0, RULE_op = 1, RULE_value = 2, RULE_sql = 3, RULE_condition = 4, 
		RULE_set = 5, RULE_names = 6, RULE_cname = 7, RULE_cnames = 8, RULE_onCondition = 9, 
		RULE_jnames = 10, RULE_values = 11, RULE_schema = 12, RULE_attribute = 13, 
		RULE_constraint = 14;
	private static String[] makeRuleNames() {
		return new String[] {
			"type", "op", "value", "sql", "condition", "set", "names", "cname", "cnames", 
			"onCondition", "jnames", "values", "schema", "attribute", "constraint"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'int'", "'long'", "'float'", "'double'", "'char'", "'('", "')'", 
			"'='", "'>'", "'<'", "'>='", "'<='", "'<>'", "'create table'", "'drop table'", 
			"'insert into'", "'values'", "'delete from'", "'where'", "'update'", 
			"'set'", "'select'", "'from'", "','", "'.'", "'join'", "'on'", "'not null'", 
			"'primary key'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, "Name", "Number", "String", "NEWLINE", 
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

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode Number() { return getToken(MiniSQLParser.Number, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniSQLListener ) ((MiniSQLListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniSQLListener ) ((MiniSQLListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniSQLVisitor ) return ((MiniSQLVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_type);
		try {
			setState(38);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(30);
				match(T__0);
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				setState(31);
				match(T__1);
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 3);
				{
				setState(32);
				match(T__2);
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 4);
				{
				setState(33);
				match(T__3);
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 5);
				{
				setState(34);
				match(T__4);
				setState(35);
				match(T__5);
				setState(36);
				match(Number);
				setState(37);
				match(T__6);
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

	public static class OpContext extends ParserRuleContext {
		public OpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniSQLListener ) ((MiniSQLListener)listener).enterOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniSQLListener ) ((MiniSQLListener)listener).exitOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniSQLVisitor ) return ((MiniSQLVisitor<? extends T>)visitor).visitOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OpContext op() throws RecognitionException {
		OpContext _localctx = new OpContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class ValueContext extends ParserRuleContext {
		public TerminalNode Number() { return getToken(MiniSQLParser.Number, 0); }
		public TerminalNode String() { return getToken(MiniSQLParser.String, 0); }
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniSQLListener ) ((MiniSQLListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniSQLListener ) ((MiniSQLListener)listener).exitValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniSQLVisitor ) return ((MiniSQLVisitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			_la = _input.LA(1);
			if ( !(_la==Number || _la==String) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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
	public static class DropContext extends SqlContext {
		public TerminalNode Name() { return getToken(MiniSQLParser.Name, 0); }
		public DropContext(SqlContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniSQLListener ) ((MiniSQLListener)listener).enterDrop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniSQLListener ) ((MiniSQLListener)listener).exitDrop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniSQLVisitor ) return ((MiniSQLVisitor<? extends T>)visitor).visitDrop(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SelectBContext extends SqlContext {
		public CnamesContext cnames() {
			return getRuleContext(CnamesContext.class,0);
		}
		public JnamesContext jnames() {
			return getRuleContext(JnamesContext.class,0);
		}
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public SelectBContext(SqlContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniSQLListener ) ((MiniSQLListener)listener).enterSelectB(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniSQLListener ) ((MiniSQLListener)listener).exitSelectB(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniSQLVisitor ) return ((MiniSQLVisitor<? extends T>)visitor).visitSelectB(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SelectAContext extends SqlContext {
		public NamesContext names() {
			return getRuleContext(NamesContext.class,0);
		}
		public TerminalNode Name() { return getToken(MiniSQLParser.Name, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public SelectAContext(SqlContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniSQLListener ) ((MiniSQLListener)listener).enterSelectA(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniSQLListener ) ((MiniSQLListener)listener).exitSelectA(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniSQLVisitor ) return ((MiniSQLVisitor<? extends T>)visitor).visitSelectA(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NewlineContext extends SqlContext {
		public TerminalNode NEWLINE() { return getToken(MiniSQLParser.NEWLINE, 0); }
		public NewlineContext(SqlContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniSQLListener ) ((MiniSQLListener)listener).enterNewline(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniSQLListener ) ((MiniSQLListener)listener).exitNewline(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniSQLVisitor ) return ((MiniSQLVisitor<? extends T>)visitor).visitNewline(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CreateContext extends SqlContext {
		public TerminalNode Name() { return getToken(MiniSQLParser.Name, 0); }
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
	public static class UpdateContext extends SqlContext {
		public TerminalNode Name() { return getToken(MiniSQLParser.Name, 0); }
		public SetContext set() {
			return getRuleContext(SetContext.class,0);
		}
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public UpdateContext(SqlContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniSQLListener ) ((MiniSQLListener)listener).enterUpdate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniSQLListener ) ((MiniSQLListener)listener).exitUpdate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniSQLVisitor ) return ((MiniSQLVisitor<? extends T>)visitor).visitUpdate(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DeleteContext extends SqlContext {
		public TerminalNode Name() { return getToken(MiniSQLParser.Name, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public DeleteContext(SqlContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniSQLListener ) ((MiniSQLListener)listener).enterDelete(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniSQLListener ) ((MiniSQLListener)listener).exitDelete(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniSQLVisitor ) return ((MiniSQLVisitor<? extends T>)visitor).visitDelete(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InsertBContext extends SqlContext {
		public TerminalNode Name() { return getToken(MiniSQLParser.Name, 0); }
		public NamesContext names() {
			return getRuleContext(NamesContext.class,0);
		}
		public ValuesContext values() {
			return getRuleContext(ValuesContext.class,0);
		}
		public InsertBContext(SqlContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniSQLListener ) ((MiniSQLListener)listener).enterInsertB(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniSQLListener ) ((MiniSQLListener)listener).exitInsertB(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniSQLVisitor ) return ((MiniSQLVisitor<? extends T>)visitor).visitInsertB(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InsertAContext extends SqlContext {
		public TerminalNode Name() { return getToken(MiniSQLParser.Name, 0); }
		public ValuesContext values() {
			return getRuleContext(ValuesContext.class,0);
		}
		public InsertAContext(SqlContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniSQLListener ) ((MiniSQLListener)listener).enterInsertA(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniSQLListener ) ((MiniSQLListener)listener).exitInsertA(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniSQLVisitor ) return ((MiniSQLVisitor<? extends T>)visitor).visitInsertA(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SqlContext sql() throws RecognitionException {
		SqlContext _localctx = new SqlContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_sql);
		int _la;
		try {
			setState(97);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				_localctx = new CreateContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(44);
				match(T__13);
				setState(45);
				match(Name);
				setState(46);
				match(T__5);
				setState(47);
				schema();
				setState(48);
				match(T__6);
				}
				break;
			case 2:
				_localctx = new DropContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(50);
				match(T__14);
				setState(51);
				match(Name);
				}
				break;
			case 3:
				_localctx = new InsertAContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(52);
				match(T__15);
				setState(53);
				match(Name);
				setState(54);
				match(T__16);
				setState(55);
				match(T__5);
				setState(56);
				values();
				setState(57);
				match(T__6);
				}
				break;
			case 4:
				_localctx = new InsertBContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(59);
				match(T__15);
				setState(60);
				match(Name);
				setState(61);
				match(T__5);
				setState(62);
				names();
				setState(63);
				match(T__6);
				setState(64);
				match(T__16);
				setState(65);
				match(T__5);
				setState(66);
				values();
				setState(67);
				match(T__6);
				}
				break;
			case 5:
				_localctx = new DeleteContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(69);
				match(T__17);
				setState(70);
				match(Name);
				setState(71);
				match(T__18);
				setState(72);
				condition();
				}
				break;
			case 6:
				_localctx = new UpdateContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(73);
				match(T__19);
				setState(74);
				match(Name);
				setState(75);
				match(T__20);
				setState(76);
				set();
				setState(77);
				match(T__18);
				setState(78);
				condition();
				}
				break;
			case 7:
				_localctx = new SelectAContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(80);
				match(T__21);
				setState(81);
				names();
				setState(82);
				match(T__22);
				setState(83);
				match(Name);
				setState(86);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__18) {
					{
					setState(84);
					match(T__18);
					setState(85);
					condition();
					}
				}

				}
				break;
			case 8:
				_localctx = new SelectBContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(88);
				match(T__21);
				setState(89);
				cnames();
				setState(90);
				match(T__22);
				setState(91);
				jnames();
				setState(94);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__18) {
					{
					setState(92);
					match(T__18);
					setState(93);
					condition();
					}
				}

				}
				break;
			case 9:
				_localctx = new NewlineContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(96);
				match(NEWLINE);
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

	public static class ConditionContext extends ParserRuleContext {
		public TerminalNode Name() { return getToken(MiniSQLParser.Name, 0); }
		public OpContext op() {
			return getRuleContext(OpContext.class,0);
		}
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniSQLListener ) ((MiniSQLListener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniSQLListener ) ((MiniSQLListener)listener).exitCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniSQLVisitor ) return ((MiniSQLVisitor<? extends T>)visitor).visitCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			match(Name);
			setState(100);
			op();
			setState(101);
			value();
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

	public static class SetContext extends ParserRuleContext {
		public TerminalNode Name() { return getToken(MiniSQLParser.Name, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public SetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_set; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniSQLListener ) ((MiniSQLListener)listener).enterSet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniSQLListener ) ((MiniSQLListener)listener).exitSet(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniSQLVisitor ) return ((MiniSQLVisitor<? extends T>)visitor).visitSet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SetContext set() throws RecognitionException {
		SetContext _localctx = new SetContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_set);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			match(Name);
			setState(104);
			match(T__7);
			setState(105);
			value();
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

	public static class NamesContext extends ParserRuleContext {
		public List<TerminalNode> Name() { return getTokens(MiniSQLParser.Name); }
		public TerminalNode Name(int i) {
			return getToken(MiniSQLParser.Name, i);
		}
		public NamesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_names; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniSQLListener ) ((MiniSQLListener)listener).enterNames(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniSQLListener ) ((MiniSQLListener)listener).exitNames(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniSQLVisitor ) return ((MiniSQLVisitor<? extends T>)visitor).visitNames(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NamesContext names() throws RecognitionException {
		NamesContext _localctx = new NamesContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_names);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			match(Name);
			setState(112);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__23) {
				{
				{
				setState(108);
				match(T__23);
				setState(109);
				match(Name);
				}
				}
				setState(114);
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

	public static class CnameContext extends ParserRuleContext {
		public List<TerminalNode> Name() { return getTokens(MiniSQLParser.Name); }
		public TerminalNode Name(int i) {
			return getToken(MiniSQLParser.Name, i);
		}
		public CnameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cname; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniSQLListener ) ((MiniSQLListener)listener).enterCname(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniSQLListener ) ((MiniSQLListener)listener).exitCname(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniSQLVisitor ) return ((MiniSQLVisitor<? extends T>)visitor).visitCname(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CnameContext cname() throws RecognitionException {
		CnameContext _localctx = new CnameContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_cname);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			match(Name);
			setState(116);
			match(T__24);
			setState(117);
			match(Name);
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

	public static class CnamesContext extends ParserRuleContext {
		public List<CnameContext> cname() {
			return getRuleContexts(CnameContext.class);
		}
		public CnameContext cname(int i) {
			return getRuleContext(CnameContext.class,i);
		}
		public CnamesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cnames; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniSQLListener ) ((MiniSQLListener)listener).enterCnames(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniSQLListener ) ((MiniSQLListener)listener).exitCnames(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniSQLVisitor ) return ((MiniSQLVisitor<? extends T>)visitor).visitCnames(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CnamesContext cnames() throws RecognitionException {
		CnamesContext _localctx = new CnamesContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_cnames);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			cname();
			setState(124);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__23) {
				{
				{
				setState(120);
				match(T__23);
				setState(121);
				cname();
				}
				}
				setState(126);
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

	public static class OnConditionContext extends ParserRuleContext {
		public List<CnameContext> cname() {
			return getRuleContexts(CnameContext.class);
		}
		public CnameContext cname(int i) {
			return getRuleContext(CnameContext.class,i);
		}
		public OnConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_onCondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniSQLListener ) ((MiniSQLListener)listener).enterOnCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniSQLListener ) ((MiniSQLListener)listener).exitOnCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniSQLVisitor ) return ((MiniSQLVisitor<? extends T>)visitor).visitOnCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OnConditionContext onCondition() throws RecognitionException {
		OnConditionContext _localctx = new OnConditionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_onCondition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			cname();
			setState(128);
			match(T__7);
			setState(129);
			cname();
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

	public static class JnamesContext extends ParserRuleContext {
		public List<TerminalNode> Name() { return getTokens(MiniSQLParser.Name); }
		public TerminalNode Name(int i) {
			return getToken(MiniSQLParser.Name, i);
		}
		public List<OnConditionContext> onCondition() {
			return getRuleContexts(OnConditionContext.class);
		}
		public OnConditionContext onCondition(int i) {
			return getRuleContext(OnConditionContext.class,i);
		}
		public JnamesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jnames; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniSQLListener ) ((MiniSQLListener)listener).enterJnames(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniSQLListener ) ((MiniSQLListener)listener).exitJnames(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniSQLVisitor ) return ((MiniSQLVisitor<? extends T>)visitor).visitJnames(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JnamesContext jnames() throws RecognitionException {
		JnamesContext _localctx = new JnamesContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_jnames);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			match(Name);
			setState(136); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(132);
				match(T__25);
				setState(133);
				match(Name);
				setState(134);
				match(T__26);
				setState(135);
				onCondition();
				}
				}
				setState(138); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__25 );
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

	public static class ValuesContext extends ParserRuleContext {
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public ValuesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_values; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniSQLListener ) ((MiniSQLListener)listener).enterValues(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniSQLListener ) ((MiniSQLListener)listener).exitValues(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniSQLVisitor ) return ((MiniSQLVisitor<? extends T>)visitor).visitValues(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValuesContext values() throws RecognitionException {
		ValuesContext _localctx = new ValuesContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_values);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			value();
			setState(145);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__23) {
				{
				{
				setState(141);
				match(T__23);
				setState(142);
				value();
				}
				}
				setState(147);
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

	public static class SchemaContext extends ParserRuleContext {
		public SchemaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_schema; }
	 
		public SchemaContext() { }
		public void copyFrom(SchemaContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AttrconsContext extends SchemaContext {
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public List<ConstraintContext> constraint() {
			return getRuleContexts(ConstraintContext.class);
		}
		public ConstraintContext constraint(int i) {
			return getRuleContext(ConstraintContext.class,i);
		}
		public AttrconsContext(SchemaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniSQLListener ) ((MiniSQLListener)listener).enterAttrcons(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniSQLListener ) ((MiniSQLListener)listener).exitAttrcons(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniSQLVisitor ) return ((MiniSQLVisitor<? extends T>)visitor).visitAttrcons(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SchemaContext schema() throws RecognitionException {
		SchemaContext _localctx = new SchemaContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_schema);
		int _la;
		try {
			_localctx = new AttrconsContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Name:
				{
				setState(148);
				attribute();
				}
				break;
			case T__28:
				{
				setState(149);
				constraint();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(159);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__23) {
				{
				{
				setState(152);
				match(T__23);
				setState(155);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case Name:
					{
					setState(153);
					attribute();
					}
					break;
				case T__28:
					{
					setState(154);
					constraint();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				}
				setState(161);
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
		public TerminalNode Name() { return getToken(MiniSQLParser.Name, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
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
	public static class NotnullattrContext extends AttributeContext {
		public TerminalNode Name() { return getToken(MiniSQLParser.Name, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public NotnullattrContext(AttributeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniSQLListener ) ((MiniSQLListener)listener).enterNotnullattr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniSQLListener ) ((MiniSQLListener)listener).exitNotnullattr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniSQLVisitor ) return ((MiniSQLVisitor<? extends T>)visitor).visitNotnullattr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributeContext attribute() throws RecognitionException {
		AttributeContext _localctx = new AttributeContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_attribute);
		try {
			setState(168);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				_localctx = new NormalattrContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(162);
				match(Name);
				setState(163);
				type();
				}
				break;
			case 2:
				_localctx = new NotnullattrContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(164);
				match(Name);
				setState(165);
				type();
				setState(166);
				match(T__27);
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
		public TerminalNode Name() { return getToken(MiniSQLParser.Name, 0); }
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
		enterRule(_localctx, 28, RULE_constraint);
		try {
			_localctx = new PrimarykeyContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(170);
			match(T__28);
			setState(171);
			match(T__5);
			setState(172);
			match(Name);
			setState(173);
			match(T__6);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3$\u00b2\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\5\2)\n\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5"+
		"Y\n\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5a\n\5\3\5\5\5d\n\5\3\6\3\6\3\6\3\6\3"+
		"\7\3\7\3\7\3\7\3\b\3\b\3\b\7\bq\n\b\f\b\16\bt\13\b\3\t\3\t\3\t\3\t\3\n"+
		"\3\n\3\n\7\n}\n\n\f\n\16\n\u0080\13\n\3\13\3\13\3\13\3\13\3\f\3\f\3\f"+
		"\3\f\3\f\6\f\u008b\n\f\r\f\16\f\u008c\3\r\3\r\3\r\7\r\u0092\n\r\f\r\16"+
		"\r\u0095\13\r\3\16\3\16\5\16\u0099\n\16\3\16\3\16\3\16\5\16\u009e\n\16"+
		"\7\16\u00a0\n\16\f\16\16\16\u00a3\13\16\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\5\17\u00ab\n\17\3\20\3\20\3\20\3\20\3\20\3\20\2\2\21\2\4\6\b\n\f\16\20"+
		"\22\24\26\30\32\34\36\2\4\3\2\n\17\3\2!\"\2\u00b8\2(\3\2\2\2\4*\3\2\2"+
		"\2\6,\3\2\2\2\bc\3\2\2\2\ne\3\2\2\2\fi\3\2\2\2\16m\3\2\2\2\20u\3\2\2\2"+
		"\22y\3\2\2\2\24\u0081\3\2\2\2\26\u0085\3\2\2\2\30\u008e\3\2\2\2\32\u0098"+
		"\3\2\2\2\34\u00aa\3\2\2\2\36\u00ac\3\2\2\2 )\7\3\2\2!)\7\4\2\2\")\7\5"+
		"\2\2#)\7\6\2\2$%\7\7\2\2%&\7\b\2\2&\'\7!\2\2\')\7\t\2\2( \3\2\2\2(!\3"+
		"\2\2\2(\"\3\2\2\2(#\3\2\2\2($\3\2\2\2)\3\3\2\2\2*+\t\2\2\2+\5\3\2\2\2"+
		",-\t\3\2\2-\7\3\2\2\2./\7\20\2\2/\60\7 \2\2\60\61\7\b\2\2\61\62\5\32\16"+
		"\2\62\63\7\t\2\2\63d\3\2\2\2\64\65\7\21\2\2\65d\7 \2\2\66\67\7\22\2\2"+
		"\678\7 \2\289\7\23\2\29:\7\b\2\2:;\5\30\r\2;<\7\t\2\2<d\3\2\2\2=>\7\22"+
		"\2\2>?\7 \2\2?@\7\b\2\2@A\5\16\b\2AB\7\t\2\2BC\7\23\2\2CD\7\b\2\2DE\5"+
		"\30\r\2EF\7\t\2\2Fd\3\2\2\2GH\7\24\2\2HI\7 \2\2IJ\7\25\2\2Jd\5\n\6\2K"+
		"L\7\26\2\2LM\7 \2\2MN\7\27\2\2NO\5\f\7\2OP\7\25\2\2PQ\5\n\6\2Qd\3\2\2"+
		"\2RS\7\30\2\2ST\5\16\b\2TU\7\31\2\2UX\7 \2\2VW\7\25\2\2WY\5\n\6\2XV\3"+
		"\2\2\2XY\3\2\2\2Yd\3\2\2\2Z[\7\30\2\2[\\\5\22\n\2\\]\7\31\2\2]`\5\26\f"+
		"\2^_\7\25\2\2_a\5\n\6\2`^\3\2\2\2`a\3\2\2\2ad\3\2\2\2bd\7#\2\2c.\3\2\2"+
		"\2c\64\3\2\2\2c\66\3\2\2\2c=\3\2\2\2cG\3\2\2\2cK\3\2\2\2cR\3\2\2\2cZ\3"+
		"\2\2\2cb\3\2\2\2d\t\3\2\2\2ef\7 \2\2fg\5\4\3\2gh\5\6\4\2h\13\3\2\2\2i"+
		"j\7 \2\2jk\7\n\2\2kl\5\6\4\2l\r\3\2\2\2mr\7 \2\2no\7\32\2\2oq\7 \2\2p"+
		"n\3\2\2\2qt\3\2\2\2rp\3\2\2\2rs\3\2\2\2s\17\3\2\2\2tr\3\2\2\2uv\7 \2\2"+
		"vw\7\33\2\2wx\7 \2\2x\21\3\2\2\2y~\5\20\t\2z{\7\32\2\2{}\5\20\t\2|z\3"+
		"\2\2\2}\u0080\3\2\2\2~|\3\2\2\2~\177\3\2\2\2\177\23\3\2\2\2\u0080~\3\2"+
		"\2\2\u0081\u0082\5\20\t\2\u0082\u0083\7\n\2\2\u0083\u0084\5\20\t\2\u0084"+
		"\25\3\2\2\2\u0085\u008a\7 \2\2\u0086\u0087\7\34\2\2\u0087\u0088\7 \2\2"+
		"\u0088\u0089\7\35\2\2\u0089\u008b\5\24\13\2\u008a\u0086\3\2\2\2\u008b"+
		"\u008c\3\2\2\2\u008c\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d\27\3\2\2"+
		"\2\u008e\u0093\5\6\4\2\u008f\u0090\7\32\2\2\u0090\u0092\5\6\4\2\u0091"+
		"\u008f\3\2\2\2\u0092\u0095\3\2\2\2\u0093\u0091\3\2\2\2\u0093\u0094\3\2"+
		"\2\2\u0094\31\3\2\2\2\u0095\u0093\3\2\2\2\u0096\u0099\5\34\17\2\u0097"+
		"\u0099\5\36\20\2\u0098\u0096\3\2\2\2\u0098\u0097\3\2\2\2\u0099\u00a1\3"+
		"\2\2\2\u009a\u009d\7\32\2\2\u009b\u009e\5\34\17\2\u009c\u009e\5\36\20"+
		"\2\u009d\u009b\3\2\2\2\u009d\u009c\3\2\2\2\u009e\u00a0\3\2\2\2\u009f\u009a"+
		"\3\2\2\2\u00a0\u00a3\3\2\2\2\u00a1\u009f\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2"+
		"\33\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a4\u00a5\7 \2\2\u00a5\u00ab\5\2\2\2"+
		"\u00a6\u00a7\7 \2\2\u00a7\u00a8\5\2\2\2\u00a8\u00a9\7\36\2\2\u00a9\u00ab"+
		"\3\2\2\2\u00aa\u00a4\3\2\2\2\u00aa\u00a6\3\2\2\2\u00ab\35\3\2\2\2\u00ac"+
		"\u00ad\7\37\2\2\u00ad\u00ae\7\b\2\2\u00ae\u00af\7 \2\2\u00af\u00b0\7\t"+
		"\2\2\u00b0\37\3\2\2\2\16(X`cr~\u008c\u0093\u0098\u009d\u00a1\u00aa";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}