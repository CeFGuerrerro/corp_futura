
package FORMS.PANELS;

import CONTROLADORES.CodeudoresJpaController;
import Entidades.Codeudores;
import Entidades.DatosPersonales;
import MODELOSTBL.modeloCodeudor;
import CONTROLADORES.DatosPersonalesJpaController;
import CONTROLADORES.exceptions.NonexistentEntityException;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author DFUENTES
 */
public class CODEUDORES_PNL extends javax.swing.JPanel {
    
    public modeloCodeudor modelo = new modeloCodeudor();
    public DatosPersonales dtCodeudor;
    public DatosPersonales datospersonales;
    
    public List<Codeudores>  codeudores = new LinkedList();

    public DatosPersonalesJpaController dtjc = new DatosPersonalesJpaController();
    public CodeudoresJpaController cojc = new CodeudoresJpaController();
    
    
    
    

    public CODEUDORES_PNL() {
        initComponents();
      
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel11 = new javax.swing.JLabel();
        lbldui = new javax.swing.JLabel();
        txtdui = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        lblnombre = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        infocodeudores3 = new javax.swing.JLabel();
        btnregistrocodeudor = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblcodeudores = new javax.swing.JTable();
        rbnnombre = new javax.swing.JRadioButton();
        rbndui = new javax.swing.JRadioButton();
        txtbusqueda = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtDui = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txttelcodeudor = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        btnGuardar = new javax.swing.JButton();
        hvminus = new Label.HoverIcon();
        btnlimpiar = new javax.swing.JButton();

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

        infocodeudores3.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        infocodeudores3.setText("CODEUDORES");

        btnregistrocodeudor.setText("AGREGAR");
        btnregistrocodeudor.setEnabled(false);
        btnregistrocodeudor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregistrocodeudorActionPerformed(evt);
            }
        });

        tblcodeudores.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tblcodeudores.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblcodeudores.setRowHeight(20);
        tblcodeudores.setSelectionBackground(new java.awt.Color(204, 255, 204));
        tblcodeudores.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(tblcodeudores);
        tblcodeudores.setModel(modelo);

        rbnnombre.setBackground(new java.awt.Color(240, 236, 236));
        rbnnombre.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        rbnnombre.setForeground(new java.awt.Color(51, 51, 51));
        rbnnombre.setText("NOMNBRE");

        rbndui.setBackground(new java.awt.Color(240, 236, 236));
        rbndui.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        rbndui.setForeground(new java.awt.Color(51, 51, 51));
        rbndui.setText("DUI");

        txtbusqueda.setEditable(false);
        txtbusqueda.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        txtbusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbusquedaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtbusquedaKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Buscar:");

        jLabel5.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("DUI:");

        txtDui.setEditable(false);
        txtDui.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N

        txtNombre.setEditable(false);
        txtNombre.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Nombre:");

        txttelcodeudor.setEditable(false);
        txttelcodeudor.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Teléfono:");

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator2.setPreferredSize(new java.awt.Dimension(5, 100));

        btnGuardar.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(51, 51, 51));
        btnGuardar.setText("GUARDAR CAMBIOS");
        btnGuardar.setEnabled(false);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        hvminus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/ICONS/minus.png"))); // NOI18N
        hvminus.setText("hoverIcon1");
        hvminus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hvminusMouseClicked(evt);
            }
        });

        btnlimpiar.setText("Limpiar");
        btnlimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlimpiarActionPerformed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbldui)
                                .addGap(10, 10, 10)
                                .addComponent(txtdui, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(lblnombre)
                                .addGap(10, 10, 10)
                                .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(infocodeudores3)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(48, 48, 48)
                                        .addComponent(rbnnombre)
                                        .addGap(2, 2, 2)
                                        .addComponent(rbndui)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnlimpiar))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(10, 10, 10)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnregistrocodeudor, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtbusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(18, 18, 18)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(4, 4, 4)
                                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(3, 3, 3)
                                        .addComponent(txtDui, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txttelcodeudor, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 835, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnGuardar)
                                    .addComponent(hvminus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 68, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtdui, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbldui)
                            .addComponent(lblnombre))))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(infocodeudores3)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                .addComponent(rbnnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(rbndui, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnlimpiar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtbusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(txtDui, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txttelcodeudor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(btnregistrocodeudor)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(hvminus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        rbnnombre.setSelected(true);
        hvminus.setImages("/IMAGES/ICONS/minus1.png","/IMAGES/ICONS/minus.png");
    }// </editor-fold>//GEN-END:initComponents

    private void btnregistrocodeudorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregistrocodeudorActionPerformed
        if(dtCodeudor!=null){
            boolean validar = true;
            for(DatosPersonales dt: modelo.getDatos()){
                if(dt.getDui().equals(dtCodeudor.getDui())){validar = false;}
            }
            if(validar==true){modelo.agregarCodeudor(dtCodeudor);}
        }
    }//GEN-LAST:event_btnregistrocodeudorActionPerformed

    private void txtbusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbusquedaKeyReleased
       
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!txtbusqueda.getText().isEmpty() && (rbnnombre.isSelected()!=false || rbndui.isSelected()!=false)) {
                if(rbndui.isSelected()==true){
                    if(dtjc.findDatosPersonales(txtbusqueda.getText())!=null){
                        dtCodeudor = dtjc.findDatosPersonales(txtbusqueda.getText());
                        txtNombre.setText(dtCodeudor.getNombre());
                        txtDui.setText(dtCodeudor.getDui());
                        txttelcodeudor.setText(dtCodeudor.getTelefono());       
                    }
                    else{JOptionPane.showMessageDialog(this,"el cliente con el dui: "+txtbusqueda.getText()+"no existe en la base de datos");}
                }
                else if(rbnnombre.isSelected()==true){
                    if(dtjc.findByNombre(txtbusqueda.getText())!=null){
                        dtCodeudor = dtjc.findByNombre(txtbusqueda.getText());
                        txtNombre.setText(dtCodeudor.getNombre());
                        txtDui.setText(dtCodeudor.getDui());
                        txttelcodeudor.setText(dtCodeudor.getTelefono());
                    }
                    else{JOptionPane.showMessageDialog(this,"el cliente con el nombre: "+txtbusqueda.getText()+"no existe en la base de datos");}
                }

            } else {
                JOptionPane.showMessageDialog(null, "ingrese el nombre o dui del cliente");
            }
        }
      
    }//GEN-LAST:event_txtbusquedaKeyReleased

    private void txtbusquedaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbusquedaKeyTyped
        Character c = evt.getKeyChar();
        if(Character.isLetter(c)) {
            evt.setKeyChar(Character.toUpperCase(c));
        }
    }//GEN-LAST:event_txtbusquedaKeyTyped

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        
        codeudores.clear();
        if(modelo.getRowCount()>=1){
            codeudores = modelo.llenarLista(datospersonales);     
            try {
                if(datospersonales.getCodeudoresList1().isEmpty()){
                    for (Codeudores codeudores : codeudores){cojc.create(codeudores);} 
                }else{
                    if(compararCodeudores()){
                            for (Codeudores codeudor : codeudores){cojc.edit(codeudor);}
                    }else{
                            cojc.actualizarCodeudores(codeudores,datospersonales.getCodeudoresList1());
                    }
                }
        
            } catch (Exception ex) {
                Logger.getLogger(CODEUDORES_PNL.class.getName()).log(Level.SEVERE, null, ex);
            }
            datospersonales.setCodeudoresList1(codeudores);
        }else if(modelo.getRowCount()<1 && !datospersonales.getCodeudoresList1().isEmpty()){
                for (Codeudores codeudores : datospersonales.getCodeudoresList1()){
                    try {
                        cojc.destroy(codeudores.getCodeudoresPK());
                    } catch (NonexistentEntityException ex) {
                        Logger.getLogger(CODEUDORES_PNL.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } 
        }
     

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void hvminusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hvminusMouseClicked
        
        if(tblcodeudores.getSelectedRow()!= -1){
                modelo.borraCodeudor(tblcodeudores.getSelectedRow());
            
        }
    }//GEN-LAST:event_hvminusMouseClicked

    private void btnlimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimpiarActionPerformed
        txtbusqueda.setText("");
        txtNombre.setText("");
        txtDui.setText("");
        txttelcodeudor.setText("");
    }//GEN-LAST:event_btnlimpiarActionPerformed

    public void cargarCliente(DatosPersonales dp){
        
        txtnombre.setText(dp.getNombre());
        txtdui.setText(dp.getDui());
        datospersonales= dp;
        txtbusqueda.setEditable(true);
        btnregistrocodeudor.setEnabled(true);
        
    }
    
    public void recibirDatos(DatosPersonales dp){
    
        cargarCliente(dp); 
        if(!datospersonales.getCodeudoresList1().isEmpty()){
            for(Codeudores codeudor: datospersonales.getCodeudoresList1()){
                modelo.agregarCodeudor(codeudor.getDuiCodeudor());
            }
        }

    }
    
    public void limpiarcampos(){

        txtnombre.setText("");
        txtdui.setText("");        
        txtNombre.setText("");
        txtDui.setText("");
        txttelcodeudor.setText("");
        txtbusqueda.setText("");

        btnGuardar.setEnabled(false);
        txtbusqueda.setEditable(false);
        btnregistrocodeudor.setEnabled(false);
        
        modelo.borrartodos();
        codeudores.clear();
        datospersonales=null;
        
    }
    
    public boolean compararCodeudores(){
        boolean cumple=false;
        if(modelo.getRowCount()==datospersonales.getCodeudoresList1().size()){cumple=true;}
        return cumple;
    }
    
    
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnlimpiar;
    public javax.swing.JButton btnregistrocodeudor;
    private Label.HoverIcon hvminus;
    private javax.swing.JLabel infocodeudores3;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbldui;
    private javax.swing.JLabel lblnombre;
    private javax.swing.JRadioButton rbndui;
    private javax.swing.JRadioButton rbnnombre;
    public javax.swing.JTable tblcodeudores;
    private javax.swing.JTextField txtDui;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtbusqueda;
    public javax.swing.JTextField txtdui;
    public javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txttelcodeudor;
    // End of variables declaration//GEN-END:variables
}
