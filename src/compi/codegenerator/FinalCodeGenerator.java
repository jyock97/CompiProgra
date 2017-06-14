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
			sBuilder.append("MOVE\t" + "#" + sA + ", /"+sC+"\n");
			break;
		
		case "LOAD_STRING":
                    int len = sA.length();
                    int ic = Integer.parseInt(sC);
                    for(int i = 0; i<len; i++){
			sBuilder.append("MOVE\t" + "\'" + sA.charAt(i) + "\'"+", /"+ ic++);//A esto no le hace falta el cambio de linea?
                    }
                    sBuilder.append("MOVE\t" + "'\0'" + ", /"+ ic++);//A esto no le hace falta el cambio de linea?
			break;
		
		case "CMP":
			sBuilder.append("CMP\t" + "/" + sA + ", /"+sC+"\n");
			break;
                case "BNE":
			sBuilder.append("BNE\t" + "$" + sC +"\n");
			break;
                case "BE":
			sBuilder.append("BE\t" + "$" + sC +"\n");
			break;
                case "BN":
			sBuilder.append("BN\t" + "$" + sC +"\n");
			break;
                case "BP":
			sBuilder.append("BC\t" + "$" + sC +"\n");
			break;
                case "LABEL":
			sBuilder.append("BE\t" + "$" + sC +"\n");
			break;
                case "BR":
			sBuilder.append("BR\t" + "$" + sC +"\n");
			break;
                case "WR_STR":
			System.out.print("BP \t\t" + "null, null, " + label + "\n");//FALTA
			break;
                case "WR_INT":
			System.out.print("BP \t\t" + "null, null, " + label + "\n");//FALTA
			break;
                case "RETURN":
			System.out.print("BP \t\t" + "null, null, " + label + "\n");//FALTA
			break;
                case "CALL":
                        sBuilder.append("CALL\t" + "$" + sC +"\n");
			break;
                case "ADD":
			sBuilder.append("ADD\t" + "/" + sA + ", /"+sB+"\n");
                        sBuilder.append("MOVE\t" + ".A" + ", /"+sC+"\n");
			break;
                case "SUB":
			sBuilder.append("SUB\t" + "/" + sA + ", /"+sB+"\n");
                        sBuilder.append("MOVE\t" + ".A" + ", /"+sC+"\n");
			break;
                case "MUL":
			sBuilder.append("MUL\t" + "/" + sA + ", /"+sB+"\n");
                        sBuilder.append("MOVE\t" + ".A" + ", /"+sC+"\n");
			break;
                case "DIV":
			sBuilder.append("DIV\t" + "/" + sA + ", /"+sB+"\n");
                        sBuilder.append("MOVE\t" + ".A" + ", /"+sC+"\n");
			break;
                case "EQUALS":
			System.out.print("BP \t\t" + "null, null, " + label + "\n");//FALTA
			break;
                case "GREATER":
			System.out.print("BP \t\t" + "null, null, " + label + "\n");//NO SE SI SE BOORA
			break;
                case "LESS":
			System.out.print("BP \t\t" + "null, null, " + label + "\n");//NO SE SI SE BORRA
			break;
                case "LOGIC_AND":
			System.out.print("BP \t\t" + "null, null, " + label + "\n");//FALTA
			break;
                case "LOGIC_OR":
			System.out.print("BP \t\t" + "null, null, " + label + "\n");//FALTA
			break;
                case "DIF":
			System.out.print("BP \t\t" + "null, null, " + label + "\n");//FALTA
			break;
      
		}
             
             s = br.readLine();             
             
         }
          BufferedWriter bw = new BufferedWriter(new FileWriter("archivo.txt"));
          bw.write(sBuilder.toString());
          bw.close();
        
    }
    
    
    
    
    
    
    
    
    
}
