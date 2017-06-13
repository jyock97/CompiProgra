/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compi.codegenerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.io.*;
import java.util.StringTokenizer;

/**
 *
 * @author josetri
 */
public class FinalCodeGenerator {
    BufferedReader br;           
    String s;
    

    //= br.readLine();   //dentro del while
   
    private StringBuilder sBuilder;
    private String fCode, instruction, sA, sB, sC;
    private StringTokenizer token;
    
    
    private FinalCodeGenerator(String fCode) {
        this.fCode = fCode;
        br = new BufferedReader( new StringReader(fCode)); 
    }
    
    
    private void generated() throws IOException{
        s = br.readLine();
         while( s != null){
             token = new StringTokenizer(s, "\t");
             instruction = token.nextToken();
             sA = token.nextToken("\t, #");
             sB = token.nextToken(", #");
             sC = token.nextToken(", #");
             
             
             switch(instruction){
		
		case "LOAD_DIRECTION":
			sBuilder.append("MOVE\t" + "/" + sA + ", /"+sC+"\n");
			break;
			
		case "LOAD_INTEGER":
			System.out.print("BE \t\t" + "null, null, " + label + "\n");
			break;
		
		case "LOAD_STRING":
                    int len = sA.length();
                    int ic = Integer.parseInt(sC);
                    for(int i = 0; i<len; i++){
			sBuilder.append("MOVE\t" + "\'" + sA.charAt(i) + "\'"+", /"+ ic++);
                    }
                    sBuilder.append("MOVE\t" + "'\0'" + ", /"+ ic++);
			break;
		
		case "CMP":
			System.out.print("BP \t\t" + "null, null, " + label + "\n");
			break;
                case "BNE":
			System.out.print("BP \t\t" + "null, null, " + label + "\n");
			break;
                case "BE":
			System.out.print("BP \t\t" + "null, null, " + label + "\n");
			break;
                case "BN":
			System.out.print("BP \t\t" + "null, null, " + label + "\n");
			break;
                case "BP":
			System.out.print("BP \t\t" + "null, null, " + label + "\n");
			break;
                case "LABEL":
			System.out.print("BP \t\t" + "null, null, " + label + "\n");
			break;
                case "BR":
			System.out.print("BP \t\t" + "null, null, " + label + "\n");
			break;
                case "WR_STR":
			System.out.print("BP \t\t" + "null, null, " + label + "\n");
			break;
                case "WR_INT":
			System.out.print("BP \t\t" + "null, null, " + label + "\n");
			break;
                case "RETURN":
			System.out.print("BP \t\t" + "null, null, " + label + "\n");
			break;
                case "CALL":
			System.out.print("BP \t\t" + "null, null, " + label + "\n");
			break;
                case "ADD":
			System.out.print("BP \t\t" + "null, null, " + label + "\n");
			break;
                case "SUB":
			System.out.print("BP \t\t" + "null, null, " + label + "\n");
			break;
                case "MUL":
			System.out.print("BP \t\t" + "null, null, " + label + "\n");
			break;
                case "DIV":
			System.out.print("BP \t\t" + "null, null, " + label + "\n");
			break;
                case "EQUALS":
			System.out.print("BP \t\t" + "null, null, " + label + "\n");
			break;
                case "GREATER":
			System.out.print("BP \t\t" + "null, null, " + label + "\n");
			break;
                case "LESS":
			System.out.print("BP \t\t" + "null, null, " + label + "\n");
			break;
                case "LOGIC_AND":
			System.out.print("BP \t\t" + "null, null, " + label + "\n");
			break;
                case "LOGIC_OR":
			System.out.print("BP \t\t" + "null, null, " + label + "\n");
			break;
                case "DIF":
			System.out.print("BP \t\t" + "null, null, " + label + "\n");
			break;
      
		}
             
             s = br.readLine();             
             
         }
          BufferedWriter bw = new BufferedWriter(new FileWriter("archivo.txt"));
          bw.write(sBuilder.toString());
          bw.close();
        
    }
    
    
    
    
    
    
    
    
    
}
