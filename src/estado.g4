
grammar estado;

file
    : (state | fun)* EOF
    ;

state
    : 'state' ID '{' (state | fun | handler)* '}'
    ;

fun
    : 'fun' ID '(' ')' '{' '}'
    ;

handler
    : 'on' ID
    ;

NATURAL : ('0'..'9')+ ;

TEXT
    :  '"' ( EscapeSequence | ~('\\'|'"') )* '"'
    ;

fragment
EscapeSequence
    : '\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\\')
    | HexEscape
    | UnicodeEscape
    ;

fragment
HexDigit : ('0'..'9'|'a'..'f'|'A'..'F') ;

fragment
HexEscape : '\\' 'x' HexDigit HexDigit ;

fragment
UnicodeEscape
    : '\\' 'u' HexDigit HexDigit HexDigit HexDigit
    | '\\' 'u' HexDigit HexDigit HexDigit HexDigit HexDigit HexDigit HexDigit HexDigit
    ;

ID
    : ('_'|'a'..'z'|'A'..'Z') ('_'|'0'..'9'|'a'..'z'|'A'..'Z')*
    | '`' ~('`')+ '`'
    ;

WHITESPACE : (' '|'\t'|'\u000C'|'\n'|'\r') -> skip ;
COMMENT : '//' ~('\n'|'\r')* '\r'? '\n' -> skip ;