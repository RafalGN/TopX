grammar SentiLexPTParser;


WS  :   ( '\t' | '\r') {skip();};

POS: 'PoS';

CLASSE: 'Adj'
      | 'N'
      | 'V'
      | 'IDIOM'
      ;

ALVO: 'TG';

HUM: 'HUM';
TIPON: 'N0'
     | 'N1'
     ;

POL: 'POL';

ANOT: 'ANOT';
ANOTADOR: 'MAN'
        | 'JALC'
        ;
REV: 'REV=AMB'
   | 'REV:POL';

POLARIDADE: '1'
          | '-1'
          | '0'
          ;

QL : '\n';
PV : ';' ;
EQ : '=';
DP : ':';
PONTO: '.';

fragment
LetrasAcentuadas :'á'|'à'|'â'|'ã'|'é'|'ê'|'í'|'ó'|'ô'|'õ'|'ú'|'ü'|'ç'|'À'|'Á'|'Â'|'Ã'|'É'|'Ê'|'Í'|'Ó'|'Ô'|'Õ'|'Ú'|'Ü'|'Ç'|'-';

PALAVRA :	('a'..'z'|'A'..'Z'|LetrasAcentuadas)+ ;

init: (linha QL)+;

linha: (bloco PV)+ bloco
     ;

bloco: PALAVRA+ PONTO POS EQ CLASSE # PalavraEPoS
     | ALVO EQ (HUM (DP TIPON)+)    # Alvo
     | blocoPol (PV blocoPol)?      # Pol
     | ANOT EQ ANOTADOR             # Anot
     | REV?                         # Rev
     ;

blocoPol: POL DP TIPON EQ POLARIDADE
        ;