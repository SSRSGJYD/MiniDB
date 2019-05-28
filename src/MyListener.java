import minidb.basic.database.CLogicTree;
import minidb.basic.database.LogicTree;
import minidb.basic.database.Pair;
import minidb.basic.database.SchemaDescriptor;
import minidb.basic.database.Statement;
import minidb.basic.database.StatementCreate;
import minidb.basic.database.StatementDB;
import minidb.basic.database.StatementDelete;
import minidb.basic.database.StatementDrop;
import minidb.basic.database.StatementInsertA;
import minidb.basic.database.StatementInsertB;
import minidb.basic.database.StatementSelectA;
import minidb.basic.database.StatementSelectB;
import minidb.basic.database.StatementUpdate;
import minidb.basic.database.StatementUser;
import minidb.basic.database.StatementPerm;
import minidb.types.TypeConst;

public class MyListener extends MiniSQLBaseListener {

	Statement st;
	int type;

	@Override 
	public void enterCreateUser(MiniSQLParser.CreateUserContext ctx) {
		type=Statement.User;
		StatementUser user=new StatementUser();
		st=(Statement) user;
		user.username=ctx.Name(0).getText();
		user.password=ctx.Name(1).getText();
	}

	@Override 
	public void enterRevoke(MiniSQLParser.RevokeContext ctx) {
		type=Statement.Perm;
		StatementPerm user=new StatementPerm();
		st=(Statement) user;
		user.stType=StatementPerm.revoke;
		user.perm=ctx.perm().getText();
		user.tableName=ctx.Name(0).getText();
		user.userName=ctx.Name(1).getText();
	}
	@Override 
	public void enterGrant(MiniSQLParser.GrantContext ctx) {
		type=Statement.Perm;
		StatementPerm user=new StatementPerm();
		st=(Statement) user;
		user.stType=StatementPerm.grant;
		user.perm=ctx.perm().getText();
		user.tableName=ctx.Name(0).getText();
		user.userName=ctx.Name(1).getText();
		if(ctx.withGrant()!=null)
			user.isOption=true;
	}

	@Override 
	public void enterShowdb(MiniSQLParser.ShowdbContext ctx) {
		type=Statement.DB;
		StatementDB db=new StatementDB();
		st=(Statement) db;
		db.stType=StatementDB.showdb;
		db.dbName=ctx.Name().getText();
	}

	@Override 
	public void enterShow(MiniSQLParser.ShowContext ctx) {
		type=Statement.DB;
		StatementDB db=new StatementDB();
		st=(Statement) db;
		db.stType=StatementDB.show;
	}

	@Override 
	public void enterUsedb(MiniSQLParser.UsedbContext ctx) {
		type=Statement.DB;
		StatementDB db=new StatementDB();
		st=(Statement) db;
		db.stType=StatementDB.use;
		db.dbName=ctx.Name().getText();
	}
	@Override 
	public void enterDropdb(MiniSQLParser.DropdbContext ctx) {
		type=Statement.DB;
		StatementDB db=new StatementDB();
		st=(Statement) db;
		db.stType=StatementDB.drop;
		db.dbName=ctx.Name().getText();
	}
	@Override 
	public void enterCreatedb(MiniSQLParser.CreatedbContext ctx) {
		type=Statement.DB;
		StatementDB db=new StatementDB();
		st=(Statement) db;
		db.stType=StatementDB.create;
		db.dbName=ctx.Name().getText();
	}
	@Override 
	public void enterSelectB(MiniSQLParser.SelectBContext ctx) {
		type=Statement.selectB;
		StatementSelectB ssb=new StatementSelectB();
		st=(Statement) ssb;
		
		ssb.existWhere=false;

		if(ctx.clogictree()!=null) {
			ssb.existWhere=true;
			ssb.lt=parseclt(ctx.clogictree());
		}

		
		if(ctx.cnames()!=null) {
			ssb.isStar=false;
			for(int i=0;i<ctx.cnames().cname().size();i++) {
				ssb.cnames.add(new Pair<String, String>(ctx.cnames().cname(i).Name(0).getText()
						,ctx.cnames().cname(i).Name(1).getText()));
			}
		}
		else {
			ssb.isStar=true;
		}

		int t=0;
		for(int i=0;i<ctx.jnames().Name().size();i++) {
			if(i>0) {
				if(ctx.jnames().join(i-1).getText().equals("join"))
					t=StatementSelectB.join;
				else if(ctx.jnames().join(i-1).getText().equals("left outer join"))
					t=StatementSelectB.leftOuterJoin;
				else if(ctx.jnames().join(i-1).getText().equals("right outer join"))
					t=StatementSelectB.rightOuterJoin;
				else if(ctx.jnames().join(i-1).getText().equals("full outer join"))
					t=StatementSelectB.fullOuterJoin;

				Pair<String, String> l=new Pair<String,String>(ctx.jnames().onCondition(i-1).cname(0).Name(0).getText()
						,ctx.jnames().onCondition(i-1).cname(0).Name(1).getText());
				Pair<String, String> r=new Pair<String,String>(ctx.jnames().onCondition(i-1).cname(1).Name(0).getText()
						,ctx.jnames().onCondition(i-1).cname(1).Name(1).getText());
				
				ssb.onConditions.add(new Pair<Pair<String, String>, Pair<String, String>>(l,r));
			}
			ssb.jnames.add(new Pair<String, Integer>(ctx.jnames().Name(i).getText(),t));
		}
	}
	
