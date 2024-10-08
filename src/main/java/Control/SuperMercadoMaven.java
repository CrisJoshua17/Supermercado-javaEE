/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Control;

import Vista.InicioSesion;
import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

/**
 *
 * @author crist
 */
public class SuperMercadoMaven {

    
    
    public static void main(String[] args) {
       diseñoInicio();
       
        
        
        
    }

    private static void diseñoInicio() {
       
        
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
              InicioSesion iniciar = new InicioSesion();
                iniciar.setVisible(true);
               
                
                
                
            }
        });

    }
}
