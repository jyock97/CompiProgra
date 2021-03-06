package compi.codegenerator;


import compi.logic.sym;
import compi.logic.datastructures.Expression;
import compi.logic.datastructures.Symbol;
import compi.logic.datastructures.TypeTable;

public class CodeGenerator {
	
	public int				direction;
	
	public StringBuilder 	sBuilder;
	
	private final int		maxInt = 65535;
	private final int 		minInt = -32768;
	
	private TypeTable 		table;
	private static CodeGenerator cGenerator;
	
	
	public static CodeGenerator getCodeGenerator(TypeTable table){
		if(cGenerator == null){
			cGenerator = new CodeGenerator(table);
		}
		return cGenerator;
	}
	
	private CodeGenerator(TypeTable table) {
		
		this.direction = 1;	// Diraccion maxima de la memoria
		this.table = table;
		this.sBuilder = new StringBuilder();
	}
	
	
	
	
	/*********************************************************************************************/
	/********************** Metodos para la generacion de codigo *********************************/
	/*********************************************************************************************/
	
	public void generateID(String id){
		Symbol s = table.getSymbol(id);
		//System.out.print("DIRECTION\t" + id + ",null,#" + s.getDirection() + "\n");
		sBuilder.append("DIRECTION\t" + id + ",null,#" + s.getDirection() + "\n");
	}
	
	public void generateID_EXPR(String id, Expression e){
		//System.out.println("ASIGNAR \t " + id + " \t " + expr);
		Symbol s = table.getSymbol(id);
		System.out.print("LOAD_DIRECTION\t#" + e.getDirection() + ",null,#" + s.getDirection() + "\n");
		sBuilder.append("LOAD_DIRECTION\t#" + e.getDirection() + ",null,#" + s.getDirection() + "\n");
	}
	
	public void generateIntegerLiteral(String literal, Expression e){
		System.out.print("LOAD_INTEGER\t" + literal + ",null,#" + e.getDirection() + "\n");
		sBuilder.append("LOAD_INTEGER\t" + literal + ",null,#" + e.getDirection() + "\n");
	}
	
	public void generateStringLiteral(String literal, Expression e){
		System.out.print("LOAD_STRING\t" + literal + ",null,#" + e.getDirection() + "\n");
		sBuilder.append("LOAD_STRING\t" + literal + ",null,#" + e.getDirection() + "\n");
	}
	
	public void generateBooleanLiteral(String literal, Expression e){
		System.out.print("LOAD_INTEGER\t" + 1 + ", null,#" + e.getDirection() + "\n");
		if(literal.equals("true"))
			sBuilder.append("LOAD_INTEGER\t" + 1 + ",null,#" + e.getDirection() + "\n");
		
		else
			sBuilder.append("LOAD_INTEGER\t" + 0 + ",null,#" + e.getDirection() + "\n");
	}
	
	public void generateCompare(Expression e){
		System.out.print("CMP\t#" + e.getDirection() + ",1,null\n");
		sBuilder.append("CMP\t#" + e.getDirection() + ",1,null\n");
	}

	public void generateBranchNotTrue(String label, Expression e) {
		
		generateCompare(e);
		System.out.print("BNZ\t" + "null,null," + label + "\n");
		sBuilder.append("BNZ\t" + "null,null," + label + "\n");
	}

	public void generateLabel(String label) {
		System.out.print("LABEL\t" + "null,null," + label + "\n");
		sBuilder.append("LABEL\t" + "null,null," + label + "\n");
	}

	public void generateBranch(String label) {
		System.out.print("BR\t" + "null,null, " + label + "\n");
		sBuilder.append("BR\t" + "null,null, " + label + "\n");
	}

	public void printString(Expression e) {
		System.out.print("WR_STR\t" + "null,null,#" + e.getDirection() + "\n");
		sBuilder.append("WR_STR\t" + "null,null,#" + e.getDirection() + "\n");
	}

	public void printNumber(Expression e) {
		System.out.print("WR_INT\t" + "null,null,#" + e.getDirection() + "\n");
		sBuilder.append("WR_INT\t" + "null,null,#" + e.getDirection() + "\n");
	}

	public void generateReturn(Expression e) {
		System.out.print("RETURN\t" + "null,null,#" + e.getDirection() + "\n");
		sBuilder.append("RETURN\t" + "null,null,#" + e.getDirection() + "\n");
	}

	public void generateSubProgramCall(String id) {
		System.out.print("CALL\t" + "null,null," + id + "\n");
		sBuilder.append("CALL\t" + "null,null," + id + "\n");
	}
	
	public void generateSubProgramId(String id) {
		
	}
}
