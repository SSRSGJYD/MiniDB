create database db
use database db
create table play(id int,name int, primary key(id))
insert into play values(1,1)
insert into play values(2,2)
insert into play values(3,3)
insert into play values(4,4)
insert into play values(5,5)
insert into play values(6,6)
insert into play values(7,7)
insert into play values(8,8)
insert into play values(9,9)
insert into play values(10,10)
delete from play where name=1
delete from play where name=3
delete from play where name=5
delete from play where name=7
delete from play where name=9
select * from play
drop table play
