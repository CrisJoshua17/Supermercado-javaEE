/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Modelo.Usuario;
import com.formdev.flatlaf.FlatDarculaLaf;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author crist
 */
public class Principal extends javax.swing.JFrame {

    private Usuario usuario;
    private Timer timer;
    private boolean isPanelMenuVisible = true;
    private int panelMenuWidth = 105; // Ancho inicial del panelMenu
    private int step = 10; // Cuántos píxeles se mueve por cada paso del timer
   private boolean click = false;
    private boolean animationRunning = false;
    
    public Principal( ) {
        initComponents();
        setTitle("Programa SuperMercado");
        setResizable(false);
        setSize(1400, 650);
        setLocationRelativeTo(null);
        
    }

   
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        panelVista = new javax.swing.JPanel();
        botonMenu = new javax.swing.JButton();
        panelMenu = new javax.swing.JPanel();
        botonRegistro = new javax.swing.JButton();
        botonMoificarProd = new javax.swing.JButton();
        botonAlmacen = new javax.swing.JButton();
        botonMov = new javax.swing.JButton();
        botonCaja = new javax.swing.JButton();
        botonTicket = new javax.swing.JButton();
        botonGanancias = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1000, 646));
        setSize(new java.awt.Dimension(550, 550));

        panelVista.setLayout(new java.awt.BorderLayout());

        botonMenu.setText("******");
        botonMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMenuActionPerformed(evt);
            }
        });

        panelMenu.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelMenu.setToolTipText("");
        panelMenu.setPreferredSize(new java.awt.Dimension(105, 587));
        panelMenu.setLayout(new java.awt.GridBagLayout());

        botonRegistro.setIcon(new javax.swing.ImageIcon("C:\\Users\\crist\\Desktop\\Trabajos\\JavaSpringNet\\SuperMercadoMaven\\src\\main\\java\\Imagenes\\registro (1).png")); // NOI18N
        botonRegistro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonRegistroMouseEntered(evt);
            }
        });
        botonRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegistroActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 38;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 0, 3);
        panelMenu.add(botonRegistro, gridBagConstraints);

        botonMoificarProd.setIcon(new javax.swing.ImageIcon("C:\\Users\\crist\\Desktop\\Trabajos\\JavaSpringNet\\SuperMercadoMaven\\src\\main\\java\\Imagenes\\products_1312256.png")); // NOI18N
        botonMoificarProd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonMoificarProdMouseEntered(evt);
            }
        });
        botonMoificarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMoificarProdActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 38;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 3, 0, 3);
        panelMenu.add(botonMoificarProd, gridBagConstraints);

        botonAlmacen.setIcon(new javax.swing.ImageIcon("C:\\Users\\crist\\Desktop\\Trabajos\\JavaSpringNet\\SuperMercadoMaven\\src\\main\\java\\Imagenes\\boxes_2310998.png")); // NOI18N
        botonAlmacen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonAlmacenMouseEntered(evt);
            }
        });
        botonAlmacen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAlmacenActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 38;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 3, 0, 3);
        panelMenu.add(botonAlmacen, gridBagConstraints);

        botonMov.setIcon(new javax.swing.ImageIcon("C:\\Users\\crist\\Desktop\\Trabajos\\JavaSpringNet\\SuperMercadoMaven\\src\\main\\java\\Imagenes\\vecteezy_delivery-truck-icon-icon-png-on-transparent-background_14455904 (1).png")); // NOI18N
        botonMov.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonMovMouseEntered(evt);
            }
        });
        botonMov.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMovActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 38;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 3, 0, 3);
        panelMenu.add(botonMov, gridBagConstraints);

        botonCaja.setIcon(new javax.swing.ImageIcon("C:\\Users\\crist\\Desktop\\Trabajos\\JavaSpringNet\\SuperMercadoMaven\\src\\main\\java\\Imagenes\\pngegg.png")); // NOI18N
        botonCaja.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonCajaMouseEntered(evt);
            }
        });
        botonCaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCajaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 38;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 3, 0, 3);
        panelMenu.add(botonCaja, gridBagConstraints);

        botonTicket.setIcon(new javax.swing.ImageIcon("C:\\Users\\crist\\Desktop\\Trabajos\\JavaSpringNet\\SuperMercadoMaven\\src\\main\\java\\Imagenes\\ticket.png")); // NOI18N
        botonTicket.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonTicketMouseEntered(evt);
            }
        });
        botonTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonTicketActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.ipadx = 38;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 3, 0, 3);
        panelMenu.add(botonTicket, gridBagConstraints);

        botonGanancias.setIcon(new javax.swing.ImageIcon("C:\\Users\\crist\\Desktop\\Trabajos\\JavaSpringNet\\SuperMercadoMaven\\src\\main\\java\\Imagenes\\klipartz.com.png")); // NOI18N
        botonGanancias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonGananciasMouseEntered(evt);
            }
        });
        botonGanancias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGananciasActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.ipadx = 38;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 3, 3, 3);
        panelMenu.add(botonGanancias, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelVista, javax.swing.GroupLayout.PREFERRED_SIZE, 973, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(159, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 646, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botonMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(panelVista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMenuActionPerformed
         
     if (isPanelMenuVisible) {
        // Ocultar panelMenu y mostrar panelVista
        iniciarAnimacionDesplazar();
    } else {
        // Mostrar panelMenu y ocultar panelVista
        iniciarAnimacionExpandir();
    }

        
    }//GEN-LAST:event_botonMenuActionPerformed

    
    
    
    
    private void botonRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegistroActionPerformed
    PanelRegistro registro= new PanelRegistro();
    
    // Limpiar el contenido existente de panelVista
    panelVista.removeAll();
    
    // Agregar el nuevo panel a panelVista
    panelVista.add(registro);
    
    // Refrescar el contenedor para mostrar el nuevo panel
    panelVista.revalidate();
    panelVista.repaint();
        click = true;
    }//GEN-LAST:event_botonRegistroActionPerformed

    private void botonMoificarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMoificarProdActionPerformed
     PanelTabla tabla= new PanelTabla();
    
    // Limpiar el contenido existente de panelVista
    panelVista.removeAll();
    
    // Agregar el nuevo panel a panelVista
    panelVista.add(tabla);
    
    // Refrescar el contenedor para mostrar el nuevo panel
    panelVista.revalidate();
    panelVista.repaint();
        click = true;
    }//GEN-LAST:event_botonMoificarProdActionPerformed

    private void botonAlmacenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAlmacenActionPerformed
       PanelAlmacen tabla= new PanelAlmacen();
    
    // Limpiar el contenido existente de panelVista
    panelVista.removeAll();
    
    // Agregar el nuevo panel a panelVista
    panelVista.add(tabla);
    
    // Refrescar el contenedor para mostrar el nuevo panel
    panelVista.revalidate();
    panelVista.repaint();
        click = true;
    }//GEN-LAST:event_botonAlmacenActionPerformed

    private void botonMovActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMovActionPerformed
      
       PanelMovimientos tabla= new PanelMovimientos();
    
    // Limpiar el contenido existente de panelVista
    panelVista.removeAll();
    
    // Agregar el nuevo panel a panelVista
    panelVista.add(tabla);
    
    // Refrescar el contenedor para mostrar el nuevo panel
    panelVista.revalidate();
    panelVista.repaint(); 
        click = true;
    }//GEN-LAST:event_botonMovActionPerformed

    private void botonCajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCajaActionPerformed
      panelCaja tabla= new panelCaja();
    
    // Limpiar el contenido existente de panelVista
    panelVista.removeAll();
    
    // Agregar el nuevo panel a panelVista
    panelVista.add(tabla);
    
    // Refrescar el contenedor para mostrar el nuevo panel
    panelVista.revalidate();
    panelVista.repaint(); 
        click = true;
    }//GEN-LAST:event_botonCajaActionPerformed

    private void botonTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonTicketActionPerformed
     
        BusquedaTickets ticket= new BusquedaTickets();
    
    // Limpiar el contenido existente de panelVista
    panelVista.removeAll();
    
    // Agregar el nuevo panel a panelVista
    panelVista.add(ticket);
    
    // Refrescar el contenedor para mostrar el nuevo panel
    panelVista.revalidate();
    panelVista.repaint();  
        click = true;
    }//GEN-LAST:event_botonTicketActionPerformed

    private void botonGananciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGananciasActionPerformed
     Ganancias ganancias= new Ganancias();
    
    // Limpiar el contenido existente de panelVista
    panelVista.removeAll();
    
    // Agregar el nuevo panel a panelVista
    panelVista.add(ganancias);
    
    // Refrescar el contenedor para mostrar el nuevo panel
    panelVista.revalidate();
    panelVista.repaint();  
      click = true;  
    }//GEN-LAST:event_botonGananciasActionPerformed

    
    
    private void botonRegistroMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonRegistroMouseEntered
      if (!click && !animationRunning) {
        PanelRegistro registro= new PanelRegistro();
    
    // Limpiar el contenido existente de panelVista
    panelVista.removeAll();
    
    // Agregar el nuevo panel a panelVista
    panelVista.add(registro);
    
    // Refrescar el contenedor para mostrar el nuevo panel
    panelVista.revalidate();
    panelVista.repaint();
      }
    }//GEN-LAST:event_botonRegistroMouseEntered

    private void botonMoificarProdMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonMoificarProdMouseEntered
     if (!click && !animationRunning) {
        PanelTabla tabla= new PanelTabla();
    
    // Limpiar el contenido existente de panelVista
    panelVista.removeAll();
    
    // Agregar el nuevo panel a panelVista
    panelVista.add(tabla);
    
    // Refrescar el contenedor para mostrar el nuevo panel
    panelVista.revalidate();
    panelVista.repaint();
     }
     
        
    }//GEN-LAST:event_botonMoificarProdMouseEntered

    private void botonAlmacenMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonAlmacenMouseEntered
       if (!click && !animationRunning) {
         PanelAlmacen tabla= new PanelAlmacen();
    
    // Limpiar el contenido existente de panelVista
    panelVista.removeAll();
    
    // Agregar el nuevo panel a panelVista
    panelVista.add(tabla);
    
    // Refrescar el contenedor para mostrar el nuevo panel
    panelVista.revalidate();
    panelVista.repaint();
        
       }   
    }//GEN-LAST:event_botonAlmacenMouseEntered

    private void botonMovMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonMovMouseEntered
     if (!click && !animationRunning) {
       PanelMovimientos tabla= new PanelMovimientos();
    
    // Limpiar el contenido existente de panelVista
    panelVista.removeAll();
    
    // Agregar el nuevo panel a panelVista
    panelVista.add(tabla);
    
    // Refrescar el contenedor para mostrar el nuevo panel
    panelVista.revalidate();
    panelVista.repaint(); 
     } 
    }//GEN-LAST:event_botonMovMouseEntered

    private void botonCajaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonCajaMouseEntered
