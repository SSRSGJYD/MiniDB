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
		T__40=1, T__39=2, T__38=3, T__37=4, T__36=5, T__35=6, T__34=7, T__33=8, 
		T__32=9, T__31=10, T__30=11, T__29=12, T__28=13, T__27=14, T__26=15, T__25=16, 
		T__24=17, T__23=18, T__22=19, T__21=20, T__20=21, T__19=22, T__18=23, 
		T__17=24, T__16=25, T__15=26, T__14=27, T__13=28, T__12=29, T__11=30, 
		T__10=31, T__9=32, T__8=33, T__7=34, T__6=35, T__5=36, T__4=37, T__3=38, 
		T__2=39, T__1=40, T__0=41, Number=42, Name=43, String=44, NEWLINE=45, 
		WS=46;
	public static final String[] tokenNames = {
		"<INVALID>", "'full outer join'", "'primary key'", "'char'", "'set'", 
		"'use database'", "'float'", "'delete from'", "'on'", "'='", "'<='", "'drop table'", 
		"'right outer join'", "'double'", "'from'", "'int'", "'null'", "'drop database'", 
		"'('", "'values'", "'*'", "'update'", "','", "'.'", "'join'", "'long'", 
		"'show database'", "'>='", "'<'", "'select'", "'>'", "'or'", "'left outer join'", 
		"'<>'", "'where'", "'create database'", "')'", "'and'", "'show databases'", 
		"'insert into'", "'not null'", "'create table'", "Number", "Name", "String", 
		"NEWLINE", "WS"
	};
	public static final int
		RULE_type = 0, RULE_op = 1, RULE_value = 2, RULE_join = 3, RULE_lop = 4, 
		RULE_sql = 5, RULE_logictree = 6, RULE_clogictree = 7, RULE_ccondition = 8, 
		RULE_condition = 9, RULE_set = 10, RULE_names = 11, RULE_cname = 12, RULE_cnames = 13, 
		RULE_onCondition = 14, RULE_jnames = 15, RULE_values = 16, RULE_schema = 17, 
		RULE_attribute = 18, RULE_constraint = 19;
	public static final String[] ruleNames = {
		"type", "op", "value", "join", "lop", "sql", "logictree", "clogictree", 
		"ccondition", "condition", "set", "names", "cname", "cnames", "onCondition", 
		"jnames", "values", "schema", "attribute", "constraint"
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
		enterRule(_localctx, 0, RULE_type);
		try {
			setState(48);
			switch (_input.LA(1)) {
			case T__26:
				enterOuterAlt(_localctx, 1);
				{
				setState(40); match(T__26);
				}
				break;
			case T__16:
				enterOuterAlt(_localctx, 2);
				{
				setState(41); match(T__16);
				}
				break;
			case T__35:
				enterOuterAlt(_localctx, 3);
				{
				setState(42); match(T__35);
				}
				break;
			case T__28:
				enterOuterAlt(_localctx, 4);
				{
				setState(43); match(T__28);
				}
				break;
			case T__38:
				enterOuterAlt(_localctx, 5);
				{
				setState(44); match(T__38);
				setState(45); match(T__23);
				setState(46); match(Number);
				setState(47); match(T__5);
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
		enterRule(_localctx, 2, RULE_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__32) | (1L << T__31) | (1L << T__14) | (1L << T__13) | (1L << T__11) | (1L << T__8))) != 0)) ) {
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
		enterRule(_localctx, 4, RULE_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__25) | (1L << Number) | (1L << String))) != 0)) ) {
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
		enterRule(_localctx, 6, RULE_join);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__40) | (1L << T__29) | (1L << T__17) | (1L << T__9))) != 0)) ) {
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
		enterRule(_localctx, 8, RULE_lop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			_la = _input.LA(1);
			if ( !(_la==T__10 || _la==T__4) ) {
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

	public final SqlContext sql() throws RecognitionException {
		SqlContext _localctx = new SqlContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_sql);
		int _la;
		try {
			setState(126);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				_localctx = new CreateContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(58); match(T__0);
				setState(59); match(Name);
				setState(60); match(T__23);
				setState(61); schema();
				setState(62); match(T__5);
				}
				break;
			case 2:
				_localctx = new DropContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(64); match(T__30);
				setState(65); match(Name);
				}
				break;
			case 3:
				_localctx = new InsertAContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(66); match(T__2);
				setState(67); match(Name);
				setState(68); match(T__22);
				setState(69); match(T__23);
				setState(70); values();
				setState(71); match(T__5);
				}
				break;
			case 4:
				_localctx = new InsertBContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(73); match(T__2);
				setState(74); match(Name);
				setState(75); match(T__23);
				setState(76); names();
				setState(77); match(T__5);
				setState(78); match(T__22);
				setState(79); match(T__23);
				setState(80); values();
				setState(81); match(T__5);
				}
				break;
			case 5:
				_localctx = new DeleteContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(83); match(T__34);
				setState(84); match(Name);
				setState(85); match(T__7);
				setState(86); logictree(0);
				}
				break;
			case 6:
				_localctx = new UpdateContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(87); match(T__20);
				setState(88); match(Name);
				setState(89); match(T__37);
				setState(90); set();
				setState(91); match(T__7);
				setState(92); logictree(0);
				}
				break;
			case 7:
				_localctx = new SelectBContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(94); match(T__12);
				setState(97);
				switch (_input.LA(1)) {
				case Name:
					{
					setState(95); cnames();
					}
					break;
				case T__21:
					{
					setState(96); match(T__21);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(99); match(T__27);
				setState(100); jnames();
				setState(103);
				_la = _input.LA(1);
				if (_la==T__7) {
					{
					setState(101); match(T__7);
					setState(102); clogictree(0);
					}
				}

				}
				break;
			case 8:
				_localctx = new SelectAContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(105); match(T__12);
				setState(108);
				switch (_input.LA(1)) {
				case Name:
					{
					setState(106); names();
					}
					break;
				case T__21:
					{
					setState(107); match(T__21);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(110); match(T__27);
				setState(111); match(Name);
				setState(114);
				_la = _input.LA(1);
				if (_la==T__7) {
					{
					setState(112); match(T__7);
					setState(113); logictree(0);
					}
				}

				}
				break;
			case 9:
				_localctx = new CreatedbContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(116); match(T__6);
				setState(117); match(Name);
				}
				break;
			case 10:
				_localctx = new DropdbContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(118); match(T__24);
				setState(119); match(Name);
				}
				break;
			case 11:
				_localctx = new UsedbContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(120); match(T__36);
				setState(121); match(Name);
				}
				break;
			case 12:
				_localctx = new ShowContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(122); match(T__3);
				}
				break;
			case 13:
				_localctx = new ShowdbContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(123); match(T__15);
				setState(124); match(Name);
				}
				break;
			case 14:
				_localctx = new NewlineContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(125); match(NEWLINE);
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
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_logictree, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			switch (_input.LA(1)) {
			case T__23:
				{
				setState(129); match(T__23);
				setState(130); logictree(0);
				setState(131); lop();
				setState(132); logictree(0);
				setState(133); match(T__5);
				}
				break;
			case Name:
				{
				setState(135); condition();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(144);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new LogictreeContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_logictree);
					setState(138);
					if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
					setState(139); lop();
					setState(140); logictree(4);
					}
					} 
				}
				setState(146);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
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
		int _startState = 14;
		enterRecursionRule(_localctx, 14, RULE_clogictree, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			switch (_input.LA(1)) {
			case T__23:
				{
				setState(148); match(T__23);
				setState(149); clogictree(0);
				setState(150); lop();
				setState(151); clogictree(0);
				setState(152); match(T__5);
				}
				break;
			case Name:
				{
				setState(154); ccondition();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(163);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ClogictreeContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_clogictree);
					setState(157);
					if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
					setState(158); lop();
					setState(159); clogictree(4);
					}
					} 
				}
				setState(165);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
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
		enterRule(_localctx, 16, RULE_ccondition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(166); cname();
			setState(167); op();
			setState(170);
			switch (_input.LA(1)) {
			case T__25:
			case Number:
			case String:
				{
				setState(168); value();
				}
				break;
			case Name:
				{
				setState(169); cname();
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
		enterRule(_localctx, 18, RULE_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172); match(Name);
			setState(173); op();
			setState(176);
			switch (_input.LA(1)) {
			case T__25:
			case Number:
			case String:
				{
				setState(174); value();
				}
				break;
			case Name:
				{
				setState(175); match(Name);
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
		enterRule(_localctx, 20, RULE_set);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(178); match(Name);
			setState(179); match(T__32);
			setState(180); value();
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
		enterRule(_localctx, 22, RULE_names);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182); match(Name);
			setState(187);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__19) {
				{
				{
				setState(183); match(T__19);
				setState(184); match(Name);
				}
				}
				setState(189);
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
		enterRule(_localctx, 24, RULE_cname);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(190); match(Name);
			setState(191); match(T__18);
			setState(192); match(Name);
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
		enterRule(_localctx, 26, RULE_cnames);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194); cname();
			setState(199);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__19) {
				{
				{
				setState(195); match(T__19);
				setState(196); cname();
				}
				}
				setState(201);
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
		enterRule(_localctx, 28, RULE_onCondition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(202); cname();
			setState(203); match(T__32);
			setState(204); cname();
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
		enterRule(_localctx, 30, RULE_jnames);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(206); match(Name);
			setState(212); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(207); join();
				setState(208); match(Name);
				setState(209); match(T__33);
				setState(210); onCondition();
				}
				}
				setState(214); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__40) | (1L << T__29) | (1L << T__17) | (1L << T__9))) != 0) );
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
		enterRule(_localctx, 32, RULE_values);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216); value();
			setState(221);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__19) {
				{
				{
				setState(217); match(T__19);
				setState(218); value();
				}
				}
				setState(223);
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
		enterRule(_localctx, 34, RULE_schema);
		int _la;
		try {
			_localctx = new AttrconsContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(226);
			switch (_input.LA(1)) {
			case Name:
				{
				setState(224); attribute();
				}
				break;
			case T__39:
				{
				setState(225); constraint();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(235);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__19) {
				{
				{
				setState(228); match(T__19);
				setState(231);
				switch (_input.LA(1)) {
				case Name:
					{
					setState(229); attribute();
					}
					break;
				case T__39:
					{
					setState(230); constraint();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				}
				setState(237);
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
		enterRule(_localctx, 36, RULE_attribute);
		try {
			setState(244);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				_localctx = new NormalattrContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(238); match(Name);
				setState(239); type();
				}
				break;
			case 2:
				_localctx = new NotnullattrContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(240); match(Name);
				setState(241); type();
				setState(242); match(T__1);
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
		enterRule(_localctx, 38, RULE_constraint);
		try {
			_localctx = new PrimarykeyContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(246); match(T__39);
			setState(247); match(T__23);
			setState(248); match(Name);
			setState(249); match(T__5);
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
		case 6: return logictree_sempred((LogictreeContext)_localctx, predIndex);
		case 7: return clogictree_sempred((ClogictreeContext)_localctx, predIndex);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\60\u00fe\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2\63"+
		"\n\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7d\n\7\3\7\3\7"+
		"\3\7\3\7\5\7j\n\7\3\7\3\7\3\7\5\7o\n\7\3\7\3\7\3\7\3\7\5\7u\n\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u0081\n\7\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\5\b\u008b\n\b\3\b\3\b\3\b\3\b\7\b\u0091\n\b\f\b\16\b\u0094"+
		"\13\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u009e\n\t\3\t\3\t\3\t\3\t\7"+
		"\t\u00a4\n\t\f\t\16\t\u00a7\13\t\3\n\3\n\3\n\3\n\5\n\u00ad\n\n\3\13\3"+
		"\13\3\13\3\13\5\13\u00b3\n\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\7\r\u00bc\n"+
		"\r\f\r\16\r\u00bf\13\r\3\16\3\16\3\16\3\16\3\17\3\17\3\17\7\17\u00c8\n"+
		"\17\f\17\16\17\u00cb\13\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\6\21\u00d7\n\21\r\21\16\21\u00d8\3\22\3\22\3\22\7\22\u00de\n\22"+
		"\f\22\16\22\u00e1\13\22\3\23\3\23\5\23\u00e5\n\23\3\23\3\23\3\23\5\23"+
		"\u00ea\n\23\7\23\u00ec\n\23\f\23\16\23\u00ef\13\23\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\5\24\u00f7\n\24\3\25\3\25\3\25\3\25\3\25\3\25\2\4\16\20\26"+
		"\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(\2\6\6\2\13\f\35\36  ##\5"+
		"\2\22\22,,..\6\2\3\3\16\16\32\32\"\"\4\2!!\'\'\u010c\2\62\3\2\2\2\4\64"+
		"\3\2\2\2\6\66\3\2\2\2\b8\3\2\2\2\n:\3\2\2\2\f\u0080\3\2\2\2\16\u008a\3"+
		"\2\2\2\20\u009d\3\2\2\2\22\u00a8\3\2\2\2\24\u00ae\3\2\2\2\26\u00b4\3\2"+
		"\2\2\30\u00b8\3\2\2\2\32\u00c0\3\2\2\2\34\u00c4\3\2\2\2\36\u00cc\3\2\2"+
		"\2 \u00d0\3\2\2\2\"\u00da\3\2\2\2$\u00e4\3\2\2\2&\u00f6\3\2\2\2(\u00f8"+
		"\3\2\2\2*\63\7\21\2\2+\63\7\33\2\2,\63\7\b\2\2-\63\7\17\2\2./\7\5\2\2"+
		"/\60\7\24\2\2\60\61\7,\2\2\61\63\7&\2\2\62*\3\2\2\2\62+\3\2\2\2\62,\3"+
		"\2\2\2\62-\3\2\2\2\62.\3\2\2\2\63\3\3\2\2\2\64\65\t\2\2\2\65\5\3\2\2\2"+
		"\66\67\t\3\2\2\67\7\3\2\2\289\t\4\2\29\t\3\2\2\2:;\t\5\2\2;\13\3\2\2\2"+
		"<=\7+\2\2=>\7-\2\2>?\7\24\2\2?@\5$\23\2@A\7&\2\2A\u0081\3\2\2\2BC\7\r"+
		"\2\2C\u0081\7-\2\2DE\7)\2\2EF\7-\2\2FG\7\25\2\2GH\7\24\2\2HI\5\"\22\2"+
		"IJ\7&\2\2J\u0081\3\2\2\2KL\7)\2\2LM\7-\2\2MN\7\24\2\2NO\5\30\r\2OP\7&"+
		"\2\2PQ\7\25\2\2QR\7\24\2\2RS\5\"\22\2ST\7&\2\2T\u0081\3\2\2\2UV\7\t\2"+
		"\2VW\7-\2\2WX\7$\2\2X\u0081\5\16\b\2YZ\7\27\2\2Z[\7-\2\2[\\\7\6\2\2\\"+
		"]\5\26\f\2]^\7$\2\2^_\5\16\b\2_\u0081\3\2\2\2`c\7\37\2\2ad\5\34\17\2b"+
		"d\7\26\2\2ca\3\2\2\2cb\3\2\2\2de\3\2\2\2ef\7\20\2\2fi\5 \21\2gh\7$\2\2"+
		"hj\5\20\t\2ig\3\2\2\2ij\3\2\2\2j\u0081\3\2\2\2kn\7\37\2\2lo\5\30\r\2m"+
		"o\7\26\2\2nl\3\2\2\2nm\3\2\2\2op\3\2\2\2pq\7\20\2\2qt\7-\2\2rs\7$\2\2"+
		"su\5\16\b\2tr\3\2\2\2tu\3\2\2\2u\u0081\3\2\2\2vw\7%\2\2w\u0081\7-\2\2"+
		"xy\7\23\2\2y\u0081\7-\2\2z{\7\7\2\2{\u0081\7-\2\2|\u0081\7(\2\2}~\7\34"+
		"\2\2~\u0081\7-\2\2\177\u0081\7/\2\2\u0080<\3\2\2\2\u0080B\3\2\2\2\u0080"+
		"D\3\2\2\2\u0080K\3\2\2\2\u0080U\3\2\2\2\u0080Y\3\2\2\2\u0080`\3\2\2\2"+
		"\u0080k\3\2\2\2\u0080v\3\2\2\2\u0080x\3\2\2\2\u0080z\3\2\2\2\u0080|\3"+
		"\2\2\2\u0080}\3\2\2\2\u0080\177\3\2\2\2\u0081\r\3\2\2\2\u0082\u0083\b"+
		"\b\1\2\u0083\u0084\7\24\2\2\u0084\u0085\5\16\b\2\u0085\u0086\5\n\6\2\u0086"+
		"\u0087\5\16\b\2\u0087\u0088\7&\2\2\u0088\u008b\3\2\2\2\u0089\u008b\5\24"+
		"\13\2\u008a\u0082\3\2\2\2\u008a\u0089\3\2\2\2\u008b\u0092\3\2\2\2\u008c"+
		"\u008d\f\5\2\2\u008d\u008e\5\n\6\2\u008e\u008f\5\16\b\6\u008f\u0091\3"+
		"\2\2\2\u0090\u008c\3\2\2\2\u0091\u0094\3\2\2\2\u0092\u0090\3\2\2\2\u0092"+
		"\u0093\3\2\2\2\u0093\17\3\2\2\2\u0094\u0092\3\2\2\2\u0095\u0096\b\t\1"+
		"\2\u0096\u0097\7\24\2\2\u0097\u0098\5\20\t\2\u0098\u0099\5\n\6\2\u0099"+
		"\u009a\5\20\t\2\u009a\u009b\7&\2\2\u009b\u009e\3\2\2\2\u009c\u009e\5\22"+
		"\n\2\u009d\u0095\3\2\2\2\u009d\u009c\3\2\2\2\u009e\u00a5\3\2\2\2\u009f"+
		"\u00a0\f\5\2\2\u00a0\u00a1\5\n\6\2\u00a1\u00a2\5\20\t\6\u00a2\u00a4\3"+
		"\2\2\2\u00a3\u009f\3\2\2\2\u00a4\u00a7\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a5"+
		"\u00a6\3\2\2\2\u00a6\21\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a8\u00a9\5\32\16"+
		"\2\u00a9\u00ac\5\4\3\2\u00aa\u00ad\5\6\4\2\u00ab\u00ad\5\32\16\2\u00ac"+
		"\u00aa\3\2\2\2\u00ac\u00ab\3\2\2\2\u00ad\23\3\2\2\2\u00ae\u00af\7-\2\2"+
		"\u00af\u00b2\5\4\3\2\u00b0\u00b3\5\6\4\2\u00b1\u00b3\7-\2\2\u00b2\u00b0"+
		"\3\2\2\2\u00b2\u00b1\3\2\2\2\u00b3\25\3\2\2\2\u00b4\u00b5\7-\2\2\u00b5"+
		"\u00b6\7\13\2\2\u00b6\u00b7\5\6\4\2\u00b7\27\3\2\2\2\u00b8\u00bd\7-\2"+
		"\2\u00b9\u00ba\7\30\2\2\u00ba\u00bc\7-\2\2\u00bb\u00b9\3\2\2\2\u00bc\u00bf"+
		"\3\2\2\2\u00bd\u00bb\3\2\2\2\u00bd\u00be\3\2\2\2\u00be\31\3\2\2\2\u00bf"+
		"\u00bd\3\2\2\2\u00c0\u00c1\7-\2\2\u00c1\u00c2\7\31\2\2\u00c2\u00c3\7-"+
		"\2\2\u00c3\33\3\2\2\2\u00c4\u00c9\5\32\16\2\u00c5\u00c6\7\30\2\2\u00c6"+
		"\u00c8\5\32\16\2\u00c7\u00c5\3\2\2\2\u00c8\u00cb\3\2\2\2\u00c9\u00c7\3"+
		"\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\35\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cc"+
		"\u00cd\5\32\16\2\u00cd\u00ce\7\13\2\2\u00ce\u00cf\5\32\16\2\u00cf\37\3"+
		"\2\2\2\u00d0\u00d6\7-\2\2\u00d1\u00d2\5\b\5\2\u00d2\u00d3\7-\2\2\u00d3"+
		"\u00d4\7\n\2\2\u00d4\u00d5\5\36\20\2\u00d5\u00d7\3\2\2\2\u00d6\u00d1\3"+
		"\2\2\2\u00d7\u00d8\3\2\2\2\u00d8\u00d6\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9"+
		"!\3\2\2\2\u00da\u00df\5\6\4\2\u00db\u00dc\7\30\2\2\u00dc\u00de\5\6\4\2"+
		"\u00dd\u00db\3\2\2\2\u00de\u00e1\3\2\2\2\u00df\u00dd\3\2\2\2\u00df\u00e0"+
		"\3\2\2\2\u00e0#\3\2\2\2\u00e1\u00df\3\2\2\2\u00e2\u00e5\5&\24\2\u00e3"+
		"\u00e5\5(\25\2\u00e4\u00e2\3\2\2\2\u00e4\u00e3\3\2\2\2\u00e5\u00ed\3\2"+
		"\2\2\u00e6\u00e9\7\30\2\2\u00e7\u00ea\5&\24\2\u00e8\u00ea\5(\25\2\u00e9"+
		"\u00e7\3\2\2\2\u00e9\u00e8\3\2\2\2\u00ea\u00ec\3\2\2\2\u00eb\u00e6\3\2"+
		"\2\2\u00ec\u00ef\3\2\2\2\u00ed\u00eb\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee"+
		"%\3\2\2\2\u00ef\u00ed\3\2\2\2\u00f0\u00f1\7-\2\2\u00f1\u00f7\5\2\2\2\u00f2"+
		"\u00f3\7-\2\2\u00f3\u00f4\5\2\2\2\u00f4\u00f5\7*\2\2\u00f5\u00f7\3\2\2"+
		"\2\u00f6\u00f0\3\2\2\2\u00f6\u00f2\3\2\2\2\u00f7\'\3\2\2\2\u00f8\u00f9"+
		"\7\4\2\2\u00f9\u00fa\7\24\2\2\u00fa\u00fb\7-\2\2\u00fb\u00fc\7&\2\2\u00fc"+
		")\3\2\2\2\26\62cint\u0080\u008a\u0092\u009d\u00a5\u00ac\u00b2\u00bd\u00c9"+
		"\u00d8\u00df\u00e4\u00e9\u00ed\u00f6";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}