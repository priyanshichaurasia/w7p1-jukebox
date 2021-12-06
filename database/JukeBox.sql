create database JukeBox;
use jukebox;

create table Genere(
gId int auto_increment primary key,
gName char(30) not null
);

create table Album(
albId int auto_increment primary key,
albName char(40),
releaseDate date
);

create table Artist(
artId int auto_increment primary key,
artName char(30) unique key not null,
gender char(10)
);

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

create view songdata as select s.sId, s.sName, s.timeDuration, art.artName, alb.albName, g.gName 
from Song s inner join Artist art on s.artId = art.artId inner join Album alb on s.albId = alb.albId
inner join genere g on g.gId = s.gId;