/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Modelo.Conexion;
import Modelo.Product;
import Modelo.UsuarioSesion;
import com.formdev.flatlaf.FlatDarculaLaf;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author crist
 */
public class Secundario extends javax.swing.JFrame {

    /**
     * Creates new form Secundario
     */
    public Secundario() {
        initComponents();
        setResizable(false);
        setSize(1400, 650);
         elementos = new ArrayList<>();
        products = new ArrayList<>();
        setLocationRelativeTo(null);
    }

   
   
   private ArrayList<String> elementos;
    private Double totalTicket =0.0;
    private LocalDateTime date = LocalDateTime.now();
    private DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    private String fechaFormateada =date.format(formateador);
    private List<Product> products;
    private int cantidadAlmacen;
    private boolean cambio=false;
    private PanelAlmacen panelAlmacen;
        
       
    
    
     
    

    private void agregarTexto(String texto){
    elementos.add(texto);
    actualizarTextArea();
    }
    
    
    
    private void actualizarTextArea(){
    areaTexto.setText("");
    for (String elemento : elementos) {
        areaTexto.append(elemento + "\n");
    }
    }
    
    private void eliminarUltimoTexto(){
        if (!elementos.isEmpty()) {
            elementos.remove(elementos.size()-1);
            actualizarTextArea();
        }
    
    }
    
    private void eliminarUltimoTexto1() {
     if (!elementos.isEmpty() && !products.isEmpty()) {
        elementos.remove(elementos.size() - 1);

        // Eliminar el último producto añadido
        Product ultimoProducto = products.remove(products.size() - 1);

        // Restar el precio del producto eliminado al total
        totalTicket -= ultimoProducto.getPrecioProducto() * ultimoProducto.getCantidad();

        actualizarTextArea();
    }
}
   
    private void restarAlmacen(int codigoBarras){
     Conexion con = new Conexion();
    Connection conexion = con.getConnection();
    PreparedStatement ps = null;
    ResultSet rs = null;
     
        try {
            ps= conexion.prepareStatement("SELECT cantidadProducto FROM almacen WHERE codigoBarras =?");
            ps.setInt(1, codigoBarras);
            rs = ps.executeQuery();
            if(rs.next()){
            cantidadAlmacen =rs.getInt("cantidadProducto");
            }
        } catch (Exception e) {
        }
    
     }
    
    
    
    
    private void agregarProducto(int codigoBarras) {
    Conexion con = new Conexion();
    Connection conexion = con.getConnection();
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        ps = conexion.prepareStatement("SELECT nombreProducto, precioProducto, tipoProducto FROM producto WHERE codigoBarras = ?");
        ps.setInt(1, codigoBarras);
        rs = ps.executeQuery();

        if (rs.next()) {
            String nombreProducto = rs.getString("nombreProducto");
            double precioProducto = rs.getDouble("precioProducto");
            String tipoProducto = rs.getString("tipoProducto");

            // Buscar el producto en la lista
            boolean productoEncontrado = false;
            for (Product product : products) {
                if (product.getCodigoBarras() == codigoBarras) {
                    // Incrementar la cantidad si el producto ya existe
                    product.setCantidad(product.getCantidad() + 1);
                    productoEncontrado = true;
                    break;
                }
            }

            if (!productoEncontrado) {
                // Agregar el producto a la lista si no existe
                Product producto = new Product(codigoBarras, nombreProducto, precioProducto, tipoProducto, 1);
                products.add(producto);
            }
           
            // Mostrar información del producto
            etiquetaNombre.setText(nombreProducto);
            etiquetaPrecio.setText("$" + precioProducto + " pesos.");
            etiquetaTipo.setText(tipoProducto);

            // Agregar texto al área de texto
            String texto = "Nombre Producto: " + nombreProducto + "\n" + "Precio: " + precioProducto;
            agregarTexto(texto);
            totalTicket += precioProducto;
            cajaBusqueda.setText(null);
        } else {
            System.out.println("Producto no encontrado");
        }
    } catch (SQLException ex) {
        System.err.println("ERROR al obtener información del producto: " + ex);
    } finally {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (conexion != null) conexion.close();
        } catch (SQLException ex) {
            System.err.println("Error cerrando recursos: " + ex);
        }
    }
}
    
    
    

