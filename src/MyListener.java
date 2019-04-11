import minidb.basic.database.Pair;
import minidb.basic.database.SchemaDescriptor;
import minidb.basic.database.Statement;
import minidb.basic.database.StatementCreate;
import minidb.basic.database.StatementDelete;
import minidb.basic.database.StatementDrop;
import minidb.basic.database.StatementInsertA;
import minidb.basic.database.StatementInsertB;
import minidb.basic.database.StatementSelectA;
import minidb.basic.database.StatementSelectB;
import minidb.basic.database.StatementUpdate;
import minidb.types.TypeConst;

public class MyListener extends MiniSQLBaseListener {

	Statement st;
	int type;
	
	@Override 
	public void enterSelectB(MiniSQLParser.SelectBContext ctx) {
		type=Statement.selectB;
		StatementSelectB ssb=new StatementSelectB();
		st=(Statement) ssb;
		
		ssb.existWhere=false;
		if(ctx.condition() != null) {
			ssb.existWhere=true;
			ssb.cdName=ctx.condition().Name().getText();
			ssb.cdValue=ctx.condition().value().getText();
			String op=ctx.condition().op().getText();
			ssb.op=Statement.opFromString(op);
		}
		
		for(int i=0;i<ctx.cnames().cname().size();i++) {
			ssb.cnames.add(new Pair<String, String>(ctx.cnames().cname(i).Name(0).getText()
					,ctx.cnames().cname(i).Name(1).getText()));
		}
		for(int i=0;i<ctx.jnames().Name().size();i++) {
			ssb.jnames.add(ctx.jnames().Name(i).getText());
			if(i>0) {
				Pair<String, String> l=new Pair<String,String>(ctx.jnames().onCondition(i-1).cname(0).Name(0).getText()
						,ctx.jnames().onCondition(i-1).cname(0).Name(1).getText());
				Pair<String, String> r=new Pair<String,String>(ctx.jnames().onCondition(i-1).cname(1).Name(0).getText()
						,ctx.jnames().onCondition(i-1).cname(1).Name(1).getText());
				
				ssb.onConditions.add(new Pair<Pair<String, String>, Pair<String, String>>(l,r));
				
			}
		}
	}
	
	@Override 
	public void enterSelectA(MiniSQLParser.SelectAContext ctx) {
		StatementSelectA ssa=new StatementSelectA();
		st=(Statement) ssa;
		
		type=Statement.selectA;
		ssa.tableName=ctx.Name().getText();
		ssa.existWhere=false;
		if(ctx.condition() != null) {
			ssa.existWhere=true;
			ssa.cdName=ctx.condition().Name().getText();
			ssa.cdValue=ctx.condition().value().getText();
			String op=ctx.condition().op().getText();
			ssa.op=Statement.opFromString(op);
		}
		for(int i=0;i<ctx.names().Name().size();i++) {
			ssa.names.add(ctx.names().Name(i).getText());
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
		su.cdName=ctx.condition().Name().getText();
		su.cdValue=ctx.condition().value().getText();
		String op=ctx.condition().op().getText();
		su.op=Statement.opFromString(op);
	}
	
	@Override 
	public void enterInsertB(MiniSQLParser.InsertBContext ctx) {
		StatementInsertB sib=new StatementInsertB();
		st=(Statement) sib;

		type=Statement.insertB;
		sib.tableName=ctx.Name().getText();
		for(int i=0;i<ctx.values().value().size();i++) {
			sib.pairs.put(ctx.names().Name(i).getText(), ctx.values().value(i).getText());
		}
	}
	
	@Override 
	public void enterInsertA(MiniSQLParser.InsertAContext ctx) {
		StatementInsertA sia=new StatementInsertA();
		st=(Statement) sia;
		
		type=Statement.insertA;
		sia.tableName=ctx.Name().getText();
		for(int i=0;i<ctx.values().value().size();i++) {
			sia.values.add(ctx.values().value(i).getText());
		}
	}
	@Override 
	public void enterDelete(MiniSQLParser.DeleteContext ctx) {
		StatementDelete sdl=new StatementDelete();
		st=(Statement) sdl;
		type=Statement.delete;
		sdl.tableName=ctx.Name().getText();
		sdl.cdName=ctx.condition().Name().getText();
		sdl.cdValue=ctx.condition().value().getText();
		String op=ctx.condition().op().getText();
		sdl.op=Statement.opFromString(op);
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
			break;
		}
	}
	
	@Override 
	public void enterNotnullattr(MiniSQLParser.NotnullattrContext ctx) { 
		SchemaDescriptor sd=new SchemaDescriptor();
		int type=TypeConst.fromString(ctx.type().getText());
		sd.setType(type);
		sd.setSize(TypeConst.type2size(type));
		StatementCreate sc=(StatementCreate) st;
		sd.setNotNull();
		switch(type) {
		case Statement.create:
			sc.descriptors.put(ctx.Name().getText(), sd);
			break;
		}
	}
	
	@Override 
	public void enterPrimarykey(MiniSQLParser.PrimarykeyContext ctx) { 
		StatementCreate sc=(StatementCreate) st;
		SchemaDescriptor sd=sc.descriptors.get(ctx.Name().getText());
		sd.setPrimary();
		sc.descriptors.put(ctx.Name().getText(), sd);
		
	}

}
