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
public class BusquedaTickets extends javax.swing.JPanel {

   
    public BusquedaTickets() {
        initComponents();
        
    }
    
    
     
   private void actualizar() {
    DefaultTableModel modeloTabla = new DefaultTableModel();
    tablaTickets.setModel(modeloTabla);

    PreparedStatement ps = null;
    ResultSet rs = null;
    String campo = cajaBuscar.getText().trim();
    String where = "";

    // Determinar el criterio de búsqueda basado en el combo box
    if (!campo.isEmpty()) {
        if (comboBusqueda.getSelectedIndex() == 0) {
            where = "WHERE t.idTicket = ?";
        } else if (comboBusqueda.getSelectedIndex() == 1) {
            where = "WHERE t.idUsuario = ?";
        }
    }

    try {
        Conexion con = new Conexion();
        Connection conexion = con.getConnection();
    
        String sql = "SELECT t.idUsuario, t.idTicket, t.total, p.codigoBarras, " +
             "p.nombreProducto, tp.cantidad, t.fecha " +
             "FROM tickets t " +
             "INNER JOIN ticket_products tp ON tp.idTicket = t.idTicket " + // Cambiado el orden de los JOINs
             "INNER JOIN producto p ON p.codigoBarras = tp.codigoBarras " + 
             where;

        ps = conexion.prepareStatement(sql);

        // Si hay un valor en la caja de búsqueda, setear el parámetro en la consulta
        if (!campo.isEmpty()) {
            if (comboBusqueda.getSelectedIndex() == 0) {
                ps.setInt(1, Integer.parseInt(campo));
            } else if (comboBusqueda.getSelectedIndex() == 1) {
                ps.setString(1, campo);
            }
        }

        rs = ps.executeQuery();

        // Añadir columnas al modelo de la tabla
        modeloTabla.addColumn("idUsuario");
        modeloTabla.addColumn("idTicket");
        modeloTabla.addColumn("total");
        modeloTabla.addColumn("codigoBarras");
        modeloTabla.addColumn("nombreProducto");
        modeloTabla.addColumn("cantidad");
        modeloTabla.addColumn("fecha");

        ResultSetMetaData rsMD = rs.getMetaData();
        int cantidadColumnas = rsMD.getColumnCount();

        // Ajustar los anchos de las columnas
        int[] anchos = {100, 50, 100, 50, 100, 100, 100};
        for (int i = 0; i < cantidadColumnas; i++) {
            tablaTickets.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
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
        cajaBuscar = new javax.swing.JTextField();
        botonBuscar = new javax.swing.JButton();
        comboBusqueda = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaTickets = new javax.swing.JTable();

        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Busqueda de tickets.");

        botonBuscar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        botonBuscar.setText("Buscar");
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });

        comboBusqueda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Id  Ticket", "Id Usuario" }));

        tablaTickets.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "IdUsuario", "IdTicket", "Total", "Codigo Barras", "Nombre Producto", "Cantidad", "Fecha"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Byte.class, java.lang.Double.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
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
        jScrollPane1.setViewportView(tablaTickets);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addComponent(comboBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cajaBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(botonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 799, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 42, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cajaBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
        
       actualizar(); 
        
    }//GEN-LAST:event_botonBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonBuscar;
    private javax.swing.JTextField cajaBuscar;
    private javax.swing.JComboBox<String> comboBusqueda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaTickets;
    // End of variables declaration//GEN-END:variables
}
