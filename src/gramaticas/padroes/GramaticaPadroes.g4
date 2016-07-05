grammar GramaticaPadroes;

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

padroes : padrao1
        | padrao2
        | padrao3
        | padrao4
        | padrao5
        | padrao6
     //   | padrao7
        | .
       ;

padrao1: ADJ produtoComposto
       ;

padrao2: ADV ADV? ADJ produtoComposto?
       ;

padrao3: produtoComposto ADJ ADV ADV?
       ;

padrao4: produtoComposto (ADV)? ADJ+
       ;

padrao5: ADV VERB
       ;

padrao6: VERB ADV
       ;

//padrao7: VERB produtoComposto
//       ;


produtoComposto returns [String produto]: SUBS (PREP? SUBS)*
               ;