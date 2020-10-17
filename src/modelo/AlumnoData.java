
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
        
        ps.executeUpdate();
        
        ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                alumno.setId_alumno(rs.getInt(1));
            } else {
                JOptionPane.showMessageDialog(null,"No puedo obtener id");
            }
       
        con.close();
        }catch(SQLException e){
        
            JOptionPane.showMessageDialog(null,"Error al guardar Alumno");
        }
       
    }
    
}
