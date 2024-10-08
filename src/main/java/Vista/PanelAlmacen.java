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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author crist
 */
public class PanelAlmacen extends javax.swing.JPanel {

    /**
     * Creates new form PanelAlmacen
     */
    public PanelAlmacen() {
        initComponents();
        }
  
    
    
    
    private void actualizar(){
    DefaultTableModel modeloTabla = new DefaultTableModel();
    tablaAlmacen.setModel(modeloTabla);

    PreparedStatement ps = null;
    ResultSet rs = null;
    String campo = cajaBuscar.getText().trim();
    String where = "";

    // Determinar el criterio de búsqueda basado en el combo box
    if (!campo.isEmpty()) {
        if (comboSelect.getSelectedIndex() == 0) {
            where = "WHERE p.codigoBarras = ?";
        } else if (comboSelect.getSelectedIndex() == 1) {
            where = "WHERE p.tipoProducto = ?";
        }
    }

    try {
        Conexion con = new Conexion();
        Connection conexion = con.getConnection();

        String sql = "SELECT p.codigoBarras, p.nombreProducto, p.precioProducto, p.tipoProducto, " +
                "a.cantidadProducto, a.fechaLlegada, pr.nombreProvedor " +
                "FROM producto p " +
                "INNER JOIN almacen a ON p.codigoBarras = a.codigoBarras " +
                "INNER JOIN provedores pr ON p.codigoBarras = pr.codigoBarras " + where;

        ps = conexion.prepareStatement(sql);

        // Si hay un valor en la caja de búsqueda, setear el parámetro en la consulta
        if (!campo.isEmpty()) {
            if (comboSelect.getSelectedIndex() == 0) {
                ps.setInt(1, Integer.parseInt(campo));
            } else if (comboSelect.getSelectedIndex() == 1) {
                ps.setString(1, campo);
            }
        }

        rs = ps.executeQuery();

        // Añadir columnas al modelo de la tabla
        modeloTabla.addColumn("Codigo Barras");
        modeloTabla.addColumn("Nombre Producto");
        modeloTabla.addColumn("Precio Producto");
        modeloTabla.addColumn("Tipo Producto");
        modeloTabla.addColumn("Cantidad");
        modeloTabla.addColumn("Fecha Actualización");
        modeloTabla.addColumn("Nombre Provedor");

        ResultSetMetaData rsMD = rs.getMetaData();
        int cantidadColumnas = rsMD.getColumnCount();

        // Ajustar los anchos de las columnas
        int[] anchos = {100, 50, 100, 50, 100, 100, 100};
        for (int i = 0; i < cantidadColumnas; i++) {
            tablaAlmacen.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
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
   
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaAlmacen = new javax.swing.JTable();
        cajaBuscar = new javax.swing.JTextField();
        comboSelect = new javax.swing.JComboBox<>();
        botonBuscar = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Almacen");

        tablaAlmacen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Codigo de Barras", "Nombre Producto", "Precio Producto", "Tipo Producto", "Cantidad", "Fecha Actualizacion", "Nombre Provedor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaAlmacen);

        cajaBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajaBuscarActionPerformed(evt);
            }
        });

        comboSelect.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        comboSelect.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Codigo de Barras", "Tipo Producto" }));

        botonBuscar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(115, 115, 115)
                                .addComponent(comboSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cajaBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(57, 57, 57)
                                .addComponent(botonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 802, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 46, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cajaBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(49, 49, 49)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cajaBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cajaBuscarActionPerformed

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
        actualizar();
    }//GEN-LAST:event_botonBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonBuscar;
    private javax.swing.JTextField cajaBuscar;
    private javax.swing.JComboBox<String> comboSelect;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaAlmacen;
    // End of variables declaration//GEN-END:variables
}
