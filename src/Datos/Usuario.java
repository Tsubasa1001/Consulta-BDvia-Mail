
package Datos;

import Consultas_Mail.ClientePgSql;

/**
 *
 * @author eyver-dev
 */
public class Usuario {
    private String codigo;
    private String ci;
    private String nombre;
    private String nacionalidad;
    private String especialidad;
    private String direccion;
    private String email;
    private String celular;
    private int edad;
    private String genero;
    private ClientePgSql BD;
    private String tabla;
    
    public Usuario() {
        this.BD = new ClientePgSql(
            /*HOST*/"tecnoweb.org.bo",
            /*PORT*/"5432",
            /*USR*/"grupo06sc",
            /*PWD*/"grup006grup006",
            /*BD*/"db_grupo06sc"
        );
        this.tabla = "usuario";
    }
    public Usuario(String codigo, String ci, String nombre, String nacionalidad, String especialidad, String direccion, String email, String celular, int edad, String genero) {
        this.codigo = codigo;
        this.ci = ci;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.especialidad = especialidad;
        this.direccion = direccion;
        this.email = email;
        this.celular = celular;
        this.edad = edad;
        this.genero = genero;
        this.BD = new ClientePgSql(
            /*HOST*/"tecnoweb.org.bo",
            /*PORT*/"5432",
            /*USR*/"grupo06sc",
            /*PWD*/"grup006grup006",
            /*BD*/"db_grupo06sc"
        );
        this.tabla = "trabajador";
    }

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
    public ClientePgSql getBD() {
        return BD;
    }
    public void setBD(ClientePgSql BD) {
        this.BD = BD;
    }
    public String getTabla() {
        return tabla;
    }
    public void setTabla(String tabla) {
        this.tabla = tabla;
    }
    
    /**
     * 
     */
    public void index(){
        String sql;String query;
        
        sql = "select * from "+this.getTabla()+";";
        query = this.getBD().runStatement(sql);
        query = query.replace(" ", "");
        System.out.println(query);
    }
    
    /**
     * 
     * @param c
     * @param c0
     * @param c1
     * @param c2
     * @param c3
     * @param c6
     * @param c7
     * @param c8
     * @param i
     * @param c9 
     */
    public void create(String c, String c0, String c1, String c2, String c3, String c6, String c7, String c8, int i, String c9){
        setCodigo(c);
        setCi(c0);
        setNombre(c1);
        setNacionalidad(c2);
        setEspecialidad(c3);
        setDireccion(c6);
        setEmail(c7);
        setCelular(c8);
        setEdad(i);
        setGenero(c9);
        String sql;String query;
        
        sql = ""
                + "INSERT INTO "
                + this.getTabla()
                + " VALUES ('"
                + this.getCodigo()
                + "', '"
                + this.getCi()
                + "', '"
                + this.getNombre()
                + "', '"
                + this.getNacionalidad()
                + "', '"
                + this.getEspecialidad()
                + "', '"
                + this.getDireccion()
                + "', '"
                + this.getEmail()
                + "', '"
                + this.getCelular()
                + "', "
                + this.getEdad()
                + ", '"
                + this.getGenero()
                + "');";
        query = this.getBD().runStatement(sql);
    }
    
    /**
     * 
     * @param f 
     */
    public void read(String f){
        this.setCodigo(f);
        String sql;String query;
        
        sql = "select * from "+this.getTabla()+" where codigo = '"+this.getCodigo()+"';";
        query = this.getBD().runStatement(sql);
        query = query.replace(" ", "");
        System.out.println(query);
    }
    
    /**
     * 
     * @param codigoViejo
     * @param c
     * @param c0
     * @param c1
     * @param c2
     * @param c3
     * @param c6
     * @param c7
     * @param c8
     * @param i
     * @param c9 
     */
    public void update(String codigoViejo, String c, String c0, String c1, String c2, String c3, String c6, String c7, String c8, int i, String c9){
        setCodigo(c);
        setCi(c0);
        setNombre(c1);
        setNacionalidad(c2);
        setEspecialidad(c3);
        setDireccion(c6);
        setEmail(c7);
        setCelular(c8);
        setEdad(i);
        setGenero(c9);
        String sql;String query;
        
        sql = ""
                + "update "
                + this.getTabla()
                + " set "
                + "codigo = '"
                + this.getCodigo()
                + "', ci = '"
                + this.getCi()
                + "', nombre = '"
                + this.getNombre()
                + "', nacionalidad = '"
                + this.getNacionalidad()
                + "', especialidad = '"
                + this.getEspecialidad()
                + "', direccion = '"
                + this.getDireccion()
                + "', email = '"
                + this.getEmail()
                + "', celular = '"
                + this.getCelular()
                + "', edad = "
                + this.getEdad()
                + ", genero = '"
                + this.getGenero()
                + "' where codigo = '"
                + codigoViejo
                +"';";
        System.out.println(sql);
        query = this.getBD().runStatement(sql);
    }
    
    /**
     * 
     * @param f 
     */
    public void delete(String f){
        this.setCodigo(f);
        String sql;String query;
        
        sql = "delete from "+this.getTabla()+" where codigo = '"+this.getCodigo()+"';";
        query = this.getBD().runStatement(sql);
    }
    
    public static void main(String[] args) {
        Usuario t = new Usuario();
        
        t.getBD().connect();
        t.index();
        //t.create("f", "f", "f", "f", "f", "f", "f", "f", 1, "M");
        //t.index();
        //t.read("f");
        //t.delete("a");
        //t.index();
        //t.update("e", "eee", "z", "z", "z", "z", "z", "z", "z", 1, "M");
        //t.index();
        t.getBD().desconectar();
    }
}
