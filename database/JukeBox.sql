create database JukeBox;
use jukebox;

-- task1
create table Genere(
gId int auto_increment primary key,
gName char(30) not null
);

alter table genere
auto_increment = 101;

insert into genere(gName) values("Rock");select last_insert_id();
insert into genere(gName) values("pop");select last_insert_id();

select * from genere;

create table Album(
albId int auto_increment primary key,
albName char(40),
releaseDate date
);

alter table album
auto_increment = 201;

insert into album(albName,releaseDate) values ("Revolution",'2020-10-05');select last_insert_id();
insert into album(albName,releaseDate) values ("perfect", '2017-05-06');select last_insert_id();

select * from album;

create table Artist(
artId int auto_increment primary key,
artName char(30) unique key not null,
gender char(10)
);

alter table artist
auto_increment = 301;

insert into Artist(artName,gender) values("A.R.Rahman", "M");select last_insert_id();
insert into Artist(artName,gender) values("Ed Sheeran", "M");select last_insert_id();

select * from artist;

create table Song(
sId int auto_increment primary key,
sName char(40),
timeDuration varchar(30),
artId int,
albId int,
gId int,
foreign key (artId) references Artist(artId) on update cascade on delete set null,
foreign key (albId) references Album(albId) on update cascade on delete set null,
foreign key (gId) references Genere(gId) on update cascade on delete set null
);

alter table song
auto_increment = 401;

insert into song(sName,timeDuration,artId,albId,gId) values("vande mataram","00:04:30",301,201,101);select last_insert_id();
insert into song(sName,timeDuration,artId,albId,gId) values("pefect","00:03:40",302,202,102);select last_insert_id();

select * from song;

create view songdata1 as select s.sId, s.sName, s.timeDuration, art.artName, alb.albName, g.gName
from Song s inner join Artist art on s.artId = art.artId inner join Album alb on s.albId = alb.albId
inner join genere g on g.gId = s.gId;

select * from songdata1;

-- task2
create table Narrator(
narId int auto_increment primary key,
narName char(30)
);

create table ProdType(
pId int auto_increment primary key,
typeName char(30)
);
