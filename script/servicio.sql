#conexion SSH
conexion :: ssh grupo06sc@tecnoweb.org.bo
password :: grup006grup006

#conexion bd
psql db_grupo06sc grupo06sc

#listar tablas
\dt

#crear tabla
create table servicio(
	id SERIAL primary key,
	nombre varchar(50),
    precio real,
    id_equipamiento integer,
    id_paquete integer
    foreign key(id_equipamiento) references equipamiento(id)
        ON UPDATE CASCADE,
    foreign key(id_paquete) references paquete(id)
        ON UPDATE CASCADE,
);

#eliminar tabla
drop table if exists servicio

#insertar datos
INSERT into servicio values(NULL, "Servicio1", 50.0, 1,1)


#consulta
select * from servicio