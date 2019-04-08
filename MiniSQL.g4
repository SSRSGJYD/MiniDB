grammar MiniSQL;

String : [a-z]+ ;


type : 'int'
     | 'long'
     | 'float'
     | 'double'
     | 'string' 
     ;

WS: [ \t\r\n]+ -> skip;

sql : 'create table' String '(' schema ')' #create
    | 'drop table' String #drop
    ;

schema : (attribute|constraint) (',' (attribute|constraint))* #attrcons
       ;

attribute : String type #normalattr
          | String type 'not null' #notnullattr
          ;

constraint :'primary key' '(' String ')'#primarykey;

