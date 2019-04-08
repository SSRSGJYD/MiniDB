import minidb.basic.database.SchemaDescriptor;
import minidb.basic.database.Statement;
import minidb.basic.database.StatementCreate;
import minidb.types.TypeConst;

public class EvalVisitor extends MiniSQLBaseVisitor<Integer> {
	StatementCreate sc;
	int type;
	
	@Override
	public Integer visitCreate(MiniSQLParser.CreateContext ctx) {
		type=Statement.create;
		sc=new StatementCreate();
		sc.tableName=ctx.String().getText();
		return 0;
	}
	//@Override
	/*public Integer visitNotnullattr(MiniSQLParser.NotnullattrContext ctx) {
		SchemaDescriptor sd=new SchemaDescriptor();
		sd.setType(TypeConst.fromString(ctx.TYPE().getText()));
		sd.setNotNull(true);
		switch(type) {
		case Statement.create:
			sc.descriptors.put(ctx.ATTRNAME().getText(), sd);
			break;
		}
		return 0;
	}*/
	@Override
	public Integer visitNormalattr(MiniSQLParser.NormalattrContext ctx) {
		SchemaDescriptor sd=new SchemaDescriptor();
		//sd.setType(TypeConst.fromString(ctx.type().getText()));
		switch(type) {
		case Statement.create:
			//sc.descriptors.put(ctx.ATTRNAME().getText(), sd);
			break;
		}
		return 0;
	}
	
	@Override
	public Integer visitPrimarykey(MiniSQLParser.PrimarykeyContext ctx) {
		switch(type) {
		case Statement.create:
			SchemaDescriptor sd=sc.descriptors.get(ctx.String().getText());
			sd.setPrimary(true);
			sc.descriptors.put(ctx.String().getText(), sd);
			break;
		}
		return 0;
	}
}
