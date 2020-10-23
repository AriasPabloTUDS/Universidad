
package entidades;

import entidades.Materia;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.Month;
import modelo.AlumnoData;
import modelo.CalificacionData;
import modelo.Conexion;
import modelo.InscripcionData;
import modelo.MateriaData;



public class Universidad {

   
    public static void main(String[] args) {
        
        Conexion c=new Conexion();
      /*
        Materia tecnologia = new Materia("Tecnologia");
        Materia eda = new Materia("Estructura de datos");
        Materia info = new Materia("Informatica");
        
        MateriaData md = new MateriaData(c);
        md.agregarMateria(tecnologia);
        md.agregarMateria(eda);
        md.agregarMateria(info);
        
        Alumno sergio=new Alumno("Sergio Gonzales",LocalDate.of(1977, Month.APRIL, 1),true);
        Alumno Gonzalo=new Alumno("Gonzalo Flores",LocalDate.of(1990, Month.JULY, 1),true);
        Alumno Florencia=new Alumno("Florencia Perez",LocalDate.of(1995, Month.DECEMBER, 1),true);
        
        
        Inscripcion inscripcion = new Inscripcion(sergio,tecnologia);
        InscripcionData id = new InscripcionData(c);
        id.altaInscripcion(inscripcion);
*/
        Calificacion calificacion = new Calificacion(new Alumno(1,"Damian Gonzalez",LocalDate.of(1990, Month.MARCH, 1),true),new Materia(6,"Informatica"),8);
        CalificacionData cd = new CalificacionData(c);
        cd.calificar(calificacion);
    }
    
}
