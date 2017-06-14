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

	// = br.readLine(); //dentro del while

	private StringBuilder sBuilder;
	private String fCode, instruction, sA, sB, sC;
	private StringTokenizer token;

	public FinalCodeGenerator(String fCode) {
		this.fCode = fCode;
		sBuilder = new StringBuilder();
		br = new BufferedReader(new StringReader(fCode));
	}

	public void generate(){
		try {
			s = br.readLine();
			System.out.println("\t\t" + s);
		while (s != null) {
			token = new StringTokenizer(s, "\t");
			instruction = token.nextToken();
			sA = token.nextToken("\t, #");
			sB = token.nextToken(", #");
			sC = token.nextToken(", #");

			switch (instruction) {

			case "LOAD_DIRECTION":
				sBuilder.append("MOVE\t" + "/" + sA + ", /" + sC + "\n");
				break;

			case "LOAD_INTEGER":
				sBuilder.append("MOVE\t" + "#" + sA + ", /" + sC + "\n");
				break;

			case "LOAD_STRING":
				int len = sA.length();
				int ic = Integer.parseInt(sC);
				for (int i = 0; i < len; i++) {
					sBuilder.append("MOVE\t" + "\'" + sA.charAt(i) + "\'" + ", /" + ic++ + "\n");
				}
				sBuilder.append("MOVE\t" + "'\0'" + ", /" + ic++ + "\n");
				break;

			case "CMP":
				sBuilder.append("CMP\t" + "/" + sA + ", /" + sB + "\n");
				break;
			case "BNZ":
				sBuilder.append("BNZ\t" + "$" + sC + "\n");
				break;
			case "BZ":
				sBuilder.append("BZ\t" + "$" + sC + "\n");
				break;
			case "BN":
				sBuilder.append("BN\t" + "$" + sC + "\n");
				break;
			case "BP":
				sBuilder.append("BC\t" + "$" + sC + "\n");
				break;
			case "LABEL":
				sBuilder.append("BE\t" + "$" + sC + "\n");
				break;
			case "BR":
				sBuilder.append("BR\t" + "$" + sC + "\n");
				break;
			case "WR_STR":
				sBuilder.append("WRSTR\t" + "/" + sC + "\n");
				break;
			case "WR_INT":
				sBuilder.append("WRINT\t" + "/" + sC + "\n");
				break;
			case "RETURN":
				sBuilder.append("MOV\t" + "/0, /" + sC + "\n");
				break;
			case "CALL":
				sBuilder.append("CALL\t" + sA + "\n");//Falta agregar ret en gramatica y aqui
				break;
			case "ADD":
				sBuilder.append("ADD\t" + "/" + sA + ", /" + sB + "\n");
				sBuilder.append("MOVE\t" + ".A" + ", /" + sC + "\n");
				break;
			case "SUB":
				sBuilder.append("SUB\t" + "/" + sA + ", /" + sB + "\n");
				sBuilder.append("MOVE\t" + ".A" + ", /" + sC + "\n");
				break;
			case "MUL":
				sBuilder.append("MUL\t" + "/" + sA + ", /" + sB + "\n");
				sBuilder.append("MOVE\t" + ".A" + ", /" + sC + "\n");
				break;
			case "DIV":
				sBuilder.append("DIV\t" + "/" + sA + ", /" + sB + "\n");
				sBuilder.append("MOVE\t" + ".A" + ", /" + sC + "\n");
				break;
			case "EQUALS":
				sBuilder.append("CMP\t,/" + sA + ", /" + sB + "\n");
				sBuilder.append("BZ\t,$3\n");
				sBuilder.append("MOV\t#" + 0 + ", /" + sC + "\n");
				sBuilder.append("BR\t,$2\n");
				sBuilder.append("MOV\t#" + 1 + ", /S" + sC + "\n");
				break;
			case "GREATER":
				sBuilder.append("CMP\t,/" + sB + ", /" + sA + "\n");
				sBuilder.append("BN\t,$3\n");
				sBuilder.append("MOV\t#" + 0 + ", /" + sC + "\n");
				sBuilder.append("BR\t,$2\n");
				sBuilder.append("MOV\t#" + 1 + ", /" + sC + "\n");
				break;
			case "LESS":
				sBuilder.append("CMP\t,/" + sA + ", /" + sB + "\n");
				sBuilder.append("BN\t,$3\n");
				sBuilder.append("MOV\t#" + 0 + ", /" + sC + "\n");
				sBuilder.append("BR\t,$2\n");
				sBuilder.append("MOV\t#" + 1 + ", /" + sC + "\n");
				break;
			case "LOGIC_AND":
				sBuilder.append("AND\t/" + sA + ", /" + sB + "\n");
				sBuilder.append("MOVE\t" + ".A" + ", /" + sC + "\n");
				break;
			case "LOGIC_OR":
				sBuilder.append("OR\t/" + sA + ", /" + sB + "\n");
				sBuilder.append("MOVE\t" + ".A" + ", /" + sC + "\n");
				break;
			case "DIF":
				sBuilder.append("CMP\t,/" + sA + ",/" + sB + "\n");
				sBuilder.append("BNZ\t,$3\n");
				sBuilder.append("MOV\t#" + 0 + ",/" + sC + "\n");
				sBuilder.append("BR\t,$2\n");
				sBuilder.append("MOV\t#" + 1 + ",/S" + sC + "\n");
				break;

			}

			s = br.readLine();
			System.out.println("\t\t" + s);
		}
		BufferedWriter bw = new BufferedWriter(new FileWriter("out.ens"));
		bw.write(sBuilder.toString());
		bw.close();
		} catch (IOException e) {
			System.out.println("Error manipulando 'out.ens'");
		}
	}

}