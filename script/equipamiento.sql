#conexion SSH
conexion :: ssh grupo06sc@tecnoweb.org.bo
password :: grup006grup006

#conexion bd
psql db_grupo06sc grupo06sc

#listar tablas
\dt

#crear tabla
create table equipamiento(
	id SERIAL primary key,
    codigo varchar(15) not null unique,
	nombre varchar(50),
    id_local integer,
    foreign key(id_local) references local(id)
        ON UPDATE CASCADE
);

#eliminar tabla
drop table if exists equipamiento

#insertar datos
INSERT into equipamiento values(NULL, "COD01", "Equipo1", 1)


#consulta
select * from equipamiento