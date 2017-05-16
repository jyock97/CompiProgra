package proyectocompi;
import java_cup.runtime.*;

%%

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
%}

Whitespace      = [ \t\n]
Digit           = [0-9]
Integer         = {Digit}+
Word            = [a-zA-Z]
Id              = {Word} ({Word}|{Digit})*
Boolean         = [false | true] 

%%

<YYINITIAL> { 
    {Id}             { return symbol(sym.ID, new String(yytext())); }
    {Integer}        { return symbol(sym.INTEGER, new Integer(yytext())); }
    {Boolean}        { return symbol(sym.BOOLEAN, new Boolean(yytext()));}
    "main"           { return symbol(sym.MAIN); }
    "if"             { return symbol(sym.IF); }
    "else"           { return symbol(sym.ELSE); }
    "while"          { return symbol(sym.WHILE); }
    "break"          { return symbol(sym.BREAK); }
    "int"            { return symbol(sym.INT); }
    "puts"           { return symbol(sym.PUTS; }
    "putw"           { return symbol(sym.PUTW); }
    "+"              { return symbol(sym.ADD); }
    "-"              { return symbol(sym.MINUS); }
    "*"              { return symbol(sym.TIMES); }
    "/"              { return symbol(sym.DIV); }
    "("              { return symbol(sym.LPAREN); }
    ")"              { return symbol(sym.RPAREN); }
    ";"              { return symbol(sym.SEMICOLON); }
    "=="             { return symbol(sym.EQUALS); }
    "{"              { return symbol(sym.LLLAVE); }
    "}"              { return symbol(sym.RLLAVE); }
    "<"              { return symbol(sym.MENOR); }
    ">"              { return symbol(sym.MAYOR); }
    "¡="             { return symbol(sym.DIF); }
    "||"             { return symbol(sym.OR); }
    "&&"             { return symbol(sym.AND); }

    {Whitespace} {}
}

//.|\n            { throw new Error("El caracter no se reconocio <" + yytext() + ">");}

