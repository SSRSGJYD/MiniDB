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
		T__44=1, T__43=2, T__42=3, T__41=4, T__40=5, T__39=6, T__38=7, T__37=8, 
		T__36=9, T__35=10, T__34=11, T__33=12, T__32=13, T__31=14, T__30=15, T__29=16, 
		T__28=17, T__27=18, T__26=19, T__25=20, T__24=21, T__23=22, T__22=23, 
		T__21=24, T__20=25, T__19=26, T__18=27, T__17=28, T__16=29, T__15=30, 
		T__14=31, T__13=32, T__12=33, T__11=34, T__10=35, T__9=36, T__8=37, T__7=38, 
		T__6=39, T__5=40, T__4=41, T__3=42, T__2=43, T__1=44, T__0=45, Number=46, 
		Name=47, String=48, NEWLINE=49, WS=50;
	public static final String[] tokenNames = {
		"<INVALID>", "'full outer join'", "'primary key'", "'revoke'", "'char'", 
		"'grant'", "'set'", "'use database'", "'float'", "'delete from'", "'on'", 
		"'='", "'<='", "'drop table'", "'right outer join'", "'double'", "'from'", 
		"'int'", "'null'", "'drop database'", "'('", "'values'", "'*'", "'update'", 
		"','", "'.'", "'join'", "'long'", "'to'", "'show database'", "'>='", "'<'", 
		"'select'", "'>'", "'or'", "'left outer join'", "'<>'", "'where'", "'create database'", 
		"'with grant option'", "')'", "'and'", "'show databases'", "'insert into'", 
		"'not null'", "'create table'", "Number", "Name", "String", "NEWLINE", 
		"WS"
	};
	public static final int
		RULE_withGrant = 0, RULE_type = 1, RULE_op = 2, RULE_value = 3, RULE_join = 4, 
		RULE_lop = 5, RULE_sql = 6, RULE_logictree = 7, RULE_clogictree = 8, RULE_ccondition = 9, 
		RULE_condition = 10, RULE_set = 11, RULE_names = 12, RULE_cname = 13, 
		RULE_cnames = 14, RULE_onCondition = 15, RULE_jnames = 16, RULE_values = 17, 
		RULE_schema = 18, RULE_attribute = 19, RULE_constraint = 20;
	public static final String[] ruleNames = {
		"withGrant", "type", "op", "value", "join", "lop", "sql", "logictree", 
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
		enterRule(_localctx, 0, RULE_withGrant);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42); match(T__6);
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
		enterRule(_localctx, 2, RULE_type);
		try {
			setState(52);
			switch (_input.LA(1)) {
			case T__28:
				enterOuterAlt(_localctx, 1);
				{
				setState(44); match(T__28);
				}
				break;
			case T__18:
				enterOuterAlt(_localctx, 2);
				{
				setState(45); match(T__18);
				}
				break;
			case T__37:
				enterOuterAlt(_localctx, 3);
				{
				setState(46); match(T__37);
				}
				break;
			case T__30:
				enterOuterAlt(_localctx, 4);
				{
				setState(47); match(T__30);
				}
				break;
			case T__41:
				enterOuterAlt(_localctx, 5);
				{
				setState(48); match(T__41);
				setState(49); match(T__25);
				setState(50); match(Number);
				setState(51); match(T__5);
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
		enterRule(_localctx, 4, RULE_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
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
		enterRule(_localctx, 6, RULE_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
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
		enterRule(_localctx, 8, RULE_join);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__44) | (1L << T__31) | (1L << T__19) | (1L << T__10))) != 0)) ) {
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
		enterRule(_localctx, 10, RULE_lop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
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
		enterRule(_localctx, 12, RULE_sql);
		int _la;
		try {
			setState(145);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				_localctx = new CreateContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(62); match(T__0);
				setState(63); match(Name);
				setState(64); match(T__25);
				setState(65); schema();
				setState(66); match(T__5);
				}
				break;
			case 2:
				_localctx = new DropContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(68); match(T__32);
				setState(69); match(Name);
				}
				break;
			case 3:
				_localctx = new InsertAContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(70); match(T__2);
				setState(71); match(Name);
				setState(72); match(T__24);
				setState(73); match(T__25);
				setState(74); values();
				setState(75); match(T__5);
				}
				break;
			case 4:
				_localctx = new InsertBContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(77); match(T__2);
				setState(78); match(Name);
				setState(79); match(T__25);
				setState(80); names();
				setState(81); match(T__5);
				setState(82); match(T__24);
				setState(83); match(T__25);
				setState(84); values();
				setState(85); match(T__5);
				}
				break;
			case 5:
				_localctx = new DeleteContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(87); match(T__36);
				setState(88); match(Name);
				setState(89); match(T__8);
				setState(90); logictree(0);
				}
				break;
			case 6:
				_localctx = new UpdateContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(91); match(T__22);
				setState(92); match(Name);
				setState(93); match(T__39);
				setState(94); set();
				setState(95); match(T__8);
				setState(96); logictree(0);
				}
				break;
			case 7:
				_localctx = new SelectBContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(98); match(T__13);
				setState(101);
				switch (_input.LA(1)) {
				case Name:
					{
					setState(99); cnames();
					}
					break;
				case T__23:
					{
					setState(100); match(T__23);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(103); match(T__29);
				setState(104); jnames();
				setState(107);
				_la = _input.LA(1);
				if (_la==T__8) {
					{
					setState(105); match(T__8);
					setState(106); clogictree(0);
					}
				}

				}
				break;
			case 8:
				_localctx = new SelectAContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(109); match(T__13);
				setState(112);
				switch (_input.LA(1)) {
				case Name:
					{
					setState(110); names();
					}
					break;
				case T__23:
					{
					setState(111); match(T__23);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(114); match(T__29);
				setState(115); match(Name);
				setState(118);
				_la = _input.LA(1);
				if (_la==T__8) {
					{
					setState(116); match(T__8);
					setState(117); logictree(0);
					}
				}

				}
				break;
			case 9:
				_localctx = new CreatedbContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(120); match(T__7);
				setState(121); match(Name);
				}
				break;
			case 10:
				_localctx = new DropdbContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(122); match(T__26);
				setState(123); match(Name);
				}
				break;
			case 11:
				_localctx = new UsedbContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(124); match(T__38);
				setState(125); match(Name);
				}
				break;
			case 12:
				_localctx = new ShowContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(126); match(T__3);
				}
				break;
			case 13:
				_localctx = new ShowdbContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(127); match(T__16);
				setState(128); match(Name);
				}
				break;
			case 14:
				_localctx = new GrantContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(129); match(T__40);
				setState(130); match(Name);
				setState(131); match(T__35);
				setState(132); match(Name);
				setState(133); match(T__17);
				setState(134); match(Name);
				setState(136);
				_la = _input.LA(1);
				if (_la==T__6) {
					{
					setState(135); withGrant();
					}
				}

				}
				break;
			case 15:
				_localctx = new RevokeContext(_localctx);
				enterOuterAlt(_localctx, 15);
				{
				setState(138); match(T__42);
				setState(139); match(Name);
				setState(140); match(T__35);
				setState(141); match(Name);
				setState(142); match(T__29);
				setState(143); match(Name);
				}
				break;
			case 16:
				_localctx = new NewlineContext(_localctx);
				enterOuterAlt(_localctx, 16);
				{
				setState(144); match(NEWLINE);
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
		int _startState = 14;
		enterRecursionRule(_localctx, 14, RULE_logictree, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			switch (_input.LA(1)) {
			case T__25:
				{
				setState(148); match(T__25);
				setState(149); logictree(0);
				setState(150); lop();
				setState(151); logictree(0);
				setState(152); match(T__5);
				}
				break;
			case Name:
				{
				setState(154); condition();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(163);
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
					setState(157);
					if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
					setState(158); lop();
					setState(159); logictree(4);
					}
					} 
				}
				setState(165);
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
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_clogictree, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			switch (_input.LA(1)) {
			case T__25:
				{
				setState(167); match(T__25);
				setState(168); clogictree(0);
				setState(169); lop();
				setState(170); clogictree(0);
				setState(171); match(T__5);
				}
				break;
			case Name:
				{
				setState(173); ccondition();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(182);
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
					setState(176);
					if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
					setState(177); lop();
					setState(178); clogictree(4);
					}
					} 
				}
				setState(184);
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
		enterRule(_localctx, 18, RULE_ccondition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185); cname();
			setState(186); op();
			setState(189);
			switch (_input.LA(1)) {
			case T__27:
			case Number:
			case String:
				{
				setState(187); value();
				}
				break;
			case Name:
				{
				setState(188); cname();
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
		enterRule(_localctx, 20, RULE_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(191); match(Name);
			setState(192); op();
			setState(195);
			switch (_input.LA(1)) {
			case T__27:
			case Number:
			case String:
				{
				setState(193); value();
				}
				break;
			case Name:
				{
				setState(194); match(Name);
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
		enterRule(_localctx, 22, RULE_set);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197); match(Name);
			setState(198); match(T__34);
			setState(199); value();
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
		enterRule(_localctx, 24, RULE_names);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(201); match(Name);
			setState(206);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__21) {
				{
				{
				setState(202); match(T__21);
				setState(203); match(Name);
				}
				}
				setState(208);
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
		enterRule(_localctx, 26, RULE_cname);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(209); match(Name);
			setState(210); match(T__20);
			setState(211); match(Name);
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
		enterRule(_localctx, 28, RULE_cnames);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(213); cname();
			setState(218);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__21) {
				{
				{
				setState(214); match(T__21);
				setState(215); cname();
				}
				}
				setState(220);
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
		enterRule(_localctx, 30, RULE_onCondition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(221); cname();
			setState(222); match(T__34);
			setState(223); cname();
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
		enterRule(_localctx, 32, RULE_jnames);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(225); match(Name);
			setState(231); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(226); join();
				setState(227); match(Name);
				setState(228); match(T__35);
				setState(229); onCondition();
				}
				}
				setState(233); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__44) | (1L << T__31) | (1L << T__19) | (1L << T__10))) != 0) );
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
		enterRule(_localctx, 34, RULE_values);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(235); value();
			setState(240);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__21) {
				{
				{
				setState(236); match(T__21);
				setState(237); value();
				}
				}
				setState(242);
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
		enterRule(_localctx, 36, RULE_schema);
		int _la;
		try {
			_localctx = new AttrconsContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(245);
			switch (_input.LA(1)) {
			case Name:
				{
				setState(243); attribute();
				}
				break;
			case T__43:
				{
				setState(244); constraint();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(254);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__21) {
				{
				{
				setState(247); match(T__21);
				setState(250);
				switch (_input.LA(1)) {
				case Name:
					{
					setState(248); attribute();
					}
					break;
				case T__43:
					{
					setState(249); constraint();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				}
				setState(256);
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
		enterRule(_localctx, 38, RULE_attribute);
		try {
			setState(263);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				_localctx = new NormalattrContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(257); match(Name);
				setState(258); type();
				}
				break;
			case 2:
				_localctx = new NotnullattrContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(259); match(Name);
				setState(260); type();
				setState(261); match(T__1);
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
		enterRule(_localctx, 40, RULE_constraint);
		try {
			_localctx = new PrimarykeyContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(265); match(T__43);
			setState(266); match(T__25);
			setState(267); match(Name);
			setState(268); match(T__5);
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
		case 7: return logictree_sempred((LogictreeContext)_localctx, predIndex);
		case 8: return clogictree_sempred((ClogictreeContext)_localctx, predIndex);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\64\u0111\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\5\3\67\n\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\5\bh\n\b\3\b\3\b\3\b\3\b\5\bn\n\b\3\b\3\b\3\b\5\bs\n\b\3\b\3\b\3\b\3"+
		"\b\5\by\n\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\5\b\u008b\n\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u0094\n\b\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u009e\n\t\3\t\3\t\3\t\3\t\7\t\u00a4\n\t\f"+
		"\t\16\t\u00a7\13\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u00b1\n\n\3\n\3"+
		"\n\3\n\3\n\7\n\u00b7\n\n\f\n\16\n\u00ba\13\n\3\13\3\13\3\13\3\13\5\13"+
		"\u00c0\n\13\3\f\3\f\3\f\3\f\5\f\u00c6\n\f\3\r\3\r\3\r\3\r\3\16\3\16\3"+
		"\16\7\16\u00cf\n\16\f\16\16\16\u00d2\13\16\3\17\3\17\3\17\3\17\3\20\3"+
		"\20\3\20\7\20\u00db\n\20\f\20\16\20\u00de\13\20\3\21\3\21\3\21\3\21\3"+
		"\22\3\22\3\22\3\22\3\22\3\22\6\22\u00ea\n\22\r\22\16\22\u00eb\3\23\3\23"+
		"\3\23\7\23\u00f1\n\23\f\23\16\23\u00f4\13\23\3\24\3\24\5\24\u00f8\n\24"+
		"\3\24\3\24\3\24\5\24\u00fd\n\24\7\24\u00ff\n\24\f\24\16\24\u0102\13\24"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u010a\n\25\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\2\4\20\22\27\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*\2\6\6"+
		"\2\r\16 !##&&\5\2\24\24\60\60\62\62\6\2\3\3\20\20\34\34%%\4\2$$++\u0121"+
		"\2,\3\2\2\2\4\66\3\2\2\2\68\3\2\2\2\b:\3\2\2\2\n<\3\2\2\2\f>\3\2\2\2\16"+
		"\u0093\3\2\2\2\20\u009d\3\2\2\2\22\u00b0\3\2\2\2\24\u00bb\3\2\2\2\26\u00c1"+
		"\3\2\2\2\30\u00c7\3\2\2\2\32\u00cb\3\2\2\2\34\u00d3\3\2\2\2\36\u00d7\3"+
		"\2\2\2 \u00df\3\2\2\2\"\u00e3\3\2\2\2$\u00ed\3\2\2\2&\u00f7\3\2\2\2(\u0109"+
		"\3\2\2\2*\u010b\3\2\2\2,-\7)\2\2-\3\3\2\2\2.\67\7\23\2\2/\67\7\35\2\2"+
		"\60\67\7\n\2\2\61\67\7\21\2\2\62\63\7\6\2\2\63\64\7\26\2\2\64\65\7\60"+
		"\2\2\65\67\7*\2\2\66.\3\2\2\2\66/\3\2\2\2\66\60\3\2\2\2\66\61\3\2\2\2"+
		"\66\62\3\2\2\2\67\5\3\2\2\289\t\2\2\29\7\3\2\2\2:;\t\3\2\2;\t\3\2\2\2"+
		"<=\t\4\2\2=\13\3\2\2\2>?\t\5\2\2?\r\3\2\2\2@A\7/\2\2AB\7\61\2\2BC\7\26"+
		"\2\2CD\5&\24\2DE\7*\2\2E\u0094\3\2\2\2FG\7\17\2\2G\u0094\7\61\2\2HI\7"+
		"-\2\2IJ\7\61\2\2JK\7\27\2\2KL\7\26\2\2LM\5$\23\2MN\7*\2\2N\u0094\3\2\2"+
		"\2OP\7-\2\2PQ\7\61\2\2QR\7\26\2\2RS\5\32\16\2ST\7*\2\2TU\7\27\2\2UV\7"+
		"\26\2\2VW\5$\23\2WX\7*\2\2X\u0094\3\2\2\2YZ\7\13\2\2Z[\7\61\2\2[\\\7\'"+
		"\2\2\\\u0094\5\20\t\2]^\7\31\2\2^_\7\61\2\2_`\7\b\2\2`a\5\30\r\2ab\7\'"+
		"\2\2bc\5\20\t\2c\u0094\3\2\2\2dg\7\"\2\2eh\5\36\20\2fh\7\30\2\2ge\3\2"+
		"\2\2gf\3\2\2\2hi\3\2\2\2ij\7\22\2\2jm\5\"\22\2kl\7\'\2\2ln\5\22\n\2mk"+
		"\3\2\2\2mn\3\2\2\2n\u0094\3\2\2\2or\7\"\2\2ps\5\32\16\2qs\7\30\2\2rp\3"+
		"\2\2\2rq\3\2\2\2st\3\2\2\2tu\7\22\2\2ux\7\61\2\2vw\7\'\2\2wy\5\20\t\2"+
		"xv\3\2\2\2xy\3\2\2\2y\u0094\3\2\2\2z{\7(\2\2{\u0094\7\61\2\2|}\7\25\2"+
		"\2}\u0094\7\61\2\2~\177\7\t\2\2\177\u0094\7\61\2\2\u0080\u0094\7,\2\2"+
		"\u0081\u0082\7\37\2\2\u0082\u0094\7\61\2\2\u0083\u0084\7\7\2\2\u0084\u0085"+
		"\7\61\2\2\u0085\u0086\7\f\2\2\u0086\u0087\7\61\2\2\u0087\u0088\7\36\2"+
		"\2\u0088\u008a\7\61\2\2\u0089\u008b\5\2\2\2\u008a\u0089\3\2\2\2\u008a"+
		"\u008b\3\2\2\2\u008b\u0094\3\2\2\2\u008c\u008d\7\5\2\2\u008d\u008e\7\61"+
		"\2\2\u008e\u008f\7\f\2\2\u008f\u0090\7\61\2\2\u0090\u0091\7\22\2\2\u0091"+
		"\u0094\7\61\2\2\u0092\u0094\7\63\2\2\u0093@\3\2\2\2\u0093F\3\2\2\2\u0093"+
		"H\3\2\2\2\u0093O\3\2\2\2\u0093Y\3\2\2\2\u0093]\3\2\2\2\u0093d\3\2\2\2"+
		"\u0093o\3\2\2\2\u0093z\3\2\2\2\u0093|\3\2\2\2\u0093~\3\2\2\2\u0093\u0080"+
		"\3\2\2\2\u0093\u0081\3\2\2\2\u0093\u0083\3\2\2\2\u0093\u008c\3\2\2\2\u0093"+
		"\u0092\3\2\2\2\u0094\17\3\2\2\2\u0095\u0096\b\t\1\2\u0096\u0097\7\26\2"+
		"\2\u0097\u0098\5\20\t\2\u0098\u0099\5\f\7\2\u0099\u009a\5\20\t\2\u009a"+
		"\u009b\7*\2\2\u009b\u009e\3\2\2\2\u009c\u009e\5\26\f\2\u009d\u0095\3\2"+
		"\2\2\u009d\u009c\3\2\2\2\u009e\u00a5\3\2\2\2\u009f\u00a0\f\5\2\2\u00a0"+
		"\u00a1\5\f\7\2\u00a1\u00a2\5\20\t\6\u00a2\u00a4\3\2\2\2\u00a3\u009f\3"+
		"\2\2\2\u00a4\u00a7\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6"+
		"\21\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a8\u00a9\b\n\1\2\u00a9\u00aa\7\26\2"+
		"\2\u00aa\u00ab\5\22\n\2\u00ab\u00ac\5\f\7\2\u00ac\u00ad\5\22\n\2\u00ad"+
		"\u00ae\7*\2\2\u00ae\u00b1\3\2\2\2\u00af\u00b1\5\24\13\2\u00b0\u00a8\3"+
		"\2\2\2\u00b0\u00af\3\2\2\2\u00b1\u00b8\3\2\2\2\u00b2\u00b3\f\5\2\2\u00b3"+
		"\u00b4\5\f\7\2\u00b4\u00b5\5\22\n\6\u00b5\u00b7\3\2\2\2\u00b6\u00b2\3"+
		"\2\2\2\u00b7\u00ba\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9"+
		"\23\3\2\2\2\u00ba\u00b8\3\2\2\2\u00bb\u00bc\5\34\17\2\u00bc\u00bf\5\6"+
		"\4\2\u00bd\u00c0\5\b\5\2\u00be\u00c0\5\34\17\2\u00bf\u00bd\3\2\2\2\u00bf"+
		"\u00be\3\2\2\2\u00c0\25\3\2\2\2\u00c1\u00c2\7\61\2\2\u00c2\u00c5\5\6\4"+
		"\2\u00c3\u00c6\5\b\5\2\u00c4\u00c6\7\61\2\2\u00c5\u00c3\3\2\2\2\u00c5"+
		"\u00c4\3\2\2\2\u00c6\27\3\2\2\2\u00c7\u00c8\7\61\2\2\u00c8\u00c9\7\r\2"+
		"\2\u00c9\u00ca\5\b\5\2\u00ca\31\3\2\2\2\u00cb\u00d0\7\61\2\2\u00cc\u00cd"+
		"\7\32\2\2\u00cd\u00cf\7\61\2\2\u00ce\u00cc\3\2\2\2\u00cf\u00d2\3\2\2\2"+
		"\u00d0\u00ce\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\33\3\2\2\2\u00d2\u00d0"+
		"\3\2\2\2\u00d3\u00d4\7\61\2\2\u00d4\u00d5\7\33\2\2\u00d5\u00d6\7\61\2"+
		"\2\u00d6\35\3\2\2\2\u00d7\u00dc\5\34\17\2\u00d8\u00d9\7\32\2\2\u00d9\u00db"+
		"\5\34\17\2\u00da\u00d8\3\2\2\2\u00db\u00de\3\2\2\2\u00dc\u00da\3\2\2\2"+
		"\u00dc\u00dd\3\2\2\2\u00dd\37\3\2\2\2\u00de\u00dc\3\2\2\2\u00df\u00e0"+
		"\5\34\17\2\u00e0\u00e1\7\r\2\2\u00e1\u00e2\5\34\17\2\u00e2!\3\2\2\2\u00e3"+
		"\u00e9\7\61\2\2\u00e4\u00e5\5\n\6\2\u00e5\u00e6\7\61\2\2\u00e6\u00e7\7"+
		"\f\2\2\u00e7\u00e8\5 \21\2\u00e8\u00ea\3\2\2\2\u00e9\u00e4\3\2\2\2\u00ea"+
		"\u00eb\3\2\2\2\u00eb\u00e9\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec#\3\2\2\2"+
		"\u00ed\u00f2\5\b\5\2\u00ee\u00ef\7\32\2\2\u00ef\u00f1\5\b\5\2\u00f0\u00ee"+
		"\3\2\2\2\u00f1\u00f4\3\2\2\2\u00f2\u00f0\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3"+
		"%\3\2\2\2\u00f4\u00f2\3\2\2\2\u00f5\u00f8\5(\25\2\u00f6\u00f8\5*\26\2"+
		"\u00f7\u00f5\3\2\2\2\u00f7\u00f6\3\2\2\2\u00f8\u0100\3\2\2\2\u00f9\u00fc"+
		"\7\32\2\2\u00fa\u00fd\5(\25\2\u00fb\u00fd\5*\26\2\u00fc\u00fa\3\2\2\2"+
		"\u00fc\u00fb\3\2\2\2\u00fd\u00ff\3\2\2\2\u00fe\u00f9\3\2\2\2\u00ff\u0102"+
		"\3\2\2\2\u0100\u00fe\3\2\2\2\u0100\u0101\3\2\2\2\u0101\'\3\2\2\2\u0102"+
		"\u0100\3\2\2\2\u0103\u0104\7\61\2\2\u0104\u010a\5\4\3\2\u0105\u0106\7"+
		"\61\2\2\u0106\u0107\5\4\3\2\u0107\u0108\7.\2\2\u0108\u010a\3\2\2\2\u0109"+
		"\u0103\3\2\2\2\u0109\u0105\3\2\2\2\u010a)\3\2\2\2\u010b\u010c\7\4\2\2"+
		"\u010c\u010d\7\26\2\2\u010d\u010e\7\61\2\2\u010e\u010f\7*\2\2\u010f+\3"+
		"\2\2\2\27\66gmrx\u008a\u0093\u009d\u00a5\u00b0\u00b8\u00bf\u00c5\u00d0"+
		"\u00dc\u00eb\u00f2\u00f7\u00fc\u0100\u0109";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}