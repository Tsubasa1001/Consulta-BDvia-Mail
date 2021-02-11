#conexion SSH
conexion :: ssh grupo06sc@tecnoweb.org.bo
password :: grup006grup006

#conexion bd
psql db_grupo06sc grupo06sc

#listar tablas
\dt

#crear tabla
create table local(
	id SERIAL primary key,
	nombre varchar(50),
    ciudad varchar(20),
    direccion varchar(20)
);

#eliminar tabla
drop table if exists local

#insertar datos
INSERT into local values(NULL, "Nombre1", "Ciudad1", "Direccion1")


#consulta
select * from local