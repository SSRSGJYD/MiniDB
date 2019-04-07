grammar MiniSQL;

TABLENAME : [a-z]+ ;
ATTRNAME : [a-z]+ ;
TYPE : 'int'
     | 'long'
     | 'float'
     | 'double'
     | 'string' 
     ;

WS: [ \t\r\n]+ -> skip;

sql : 'create table' TABLENAME '(' schema ')' #create
    ;

schema : attribute //',' schema #attrs
      // | attribute #attrs
       ;

attribute : ATTRNAME ' ' TYPE #normalattr
    //      | ATTRNAME TYPE 'not null' #notnullattr
          ;

constraint :'primary key' '(' ATTRNAME ')'#primarykey;

