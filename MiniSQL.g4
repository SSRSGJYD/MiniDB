grammar MiniSQL;

Number : [0-9]+ ;
Name : [0-9a-z_]+ ;
String : '\'' (.)+? '\''
	;
NEWLINE:'\r'?'\n'
     |EOF;
   

type : 'int'
     | 'long'
     | 'float'
     | 'double'
     | 'char' '(' Number ')' 
     ;

op : '='|'>'|'<'|'>='|'<='|'<>';

value : Number
      | String
      | 'null'
	;

WS: [ \t\r\n]+ -> skip;

sql : 'create table' Name '(' schema ')' #create
    | 'drop table' Name #drop
    | 'insert into' Name 'values' '(' values ')' #insertA
    | 'insert into' Name '(' names ')' 'values' '(' values ')' #insertB
    | 'delete from' Name 'where' condition #delete
    | 'update' Name 'set' set 'where' condition #update
    | 'select' (cnames|'*') 'from' jnames  ('where' ccondition)? #selectB
    | 'select' (names|'*') 'from' Name ('where' condition)? #selectA
    | 'create database' Name #createdb
    | 'drop database' Name #dropdb
    | 'use database' Name #usedb
    | 'show databases' #show
    | 'show database' Name #showdb
    | NEWLINE #newline
    ;
    

ccondition : cname op (value|cname)
	;

condition : Name op (value|Name)
	;
	
set : Name '=' value
	;

names : Name (',' Name)* 
	;
cname: Name'.'Name
	;
cnames : cname (',' cname)*
	;
onCondition : cname'='cname
	;
	
jnames : Name ('join' Name 'on' onCondition)+
	;

values : value (',' value)*
	;

schema : (attribute|constraint) (',' (attribute|constraint))* #attrcons
       ;

attribute : Name type #normalattr
          | Name type 'not null' #notnullattr
          ;

constraint :'primary key' '(' Name ')'#primarykey;

