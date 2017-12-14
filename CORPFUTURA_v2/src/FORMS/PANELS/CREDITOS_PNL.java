
package FORMS.PANELS;

import javax.swing.JPanel;

/**
 *
 * @author DFUENTES
 */
public class CREDITOS_PNL extends javax.swing.JPanel {

    public LISTA_CREDITOS_PNL cp = new LISTA_CREDITOS_PNL();
   
 
    
    public CREDITOS_PNL() {
        initComponents();
        cargarPanel(cp);
    }

    public void cargarPanel(JPanel panel){
        
            panel.setLocation(0,0);
            panel.setSize(500,500);
            contenidoSolicitud.removeAll();
            contenidoSolicitud.add(panel);
            contenidoSolicitud.revalidate();
            contenidoSolicitud.repaint();
            
            
    
    }
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        contenidoSolicitud = new javax.swing.JPanel();

        setBackground(new java.awt.Color(240, 236, 236));

        jPanel1.setBackground(new java.awt.Color(71, 109, 146));
        jPanel1.setPreferredSize(new java.awt.Dimension(539, 140));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 780, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 98, Short.MAX_VALUE)
        );

        contenidoSolicitud.setBackground(new java.awt.Color(240, 236, 236));
        contenidoSolicitud.setLayout(new javax.swing.BoxLayout(contenidoSolicitud, javax.swing.BoxLayout.LINE_AXIS));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
            .addComponent(contenidoSolicitud, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(contenidoSolicitud, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel contenidoSolicitud;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
