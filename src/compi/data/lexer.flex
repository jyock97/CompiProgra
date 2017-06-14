package compi.logic;
import java_cup.runtime.*;
import java.lang.StringBuilder;
import compi.logic.datastructures.Token;

%%

%public
%class Lexer
%unicode
%cup
%line
%column

%{
    public  Token token =  Token.createToken();
    private Symbol symbol(int type) {
        return new Symbol(type, yyline, yycolumn);
    }
    private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline, yycolumn, value);
    }
    
    private void noCharacterError(String s){
    	System.out.println("El caracter <" + s + "> no pertenece al lenguaje"); 
    }
%}

Whitespace		= [ \t\n]
Digit			= [0-9]
IntegerLiteral	= {Digit}+
StringLiteral	= \"([\x20-\x21\x23-\xFE])*\"
Word			= [a-zA-Z]
Id				= {Word}({Word}|{Digit})*

%%

<YYINITIAL> {
    {Whitespace}		{}

    "int"				{ token.sb.append("Token: " + yytext() + "\tColumna: " + yycolumn + "\tLinea: " + yyline + "\n");
                                            return symbol(sym.INTEGER); }
    "string"			{ token.sb.append("Token: " + yytext() + "\tColumna: " + yycolumn + "\tLinea: " + yyline + "\n");
                                    return symbol(sym.STRING); }
    "boolean"			{ token.sb.append("Token: " + yytext() + "\tColumna: " + yycolumn + "\tLinea: " + yyline + "\n");
                                   return symbol(sym.BOOLEAN); }
    "true"				{ token.sb.append("Token: " + yytext() + "\tColumna: " + yycolumn + "\tLinea: " + yyline + "\n");
                                           return symbol(sym.BOOLEAN_LITERAL, new String(yytext())); }
    "false"				{ token.sb.append("Token: " + yytext() + "\tColumna: " + yycolumn + "\tLinea: " + yyline + "\n");
                                           return symbol(sym.BOOLEAN_LITERAL, new String(yytext())); }
    "if"				{ token.sb.append("Token: " + yytext() + "\tColumna: " + yycolumn + "\tLinea: " + yyline + "\n");
                                            return symbol(sym.IF); }
    "else"				{ token.sb.append("Token: " + yytext() + "\tColumna: " + yycolumn + "\tLinea: " + yyline + "\n");
                                            return symbol(sym.ELSE); }
    "while"				{ token.sb.append("Token: " + yytext() + "\tColumna: " + yycolumn + "\tLinea: " + yyline + "\n");
                                            return symbol(sym.WHILE); }
    "break"				{ token.sb.append("Token: " + yytext() + "\tColumna: " + yycolumn + "\tLinea: " + yyline + "\n");
                                            return symbol(sym.BREAK); }
    "main"				{ token.sb.append("Token: " + yytext() + "\tColumna: " + yycolumn + "\tLinea: " + yyline + "\n");
                                            return symbol(sym.MAIN); }
    "return"                            { token.sb.append("Token: " + yytext() + "\tColumna: " + yycolumn + "\tLinea: " + yyline + "\n");
                                            return symbol(sym.RETURN); }
    "puts"				{ token.sb.append("Token: " + yytext() + "\tColumna: " + yycolumn + "\tLinea: " + yyline + "\n");
                                            return symbol(sym.PUTS); }
    "putw"				{ token.sb.append("Token: " + yytext() + "\tColumna: " + yycolumn + "\tLinea: " + yyline + "\n");
                                            return symbol(sym.PUTW); }
    "+"					{ token.sb.append("Token: " + yytext() + "\tColumna: " + yycolumn + "\tLinea: " + yyline + "\n");
                                            return symbol(sym.ADD); }
    "-"					{ token.sb.append("Token: " + yytext() + "\tColumna: " + yycolumn + "\tLinea: " + yyline + "\n"); 
                                            return symbol(sym.MINUS); }
    "*"					{ token.sb.append("Token: " + yytext() + "\tColumna: " + yycolumn + "\tLinea: " + yyline + "\n");
                                            return symbol(sym.TIMES); }
    "/"					{ token.sb.append("Token: " + yytext() + "\tColumna: " + yycolumn + "\tLinea: " + yyline + "\n");
                                            return symbol(sym.DIV); }
    "("					{ token.sb.append("Token: " + yytext() + "\tColumna: " + yycolumn + "\tLinea: " + yyline + "\n");
                                            return symbol(sym.LPAREN); }
    ")"					{ token.sb.append("Token: " + yytext() + "\tColumna: " + yycolumn + "\tLinea: " + yyline + "\n");
                                            return symbol(sym.RPAREN); }
    ";"					{ token.sb.append("Token: " + yytext() + "\tColumna: " + yycolumn + "\tLinea: " + yyline + "\n");
                                            return symbol(sym.SEMICOLON); }
    "="					{ token.sb.append("Token: " + yytext() + "\tColumna: " + yycolumn + "\tLinea: " + yyline + "\n");
                                            return symbol(sym.ASSIGN); }
    "=="				{ token.sb.append("Token: " + yytext() + "\tColumna: " + yycolumn + "\tLinea: " + yyline + "\n");
                                            return symbol(sym.EQUALS); }
    "{"					{ token.sb.append("Token: " + yytext() + "\tColumna: " + yycolumn + "\tLinea: " + yyline + "\n");
                                            return symbol(sym.LBRACE); }
    "}"					{ token.sb.append("Token: " + yytext() + "\tColumna: " + yycolumn + "\tLinea: " + yyline + "\n");
                                            return symbol(sym.RBRACE); }
    "<"					{ token.sb.append("Token: " + yytext() + "\tColumna: " + yycolumn + "\tLinea: " + yyline + "\n");
                                            return symbol(sym.LESS); }
    ">"					{ token.sb.append("Token: " + yytext() + "\tColumna: " + yycolumn + "\tLinea: " + yyline + "\n");
                                            return symbol(sym.GREATER); }
    "!="				{ token.sb.append("Token: " + yytext() + "\tColumna: " + yycolumn + "\tLinea: " + yyline + "\n");
                                            return symbol(sym.DIF); }
    "||"				{ token.sb.append("Token: " + yytext() + "\tColumna: " + yycolumn + "\tLinea: " + yyline + "\n");
                                            return symbol(sym.OR); }
    "&&"				{ token.sb.append("Token: " + yytext() + "\tColumna: " + yycolumn + "\tLinea: " + yyline + "\n");
                                            return symbol(sym.AND); }

    {StringLiteral}		{ token.sb.append("Token: " + yytext() + "\tColumna: " + yycolumn + "\tLinea: " + yyline + "\n");
                                    return symbol(sym.STRING_LITERAL, new String(yytext())); }
	{IntegerLiteral}	{ token.sb.append("Token: " + yytext() + "\tColumna: " + yycolumn + "\tLinea: " + yyline + "\n");
                                    return symbol(sym.INTEGER_LITERAL, new String(yytext())); }
    {Id}				{ //System.out.println("Es id");
                                        token.sb.append("Token: " + yytext() + "\tColumna: " + yycolumn + "\tLinea: " + yyline + "\n");
    						return symbol(sym.ID, new String(yytext())); }
    
    .					{ noCharacterError(yytext()); }
}





