#conexion SSH
conexion :: ssh grupo06sc@tecnoweb.org.bo
password :: grup006grup006

#conexion bd
psql db_grupo06sc grupo06sc

#listar tablas
\dt

#crear tabla
create table paquete(
	id SERIAL primary key,
	nombre varchar(50),
    cantidad integer,
    precio real,
);

#eliminar tabla
drop table if exists paquete

#insertar datos
INSERT into paquete values(NULL, "Paquete1", 4, 200.0)


#consulta
select * from paquete