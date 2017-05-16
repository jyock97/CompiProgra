/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectocompi;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;

/**
 *
 * @author josetri
 */
public class ProyectoCompi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, Exception {
        if(true){
            
        
        String[] in = {"-parser", "Parser", "src/proyectocompi/compilador.cup"};
        jflex.Main.generate(new File("src/proyectocompi/compilador.flex"));
        java_cup.Main.main(in);
        
        new File("Parser.java").renameTo(new File("src/proyectocompi/Parser.java"));
        new File("sym.java").renameTo(new File("src/proyectocompi/sym.java"));
        }else{
        
        Parser p = new Parser(new Lexer(new StringReader("3;")));
        Object result = p.parse().value;
        System.out.println(result);
        }
    }
    
    
}
