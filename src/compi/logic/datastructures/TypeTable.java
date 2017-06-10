package compi.logic.datastructures;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import java_cup.internal_error;

public class TypeTable {
	
	private int lastScope;
	
	private ArrayList<HashMap<String, Symbol>> table;
	private HashMap<String, Integer> ids;
	private HashMap<String, Integer> procedures;
	
	public TypeTable() {
		
		table = new ArrayList<>();
		ids = new HashMap<>();
		procedures = new HashMap<>();
		createScope();				//Primer scope, el cual se considera global
	}
	
	public void createScope(){
		
		table.add(new HashMap<>());
		lastScope = table.size()-1;
	}
	
	public void deleteScope(){
		
		table.remove(lastScope);
		lastScope = table.size()-1;
	}
	
	public boolean addSymbol(String id, int type){
		
		HashMap<String, Symbol> currentScope = table.get(lastScope);
		
		if(currentScope.get(id) != null)
			return false;
		
		currentScope.put(id, new Symbol(id, type));
		return true;
	}
	
	public boolean addSymbol(String id, int type, int direction){
		
		HashMap<String, Symbol> currentScope = table.get(lastScope);

		if(currentScope.get(id) != null)
			return false;
		
		currentScope.put(id, new Symbol(id, type, direction));
		return true;
	}
	
	public Symbol getSymbol(String id){
		
		int cont = lastScope;
		HashMap<String, Symbol> currentScope;
		
		while(cont >= 0){
			
			currentScope = table.get(cont);
			Symbol s = currentScope.get(id);

			if(s != null){
				return s;
			}
			cont--;
		}
		return null;
	}
	
	public void addId(String id, Integer sym){
		ids.put(id, sym);
	}
	
	public Integer getId(String id){
		return ids.get(id);
	}

	public void addProcedure(String id, Integer sym){
		procedures.put(id, sym);
	}

	public Integer getProcedure(String id){
		return procedures.get(id);
	}
	/*public static void main(String[] args) throws internal_error, IOException, Exception {
	}*/
}
