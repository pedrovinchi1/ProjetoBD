create database trabalho

create table processador( 
	
	marca varchar(20),
	modelo varchar(20),
	quantidade integer

)
create table fonte( 
	
	marca varchar(20),
	modelo varchar(20),
	quantidade integer

)
create table Placamae( 
	
	marca varchar(20),
	modelo varchar(20),
	quantidade integer

)
create table fone( 
	
	marca varchar(20),
	modelo varchar(20),
	quantidade integer

)
create table monitor( 
	
	marca varchar(20),
	modelo varchar(20),
	quantidade integer

)
create table mouse( 
	
	marca varchar(20),
	modelo varchar(20),
	quantidade integer

)
create table mesa( 
	
	marca varchar(20),
	modelo varchar(20),
	quantidade integer

)
create table cadeira( 
	
	marca varchar(20),
	modelo varchar(20),
	quantidade integer

)
insert into processador(marca,modelo,quantidade) values('intel','i9','10');
insert into processador(marca,modelo,quantidade) values('intel','i7','5');
insert into processador(marca,modelo,quantidade) values('intel','i3','2');
insert into processador(marca,modelo,quantidade) values('intel','pentium','4');
insert into processador(marca,modelo,quantidade) values('amd','ryzen5','10');

insert into Placamae(marca,modelo,quantidade) values('gigabyte','1151','000001');
insert into Placamae(marca,modelo,quantidade) values('gigabyte','1151','59');
insert into Placamae(marca,modelo,quantidade) values('asus','1151','23456789');
insert into Placamae(marca,modelo,quantidade) values('asus','1151','2');
insert into Placamae(marca,modelo,quantidade) values('asus','1151','10');

insert into fonte(marca,modelo,quantidade) values('msi','200w','10');
insert into fonte(marca,modelo,quantidade) values('atx','300w','9');
insert into fonte(marca,modelo,quantidade) values('atx','400w','4');
insert into fonte(marca,modelo,quantidade) values('msi','500w','2');
insert into fonte(marca,modelo,quantidade) values('msi','600w','20000');

insert into monitor(marca,modelo,quantidade) values('samsung','curved','10');
insert into monitor(marca,modelo,quantidade) values('aoc','abcd','57');
insert into monitor(marca,modelo,quantidade) values('dell','123','18');
insert into monitor(marca,modelo,quantidade) values('msi','a1b2c3','34');
insert into monitor(marca,modelo,quantidade) values('msi','12563','102');

insert into mouse(marca,modelo,quantidade) values('logitech','g10','19');
insert into mouse(marca,modelo,quantidade) values('alienware','modelo1','75');
insert into mouse(marca,modelo,quantidade) values('dell','123','18');
insert into mouse(marca,modelo,quantidade) values('msi','a1b2c3','34');
insert into mouse(marca,modelo,quantidade) values('hyperx','12563','102');

insert into fone(marca,modelo,quantidade) values('logitech','g600','12');
insert into fone(marca,modelo,quantidade) values('alienware','','1');
insert into fone(marca,modelo,quantidade) values('dell','','18');
insert into fone(marca,modelo,quantidade) values('','a1b2c3','34');
insert into fone(marca,modelo,quantidade) values('','',null);

insert into cadeira(marca,modelo,quantidade) values('top seat','ergonomica','49');
insert into cadeira(marca,modelo,quantidade) values('dt3','gamer','23');
insert into cadeira(marca,modelo,quantidade) values('dt3','escritorio','180');
insert into cadeira(marca,modelo,quantidade) values('comfy','ergonomica','39');
insert into cadeira(marca,modelo,quantidade) values('comfy','gamer','0');

insert into mesa(marca,modelo,quantidade) values('','escritorio','52');
insert into mesa(marca,modelo,quantidade) values('','gamer','36');
insert into mesa(marca,modelo,quantidade) values('','gamer','14');
insert into mesa(marca,modelo,quantidade) values('','escrivaninha','22');
insert into mesa(marca,modelo,quantidade) values('','escritorio','122');


select * from cadeira



