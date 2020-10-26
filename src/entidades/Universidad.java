
package entidades;

import entidades.*;
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
        
         Materia quimica = new Materia("Quimica");
         Materia lab4 = new Materia("Laboratorio 4");
         MateriaData md=new MateriaData(c);
         md.agregarMateria(quimica);
         md.agregarMateria(lab4);
         
         md.agregarMateria(lab4);
         md.modificarMateria(quimica,7804, "Modificado", true);
         
         
         md.agregarMateria(quimica);
         md.quitarMateria(1);
         AlumnoData ad= new AlumnoData(c);
         ad.borrarAlumno(5);
         ad.borrarAlumno(5);
         md.quitarMateria(1);
         
      
         Materia tecnologia = new Materia("Tecnologia");
         Materia eda = new Materia("Estructura de datos");
         Materia info = new Materia("Informatica");
        
         md.agregarMateria(tecnologia);
         md.agregarMateria(eda);
         md.agregarMateria(info);
        
         Alumno sergio=new Alumno(7,"Sergio Gonzales",LocalDate.of(1977, Month.APRIL, 1),true);
         ad.guardarAlumno(sergio);
         ad.modificarAlumno(sergio, 1124, "Ariel Lucero", LocalDate.of(1900, Month.APRIL, 1), true);
         Alumno Gonzalo=new Alumno("Gonzalo Flores",LocalDate.of(1990, Month.JULY, 1),true);
         Alumno Florencia=new Alumno("Florencia Perez",LocalDate.of(1995, Month.DECEMBER, 1),true);
        
        
        
        Inscripcion inscripcion = new Inscripcion(sergio,tecnologia);
        InscripcionData id = new InscripcionData(c);
        id.altaInscripcion(inscripcion);

        Calificacion calificacion = new Calificacion(new Alumno(1,"Damian Gonzalez",LocalDate.of(1990, Month.MARCH, 1),true),new Materia(6,"Informatica"),8);
        CalificacionData cd = new CalificacionData(c);
        cd.calificar(calificacion);
        
        
    }
    
}
