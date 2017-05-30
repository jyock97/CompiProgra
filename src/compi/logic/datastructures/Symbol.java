package compi.logic.datastructures;

public class Symbol {
	
	private String	id,
					value;
	private int		type;
	
	public Symbol(String id, int type) {
		this.id = id;
		this.type = type;
		this.value = null;
	}
	
	public Symbol(String id, int type, String value) {
		this.id = id;
		this.type = type;
		this.value = value;
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
}
