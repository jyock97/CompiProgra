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
public class Token {
    public static StringBuilder  sb;
    public static Token token;

    public Token() {
        sb = new StringBuilder();
        
    }
    
    public static Token createToken(){
		if(token == null){
			token = new Token();
		}
		return token;
	}
}
