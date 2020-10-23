
package modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import entidades.Alumno;


public class AlumnoData {
    private Connection con;
    
    public AlumnoData(Conexion conexion){
    
        con=conexion.getConnection();
    }
    
    public void guardarAlumno(Alumno alumno){
    
        String sql="INSERT into alumno (nombre_alumno, fn_alumno,activo) "
                + "VALUES(?, ?, ?);";
        
        try{
        
        PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1,alumno.getNombre_alumno() );
        ps.setDate(2, Date.valueOf(alumno.getFn_alumno()));
        ps.setBoolean(3, alumno.isActivo());
        
        ps.executeQuery();
        
        ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                alumno.setId_alumno(rs.getInt(1));
            } else {
                JOptionPane.showMessageDialog(null,"No puedo obtener id");
            }
       con.close();
        
        }catch(SQLException e){
        
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
       
    }
    
     public Alumno buscarAlumno(int id) {
        //Alumno alumno = null;
        Alumno alumno= new Alumno();
        String sql = "SELECT * FROM alumno WHERE id_alumno=?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                alumno.setId_alumno(rs.getInt("id_alumno"));
                alumno.setNombre_alumno(rs.getString("nombre_alumno"));
                alumno.setFn_alumno(rs.getDate("fn_alumno").toLocalDate());
                alumno.setActivo(rs.getBoolean("activo"));
            }
            rs.close();
            ps.close();

        } catch (SQLException ex) {
            //Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
            //JOptionPane.showMessageDialog(null, "Alumno no encontrado ", "Error!", JOptionPane.WARNING_MESSAGE);
        }
        return alumno;
    }
     }

     /*
package modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import Universidad.entidades.Alumno;

public class AlumnoData {

    private Connection con;

    public AlumnoData(Conexion conexion) {

        con = conexion.getConnection();
    }

    public void guardarAlumno(Alumno alumno) {

        String sql = "INSERT into alumno (nombre_alumno, fn_alumno,activo) " + "VALUES(?, ?, ?);";

        try {

            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, alumno.getNombreAlumno());
            ps.setDate(2, Date.valueOf(alumno.getFnAlumno()));
            ps.setBoolean(3, alumno.isActivo());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                alumno.setIdAlumno(rs.getInt(1));
            } else {
                JOptionPane.showMessageDialog(null, "No puedo obtener id");
            }
            rs.close();
            con.close();
          
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Error al guardar Alumno");
        }
    }

    public Alumno buscarAlumno(int id) {
        Alumno alumno = null;
        String sql = "SELECT * FROM alumno WHERE id_alumno=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                alumno = new Alumno();
                alumno.setIdAlumno(rs.getInt("id_alumno"));
                alumno.setNombreAlumno(rs.getString("nombre_alumno"));
                alumno.setFnAlumno(rs.getDate("fn_alumno").toLocalDate());
                alumno.setActivo(rs.getBoolean("activo"));
         
            rs.close();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Alumno no encontrado ", "Error!", JOptionPane.WARNING_MESSAGE);
        }
        return alumno;
    }

    public List<Alumno> obtenerAlumnos() {

        Alumno alumno;
        List<Alumno> alumnos = new ArrayList<>();
        String sql = "SELECT * FROM alumno ";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                alumno = new Alumno();
                alumno.setIdAlumno(rs.getInt("id_alumno"));
                alumno.setNombreAlumno(rs.getString("nombre_alumno"));
                alumno.setFnAlumno(rs.getDate("fn_alumno").toLocalDate());
                alumno.setActivo(rs.getBoolean("activo"));
                System.out.println(alumno.getNombreAlumno());
                alumnos.add(alumno);
        
            }
            rs.close();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Alumnos no encontrados ", "Error!", JOptionPane.WARNING_MESSAGE);
        }
        return alumnos;
    }

    public void actualizarAlumno(Alumno alumno) {

        try {
            String sql = "UPDATE alumno SET nombre_alumno=?, fn_alumno=?, activo=? WHERE id_alumno=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, alumno.getNombreAlumno());
            ps.setDate(2, Date.valueOf(alumno.getFnAlumno()));
            ps.setBoolean(3, alumno.isActivo());
            ps.setInt(4, alumno.getIdAlumno());

            ps.executeUpdate();
            ps.close();
           
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Error al actualizar Alumno");
        }
    }
    
    public void borrarAlumno(int id){
    
        String sql="DELETE FROM alumno WHERE id_alumno=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, id);
            ps.executeUpdate();
            
            ps.close();
         
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al borrar Alumno");
        }
        
    }
*/
