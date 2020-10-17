
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import entidades.Materia;


public class MateriaData {
    private Connection con;
    
    public MateriaData(Conexion conexion){
    
        con=conexion.getConnection();
    }
    
    public void agregarMateria(Materia materia){
    
        String sql="INSERT into materia (nombre_materia)"
                 + "VALUES(?);";
        
        try{
        
        PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1,materia.getNombreMateria());
        
               
        ps.executeUpdate();
        
        ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                materia.setIdMateria(rs.getInt(1));
            } else {
                JOptionPane.showMessageDialog(null,"No puedo obtener id");
            }
       
        con.close();
        }catch(SQLException e){
        
            JOptionPane.showMessageDialog(null,"Error al crear la materia");
        }
       
    }
    
}
