/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Modelo.CifrarContraseña;
import Modelo.SQLUsuario;
import Modelo.Usuario;
import com.formdev.flatlaf.FlatDarculaLaf;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author crist
 */
public class Registro extends javax.swing.JFrame {

    /**
     * Creates new form Registro
     */
    public Registro() {
        initComponents();
        setTitle("Registro Usuarios");
        setSize(550, 550);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    
     private void limpiarCajas() {

        cajaNombreUsuario.setText("");
        cajaNombres.setText("");
        cajaCorreo.setText("");
        cajaConfirmarPasword.setText("");
        cajaPasword.setText("");
        cajaApellidos.setText("");
    }
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRegistro = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cajaNombreUsuario = new javax.swing.JTextField();
        cajaNombres = new javax.swing.JTextField();
        cajaApellidos = new javax.swing.JTextField();
        cajaCorreo = new javax.swing.JTextField();
        cajaPasword = new javax.swing.JPasswordField();
        cajaConfirmarPasword = new javax.swing.JPasswordField();
        botonRegistrar = new javax.swing.JButton();
        comboTipoUsuario = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jCalendar1 = new com.toedter.calendar.JCalendar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelRegistro.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Nombre Usuario: ");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Nombres: ");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Apellidos: ");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Correo: ");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("Contraseña: ");

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setText("<html>Confirmar Contraseña: </html> ");

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setText("Tipo de Usuario: ");

        cajaNombreUsuario.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        cajaNombres.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        cajaApellidos.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        cajaCorreo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cajaCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajaCorreoActionPerformed(evt);
            }
        });

        cajaPasword.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        cajaConfirmarPasword.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        botonRegistrar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        botonRegistrar.setText("Registrar");
        botonRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegistrarActionPerformed(evt);
            }
        });

        comboTipoUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "General" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cajaConfirmarPasword)
                            .addComponent(cajaNombreUsuario)
                            .addComponent(cajaNombres)
                            .addComponent(cajaApellidos)
                            .addComponent(cajaCorreo)
                            .addComponent(cajaPasword)
                            .addComponent(comboTipoUsuario, 0, 229, Short.MAX_VALUE))
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(botonRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(146, 146, 146))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(cajaNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(cajaNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(cajaApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(cajaCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cajaPasword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cajaConfirmarPasword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(comboTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(botonRegistrar)
                .addGap(20, 20, 20))
        );

        panelRegistro.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 450, 370));

        jLabel9.setIcon(new javax.swing.ImageIcon("C:\\Users\\crist\\Desktop\\Trabajos\\JavaSpringNet\\SuperMercadoMaven\\src\\main\\java\\Imagenes\\login.png")); // NOI18N
        panelRegistro.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, 88, 91));
        panelRegistro.add(jCalendar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 130, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRegistro, javax.swing.GroupLayout.DEFAULT_SIZE, 801, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRegistro, javax.swing.GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cajaCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cajaCorreoActionPerformed

    private void botonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegistrarActionPerformed
       
        Usuario usuario = new Usuario();
        SQLUsuario sqlUsuario = new SQLUsuario();

        String pasword = new String(cajaPasword.getPassword());
        String confirmarPasword = new String(cajaConfirmarPasword.getPassword());

        if (cajaNombreUsuario.getText().equals("")
                || pasword.equals("")
                || confirmarPasword.equals("")
                || cajaNombreUsuario.getText().equals("")
                || cajaCorreo.getText().equals("")) {
           
            JOptionPane.showMessageDialog(null, "Por favor, completa todos los campos", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else {

            if (pasword.equals(confirmarPasword)) {

                if (sqlUsuario.verificar(cajaNombreUsuario.getText()) == 0) {
                    if (sqlUsuario.comprobarEmail(cajaCorreo.getText())) {

                        String nuevoPasword = CifrarContraseña.encrypt(pasword);

                        usuario.setNombreUsuario(cajaNombreUsuario.getText());
                        usuario.setPasword(nuevoPasword);
                        usuario.setNombres(cajaNombres.getText());
                        usuario.setApellidos(cajaApellidos.getText());
                        usuario.setCorreo(cajaCorreo.getText());
                       
                        if(comboTipoUsuario.getSelectedIndex() == 0){
                            usuario.setIdTipoUsuario(1);
                            usuario.setNombreRol(String.valueOf(comboTipoUsuario.getSelectedItem()));
                        }else{
                        usuario.setIdTipoUsuario(2);
                        usuario.setNombreRol(String.valueOf(comboTipoUsuario.getSelectedItem()));
                        }
                        
                        if (sqlUsuario.registrar(usuario)) {
                            JOptionPane.showMessageDialog(null, "Registro Correcto");
                            limpiarCajas();  

                        } else {
                            JOptionPane.showMessageDialog(null, "Error  al registrar Usuario", "Advertencia", JOptionPane.WARNING_MESSAGE);
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "Error  correo de Usuario no valido", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    }
                } else {

                    JOptionPane.showMessageDialog(null, "El usuario ya no esta disponible", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }

            } else {

                JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }

        }

        
        
        
        
    }//GEN-LAST:event_botonRegistrarActionPerformed

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
                new Registro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonRegistrar;
    private javax.swing.JTextField cajaApellidos;
    private javax.swing.JPasswordField cajaConfirmarPasword;
    private javax.swing.JTextField cajaCorreo;
    private javax.swing.JTextField cajaNombreUsuario;
    private javax.swing.JTextField cajaNombres;
    private javax.swing.JPasswordField cajaPasword;
    private javax.swing.JComboBox<String> comboTipoUsuario;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel panelRegistro;
    // End of variables declaration//GEN-END:variables
}
