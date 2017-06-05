package compi.codegenerator;


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
		
		this.direction = 0;	// Diraccion maxima de la memoria
		this.table = table;
		this.sBuilder = new StringBuilder();
	}
	
	
	
	
	/*********************************************************************************************/
	/********************** Metodos para la generacion de codigo *********************************/
	/*********************************************************************************************/
	
	public void generateID(String id){
		Symbol s = table.getSymbol(id);
		System.out.print("DIRECTION \t\t" + id + ", null, #" + s.getDirection() + "\n");
		sBuilder.append("DIRECTION \t\t" + id + ", null, #" + s.getDirection() + "\n");
	}
	
	public void generateID_EXPR(String id, Expression e){
		//System.out.println("ASIGNAR \t " + id + " \t " + expr);
		Symbol s = table.getSymbol(id);
		System.out.print("LOAD_DIRECTION \t\t#" + e.getDirection() + ", null, #" + s.getDirection() + "\n");
		sBuilder.append("LOAD_DIRECTION \t\t#" + e.getDirection() + ", null, #" + s.getDirection() + "\n");
	}
	
	public void generateIntegerLiteral(String literal, Expression e){
		System.out.print("LOAD_INTEGER \t\t" + literal + ", null, #" + e.getDirection() + "\n");
		sBuilder.append("LOAD_INTEGER \t\t" + literal + ", null, #" + e.getDirection() + "\n");
	}
	
	public void generateStringLiteral(String literal, Expression e){
		System.out.print("LOAD_STRING \t\t" + literal + ", null, #" + e.getDirection() + "\n");
		sBuilder.append("LOAD_STRING \t\t" + literal + ", null, #" + e.getDirection() + "\n");
	}
	
	public void generateBooleanLiteral(String literal, Expression e){
		System.out.print("LOAD_INTEGER \t\t" + 1 + ", null, #" + e.getDirection() + "\n");
		if(literal.equals("true"))
			sBuilder.append("LOAD_INTEGER \t\t" + 1 + ", null, #" + e.getDirection() + "\n");
		
		else
			sBuilder.append("LOAD_INTEGER \t\t" + 0 + ", null, #" + e.getDirection() + "\n");
	}
	
	public void generateValidateEquals(Expression e){
		System.out.print("CMP \t\t" + e.getDirection() + ", 1, #" + e.getDirection() + "\n");
	}

	public void generateBranchNotEquals(String label) {
		System.out.print("BNE \t\t" + label + ", null, #" + "e.getDirection()" + "\n");
	}

	public void generateLabel(String label) {
		System.out.print("LABEL \t\t" + label + ", null, #" + "e.getDirection()" + "\n");
	}

	public void generateJmpLabel(String label) {
		System.out.print("JMP \t\t" + label + ", null, #" + "e.getDirection()" + "\n");
	}
}
