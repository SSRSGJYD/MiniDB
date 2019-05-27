// Generated from MiniSQL.g4 by ANTLR 4.4
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
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__46=1, T__45=2, T__44=3, T__43=4, T__42=5, T__41=6, T__40=7, T__39=8, 
		T__38=9, T__37=10, T__36=11, T__35=12, T__34=13, T__33=14, T__32=15, T__31=16, 
		T__30=17, T__29=18, T__28=19, T__27=20, T__26=21, T__25=22, T__24=23, 
		T__23=24, T__22=25, T__21=26, T__20=27, T__19=28, T__18=29, T__17=30, 
		T__16=31, T__15=32, T__14=33, T__13=34, T__12=35, T__11=36, T__10=37, 
		T__9=38, T__8=39, T__7=40, T__6=41, T__5=42, T__4=43, T__3=44, T__2=45, 
		T__1=46, T__0=47, Number=48, Name=49, String=50, NEWLINE=51, WS=52;
	public static final String[] tokenNames = {
		"<INVALID>", "'full outer join'", "'primary key'", "'revoke'", "'char'", 
		"'grant'", "'password'", "'create user'", "'set'", "'use database'", "'float'", 
		"'delete from'", "'on'", "'='", "'<='", "'drop table'", "'right outer join'", 
		"'double'", "'from'", "'int'", "'null'", "'drop database'", "'('", "'values'", 
		"'*'", "'update'", "','", "'.'", "'join'", "'long'", "'to'", "'show database'", 
		"'>='", "'<'", "'select'", "'>'", "'or'", "'left outer join'", "'<>'", 
		"'where'", "'create database'", "'with grant option'", "')'", "'and'", 
		"'show databases'", "'insert into'", "'not null'", "'create table'", "Number", 
		"Name", "String", "NEWLINE", "WS"
	};
	public static final int
		RULE_perm = 0, RULE_withGrant = 1, RULE_type = 2, RULE_op = 3, RULE_value = 4, 
		RULE_join = 5, RULE_lop = 6, RULE_sql = 7, RULE_logictree = 8, RULE_clogictree = 9, 
		RULE_ccondition = 10, RULE_condition = 11, RULE_set = 12, RULE_names = 13, 
		RULE_cname = 14, RULE_cnames = 15, RULE_onCondition = 16, RULE_jnames = 17, 
		RULE_values = 18, RULE_schema = 19, RULE_attribute = 20, RULE_constraint = 21;
	public static final String[] ruleNames = {
		"perm", "withGrant", "type", "op", "value", "join", "lop", "sql", "logictree", 
		"clogictree", "ccondition", "condition", "set", "names", "cname", "cnames", 
		"onCondition", "jnames", "values", "schema", "attribute", "constraint"
	};

	@Override
	public String getGrammarFileName() { return "MiniSQL.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

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
	public static class PermContext extends ParserRuleContext {
		public PermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_perm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniSQLListener ) ((MiniSQLListener)listener).enterPerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniSQLListener ) ((MiniSQLListener)listener).exitPerm(this);
		}
	}

	public final PermContext perm() throws RecognitionException {
		PermContext _localctx = new PermContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_perm);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			_la = _input.LA(1);
			if ( !(_la==T__22 || _la==T__13) ) {
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

	public static class WithGrantContext extends ParserRuleContext {
		public WithGrantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_withGrant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniSQLListener ) ((MiniSQLListener)listener).enterWithGrant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniSQLListener ) ((MiniSQLListener)listener).exitWithGrant(this);
		}
	}

	public final WithGrantContext withGrant() throws RecognitionException {
		WithGrantContext _localctx = new WithGrantContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_withGrant);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46); match(T__6);
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
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_type);
		try {
			setState(56);
			switch (_input.LA(1)) {
			case T__28:
				enterOuterAlt(_localctx, 1);
				{
				setState(48); match(T__28);
				}
				break;
			case T__18:
				enterOuterAlt(_localctx, 2);
				{
				setState(49); match(T__18);
				}
				break;
			case T__37:
				enterOuterAlt(_localctx, 3);
				{
				setState(50); match(T__37);
				}
				break;
			case T__30:
				enterOuterAlt(_localctx, 4);
				{
				setState(51); match(T__30);
				}
				break;
			case T__43:
				enterOuterAlt(_localctx, 5);
				{
				setState(52); match(T__43);
				setState(53); match(T__25);
				setState(54); match(Number);
				setState(55); match(T__5);
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
	}

	public final OpContext op() throws RecognitionException {
		OpContext _localctx = new OpContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__34) | (1L << T__33) | (1L << T__15) | (1L << T__14) | (1L << T__12) | (1L << T__9))) != 0)) ) {
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

	public static class ValueContext extends ParserRuleContext {
		public TerminalNode String() { return getToken(MiniSQLParser.String, 0); }
		public TerminalNode Number() { return getToken(MiniSQLParser.Number, 0); }
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
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__27) | (1L << Number) | (1L << String))) != 0)) ) {
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

	public static class JoinContext extends ParserRuleContext {
		public JoinContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_join; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniSQLListener ) ((MiniSQLListener)listener).enterJoin(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniSQLListener ) ((MiniSQLListener)listener).exitJoin(this);
		}
	}

	public final JoinContext join() throws RecognitionException {
		JoinContext _localctx = new JoinContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_join);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__46) | (1L << T__31) | (1L << T__19) | (1L << T__10))) != 0)) ) {
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

	public static class LopContext extends ParserRuleContext {
		public LopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniSQLListener ) ((MiniSQLListener)listener).enterLop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniSQLListener ) ((MiniSQLListener)listener).exitLop(this);
		}
	}

	public final LopContext lop() throws RecognitionException {
		LopContext _localctx = new LopContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_lop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			_la = _input.LA(1);
			if ( !(_la==T__11 || _la==T__4) ) {
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
	}
	public static class SelectBContext extends SqlContext {
		public ClogictreeContext clogictree() {
			return getRuleContext(ClogictreeContext.class,0);
		}
		public CnamesContext cnames() {
			return getRuleContext(CnamesContext.class,0);
		}
		public JnamesContext jnames() {
			return getRuleContext(JnamesContext.class,0);
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
	}
	public static class SelectAContext extends SqlContext {
		public LogictreeContext logictree() {
			return getRuleContext(LogictreeContext.class,0);
		}
		public TerminalNode Name() { return getToken(MiniSQLParser.Name, 0); }
		public NamesContext names() {
			return getRuleContext(NamesContext.class,0);
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
	}
	public static class UpdateContext extends SqlContext {
		public LogictreeContext logictree() {
			return getRuleContext(LogictreeContext.class,0);
		}
		public TerminalNode Name() { return getToken(MiniSQLParser.Name, 0); }
		public SetContext set() {
			return getRuleContext(SetContext.class,0);
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
	}
	public static class RevokeContext extends SqlContext {
		public PermContext perm() {
			return getRuleContext(PermContext.class,0);
		}
		public TerminalNode Name(int i) {
			return getToken(MiniSQLParser.Name, i);
		}
		public List<TerminalNode> Name() { return getTokens(MiniSQLParser.Name); }
		public RevokeContext(SqlContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniSQLListener ) ((MiniSQLListener)listener).enterRevoke(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniSQLListener ) ((MiniSQLListener)listener).exitRevoke(this);
		}
	}
	public static class DeleteContext extends SqlContext {
		public LogictreeContext logictree() {
			return getRuleContext(LogictreeContext.class,0);
		}
		public TerminalNode Name() { return getToken(MiniSQLParser.Name, 0); }
		public DeleteContext(SqlContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniSQLListener ) ((MiniSQLListener)listener).enterDelete(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniSQLListener ) ((MiniSQLListener)listener).exitDelete(this);
		}
	}
	public static class InsertBContext extends SqlContext {
		public ValuesContext values() {
			return getRuleContext(ValuesContext.class,0);
		}
		public TerminalNode Name() { return getToken(MiniSQLParser.Name, 0); }
		public NamesContext names() {
			return getRuleContext(NamesContext.class,0);
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
	}
	public static class InsertAContext extends SqlContext {
		public ValuesContext values() {
			return getRuleContext(ValuesContext.class,0);
		}
		public TerminalNode Name() { return getToken(MiniSQLParser.Name, 0); }
		public InsertAContext(SqlContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniSQLListener ) ((MiniSQLListener)listener).enterInsertA(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniSQLListener ) ((MiniSQLListener)listener).exitInsertA(this);
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
	}
	public static class CreateContext extends SqlContext {
		public SchemaContext schema() {
			return getRuleContext(SchemaContext.class,0);
		}
		public TerminalNode Name() { return getToken(MiniSQLParser.Name, 0); }
		public CreateContext(SqlContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniSQLListener ) ((MiniSQLListener)listener).enterCreate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniSQLListener ) ((MiniSQLListener)listener).exitCreate(this);
		}
	}
	public static class CreateUserContext extends SqlContext {
		public TerminalNode Name(int i) {
			return getToken(MiniSQLParser.Name, i);
		}
		public List<TerminalNode> Name() { return getTokens(MiniSQLParser.Name); }
		public CreateUserContext(SqlContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniSQLListener ) ((MiniSQLListener)listener).enterCreateUser(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniSQLListener ) ((MiniSQLListener)listener).exitCreateUser(this);
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
	}
	public static class GrantContext extends SqlContext {
		public WithGrantContext withGrant() {
			return getRuleContext(WithGrantContext.class,0);
		}
		public PermContext perm() {
			return getRuleContext(PermContext.class,0);
		}
		public TerminalNode Name(int i) {
			return getToken(MiniSQLParser.Name, i);
		}
		public List<TerminalNode> Name() { return getTokens(MiniSQLParser.Name); }
		public GrantContext(SqlContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniSQLListener ) ((MiniSQLListener)listener).enterGrant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniSQLListener ) ((MiniSQLListener)listener).exitGrant(this);
		}
	}

	public final SqlContext sql() throws RecognitionException {
		SqlContext _localctx = new SqlContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_sql);
		int _la;
		try {
			setState(154);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				_localctx = new CreateContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(66); match(T__0);
				setState(67); match(Name);
				setState(68); match(T__25);
				setState(69); schema();
				setState(70); match(T__5);
				}
				break;
			case 2:
				_localctx = new DropContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(72); match(T__32);
				setState(73); match(Name);
				}
				break;
			case 3:
				_localctx = new InsertAContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(74); match(T__2);
				setState(75); match(Name);
				setState(76); match(T__24);
				setState(77); match(T__25);
				setState(78); values();
				setState(79); match(T__5);
				}
				break;
			case 4:
				_localctx = new InsertBContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(81); match(T__2);
				setState(82); match(Name);
				setState(83); match(T__25);
				setState(84); names();
				setState(85); match(T__5);
				setState(86); match(T__24);
				setState(87); match(T__25);
				setState(88); values();
				setState(89); match(T__5);
				}
				break;
			case 5:
				_localctx = new DeleteContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(91); match(T__36);
				setState(92); match(Name);
				setState(93); match(T__8);
				setState(94); logictree(0);
				}
				break;
			case 6:
				_localctx = new UpdateContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(95); match(T__22);
				setState(96); match(Name);
				setState(97); match(T__39);
				setState(98); set();
				setState(99); match(T__8);
				setState(100); logictree(0);
				}
				break;
			case 7:
				_localctx = new SelectBContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(102); match(T__13);
				setState(105);
				switch (_input.LA(1)) {
				case Name:
					{
					setState(103); cnames();
					}
					break;
				case T__23:
					{
					setState(104); match(T__23);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(107); match(T__29);
				setState(108); jnames();
				setState(111);
				_la = _input.LA(1);
				if (_la==T__8) {
					{
					setState(109); match(T__8);
					setState(110); clogictree(0);
					}
				}

				}
				break;
			case 8:
				_localctx = new SelectAContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(113); match(T__13);
				setState(116);
				switch (_input.LA(1)) {
				case Name:
					{
					setState(114); names();
					}
					break;
				case T__23:
					{
					setState(115); match(T__23);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(118); match(T__29);
				setState(119); match(Name);
				setState(122);
				_la = _input.LA(1);
				if (_la==T__8) {
					{
					setState(120); match(T__8);
					setState(121); logictree(0);
					}
				}

				}
				break;
			case 9:
				_localctx = new CreatedbContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(124); match(T__7);
				setState(125); match(Name);
				}
				break;
			case 10:
				_localctx = new DropdbContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(126); match(T__26);
				setState(127); match(Name);
				}
				break;
			case 11:
				_localctx = new UsedbContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(128); match(T__38);
				setState(129); match(Name);
				}
				break;
			case 12:
				_localctx = new ShowContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(130); match(T__3);
				}
				break;
			case 13:
				_localctx = new ShowdbContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(131); match(T__16);
				setState(132); match(Name);
				}
				break;
			case 14:
				_localctx = new CreateUserContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(133); match(T__40);
				setState(134); match(Name);
				setState(135); match(T__41);
				setState(136); match(Name);
				}
				break;
			case 15:
				_localctx = new GrantContext(_localctx);
				enterOuterAlt(_localctx, 15);
				{
				setState(137); match(T__42);
				setState(138); perm();
				setState(139); match(T__35);
				setState(140); match(Name);
				setState(141); match(T__17);
				setState(142); match(Name);
				setState(144);
				_la = _input.LA(1);
				if (_la==T__6) {
					{
					setState(143); withGrant();
					}
				}

				}
				break;
			case 16:
				_localctx = new RevokeContext(_localctx);
				enterOuterAlt(_localctx, 16);
				{
				setState(146); match(T__44);
				setState(147); perm();
				setState(148); match(T__35);
				setState(149); match(Name);
				setState(150); match(T__29);
				setState(151); match(Name);
				}
				break;
			case 17:
				_localctx = new NewlineContext(_localctx);
				enterOuterAlt(_localctx, 17);
				{
				setState(153); match(NEWLINE);
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

	public static class LogictreeContext extends ParserRuleContext {
		public List<LogictreeContext> logictree() {
			return getRuleContexts(LogictreeContext.class);
		}
		public LopContext lop() {
			return getRuleContext(LopContext.class,0);
		}
		public LogictreeContext logictree(int i) {
			return getRuleContext(LogictreeContext.class,i);
		}
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public LogictreeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logictree; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniSQLListener ) ((MiniSQLListener)listener).enterLogictree(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniSQLListener ) ((MiniSQLListener)listener).exitLogictree(this);
		}
	}

	public final LogictreeContext logictree() throws RecognitionException {
		return logictree(0);
	}

	private LogictreeContext logictree(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		LogictreeContext _localctx = new LogictreeContext(_ctx, _parentState);
		LogictreeContext _prevctx = _localctx;
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_logictree, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			switch (_input.LA(1)) {
			case T__25:
				{
				setState(157); match(T__25);
				setState(158); logictree(0);
				setState(159); lop();
				setState(160); logictree(0);
				setState(161); match(T__5);
				}
				break;
			case Name:
				{
				setState(163); condition();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(172);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new LogictreeContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_logictree);
					setState(166);
					if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
					setState(167); lop();
					setState(168); logictree(4);
					}
					} 
				}
				setState(174);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ClogictreeContext extends ParserRuleContext {
		public ClogictreeContext clogictree(int i) {
			return getRuleContext(ClogictreeContext.class,i);
		}
		public List<ClogictreeContext> clogictree() {
			return getRuleContexts(ClogictreeContext.class);
		}
		public CconditionContext ccondition() {
			return getRuleContext(CconditionContext.class,0);
		}
		public LopContext lop() {
			return getRuleContext(LopContext.class,0);
		}
		public ClogictreeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_clogictree; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniSQLListener ) ((MiniSQLListener)listener).enterClogictree(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniSQLListener ) ((MiniSQLListener)listener).exitClogictree(this);
		}
	}

	public final ClogictreeContext clogictree() throws RecognitionException {
		return clogictree(0);
	}

	private ClogictreeContext clogictree(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ClogictreeContext _localctx = new ClogictreeContext(_ctx, _parentState);
		ClogictreeContext _prevctx = _localctx;
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_clogictree, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
			switch (_input.LA(1)) {
			case T__25:
				{
				setState(176); match(T__25);
				setState(177); clogictree(0);
				setState(178); lop();
				setState(179); clogictree(0);
				setState(180); match(T__5);
				}
				break;
			case Name:
				{
				setState(182); ccondition();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(191);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ClogictreeContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_clogictree);
					setState(185);
					if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
					setState(186); lop();
					setState(187); clogictree(4);
					}
					} 
				}
				setState(193);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
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
	}

	public final CconditionContext ccondition() throws RecognitionException {
		CconditionContext _localctx = new CconditionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_ccondition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194); cname();
			setState(195); op();
			setState(198);
			switch (_input.LA(1)) {
			case T__27:
			case Number:
			case String:
				{
				setState(196); value();
				}
				break;
			case Name:
				{
				setState(197); cname();
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
		public OpContext op() {
			return getRuleContext(OpContext.class,0);
		}
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public TerminalNode Name(int i) {
			return getToken(MiniSQLParser.Name, i);
		}
		public List<TerminalNode> Name() { return getTokens(MiniSQLParser.Name); }
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
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(200); match(Name);
			setState(201); op();
			setState(204);
			switch (_input.LA(1)) {
			case T__27:
			case Number:
			case String:
				{
				setState(202); value();
				}
				break;
			case Name:
				{
				setState(203); match(Name);
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
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public TerminalNode Name() { return getToken(MiniSQLParser.Name, 0); }
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
	}

	public final SetContext set() throws RecognitionException {
		SetContext _localctx = new SetContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_set);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(206); match(Name);
			setState(207); match(T__34);
			setState(208); value();
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
		public TerminalNode Name(int i) {
			return getToken(MiniSQLParser.Name, i);
		}
		public List<TerminalNode> Name() { return getTokens(MiniSQLParser.Name); }
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
	}

	public final NamesContext names() throws RecognitionException {
		NamesContext _localctx = new NamesContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_names);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210); match(Name);
			setState(215);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__21) {
				{
				{
				setState(211); match(T__21);
				setState(212); match(Name);
				}
				}
				setState(217);
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
		public TerminalNode Name(int i) {
			return getToken(MiniSQLParser.Name, i);
		}
		public List<TerminalNode> Name() { return getTokens(MiniSQLParser.Name); }
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
	}

	public final CnameContext cname() throws RecognitionException {
		CnameContext _localctx = new CnameContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_cname);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(218); match(Name);
			setState(219); match(T__20);
			setState(220); match(Name);
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
	}

	public final CnamesContext cnames() throws RecognitionException {
		CnamesContext _localctx = new CnamesContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_cnames);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(222); cname();
			setState(227);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__21) {
				{
				{
				setState(223); match(T__21);
				setState(224); cname();
				}
				}
				setState(229);
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
	}

	public final OnConditionContext onCondition() throws RecognitionException {
		OnConditionContext _localctx = new OnConditionContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_onCondition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(230); cname();
			setState(231); match(T__34);
			setState(232); cname();
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
		public OnConditionContext onCondition(int i) {
			return getRuleContext(OnConditionContext.class,i);
		}
		public JoinContext join(int i) {
			return getRuleContext(JoinContext.class,i);
		}
		public List<JoinContext> join() {
			return getRuleContexts(JoinContext.class);
		}
		public TerminalNode Name(int i) {
			return getToken(MiniSQLParser.Name, i);
		}
		public List<TerminalNode> Name() { return getTokens(MiniSQLParser.Name); }
		public List<OnConditionContext> onCondition() {
			return getRuleContexts(OnConditionContext.class);
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
	}

	public final JnamesContext jnames() throws RecognitionException {
		JnamesContext _localctx = new JnamesContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_jnames);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(234); match(Name);
			setState(240); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(235); join();
				setState(236); match(Name);
				setState(237); match(T__35);
				setState(238); onCondition();
				}
				}
				setState(242); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__46) | (1L << T__31) | (1L << T__19) | (1L << T__10))) != 0) );
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
	}

	public final ValuesContext values() throws RecognitionException {
		ValuesContext _localctx = new ValuesContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_values);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(244); value();
			setState(249);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__21) {
				{
				{
				setState(245); match(T__21);
				setState(246); value();
				}
				}
				setState(251);
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
		public List<ConstraintContext> constraint() {
			return getRuleContexts(ConstraintContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
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
	}

	public final SchemaContext schema() throws RecognitionException {
		SchemaContext _localctx = new SchemaContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_schema);
		int _la;
		try {
			_localctx = new AttrconsContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(254);
			switch (_input.LA(1)) {
			case Name:
				{
				setState(252); attribute();
				}
				break;
			case T__45:
				{
				setState(253); constraint();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(263);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__21) {
				{
				{
				setState(256); match(T__21);
				setState(259);
				switch (_input.LA(1)) {
				case Name:
					{
					setState(257); attribute();
					}
					break;
				case T__45:
					{
					setState(258); constraint();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				}
				setState(265);
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
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode Name() { return getToken(MiniSQLParser.Name, 0); }
		public NormalattrContext(AttributeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniSQLListener ) ((MiniSQLListener)listener).enterNormalattr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniSQLListener ) ((MiniSQLListener)listener).exitNormalattr(this);
		}
	}
	public static class NotnullattrContext extends AttributeContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode Name() { return getToken(MiniSQLParser.Name, 0); }
		public NotnullattrContext(AttributeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniSQLListener ) ((MiniSQLListener)listener).enterNotnullattr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniSQLListener ) ((MiniSQLListener)listener).exitNotnullattr(this);
		}
	}

	public final AttributeContext attribute() throws RecognitionException {
		AttributeContext _localctx = new AttributeContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_attribute);
		try {
			setState(272);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				_localctx = new NormalattrContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(266); match(Name);
				setState(267); type();
				}
				break;
			case 2:
				_localctx = new NotnullattrContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(268); match(Name);
				setState(269); type();
				setState(270); match(T__1);
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
	}

	public final ConstraintContext constraint() throws RecognitionException {
		ConstraintContext _localctx = new ConstraintContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_constraint);
		try {
			_localctx = new PrimarykeyContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(274); match(T__45);
			setState(275); match(T__25);
			setState(276); match(Name);
			setState(277); match(T__5);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 8: return logictree_sempred((LogictreeContext)_localctx, predIndex);
		case 9: return clogictree_sempred((ClogictreeContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean logictree_sempred(LogictreeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 3);
		}
		return true;
	}
	private boolean clogictree_sempred(ClogictreeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1: return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\66\u011a\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3\2\3\3\3\3\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4;\n\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\5\tl\n\t\3\t\3\t\3\t\3\t\5\tr\n\t\3\t\3\t\3\t\5\tw\n"+
		"\t\3\t\3\t\3\t\3\t\5\t}\n\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u0093\n\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\5\t\u009d\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u00a7"+
		"\n\n\3\n\3\n\3\n\3\n\7\n\u00ad\n\n\f\n\16\n\u00b0\13\n\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\5\13\u00ba\n\13\3\13\3\13\3\13\3\13\7\13\u00c0"+
		"\n\13\f\13\16\13\u00c3\13\13\3\f\3\f\3\f\3\f\5\f\u00c9\n\f\3\r\3\r\3\r"+
		"\3\r\5\r\u00cf\n\r\3\16\3\16\3\16\3\16\3\17\3\17\3\17\7\17\u00d8\n\17"+
		"\f\17\16\17\u00db\13\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21\7\21\u00e4"+
		"\n\21\f\21\16\21\u00e7\13\21\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3"+
		"\23\3\23\6\23\u00f3\n\23\r\23\16\23\u00f4\3\24\3\24\3\24\7\24\u00fa\n"+
		"\24\f\24\16\24\u00fd\13\24\3\25\3\25\5\25\u0101\n\25\3\25\3\25\3\25\5"+
		"\25\u0106\n\25\7\25\u0108\n\25\f\25\16\25\u010b\13\25\3\26\3\26\3\26\3"+
		"\26\3\26\3\26\5\26\u0113\n\26\3\27\3\27\3\27\3\27\3\27\3\27\2\4\22\24"+
		"\30\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,\2\7\4\2\33\33$$\6\2"+
		"\17\20\"#%%((\5\2\26\26\62\62\64\64\6\2\3\3\22\22\36\36\'\'\4\2&&--\u012a"+
		"\2.\3\2\2\2\4\60\3\2\2\2\6:\3\2\2\2\b<\3\2\2\2\n>\3\2\2\2\f@\3\2\2\2\16"+
		"B\3\2\2\2\20\u009c\3\2\2\2\22\u00a6\3\2\2\2\24\u00b9\3\2\2\2\26\u00c4"+
		"\3\2\2\2\30\u00ca\3\2\2\2\32\u00d0\3\2\2\2\34\u00d4\3\2\2\2\36\u00dc\3"+
		"\2\2\2 \u00e0\3\2\2\2\"\u00e8\3\2\2\2$\u00ec\3\2\2\2&\u00f6\3\2\2\2(\u0100"+
		"\3\2\2\2*\u0112\3\2\2\2,\u0114\3\2\2\2./\t\2\2\2/\3\3\2\2\2\60\61\7+\2"+
		"\2\61\5\3\2\2\2\62;\7\25\2\2\63;\7\37\2\2\64;\7\f\2\2\65;\7\23\2\2\66"+
		"\67\7\6\2\2\678\7\30\2\289\7\62\2\29;\7,\2\2:\62\3\2\2\2:\63\3\2\2\2:"+
		"\64\3\2\2\2:\65\3\2\2\2:\66\3\2\2\2;\7\3\2\2\2<=\t\3\2\2=\t\3\2\2\2>?"+
		"\t\4\2\2?\13\3\2\2\2@A\t\5\2\2A\r\3\2\2\2BC\t\6\2\2C\17\3\2\2\2DE\7\61"+
		"\2\2EF\7\63\2\2FG\7\30\2\2GH\5(\25\2HI\7,\2\2I\u009d\3\2\2\2JK\7\21\2"+
		"\2K\u009d\7\63\2\2LM\7/\2\2MN\7\63\2\2NO\7\31\2\2OP\7\30\2\2PQ\5&\24\2"+
		"QR\7,\2\2R\u009d\3\2\2\2ST\7/\2\2TU\7\63\2\2UV\7\30\2\2VW\5\34\17\2WX"+
		"\7,\2\2XY\7\31\2\2YZ\7\30\2\2Z[\5&\24\2[\\\7,\2\2\\\u009d\3\2\2\2]^\7"+
		"\r\2\2^_\7\63\2\2_`\7)\2\2`\u009d\5\22\n\2ab\7\33\2\2bc\7\63\2\2cd\7\n"+
		"\2\2de\5\32\16\2ef\7)\2\2fg\5\22\n\2g\u009d\3\2\2\2hk\7$\2\2il\5 \21\2"+
		"jl\7\32\2\2ki\3\2\2\2kj\3\2\2\2lm\3\2\2\2mn\7\24\2\2nq\5$\23\2op\7)\2"+
		"\2pr\5\24\13\2qo\3\2\2\2qr\3\2\2\2r\u009d\3\2\2\2sv\7$\2\2tw\5\34\17\2"+
		"uw\7\32\2\2vt\3\2\2\2vu\3\2\2\2wx\3\2\2\2xy\7\24\2\2y|\7\63\2\2z{\7)\2"+
		"\2{}\5\22\n\2|z\3\2\2\2|}\3\2\2\2}\u009d\3\2\2\2~\177\7*\2\2\177\u009d"+
		"\7\63\2\2\u0080\u0081\7\27\2\2\u0081\u009d\7\63\2\2\u0082\u0083\7\13\2"+
		"\2\u0083\u009d\7\63\2\2\u0084\u009d\7.\2\2\u0085\u0086\7!\2\2\u0086\u009d"+
		"\7\63\2\2\u0087\u0088\7\t\2\2\u0088\u0089\7\63\2\2\u0089\u008a\7\b\2\2"+
		"\u008a\u009d\7\63\2\2\u008b\u008c\7\7\2\2\u008c\u008d\5\2\2\2\u008d\u008e"+
		"\7\16\2\2\u008e\u008f\7\63\2\2\u008f\u0090\7 \2\2\u0090\u0092\7\63\2\2"+
		"\u0091\u0093\5\4\3\2\u0092\u0091\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u009d"+
		"\3\2\2\2\u0094\u0095\7\5\2\2\u0095\u0096\5\2\2\2\u0096\u0097\7\16\2\2"+
		"\u0097\u0098\7\63\2\2\u0098\u0099\7\24\2\2\u0099\u009a\7\63\2\2\u009a"+
		"\u009d\3\2\2\2\u009b\u009d\7\65\2\2\u009cD\3\2\2\2\u009cJ\3\2\2\2\u009c"+
		"L\3\2\2\2\u009cS\3\2\2\2\u009c]\3\2\2\2\u009ca\3\2\2\2\u009ch\3\2\2\2"+
		"\u009cs\3\2\2\2\u009c~\3\2\2\2\u009c\u0080\3\2\2\2\u009c\u0082\3\2\2\2"+
		"\u009c\u0084\3\2\2\2\u009c\u0085\3\2\2\2\u009c\u0087\3\2\2\2\u009c\u008b"+
		"\3\2\2\2\u009c\u0094\3\2\2\2\u009c\u009b\3\2\2\2\u009d\21\3\2\2\2\u009e"+
		"\u009f\b\n\1\2\u009f\u00a0\7\30\2\2\u00a0\u00a1\5\22\n\2\u00a1\u00a2\5"+
		"\16\b\2\u00a2\u00a3\5\22\n\2\u00a3\u00a4\7,\2\2\u00a4\u00a7\3\2\2\2\u00a5"+
		"\u00a7\5\30\r\2\u00a6\u009e\3\2\2\2\u00a6\u00a5\3\2\2\2\u00a7\u00ae\3"+
		"\2\2\2\u00a8\u00a9\f\5\2\2\u00a9\u00aa\5\16\b\2\u00aa\u00ab\5\22\n\6\u00ab"+
		"\u00ad\3\2\2\2\u00ac\u00a8\3\2\2\2\u00ad\u00b0\3\2\2\2\u00ae\u00ac\3\2"+
		"\2\2\u00ae\u00af\3\2\2\2\u00af\23\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b1\u00b2"+
		"\b\13\1\2\u00b2\u00b3\7\30\2\2\u00b3\u00b4\5\24\13\2\u00b4\u00b5\5\16"+
		"\b\2\u00b5\u00b6\5\24\13\2\u00b6\u00b7\7,\2\2\u00b7\u00ba\3\2\2\2\u00b8"+
		"\u00ba\5\26\f\2\u00b9\u00b1\3\2\2\2\u00b9\u00b8\3\2\2\2\u00ba\u00c1\3"+
		"\2\2\2\u00bb\u00bc\f\5\2\2\u00bc\u00bd\5\16\b\2\u00bd\u00be\5\24\13\6"+
		"\u00be\u00c0\3\2\2\2\u00bf\u00bb\3\2\2\2\u00c0\u00c3\3\2\2\2\u00c1\u00bf"+
		"\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\25\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c4"+
		"\u00c5\5\36\20\2\u00c5\u00c8\5\b\5\2\u00c6\u00c9\5\n\6\2\u00c7\u00c9\5"+
		"\36\20\2\u00c8\u00c6\3\2\2\2\u00c8\u00c7\3\2\2\2\u00c9\27\3\2\2\2\u00ca"+
		"\u00cb\7\63\2\2\u00cb\u00ce\5\b\5\2\u00cc\u00cf\5\n\6\2\u00cd\u00cf\7"+
		"\63\2\2\u00ce\u00cc\3\2\2\2\u00ce\u00cd\3\2\2\2\u00cf\31\3\2\2\2\u00d0"+
		"\u00d1\7\63\2\2\u00d1\u00d2\7\17\2\2\u00d2\u00d3\5\n\6\2\u00d3\33\3\2"+
		"\2\2\u00d4\u00d9\7\63\2\2\u00d5\u00d6\7\34\2\2\u00d6\u00d8\7\63\2\2\u00d7"+
		"\u00d5\3\2\2\2\u00d8\u00db\3\2\2\2\u00d9\u00d7\3\2\2\2\u00d9\u00da\3\2"+
		"\2\2\u00da\35\3\2\2\2\u00db\u00d9\3\2\2\2\u00dc\u00dd\7\63\2\2\u00dd\u00de"+
		"\7\35\2\2\u00de\u00df\7\63\2\2\u00df\37\3\2\2\2\u00e0\u00e5\5\36\20\2"+
		"\u00e1\u00e2\7\34\2\2\u00e2\u00e4\5\36\20\2\u00e3\u00e1\3\2\2\2\u00e4"+
		"\u00e7\3\2\2\2\u00e5\u00e3\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6!\3\2\2\2"+
		"\u00e7\u00e5\3\2\2\2\u00e8\u00e9\5\36\20\2\u00e9\u00ea\7\17\2\2\u00ea"+
		"\u00eb\5\36\20\2\u00eb#\3\2\2\2\u00ec\u00f2\7\63\2\2\u00ed\u00ee\5\f\7"+
		"\2\u00ee\u00ef\7\63\2\2\u00ef\u00f0\7\16\2\2\u00f0\u00f1\5\"\22\2\u00f1"+
		"\u00f3\3\2\2\2\u00f2\u00ed\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4\u00f2\3\2"+
		"\2\2\u00f4\u00f5\3\2\2\2\u00f5%\3\2\2\2\u00f6\u00fb\5\n\6\2\u00f7\u00f8"+
		"\7\34\2\2\u00f8\u00fa\5\n\6\2\u00f9\u00f7\3\2\2\2\u00fa\u00fd\3\2\2\2"+
		"\u00fb\u00f9\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc\'\3\2\2\2\u00fd\u00fb\3"+
		"\2\2\2\u00fe\u0101\5*\26\2\u00ff\u0101\5,\27\2\u0100\u00fe\3\2\2\2\u0100"+
		"\u00ff\3\2\2\2\u0101\u0109\3\2\2\2\u0102\u0105\7\34\2\2\u0103\u0106\5"+
		"*\26\2\u0104\u0106\5,\27\2\u0105\u0103\3\2\2\2\u0105\u0104\3\2\2\2\u0106"+
		"\u0108\3\2\2\2\u0107\u0102\3\2\2\2\u0108\u010b\3\2\2\2\u0109\u0107\3\2"+
		"\2\2\u0109\u010a\3\2\2\2\u010a)\3\2\2\2\u010b\u0109\3\2\2\2\u010c\u010d"+
		"\7\63\2\2\u010d\u0113\5\6\4\2\u010e\u010f\7\63\2\2\u010f\u0110\5\6\4\2"+
		"\u0110\u0111\7\60\2\2\u0111\u0113\3\2\2\2\u0112\u010c\3\2\2\2\u0112\u010e"+
		"\3\2\2\2\u0113+\3\2\2\2\u0114\u0115\7\4\2\2\u0115\u0116\7\30\2\2\u0116"+
		"\u0117\7\63\2\2\u0117\u0118\7,\2\2\u0118-\3\2\2\2\27:kqv|\u0092\u009c"+
		"\u00a6\u00ae\u00b9\u00c1\u00c8\u00ce\u00d9\u00e5\u00f4\u00fb\u0100\u0105"+
		"\u0109\u0112";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}