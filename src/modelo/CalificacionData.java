/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import entidades.Alumno;
import entidades.Calificacion;
import entidades.Materia;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import javax.swing.JOptionPane;


public class CalificacionData {
    
    private Connection con;
    
    public CalificacionData(Conexion conexion){
    
        con=conexion.getConnection();
    }
    
    public void calificar(Calificacion calificacion){
        try {
            if (con.isClosed()){
                
                con = new Conexion().getConnection();
            }
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        String sql="INSERT INTO `calificacion` (`id_alumno`, `id_materia`, `nota`, `fecha`)"
                + "VALUES (?,?,?,?);";
        
        try{
        
        PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, calificacion.getAlumno().getId_alumno());
        ps.setInt(2, calificacion.getMateria().getIdMateria());
        ps.setDouble(3, calificacion.getNota());
        ps.setDate(4, Date.valueOf(LocalDate.now()));
        
        ps.executeUpdate();
        
           
       con.close();
        
        }catch(SQLException e){
        
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
       
    }
    
    
    
     }

