
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author crist
 */
public class SQLUsuario {
    
    public boolean registrar(Usuario usuario){
    
        Conexion con = new Conexion();
        PreparedStatement ps=null;
        
        
        
        try{
        Connection conexion = con.getConnection();
            
        ps = conexion.prepareStatement("insert into usuarios (nombreUsuario, nombres, apellidos, idTipoUsuario, correo,pasword,nombreRol) values(?,?,?,?,?,?,?)");
        
        ps.setString(1, usuario.getNombreUsuario());
        ps.setString(2, usuario.getNombres());
        ps.setString(3, usuario.getApellidos());
        ps.setInt(4, usuario.getIdTipoUsuario());
        ps.setString(5, usuario.getCorreo());
        ps.setString(6, usuario.getPasword());
        ps.setString(7, usuario.getNombreRol());
        ps.executeUpdate();
        return true;
            
        
            
        }catch(Exception ex){
            System.err.println("ERROR EN SQLUsuario "+ex );
        return false;
        }
           
    }
    
    
    
    
    
    public int verificar(String usuario){
    
        Conexion con = new Conexion();
        PreparedStatement ps=null;
        ResultSet rs= null;
        
        
        try{
        Connection conexion = con.getConnection();
            
        ps= conexion.prepareStatement("select count(idUsuario) from usuarios where nombreUsuario =? " );
        
        ps.setString(1, usuario);
       
        
        rs= ps.executeQuery();
        
        
            if (rs.next()) {
                return rs.getInt(1);
            }else{
            
            return 1;
            }
            
        
            
        }catch(Exception ex){
            System.err.println("ERROR EN SQLUsuario verificacion "+ex );
        return 1;
        }
           
    }
    
    
    
    public boolean comprobarEmail (String correo){
    
        Pattern patron = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        
        Matcher matcher = patron.matcher(correo);
        
        return matcher.find();
    }
    
    
    
    
      public boolean iniciar (Usuario usuario){
    
        Conexion con = new Conexion();
        PreparedStatement ps=null;
        ResultSet rs= null;
        
        
        try{
        Connection conexion = con.getConnection();
            
       ps = conexion.prepareStatement("SELECT idUsuario, nombreUsuario, nombres, apellidos, idTipoUsuario, correo, pasword,nombreRol FROM usuarios WHERE nombreUsuario=?");
        
        ps.setString(1, usuario.getNombreUsuario());
       
        
        rs= ps.executeQuery();
        
        
            if (rs.next()) {
                 if (usuario.getPasword().equals(rs.getString("pasword"))) {
                ps = conexion.prepareStatement("update usuarios  set ultimaConexion =? where idUsuario =?");
                ps.setString(1, usuario.getUltimaConexion());
                ps.setInt(2, rs.getInt("idUsuario"));
                ps.executeUpdate();
                
               
                    usuario.setIdusuarios(rs.getInt("idUsuario"));
                    usuario.setNombres(rs.getString("nombres"));
                    usuario.setApellidos(rs.getString("apellidos"));
                    usuario.setCorreo(rs.getString("correo"));
                    usuario.setIdTipoUsuario(rs.getInt("idTipoUsuario"));
                    usuario.setNombreRol(rs.getString("nombreRol"));
                    
                    
                    return true;
                }else{
                
                return false;
                }
                
            }else{
            
            return false;
            }
            
        
            
        }catch(Exception ex){
            System.err.println("ERROR EN SQLUsuario verificacion "+ex );
        return false;
        }
           
    }
    
    
    
}
