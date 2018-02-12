
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
public class REPORTES_PNL extends javax.swing.JPanel {

        
    private REPORTE_CLIENTES_PNL repClientes;
    private REPORTE_LISTA_PAGOS_PNL repPagos;
    private REPORTE_CREDITOS_PNL repCreditos;
    private REPORTE_DIAPAGO_PNL repDiaPago;
   
 
    
    public REPORTES_PNL() {
        initComponents();

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
        hvCreditos = new Label.HvLabel();
        hvClientes = new Label.HvLabel();
        hvdiapago = new Label.HvLabel();
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

        hvCreditos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/LABELS/listcreditosDes.png"))); // NOI18N
        hvCreditos.setPreferredSize(new java.awt.Dimension(100, 50));
        hvCreditos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hvCreditosMouseClicked(evt);
            }
        });

        hvClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/LABELS/listclientesDes.png"))); // NOI18N
        hvClientes.setPreferredSize(new java.awt.Dimension(100, 50));
        hvClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hvClientesMouseClicked(evt);
            }
        });

        hvdiapago.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/LABELS/diapagoDes.png"))); // NOI18N
        hvdiapago.setPreferredSize(new java.awt.Dimension(100, 50));
        hvdiapago.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hvdiapagoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(hvCreditos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(hvClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(hvPagos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(hvdiapago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(414, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(hvdiapago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(hvPagos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(hvCreditos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(hvClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(13, 13, 13))
        );

        hvPagos.setImages("/IMAGES/LABELS/pagosDes.png","/IMAGES/LABELS/pagosDes.png", "/IMAGES/LABELS/pagosAct.png");
        hvCreditos.setImages("/IMAGES/LABELS/listcreditosAct.png","/IMAGES/LABELS/listcreditosAct.png", "/IMAGES/LABELS/listcreditosDes.png");
        hvClientes.setImages("/IMAGES/LABELS/listclientesAct.png","/IMAGES/LABELS/listclientesAct.png", "/IMAGES/LABELS/listclientesDes.png");
        hvdiapago.setImages("/IMAGES/LABELS/diapagoAct.png","/IMAGES/LABELS/diapagoAct.png", "/IMAGES/LABELS/diapagoDes.png");

        contenidoCreditos.setBackground(new java.awt.Color(240, 236, 236));
        contenidoCreditos.setLayout(new javax.swing.BoxLayout(contenidoCreditos, javax.swing.BoxLayout.LINE_AXIS));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 824, Short.MAX_VALUE)
            .addComponent(contenidoCreditos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(contenidoCreditos, javax.swing.GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void hvPagosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hvPagosMouseClicked
 
        repPagos = new REPORTE_LISTA_PAGOS_PNL();
        cargarPanel(repPagos);
        hvPagos.setSeleccionado( hvCreditos,hvClientes,hvdiapago);
        
    }//GEN-LAST:event_hvPagosMouseClicked

    private void hvCreditosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hvCreditosMouseClicked
        
        repCreditos = new REPORTE_CREDITOS_PNL();
        cargarPanel(repCreditos);
        hvCreditos.setSeleccionado( hvPagos,hvClientes,hvdiapago);
         
    }//GEN-LAST:event_hvCreditosMouseClicked

    private void hvClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hvClientesMouseClicked
        
        repClientes = new REPORTE_CLIENTES_PNL();
        cargarPanel(repClientes);
        hvClientes.setSeleccionado( hvCreditos,hvPagos,hvdiapago);
         
    }//GEN-LAST:event_hvClientesMouseClicked

    private void hvdiapagoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hvdiapagoMouseClicked
        
        repDiaPago = new REPORTE_DIAPAGO_PNL();
        cargarPanel(repDiaPago);
        hvdiapago.setSeleccionado( hvCreditos,hvClientes,hvPagos);
        
    }//GEN-LAST:event_hvdiapagoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel contenidoCreditos;
    private Label.HvLabel hvClientes;
    private Label.HvLabel hvCreditos;
    private Label.HvLabel hvPagos;
    private Label.HvLabel hvdiapago;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
