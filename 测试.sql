create database db;
use database db;
create table avengers
	(id			int not null, 
	 name			char(32) not null, 
	 power	int not null,
	 weight     float,
	 primary key (ID)
	);


drop table avengers;

create table avengers
	(id			int not null, 
	 name			char(32) not null, 
	 power	int not null,
	 weight     float,
	 height     double,
	 primary key (ID)
	);

create user un password pw;
grant select on avengers to un;

INSERT INTO avengers VALUES (10, 'Captain', 50, 78.1, 1.85);
INSERT INTO avengers VALUES (3, 'Thor', 90, 92.1, 1.89);
INSERT INTO avengers VALUES (7, 'IronMan', 85, 82.1, 1.76);
INSERT INTO avengers VALUES (4, 'rocket', 40, 42.1, 0.76);
INSERT INTO avengers VALUES (5, 'Groot', 10, 182.1, 2.76);

DELETE FROM avengers WHERE name = 'Groot';

UPDATE avengers SET power = 100 WHERE name = 'Captain';

create table villain
	(id			int not null, 
	 name			char(32) not null, 
	 power	int not null,
	 primary key (ID)
	);

INSERT INTO villain VALUES (1, 'Thanos', 100);
INSERT INTO villain VALUES (2, 'Red Skull', 40);
INSERT INTO villain VALUES (3, 'Hella', 90);
INSERT INTO villain VALUES (4, 'monster', 10);

create user un password pw;
grant select on avengers to un;

select avengers.name, villain.name, villain.power from avengers join villain on avengers.power = villain.power where villain.power > 40;

select * from avengers;

select id, name from avengers where id = 4;