	@Override 
	public void enterSelectA(MiniSQLParser.SelectAContext ctx) {
		StatementSelectA ssa=new StatementSelectA();
		st=(Statement) ssa;
		
		type=Statement.selectA;
		ssa.tableName=ctx.Name().getText();
		ssa.existWhere=false;

		if(ctx.logictree()!=null) {
			ssa.existWhere=true;
			ssa.lt=parselt(ctx.logictree());
		}


		if(ctx.names()!=null) {
			ssa.isStar=false;
			for(int i=0;i<ctx.names().Name().size();i++) {
				ssa.names.add(ctx.names().Name(i).getText());
			}
		}
		else {
			ssa.isStar=true;
		}
	}

	private CLogicTree parseclt(MiniSQLParser.ClogictreeContext logicTree) {
		CLogicTree lt=new CLogicTree();
		lt.isLeaf=false;
		if(logicTree.ccondition()!=null) {
			lt.isLeaf=true;

			if(logicTree.ccondition().value()!=null) {
				lt.isImme=true;
				lt.cdNameP=new Pair<String,String>(logicTree.ccondition().cname(0).Name(0).getText(),logicTree.ccondition().cname(0).Name(1).getText());
				lt.cdValue=logicTree.ccondition().value().getText();
			}
			else {
				lt.isImme=false;
				lt.cdNameP=new Pair<String,String>(logicTree.ccondition().cname(0).Name(0).getText(),logicTree.ccondition().cname(0).Name(1).getText());
				lt.cdNamerP=new Pair<String,String>(logicTree.ccondition().cname(1).Name(0).getText(),logicTree.ccondition().cname(1).Name(1).getText());
			}
			String op=logicTree.ccondition().op().getText();
			lt.op=Statement.opFromString(op);

			return lt;
		}
		else {
			lt.ltree=parseclt(logicTree.clogictree(0));
			lt.rtree=parseclt(logicTree.clogictree(1));
			if(logicTree.lop().getText().equalsIgnoreCase("and")) {
				lt.lop=LogicTree.and;
			}
			else {
				lt.lop=LogicTree.or;
			}
			return lt;
		}
	}


	private LogicTree parselt(MiniSQLParser.LogictreeContext logicTree) {
		LogicTree lt=new LogicTree();
		lt.isLeaf=false;
		if(logicTree.condition()!=null) {
			lt.isLeaf=true;
			if(logicTree.condition().value()!=null) {
				lt.isImme=true;
				lt.cdName=logicTree.condition().Name(0).getText();
				lt.cdValue=logicTree.condition().value().getText();
			}
			else {
				lt.isImme=false;
				lt.cdName=logicTree.condition().Name(0).getText();
				lt.cdNamer=logicTree.condition().Name(1).getText();
			}
			String op=logicTree.condition().op().getText();
			lt.op=Statement.opFromString(op);
			return lt;
		}
		else {
			lt.ltree=parselt(logicTree.logictree(0));
			lt.rtree=parselt(logicTree.logictree(1));
			if(logicTree.lop().getText().equalsIgnoreCase("and")) {
				lt.lop=LogicTree.and;
			}
			else {
				lt.lop=LogicTree.or;
			}
			return lt;
		}
	}