// Método para insertar datos en la base de datos
    private void insertarTicketEnBaseDeDatos() {
    Conexion con = new Conexion();
    Connection conexion = con.getConnection();
    PreparedStatement ps = null;
    PreparedStatement ps2 = null;
    PreparedStatement ps3 = null;

    try {
        // Desactivar autocommit para manejar transacciones manualmente
        conexion.setAutoCommit(false);

        // Insertar en la tabla tickets y obtener el ID generado
        ps = conexion.prepareStatement("INSERT INTO tickets (idUsuario, total) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
        UsuarioSesion usuarioSesion = UsuarioSesion.getInstancia();
        int idUsuario = usuarioSesion.getIdusuarios();
        ps.setInt(1, idUsuario);
        ps.setDouble(2, totalTicket);
        ps.executeUpdate();

        ResultSet generatedKeys = ps.getGeneratedKeys();
        int idTicket = 0;
        if (generatedKeys.next()) {
            idTicket = generatedKeys.getInt(1);
        }

        // Insertar en la tabla ticket_products
        ps2 = conexion.prepareStatement("INSERT INTO ticket_products (idTicket, codigoBarras, cantidad) VALUES (?, ?, ?)");
        for (Product product : products) {
            ps2.setInt(1, idTicket);
            ps2.setInt(2, product.getCodigoBarras());
            ps2.setInt(3, product.getCantidad());
            ps2.executeUpdate();

            // Restar la cantidad en la tabla almacen
            ps3 = conexion.prepareStatement("UPDATE almacen SET cantidadProducto = cantidadProducto - ? WHERE codigoBarras = ?");
            ps3.setInt(1, product.getCantidad());
            ps3.setInt(2, product.getCodigoBarras());
            ps3.executeUpdate();
        }

        // Confirmar la transacción
        conexion.commit();

        // Mostrar el ID del ticket al final del mensaje
        elementos.add("ID del Ticket: " + idTicket + "\nEl total de su compra fue: " + totalTicket + "\n" + fechaFormateada + "\nGracias por su compra. ¡Vuelva Pronto!");
        actualizarTextArea();
    } catch (SQLException ex) {
        // Revertir la transacción en caso de error
        try {
            if (conexion != null) {
                conexion.rollback();
            }
        } catch (SQLException rollbackEx) {
            System.err.println("ERROR al hacer rollback: " + rollbackEx);
        }
        System.err.println("ERROR al insertar ticket: " + ex);
    } finally {
        // Restaurar el autocommit y cerrar recursos
        try {
            if (conexion != null) {
                conexion.setAutoCommit(true);
            }
            if (ps != null) ps.close();
            if (ps2 != null) ps2.close();
            if (ps3 != null) ps3.close();
            if (conexion != null) conexion.close();
        } catch (SQLException ex) {
            System.err.println("ERROR al cerrar la conexión: " + ex);
        }
    }
}

    
    
    
    
    
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelCaja = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cajaBusqueda = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        etiquetaNombre = new javax.swing.JLabel();
        etiquetaPrecio = new javax.swing.JLabel();
        etiquetaTipo = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        botonBuscar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaTexto = new javax.swing.JTextArea();
        botonAgregar = new javax.swing.JButton();
        botonEliminar = new javax.swing.JButton();
        botonFinalizar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuAlmacen = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        menuCambiarUsuario = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setText("Caja de Pago");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setText("Informacion de Producto: ");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Inserte Codigo de Barras:");

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("Nombre:");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText("Precio:");

        etiquetaNombre.setBackground(new java.awt.Color(102, 102, 102));

        etiquetaPrecio.setBackground(new java.awt.Color(102, 102, 102));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setText("Tipo Producto:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(etiquetaNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(etiquetaPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(etiquetaTipo, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE))
                .addGap(42, 42, 42))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(etiquetaNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(etiquetaTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(etiquetaPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        botonBuscar.setText("Buscar");
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Ticket");

        areaTexto.setEditable(false);
        areaTexto.setColumns(20);
        areaTexto.setRows(5);
        jScrollPane1.setViewportView(areaTexto);

        botonAgregar.setText("Agregar");
        botonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarActionPerformed(evt);
            }
        });

        botonEliminar.setText("Eliminar");
        botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarActionPerformed(evt);
            }
        });

        botonFinalizar.setText("Finalizar");
        botonFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonFinalizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelCajaLayout = new javax.swing.GroupLayout(panelCaja);
        panelCaja.setLayout(panelCajaLayout);
        panelCajaLayout.setHorizontalGroup(
            panelCajaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCajaLayout.createSequentialGroup()
                .addGroup(panelCajaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCajaLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(panelCajaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelCajaLayout.createSequentialGroup()
                                .addComponent(botonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(botonAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(botonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(73, 73, 73))))
                    .addGroup(panelCajaLayout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(cajaBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelCajaLayout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addGroup(panelCajaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(panelCajaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel1)
                                .addGroup(panelCajaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(botonFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(panelCajaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );
        panelCajaLayout.setVerticalGroup(
            panelCajaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCajaLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(panelCajaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel7))
                .addGroup(panelCajaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCajaLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jScrollPane1))
                    .addGroup(panelCajaLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cajaBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addGroup(panelCajaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(botonFinalizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(39, 39, 39))
        );

        jMenu1.setText("Menu");

        menuAlmacen.setText("Almacen");
        menuAlmacen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAlmacenActionPerformed(evt);
            }
        });
        jMenu1.add(menuAlmacen);
        jMenu1.add(jSeparator1);

        menuCambiarUsuario.setText("Cambiar Usuario");
        menuCambiarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCambiarUsuarioActionPerformed(evt);
            }
        });
        jMenu1.add(menuCambiarUsuario);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 792, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(panelCaja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 7, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 520, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(panelCaja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
        Conexion con = new Conexion();
        Connection conexion = con.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String campo = cajaBusqueda.getText();
        try {

            if (!campo.trim().isEmpty()) {
                ps = conexion.prepareStatement("SELECT nombreProducto, precioProducto, tipoProducto from producto where codigoBarras=?" );
                ps.setString(1, campo);
                rs = ps.executeQuery();

                // Check if the ResultSet has any data
                if (rs.next()) {
                    etiquetaNombre.setText(rs.getString("nombreProducto"));
                    etiquetaPrecio.setText("$"+String.valueOf(rs.getDouble("precioProducto"))+" pesos.");
                    etiquetaTipo.setText(rs.getString("tipoProducto"));
                } else {
                    etiquetaNombre.setText("No encontrado");
                    etiquetaPrecio.setText("");
                    etiquetaTipo.setText("");
                }
            }
        } catch (Exception ex) {
            System.err.println("ERROR Mostrando datos: " + ex);
        } finally {
            // Close resources
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conexion != null) conexion.close();
            } catch (SQLException ex) {
                System.err.println("ERROR al cerrar recursos: " + ex);
            }
        }

    }//GEN-LAST:event_botonBuscarActionPerformed

    private void botonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarActionPerformed
        int codigoBarras = Integer.parseInt(cajaBusqueda.getText());
        agregarProducto(codigoBarras);

    }//GEN-LAST:event_botonAgregarActionPerformed

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
        eliminarUltimoTexto1();
    }//GEN-LAST:event_botonEliminarActionPerformed

    private void botonFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonFinalizarActionPerformed
        insertarTicketEnBaseDeDatos();

    }//GEN-LAST:event_botonFinalizarActionPerformed

    private void menuCambiarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCambiarUsuarioActionPerformed
        InicioSesion cambioUsuario = new InicioSesion();
       this.dispose();
        cambioUsuario.setVisible(true);
    }//GEN-LAST:event_menuCambiarUsuarioActionPerformed

    private void menuAlmacenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAlmacenActionPerformed
     
        if (!cambio) {
        panelCaja.setVisible(false); // Ocultar el panel de Caja
        panelAlmacen = new PanelAlmacen(); // Crear instancia del panel de Almacén
        panelAlmacen.setSize(1400, 650); // Establecer el tamaño del panel de Almacén
        add(panelAlmacen); // Añadir el panel de Almacén al JFrame
        menuAlmacen.setText("Menu Caja");
        cambio = true;
    } else {
        remove(panelAlmacen); // Eliminar el panel de Almacén del JFrame
        panelCaja.setVisible(true); // Mostrar el panel de Caja
        menuAlmacen.setText("Menu Almacen");
        cambio = false;
    }

    revalidate(); // Validar nuevamente el contenido del JFrame
    repaint(); // Repintar el contenido del JFrame 
    }//GEN-LAST:event_menuAlmacenActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(new FlatDarculaLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Secundario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaTexto;
    private javax.swing.JButton botonAgregar;
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonFinalizar;
    private javax.swing.JTextField cajaBusqueda;
    private javax.swing.JLabel etiquetaNombre;
    private javax.swing.JLabel etiquetaPrecio;
    private javax.swing.JLabel etiquetaTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenuItem menuAlmacen;
    private javax.swing.JMenuItem menuCambiarUsuario;
    private javax.swing.JPanel panelCaja;
    // End of variables declaration//GEN-END:variables
}
