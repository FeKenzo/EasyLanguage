grammar EasyLanguage;

@header {
package br.edu.cefsa.faculdade.parser;
}

// ========================
//  REGRAS DO PARSER
// ========================
programa
    : PROGRAMA ABRE_CHAVE decls comandos FECHA_CHAVE EOF
    ;

decls
    : (declaracao PONTO_VIRGULA)*
    ;

declaracao
    : tipo ID (VIRGULA ID)*
    ;

comandos
    : (cmd PONTO_VIRGULA)*
    ;

cmd
    : cmdLeitura
    | cmdEscrita
    | cmdAtribuicao
    | cmdSe
    | cmdEnquanto
    | cmdPara
    ;

// --- Comandos da linguagem ---
cmdLeitura     : LEIA ABRE_PAR ID FECHA_PAR ;
cmdEscrita     : ESCREVA ABRE_PAR expressao FECHA_PAR ;
cmdAtribuicao  : ID ATRIBUICAO expressao ;
cmdSe          : SE ABRE_PAR expressao FECHA_PAR ENTAO bloco (SENAO bloco)? ;
cmdEnquanto    : ENQUANTO ABRE_PAR expressao FECHA_PAR FACA bloco ;
cmdPara        : PARA ID DE expressao ATE expressao PASSO expressao FACA bloco ;

bloco          : ABRE_CHAVE comandos FECHA_CHAVE ;

// --- Expressões ---
expressao : termo (opRel termo)? ;
termo     : fator (opArit fator)* ;
fator     : ID | NUM | STRING | BOOL | ABRE_PAR expressao FECHA_PAR ;

opArit : MAIS | MENOS | MULT | DIV | MOD ;
opRel  : MAIOR | MENOR | MAIOR_IGUAL | MENOR_IGUAL | IGUAL | DIFERENTE ;

// --- Tipos ---
tipo  : INTEIRO | BOOLEANO | TEXTO ;

// ========================
//  TOKENS DO LÉXER
// ========================

// Palavras-chave
PROGRAMA   : 'programa' ;
LEIA       : 'leia' ;
ESCREVA    : 'escreva' ;
SE         : 'se' ;
ENTAO      : 'entao' ;
SENAO      : 'senao' ;
ENQUANTO   : 'enquanto' ;
FACA       : 'faca' ;
PARA       : 'para' ;
DE         : 'de' ;
ATE        : 'ate' ;
PASSO      : 'passo' ;
INTEIRO    : 'inteiro' ;
BOOLEANO   : 'booleano' ;
TEXTO      : 'texto' ;
BOOL       : 'verdadeiro' | 'falso' ;

// Operadores e símbolos
ATRIBUICAO   : '=' ;
MAIOR        : '>' ;
MENOR        : '<' ;
MAIOR_IGUAL  : '>=' ;
MENOR_IGUAL  : '<=' ;
IGUAL        : '==' ;
DIFERENTE    : '!=' ;
MAIS         : '+' ;
MENOS        : '-' ;
MULT         : '*' ;
DIV          : '/' ;
MOD          : '%' ;
ABRE_PAR     : '(' ;
FECHA_PAR    : ')' ;
ABRE_CHAVE   : '{' ;
FECHA_CHAVE  : '}' ;
VIRGULA      : ',' ;
PONTO_VIRGULA: ';' ;

// Tipos primitivos
NUM    : [0-9]+ ;
STRING : '"' (~["\r\n])* '"' ;
ID     : [a-zA-Z_] [a-zA-Z0-9_]* ;

// Ignorar espaços e comentários
WS      : [ \t\r\n]+ -> skip ;
COMMENT : '//' ~[\r\n]* -> skip ;
