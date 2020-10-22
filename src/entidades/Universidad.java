
package entidades;

import entidades.Materia;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.Month;
import modelo.AlumnoData;
import modelo.Conexion;
import modelo.MateriaData;



public class Universidad {

   
    public static void main(String[] args) {
        // TODO code application logic here
        Conexion c=new Conexion();
        //('Juan Perez', '1983-4-8', '1');
        Alumno al=new Alumno("Franco Caballero",LocalDate.of(1997, Month.APRIL, 12),true);
        AlumnoData ad=new AlumnoData(c);
        //ad.guardarAlumno(al);
        Alumno a2 = ad.buscarAlumno(2);
        System.out.println(a2.toString());
        
        //Materia lab = new Materia("EDA");
        //MateriaData addMateria = new MateriaData(c);
        //addMateria.agregarMateria(lab);
        
    }
    
}
