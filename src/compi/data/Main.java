package compi.data;

import java.io.File;
import java.io.IOException;

import java_cup.internal_error;

public class Main {

	public static void main(String[] args) throws internal_error, IOException, Exception {
		
		String[] in = {"-parser", "Parser", "src/compi/data/parser.cup"};
        jflex.Main.generate(new File("src/compi/data/lexer.flex"));
        java_cup.Main.main(in);
        
        new File("Parser.java").renameTo(new File("src/compi/logic/Parser.java"));
        new File("sym.java").renameTo(new File("src/compi/logic/sym.java"));
        new File("src/compi/data/Lexer.java").renameTo(new File("src/compi/logic/Lexer.java"));
	}
}
