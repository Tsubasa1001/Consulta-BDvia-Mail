package negocio;

import Consultas_Mail.ClientePgSql;
import Datos.DatosTrabajador;

/**
 *
 * @author eyver-dev
 */
public class NegocioTrabajador {
    private String codigo;              /*variable de la tabla*/
    private String ci;                  /*variable de la tabla*/
    private String nombre;              /*variable de la tabla*/
    private String nacionalidad;        /*variable de la tabla*/
    private String especialidad;        /*variable de la tabla*/
    private String cargo;               /*variable de la tabla*/
    private String ocupacion;           /*variable de la tabla*/
    private String direccion;           /*variable de la tabla*/
    private String email;               /*variable de la tabla*/
    private String celular;             /*variable de la tabla*/
    private int edad;                   /*variable de la tabla*/
    private String genero;              /*variable de la tabla*/
    private DatosTrabajador workerBD;   /*variable del sistema*/
    private String tabla;               /*variable de operaciones*/
    
    public NegocioTrabajador() {
        this.workerBD = new DatosTrabajador();
        this.tabla = "trabajador";
    }
    public NegocioTrabajador(String codigo, String ci, String nombre, String nacionalidad, String especialidad, String cargo, String ocupacion, String direccion, String email, String celular, int edad, String genero) {
        this.codigo = codigo;
        this.ci = ci;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.especialidad = especialidad;
        this.cargo = cargo;
        this.ocupacion = ocupacion;
        this.direccion = direccion;
        this.email = email;
        this.celular = celular;
        this.edad = edad;
        this.genero = genero;
        this.workerBD = new DatosTrabajador();
        this.tabla = "trabajador";
    }
    
    /* G E T / S E T   D E   L A S   V A R I A B L E S */
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getCi() {
        return ci;
    }
    public void setCi(String ci) {
        this.ci = ci;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getNacionalidad() {
        return nacionalidad;
    }
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
    public String getEspecialidad() {
        return especialidad;
    }
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    public String getOcupacion() {
        return ocupacion;
    }
    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getCelular() {
        return celular;
    }
    public void setCelular(String celular) {
        this.celular = celular;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public DatosTrabajador getWorkerBD() {
        return workerBD;
    }
    public void setWorkerBD(DatosTrabajador workerBD) {
        this.workerBD = workerBD;
    }
    public ClientePgSql getPostgres() {
        return workerBD;
    }
    public void setPostgres(ClientePgSql postgres) {
        this.workerBD = postgres;
    }
    public String getTabla() {
        return tabla;
    }
    public void setTabla(String tabla) {
        this.tabla = tabla;
    }
    /* ********************************************************************** */
    
    public static void main(String[] args) {
        NegocioTrabajador worker = new NegocioTrabajador();
        
        worker.getWorkerBD().getPostgres().connect();
        
        worker.getWorkerBD().read(worker.getTabla(), "f");
        worker.getWorkerBD().delete(worker.getTabla(), "f");
        worker.getWorkerBD().read(worker.getTabla(), "f");
        worker.getWorkerBD().create(worker.getTabla(),"f", "f", "f", "f", "f", "f", "f", "f", "f", "f", 1, "M");
        worker.getWorkerBD().read(worker.getTabla(), "f");
        
        worker.getWorkerBD().getPostgres().desconectar();
        
        //t.index();
        //t.create("f", "f", "f", "f", "f", "f", "f", "f", "f", "f", 1, "M");
        //t.index();
        //t.read("f");
        //t.delete("a");
        //t.index();
        //t.update("e", "eee", "z", "z", "z", "z", "z", "z", "z", "z", "z", 1, "M");
        //t.index();
    }
}
