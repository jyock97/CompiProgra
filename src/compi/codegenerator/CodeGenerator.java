package compi.codegenerator;


import compi.logic.datastructures.Expression;
import compi.logic.datastructures.Symbol;
import compi.logic.datastructures.TypeTable;

public class CodeGenerator {
	
	public int				memory;
	
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
		
		this.memory = 65535;	// Diraccion maxima de la memoria
		this.table = table;
		this.sBuilder = new StringBuilder();
	}
	
	
	
	
	/*********************************************************************************************/
	/********************** Metodos para la generacion de codigo *********************************/
	/*********************************************************************************************/
	
	public void generateID(String id){
		Symbol s = table.getSymbol(id);
		sBuilder.append("DIRECTION \t\t" + id + ", null, " + s.getDirection() + "\n");
		System.out.println("DIRECTION \t\t" + id + ", null, " + s.getDirection());
	}
	
	public void generateID_EXPR(String id, Expression e){
		//System.out.println("ASIGNAR \t " + id + " \t " + expr);
		Symbol s = table.getSymbol(id);
		sBuilder.append("LOAD_DIRECTION \t\t" + e.getDirection() + ", null, " + s.getDirection() + "\n");
		System.out.println("LOAD_DIRECTION \t\t" + e.getDirection() + ", null, " + s.getDirection());
	}
	
	public void generateIntLiteral(Expression e){
		sBuilder.append("LOAD_VALUE \t\t" + e.getValue() + ", null, " + e.getDirection() + "\n");
		System.out.println("LOAD_VALUE \t\t" + e.getValue() + ", null, " + e.getDirection());
	}
	
	public void generateStringLiteral(Expression e){
		System.out.println("LOAD_VALUE \t\t" + e.getValue() + ", null, " + e.getDirection());
	}
}
