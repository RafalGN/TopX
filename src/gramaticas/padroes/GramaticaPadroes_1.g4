grammar GramaticaPadroes_1;

tokens {
    ART,ADJ,SUBS,VERB,PREP,PRON,CONJ,ADV,NUM,FABRICANTE
}


WS  :   ( ' ' | '\t' | '\r' | '\n') {skip();};

fragment
LetrasAcentuadas :'á'|'à'|'â'|'ã'|'é'|'ê'|'í'|'ó'|'ô'|'õ'|'ú'|'ü'|'ç'|'À'|'Á'|'Â'|'Ã'|'É'|'Ê'|'Í'|'Ó'|'Ô'|'Õ'|'Ú'|'Ü'|'Ç'|'-';

PALAVRA :	('a'..'z'|'A'..'Z'|LetrasAcentuadas)+ ;

INTS 	:	'0'..'9'+ ('.' '0'..'9'+)? ;

SIMBOLOS 	:	'='|'+'|'*'|'/'|'\\'|'&'|'%'|'$'|'#'|'@'|'['|']'|'('|')'|'{'|'}'|'_'|':'|'<'|'>'|'"'|'\''|'´'|'`';

TERMINAL : '.'|'?'|'!'|';';
VIRGULA : ',';

MODELO: (('a'..'z'|'A'..'Z') '0'..'9')+
      ;

NAO : 'não';

periodo : (padroes)*;

padroes : pattern1
        | pattern2
        | pattern3
        | pattern4
        | pattern5
        | pattern6
        | pattern7
        | .
       ;

pattern1: ADJ SUBS (PREP? SUBS)*;

pattern2: ADV (ADJ|ADV) (SUBS (PREP? SUBS)*)?;

pattern3: SUBS (PREP? SUBS)* (ADJ)+ ADV?;

pattern4: SUBS (PREP? SUBS)* (ADV)? ADJ+ ;

pattern5: ADV VERB;

pattern6: VERB ADV;

pattern7: VERB SUBS;


produtoComposto returns [String produto]: SUBS (PREP? SUBS)*
               ;