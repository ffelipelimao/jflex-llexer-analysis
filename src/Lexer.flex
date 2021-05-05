/* Pacote para o Analisador Léxico */
import static codigo.Tokens.*;
%%
%class Lexer  /* Classe a ser criada com o  mesmo nome do arquivo vazio  */
%type codigo.Tokens  /* Definição  dos tokens como uma expressão regular */
L=[a-zA-Z]+   /* Conjunto de uma ou mais  Letras */
D=[0-9]+      /* Conjunto de um ou  mais dígitos */
ESPACO=[ ,\t,\r,\n]+  /* Conjunto de caracteres "espaço", "tabulação", "retorno de carro" e "pula linha" */
%{
    public String lexema;
%}
%%
/* Definição  das palavras Reservadas  - Colocar aqui todas as palavras reservadas */
int |
print |
read |
class |
for {lexema=yytext(); return RESERVADA;}
{ESPACO} {/*Ignore*/}    /* Definição de espaço para ignorar */
"//".* {/*Ignore*/}      /* Definição de comentários na mesma linha */
"+" {return SOMA;}       /* Definição de operadores - colocar todos os operadores */
"=" {return ATRIBUICAO;}   /* Definição  de atribuição */
"==" {return IGUAL;}       /* Definição de operadores relacionais - colocar todos relacionais */
";" {return PONTO_E_VIRGULA;}  /* Definição de término de comando */
"(" {return ABRE_PARENTESES;}  /* Definição de separadores - colocar todos os separadores*/
")" {return FECHA_PARENTESES;}
"{" {return ABRE_CHAVES;}
"}" {return FECHA_CHAVES;}
"!=" {return DIFERENTE;}
"," {return VIRGULA;}
{L}({L}|{D})* {lexema=yytext(); return IDENTIFICADOR;}   /* Definição de Identificador */
{D}+ {lexema=yytext(); return INT_CONSTANTE;}            /* Definição de inteiros */
("'".*"'" |"\"".*"\"") {lexema=yytext(); return STRING_CONSTANTE;}  /* Definição de cadeia de caracteres (strings) */
 . {return ERROR;}    /* Caso nenhum dos tokens elexemas acima, erro */