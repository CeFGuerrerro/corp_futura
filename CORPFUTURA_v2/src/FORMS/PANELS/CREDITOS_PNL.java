
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

    public LISTA_CREDITOS_PNL cp = new LISTA_CREDITOS_PNL();
    public LISTA_MORAS_PNL mp = new LISTA_MORAS_PNL(this);
    
    public PAGO_FORM pagoForm;
   
    public Date fechadesistema;
 
    
    public CREDITOS_PNL() {
        initComponents();
        cargarPanel(cp);
        hvCreditos.setSeleccionado(hvMoras,hvPagos);
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
        hvPagos = new Label.HvLabel();
        hvMoras = new Label.HvLabel();
        hvCreditos = new Label.HvLabel();
        jButton1 = new javax.swing.JButton();
        lblfecha = new javax.swing.JLabel();
        contenidoCreditos = new javax.swing.JPanel();

        setBackground(new java.awt.Color(240, 236, 236));

        jPanel1.setBackground(new java.awt.Color(71, 109, 146));
        jPanel1.setPreferredSize(new java.awt.Dimension(539, 140));

        hvPagos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/LABELS/pagosAct.png"))); // NOI18N
        hvPagos.setPreferredSize(new java.awt.Dimension(100, 50));
        hvPagos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hvPagosMouseClicked(evt);
            }
        });

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

        jButton1.setText("actualizar fecha");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lblfecha.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblfecha.setForeground(new java.awt.Color(255, 255, 255));
        lblfecha.setText("Fecha");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(hvCreditos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hvMoras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hvPagos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 193, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(lblfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(hvPagos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hvMoras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hvCreditos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(13, 13, 13))
        );

        hvPagos.setImages("/IMAGES/LABELS/pagosDes.png","/IMAGES/LABELS/pagosDes.png", "/IMAGES/LABELS/pagosAct.png");
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

    private void hvPagosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hvPagosMouseClicked
        
        if(cp.tblCreditos.getSelectedRow() != -1){
            Creditos credito = cp.modelo.obtenerCredito(cp.tblCreditos.getSelectedRow());
            pagoForm = new PAGO_FORM(credito,cp,mp); 
            pagoForm.setVisible(true);
        }
        
    }//GEN-LAST:event_hvPagosMouseClicked

    private void hvMorasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hvMorasMouseClicked
       cargarPanel(mp);
        hvMoras.setSeleccionado(hvCreditos,hvPagos);
    }//GEN-LAST:event_hvMorasMouseClicked

    private void hvCreditosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hvCreditosMouseClicked
        cargarPanel(cp);
        hvCreditos.setSeleccionado(hvMoras,hvPagos);
    }//GEN-LAST:event_hvCreditosMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        if(lblfecha.getText().equals("Fecha")){
            fechadesistema = fechas.fechaActual();
            SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
            String fechaFormateada = formato.format(fechadesistema);
            lblfecha.setText(fechaFormateada);
        }
        else{
            fechadesistema.setTime(fechadesistema.getTime()+86400000);
             SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
            String fechaFormateada = formato.format(fechadesistema);
            lblfecha.setText(fechaFormateada);
        }
        
        
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel contenidoCreditos;
    private Label.HvLabel hvCreditos;
    private Label.HvLabel hvMoras;
    private Label.HvLabel hvPagos;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblfecha;
    // End of variables declaration//GEN-END:variables
}
