
package FORMS.PANELS;

import CONTROLADORES.CreditosJpaController;
import CONTROLADORES.MoraJpaController;
import Entidades.Creditos;
import Entidades.Mora;
import MODELOSTBL.modeloCreditos;
import MODELOSTBL.modeloMoras;
import UTILIDADES.monto;
import java.util.List;
import javax.swing.table.DefaultTableCellRenderer;
import utilidades.fechas;

/**
 *
 * @author DFUENTES
 */
public class LISTA_MORAS_PNL extends javax.swing.JPanel {

    public modeloMoras modelo = new modeloMoras();
    public MoraJpaController mjc = new  MoraJpaController();
    public CreditosJpaController cjc = new  CreditosJpaController();
    
    public List<Creditos> listaCreditos;
    
    
    public LISTA_MORAS_PNL() {
        
        initComponents();
        cargarModelo();
        listaCreditos = cjc.getCreditosActivos((short)2);
    
    }
    
    public void cargarModelo(){
   
        short estado =0;
        modelo.borrartodos();
        List<Mora> lista = mjc.getMorasActivas(estado);
            for(Mora mora:lista){
                modelo.agregarMora(mora); 
            }
        tblCreditos.updateUI();
    
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblCreditos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        calcularMora = new javax.swing.JButton();

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
        tblCreditos.getColumn("Cliente").setCellRenderer( leftRenderer );
        tblCreditos.getColumn("Monto").setCellRenderer( leftRenderer );
        tblCreditos.getColumn("Mora Pendiente").setCellRenderer( leftRenderer );
        tblCreditos.getColumn("Mora Pagada").setCellRenderer( leftRenderer );
        tblCreditos.getColumn("Mora Total").setCellRenderer( leftRenderer );

        tblCreditos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {

            }
        });

        jLabel1.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("MORA DE  CRÉDITOS ACTIVOS");

        calcularMora.setText("Calcular Mora ");
        calcularMora.setMaximumSize(new java.awt.Dimension(100, 23));
        calcularMora.setPreferredSize(new java.awt.Dimension(100, 30));
        calcularMora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calcularMoraActionPerformed(evt);
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
                            .addComponent(calcularMora, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(calcularMora, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(298, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void calcularMoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calcularMoraActionPerformed
      
        for(Creditos credito: listaCreditos){
            
            if(fechas.verificarPrimerPago(credito.getFechaPrimerPago(), fechas.fechaActual())){
                System.out.println("aun no es momento de primerpago");
            }else{System.out.println("ya se paso");}
            
        }
        
    }//GEN-LAST:event_calcularMoraActionPerformed


    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton calcularMora;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tblCreditos;
    // End of variables declaration//GEN-END:variables
}
