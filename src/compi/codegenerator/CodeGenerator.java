package compi.codegenerator;

import compi.logic.datastructures.Symbol;
import compi.logic.datastructures.TypeTable;

public class CodeGenerator {
	
	public int				memory;
	private final int		maxInt = 65535;
	private final int 		minInt = -32768;
	
	private TypeTable 		table;
	
	public CodeGenerator(TypeTable table) {
		
		this.memory = 65535;	// Diraccion maxima de la memoria
		this.table = table;
	}
	
	
	public void generateINT_ID(String id){
		Symbol s = table.getSymbol(id);
		System.out.println("DIRECCION \t\t" + id + ", " + s.getDirection());
	}
	
	public void generateINT_ID_EXPR(String id, String expr){
		Symbol s = table.getSymbol(id);
		
		System.out.println("DIRECCION \t\t" + id + ", " + s.getDirection());
		System.out.println("CARGAR_VALOR \t\t" + expr + ", null, " + memory);
		System.out.println("CARGAR_DIRECCION \t" + memory + ", null, " + s.getDirection());
		memory--;
		//System.out.println("RESERVAR \t INT \t " + id);
		//System.out.println("ASIGNAR \t " + id + " \t " + expr);
	}
	
	public void generateID_EXPR(String id, String expr){
		//System.out.println("ASIGNAR \t " + id + " \t " + expr);
		Symbol s = table.getSymbol(id);
		
		System.out.println("DIRECCION \t\t" + id + ", " + s.getDirection());
		System.out.println("CARGAR_VALOR \t\t" + expr + ", null, " + memory);
		System.out.println("CARGAR_DIRECCION \t" + memory + ", null, " + s.getDirection());
		memory--;
	}
}
