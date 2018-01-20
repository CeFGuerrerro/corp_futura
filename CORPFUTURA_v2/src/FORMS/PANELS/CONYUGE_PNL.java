
package FORMS.PANELS;

import Entidades.DatosConyugue;
import Entidades.DatosPersonales;
import CONTROLADORES.DatosConyugueJpaController;
import CONTROLADORES.exceptions.NonexistentEntityException;
import CONTROLADORES.exceptions.PreexistingEntityException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author DFUENTES
 */
public class CONYUGE_PNL extends javax.swing.JPanel {

   
    
    public DatosConyugue conyuge;
    public DatosPersonales datospersonales;
    
    public DatosConyugueJpaController dcjc    = new DatosConyugueJpaController();
    
    public String direccionpersonal;
    
    public CONYUGE_PNL() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblconyugue = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtnombrecony = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtlugartrabajo = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtcargo = new javax.swing.JTextField();
        txttelcon = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtdirconyugue = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        txtdui = new javax.swing.JTextField();
        lbldui = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblnombre = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        hvadd = new Label.HoverIcon();

        setBackground(new java.awt.Color(240, 236, 236));

        lblconyugue.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        lblconyugue.setForeground(new java.awt.Color(51, 51, 51));
        lblconyugue.setText("DATOS DEL CONYUGUE");

