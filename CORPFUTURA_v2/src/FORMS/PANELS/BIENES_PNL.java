
package FORMS.PANELS;

import MODELOSTBL.modeloBienes;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author DFUENTES
 */
public class BIENES_PNL extends javax.swing.JPanel {

    public modeloBienes modelobienes = new modeloBienes();
    
    
    
    public BIENES_PNL() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel11 = new javax.swing.JLabel();
        lbldui = new javax.swing.JLabel();
        txtdui = new javax.swing.JTextField();
        lblnombre = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        fechadeclaracion = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblbienes = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        txttotal = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        minushv = new Label.HoverIcon();
        addhv = new Label.HoverIcon();

        setBackground(new java.awt.Color(240, 236, 236));

        jLabel11.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("CLIENTE");

        lbldui.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        lbldui.setForeground(new java.awt.Color(51, 51, 51));
        lbldui.setText("DUI:");

        txtdui.setEditable(false);
        txtdui.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N

        lblnombre.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        lblnombre.setForeground(new java.awt.Color(51, 51, 51));
        lblnombre.setText("Nombre:");

        txtnombre.setEditable(false);
        txtnombre.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        txtnombre.setSelectionColor(new java.awt.Color(51, 255, 204));
        txtnombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombreActionPerformed(evt);
            }
        });
        txtnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnombreKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Fecha:");

        fechadeclaracion.setBackground(new java.awt.Color(240, 236, 236));

        tblbienes.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        tblbienes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblbienes.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblbienes.setRowHeight(25);
        tblbienes.setSelectionBackground(new java.awt.Color(204, 255, 204));
        tblbienes.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(tblbienes);
        tblbienes.setModel(modelobienes);

        tblbienes.getColumnModel().getColumn(5).setMaxWidth(30);
        tblbienes.getColumnModel().getColumn(0).setMaxWidth(75);
        tblbienes.getColumnModel().getColumn(4).setMaxWidth(100);

        tblbienes.setDefaultRenderer(JButton.class,new TableCellRenderer(){
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object objeto, boolean estaSeleccionado, boolean tieneElFoco, int fila, int columna) {
                return (Component) objeto;
            }
        });

        tblbienes.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila = tblbienes.rowAtPoint(e.getPoint());
                int columna = tblbienes.columnAtPoint(e.getPoint());
                if (tblbienes.getModel().getColumnClass(columna).equals(JButton.class)) {
                    modelobienes.obtenerFoto(fila);
                }
            }});

            jLabel4.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
            jLabel4.setForeground(new java.awt.Color(102, 102, 102));
            jLabel4.setText("Total:  $");

            jLabel1.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
            jLabel1.setForeground(new java.awt.Color(51, 51, 51));
            jLabel1.setText("DECLARACIÓN JURADA DE BIENES");

            minushv.setText("hoverIcon1");
            minushv.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    minushvMouseClicked(evt);
                }
            });

            addhv.setText("hoverIcon2");
            addhv.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    addhvMouseClicked(evt);
                }
            });

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
            this.setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(jSeparator1)
                    .addContainerGap())
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(jLabel4)
                            .addGap(4, 4, 4)
                            .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(lbldui)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(txtdui, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(lblnombre)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(jLabel1)
                                            .addGap(29, 29, 29)
                                            .addComponent(jLabel3)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(fechadeclaracion, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(addhv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(minushv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(0, 405, Short.MAX_VALUE)))))
                    .addGap(35, 35, 35))
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(23, 23, 23)
                    .addComponent(jLabel11)
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(lbldui)
                        .addComponent(txtdui, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblnombre)
                        .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(fechadeclaracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel1)
                        .addComponent(minushv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(addhv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(2, 2, 2)
                            .addComponent(jLabel4))
                        .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(47, Short.MAX_VALUE))
            );

            minushv.setImages("/IMAGES/ICONS/minus1.png","/IMAGES/ICONS/minus.png");
            addhv.setImages("/IMAGES/ICONS/add1.png","/IMAGES/ICONS/add.png");
        }// </editor-fold>//GEN-END:initComponents

    private void txtnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombreActionPerformed
      
    }//GEN-LAST:event_txtnombreActionPerformed

    private void txtnombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombreKeyTyped
        Character c = evt.getKeyChar();
        if(Character.isLetter(c)) {
            evt.setKeyChar(Character.toUpperCase(c));
        }
    }//GEN-LAST:event_txtnombreKeyTyped

    private void addhvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addhvMouseClicked
        modelobienes.nuevaFila(); tblbienes.updateUI();
    }//GEN-LAST:event_addhvMouseClicked

    private void minushvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minushvMouseClicked
         if(tblbienes.getSelectedRow()!= -1){
                modelobienes.borraBien(tblbienes.getSelectedRow());
        }
    }//GEN-LAST:event_minushvMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Label.HoverIcon addhv;
    public com.toedter.calendar.JDateChooser fechadeclaracion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbldui;
    private javax.swing.JLabel lblnombre;
    private Label.HoverIcon minushv;
    public javax.swing.JTable tblbienes;
    public javax.swing.JTextField txtdui;
    public javax.swing.JTextField txtnombre;
    public javax.swing.JTextField txttotal;
    // End of variables declaration//GEN-END:variables
}
