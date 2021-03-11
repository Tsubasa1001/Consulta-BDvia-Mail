/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;
import Consultas_Mail.ClientePgSql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author sariah
 */
public class DSkinTest {
    
    private int id;
    private int id_consulta;
    private String codigo;
    private String tratamiento_dermatologico;
    private String cirugia;
    private String problemas_salud;
    private String fuma;
    private String actividad_fisica;
    private String alergias;
    private String medicacion;
    private String afeccion_piel;
    private String hidratacion;
    private String observacion_cosmetica;
    
    private static ClientePgSql bd;
    
    private DConsulta dconsulta;

    public DSkinTest() {
        bd = new ClientePgSql();
    }

    public DSkinTest(int id, int id_consulta, String codigo, String tratamiento_dermatologico, String cirugia, String problemas_salud, String fuma, String actividad_fisica, String alergias, String medicacion, String afeccion_piel, String hidratacion, String observacion_cosmetica) {
        this.id = id;
        this.id_consulta = id_consulta;
        this.codigo = codigo;
        this.tratamiento_dermatologico = tratamiento_dermatologico;
        this.cirugia = cirugia;
        this.problemas_salud = problemas_salud;
        this.fuma = fuma;
        this.actividad_fisica = actividad_fisica;
        this.alergias = alergias;
        this.medicacion = medicacion;
        this.afeccion_piel = afeccion_piel;
        this.hidratacion = hidratacion;
        this.observacion_cosmetica = observacion_cosmetica;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_consulta() {
        return id_consulta;
    }

    public void setId_consulta(int id_consulta) {
        this.id_consulta = id_consulta;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTratamiento_dermatologico() {
        return tratamiento_dermatologico;
    }

    public void setTratamiento_dermatologico(String tratamiento_dermatologico) {
        this.tratamiento_dermatologico = tratamiento_dermatologico;
    }

    public String getCirugia() {
        return cirugia;
    }

    public void setCirugia(String cirugia) {
        this.cirugia = cirugia;
    }

    public String getProblemas_salud() {
        return problemas_salud;
    }

    public void setProblemas_salud(String problemas_salud) {
        this.problemas_salud = problemas_salud;
    }

    public String getFuma() {
        return fuma;
    }

    public void setFuma(String fuma) {
        this.fuma = fuma;
    }

    public String getActividad_fisica() {
        return actividad_fisica;
    }

    public void setActividad_fisica(String actividad_fisica) {
        this.actividad_fisica = actividad_fisica;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public String getMedicacion() {
        return medicacion;
    }

    public void setMedicacion(String medicacion) {
        this.medicacion = medicacion;
    }

    public String getAfeccion_piel() {
        return afeccion_piel;
    }

    public void setAfeccion_piel(String afeccion_piel) {
        this.afeccion_piel = afeccion_piel;
    }

    public String getHidratacion() {
        return hidratacion;
    }

    public void setHidratacion(String hidratacion) {
        this.hidratacion = hidratacion;
    }

    public String getObservacion_cosmetica() {
        return observacion_cosmetica;
    }

    public void setObservacion_cosmetica(String observacion_cosmetica) {
        this.observacion_cosmetica = observacion_cosmetica;
    }
    
    public String Listar(){
   
        Connection conexion = this.bd.connect();
        String sql = "SELECT test.id,c.codigo,test.codigo, \n" +
                      "test.problemas_salud,\n" +
                      "test.alergias \n" +
                     "FROM skintest test, consulta c\n" +
                     "where test.id_consulta = c.id \n" +
                     "ORDER BY id ASC";
        String result = this.bd.runStatement(sql);
        conexion = null;
        return result;  
    }
    
    public String Dregistrar(int id,int id_consulta) throws SQLException{
        
        String resultado="";
        Connection conexion = this.bd.connect();
        String sql = "INSERT INTO skintest values("+id+","+id_consulta+",?,?,?,?,?,?,?,?,?,?,?);";
        System.out.println("sql: "+sql);
        PreparedStatement ps = conexion.prepareStatement(sql);

        ps.setString(1, this.getCodigo());
        ps.setString(2,this.getTratamiento_dermatologico());
        ps.setString(3, this.getCirugia());
        ps.setString(4, this.getProblemas_salud());
        ps.setString(5, this.getFuma());
        ps.setString(6, this.getActividad_fisica());
        ps.setString(7, this.getAlergias());
        ps.setString(8, this.getMedicacion());
        ps.setString(9, this.getAfeccion_piel());
        ps.setString(10, this.getHidratacion());
        ps.setString(11, this.getObservacion_cosmetica());
       
        System.err.println("ps:" + ps);
        
        ps.executeUpdate();
        ps.close();
        conexion = null;
        
        resultado="A registrado un skintest exitosamente";
        return resultado;
    }
    
    public String Dmodificar(int id, int id_consulta) throws SQLException{
        
        String resultado="";
        Connection conexion = this.bd.connect();
        String sql = "UPDATE skintest \n" +
                     "SET id_consulta= "+id_consulta+", codigo  = ?, tratamiento_dermatologico=?,\n" +
                      "cirugia = ?,problemas_salud = ?,fuma = ?, actividad_fisica = ?,alergias = ?," +
                      "medicacion = ?,afeccion_piel = ?,hidratacion= ?, observacion_cosmetica= ? \n" +
                     "WHERE id = "+id+";";
        System.out.println("sql: "+sql);
        PreparedStatement ps = conexion.prepareStatement(sql);

        ps.setString(1, this.getCodigo());
        ps.setString(2,this.getTratamiento_dermatologico());
        ps.setString(3, this.getCirugia());
        ps.setString(4, this.getProblemas_salud());
        ps.setString(5, this.getFuma());
        ps.setString(6, this.getActividad_fisica());
        ps.setString(7, this.getAlergias());
        ps.setString(8, this.getMedicacion());
        ps.setString(9, this.getAfeccion_piel());
        ps.setString(10, this.getHidratacion());
        ps.setString(11, this.getObservacion_cosmetica());
       
        System.err.println("ps:" + ps);
        
        ps.executeUpdate();
        ps.close();
        conexion = null;
        
        resultado="A modificado un skintest exitosamente";
        return resultado;
    }
    
    public String Deliminar()throws SQLException{
        String resultado="";
        
        Connection conexion = this.bd.connect();
        String sql = "DELETE FROM skintest WHERE id = ?;";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setInt(1,this.getId());
        ps.executeUpdate();
        ps.close();
        conexion = null;
        
        resultado = "A eliminado un skintest exitosamente";
        return resultado;
    }
    
    public String Dver(int id) throws SQLException{
        Connection conexion = this.bd.connect();
        String sql = "SELECT test.id,c.codigo,test.codigo,test.tratamiento_dermatologico, \n" +
                      "test.cirugia,test.problemas_salud,test.fuma,test.actividad_fisica,\n" +
                      "test.alergias,test.medicacion,test.afeccion_piel,test.hidratacion,\n" +
                      "test.observacion_cosmetica \n" +
                     "FROM skintest test, consulta c\n" +
                     "where test.id_consulta = c.id and test.id="+id+";";
        System.out.println("sql: "+sql);
        String result = this.bd.runStatement(sql);
        conexion = null;
        
        //result.replaceAll(" ","");
        
        String[] detalle = result.split(",");
        System.out.println("result: "+result);
        result = "El SkinTest id"+id+" es:\n"
                + "id SkinTest: "+detalle[0].trim() +"\n"
                + "Codigo consulta: "+detalle[1].trim() +"\n"
                + "Codigo SkinTest: "+detalle[2].trim()+"\n"
                + "Tratamiento dermatologico: "+detalle[3].trim()+"\n"
                + "Cirugias: "+detalle[4].trim()+"\n"
                + "Problemas de salud: "+detalle[5].trim()+"\n"
                + "Fuma: "+detalle[6].trim()+"\n"
                + "Actividad fisica: "+detalle[7].trim()+"\n"
                + "Alergias: "+detalle[8].trim()+"\n"
                + "Medicacion: "+detalle[9].trim()+"\n"
                + "Afeccion en la piel: "+detalle[10].trim()+"\n"
                + "Hidratacion: "+detalle[11].trim()+"\n"
                + "Observacion cosmetica: "+detalle[12].trim()+"\n"
                + "";
        
        
        //result.replace(" ","");
        System.err.println(detalle);
        return result;
    }
    
}
