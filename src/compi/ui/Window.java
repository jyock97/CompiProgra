package compi.ui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.StringReader;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import compi.logic.Parser;
import compi.logic.Lexer;
import compi.utils.TextLineNumber;

public class Window {
	
	private final int 	width = 800,
						height = 600;
	
	private JFrame 		ideWindow;
	private JButton 	ideRunButton;
	private JTextArea 	ideCode,
						ideConsole;
	private JScrollPane scrollIdeCode,
						scrollIdeConsole,
						scroll;
	private TextLineNumber tln;
	
	public Window() {
		ideWindow = new JFrame("C-0");
		ideRunButton = new JButton("Run");
		ideCode = new JTextArea();
		ideConsole = new JTextArea();
		tln = new TextLineNumber(ideCode);
		scrollIdeCode = new JScrollPane(ideCode);
		scrollIdeConsole = new JScrollPane(ideConsole);
		scroll = new JScrollPane(tln);
		
		
		ideWindow.setLayout(null);
		ideWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ideWindow.setBounds(100, 80, width, height);
		ideWindow.setResizable(false);
		
		scrollIdeCode.setBounds(31, 32, width-31, (height/2 + height/5)-32);
		scrollIdeConsole.setBounds(1, (height/2 + height/5)+1, width-1, height-((height/2 + height/5)+34));
		scroll.setBounds(-10, 32, 60, (height/2 + height/5)-32);
		
		
		ideRunButton.setBounds(width-66, 1, 65, 30);
		ideRunButton.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					runProgram();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		ideWindow.add(scrollIdeCode);
		ideWindow.add(scrollIdeConsole);
		ideWindow.add(ideRunButton);
		ideWindow.add(scroll);
		
		
		
		ideWindow.setVisible(true);
	}
	
	private void runProgram() throws Exception{
		
		Parser p = new Parser(new Lexer(new StringReader(ideCode.getText())));
        Object result = p.parse().value;
	}
	
	private void compileProgram(){}

	public static void main(String[] args) {
		new Window();

	}

}
