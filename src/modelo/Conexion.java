
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Conexion {
    private final String base = "SmNTbTZ6Iq";
    private final String url="jdbc:mysql://remotemysql.com:3306/"+base;
    private final String user="SmNTbTZ6Iq";
    private final String pass="Qcx7ktWQXZ";
    private Connection con;
    
    public Connection getConnection()
    {
        if(con==null)
        {
            try
            {
                 Class.forName("org.mariadb.jdbc.Driver");
         
                con = (Connection)DriverManager.getConnection(url, user, pass);
            }
            catch (SQLException |ClassNotFoundException e)
            {
                JOptionPane.showMessageDialog(null, "Error al conectarse");
            }
        }
                return con;
    }

}
