/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vista;

import Modelo.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author crist
 */
public class PanelMovimientos extends javax.swing.JPanel {

    public PanelMovimientos() {
        initComponents();
    }

    public void limpiarCajas() {
        cajaBusqueda.setText("");
        cajaCantidad.setText("");
        cajaCodigo.setText("");
        cajaNombreProduct.setText("");
        cajaNombreProvedor.setText("");
        cajaPrecioProduct.setText("");
        cajaTipoProduct.setText("");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cajaCodigo = new javax.swing.JTextField();
        cajaNombreProduct = new javax.swing.JTextField();
        cajaTipoProduct = new javax.swing.JTextField();
        cajaPrecioProduct = new javax.swing.JTextField();
        cajaNombreProvedor = new javax.swing.JTextField();
        cajaCantidad = new javax.swing.JTextField();
        botonInserta = new javax.swing.JButton();
        botonBorrar = new javax.swing.JButton();
        comboBusqueda = new javax.swing.JComboBox<>();
        cajaBusqueda = new javax.swing.JTextField();
        jCalendar1 = new com.toedter.calendar.JCalendar();
        botonBuscar = new javax.swing.JButton();
        jProgressBar1 = new javax.swing.JProgressBar();

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setText("Movimientos Productos");

        jLabel2.setText("Codigo de Barras: ");

        jLabel3.setText("Nombre Producto: ");

        jLabel4.setText("Tipo Producto:");

        jLabel5.setText("Nombre Provedor: ");

        jLabel7.setText("Precio Producto: ");

        jLabel8.setText("Cantidad:");

        cajaPrecioProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajaPrecioProductActionPerformed(evt);
            }
        });

        botonInserta.setText("Insertar");
        botonInserta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonInsertaActionPerformed(evt);
            }
        });

        botonBorrar.setText("Borrar");
        botonBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBorrarActionPerformed(evt);
            }
        });

        comboBusqueda.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        comboBusqueda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Codigo de Barras:", "Nombre Producto:" }));

        cajaBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajaBusquedaActionPerformed(evt);
            }
        });

        botonBuscar.setText("Buscar");
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cajaNombreProvedor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cajaCantidad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(comboBusqueda, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cajaCodigo)
                                    .addComponent(cajaNombreProduct)
                                    .addComponent(cajaTipoProduct)
                                    .addComponent(cajaPrecioProduct)
                                    .addComponent(cajaBusqueda, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(botonInserta, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(89, 89, 89)
                                .addComponent(botonBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(110, 110, 110))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(292, 292, 292))))
            .addGroup(layout.createSequentialGroup()
                .addGap(210, 210, 210)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cajaBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cajaCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cajaNombreProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cajaTipoProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cajaPrecioProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cajaNombreProvedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cajaCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonInserta, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cajaPrecioProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaPrecioProductActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cajaPrecioProductActionPerformed

    private void cajaBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaBusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cajaBusquedaActionPerformed

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
        try {
            Conexion con = new Conexion();
            Connection conexion = con.getConnection();
            PreparedStatement ps = null;
            ResultSet rs = null;
            String campo = cajaBusqueda.getText();
            String where = "";
            int select = comboBusqueda.getSelectedIndex();

            if (!campo.trim().isEmpty()) {
                if (comboBusqueda.getSelectedIndex() == 0) {
                    where = "WHERE p.codigoBarras = ?";
                } else if (comboBusqueda.getSelectedIndex() == 1) {
                    where = "WHERE p.nombreProducto = ?";
                }

                ps = conexion.prepareStatement("SELECT p.nombreProducto, p.precioProducto, p.tipoProducto, p.codigoBarras,"
                        + " a.cantidadProducto, m.nombreProvedor "
                        + "FROM producto p "
                        + "INNER JOIN almacen a ON p.codigoBarras =a.codigoBarras "
                        + "INNER JOIN provedores m ON p.codigoBarras = m.codigoBarras " + where);
                ps.setString(1, campo);
                rs = ps.executeQuery();
            }

            while (rs.next()) {

                cajaCodigo.setText(rs.getString("p.codigoBarras"));
                cajaNombreProduct.setText(rs.getString("p.nombreProducto"));
                cajaPrecioProduct.setText(String.valueOf(rs.getDouble("p.precioProducto")));
                cajaCantidad.setText(String.valueOf(rs.getInt("a.cantidadProducto")));
                cajaNombreProvedor.setText(rs.getString("m.nombreProvedor"));
                cajaTipoProduct.setText(rs.getString("p.tipoProducto"));
            }

        } catch (Exception ex) {
            System.err.println("ERROR llenado de cajas" + ex);
        }
    }

    {

    }//GEN-LAST:event_botonBuscarActionPerformed

    private void botonInsertaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonInsertaActionPerformed

        java.util.Date now = new java.util.Date();
        Timestamp timestamp = new Timestamp(now.getTime());

        PreparedStatement ps = null;
        PreparedStatement ps2 = null;
        PreparedStatement ps3 = null;
        Connection conexion = null;

        try {
            Conexion con = new Conexion();
            conexion = con.getConnection();

            // Iniciar la transacción
            conexion.setAutoCommit(false);

            // Insertar en producto
            ps = conexion.prepareStatement("INSERT INTO producto (codigoBarras, nombreProducto, precioProducto, TipoProducto) VALUES (?, ?, ?, ?)");
            ps.setInt(1, Integer.parseInt(cajaCodigo.getText()));
            ps.setString(2, cajaNombreProduct.getText());
            ps.setDouble(3, Double.parseDouble(cajaPrecioProduct.getText()));
            ps.setString(4, cajaTipoProduct.getText());
            ps.executeUpdate();

            // Insertar en almacen
            ps2 = conexion.prepareStatement("INSERT INTO almacen (codigoBarras, cantidadProducto,fechaLlegada) VALUES (?, ?,?)");
            ps2.setInt(1, Integer.parseInt(cajaCodigo.getText()));
            ps2.setInt(2, Integer.parseInt(cajaCantidad.getText()));
            ps2.setTimestamp(3, timestamp);
            ps2.executeUpdate();

            // Insertar en provedores
            ps3 = conexion.prepareStatement("INSERT INTO provedores (codigoBarras, nombreProvedor) VALUES (?, ?)");
            ps3.setInt(1, Integer.parseInt(cajaCodigo.getText()));
            ps3.setString(2, cajaNombreProvedor.getText());
            ps3.executeUpdate();

            // Confirmar la transacción
            conexion.commit();

            JOptionPane.showMessageDialog(null, "Registro insertado correctamente");
            limpiarCajas();
        } catch (Exception ex) {
            System.err.println("ERROR en insertar: " + ex);
            try {
                if (conexion != null) {
                    conexion.rollback();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } finally {
            // Cerrar recursos
            try {
                if (ps != null) {
                    ps.close();
                }
                if (ps2 != null) {
                    ps2.close();
                }
                if (ps3 != null) {
                    ps3.close();
                }
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException ex) {
                System.err.println("ERROR al cerrar recursos: " + ex);
            }
        }

    }//GEN-LAST:event_botonInsertaActionPerformed

    private void botonBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBorrarActionPerformed
 PreparedStatement ps = null;
    Connection conexion = null;

    try {
        Conexion con = new Conexion();
        conexion = con.getConnection();

        // Iniciar la transacción
        conexion.setAutoCommit(false);

        // Eliminar de provedores
        ps = conexion.prepareStatement("DELETE FROM provedores WHERE codigoBarras = ?");
        ps.setInt(1, Integer.parseInt(cajaCodigo.getText()));
        ps.executeUpdate();

        // Eliminar de almacen
        ps = conexion.prepareStatement("DELETE FROM almacen WHERE codigoBarras = ?");
        ps.setInt(1, Integer.parseInt(cajaCodigo.getText()));
        ps.executeUpdate();

        // Eliminar de producto
        ps = conexion.prepareStatement("DELETE FROM producto WHERE codigoBarras = ?");
        ps.setInt(1, Integer.parseInt(cajaCodigo.getText()));
        ps.executeUpdate();

        // Confirmar la transacción
        conexion.commit();

        JOptionPane.showMessageDialog(null, "Registro eliminado correctamente");
        limpiarCajas();
    } catch (Exception ex) {
        System.err.println("ERROR en eliminar: " + ex);
        try {
            if (conexion != null) {
                conexion.rollback();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } finally {
        // Cerrar recursos
        try {
            if (ps != null) {
                ps.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        } catch (SQLException ex) {
            System.err.println("ERROR al cerrar recursos: " + ex);
        }
    }

    }//GEN-LAST:event_botonBorrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonBorrar;
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonInserta;
    private javax.swing.JTextField cajaBusqueda;
    private javax.swing.JTextField cajaCantidad;
    private javax.swing.JTextField cajaCodigo;
    private javax.swing.JTextField cajaNombreProduct;
    private javax.swing.JTextField cajaNombreProvedor;
    private javax.swing.JTextField cajaPrecioProduct;
    private javax.swing.JTextField cajaTipoProduct;
    private javax.swing.JComboBox<String> comboBusqueda;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JProgressBar jProgressBar1;
    // End of variables declaration//GEN-END:variables
}
