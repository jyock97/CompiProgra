package compi.logic.datastructures;

public class Symbol {
	
	private String	id;
	private int		type,
					direction;
	
	public Symbol(String id, int type, int direction) {
		this.id = id;
		this.type = type;
		this.direction = direction;
	}
	
	public Symbol(String id, int type) {
		this.id = id;
		this.type = type;
	}
	
	public String getId(){
		return this.id;
	}
	
	public int getType(){
		return this.type;
	}
	
	public int getDirection(){
		return this.direction;
	}
}
