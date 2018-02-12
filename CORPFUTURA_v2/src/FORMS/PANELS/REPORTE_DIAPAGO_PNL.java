
package FORMS.PANELS;

import MODELOSTBL.modeloDiapago;

/**
 *
 * @author DFUENTES
 */
public class REPORTE_DIAPAGO_PNL extends javax.swing.JPanel {


    private modeloDiapago modelo = new modeloDiapago();
    
    
    public REPORTE_DIAPAGO_PNL() {

        initComponents();
   
    }
    
    
    public void cargarModelo(){
    
        //metodo que carga el modelo con todos los creditos a los que le toca
        //pago en la fecha seleccionada
        tbldiapagos.updateUI();
    }
    
  

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbldiapagos = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        fechasistema = new com.toedter.calendar.JDateChooser();

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

        jButton1.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jButton1.setText("Cargar Pagos");

        jButton2.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jButton2.setText("Generar Documento");

        jLabel15.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(51, 51, 51));
        jLabel15.setText("Fecha:");

        fechasistema.setBackground(new java.awt.Color(240, 236, 236));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1040, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fechasistema, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(jButton2))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(jLabel15)
                        .addComponent(fechasistema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(129, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public com.toedter.calendar.JDateChooser fechasistema;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tbldiapagos;
    // End of variables declaration//GEN-END:variables
}
