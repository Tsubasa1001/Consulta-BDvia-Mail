/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;
import Datos.DConsulta;
import Datos.DSkinTest;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sariah
 */
public class NSkinTest {
    
    private DSkinTest dskintest;

    public NSkinTest() {
        dskintest = new DSkinTest();
        
    }
    
    public String Listar(){
        String Lista = this.dskintest.Listar();
         String[] tmp = Lista.split("\n");
        
        System.err.println("tmp: "+tmp[1]);
        String resultado = "";
        resultado += "\n____________________________________________________________________________ \n"
                     +"ID___COD.CONSULTA___COD.TEST_____PROBLEMAS_DE_SALUD_____________ALERGIAS____\n";
        
        for (int i = 0; i < tmp.length; i++){
            String[] aux = tmp[i].split(",");
            for (int j = 0; j < aux.length; j++){
                aux[j] = aux[j].trim();
            }
            
        
            
            
        resultado += String.format("%-5s", aux[0]);
        resultado += String.format("%-15s", ","+aux[1]);
        resultado += String.format("%-15s", ","+aux[2]);
        resultado += String.format("%-30s", ","+aux[3]);
        resultado += String.format("%-20s", ","+aux[4]);
            
        resultado += "\n";
        
        }
        return resultado;
    }
    
    public void Registrar(List<String> atributos) throws SQLException{
        int id = Integer.parseInt(atributos.get(0));
        int id_consulta = Integer.parseInt(atributos.get(1));
        String codigo = atributos.get(2);
        String tratamiento_dermatologico = atributos.get(3);
        String cirugia = atributos.get(4);
        String problemas_salud = atributos.get(5);
        String fuma = atributos.get(6);
        String actividad_fisica = atributos.get(7);
        String alergias = atributos.get(8);
        String medicacion = atributos.get(9);
        String afeccion_piel = atributos.get(10);
        String hidratacion = atributos.get(11);
        String observacion_cosmetica = atributos.get(12);
        
        dskintest.setCodigo(codigo); 
        dskintest.setTratamiento_dermatologico(tratamiento_dermatologico);
        dskintest.setCirugia(cirugia);
        dskintest.setProblemas_salud(problemas_salud);
        dskintest.setFuma(fuma);
        dskintest.setActividad_fisica(actividad_fisica);
        dskintest.setAlergias(alergias);
        dskintest.setMedicacion(medicacion);
        dskintest.setAfeccion_piel(afeccion_piel);
        dskintest.setHidratacion(hidratacion);
        dskintest.setObservacion_cosmetica(observacion_cosmetica);
        
        dskintest.Dregistrar(id,id_consulta);
        
     }
    
    public void Modificar(List<String> atributos) throws SQLException{
        int id = Integer.parseInt(atributos.get(0));
        int id_consulta = Integer.parseInt(atributos.get(1));
        String codigo = atributos.get(2);
        String tratamiento_dermatologico = atributos.get(3);
        String cirugia = atributos.get(4);
        String problemas_salud = atributos.get(5);
        String fuma = atributos.get(6);
        String actividad_fisica = atributos.get(7);
        String alergias = atributos.get(8);
        String medicacion = atributos.get(9);
        String afeccion_piel = atributos.get(10);
        String hidratacion = atributos.get(11);
        String observacion_cosmetica = atributos.get(12);
        
        dskintest.setCodigo(codigo); 
        dskintest.setTratamiento_dermatologico(tratamiento_dermatologico);
        dskintest.setCirugia(cirugia);
        dskintest.setProblemas_salud(problemas_salud);
        dskintest.setFuma(fuma);
        dskintest.setActividad_fisica(actividad_fisica);
        dskintest.setAlergias(alergias);
        dskintest.setMedicacion(medicacion);
        dskintest.setAfeccion_piel(afeccion_piel);
        dskintest.setHidratacion(hidratacion);
        dskintest.setObservacion_cosmetica(observacion_cosmetica);
        
        dskintest.Dmodificar(id,id_consulta);
        
     }
    
    public void Eliminar(List<String> atributos) throws SQLException{
        int id = Integer.parseInt(atributos.get(0));
        dskintest.setId(id);
        dskintest.Deliminar();
    }
    
    public String Ver(List<String> atributos) throws SQLException{
        int id = Integer.parseInt(atributos.get(0));
        dskintest.setId(id);
        //System.err.println("id:"+id);
        String detalle = dskintest.Dver(dskintest.getId());
        //System.err.println("resultado: "+detalle);
    return detalle;
    } 
    
    public static void main(String[] args) throws SQLException{
        NSkinTest nskintest = new NSkinTest();
        List<String> atributos = new ArrayList<>();
        
        atributos.add("2");
        atributos.add("3");
        atributos.add("T-0003");
        atributos.add("acne");
        atributos.add("ninguna");
        atributos.add("higado graso");
        atributos.add("si, regularmente");
        atributos.add("no");
        atributos.add("ninguna");
        atributos.add("medicinas herbareas");
        atributos.add("acne");
        atributos.add("1 vaso/dia");
        atributos.add("Acne grado 2");
        
                
        
        System.out.println("lista: "+atributos);
        System.out.println("lista: \n"+ nskintest.Listar());
        System.out.println(nskintest.Ver(atributos));
        //System.out.println(nconsulta.Ver(atributos));
        //System.out.println("lista: \n"+ nskintest.Listar());
        
        //nreserva.Eliminar(atributos);
        //System.out.println("lista: \n"+ nreserva.Listar());  
    } 
    
}
