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
		T__37=1, T__36=2, T__35=3, T__34=4, T__33=5, T__32=6, T__31=7, T__30=8, 
		T__29=9, T__28=10, T__27=11, T__26=12, T__25=13, T__24=14, T__23=15, T__22=16, 
		T__21=17, T__20=18, T__19=19, T__18=20, T__17=21, T__16=22, T__15=23, 
		T__14=24, T__13=25, T__12=26, T__11=27, T__10=28, T__9=29, T__8=30, T__7=31, 
		T__6=32, T__5=33, T__4=34, T__3=35, T__2=36, T__1=37, T__0=38, Number=39, 
		Name=40, String=41, NEWLINE=42, WS=43;
	public static final String[] tokenNames = {
		"<INVALID>", "'primary key'", "'char'", "'set'", "'use database'", "'float'", 
		"'delete from'", "'on'", "'='", "'<='", "'drop table'", "'double'", "'from'", 
		"'int'", "'null'", "'drop database'", "'('", "'values'", "'*'", "'update'", 
		"','", "'join'", "'.'", "'long'", "'show database'", "'>='", "'<'", "'select'", 
		"'>'", "'or'", "'<>'", "'where'", "'create database'", "')'", "'and'", 
		"'show databases'", "'insert into'", "'not null'", "'create table'", "Number", 
		"Name", "String", "NEWLINE", "WS"
	};
	public static final int
		RULE_type = 0, RULE_op = 1, RULE_value = 2, RULE_lop = 3, RULE_sql = 4, 
		RULE_logictree = 5, RULE_ccondition = 6, RULE_condition = 7, RULE_set = 8, 
		RULE_names = 9, RULE_cname = 10, RULE_cnames = 11, RULE_onCondition = 12, 
		RULE_jnames = 13, RULE_values = 14, RULE_schema = 15, RULE_attribute = 16, 
		RULE_constraint = 17;
	public static final String[] ruleNames = {
		"type", "op", "value", "lop", "sql", "logictree", "ccondition", "condition", 
		"set", "names", "cname", "cnames", "onCondition", "jnames", "values", 
		"schema", "attribute", "constraint"
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
			setState(44);
			switch (_input.LA(1)) {
			case T__25:
				enterOuterAlt(_localctx, 1);
				{
				setState(36); match(T__25);
				}
				break;
			case T__15:
				enterOuterAlt(_localctx, 2);
				{
				setState(37); match(T__15);
				}
				break;
			case T__33:
				enterOuterAlt(_localctx, 3);
				{
				setState(38); match(T__33);
				}
				break;
			case T__27:
				enterOuterAlt(_localctx, 4);
				{
				setState(39); match(T__27);
				}
				break;
			case T__36:
				enterOuterAlt(_localctx, 5);
				{
				setState(40); match(T__36);
				setState(41); match(T__22);
				setState(42); match(Number);
				setState(43); match(T__5);
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
			setState(46);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__30) | (1L << T__29) | (1L << T__13) | (1L << T__12) | (1L << T__10) | (1L << T__8))) != 0)) ) {
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
			setState(48);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__24) | (1L << Number) | (1L << String))) != 0)) ) {
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
		enterRule(_localctx, 6, RULE_lop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			_la = _input.LA(1);
			if ( !(_la==T__9 || _la==T__4) ) {
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
		public CnamesContext cnames() {
			return getRuleContext(CnamesContext.class,0);
		}
		public CconditionContext ccondition() {
			return getRuleContext(CconditionContext.class,0);
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
		enterRule(_localctx, 8, RULE_sql);
		int _la;
		try {
			setState(120);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				_localctx = new CreateContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(52); match(T__0);
				setState(53); match(Name);
				setState(54); match(T__22);
				setState(55); schema();
				setState(56); match(T__5);
				}
				break;
			case 2:
				_localctx = new DropContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(58); match(T__28);
				setState(59); match(Name);
				}
				break;
			case 3:
				_localctx = new InsertAContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(60); match(T__2);
				setState(61); match(Name);
				setState(62); match(T__21);
				setState(63); match(T__22);
				setState(64); values();
				setState(65); match(T__5);
				}
				break;
			case 4:
				_localctx = new InsertBContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(67); match(T__2);
				setState(68); match(Name);
				setState(69); match(T__22);
				setState(70); names();
				setState(71); match(T__5);
				setState(72); match(T__21);
				setState(73); match(T__22);
				setState(74); values();
				setState(75); match(T__5);
				}
				break;
			case 5:
				_localctx = new DeleteContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(77); match(T__32);
				setState(78); match(Name);
				setState(79); match(T__7);
				setState(80); logictree(0);
				}
				break;
			case 6:
				_localctx = new UpdateContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(81); match(T__19);
				setState(82); match(Name);
				setState(83); match(T__35);
				setState(84); set();
				setState(85); match(T__7);
				setState(86); logictree(0);
				}
				break;
			case 7:
				_localctx = new SelectBContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(88); match(T__11);
				setState(91);
				switch (_input.LA(1)) {
				case Name:
					{
					setState(89); cnames();
					}
					break;
				case T__20:
					{
					setState(90); match(T__20);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(93); match(T__26);
				setState(94); jnames();
				setState(97);
				_la = _input.LA(1);
				if (_la==T__7) {
					{
					setState(95); match(T__7);
					setState(96); ccondition();
					}
				}

				}
				break;
			case 8:
				_localctx = new SelectAContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(99); match(T__11);
				setState(102);
				switch (_input.LA(1)) {
				case Name:
					{
					setState(100); names();
					}
					break;
				case T__20:
					{
					setState(101); match(T__20);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(104); match(T__26);
				setState(105); match(Name);
				setState(108);
				_la = _input.LA(1);
				if (_la==T__7) {
					{
					setState(106); match(T__7);
					setState(107); logictree(0);
					}
				}

				}
				break;
			case 9:
				_localctx = new CreatedbContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(110); match(T__6);
				setState(111); match(Name);
				}
				break;
			case 10:
				_localctx = new DropdbContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(112); match(T__23);
				setState(113); match(Name);
				}
				break;
			case 11:
				_localctx = new UsedbContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(114); match(T__34);
				setState(115); match(Name);
				}
				break;
			case 12:
				_localctx = new ShowContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(116); match(T__3);
				}
				break;
			case 13:
				_localctx = new ShowdbContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(117); match(T__14);
				setState(118); match(Name);
				}
				break;
			case 14:
				_localctx = new NewlineContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(119); match(NEWLINE);
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
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_logictree, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			switch (_input.LA(1)) {
			case T__22:
				{
				setState(123); match(T__22);
				setState(124); logictree(0);
				setState(125); lop();
				setState(126); logictree(0);
				setState(127); match(T__5);
				}
				break;
			case Name:
				{
				setState(129); condition();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(138);
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
					setState(132);
					if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
					setState(133); lop();
					setState(134); logictree(4);
					}
					} 
				}
				setState(140);
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
		enterRule(_localctx, 12, RULE_ccondition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141); cname();
			setState(142); op();
			setState(145);
			switch (_input.LA(1)) {
			case T__24:
			case Number:
			case String:
				{
				setState(143); value();
				}
				break;
			case Name:
				{
				setState(144); cname();
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
		enterRule(_localctx, 14, RULE_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147); match(Name);
			setState(148); op();
			setState(151);
			switch (_input.LA(1)) {
			case T__24:
			case Number:
			case String:
				{
				setState(149); value();
				}
				break;
			case Name:
				{
				setState(150); match(Name);
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
		enterRule(_localctx, 16, RULE_set);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153); match(Name);
			setState(154); match(T__30);
			setState(155); value();
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
		enterRule(_localctx, 18, RULE_names);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157); match(Name);
			setState(162);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__18) {
				{
				{
				setState(158); match(T__18);
				setState(159); match(Name);
				}
				}
				setState(164);
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
		enterRule(_localctx, 20, RULE_cname);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165); match(Name);
			setState(166); match(T__16);
			setState(167); match(Name);
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
		enterRule(_localctx, 22, RULE_cnames);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169); cname();
			setState(174);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__18) {
				{
				{
				setState(170); match(T__18);
				setState(171); cname();
				}
				}
				setState(176);
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
		enterRule(_localctx, 24, RULE_onCondition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177); cname();
			setState(178); match(T__30);
			setState(179); cname();
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
		enterRule(_localctx, 26, RULE_jnames);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(181); match(Name);
			setState(186); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(182); match(T__17);
				setState(183); match(Name);
				setState(184); match(T__31);
				setState(185); onCondition();
				}
				}
				setState(188); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__17 );
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
		enterRule(_localctx, 28, RULE_values);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(190); value();
			setState(195);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__18) {
				{
				{
				setState(191); match(T__18);
				setState(192); value();
				}
				}
				setState(197);
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
		enterRule(_localctx, 30, RULE_schema);
		int _la;
		try {
			_localctx = new AttrconsContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(200);
			switch (_input.LA(1)) {
			case Name:
				{
				setState(198); attribute();
				}
				break;
			case T__37:
				{
				setState(199); constraint();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(209);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__18) {
				{
				{
				setState(202); match(T__18);
				setState(205);
				switch (_input.LA(1)) {
				case Name:
					{
					setState(203); attribute();
					}
					break;
				case T__37:
					{
					setState(204); constraint();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				}
				setState(211);
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
		enterRule(_localctx, 32, RULE_attribute);
		try {
			setState(218);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				_localctx = new NormalattrContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(212); match(Name);
				setState(213); type();
				}
				break;
			case 2:
				_localctx = new NotnullattrContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(214); match(Name);
				setState(215); type();
				setState(216); match(T__1);
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
		enterRule(_localctx, 34, RULE_constraint);
		try {
			_localctx = new PrimarykeyContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(220); match(T__37);
			setState(221); match(T__22);
			setState(222); match(Name);
			setState(223); match(T__5);
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
		case 5: return logictree_sempred((LogictreeContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean logictree_sempred(LogictreeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3-\u00e4\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2/\n\2\3\3\3\3\3\4\3\4\3"+
		"\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\5\6^\n\6\3\6\3\6\3\6\3\6\5\6d\n\6\3\6\3\6\3\6\5"+
		"\6i\n\6\3\6\3\6\3\6\3\6\5\6o\n\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\5\6{\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u0085\n\7\3\7\3\7\3\7"+
		"\3\7\7\7\u008b\n\7\f\7\16\7\u008e\13\7\3\b\3\b\3\b\3\b\5\b\u0094\n\b\3"+
		"\t\3\t\3\t\3\t\5\t\u009a\n\t\3\n\3\n\3\n\3\n\3\13\3\13\3\13\7\13\u00a3"+
		"\n\13\f\13\16\13\u00a6\13\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\7\r\u00af\n\r"+
		"\f\r\16\r\u00b2\13\r\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\6\17"+
		"\u00bd\n\17\r\17\16\17\u00be\3\20\3\20\3\20\7\20\u00c4\n\20\f\20\16\20"+
		"\u00c7\13\20\3\21\3\21\5\21\u00cb\n\21\3\21\3\21\3\21\5\21\u00d0\n\21"+
		"\7\21\u00d2\n\21\f\21\16\21\u00d5\13\21\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\5\22\u00dd\n\22\3\23\3\23\3\23\3\23\3\23\3\23\2\3\f\24\2\4\6\b\n\f\16"+
		"\20\22\24\26\30\32\34\36 \"$\2\5\6\2\n\13\33\34\36\36  \5\2\20\20))++"+
		"\4\2\37\37$$\u00f2\2.\3\2\2\2\4\60\3\2\2\2\6\62\3\2\2\2\b\64\3\2\2\2\n"+
		"z\3\2\2\2\f\u0084\3\2\2\2\16\u008f\3\2\2\2\20\u0095\3\2\2\2\22\u009b\3"+
		"\2\2\2\24\u009f\3\2\2\2\26\u00a7\3\2\2\2\30\u00ab\3\2\2\2\32\u00b3\3\2"+
		"\2\2\34\u00b7\3\2\2\2\36\u00c0\3\2\2\2 \u00ca\3\2\2\2\"\u00dc\3\2\2\2"+
		"$\u00de\3\2\2\2&/\7\17\2\2\'/\7\31\2\2(/\7\7\2\2)/\7\r\2\2*+\7\4\2\2+"+
		",\7\22\2\2,-\7)\2\2-/\7#\2\2.&\3\2\2\2.\'\3\2\2\2.(\3\2\2\2.)\3\2\2\2"+
		".*\3\2\2\2/\3\3\2\2\2\60\61\t\2\2\2\61\5\3\2\2\2\62\63\t\3\2\2\63\7\3"+
		"\2\2\2\64\65\t\4\2\2\65\t\3\2\2\2\66\67\7(\2\2\678\7*\2\289\7\22\2\29"+
		":\5 \21\2:;\7#\2\2;{\3\2\2\2<=\7\f\2\2={\7*\2\2>?\7&\2\2?@\7*\2\2@A\7"+
		"\23\2\2AB\7\22\2\2BC\5\36\20\2CD\7#\2\2D{\3\2\2\2EF\7&\2\2FG\7*\2\2GH"+
		"\7\22\2\2HI\5\24\13\2IJ\7#\2\2JK\7\23\2\2KL\7\22\2\2LM\5\36\20\2MN\7#"+
		"\2\2N{\3\2\2\2OP\7\b\2\2PQ\7*\2\2QR\7!\2\2R{\5\f\7\2ST\7\25\2\2TU\7*\2"+
		"\2UV\7\5\2\2VW\5\22\n\2WX\7!\2\2XY\5\f\7\2Y{\3\2\2\2Z]\7\35\2\2[^\5\30"+
		"\r\2\\^\7\24\2\2][\3\2\2\2]\\\3\2\2\2^_\3\2\2\2_`\7\16\2\2`c\5\34\17\2"+
		"ab\7!\2\2bd\5\16\b\2ca\3\2\2\2cd\3\2\2\2d{\3\2\2\2eh\7\35\2\2fi\5\24\13"+
		"\2gi\7\24\2\2hf\3\2\2\2hg\3\2\2\2ij\3\2\2\2jk\7\16\2\2kn\7*\2\2lm\7!\2"+
		"\2mo\5\f\7\2nl\3\2\2\2no\3\2\2\2o{\3\2\2\2pq\7\"\2\2q{\7*\2\2rs\7\21\2"+
		"\2s{\7*\2\2tu\7\6\2\2u{\7*\2\2v{\7%\2\2wx\7\32\2\2x{\7*\2\2y{\7,\2\2z"+
		"\66\3\2\2\2z<\3\2\2\2z>\3\2\2\2zE\3\2\2\2zO\3\2\2\2zS\3\2\2\2zZ\3\2\2"+
		"\2ze\3\2\2\2zp\3\2\2\2zr\3\2\2\2zt\3\2\2\2zv\3\2\2\2zw\3\2\2\2zy\3\2\2"+
		"\2{\13\3\2\2\2|}\b\7\1\2}~\7\22\2\2~\177\5\f\7\2\177\u0080\5\b\5\2\u0080"+
		"\u0081\5\f\7\2\u0081\u0082\7#\2\2\u0082\u0085\3\2\2\2\u0083\u0085\5\20"+
		"\t\2\u0084|\3\2\2\2\u0084\u0083\3\2\2\2\u0085\u008c\3\2\2\2\u0086\u0087"+
		"\f\5\2\2\u0087\u0088\5\b\5\2\u0088\u0089\5\f\7\6\u0089\u008b\3\2\2\2\u008a"+
		"\u0086\3\2\2\2\u008b\u008e\3\2\2\2\u008c\u008a\3\2\2\2\u008c\u008d\3\2"+
		"\2\2\u008d\r\3\2\2\2\u008e\u008c\3\2\2\2\u008f\u0090\5\26\f\2\u0090\u0093"+
		"\5\4\3\2\u0091\u0094\5\6\4\2\u0092\u0094\5\26\f\2\u0093\u0091\3\2\2\2"+
		"\u0093\u0092\3\2\2\2\u0094\17\3\2\2\2\u0095\u0096\7*\2\2\u0096\u0099\5"+
		"\4\3\2\u0097\u009a\5\6\4\2\u0098\u009a\7*\2\2\u0099\u0097\3\2\2\2\u0099"+
		"\u0098\3\2\2\2\u009a\21\3\2\2\2\u009b\u009c\7*\2\2\u009c\u009d\7\n\2\2"+
		"\u009d\u009e\5\6\4\2\u009e\23\3\2\2\2\u009f\u00a4\7*\2\2\u00a0\u00a1\7"+
		"\26\2\2\u00a1\u00a3\7*\2\2\u00a2\u00a0\3\2\2\2\u00a3\u00a6\3\2\2\2\u00a4"+
		"\u00a2\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\25\3\2\2\2\u00a6\u00a4\3\2\2"+
		"\2\u00a7\u00a8\7*\2\2\u00a8\u00a9\7\30\2\2\u00a9\u00aa\7*\2\2\u00aa\27"+
		"\3\2\2\2\u00ab\u00b0\5\26\f\2\u00ac\u00ad\7\26\2\2\u00ad\u00af\5\26\f"+
		"\2\u00ae\u00ac\3\2\2\2\u00af\u00b2\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b0\u00b1"+
		"\3\2\2\2\u00b1\31\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b3\u00b4\5\26\f\2\u00b4"+
		"\u00b5\7\n\2\2\u00b5\u00b6\5\26\f\2\u00b6\33\3\2\2\2\u00b7\u00bc\7*\2"+
		"\2\u00b8\u00b9\7\27\2\2\u00b9\u00ba\7*\2\2\u00ba\u00bb\7\t\2\2\u00bb\u00bd"+
		"\5\32\16\2\u00bc\u00b8\3\2\2\2\u00bd\u00be\3\2\2\2\u00be\u00bc\3\2\2\2"+
		"\u00be\u00bf\3\2\2\2\u00bf\35\3\2\2\2\u00c0\u00c5\5\6\4\2\u00c1\u00c2"+
		"\7\26\2\2\u00c2\u00c4\5\6\4\2\u00c3\u00c1\3\2\2\2\u00c4\u00c7\3\2\2\2"+
		"\u00c5\u00c3\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\37\3\2\2\2\u00c7\u00c5"+
		"\3\2\2\2\u00c8\u00cb\5\"\22\2\u00c9\u00cb\5$\23\2\u00ca\u00c8\3\2\2\2"+
		"\u00ca\u00c9\3\2\2\2\u00cb\u00d3\3\2\2\2\u00cc\u00cf\7\26\2\2\u00cd\u00d0"+
		"\5\"\22\2\u00ce\u00d0\5$\23\2\u00cf\u00cd\3\2\2\2\u00cf\u00ce\3\2\2\2"+
		"\u00d0\u00d2\3\2\2\2\u00d1\u00cc\3\2\2\2\u00d2\u00d5\3\2\2\2\u00d3\u00d1"+
		"\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4!\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d6"+
		"\u00d7\7*\2\2\u00d7\u00dd\5\2\2\2\u00d8\u00d9\7*\2\2\u00d9\u00da\5\2\2"+
		"\2\u00da\u00db\7\'\2\2\u00db\u00dd\3\2\2\2\u00dc\u00d6\3\2\2\2\u00dc\u00d8"+
		"\3\2\2\2\u00dd#\3\2\2\2\u00de\u00df\7\3\2\2\u00df\u00e0\7\22\2\2\u00e0"+
		"\u00e1\7*\2\2\u00e1\u00e2\7#\2\2\u00e2%\3\2\2\2\24.]chnz\u0084\u008c\u0093"+
		"\u0099\u00a4\u00b0\u00be\u00c5\u00ca\u00cf\u00d3\u00dc";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}