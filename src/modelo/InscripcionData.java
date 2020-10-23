/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import entidades.Alumno;
import entidades.Inscripcion;
import entidades.Materia;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class InscripcionData {
    private Connection con;

    public InscripcionData(Conexion conexion) {
       con=conexion.getConnection();
    }
    
  
    public void altaInscripcion(Inscripcion inscripcion){
    
        String sql="INSERT into inscripcion (id_alumno, id_materia, fecha) "
                + "VALUES(?, ?, ?);";
        
        try{
        
        PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1,inscripcion.getAlumno().getId_alumno());
        ps.setInt(2,inscripcion.getMateria().getIdMateria());
        ps.setDate(3, Date.valueOf(LocalDate.now()));
        
        
        ps.executeQuery();
        
        ResultSet rs = ps.getGeneratedKeys();
        
       
        con.close();
        
        }catch(SQLException e){
        
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
       
    }
    
     public void bajaInscripcion(int idInscripcion){
    
        String sql="DELETE from inscripcion WHERE id_inscripcion = ?";
        
        
        try{
        
        PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1,idInscripcion);
       
        
        
        ps.executeQuery();
        
        ResultSet rs = ps.getGeneratedKeys();
        
       
        con.close();
        
        }catch(SQLException e){
        
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
       
    }
    
}
