
package MODELOSTBL;


import Entidades.DeclaracionBienes;
import javafx.scene.layout.Border;
import javax.swing.JButton;

/**
 *
 * @author DFUENTES
 */
public class Bien {
    
    private DeclaracionBienes declaracion;
    private JButton boton;

    public Bien(){
        declaracion = new DeclaracionBienes();
        this.setBoton(newButton());

    }
      
    public DeclaracionBienes getDeclaracion() {
        return declaracion;
    }

    public void setDeclaracion(DeclaracionBienes declaracion) {
        this.declaracion = declaracion;
    }

    public JButton getBoton() {
        return boton;
    }

    public void setBoton(JButton boton) {
        this.boton = boton;
    }
    
    private JButton newButton(){
         
        JButton boton = new JButton();
        boton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/ICONS/foto.png")));
        return boton;
        
    
    }
    
    
    
    
    
    
}
