/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vista;

import Modelo.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author crist
 */
public class PanelTabla extends javax.swing.JPanel {

    /**
     * Creates new form PanelTabla
     */
    public PanelTabla() {
        initComponents();
         setSize(800, 650);
    }

     private void actualizar(){
    DefaultTableModel modeloTabla = new DefaultTableModel();
    tablaProducto.setModel(modeloTabla);

    PreparedStatement ps = null;
    ResultSet rs = null;
    String campo = cajaBuscar.getText();
    String where = "";

    // Determinar el criterio de búsqueda basado en el combo box
    if (!campo.trim().isEmpty()) {
        if (comboSelec.getSelectedIndex() == 0) {
            where = " WHERE p.codigoBarras = ?";
        } else if (comboSelec.getSelectedIndex() == 1) {
            where = " WHERE p.tipoProducto = ?";
        }
    }

    try {
        Conexion con = new Conexion();
        Connection conexion = con.getConnection();

        String sql = "SELECT p.codigoBarras, p.nombreProducto, p.precioProducto, p.tipoProducto, " +
                     " pr.nombreProvedor " +
                     "FROM producto p "  +
                     "INNER JOIN provedores pr ON p.codigoBarras = pr.codigoBarras" + where;

        ps = conexion.prepareStatement(sql);

        // Si hay un valor en la caja de búsqueda, setear el parámetro en la consulta
        if (!campo.trim().isEmpty()) {
            if (comboSelec.getSelectedIndex() == 0) {
                ps.setInt(1, Integer.parseInt(campo));
            } else if (comboSelec.getSelectedIndex() == 1) {
                ps.setString(1, campo);
            }
        }

        rs = ps.executeQuery();

        // Añadir columnas al modelo de la tabla
        modeloTabla.addColumn("Código Barras");
        modeloTabla.addColumn("Nombre Producto");
        modeloTabla.addColumn("Precio Producto");
        modeloTabla.addColumn("Tipo Producto");
        modeloTabla.addColumn("Nombre Proveedor");

        ResultSetMetaData rsMD = rs.getMetaData();
        int cantidadColumnas = rsMD.getColumnCount();

        // Ajustar los anchos de las columnas
        int[] anchos = {80, 150, 50, 70, 150};
        for (int i = 0; i < cantidadColumnas; i++) {
            tablaProducto.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }

        // Rellenar la tabla con los datos
        while (rs.next()) {
            Object[] fila = new Object[cantidadColumnas];
            for (int i = 0; i < cantidadColumnas; i++) {
                fila[i] = rs.getObject(i + 1);
            }
            modeloTabla.addRow(fila);
        }

    } catch (Exception ex) {
        System.err.println("ERROR EN LA CONEXIÓN: " + ex);
    } finally {
        // Cerrar recursos
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
        } catch (Exception ex) {
            System.err.println("ERROR AL CERRAR RECURSOS: " + ex);
        }
    }
}
    
    private void limpiarCajas(){
        cajaBuscar.setText(null);
        cajaTipoProducto.setText(null);
        cajaCodigo.setText(null);
        cajaNombre.setText(null);
        cajaPrecio.setText(null);
        cajaNombreProvedor.setText(null);
    
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProducto = new javax.swing.JTable();
        botonCargar = new javax.swing.JButton();
        cajaBuscar = new javax.swing.JTextField();
        cajaCodigo = new javax.swing.JTextField();
        cajaNombre = new javax.swing.JTextField();
        cajaPrecio = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cajaTipoProducto = new javax.swing.JTextField();
        botonModificar = new javax.swing.JButton();
        comboSelec = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cajaNombreProvedor = new javax.swing.JTextField();

        setMaximumSize(new java.awt.Dimension(1000, 1000));
        setPreferredSize(new java.awt.Dimension(900, 495));

        tablaProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Codigo Barras", "Nombre", "Precio", "Tipo Producto", "Nombre Provedor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaProductoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaProducto);

        botonCargar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        botonCargar.setText("Cargar Tabla");
        botonCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCargarActionPerformed(evt);
            }
        });

        cajaBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajaBuscarActionPerformed(evt);
            }
        });

        cajaPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajaPrecioActionPerformed(evt);
            }
        });

        jLabel2.setText("Codigo: ");

        jLabel3.setText("Nombre: ");

        jLabel4.setText("Precio: ");

        jLabel5.setText("<html>Tipo Producto: </html> ");

        cajaTipoProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajaTipoProductoActionPerformed(evt);
            }
        });

        botonModificar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        botonModificar.setText("Modificar");
        botonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonModificarActionPerformed(evt);
            }
        });

        comboSelec.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        comboSelec.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Codigo Barras:", "Tipo Producto:" }));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setText("Modificador de Productos.");

        jLabel6.setText("<html>Nombre Provedor:</html>");

        cajaNombreProvedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajaNombreProvedorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(comboSelec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(cajaBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(botonCargar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 626, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE))
                                    .addComponent(jLabel4))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cajaNombreProvedor, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cajaTipoProducto)
                                            .addComponent(cajaPrecio)
                                            .addComponent(cajaNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(cajaCodigo)
                                                .addGap(4, 4, 4))))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(botonModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(54, 54, 54))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addComponent(jLabel2))
                                    .addComponent(cajaCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(cajaNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(cajaPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cajaTipoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cajaNombreProvedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(25, 25, 25)
                        .addComponent(botonModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(11, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cajaBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboSelec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonCargar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(64, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tablaProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProductoMouseClicked
        try{
            Conexion con = new Conexion();
            Connection conexion = con.getConnection();
            PreparedStatement ps = null;
            ResultSet rs= null;

            int fila = tablaProducto.getSelectedRow();
            int codigo = (int) tablaProducto.getValueAt(fila, 0);

            ps = conexion.prepareStatement("SELECT p.codigoBarras, p.nombreProducto, p.precioProducto, p.tipoProducto, " +
                     " pr.nombreProvedor " +
                     "FROM producto p "  +
                     "INNER JOIN provedores pr ON p.codigoBarras = pr.codigoBarras where p.codigoBarras=?");
            ps.setInt(1, codigo);
            rs= ps.executeQuery();

            while(rs.next()){

                cajaCodigo.setText(rs.getString("codigoBarras"));
                cajaNombre.setText(rs.getString("nombreProducto"));
                cajaTipoProducto.setText(rs.getString("tipoProducto"));
                cajaPrecio.setText(String.valueOf(rs.getDouble("precioProducto")));
                cajaNombreProvedor.setText(rs.getString("nombreProvedor"));

            }

        }catch(Exception ex){
            System.err.println("ERROR "+ ex);
        }
    }//GEN-LAST:event_tablaProductoMouseClicked

    private void botonCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCargarActionPerformed

        actualizar();
    }//GEN-LAST:event_botonCargarActionPerformed

    private void botonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonModificarActionPerformed
     PreparedStatement ps = null;
    PreparedStatement ps2 = null;
    
    Connection conexion = null;

    try {
        Conexion con = new Conexion();
        conexion = con.getConnection();
        conexion.setAutoCommit(false);

        // Actualizar producto
        ps = conexion.prepareStatement("UPDATE producto SET nombreProducto=?, precioProducto=?, tipoProducto=? WHERE codigoBarras=?");
        ps.setString(1, cajaNombre.getText());
        ps.setDouble(2, Double.parseDouble(cajaPrecio.getText()));
        ps.setString(3, cajaTipoProducto.getText());
        ps.setInt(4, Integer.parseInt(cajaCodigo.getText()));

        // Actualizar provedores
        ps2 = conexion.prepareStatement("UPDATE provedores SET nombreProvedor=? WHERE codigoBarras=?");
        ps2.setString(1, cajaNombreProvedor.getText());
        ps2.setInt(2, Integer.parseInt(cajaCodigo.getText()));

        ps.executeUpdate();
        ps2.executeUpdate();

        // Confirmar la transacción
        conexion.commit();

        JOptionPane.showMessageDialog(null, "Registro modificado correctamente");
        limpiarCajas();
        actualizar();

    } catch (Exception ex) {
        System.err.println("ERROR " + ex);
        try {
            if (conexion != null) {
                conexion.rollback();
            }
        } catch (SQLException e) {
            System.err.println("ERROR AL HACER ROLLBACK " + e);
        }
    } finally {
        try {
            if (ps != null) ps.close();
            if (ps2 != null) ps2.close();
            if (conexion != null) conexion.setAutoCommit(true);
        } catch (SQLException e) {
            System.err.println("ERROR AL CERRAR RECURSOS " + e);
        }
    }
    }//GEN-LAST:event_botonModificarActionPerformed

    private void cajaBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cajaBuscarActionPerformed

    private void cajaTipoProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaTipoProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cajaTipoProductoActionPerformed

    private void cajaNombreProvedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaNombreProvedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cajaNombreProvedorActionPerformed

    private void cajaPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cajaPrecioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCargar;
    private javax.swing.JButton botonModificar;
    private javax.swing.JTextField cajaBuscar;
    private javax.swing.JTextField cajaCodigo;
    private javax.swing.JTextField cajaNombre;
    private javax.swing.JTextField cajaNombreProvedor;
    private javax.swing.JTextField cajaPrecio;
    private javax.swing.JTextField cajaTipoProducto;
    private javax.swing.JComboBox<String> comboSelec;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaProducto;
    // End of variables declaration//GEN-END:variables
}
