package compi.logic.datastructures;

public class Symbol {
	
	private String	id,
					value;
	private int		type,
					direction;
	
	public Symbol(String id, int type, int direction) {
		this.id = id;
		this.type = type;
		this.value = null;
		this.direction = direction;
	}
	
	public Symbol(String id, int type, String value, int direction) {
		this.id = id;
		this.type = type;
		this.value = value;
		this.direction = direction;
	}
	
	public String getId(){
		return this.id;
	}
	
	public int getType(){
		return this.type;
	}
	
	public void setValue(String value){
		this.value = value;
	}
	
	public String getValue(){
		return this.value;
	}
	
	public int getDirection(){
		return this.direction;
	}
}
