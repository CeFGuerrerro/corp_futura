
package FORMS.PANELS;

import CONTROLADORES.CreditosJpaController;
import Entidades.Creditos;
import MODELOSTBL.modeloListaCreditos;

/**
 *
 * @author DFUENTES
 */
public class REPORTE_CREDITOS_PNL extends javax.swing.JPanel {

    private modeloListaCreditos modelo = new modeloListaCreditos();
    private CreditosJpaController cjc = new CreditosJpaController();
    
    
    public REPORTE_CREDITOS_PNL() {

        
        initComponents();
        
   
    }
    
  

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblListaCreditos = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        txtbusqueda = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        cmbEstadocredito = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        fechasistema = new com.toedter.calendar.JDateChooser();
        jLabel18 = new javax.swing.JLabel();
        fechasistema1 = new com.toedter.calendar.JDateChooser();
        btnCargarCreditos = new javax.swing.JButton();

        setBackground(new java.awt.Color(240, 236, 236));

        tblListaCreditos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblListaCreditos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblListaCreditos.setRowHeight(30);
        tblListaCreditos.setSelectionBackground(new java.awt.Color(204, 255, 204));
        tblListaCreditos.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tblListaCreditos.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblListaCreditos);
        tblListaCreditos.setModel(modelo);

        jLabel6.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Nombre de Cliente:");

        txtbusqueda.setEditable(false);
        txtbusqueda.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        txtbusqueda.setPreferredSize(new java.awt.Dimension(350, 19));

        jLabel15.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(51, 51, 51));
        jLabel15.setText("Estado del Crédito:");

        cmbEstadocredito.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        cmbEstadocredito.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<SELECCIONAR>", "APROBADO", "ACTIVO", "REFINANCIADO", "GESTION DE ARREGLO", "CANCELADO", "CONGELADO" }));

        jLabel16.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(51, 51, 51));
        jLabel16.setText("Fechas de aprobación:");

        jLabel17.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(51, 51, 51));
        jLabel17.setText("Fecha inicio:");

        fechasistema.setBackground(new java.awt.Color(240, 236, 236));

        jLabel18.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(51, 51, 51));
        jLabel18.setText("Fecha fin:");

        fechasistema1.setBackground(new java.awt.Color(240, 236, 236));

        btnCargarCreditos.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        btnCargarCreditos.setForeground(new java.awt.Color(51, 51, 51));
        btnCargarCreditos.setText("Cargar Créditos");
        btnCargarCreditos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarCreditosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1073, Short.MAX_VALUE)
                        .addGap(25, 25, 25))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel15))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbEstadocredito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtbusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel16)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fechasistema, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fechasistema1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCargarCreditos)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtbusqueda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(cmbEstadocredito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel17)
                    .addComponent(fechasistema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(fechasistema1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCargarCreditos))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(147, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCargarCreditosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarCreditosActionPerformed
        
        for(Creditos credito: cjc.findCreditosEntities()){
            modelo.agregarCredito(credito);
        }
        tblListaCreditos.updateUI();
        
        
    }//GEN-LAST:event_btnCargarCreditosActionPerformed


    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCargarCreditos;
    private javax.swing.JComboBox<String> cmbEstadocredito;
    public com.toedter.calendar.JDateChooser fechasistema;
    public com.toedter.calendar.JDateChooser fechasistema1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tblListaCreditos;
    private javax.swing.JTextField txtbusqueda;
    // End of variables declaration//GEN-END:variables
}