	@Override 
	public void enterInsertB(MiniSQLParser.InsertBContext ctx) {
		StatementInsertB sib=new StatementInsertB();
		st=(Statement) sib;

		type=Statement.insertB;
		sib.tableName=ctx.Name().getText();
		for(int i=0;i<ctx.values().value().size();i++) {
			if(ctx.values().value(i).Number()!=null)
				sib.pairs.put(ctx.names().Name(i).getText(), ctx.values().value(i).getText());
			else if(ctx.values().value(i).String()!=null) {
				String str=ctx.values().value(i).getText();
				sib.pairs.put(ctx.names().Name(i).getText(), str);
			}else {
				sib.pairs.put(ctx.names().Name(i).getText(), null);
			}
		}
	}
	
	@Override 
	public void enterInsertA(MiniSQLParser.InsertAContext ctx) {
		StatementInsertA sia=new StatementInsertA();
		st=(Statement) sia;
		
		type=Statement.insertA;
		sia.tableName=ctx.Name().getText();
		for(int i=0;i<ctx.values().value().size();i++) {
			if(ctx.values().value(i).Number()!=null)
				sia.values.add(ctx.values().value(i).getText());
			else if(ctx.values().value(i).String()!=null) {
				String str=ctx.values().value(i).getText();
				sia.values.add(str);
			}else {
				sia.values.add(null);
			}
				
		}
	}

	@Override 
	public void enterUpdate(MiniSQLParser.UpdateContext ctx) {
		StatementUpdate su=new StatementUpdate();
		st=(Statement) su;
		
		type=Statement.update;
		su.tableName=ctx.Name().getText();
		su.setName=ctx.set().Name().getText();
		su.setValue=ctx.set().value().getText();

		su.lt=parselt(ctx.logictree());

	}
	

	@Override 
	public void enterDelete(MiniSQLParser.DeleteContext ctx) {
		StatementDelete sdl=new StatementDelete();
		st=(Statement) sdl;
		type=Statement.delete;
		sdl.tableName=ctx.Name().getText();
		sdl.lt=parselt(ctx.logictree());

	}
	
	@Override 
	public void enterCreate(MiniSQLParser.CreateContext ctx) { 
		type=Statement.create;
		StatementCreate sc=new StatementCreate();
		st=(Statement) sc;
		sc.tableName=ctx.Name().getText();
	}
	
	@Override
	public void enterDrop(MiniSQLParser.DropContext ctx) { 
		type=Statement.drop;
		StatementDrop sd=new StatementDrop();
		st=(Statement) sd;
		sd.tableName=ctx.Name().getText();
	}
	
	@Override 
	public void enterNormalattr(MiniSQLParser.NormalattrContext ctx) { 
		SchemaDescriptor sd=new SchemaDescriptor();
		int mtype=TypeConst.fromString(ctx.type().getText());
		sd.setType(mtype);
		int size=TypeConst.type2size(mtype);
		if(ctx.type().getText().substring(0, 3).equals("cha")) {
			size=size*Integer.parseInt(ctx.type().Number().getText());
		}
		sd.setSize(size);
		StatementCreate sc=(StatementCreate) st;
		switch(type) {
		case Statement.create:
			sc.descriptors.put(ctx.Name().getText(), sd);
			sc.types.put(ctx.Name().getText(), mtype);
			break;
		}
	}
	
	@Override 
	public void enterNotnullattr(MiniSQLParser.NotnullattrContext ctx) { 
		SchemaDescriptor sd=new SchemaDescriptor();
		int mtype=TypeConst.fromString(ctx.type().getText());
		sd.setType(mtype);
		int size=TypeConst.type2size(mtype);
		if(ctx.type().getText().substring(0, 3).equals("cha")) {
			size=size*Integer.parseInt(ctx.type().Number().getText());
		}
		sd.setSize(size);
		StatementCreate sc=(StatementCreate) st;
		sd.setNotNull();
		switch(type) {
		case Statement.create:
			sc.descriptors.put(ctx.Name().getText(), sd);
			sc.types.put(ctx.Name().getText(), mtype);
			break;
		}
	}
	
	@Override 
	public void enterPrimarykey(MiniSQLParser.PrimarykeyContext ctx) { 
		StatementCreate sc=(StatementCreate) st;
		SchemaDescriptor sd=sc.descriptors.get(ctx.Name().getText());
		sd.setPrimary();
		sc.hasPrimary=true;
		sc.descriptors.put(ctx.Name().getText(), sd);
		
	}

}
