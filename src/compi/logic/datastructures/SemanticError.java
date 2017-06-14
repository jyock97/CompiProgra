/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compi.logic.datastructures;

/**
 *
 * @author josetri
 */
public  class SemanticError {
     public static StringBuilder  sb;
     public static SemanticError sError;

    public SemanticError() {
        sb = new StringBuilder();
    }
    
    	public static SemanticError createSemanticError(){
		if(sError == null){
			sError = new SemanticError();
		}
		return sError;
	}
	
	
    
}
