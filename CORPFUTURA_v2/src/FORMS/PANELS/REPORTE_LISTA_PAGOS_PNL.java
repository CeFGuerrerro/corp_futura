
package FORMS.PANELS;

import CONTROLADORES.PagosJpaController;
import Entidades.Pagos;
import MODELOSTBL.modeloListaPagos;

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

        jLabel15 = new javax.swing.JLabel();
        fechasistema = new com.toedter.calendar.JDateChooser();
        jLabel16 = new javax.swing.JLabel();
        fechasistema1 = new com.toedter.calendar.JDateChooser();
        rbnAbonoCuotas = new javax.swing.JRadioButton();
        rbnAbonoCapital = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListapagos = new javax.swing.JTable();

        setBackground(new java.awt.Color(240, 236, 236));

        jLabel15.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(51, 51, 51));
        jLabel15.setText("Fecha inicio:");

        fechasistema.setBackground(new java.awt.Color(240, 236, 236));

        jLabel16.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(51, 51, 51));
        jLabel16.setText("Fecha fin:");

        fechasistema1.setBackground(new java.awt.Color(240, 236, 236));

        rbnAbonoCuotas.setBackground(new java.awt.Color(240, 236, 236));
        rbnAbonoCuotas.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        rbnAbonoCuotas.setForeground(new java.awt.Color(51, 51, 51));
        rbnAbonoCuotas.setText("Dia");

        rbnAbonoCapital.setBackground(new java.awt.Color(240, 236, 236));
        rbnAbonoCapital.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        rbnAbonoCapital.setForeground(new java.awt.Color(51, 51, 51));
        rbnAbonoCapital.setText("Intervalo de fechas");

        jLabel6.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("DETALLE DE INGRESOS");

        jButton2.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jButton2.setText("Cargar Pagos");

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
                                .addComponent(rbnAbonoCuotas)
                                .addGap(18, 18, 18)
                                .addComponent(rbnAbonoCapital))
                            .addComponent(jLabel6)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fechasistema, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fechasistema1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2)))
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
                    .addComponent(rbnAbonoCapital)
                    .addComponent(rbnAbonoCuotas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel15)
                    .addComponent(fechasistema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(fechasistema1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public com.toedter.calendar.JDateChooser fechasistema;
    public com.toedter.calendar.JDateChooser fechasistema1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbnAbonoCapital;
    private javax.swing.JRadioButton rbnAbonoCuotas;
    public javax.swing.JTable tblListapagos;
    // End of variables declaration//GEN-END:variables
}
