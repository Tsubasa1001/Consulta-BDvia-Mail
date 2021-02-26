package negocio;

import Consultas_Mail.ClientePgSql;
import Datos.DatosTrabajador;
import static java.time.Instant.now;

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
    private String tabla;               /*variable del sistema*/
    
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
    
    public String getCodigo() {return codigo;}
    public void setCodigo(String codigo) {this.codigo = codigo;}
    public String getCi() {return ci;}
    public void setCi(String ci) {this.ci = ci;}
    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public String getNacionalidad() {return nacionalidad;}
    public void setNacionalidad(String nacionalidad) {this.nacionalidad = nacionalidad;}
    public String getEspecialidad() {return especialidad;}
    public void setEspecialidad(String especialidad) {this.especialidad = especialidad;}
    public String getCargo() {return cargo;}
    public void setCargo(String cargo) {this.cargo = cargo;}
    public String getOcupacion() {return ocupacion;}
    public void setOcupacion(String ocupacion) {this.ocupacion = ocupacion;}
    public String getDireccion() {return direccion;}
    public void setDireccion(String direccion) {this.direccion = direccion;}
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
    public String getCelular() {return celular;}
    public void setCelular(String celular) {this.celular = celular;}
    public int getEdad() {return edad;}
    public void setEdad(int edad) {this.edad = edad;}
    public String getGenero() {return genero;}
    public void setGenero(String genero) {this.genero = genero;}
    public DatosTrabajador getWorkerBD() {return workerBD;}
    public void setWorkerBD(DatosTrabajador workerBD) {this.workerBD = workerBD;}
    public String getTabla() {return tabla;}
    public void setTabla(String tabla) {this.tabla = tabla;}

    /* ********************************************************************** */
    
    private void index() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void read(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void create(String string, String string0, String valentín_Noelia, String bolivia, String string1, String c_Alameins, String gmailcom, String string2, String string3, String m, String now) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void delete(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    public static void main(String[] args) {
        NegocioTrabajador worker = new NegocioTrabajador();
        
        worker.index();
        System.out.println("*************************************************");
        worker.read("6000");
        System.out.println("*************************************************");
        worker.create("6000", "5959595", "Valentín Noelia", "Bolivia", "1", "c Alameins", "6000@gmail.com", "65858585", "22", "M", "now()");
        System.out.println("*************************************************");
        worker.delete("6000");
        System.out.println("*************************************************");
        worker.read("6000");
        System.out.println("*************************************************");
        worker.getWorkerBD().delete(worker.getTabla(), 37);
    }
}
