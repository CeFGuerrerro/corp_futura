
package FORMS.PANELS;

import Entidades.SolicitudCredito;
import FORMS.CREAR_DOCS;
import FORMS.EVALUACION_FORM;
import FORMS.NUEVA_SOLICITUD_FORM;
import FORMS.RESOLUCION_FORM;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author DFUENTES
 */
public class SOLICITUD_PNL extends javax.swing.JPanel {

    public LISTA_SOLICITUDES_PNL sp = new LISTA_SOLICITUDES_PNL();
    
    public NUEVA_SOLICITUD_FORM nuevasolicitud;
    public EVALUACION_FORM evaluacion;
    public RESOLUCION_FORM resolucion;
    
    public CREDITOS_PNL cpanel;
    
    public CREAR_DOCS docs;
 
    
    public SOLICITUD_PNL(CREDITOS_PNL cpanel1) {
        
        initComponents();
        
        cpanel = cpanel1;
        cargarPanel(sp);
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
        hvNuevaSol = new Label.HvLabel();
        hvEvaluacion = new Label.HvLabel();
        hvResolucion = new Label.HvLabel();
        hvDocumentos = new Label.HvLabel();
        contenidoSolicitud = new javax.swing.JPanel();

        setBackground(new java.awt.Color(240, 236, 236));

        jPanel1.setBackground(new java.awt.Color(71, 109, 146));
        jPanel1.setPreferredSize(new java.awt.Dimension(539, 140));

        hvNuevaSol.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/LABELS/nuevaSolicitudDes.png"))); // NOI18N
        hvNuevaSol.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hvNuevaSolMouseClicked(evt);
            }
        });

        hvEvaluacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/LABELS/evaluacionDes.png"))); // NOI18N
        hvEvaluacion.setPreferredSize(new java.awt.Dimension(100, 50));
        hvEvaluacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hvEvaluacionMouseClicked(evt);
            }
        });

        hvResolucion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/LABELS/resolucionDes.png"))); // NOI18N
        hvResolucion.setPreferredSize(new java.awt.Dimension(100, 50));
        hvResolucion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hvResolucionMouseClicked(evt);
            }
        });

        hvDocumentos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/LABELS/documentosDes.png"))); // NOI18N
        hvDocumentos.setPreferredSize(new java.awt.Dimension(100, 50));
        hvDocumentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hvDocumentosMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(hvNuevaSol, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(hvEvaluacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(hvResolucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(hvDocumentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(370, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(hvNuevaSol, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hvEvaluacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hvResolucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hvDocumentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        hvNuevaSol.setImages("/IMAGES/LABELS/nuevaSolicitudSel.png","/IMAGES/LABELS/nuevaSolicitudSel.png", "/IMAGES/LABELS/nuevaSolicitudDes.png");
        hvEvaluacion.setImages("/IMAGES/LABELS/evaluacionSel.png","/IMAGES/LABELS/evaluacionSel.png", "/IMAGES/LABELS/evaluacionDes.png");
        hvResolucion.setImages("/IMAGES/LABELS/resolucionSel.png","/IMAGES/LABELS/resolucionSel.png", "/IMAGES/LABELS/resolucionDes.png");
        hvDocumentos.setImages("/IMAGES/LABELS/documentosAct.png","/IMAGES/LABELS/documentosAct.png", "/IMAGES/LABELS/documentosDes.png");

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

    private void hvNuevaSolMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hvNuevaSolMouseClicked
        
        nuevasolicitud = new NUEVA_SOLICITUD_FORM(sp,cpanel.fechasistema.getDate());
        nuevasolicitud.setVisible(true);
      

        
    }//GEN-LAST:event_hvNuevaSolMouseClicked

    private void hvEvaluacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hvEvaluacionMouseClicked
        if(sp.getTblSolicitudes().getSelectedRow()!= -1){
            SolicitudCredito sol = sp.modelo.obtenersolicitud(sp.tblSolicitudes.getSelectedRow());
            if(sol.getEstado()<3){
            evaluacion = new EVALUACION_FORM(sol,sp);
            evaluacion.setVisible(true);}
            else{JOptionPane.showMessageDialog(null,"La solicitud ya ha sido evaluada.");}
        }
    }//GEN-LAST:event_hvEvaluacionMouseClicked

    private void hvResolucionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hvResolucionMouseClicked
         if(sp.getTblSolicitudes().getSelectedRow()!= -1){
            SolicitudCredito sol = sp.modelo.obtenersolicitud(sp.tblSolicitudes.getSelectedRow());
            if(sol.getEstado()==3){
            resolucion = new RESOLUCION_FORM(sol,sp);
            resolucion.setVisible(true);}           
            else if(sol.getEstado()<3){JOptionPane.showMessageDialog(null,"Es necesario que el estado de la solicitud sea: Resolución pendiente.");}
            else if(sol.getEstado()>3){JOptionPane.showMessageDialog(null,"La solicitud ya ha sido resuelta.");}
        }
    }//GEN-LAST:event_hvResolucionMouseClicked

    private void hvDocumentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hvDocumentosMouseClicked
        
         if(sp.getTblSolicitudes().getSelectedRow()!= -1){
            docs = new CREAR_DOCS(sp.modelo.obtenersolicitud(sp.tblSolicitudes.getSelectedRow()));
            docs.setVisible(true);
        }
  
    }//GEN-LAST:event_hvDocumentosMouseClicked

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel contenidoSolicitud;
    private Label.HvLabel hvDocumentos;
    private Label.HvLabel hvEvaluacion;
    private Label.HvLabel hvNuevaSol;
    private Label.HvLabel hvResolucion;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
