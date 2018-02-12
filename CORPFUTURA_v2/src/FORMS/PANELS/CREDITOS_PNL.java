
package FORMS.PANELS;

import Entidades.Creditos;
import FORMS.PAGO_FORM;
import UTILIDADES.fechas;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JPanel;

/**
 *
 * @author DFUENTES
 */
public class CREDITOS_PNL extends javax.swing.JPanel {

    
    public LISTA_MORAS_PNL mp = new LISTA_MORAS_PNL(this);
    public LISTA_CREDITOS_PNL cp = new LISTA_CREDITOS_PNL(mp);
    
    public PAGO_FORM pagoForm;
   
 
    
    public CREDITOS_PNL() {
        initComponents();
        cargarPanel(cp);
        hvCreditos.setSeleccionado(hvMoras);
        fechasistema.setDate(fechas.fechaActual());
    }

    public void cargarPanel(JPanel panel){
        
            panel.setLocation(0,0);
            panel.setSize(500,500);
            contenidoCreditos.removeAll();
            contenidoCreditos.add(panel);
            contenidoCreditos.revalidate();
            contenidoCreditos.repaint();

    }
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        hvMoras = new Label.HvLabel();
        hvCreditos = new Label.HvLabel();
        fechasistema = new com.toedter.calendar.JDateChooser();
        jLabel15 = new javax.swing.JLabel();
        contenidoCreditos = new javax.swing.JPanel();

        setBackground(new java.awt.Color(240, 236, 236));

        jPanel1.setBackground(new java.awt.Color(71, 109, 146));
        jPanel1.setPreferredSize(new java.awt.Dimension(539, 140));

        hvMoras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/LABELS/morasDes.png"))); // NOI18N
        hvMoras.setPreferredSize(new java.awt.Dimension(100, 50));
        hvMoras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hvMorasMouseClicked(evt);
            }
        });

        hvCreditos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/LABELS/listacreditosDes.png"))); // NOI18N
        hvCreditos.setPreferredSize(new java.awt.Dimension(100, 50));
        hvCreditos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hvCreditosMouseClicked(evt);
            }
        });

        fechasistema.setBackground(new java.awt.Color(71, 109, 146));

        jLabel15.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Fecha:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(hvCreditos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(hvMoras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 357, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fechasistema, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(hvMoras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hvCreditos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(fechasistema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13))
        );

        hvMoras.setImages("/IMAGES/LABELS/morasAct.png","/IMAGES/LABELS/morasAct.png", "/IMAGES/LABELS/morasDes.png");
        hvCreditos.setImages("/IMAGES/LABELS/listacreditosAct.png","/IMAGES/LABELS/listacreditosAct.png", "/IMAGES/LABELS/listacreditosDes.png");

        contenidoCreditos.setBackground(new java.awt.Color(240, 236, 236));
        contenidoCreditos.setLayout(new javax.swing.BoxLayout(contenidoCreditos, javax.swing.BoxLayout.LINE_AXIS));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
            .addComponent(contenidoCreditos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(contenidoCreditos, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void hvMorasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hvMorasMouseClicked
       cargarPanel(mp);
        hvMoras.setSeleccionado(hvCreditos);
    }//GEN-LAST:event_hvMorasMouseClicked

    private void hvCreditosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hvCreditosMouseClicked
        cargarPanel(cp);
        hvCreditos.setSeleccionado(hvMoras);
    }//GEN-LAST:event_hvCreditosMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel contenidoCreditos;
    public com.toedter.calendar.JDateChooser fechasistema;
    private Label.HvLabel hvCreditos;
    private Label.HvLabel hvMoras;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
