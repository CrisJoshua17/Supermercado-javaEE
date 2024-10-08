
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author crist
 */
public class Conexion {
    
     public static final String URL = "jdbc:mysql://localhost:3306/supermercado?autoReconnet=true&useSSL=false" ; 
        public static final String usuario = "root";
        public static final String contraseña = "Haikyuu2024";
        
         public Connection getConnection(){
        
            Connection conexion = null;
            
            try{
            
                Class.forName("com.mysql.cj.jdbc.Driver");
                conexion = (Connection) DriverManager.getConnection(URL, usuario,contraseña);
                
                
            } catch (Exception ex){
            
                System.err.println("Error"+ex);
            }
        return conexion;
        }

          
          
          
         
         
         
    
}
