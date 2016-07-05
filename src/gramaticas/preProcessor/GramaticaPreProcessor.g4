grammar GramaticaPreProcessor;

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

periodo : (.)*?;