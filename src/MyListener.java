import minidb.basic.database.SchemaDescriptor;
import minidb.basic.database.Statement;
import minidb.basic.database.StatementCreate;
import minidb.basic.database.StatementDrop;
import minidb.types.TypeConst;

public class MyListener extends MiniSQLBaseListener {

	StatementCreate sc;
	StatementDrop sd;
	int type;
	
	@Override 
	public void enterCreate(MiniSQLParser.CreateContext ctx) { 
		type=Statement.create;
		sc=new StatementCreate();
		sc.tableName=ctx.String().getText();
	}
	
	@Override
	public void enterDrop(MiniSQLParser.DropContext ctx) { 
		type=Statement.drop;
		sd=new StatementDrop();
		sd.tableName=ctx.String().getText();
	}
	
	@Override 
	public void enterNormalattr(MiniSQLParser.NormalattrContext ctx) { 
		SchemaDescriptor sd=new SchemaDescriptor();
		sd.setType(TypeConst.fromString(ctx.type().getText()));
		switch(type) {
		case Statement.create:
			sc.descriptors.put(ctx.String().getText(), sd);
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
			sc.descriptors.put(ctx.String().getText(), sd);
			break;
		}
	}
	
	@Override 
	public void enterPrimarykey(MiniSQLParser.PrimarykeyContext ctx) { 
		switch(type) {
		case Statement.create:
			SchemaDescriptor sd=sc.descriptors.get(ctx.String().getText());
			sd.setPrimary(true);
			sc.descriptors.put(ctx.String().getText(), sd);
			break;
		}
	}

}
