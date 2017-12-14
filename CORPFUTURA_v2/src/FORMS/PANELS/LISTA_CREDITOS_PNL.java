
package FORMS.PANELS;

import CONTROLADORES.CreditosJpaController;
import Entidades.Creditos;
import MODELOSTBL.modeloCreditos;
import UTILIDADES.monto;
import java.util.List;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author DFUENTES
 */
public class LISTA_CREDITOS_PNL extends javax.swing.JPanel {

    modeloCreditos modelo = new modeloCreditos();
    CreditosJpaController cjc = new  CreditosJpaController();
    
    public LISTA_CREDITOS_PNL() {
        
        initComponents();
        cargarModelo();
    
    }
    
    public void cargarModelo(){
   
        short estado =2;
        modelo.borrartodos();
        cjc = new CreditosJpaController();
        List<Creditos> lista = cjc.getCreditosActivos(estado);
            for(Creditos credito:lista){
                modelo.agregarCredito(credito); 
            }
        tblCreditos.updateUI();
    
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblCreditos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtTotalIntereses = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        txtTotalIva = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        txtTotalPago = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        txtTotalCuota = new javax.swing.JTextField();
        hvreload = new Label.HoverIcon();

        setBackground(new java.awt.Color(240, 236, 236));

        tblCreditos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tblCreditos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblCreditos.setRowHeight(30);
        tblCreditos.setSelectionBackground(new java.awt.Color(204, 255, 204));
        tblCreditos.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tblCreditos.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblCreditos);
        tblCreditos.setModel(modelo);
        DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
        leftRenderer.setHorizontalAlignment(DefaultTableCellRenderer.LEFT);

        tblCreditos.getColumnModel().getColumn(1).setPreferredWidth(250);
        tblCreditos.getColumnModel().getColumn(0).setPreferredWidth(50);
        tblCreditos.getColumn("Crédito").setCellRenderer( leftRenderer );
        tblCreditos.getColumn("Monto Aprobado").setCellRenderer( leftRenderer );
        tblCreditos.getColumn("Capital Pagado").setCellRenderer( leftRenderer );
        tblCreditos.getColumn("Capital Pendiente").setCellRenderer( leftRenderer );
        tblCreditos.getColumn("Intereses Pagados").setCellRenderer( leftRenderer );
        tblCreditos.getColumn("Mora Pagada").setCellRenderer( leftRenderer );
        tblCreditos.getColumn("Cuotas Pagadas").setCellRenderer( leftRenderer );

        tblCreditos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {

                cargarTotalesCredito(tblCreditos.getSelectedRow());
            }
        });

        jLabel1.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText(" CRÉDITOS ACTIVOS");

        jLabel23.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(51, 51, 51));
        jLabel23.setText("Total Intereses a pagar:");

        txtTotalIntereses.setEditable(false);
        txtTotalIntereses.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N

        jLabel24.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(51, 51, 51));
        jLabel24.setText("Total IVA a pagar:");

        txtTotalIva.setEditable(false);
        txtTotalIva.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N

        jLabel25.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(51, 51, 51));
        jLabel25.setText("Total a pagar:");

        txtTotalPago.setEditable(false);
        txtTotalPago.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N

        jLabel26.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(51, 51, 51));
        jLabel26.setText("Total  Cuotas a pagar:");

        txtTotalCuota.setEditable(false);
        txtTotalCuota.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N

        hvreload.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/ICONS/reload.png"))); // NOI18N
        hvreload.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hvreloadMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1040, Short.MAX_VALUE)
                        .addGap(25, 25, 25))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(hvreload, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTotalPago, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTotalIva, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTotalIntereses, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTotalCuota, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addComponent(hvreload, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(txtTotalPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel23)
                    .addComponent(txtTotalIntereses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(txtTotalIva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(txtTotalCuota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(218, Short.MAX_VALUE))
        );

        hvreload.setImages("/IMAGES/ICONS/reload1.png","/IMAGES/ICONS/reload.png");
    }// </editor-fold>//GEN-END:initComponents

    private void hvreloadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hvreloadMouseClicked
        cargarModelo();
    }//GEN-LAST:event_hvreloadMouseClicked

   
    public void cargarTotalesCredito(int indice){
    
        Creditos credito = modelo.obtenerCredito(indice);
        monto monto = new monto(credito.getMonto().toString(),credito.getPlazo(),credito.getFormaPago());
        txtTotalPago.setText(monto.getTotalPago());
        txtTotalIntereses.setText(monto.getTotalIntereses());
        txtTotalIva.setText(monto.getTotalIva());
        txtTotalCuota.setText(String.valueOf(monto.numeroCuotas()));
        
    }
    
    public void limpiarTotales(){
        
        txtTotalPago.setText("");
        txtTotalIntereses.setText("");
        txtTotalIva.setText("");
        txtTotalCuota.setText("");   
        
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Label.HoverIcon hvreload;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tblCreditos;
    private javax.swing.JTextField txtTotalCuota;
    private javax.swing.JTextField txtTotalIntereses;
    private javax.swing.JTextField txtTotalIva;
    private javax.swing.JTextField txtTotalPago;
    // End of variables declaration//GEN-END:variables
}
