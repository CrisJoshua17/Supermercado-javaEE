/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Modelo.CifrarContraseña;
import Modelo.Conexion;
import Modelo.SQLUsuario;
import Modelo.Usuario;
import Modelo.UsuarioSesion;
import com.formdev.flatlaf.FlatDarculaLaf;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author crist
 */
public class InicioSesion extends javax.swing.JFrame {

    /**
     * Creates new form InicioSesion
     */
    public InicioSesion() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
    }

    
    
    
    public void ObtenerUsuario(){
         Conexion con = new Conexion();
    Connection conexion = con.getConnection();
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        String nombreUsuario = cajaUsuario.getText();
        System.out.println("Buscando usuario: " + nombreUsuario);

        ps = conexion.prepareStatement("SELECT idUsuario, nombres, apellidos, idTipoUsuario, ultimaConexion, correo, nombreRol FROM usuarios WHERE nombreUsuario = ?");
        ps.setString(1, nombreUsuario);
        rs = ps.executeQuery();

        if (rs.next()) { // Mover el cursor al primer registro
            UsuarioSesion usuarioSesion = UsuarioSesion.getInstancia();
            usuarioSesion.setIdusuarios(rs.getInt("idUsuario"));
            usuarioSesion.setNombreUsuario(nombreUsuario);
            usuarioSesion.setNombres(rs.getString("nombres"));
            usuarioSesion.setApellidos(rs.getString("apellidos"));
            usuarioSesion.setIdTipoUsuario(rs.getInt("idTipoUsuario"));
            usuarioSesion.setUltimaConexion(rs.getString("ultimaConexion"));
            usuarioSesion.setCorreo(rs.getString("correo"));
            usuarioSesion.setNombreRol(rs.getString("nombreRol"));

            System.out.println("Usuario encontrado: " + usuarioSesion.getIdusuarios());
        } else {
            System.out.println("Usuario no encontrado");
        }

    } catch (Exception ex) {
        System.out.println("Error obteniendo el idUsuario: " + ex);
    } finally {
        // Cerrar recursos
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (conexion != null) conexion.close();
        } catch (Exception ex) {
            System.out.println("Error cerrando recursos: " + ex);
        }
    }
    }
    
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cajaUsuario = new javax.swing.JTextField();
        cajaPasword = new javax.swing.JPasswordField();
        botonIniciar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\crist\\Desktop\\Trabajos\\JavaSpringNet\\SuperMercadoMaven\\src\\main\\java\\Imagenes\\login.png")); // NOI18N
        panel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, 88, 91));

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Usuario: ");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Contraseña: ");

        cajaUsuario.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cajaUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajaUsuarioActionPerformed(evt);
            }
        });

        cajaPasword.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cajaPasword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajaPaswordActionPerformed(evt);
            }
        });

        botonIniciar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        botonIniciar.setForeground(new java.awt.Color(0, 0, 0));
        botonIniciar.setText("Iniciar Sesión");
        botonIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonIniciarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(cajaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cajaPasword)))
                .addContainerGap(41, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cajaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cajaPasword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(botonIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        panel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 340, 260));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonIniciarActionPerformed
          Usuario usuario = new Usuario();
    SQLUsuario sql = new SQLUsuario();
    Date date = new Date();
    DateFormat fechaHora = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    String contraseña = new String(cajaPasword.getPassword());

    if (cajaUsuario.getText().equals("") || (contraseña.equals(""))) {
        JOptionPane.showMessageDialog(null, "Por favor, completa todos los campos", "Advertencia", JOptionPane.WARNING_MESSAGE);
    } else {
        String nuevaContraseña = CifrarContraseña.encrypt(contraseña);
        usuario.setNombreUsuario(cajaUsuario.getText());
        usuario.setPasword(nuevaContraseña);
        usuario.setUltimaConexion(fechaHora.format(date));

        if (sql.iniciar(usuario)) {
            ObtenerUsuario();
            UsuarioSesion usuarioSesion = UsuarioSesion.getInstancia();

            this.dispose();

            if ("Administrador".equals(usuarioSesion.getNombreRol())) {
                Principal principal = new Principal();
                principal.setVisible(true);
            } else {
                Secundario secundario = new Secundario();
                secundario.setVisible(true);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Los Datos de Inicio son incorrectos", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }
    }//GEN-LAST:event_botonIniciarActionPerformed

    private void cajaUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaUsuarioActionPerformed
        
    }//GEN-LAST:event_cajaUsuarioActionPerformed

    private void cajaPaswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaPaswordActionPerformed
       
    }//GEN-LAST:event_cajaPaswordActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
       try {
            UIManager.setLookAndFeel(new FlatDarculaLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new InicioSesion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonIniciar;
    private javax.swing.JPasswordField cajaPasword;
    private javax.swing.JTextField cajaUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel panel1;
    // End of variables declaration//GEN-END:variables
}
