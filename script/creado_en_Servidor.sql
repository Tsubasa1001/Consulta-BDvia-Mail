#crear tabla
create table paquete(
	id SERIAL primary key,
	nombre varchar(50),
    cantidad integer,
    precio real
);

#eliminar tabla
drop table if exists paquete

#insertar datos
INSERT into paquete values(default, 'Paquete1', 4, 200.0);
INSERT into paquete values(default, 'Paquete2', 3, 20.50);


#consulta
select * from paquete

CREATE TABLE trabajador(
	id SERIAL primary key,
	codigo varchar(15),
	ci varchar(10) NOT NULL,
	nombre varchar(150) NOT NULL,
	nacionalidad varchar(100) NOT NULL,
	especialidad varchar(50) NOT NULL,
	cargo varchar(50) NOT NULL,
	ocupacion varchar(50) NOT NULL,
	direccion varchar(50) NOT NULL,
	email varchar(50) UNIQUE NOT NULL,
	celular varchar(8) NOT NULL,
	edad int NOT NULL,
	genero char(1) NOT NULL
);

#eliminar tabla
drop table if exists trabajador;

#insertar datos
INSERT INTO trabajador VALUES (default,'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 1, 'M');
INSERT INTO trabajador VALUES (default,'b', 'b', 'a', 'a', 'a', 'a', 'a', 'a', 'b', 'a', 1, 'F');

#consulta
select * from trabajador;


CREATE TABLE paciente(
	id SERIAL primary key,
	codigo varchar(15),
	ci varchar(10) NOT NULL,
	nombre varchar(150) NOT NULL,
	nacionalidad varchar(100) NOT NULL,
	ocupacion varchar(50) NOT NULL,
	direccion varchar(50) NOT NULL,
	email varchar(50) UNIQUE NOT NULL,
	celular varchar(8) NOT NULL,
	edad int NOT NULL,
	genero char(1) NOT NULL
);


#eliminar tabla
drop table if exists paciente;

#insertar datos
INSERT INTO paciente VALUES ( default,'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 1, 'M');
INSERT INTO paciente VALUES (default,'b', 'b', 'a', 'a', 'a', 'a', 'b', 'a', 1, 'F');


select * from paciente

create table local(
	id SERIAL primary key,
	nombre varchar(50),
    ciudad varchar(20),
    direccion varchar(20)
);

#eliminar tabla
drop table if exists local

#insertar datos
INSERT into local values(default, 'Nombre1', 'Ciudad1','Direccion1');
select * from local

create table equipamiento(
	id SERIAL primary key,
    codigo varchar(15),
	nombre varchar(50),
    id_local integer,
    foreign key(id_local) references local(id)
        ON UPDATE CASCADE
);
#eliminar tabla
drop table if exists equipamiento

#insertar datos
INSERT into equipamiento values(default, 'COD01', 'Equipo1', 1);

#consulta
select * from equipamiento

create table servicio(
	id SERIAL primary key,
	nombre varchar(50),
    precio real,
    id_equipamiento integer,
    id_paquete integer,
	foreign key(id_equipamiento) references equipamiento(id)
        ON UPDATE CASCADE,
    foreign key(id_paquete) references paquete(id)
        ON UPDATE CASCADE
);

#eliminar tabla
drop table if exists servicio

#insertar datos
INSERT into servicio values(default, 'Servicio1', 50.0, 1,1);


#consulta
select * from servicio

create table citaConsulta(
	id SERIAL,
	id_paciente integer,
	id_trabajador integer,
	codigo varchar(15)NOT NULL,
	hora time NOT NULL,
	fecha date NOT NULL,
	motivoConsulta varchar(255)NOT NULL,
	estadoTratamiento varchar(255)NOT NULL,
	
	primary key (id),
	foreign key (id_paciente)references paciente(id),
	foreign key (id_trabajador) references trabajador(id)
	ON UPDATE CASCADE
);

#eliminar tabla
drop table if exists citaConsulta;

#insertar datos
INSERT INTO citaConsulta values (default,1,1,'FC0001','02:30:00','2021-08-15','dolor de espalda','iniciando');

#consulta
select * from citaConsulta;

#crear tabla

create table consulta(  
	id SERIAL,
	id_citaConsulta integer,
	id_servicio integer,
	codigo varchar(50),
	horaEntrada time,
	horaSalida time,
	fecha date,
	precio real,
	notas varchar(255),
	diagnosticoFinal varchar(255),
	primary key(id,id_citaConsulta,id_servicio),
	foreign key (id_citaConsulta)references citaConsulta(id),
	foreign key (id_servicio) references servicio(id)
	ON UPDATE CASCADE
);

#eliminar tabla
drop table if exists consulta;

#insertar datos
INSERT INTO consulta VALUES (default, 1, 1, 'CON001', '04:00:00', '04:20:00', '2001-10-05', 200.0, 'ninguno', 'No se presentan anomalias');

#consulta
select * from consulta


#usuario
CREATE TABLE usuario(
	codigo serial	    PRIMARY KEY,
	ci char(10)         UNIQUE NOT NULL,
	nombre char(150)    NOT NULL,
	nacionalidad char(100)  NOT NULL,
	especialidad char(50)   NOT NULL,
	direccion char(50)      NOT NULL,
	email char(50)          UNIQUE NOT NULL,
	celular char(8)     NOT NULL,
	edad int            NOT NULL,
	genero char(1)      NOT NULL,
	fecha_creacion date NOT NULL
);