        jLabel17.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(51, 51, 51));
        jLabel17.setText("Nombre:");

        txtnombrecony.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        txtnombrecony.setPreferredSize(new java.awt.Dimension(345, 19));
        txtnombrecony.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnombreconyKeyTyped(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(51, 51, 51));
        jLabel20.setText("Lugar de trabajo:");

        txtlugartrabajo.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        txtlugartrabajo.setPreferredSize(new java.awt.Dimension(345, 19));
        txtlugartrabajo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtlugartrabajoKeyTyped(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(51, 51, 51));
        jLabel21.setText("Cargo:");

        txtcargo.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        txtcargo.setPreferredSize(new java.awt.Dimension(345, 19));
        txtcargo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcargoKeyTyped(evt);
            }
        });

        txttelcon.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N

        jLabel22.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(51, 51, 51));
        jLabel22.setText("Télefono:");

        jLabel23.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(51, 51, 51));
        jLabel23.setText("Dirección:");

        txtdirconyugue.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        txtdirconyugue.setPreferredSize(new java.awt.Dimension(550, 19));
        txtdirconyugue.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtdirconyugueKeyTyped(evt);
            }
        });

        txtdui.setEditable(false);
        txtdui.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N

        lbldui.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        lbldui.setForeground(new java.awt.Color(51, 51, 51));
        lbldui.setText("DUI:");

        jLabel11.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("CLIENTE");

        lblnombre.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        lblnombre.setForeground(new java.awt.Color(51, 51, 51));
        lblnombre.setText("Nombre:");

        txtnombre.setEditable(false);
        txtnombre.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        txtnombre.setSelectionColor(new java.awt.Color(51, 255, 204));
        txtnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnombreKeyTyped(evt);
            }
        });

        btnGuardar.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(51, 51, 51));
        btnGuardar.setText("GUARDAR");
        btnGuardar.setEnabled(false);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        hvadd.setText("hoverIcon1");
        hvadd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hvaddMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txttelcon, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtnombrecony, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtlugartrabajo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtcargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(txtdirconyugue, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(hvadd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addComponent(lblconyugue)
                                    .addComponent(jLabel11)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lbldui)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtdui, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblnombre)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 224, Short.MAX_VALUE)))
                        .addContainerGap())))
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
                .addComponent(lblconyugue)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtnombrecony, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel20)
                    .addComponent(txtlugartrabajo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel21)
                    .addComponent(txtcargo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel22)
                    .addComponent(txttelcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel23)
                    .addComponent(txtdirconyugue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hvadd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(195, Short.MAX_VALUE))
        );

        hvadd.setImages("/IMAGES/ICONS/add1.png","/IMAGES/ICONS/add.png");
    }// </editor-fold>//GEN-END:initComponents

    private void txtnombreconyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombreconyKeyTyped
        Character c = evt.getKeyChar();
        if(Character.isLetter(c)) {
            evt.setKeyChar(Character.toUpperCase(c));
        }
    }//GEN-LAST:event_txtnombreconyKeyTyped

    private void txtlugartrabajoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtlugartrabajoKeyTyped
        Character c = evt.getKeyChar();
        if(Character.isLetter(c)) {
            evt.setKeyChar(Character.toUpperCase(c));
        }
    }//GEN-LAST:event_txtlugartrabajoKeyTyped

    private void txtcargoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcargoKeyTyped
        Character c = evt.getKeyChar();
        if(Character.isLetter(c)) {
            evt.setKeyChar(Character.toUpperCase(c));
        }
    }//GEN-LAST:event_txtcargoKeyTyped

    private void txtdirconyugueKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdirconyugueKeyTyped
        Character c = evt.getKeyChar();
        if(Character.isLetter(c)) {
            evt.setKeyChar(Character.toUpperCase(c));
        }
    }//GEN-LAST:event_txtdirconyugueKeyTyped

    private void txtnombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombreKeyTyped
        Character c = evt.getKeyChar();
        if(Character.isLetter(c)) {
            evt.setKeyChar(Character.toUpperCase(c));
        }
    }//GEN-LAST:event_txtnombreKeyTyped

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
       
        boolean verificacion = true;
        boolean edicion = false;
        if (conyuge != null) {
            edicion = true;     
        }

        if (txtnombrecony.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Falta llenar campos obligatorios\n*Nombre del cónyuge");
        } else {  
            
            llenardatosconyuge();
     
            if (edicion == false) {   
                try {
                    dcjc.create(conyuge);
                } catch (PreexistingEntityException ex) {
                    verificacion=false;
                    JOptionPane.showMessageDialog(null, "Error al registrar el conyuge del cliente.\n");
                } catch (Exception ex) {
                    verificacion=false;
                    JOptionPane.showMessageDialog(null, "Error al registrar el conyuge del cliente.\n");
                }
                if(verificacion){JOptionPane.showMessageDialog(null, "Datos del conyuge registrados con exito");}
            } else {
                try {
                    dcjc.edit(conyuge);
                } catch (NonexistentEntityException ex) {
                    JOptionPane.showMessageDialog(null, "Error al actualizar el conyuge del cliente.\n");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al actualizar el conyuge del cliente.\n");
                }
                if(verificacion){JOptionPane.showMessageDialog(null, "Datos del conyuge actualizados con exito");}
            }
        }
        
        
        
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void hvaddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hvaddMouseClicked
        txtdirconyugue.setText(direccionpersonal);
    }//GEN-LAST:event_hvaddMouseClicked

    public void limpiarcampos(){
        
        //DATOS CONYUGUE
        txtnombrecony.setText("");
        txtlugartrabajo.setText("");
        txtcargo.setText("");
        txttelcon.setText("");
        txtdirconyugue.setText("");
        txtnombre.setText("");
        txtdui.setText("");
        
        conyuge = null; 
        datospersonales = null;
        btnGuardar.setEnabled(false);
    
    }
    
    public void llenardatosconyuge(){
                
                conyuge = new DatosConyugue();
                conyuge.setDui(txtdui.getText());  
                conyuge.setCargo(txtcargo.getText());
                conyuge.setDireccion(txtdirconyugue.getText());
                conyuge.setLugarTrabajo(txtlugartrabajo.getText());
                conyuge.setNombre(txtnombrecony.getText());
                conyuge.setTelefono(txttelcon.getText());  
                conyuge.setDatosPersonales(datospersonales);

                
    }
 
    public void cargarconyuge(DatosConyugue con){
        
           txtnombrecony.setText(con.getNombre());
           txtdirconyugue.setText(con.getDireccion());
           txtlugartrabajo.setText(con.getLugarTrabajo());
           txtcargo.setText(con.getCargo());
           txttelcon.setText(con.getTelefono());

    }
    
    public void cargarCliente(DatosPersonales dp){
       
        datospersonales=dp;
        txtnombre.setText(datospersonales.getNombre());
        txtdui.setText(datospersonales.getDui());
    }
    
    public void recibirDatos(DatosPersonales dp){
    
        cargarCliente(dp);
        conyuge = dp.getDatosConyugue(); 
        if (conyuge != null) { cargarconyuge(conyuge); }

    }
     
   
     
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnGuardar;
    private Label.HoverIcon hvadd;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblconyugue;
    private javax.swing.JLabel lbldui;
    private javax.swing.JLabel lblnombre;
    public javax.swing.JTextField txtcargo;
    public javax.swing.JTextField txtdirconyugue;
    public javax.swing.JTextField txtdui;
    public javax.swing.JTextField txtlugartrabajo;
    public javax.swing.JTextField txtnombre;
    public javax.swing.JTextField txtnombrecony;
    public javax.swing.JTextField txttelcon;
    // End of variables declaration//GEN-END:variables
}