if (!click && !animationRunning) {
  panelCaja tabla= new panelCaja();
    
    // Limpiar el contenido existente de panelVista
    panelVista.removeAll();
    
    // Agregar el nuevo panel a panelVista
    panelVista.add(tabla);
    
    // Refrescar el contenedor para mostrar el nuevo panel
    panelVista.revalidate();
    panelVista.repaint(); 
}
    }//GEN-LAST:event_botonCajaMouseEntered

    private void botonTicketMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonTicketMouseEntered
 if (!click && !animationRunning) {
       BusquedaTickets ticket= new BusquedaTickets();
    
    // Limpiar el contenido existente de panelVista
    panelVista.removeAll();
    
    // Agregar el nuevo panel a panelVista
    panelVista.add(ticket);
    
    // Refrescar el contenedor para mostrar el nuevo panel
    panelVista.revalidate();
    panelVista.repaint();  
 }

    }//GEN-LAST:event_botonTicketMouseEntered

    private void botonGananciasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonGananciasMouseEntered
     if (!click && !animationRunning) {
        Ganancias ganancias= new Ganancias();
    
    // Limpiar el contenido existente de panelVista
    panelVista.removeAll();
    
    // Agregar el nuevo panel a panelVista
    panelVista.add(ganancias);
    
    // Refrescar el contenedor para mostrar el nuevo panel
    panelVista.revalidate();
    panelVista.repaint();  
     }
    }//GEN-LAST:event_botonGananciasMouseEntered

    
    
