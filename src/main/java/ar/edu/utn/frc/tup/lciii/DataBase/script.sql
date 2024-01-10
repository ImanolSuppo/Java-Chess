create database Ajedrez
use Ajedrez

drop database Ajedrez

create table jugadores(
                          id_jugador int AUTO_INCREMENT,
                          nombre varchar(50),
                          primary key (id_jugador)
)

create table juegos(
                       id_juego int AUTO_INCREMENT,
                       id_jugador_1 int,
                       id_jugador_2 int,
                       primary key(id_juego),
                       foreign key(id_jugador_1) references jugadores(id_jugador),
                       foreign key(id_jugador_2) references jugadores(id_jugador)
)

create table tiles(
                      id_tile int auto_increment,
                      id_juego int,
                      tileX int,
                      tileY int,
                      namePart varchar(5),
                      typePart varchar(20),
                      primary key(id_tile),
                      foreign key(id_juego) references juegos(id_juego)
)

create table historicalMovements(
                                    id_historicalMovement int auto_increment,
                                    historicalMovement varchar(10000),
                                    id_juego int,
                                    primary key(id_historicalMovement),
                                    foreign key(id_juego) references juegos(id_juego)
)

select * from jugadores
select id_jugador from jugadores where nombre = 'GUILLERMO'
select * from juegos

    insert into jugadores(nombre) values('Nico')
insert into jugadores(nombre) values('Zeke')
insert into jugadores(nombre) values('Guille')
insert into jugadores(nombre) values('Imanol')

insert into juegos(id_jugador_1,id_jugador_2)
values(1,2)
insert into juegos(id_jugador_1,id_jugador_2)
values(3,4)

select * from jugadores
select * from juegos
select * from tiles
select * from historicalMovements where id_juego =


select j.id_juego, j1.nombre as playerOne, j2.nombre as playerTwo from juegos j inner join jugadores j1 on j.id_jugador_1 = j1.id_jugador inner join jugadores j2 on j.id_jugador_2 = j2.id_jugador where j1.nombre = 'Nico' and j2.nombre = 'Zeke'

select id_tile from tiles where id_juego = 1 and id_tile = 1

select j1.nombre as PlayerOne, j2.nombre as PlayerTwo, tileX, tileY, namePart, typePart from tiles t inner join juegos j on t.id_juego = j.id_juego inner join jugadores j1 on j1.id_jugador = j.id_jugador_1 inner join jugadores j2 on j2.id_jugador = j.id_jugador_2  where t.id_juego = 1

update tiles set tileX = ?, tileY = ?, namePart = ?, typePart = ? where id_juego = ? and id_tile = ?