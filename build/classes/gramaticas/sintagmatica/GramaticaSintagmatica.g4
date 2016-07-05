grammar GramaticaSintagmatica;

tokens {
    ART,ADJ,SUBS,VERB,PREP,PRON,CONJ,ADV,NUM,FABRICANTE
}


WS  :   ( ' ' | '\t' | '\r' | '\n') {skip();} ;

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

periodo :(oracao | . )*?
        ;

oracao : sn_suj? nao_opc? sv sp_opc?
       | sp VIRGULA sn_suj? nao_opc? sv sp_opc?
       ;

nao_opc: NAO
       ;

sn_opc : sn
       ;

sn : SUBS
   | det sa_opc? SUBS mod?
   ;

sn_suj : ( SUBS (PREP? SUBS)* | PRON )
       | det sa_opc? SUBS (PREP? SUBS)* mod?
       ;

det : pre_det? det_base pos_det?
    ;

pre_det:
       ;

det_base: ART
        | PRON
        | NUM
        ;

pos_det: NUM
       | PRON
       ;

mod : sa?
    | sp
    ;

sp_opc : sp
       ;

sp : PREP sn
   | ADV sp_opc?
   ;

sa_opc : sa?
       ;

sa : intens? ADJ ((CONJ | VIRGULA)? ADJ)* sp_opc?
   ;

intens : ADV
       ;

sv : VERB complemento
   ;

complemento : sa_opc? sn_opc? sp_opc?
            ;