private void iniciarAnimacionDesplazar() {
    timer = new Timer(10, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int anchoActual = panelMenu.getWidth();
            if (anchoActual > 0) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        panelMenu.setPreferredSize(new Dimension(anchoActual - step, panelMenu.getHeight()));
                        panelVista.setPreferredSize(new Dimension(panelVista.getWidth() + step, panelVista.getHeight()));
                        
                        panelMenu.setBounds(anchoActual - step, panelMenu.getY(), panelMenu.getWidth(), panelMenu.getHeight());
                        panelVista.setBounds(panelVista.getX() + step, panelVista.getY(), panelVista.getWidth(), panelVista.getHeight());
                       
                        revalidate();
                        repaint();
                    }
                });
            } else {
                timer.stop();
                isPanelMenuVisible = false;
                botonMenu.setText(">>");
                animationRunning = false; // Set animationRunning to false here
            }
        }
    });
    animationRunning = true; // Set animationRunning to true here
    timer.start();
}

private void iniciarAnimacionExpandir() {
    timer = new Timer(10, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int anchoActual = panelMenu.getWidth();
            if (anchoActual < panelMenuWidth) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        panelMenu.setPreferredSize(new Dimension(anchoActual + step, panelMenu.getHeight()));
                        panelVista.setPreferredSize(new Dimension(panelVista.getWidth() - step, panelVista.getHeight()));
                        
                        panelMenu.setBounds(anchoActual + step, panelMenu.getY(), panelMenu.getWidth(), panelMenu.getHeight());
                        panelVista.setBounds(panelVista.getX() - step, panelVista.getY(), panelVista.getWidth(), panelVista.getHeight());
                        
                        revalidate();
                        repaint();
                    }
                });
            } else {
                timer.stop();
                isPanelMenuVisible = true;
                botonMenu.setText("<<");
                animationRunning = false; // Set animationRunning to false here
            }
        }
    });
    animationRunning = true; // Set animationRunning to true here
    timer.start();
}
    
    
  
    
    
    
    
    
    
    
    
    
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
                new Principal().setVisible(true);
            }
        });
    
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAlmacen;
    private javax.swing.JButton botonCaja;
    private javax.swing.JButton botonGanancias;
    private javax.swing.JButton botonMenu;
    private javax.swing.JButton botonMoificarProd;
    private javax.swing.JButton botonMov;
    private javax.swing.JButton botonRegistro;
    private javax.swing.JButton botonTicket;
    private javax.swing.JPanel panelMenu;
    private javax.swing.JPanel panelVista;
    // End of variables declaration//GEN-END:variables
}
