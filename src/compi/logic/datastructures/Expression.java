package compi.logic.datastructures;

import compi.codegenerator.CodeGenerator;
import compi.logic.sym;

public class Expression {
	
	private int direction;
	private int type;
	private String id;
	
	public Expression(String id, int direcrion, int type) {
		this.id = id;
		this.direction = direcrion;
		this.type = type;
	}
	
	public Expression(int direcrion, int type) {
		this.direction = direcrion;
		this.type = type;
	}
	
	public String setId(){
		return this.id;
	}
	
	public int getDirection(){
		return this.direction;
	}
	
	public int getType(){
		return this.type;
	}
	
	public Expression add(Expression e){
		System.out.println("ADD \t\t\t#" + this.direction + ", #" + e.direction + ", #" + CodeGenerator.getCodeGenerator(null).direction);
		CodeGenerator.getCodeGenerator(null).sBuilder.append("ADD \t\t\t#" + this.direction + ", #" + e.direction + ", #" + CodeGenerator.getCodeGenerator(null).direction + "\n");
		return new Expression(CodeGenerator.getCodeGenerator(null).direction++, sym.INTEGER);
	}
	
	public Expression sub(Expression e){
		System.out.println("SUB \t\t\t#" + this.direction + ", #" + e.direction + ", #" + CodeGenerator.getCodeGenerator(null).direction);
		CodeGenerator.getCodeGenerator(null).sBuilder.append("SUB \t\t\t#" + this.direction + ", #" + e.direction + ", #" + CodeGenerator.getCodeGenerator(null).direction + "\n");
		return new Expression(CodeGenerator.getCodeGenerator(null).direction++, sym.INTEGER);
	}
	
	public Expression mul(Expression e){
		System.out.println("MUL \t\t\t#" + this.direction + ", #" + e.direction + ", #" + CodeGenerator.getCodeGenerator(null).direction + "\n");
		CodeGenerator.getCodeGenerator(null).sBuilder.append("MUL \t\t\t#" + this.direction + ", #" + e.direction + ", #" + CodeGenerator.getCodeGenerator(null).direction + "\n");
		return new Expression(CodeGenerator.getCodeGenerator(null).direction++, sym.INTEGER);
	}
	
	public Expression div(Expression e){
		System.out.println("DIV \t\t\t#" + this.direction + ", #" + e.direction + ", #" + CodeGenerator.getCodeGenerator(null).direction);
		CodeGenerator.getCodeGenerator(null).sBuilder.append("DIV \t\t\t#" + this.direction + ", #" + e.direction + ", #" + CodeGenerator.getCodeGenerator(null).direction + "\n");
		return new Expression(CodeGenerator.getCodeGenerator(null).direction++, sym.INTEGER);
	}
	
	public Expression equals(Expression e){
		System.out.print("EQUALS \t\t\t#" + this.direction + ", #" + e.direction + ", #" + CodeGenerator.getCodeGenerator(null).direction + "\n");
		CodeGenerator.getCodeGenerator(null).sBuilder.append("EQUALS \t\t\t#" + this.direction + ", #" + e.direction + ", #" + CodeGenerator.getCodeGenerator(null).direction + "\n");
		return new Expression(CodeGenerator.getCodeGenerator(null).direction++, sym.EQUALS);
	}
/**************** Para greater y less *****************/
/*  */
	public Expression greater(Expression e) {
		System.out.print("GREATER \t\t\t#" + this.direction + ", #" + e.direction + ", #" + CodeGenerator.getCodeGenerator(null).direction + "\n");
		CodeGenerator.getCodeGenerator(null).sBuilder.append("GREATER \t\t\t#" + this.direction + ", #" + e.direction + ", #" + CodeGenerator.getCodeGenerator(null).direction + "\n");
		return new Expression(CodeGenerator.getCodeGenerator(null).direction++, sym.GREATER);
	}

	public Expression less(Expression e) {
		System.out.print("LESS \t\t\t#" + this.direction + ", #" + e.direction + ", #" + CodeGenerator.getCodeGenerator(null).direction + "\n");
		CodeGenerator.getCodeGenerator(null).sBuilder.append("LESS \t\t\t#" + this.direction + ", #" + e.direction + ", #" + CodeGenerator.getCodeGenerator(null).direction + "\n");
		return new Expression(CodeGenerator.getCodeGenerator(null).direction++, sym.LESS);
	}

	public Expression and(Expression e) {
		System.out.print("LOGIC_AND \t\t\t#" + this.direction + ", #" + e.direction + ", #" + CodeGenerator.getCodeGenerator(null).direction + "\n");
		CodeGenerator.getCodeGenerator(null).sBuilder.append("LOGIC_AND \t\t\t#" + this.direction + ", #" + e.direction + ", #" + CodeGenerator.getCodeGenerator(null).direction + "\n");
		return new Expression(CodeGenerator.getCodeGenerator(null).direction++, sym.EQUALS);
	}

	public Expression or(Expression e) {
		System.out.print("LOGIC_OR \t\t\t#" + this.direction + ", #" + e.direction + ", #" + CodeGenerator.getCodeGenerator(null).direction + "\n");
		CodeGenerator.getCodeGenerator(null).sBuilder.append("LOGIC_OR \t\t\t#" + this.direction + ", #" + e.direction + ", #" + CodeGenerator.getCodeGenerator(null).direction + "\n");
		return new Expression(CodeGenerator.getCodeGenerator(null).direction++, sym.EQUALS);
	}

	public Expression dif(Expression e) {
		System.out.print("DIF \t\t\t#" + this.direction + ", #" + e.direction + ", #" + CodeGenerator.getCodeGenerator(null).direction + "\n");
		CodeGenerator.getCodeGenerator(null).sBuilder.append("DIF \t\t\t#" + this.direction + ", #" + e.direction + ", #" + CodeGenerator.getCodeGenerator(null).direction + "\n");
		return new Expression(CodeGenerator.getCodeGenerator(null).direction++, sym.DIF);
	}
	
	//CodeGenerator.getCodeGenerator(null).sBuilder.append( + "\n");
}
