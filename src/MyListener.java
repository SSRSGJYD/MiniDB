import minidb.basic.database.SchemaDescriptor;
import minidb.basic.database.Statement;
import minidb.basic.database.StatementCreate;
import minidb.basic.database.StatementDelete;
import minidb.basic.database.StatementDrop;
import minidb.basic.database.StatementInsertA;
import minidb.basic.database.StatementInsertB;
import minidb.basic.database.StatementSelectA;
import minidb.basic.database.StatementUpdate;
import minidb.types.TypeConst;

public class MyListener extends MiniSQLBaseListener {

	StatementCreate sc;
	StatementDrop sd;
	StatementInsertA sia;
	StatementInsertB sib;
	StatementDelete sdl;
	StatementUpdate su;
	StatementSelectA ssa;
	int type;
	
	@Override 
	public void enterSelectA(MiniSQLParser.SelectAContext ctx) {
		type=Statement.selectA;
		ssa=new StatementSelectA();
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
		type=Statement.update;
		su=new StatementUpdate();
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
		type=Statement.insertB;
		sib=new StatementInsertB();
		sib.tableName=ctx.Name().getText();
		for(int i=0;i<ctx.values().value().size();i++) {
			sib.pairs.put(ctx.names().Name(i).getText(), ctx.values().value(i).getText());
		}
	}
	
	@Override 
	public void enterInsertA(MiniSQLParser.InsertAContext ctx) {
		type=Statement.insertA;
		sia=new StatementInsertA();
		sia.tableName=ctx.Name().getText();
		for(int i=0;i<ctx.values().value().size();i++) {
			sia.values.add(ctx.values().value(i).getText());
		}
	}
	@Override 
	public void enterDelete(MiniSQLParser.DeleteContext ctx) {
		type=Statement.delete;
		sdl=new StatementDelete();
		sdl.tableName=ctx.Name().getText();
		sdl.cdName=ctx.condition().Name().getText();
		sdl.cdValue=ctx.condition().value().getText();
		String op=ctx.condition().op().getText();
		sdl.op=Statement.opFromString(op);
	}
	
	@Override 
	public void enterCreate(MiniSQLParser.CreateContext ctx) { 
		type=Statement.create;
		sc=new StatementCreate();
		sc.tableName=ctx.Name().getText();
	}
	
	@Override
	public void enterDrop(MiniSQLParser.DropContext ctx) { 
		type=Statement.drop;
		sd=new StatementDrop();
		sd.tableName=ctx.Name().getText();
	}
	
	@Override 
	public void enterNormalattr(MiniSQLParser.NormalattrContext ctx) { 
		SchemaDescriptor sd=new SchemaDescriptor();
		sd.setType(TypeConst.fromString(ctx.type().getText()));
		switch(type) {
		case Statement.create:
			sc.descriptors.put(ctx.Name().getText(), sd);
			break;
		}
	}
	
	@Override 
	public void enterNotnullattr(MiniSQLParser.NotnullattrContext ctx) { 
		SchemaDescriptor sd=new SchemaDescriptor();
		sd.setType(TypeConst.fromString(ctx.type().getText()));
		sd.setNotNull(true);
		switch(type) {
		case Statement.create:
			sc.descriptors.put(ctx.Name().getText(), sd);
			break;
		}
	}
	
	@Override 
	public void enterPrimarykey(MiniSQLParser.PrimarykeyContext ctx) { 
		switch(type) {
		case Statement.create:
			SchemaDescriptor sd=sc.descriptors.get(ctx.Name().getText());
			sd.setPrimary(true);
			sc.descriptors.put(ctx.Name().getText(), sd);
			break;
		}
	}

}
