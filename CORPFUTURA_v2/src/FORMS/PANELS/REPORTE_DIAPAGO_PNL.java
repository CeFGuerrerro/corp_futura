
package FORMS.PANELS;

import CONTROLADORES.CreditosJpaController;
import DOCS_DATASOURCES.DS_PagosDia;
import DOCS_DATASOURCES.JasperGenerator;
import Entidades.Creditos;
import MODELOSTBL.modeloDiapago;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author DFUENTES
 */
public class REPORTE_DIAPAGO_PNL extends javax.swing.JPanel {


    private modeloDiapago modelo = new modeloDiapago();
    private CreditosJpaController cjc = new CreditosJpaController();
    private DS_PagosDia listaPagos = new DS_PagosDia();
    private JasperGenerator jasper = new JasperGenerator();
    private Map parametros = new HashMap();
    
    
    
    public REPORTE_DIAPAGO_PNL() {

        initComponents();
   
    }
    
  
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbldiapagos = new javax.swing.JTable();
        cargarpagos = new javax.swing.JButton();
        btnGenerarDoc = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        fechapago = new com.toedter.calendar.JDateChooser();

        setBackground(new java.awt.Color(240, 236, 236));

        tbldiapagos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tbldiapagos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbldiapagos.setRowHeight(30);
        tbldiapagos.setSelectionBackground(new java.awt.Color(204, 255, 204));
        tbldiapagos.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tbldiapagos.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tbldiapagos);
        tbldiapagos.setModel(modelo);

        tbldiapagos.getColumnModel().getColumn(0).setPreferredWidth(300);

        cargarpagos.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        cargarpagos.setText("Cargar Pagos");
        cargarpagos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarpagosActionPerformed(evt);
            }
        });

        btnGenerarDoc.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        btnGenerarDoc.setText("Generar Documento");
        btnGenerarDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarDocActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(51, 51, 51));
        jLabel15.setText("Fecha:");

        fechapago.setBackground(new java.awt.Color(240, 236, 236));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1040, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cargarpagos)
                        .addGap(18, 18, 18)
                        .addComponent(btnGenerarDoc)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fechapago, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cargarpagos)
                        .addComponent(btnGenerarDoc))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(jLabel15)
                        .addComponent(fechapago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(129, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cargarpagosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarpagosActionPerformed
        
        
        if(fechapago.getDate()!=null){
            modelo.borrartodos();
            for(Creditos credito: cjc.obtenerPagosDelDia(fechapago.getDate()) ){
                modelo.agregarPago(credito);
                listaPagos.addCredito(credito);
            }
        }
        
        tbldiapagos.updateUI();
       
    }//GEN-LAST:event_cargarpagosActionPerformed

    private void btnGenerarDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarDocActionPerformed
        String doc = "ListaAbonos";
            parametros.clear();
            if(fechapago.getDate() !=null){
            parametros.put("Fecha",fechapago.getDate());
            try {
                jasper.crearReporteConParamDesktop(doc, parametros, listaPagos);
            } catch (JRException ex) {
                JOptionPane.showMessageDialog(null, "Error al crear el documento: " + ex.getMessage());;
            }
            }else {
                JOptionPane.showMessageDialog(null, "Por favor seleccionar una fecha");
            }
    }//GEN-LAST:event_btnGenerarDocActionPerformed


    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerarDoc;
    private javax.swing.JButton cargarpagos;
    public com.toedter.calendar.JDateChooser fechapago;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tbldiapagos;
    // End of variables declaration//GEN-END:variables
}
