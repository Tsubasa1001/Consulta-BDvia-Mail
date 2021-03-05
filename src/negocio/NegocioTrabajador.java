package negocio;

import Datos.DatosTrabajador;

/**
 *
 * @author eyver-dev
 */
public class NegocioTrabajador {
    private int id;                     /*variable de la tabla*/
    private String ci;                  /*variable de la tabla*/
    private String nombre;              /*variable de la tabla*/
    private String nacionalidad;        /*variable de la tabla*/
    private String especialidad;        /*variable de la tabla*/
    private String cargo;               /*variable de la tabla*/
    private String ocupacion;           /*variable de la tabla*/
    private String direccion;           /*variable de la tabla*/
    private String email;               /*variable de la tabla*/
    private String celular;             /*variable de la tabla*/
    private String edad;                /*variable de la tabla*/
    private String genero;              /*variable de la tabla*/
    private String fecha_creacion;      /*variable de la tabla*/
    private DatosTrabajador trabajadorBD;/*ariable del sistema*/
    private String tabla;               /*variable del sistema*/
    
    public NegocioTrabajador() {
        this.trabajadorBD = new DatosTrabajador();
        this.tabla = "trabajador";
    }
    
    /* G E T / S E T   D E   L A S   V A R I A B L E S */
    
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
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
    public String getEdad() {return edad;}
    public void setEdad(String edad) {this.edad = edad;}
    public String getGenero() {return genero;}
    public void setGenero(String genero) {this.genero = genero;}
    public String getFecha_creacion() {return fecha_creacion;}
    public void setFecha_creacion(String fecha_creacion) {this.fecha_creacion = fecha_creacion;}
    public DatosTrabajador getTrabajadorBD() {return trabajadorBD;}
    public void setTrabajadorBD(DatosTrabajador trabajadorBD) {this.trabajadorBD = trabajadorBD;}
    public String getTabla() {return tabla;}
    public void setTabla(String tabla) {this.tabla = tabla;}

    /* ********************************************************************** */
    
    public static void main(String[] args) {
        NegocioTrabajador worker = new NegocioTrabajador();
        String tmp = "";
        
        /**
         * id       ci          nombre      nacionalidad    especialidad
         * cargo    ocupacion   direccion   email           celular         edad
         * genero   fecha_reacion
         * 
         * "5000","6742098","IldefonsoLino","Bolivia","1","c/Alameins","5000@gmail.com","60426008","53","M","2020-08-08"
         * id,ci,nombre,nacionalidad,especialidad,cargo,ocupacion,direccion,email,celular,edad,genero,fecha_creacion
         * 
         */
        
        
        /**
         * Suele emplearse el término:
         * ocupación para la categoría de obreros
         * cargos para el personal directivo y funcionarios
         */
        tmp = worker.index();
        System.out.println("index"+"\n"+tmp+"\n\n");
        
        worker.create(5001, "WORK005001","777777","IldefonsoLino","Bolivia","1","No presente","Secreatria","c/Alameins","5001@gmail.com","64444408","53","M","2020-08-08");
        
        tmp = worker.read(5001);
        System.out.println("read"+"\n"+tmp+"\n\n");
        
        worker.update(5002, "WORK005001","777777","IldefonsoLino","Bolivia","1","No presente","Secreatria","c/Alameins","5001@gmail.com","64444408","53","M","2020-08-08", 5001);
        tmp = worker.read(5002);
        System.out.println("read"+"\n"+tmp+"\n\n");
        
        worker.delete(5002);
        tmp = worker.read(5001);
        System.out.println("read"+"\n"+tmp+"\n\n");
    }
    
    private String index() {
        String resultado = "default";        
        resultado = this.getTrabajadorBD().index(this.getTabla());
        
        String[] tmp = resultado.split("\n");
        resultado = "";
        
        /**
         * Banner
         */
        
        for (int i = 1; i < tmp.length; i++){
            String[] aux = tmp[i].split(",");
            for (int j = 0; j < aux.length; j++){
                aux[j] = aux[j].trim();
            }
            
            resultado += String.format("%-20s", aux[3]);
            resultado += String.format("%-10s", ","+aux[4]);
            resultado += String.format("%-50s", ","+aux[6]);
            resultado += String.format("%-20s", ","+aux[7]);
            resultado += String.format("%-10s", ","+aux[8]);
            
            resultado += "\n";
        }
        
        return resultado;
    }
    private void create(int id, String codigo, String ci, String nombre, String nacionalidad, String especialidad, String cargo, String ocupacion, String direccion, String email, String celular, String edad, String genero, String fecha_creacion) {
        this.getTrabajadorBD().create(this.getTabla(), id, codigo, ci, nombre, nacionalidad, especialidad, cargo, ocupacion, direccion, email, celular, edad, genero, fecha_creacion);
    }
    private String read(int id) {
        String resultado = "default";
        resultado = this.getTrabajadorBD().read(this.getTabla(), id);
        
        String[] tmp = resultado.split("\n");
        resultado = "";
        
        /**
         * Banner
         */
        
        for (int i = 1; i < tmp.length; i++){
            String[] aux = tmp[i].split(",");
            for (int j = 0; j < aux.length; j++){
                aux[j] = aux[j].trim();
            }
            
            resultado += String.format("%-5s", aux[0]);
            resultado += String.format("%-10s", ","+aux[1]);
            resultado += String.format("%-10s", ","+aux[2]);
            resultado += String.format("%-20s", ","+aux[3]);
            resultado += String.format("%-20s", ","+aux[4]);
            resultado += String.format("%-10s", ","+aux[5]);
            resultado += String.format("%-5s", ","+aux[6]);
            resultado += String.format("%-50s", ","+aux[7]);
            resultado += String.format("%-20s", ","+aux[8]);
            resultado += String.format("%-10s", ","+aux[9]);
            resultado += String.format("%-15s", ","+aux[10]);//direccion
            resultado += String.format("%-10s", ","+aux[11]);//email
            resultado += String.format("%-5s", ","+aux[12]);//celular
            resultado += String.format("%-5s", ","+aux[13]);
            resultado += String.format("%-12s", ","+aux[14]);
            
            resultado += "\n";
        }
        
        return resultado;
    }
    private void update(int id, String codigo, String ci, String nombre, String nacionalidad, String especialidad, String cargo, String ocupacion, String direccion, String email, String celular, String edad, String genero, String fecha_creacion, int idViejo) {
        this.getTrabajadorBD().update(this.getTabla(), id, codigo, ci, nombre, nacionalidad, especialidad, cargo, ocupacion, direccion, email, celular, edad, genero, fecha_creacion, idViejo);
    }
    private void delete(int id) {
        this.getTrabajadorBD().delete(this.getTabla(), id);
    }
}
