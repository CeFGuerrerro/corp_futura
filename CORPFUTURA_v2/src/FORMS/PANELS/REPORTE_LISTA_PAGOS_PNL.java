
package FORMS.PANELS;

import CONTROLADORES.PagosJpaController;
import Entidades.Pagos;
import MODELOSTBL.modeloListaPagos;
import static UTILIDADES.fechas.formatearFecha;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author DFUENTES
 */
public class REPORTE_LISTA_PAGOS_PNL extends javax.swing.JPanel {

    private modeloListaPagos modelo = new modeloListaPagos();   
    private PagosJpaController pagos = new PagosJpaController();
    
    
    public REPORTE_LISTA_PAGOS_PNL() {

        initComponents();
        
        for(Pagos pago: pagos.findPagosEntities()){
            modelo.agregarPago(pago);
        }
        
        tblListapagos.updateUI();
   
    }
    
  

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroup = new javax.swing.ButtonGroup();
        jLabel15 = new javax.swing.JLabel();
        fechaInicio = new com.toedter.calendar.JDateChooser();
        jLabel16 = new javax.swing.JLabel();
        fechaFin = new com.toedter.calendar.JDateChooser();
        rbnDia = new javax.swing.JRadioButton();
        rbnIntervalo = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        btnCargar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListapagos = new javax.swing.JTable();

        setBackground(new java.awt.Color(240, 236, 236));

        jLabel15.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(51, 51, 51));
        jLabel15.setText("Fecha inicio:");

        fechaInicio.setBackground(new java.awt.Color(240, 236, 236));

        jLabel16.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(51, 51, 51));
        jLabel16.setText("Fecha fin:");

        fechaFin.setBackground(new java.awt.Color(240, 236, 236));

        rbnDia.setBackground(new java.awt.Color(240, 236, 236));
        btnGroup.add(rbnDia);
        rbnDia.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        rbnDia.setForeground(new java.awt.Color(51, 51, 51));
        rbnDia.setText("Dia");

        rbnIntervalo.setBackground(new java.awt.Color(240, 236, 236));
        btnGroup.add(rbnIntervalo);
        rbnIntervalo.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        rbnIntervalo.setForeground(new java.awt.Color(51, 51, 51));
        rbnIntervalo.setText("Intervalo de fechas");

        jLabel6.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("DETALLE DE INGRESOS");

        btnCargar.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        btnCargar.setText("Cargar Pagos");
        btnCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarActionPerformed(evt);
            }
        });

        tblListapagos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblListapagos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblListapagos.setRowHeight(30);
        tblListapagos.setSelectionBackground(new java.awt.Color(204, 255, 204));
        tblListapagos.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tblListapagos.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblListapagos);
        tblListapagos.setModel(modelo);

        tblListapagos.getColumnModel().getColumn(1).setPreferredWidth(250);
        tblListapagos.getColumnModel().getColumn(0).setPreferredWidth(75);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rbnDia)
                                .addGap(18, 18, 18)
                                .addComponent(rbnIntervalo))
                            .addComponent(jLabel6)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCargar)))
                        .addGap(0, 493, Short.MAX_VALUE)))
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbnIntervalo)
                    .addComponent(rbnDia))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel15)
                    .addComponent(fechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(fechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCargar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarActionPerformed
        if(rbnDia.isSelected()){
            if(fechaInicio.getDate() != null){
                modelo.borrartodos();
                for(Pagos p: pagos.findPagosPorDia(fechaInicio.getDate())){
                    modelo.agregarPago(p);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Por favor seleccionar una fecha");
            }
        } else if(rbnIntervalo.isSelected()){
            if(fechaInicio.getDate() != null && fechaFin.getDate() != null){
                modelo.borrartodos();
                for(Pagos p: pagos.findPagosPorIntervalo(fechaInicio.getDate(), fechaFin.getDate())){
                    modelo.agregarPago(p);
                }
            } else {
                JOptionPane.showMessageDialog(null,"Por favor seleccionar un intervalo de fechas");
            }
        }
    }//GEN-LAST:event_btnCargarActionPerformed


    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCargar;
    public javax.swing.ButtonGroup btnGroup;
    public com.toedter.calendar.JDateChooser fechaFin;
    public com.toedter.calendar.JDateChooser fechaInicio;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbnDia;
    private javax.swing.JRadioButton rbnIntervalo;
    public javax.swing.JTable tblListapagos;
    // End of variables declaration//GEN-END:variables
}
