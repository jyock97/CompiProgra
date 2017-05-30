package compi.logic;
import java_cup.runtime.*;

%%

%public
%class Lexer
%unicode
%cup
%line
%column

%{
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

Whitespace      = [ \t\n]
Digit           = [0-9]
Integer         = {Digit}+
Word            = [a-zA-Z]
Id              = {Word} ({Word}|{Digit})*
Symbols			= [!-/]
Literal         = \"([\x20-\x21\x23-\xFE])*\"
Boolean         = [false | true] 

%%

<YYINITIAL> {
    {Whitespace}	{}

    "main"			{ return symbol(sym.MAIN); }
    "if"			{ return symbol(sym.IF); }
    "else"			{ return symbol(sym.ELSE); }
    "while"			{ return symbol(sym.WHILE); }
    "break"			{ return symbol(sym.BREAK); }
    "int"			{ return symbol(sym.INT); }
    "puts"			{ return symbol(sym.PUTS); }
    "putw"			{ return symbol(sym.PUTW); }
    
    "+"				{ return symbol(sym.ADD); }
    "-"				{ return symbol(sym.MINUS); }
    "*"				{ return symbol(sym.TIMES); }
    "/"				{ return symbol(sym.DIV); }
    "("				{ return symbol(sym.LPAREN); }
    ")"				{ return symbol(sym.RPAREN); }
    ";"				{ return symbol(sym.SEMICOLON); }
    "="				{ return symbol(sym.ASSIGN); }
    "=="			{ return symbol(sym.EQUALS); }
    "{"				{ return symbol(sym.LBRACE); }
    "}"				{ return symbol(sym.RBRACE); }
    "<"				{ return symbol(sym.LESS); }
    ">"				{ return symbol(sym.GREATER); }
    "¡="			{ return symbol(sym.DIF); }
    "||"			{ return symbol(sym.OR); }
    "&&"			{ return symbol(sym.AND); }

    {Id}			{ return symbol(sym.ID, new String(yytext())); }
    {Literal}		{ return symbol(sym.LITERAL, new String(yytext())); }
    {Integer}		{ return symbol(sym.INTEGER, new String(yytext())); }
    {Boolean}		{ return symbol(sym.BOOLEAN, new String(yytext())); }
    .				{ noCharacterError(yytext()); }
}




