package compi.logic.datastructures;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import java_cup.internal_error;

public class TypeTable {
	
	private int lastScope;
	
	private ArrayList<HashMap<String, Symbol>> table;
	
	public TypeTable() {
		
		table = new ArrayList<>();
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
	
	public boolean addSymbol(String id, int type, String value){
		
		HashMap<String, Symbol> currentScope = table.get(lastScope);
		
		if(currentScope.get(id) != null)
			return false;
		
		currentScope.put(id, new Symbol(id, type, value));
		return true;
	}
	
	public boolean addSymbol(String id, int type){
		
		HashMap<String, Symbol> currentScope = table.get(lastScope);

		if(currentScope.get(id) != null)
			return false;
		
		currentScope.put(id, new Symbol(id, type));
		return true;
	}
	
	public void setSymbol(String id, String value){
		
		Symbol s = getSymbol(id);
		s.setValue(value);
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
	/*public static void main(String[] args) throws internal_error, IOException, Exception {
	}*/
}
