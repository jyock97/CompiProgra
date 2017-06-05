package compi.logic.datastructures;

import compi.codegenerator.CodeGenerator;
import compi.logic.sym;

public class Expression {
	
	private int direction;
	private int type;
	
	public Expression(int direcrion, int type) {
		this.direction = direcrion;
		this.type = type;
	}
	
	public void setDirection(int direction){
		this.direction = direction;
	}
	
	public int getDirection(){
		return this.direction;
	}
	
	public int getType(){
		return this.type;
	}
	
	public Expression add(Expression e){
		CodeGenerator.getCodeGenerator(null).sBuilder.append("ADD \t\t\t#" + this.direction + ", #" + e.direction + ", #" + CodeGenerator.getCodeGenerator(null).direction + "\n");
		return new Expression(CodeGenerator.getCodeGenerator(null).direction++, sym.INTEGER);
	}
	
	public Expression sub(Expression e){
		CodeGenerator.getCodeGenerator(null).sBuilder.append("SUB \t\t\t#" + this.direction + ", #" + e.direction + ", #" + CodeGenerator.getCodeGenerator(null).direction + "\n");
		return new Expression(CodeGenerator.getCodeGenerator(null).direction++, sym.INTEGER);
	}
	
	public Expression mul(Expression e){
		CodeGenerator.getCodeGenerator(null).sBuilder.append("MUL \t\t\t#" + this.direction + ", #" + e.direction + ", #" + CodeGenerator.getCodeGenerator(null).direction + "\n");
		return new Expression(CodeGenerator.getCodeGenerator(null).direction++, sym.INTEGER);
	}
	
	public Expression div(Expression e){
		CodeGenerator.getCodeGenerator(null).sBuilder.append("DIV \t\t\t#" + this.direction + ", #" + e.direction + ", #" + CodeGenerator.getCodeGenerator(null).direction + "\n");
		return new Expression(CodeGenerator.getCodeGenerator(null).direction++, sym.INTEGER);
	}
	
	public Expression equals(Expression e){
		System.out.print("EQUALS \t\t\t#" + this.direction + ", #" + e.direction + ", #" + CodeGenerator.getCodeGenerator(null).direction + "\n");
		CodeGenerator.getCodeGenerator(null).sBuilder.append("EQUALS \t\t\t#" + this.direction + ", #" + e.direction + ", #" + CodeGenerator.getCodeGenerator(null).direction + "\n");
		return new Expression(CodeGenerator.getCodeGenerator(null).direction++, sym.BOOLEAN);
	}

	public Expression greater(Expression e) {
		System.out.print("GREATER \t\t\t#" + this.direction + ", #" + e.direction + ", #" + CodeGenerator.getCodeGenerator(null).direction + "\n");
		CodeGenerator.getCodeGenerator(null).sBuilder.append("GREATER \t\t\t#" + this.direction + ", #" + e.direction + ", #" + CodeGenerator.getCodeGenerator(null).direction + "\n");
		return new Expression(CodeGenerator.getCodeGenerator(null).direction++, sym.BOOLEAN);
	}

	public Expression less(Expression e) {
		CodeGenerator.getCodeGenerator(null).sBuilder.append("LESS \t\t\t#" + this.direction + ", #" + e.direction + ", #" + CodeGenerator.getCodeGenerator(null).direction + "\n");
		return new Expression(CodeGenerator.getCodeGenerator(null).direction++, sym.BOOLEAN);
	}

	public Expression and(Expression e) {
		CodeGenerator.getCodeGenerator(null).sBuilder.append("AND \t\t\t#" + this.direction + ", #" + e.direction + ", #" + CodeGenerator.getCodeGenerator(null).direction + "\n");
		return new Expression(CodeGenerator.getCodeGenerator(null).direction++, sym.BOOLEAN);
	}

	public Expression or(Expression e) {
		CodeGenerator.getCodeGenerator(null).sBuilder.append("OR \t\t\t#" + this.direction + ", #" + e.direction + ", #" + CodeGenerator.getCodeGenerator(null).direction + "\n");
		return new Expression(CodeGenerator.getCodeGenerator(null).direction++, sym.BOOLEAN);
	}

	public Expression dif(Expression e) {
		CodeGenerator.getCodeGenerator(null).sBuilder.append("DIF \t\t\t#" + this.direction + ", #" + e.direction + ", #" + CodeGenerator.getCodeGenerator(null).direction + "\n");
		return new Expression(CodeGenerator.getCodeGenerator(null).direction++, sym.BOOLEAN);
	}
	
	//CodeGenerator.getCodeGenerator(null).sBuilder.append( + "\n");
}
