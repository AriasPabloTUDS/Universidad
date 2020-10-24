
package modelo;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import entidades.Alumno;
import java.util.logging.Logger;




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
     public void actualizarAlumno(Alumno alumno) {

        try {
            String sql = "UPDATE alumno SET nombre_alumno=?, fn_alumno=?, activo=? WHERE id_alumno=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, alumno.getNombre_alumno());
            ps.setDate(2, Date.valueOf(alumno.getFn_alumno()));
            ps.setBoolean(3, alumno.isActivo());
            ps.setInt(4, alumno.getId_alumno());

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
            
            JOptionPane.showMessageDialog(null, "Error al borrar Alumno");
        }
        
     }
}

     
