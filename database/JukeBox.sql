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
alter table narrator
auto_increment = 1001;
insert into narrator(narName) values("Taylor");select last_insert_id();
insert into narrator(narName) values("Valmiki");select last_insert_id();

select * from narrator;


create table ProdType(
ptId int auto_increment primary key,
typeName char(30)
);
alter table prodtype
auto_increment =2001;

insert into prodtype(typeName) values("sanskriti");select last_insert_id();
select * from prodtype;

create table Celebrity(
celbId int auto_increment primary key,
celbName char(30)
);
alter table celebrity
auto_increment = 3001;

insert into celebrity(celbName) values ("Amitabh");select last_insert_id();
select * from celebrity;

create table Prodcast(
podId int auto_increment primary key,
podName char(30),
ptId int,
narId int,
celbId int,
foreign key (ptId) references ProdType(ptId) on update cascade on delete set null,
foreign key (narId) references Narrator(narId) on update cascade on delete set null,
foreign key (celbId) references Celebrity(celbId) on update cascade on delete set null
);

alter table prodcast
auto_increment = 4001;

insert into prodcast(podName,ptId,narId,celbId) values("Story",2001,1002,3001);select last_insert_id();

select * from prodcast;

create table ProdEpisode(
prodEId int auto_increment primary key,
epiNo int,
epiName char(30),
timeDuration varchar(30),
publishedDate date, 
podId int,
foreign key (podId) references Prodcast(podId) on update cascade on delete set null
);

insert into prodEpisode(epiNo,epiName,timeDuration,publishedDate,podId) values(2,"Valmiki start","01:45:30",'2021-04-15',4001);select last_insert_id();

alter table ProdEpisode
auto_increment = 11000;

select * from ProdEpisode;

create view prodEpiData as 
select prodep.prodEId,prodep.epiNo,prodep.epiName,prodep.timeDuration,
pc.podName,celb.celbName,prodep.publishedDate,n.narName,p.typeName from ProdEpisode prodep 
inner join prodcast pc on prodep.podId=pc.podId inner join celebrity celb on pc.celbId=celb.celbId
inner join narrator n on pc.narId=n.narId inner join prodType p on pc.ptId=p.ptId;

select * from prodEpiData;

-- task3
create table Playlist(
playId int auto_increment primary key,
playName varchar(50)
);
alter table playlist auto_increment = 31000;
insert into playlist(playName) values("10 most played"),("Workout Music");
select * from playlist;

create table Playlistcontent(
contId int auto_increment primary key,
playId int,
listDuration varchar(15),
trackId int,
foreign key (playId) references playlist(playId) on update cascade on delete set null
-- foreign key (trackId) references song(sId) on update cascade on delete set null,
-- foreign key (trackId) references ProdEpisode(prodEId) on update cascade on delete set null
);
drop table playlistcontent;

insert into playlistcontent(playId,listDuration,trackId) values(31000,"00:14:27",403);
insert into playlistcontent(playId,listDuration,trackId) values(31000,"00:14:27",11003);

select * from song;
select * from ProdEpisode;
select * from Playlistcontent;


-- view table for playlist
create view playlistcontdata as 
select pl.playName,plc.listDuration,so.sName,so.timeDuration,pe.epiName,pe.timeDuration from playlistcontent plc 
join playlist pl on plc.playId=pl.playId join song so on so.sId=plc.trackId
join prodEpisode pe on pe.prodEId=plc.trackId;

select * from playlistcontdata;