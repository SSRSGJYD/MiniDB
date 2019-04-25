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
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, Name=37, Number=38, 
		String=39, NEWLINE=40, WS=41;
	public static final int
		RULE_type = 0, RULE_op = 1, RULE_value = 2, RULE_sql = 3, RULE_ccondition = 4, 
		RULE_condition = 5, RULE_set = 6, RULE_names = 7, RULE_cname = 8, RULE_cnames = 9, 
		RULE_onCondition = 10, RULE_jnames = 11, RULE_values = 12, RULE_schema = 13, 
		RULE_attribute = 14, RULE_constraint = 15;
	private static String[] makeRuleNames() {
		return new String[] {
			"type", "op", "value", "sql", "ccondition", "condition", "set", "names", 
			"cname", "cnames", "onCondition", "jnames", "values", "schema", "attribute", 
			"constraint"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'int'", "'long'", "'float'", "'double'", "'char'", "'('", "')'", 
			"'='", "'>'", "'<'", "'>='", "'<='", "'<>'", "'null'", "'create table'", 
			"'drop table'", "'insert into'", "'values'", "'delete from'", "'where'", 
			"'update'", "'set'", "'select'", "'*'", "'from'", "'create database'", 
			"'drop database'", "'use database'", "'show databases'", "'show database'", 
			"','", "'.'", "'join'", "'on'", "'not null'", "'primary key'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "Name", "Number", "String", "NEWLINE", "WS"
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
			setState(40);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(32);
				match(T__0);
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				setState(33);
				match(T__1);
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 3);
				{
				setState(34);
				match(T__2);
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 4);
				{
				setState(35);
				match(T__3);
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 5);
				{
				setState(36);
				match(T__4);
				setState(37);
				match(T__5);
				setState(38);
				match(Number);
				setState(39);
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
			setState(42);
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
			setState(44);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__13) | (1L << Number) | (1L << String))) != 0)) ) {
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
		public JnamesContext jnames() {
			return getRuleContext(JnamesContext.class,0);
		}
		public CnamesContext cnames() {
			return getRuleContext(CnamesContext.class,0);
		}
		public CconditionContext ccondition() {
			return getRuleContext(CconditionContext.class,0);
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
		public TerminalNode Name() { return getToken(MiniSQLParser.Name, 0); }
		public NamesContext names() {
			return getRuleContext(NamesContext.class,0);
		}
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
	public static class UsedbContext extends SqlContext {
		public TerminalNode Name() { return getToken(MiniSQLParser.Name, 0); }
		public UsedbContext(SqlContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniSQLListener ) ((MiniSQLListener)listener).enterUsedb(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniSQLListener ) ((MiniSQLListener)listener).exitUsedb(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniSQLVisitor ) return ((MiniSQLVisitor<? extends T>)visitor).visitUsedb(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ShowContext extends SqlContext {
		public ShowContext(SqlContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniSQLListener ) ((MiniSQLListener)listener).enterShow(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniSQLListener ) ((MiniSQLListener)listener).exitShow(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniSQLVisitor ) return ((MiniSQLVisitor<? extends T>)visitor).visitShow(this);
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
	public static class ShowdbContext extends SqlContext {
		public TerminalNode Name() { return getToken(MiniSQLParser.Name, 0); }
		public ShowdbContext(SqlContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniSQLListener ) ((MiniSQLListener)listener).enterShowdb(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniSQLListener ) ((MiniSQLListener)listener).exitShowdb(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniSQLVisitor ) return ((MiniSQLVisitor<? extends T>)visitor).visitShowdb(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DropdbContext extends SqlContext {
		public TerminalNode Name() { return getToken(MiniSQLParser.Name, 0); }
		public DropdbContext(SqlContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniSQLListener ) ((MiniSQLListener)listener).enterDropdb(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniSQLListener ) ((MiniSQLListener)listener).exitDropdb(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniSQLVisitor ) return ((MiniSQLVisitor<? extends T>)visitor).visitDropdb(this);
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
	public static class CreatedbContext extends SqlContext {
		public TerminalNode Name() { return getToken(MiniSQLParser.Name, 0); }
		public CreatedbContext(SqlContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniSQLListener ) ((MiniSQLListener)listener).enterCreatedb(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniSQLListener ) ((MiniSQLListener)listener).exitCreatedb(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniSQLVisitor ) return ((MiniSQLVisitor<? extends T>)visitor).visitCreatedb(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SqlContext sql() throws RecognitionException {
		SqlContext _localctx = new SqlContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_sql);
		int _la;
		try {
			setState(114);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				_localctx = new CreateContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(46);
				match(T__14);
				setState(47);
				match(Name);
				setState(48);
				match(T__5);
				setState(49);
				schema();
				setState(50);
				match(T__6);
				}
				break;
			case 2:
				_localctx = new DropContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(52);
				match(T__15);
				setState(53);
				match(Name);
				}
				break;
			case 3:
				_localctx = new InsertAContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(54);
				match(T__16);
				setState(55);
				match(Name);
				setState(56);
				match(T__17);
				setState(57);
				match(T__5);
				setState(58);
				values();
				setState(59);
				match(T__6);
				}
				break;
			case 4:
				_localctx = new InsertBContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(61);
				match(T__16);
				setState(62);
				match(Name);
				setState(63);
				match(T__5);
				setState(64);
				names();
				setState(65);
				match(T__6);
				setState(66);
				match(T__17);
				setState(67);
				match(T__5);
				setState(68);
				values();
				setState(69);
				match(T__6);
				}
				break;
			case 5:
				_localctx = new DeleteContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(71);
				match(T__18);
				setState(72);
				match(Name);
				setState(73);
				match(T__19);
				setState(74);
				condition();
				}
				break;
			case 6:
				_localctx = new UpdateContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(75);
				match(T__20);
				setState(76);
				match(Name);
				setState(77);
				match(T__21);
				setState(78);
				set();
				setState(79);
				match(T__19);
				setState(80);
				condition();
				}
				break;
			case 7:
				_localctx = new SelectBContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(82);
				match(T__22);
				setState(85);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case Name:
					{
					setState(83);
					cnames();
					}
					break;
				case T__23:
					{
					setState(84);
					match(T__23);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(87);
				match(T__24);
				setState(88);
				jnames();
				setState(91);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__19) {
					{
					setState(89);
					match(T__19);
					setState(90);
					ccondition();
					}
				}

				}
				break;
			case 8:
				_localctx = new SelectAContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(93);
				match(T__22);
				setState(96);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case Name:
					{
					setState(94);
					names();
					}
					break;
				case T__23:
					{
					setState(95);
					match(T__23);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(98);
				match(T__24);
				setState(99);
				match(Name);
				setState(102);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__19) {
					{
					setState(100);
					match(T__19);
					setState(101);
					condition();
					}
				}

				}
				break;
			case 9:
				_localctx = new CreatedbContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(104);
				match(T__25);
				setState(105);
				match(Name);
				}
				break;
			case 10:
				_localctx = new DropdbContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(106);
				match(T__26);
				setState(107);
				match(Name);
				}
				break;
			case 11:
				_localctx = new UsedbContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(108);
				match(T__27);
				setState(109);
				match(Name);
				}
				break;
			case 12:
				_localctx = new ShowContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(110);
				match(T__28);
				}
				break;
			case 13:
				_localctx = new ShowdbContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(111);
				match(T__29);
				setState(112);
				match(Name);
				}
				break;
			case 14:
				_localctx = new NewlineContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(113);
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

	public static class CconditionContext extends ParserRuleContext {
		public List<CnameContext> cname() {
			return getRuleContexts(CnameContext.class);
		}
		public CnameContext cname(int i) {
			return getRuleContext(CnameContext.class,i);
		}
		public OpContext op() {
			return getRuleContext(OpContext.class,0);
		}
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public CconditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ccondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniSQLListener ) ((MiniSQLListener)listener).enterCcondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniSQLListener ) ((MiniSQLListener)listener).exitCcondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniSQLVisitor ) return ((MiniSQLVisitor<? extends T>)visitor).visitCcondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CconditionContext ccondition() throws RecognitionException {
		CconditionContext _localctx = new CconditionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_ccondition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			cname();
			setState(117);
			op();
			setState(120);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__13:
			case Number:
			case String:
				{
				setState(118);
				value();
				}
				break;
			case Name:
				{
				setState(119);
				cname();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class ConditionContext extends ParserRuleContext {
		public List<TerminalNode> Name() { return getTokens(MiniSQLParser.Name); }
		public TerminalNode Name(int i) {
			return getToken(MiniSQLParser.Name, i);
		}
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
		enterRule(_localctx, 10, RULE_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			match(Name);
			setState(123);
			op();
			setState(126);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__13:
			case Number:
			case String:
				{
				setState(124);
				value();
				}
				break;
			case Name:
				{
				setState(125);
				match(Name);
				}
				break;
			default:
				throw new NoViableAltException(this);
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
		enterRule(_localctx, 12, RULE_set);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			match(Name);
			setState(129);
			match(T__7);
			setState(130);
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
		enterRule(_localctx, 14, RULE_names);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			match(Name);
			setState(137);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__30) {
				{
				{
				setState(133);
				match(T__30);
				setState(134);
				match(Name);
				}
				}
				setState(139);
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
		enterRule(_localctx, 16, RULE_cname);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			match(Name);
			setState(141);
			match(T__31);
			setState(142);
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
		enterRule(_localctx, 18, RULE_cnames);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			cname();
			setState(149);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__30) {
				{
				{
				setState(145);
				match(T__30);
				setState(146);
				cname();
				}
				}
				setState(151);
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
		enterRule(_localctx, 20, RULE_onCondition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			cname();
			setState(153);
			match(T__7);
			setState(154);
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
		enterRule(_localctx, 22, RULE_jnames);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			match(Name);
			setState(161); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(157);
				match(T__32);
				setState(158);
				match(Name);
				setState(159);
				match(T__33);
				setState(160);
				onCondition();
				}
				}
				setState(163); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__32 );
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
		enterRule(_localctx, 24, RULE_values);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			value();
			setState(170);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__30) {
				{
				{
				setState(166);
				match(T__30);
				setState(167);
				value();
				}
				}
				setState(172);
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
		enterRule(_localctx, 26, RULE_schema);
		int _la;
		try {
			_localctx = new AttrconsContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(175);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Name:
				{
				setState(173);
				attribute();
				}
				break;
			case T__35:
				{
				setState(174);
				constraint();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(184);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__30) {
				{
				{
				setState(177);
				match(T__30);
				setState(180);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case Name:
					{
					setState(178);
					attribute();
					}
					break;
				case T__35:
					{
					setState(179);
					constraint();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				}
				setState(186);
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
		enterRule(_localctx, 28, RULE_attribute);
		try {
			setState(193);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				_localctx = new NormalattrContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(187);
				match(Name);
				setState(188);
				type();
				}
				break;
			case 2:
				_localctx = new NotnullattrContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(189);
				match(Name);
				setState(190);
				type();
				setState(191);
				match(T__34);
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
		enterRule(_localctx, 30, RULE_constraint);
		try {
			_localctx = new PrimarykeyContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(195);
			match(T__35);
			setState(196);
			match(T__5);
			setState(197);
			match(Name);
			setState(198);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3+\u00cb\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\5\2+\n\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5X"+
		"\n\5\3\5\3\5\3\5\3\5\5\5^\n\5\3\5\3\5\3\5\5\5c\n\5\3\5\3\5\3\5\3\5\5\5"+
		"i\n\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5u\n\5\3\6\3\6\3\6\3\6"+
		"\5\6{\n\6\3\7\3\7\3\7\3\7\5\7\u0081\n\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\7"+
		"\t\u008a\n\t\f\t\16\t\u008d\13\t\3\n\3\n\3\n\3\n\3\13\3\13\3\13\7\13\u0096"+
		"\n\13\f\13\16\13\u0099\13\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\6\r\u00a4"+
		"\n\r\r\r\16\r\u00a5\3\16\3\16\3\16\7\16\u00ab\n\16\f\16\16\16\u00ae\13"+
		"\16\3\17\3\17\5\17\u00b2\n\17\3\17\3\17\3\17\5\17\u00b7\n\17\7\17\u00b9"+
		"\n\17\f\17\16\17\u00bc\13\17\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u00c4"+
		"\n\20\3\21\3\21\3\21\3\21\3\21\3\21\2\2\22\2\4\6\b\n\f\16\20\22\24\26"+
		"\30\32\34\36 \2\4\3\2\n\17\4\2\20\20()\2\u00d9\2*\3\2\2\2\4,\3\2\2\2\6"+
		".\3\2\2\2\bt\3\2\2\2\nv\3\2\2\2\f|\3\2\2\2\16\u0082\3\2\2\2\20\u0086\3"+
		"\2\2\2\22\u008e\3\2\2\2\24\u0092\3\2\2\2\26\u009a\3\2\2\2\30\u009e\3\2"+
		"\2\2\32\u00a7\3\2\2\2\34\u00b1\3\2\2\2\36\u00c3\3\2\2\2 \u00c5\3\2\2\2"+
		"\"+\7\3\2\2#+\7\4\2\2$+\7\5\2\2%+\7\6\2\2&\'\7\7\2\2\'(\7\b\2\2()\7(\2"+
		"\2)+\7\t\2\2*\"\3\2\2\2*#\3\2\2\2*$\3\2\2\2*%\3\2\2\2*&\3\2\2\2+\3\3\2"+
		"\2\2,-\t\2\2\2-\5\3\2\2\2./\t\3\2\2/\7\3\2\2\2\60\61\7\21\2\2\61\62\7"+
		"\'\2\2\62\63\7\b\2\2\63\64\5\34\17\2\64\65\7\t\2\2\65u\3\2\2\2\66\67\7"+
		"\22\2\2\67u\7\'\2\289\7\23\2\29:\7\'\2\2:;\7\24\2\2;<\7\b\2\2<=\5\32\16"+
		"\2=>\7\t\2\2>u\3\2\2\2?@\7\23\2\2@A\7\'\2\2AB\7\b\2\2BC\5\20\t\2CD\7\t"+
		"\2\2DE\7\24\2\2EF\7\b\2\2FG\5\32\16\2GH\7\t\2\2Hu\3\2\2\2IJ\7\25\2\2J"+
		"K\7\'\2\2KL\7\26\2\2Lu\5\f\7\2MN\7\27\2\2NO\7\'\2\2OP\7\30\2\2PQ\5\16"+
		"\b\2QR\7\26\2\2RS\5\f\7\2Su\3\2\2\2TW\7\31\2\2UX\5\24\13\2VX\7\32\2\2"+
		"WU\3\2\2\2WV\3\2\2\2XY\3\2\2\2YZ\7\33\2\2Z]\5\30\r\2[\\\7\26\2\2\\^\5"+
		"\n\6\2][\3\2\2\2]^\3\2\2\2^u\3\2\2\2_b\7\31\2\2`c\5\20\t\2ac\7\32\2\2"+
		"b`\3\2\2\2ba\3\2\2\2cd\3\2\2\2de\7\33\2\2eh\7\'\2\2fg\7\26\2\2gi\5\f\7"+
		"\2hf\3\2\2\2hi\3\2\2\2iu\3\2\2\2jk\7\34\2\2ku\7\'\2\2lm\7\35\2\2mu\7\'"+
		"\2\2no\7\36\2\2ou\7\'\2\2pu\7\37\2\2qr\7 \2\2ru\7\'\2\2su\7*\2\2t\60\3"+
		"\2\2\2t\66\3\2\2\2t8\3\2\2\2t?\3\2\2\2tI\3\2\2\2tM\3\2\2\2tT\3\2\2\2t"+
		"_\3\2\2\2tj\3\2\2\2tl\3\2\2\2tn\3\2\2\2tp\3\2\2\2tq\3\2\2\2ts\3\2\2\2"+
		"u\t\3\2\2\2vw\5\22\n\2wz\5\4\3\2x{\5\6\4\2y{\5\22\n\2zx\3\2\2\2zy\3\2"+
		"\2\2{\13\3\2\2\2|}\7\'\2\2}\u0080\5\4\3\2~\u0081\5\6\4\2\177\u0081\7\'"+
		"\2\2\u0080~\3\2\2\2\u0080\177\3\2\2\2\u0081\r\3\2\2\2\u0082\u0083\7\'"+
		"\2\2\u0083\u0084\7\n\2\2\u0084\u0085\5\6\4\2\u0085\17\3\2\2\2\u0086\u008b"+
		"\7\'\2\2\u0087\u0088\7!\2\2\u0088\u008a\7\'\2\2\u0089\u0087\3\2\2\2\u008a"+
		"\u008d\3\2\2\2\u008b\u0089\3\2\2\2\u008b\u008c\3\2\2\2\u008c\21\3\2\2"+
		"\2\u008d\u008b\3\2\2\2\u008e\u008f\7\'\2\2\u008f\u0090\7\"\2\2\u0090\u0091"+
		"\7\'\2\2\u0091\23\3\2\2\2\u0092\u0097\5\22\n\2\u0093\u0094\7!\2\2\u0094"+
		"\u0096\5\22\n\2\u0095\u0093\3\2\2\2\u0096\u0099\3\2\2\2\u0097\u0095\3"+
		"\2\2\2\u0097\u0098\3\2\2\2\u0098\25\3\2\2\2\u0099\u0097\3\2\2\2\u009a"+
		"\u009b\5\22\n\2\u009b\u009c\7\n\2\2\u009c\u009d\5\22\n\2\u009d\27\3\2"+
		"\2\2\u009e\u00a3\7\'\2\2\u009f\u00a0\7#\2\2\u00a0\u00a1\7\'\2\2\u00a1"+
		"\u00a2\7$\2\2\u00a2\u00a4\5\26\f\2\u00a3\u009f\3\2\2\2\u00a4\u00a5\3\2"+
		"\2\2\u00a5\u00a3\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\31\3\2\2\2\u00a7\u00ac"+
		"\5\6\4\2\u00a8\u00a9\7!\2\2\u00a9\u00ab\5\6\4\2\u00aa\u00a8\3\2\2\2\u00ab"+
		"\u00ae\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\33\3\2\2"+
		"\2\u00ae\u00ac\3\2\2\2\u00af\u00b2\5\36\20\2\u00b0\u00b2\5 \21\2\u00b1"+
		"\u00af\3\2\2\2\u00b1\u00b0\3\2\2\2\u00b2\u00ba\3\2\2\2\u00b3\u00b6\7!"+
		"\2\2\u00b4\u00b7\5\36\20\2\u00b5\u00b7\5 \21\2\u00b6\u00b4\3\2\2\2\u00b6"+
		"\u00b5\3\2\2\2\u00b7\u00b9\3\2\2\2\u00b8\u00b3\3\2\2\2\u00b9\u00bc\3\2"+
		"\2\2\u00ba\u00b8\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb\35\3\2\2\2\u00bc\u00ba"+
		"\3\2\2\2\u00bd\u00be\7\'\2\2\u00be\u00c4\5\2\2\2\u00bf\u00c0\7\'\2\2\u00c0"+
		"\u00c1\5\2\2\2\u00c1\u00c2\7%\2\2\u00c2\u00c4\3\2\2\2\u00c3\u00bd\3\2"+
		"\2\2\u00c3\u00bf\3\2\2\2\u00c4\37\3\2\2\2\u00c5\u00c6\7&\2\2\u00c6\u00c7"+
		"\7\b\2\2\u00c7\u00c8\7\'\2\2\u00c8\u00c9\7\t\2\2\u00c9!\3\2\2\2\22*W]"+
		"bhtz\u0080\u008b\u0097\u00a5\u00ac\u00b1\u00b6\u00ba\u00c3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}