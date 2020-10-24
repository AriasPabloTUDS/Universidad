package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import entidades.Materia;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MateriaData {

    private Connection con;

    public MateriaData(Conexion conexion) {

        con = conexion.getConnection();
    }

    public void agregarMateria(Materia materia) {

        String sql = "INSERT into materia (nombre_materia)"
                + "VALUES(?);";

        try {

            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, materia.getNombreMateria());

            ps.executeQuery();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                materia.setIdMateria(rs.getInt(1));
            } else {
                JOptionPane.showMessageDialog(null, "No puedo obtener id");
            }

            con.close();
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

  
    public void quitarMateria(int id){
        
        String sql = "DELETE FROM materia WHERE id_materia=?";
        
        try{
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
          JOptionPane.showMessageDialog(null, "Materia Borrada");
            ps.close();
            con.close();
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "No se pudo borrar la Materia", "Error!", JOptionPane.WARNING_MESSAGE);
        }
    }
         public void modificarMateria(Materia materia) {

        try {
            String sql = "UPDATE materia SET nombre_materia=? WHERE id_materia=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, materia.getNombreMateria());
            ps.setInt(2, materia.getIdMateria());

            ps.executeUpdate();
            ps.close();
           
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Error al actualizar Alumno");
        }
    }
    
    
        
    }



