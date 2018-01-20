
package FORMS.PANELS;

import Entidades.DatosPersonales;
import Entidades.InformacionNegocio;
import CONTROLADORES.InformacionNegocioJpaController;
import CONTROLADORES.exceptions.NonexistentEntityException;
import CONTROLADORES.exceptions.PreexistingEntityException;
import javax.swing.JOptionPane;

/**
 *
 * @author DFUENTES
 */
public class NEGOCIO_PNL extends javax.swing.JPanel {

    public InformacionNegocio negocio;
    public DatosPersonales datospersonales;
    
    public InformacionNegocioJpaController  injc = new InformacionNegocioJpaController();
   
    
    public String direccionpersonal;
    public String puntorefpersonal;
    public String telpersonal;
    
    public NEGOCIO_PNL() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel24 = new javax.swing.JLabel();
        txtutilidad = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        txtnumempleados = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cmbtipolocal = new javax.swing.JComboBox<>();
        txtnombreneg = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtgiro = new javax.swing.JTextField();
        txtdireccionneg = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtreferencianeg = new javax.swing.JTextField();
        txttiempofun = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txttelneg = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txthorario = new javax.swing.JTextField();
        txtrutas = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        lblnombre = new javax.swing.JLabel();
        lbldui = new javax.swing.JLabel();
        txtdui = new javax.swing.JTextField();
        txtnombre = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        hvadd = new Label.HoverIcon();
        hvadd1 = new Label.HoverIcon();

        setBackground(new java.awt.Color(240, 236, 236));

        jLabel24.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(51, 51, 51));
        jLabel24.setText("Utilidad mensual:");

        txtutilidad.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N

        jLabel25.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(51, 51, 51));
        jLabel25.setText("Nº de empleados:");

        txtnumempleados.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N

        jLabel26.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(51, 51, 51));
        jLabel26.setText("Tipo de local:");

        jLabel10.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("DATOS DEL NEGOCIO");

        cmbtipolocal.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        cmbtipolocal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<SELECCIONAR>", "PROPIO", "ALQUILADO" }));

        txtnombreneg.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        txtnombreneg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnombrenegKeyTyped(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Nombre:");

        jLabel2.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Giro:");

        txtgiro.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        txtgiro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtgiroKeyTyped(evt);
            }
        });

        txtdireccionneg.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        txtdireccionneg.setPreferredSize(new java.awt.Dimension(584, 19));
        txtdireccionneg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtdireccionnegKeyTyped(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(51, 51, 51));
        jLabel18.setText("Dirección:");

        jLabel13.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 51, 51));
        jLabel13.setText("Punto de referencia:");

        txtreferencianeg.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        txtreferencianeg.setPreferredSize(new java.awt.Dimension(584, 19));
        txtreferencianeg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtreferencianegKeyTyped(evt);
            }
        });

        txttiempofun.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Tiempo en función:");

        txttelneg.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N

        jLabel23.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(51, 51, 51));
        jLabel23.setText("Télefono:");

        jLabel19.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(51, 51, 51));
        jLabel19.setText("Horarios:");

        txthorario.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        txthorario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txthorarioKeyTyped(evt);
            }
        });

        txtrutas.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        txtrutas.setPreferredSize(new java.awt.Dimension(584, 19));
        txtrutas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtrutasKeyTyped(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(51, 51, 51));
        jLabel20.setText("Rutas:");

        jLabel11.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("CLIENTE");

        lblnombre.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        lblnombre.setForeground(new java.awt.Color(51, 51, 51));
        lblnombre.setText("Nombre:");

        lbldui.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        lbldui.setForeground(new java.awt.Color(51, 51, 51));
        lbldui.setText("DUI:");

        txtdui.setEditable(false);
        txtdui.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N

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

        hvadd1.setText("hoverIcon1");
        hvadd1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hvadd1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbtipolocal, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtutilidad, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel25)
                                        .addGap(4, 4, 4)
                                        .addComponent(txtnumempleados, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtnombreneg, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtgiro, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txttiempofun, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txttelneg, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(hvadd1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txthorario, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txtrutas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtdireccionneg, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtreferencianeg, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(hvadd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbldui)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtdui, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblnombre)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 180, Short.MAX_VALUE)))
                .addContainerGap())
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
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtnombreneg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel3)
                    .addComponent(txttiempofun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtgiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtdireccionneg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(hvadd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtreferencianeg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(txttelneg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hvadd1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txthorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel20)
                    .addComponent(txtrutas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtnumempleados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel24)
                                .addComponent(txtutilidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel25))))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(cmbtipolocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(83, Short.MAX_VALUE))
        );

        hvadd.setImages("/IMAGES/ICONS/add1.png","/IMAGES/ICONS/add.png");
        hvadd1.setImages("/IMAGES/ICONS/add1.png","/IMAGES/ICONS/add.png");
    }// </editor-fold>//GEN-END:initComponents

    private void txtnombrenegKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombrenegKeyTyped
        Character c = evt.getKeyChar();
        if(Character.isLetter(c)) {
            evt.setKeyChar(Character.toUpperCase(c));
        }
    }//GEN-LAST:event_txtnombrenegKeyTyped

    private void txtgiroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtgiroKeyTyped
        Character c = evt.getKeyChar();
        if(Character.isLetter(c)) {
            evt.setKeyChar(Character.toUpperCase(c));
        }
    }//GEN-LAST:event_txtgiroKeyTyped

    private void txtdireccionnegKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdireccionnegKeyTyped
        Character c = evt.getKeyChar();
        if(Character.isLetter(c)) {
            evt.setKeyChar(Character.toUpperCase(c));
        }
    }//GEN-LAST:event_txtdireccionnegKeyTyped

    private void txtreferencianegKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtreferencianegKeyTyped
        Character c = evt.getKeyChar();
        if(Character.isLetter(c)) {
            evt.setKeyChar(Character.toUpperCase(c));
        }
    }//GEN-LAST:event_txtreferencianegKeyTyped

    private void txthorarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txthorarioKeyTyped
        Character c = evt.getKeyChar();
        if(Character.isLetter(c)) {
            evt.setKeyChar(Character.toUpperCase(c));
        }
    }//GEN-LAST:event_txthorarioKeyTyped

    private void txtrutasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtrutasKeyTyped
        Character c = evt.getKeyChar();
        if(Character.isLetter(c)) {
            evt.setKeyChar(Character.toUpperCase(c));
        }
    }//GEN-LAST:event_txtrutasKeyTyped

    private void txtnombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombreKeyTyped
        Character c = evt.getKeyChar();
        if(Character.isLetter(c)) {
            evt.setKeyChar(Character.toUpperCase(c));
        }
    }//GEN-LAST:event_txtnombreKeyTyped

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        
        boolean verificacion = true;
        boolean edicion = false;
        if (negocio != null) {
            edicion = true;     
        }

        if (txtnombreneg.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Falta llenar campos obligatorios\n*Nombre del Negocio");
        } else {  
            
            llenarnegocio();
     
            if (edicion == false) {   
                try {
                    injc.create(negocio);
                } catch (PreexistingEntityException ex) {
                    verificacion=false;
                    JOptionPane.showMessageDialog(null, "Error al registrar el negocio del cliente.\n");
                } catch (Exception ex) {
                    verificacion=false;
                    JOptionPane.showMessageDialog(null, "Error al registrar el negocio del cliente.\n");
                }
                if(verificacion){JOptionPane.showMessageDialog(null, "Datos del negocio registrados con exito");}

            } else {
                try {
                    injc.edit(negocio);
                } catch (NonexistentEntityException ex) {
                    verificacion=false;
                    JOptionPane.showMessageDialog(null, "Error al actualizar el negocio del cliente.\n");
                } catch (Exception ex) {
                    verificacion=false;
                    JOptionPane.showMessageDialog(null, "Error al actualizar el negocio del cliente.\n");
                }
                if(verificacion){JOptionPane.showMessageDialog(null, "Datos del negocio actualizados con exito");}
                
            }
        }
        
        
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void hvaddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hvaddMouseClicked
        txtdireccionneg.setText(direccionpersonal);
        txtreferencianeg.setText(puntorefpersonal);
    }//GEN-LAST:event_hvaddMouseClicked

    private void hvadd1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hvadd1MouseClicked
        txttelneg.setText(telpersonal);
    }//GEN-LAST:event_hvadd1MouseClicked

     public void limpiarcampos(){
        
        //DATOS NEGOCIO
        txtnombreneg.setText("");
        txtgiro.setText("");
        txttiempofun.setText("");
        txtdireccionneg.setText("");
        txtreferencianeg.setText("");
        txttelneg.setText("");
        txthorario.setText("");
        txtrutas.setText("");
        txtutilidad.setText("");
        txtnumempleados.setText("");
        cmbtipolocal.setSelectedIndex(0);
        txtnombre.setText("");
        txtdui.setText("");
        
        negocio = null;
        datospersonales = null;
        btnGuardar.setEnabled(false);
        
    }
     
     public void llenarnegocio(){
           
                negocio = new InformacionNegocio();
                negocio.setComoLlegar(txtreferencianeg.getText());
                negocio.setDireccion(txtdireccionneg.getText());
                negocio.setDui(txtdui.getText());
                negocio.setGiro(txtgiro.getText());
                negocio.setHorarios(txthorario.getText());
                negocio.setNombre(txtnombreneg.getText());
                negocio.setRutasVenta(txtrutas.getText());
                negocio.setTelefono(txttelneg.getText());
                negocio.setTipoLocal((short)cmbtipolocal.getSelectedIndex());
                negocio.setNumeroEmpleados(txtnumempleados.getText());
                negocio.setTiempoFuncion(txttiempofun.getText());
                negocio.setUtilidadMensual(txtutilidad.getText());
                negocio.setDatosPersonales(datospersonales);
    }
       
     public void cargarnegocio(InformacionNegocio in){
         
        txtnombreneg.setText(in.getNombre());
        txtgiro.setText(in.getGiro());
        txttiempofun.setText(String.valueOf(in.getTiempoFuncion()));
        txtdireccionneg.setText(in.getDireccion());
        txtreferencianeg.setText(in.getComoLlegar());
        txttelneg.setText(in.getTelefono());
        txthorario.setText(in.getHorarios());
        txtrutas.setText(in.getRutasVenta());
        txtutilidad.setText(in.getUtilidadMensual());
        txtnumempleados.setText(in.getNumeroEmpleados());
        cmbtipolocal.setSelectedIndex(in.getTipoLocal());
    
     }
     
     public void cargarCliente(DatosPersonales dp){
        
        datospersonales = dp;
        txtnombre.setText(dp.getNombre());
        txtdui.setText(dp.getDui());
    
    }
     
    public void recibirDatos(DatosPersonales dp){
    
        cargarCliente(dp);
        negocio = dp.getInformacionNegocio();      
        if (negocio != null) { cargarnegocio(negocio); }

    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnGuardar;
    public javax.swing.JComboBox<String> cmbtipolocal;
    private Label.HoverIcon hvadd;
    private Label.HoverIcon hvadd1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbldui;
    private javax.swing.JLabel lblnombre;
    public javax.swing.JTextField txtdireccionneg;
    public javax.swing.JTextField txtdui;
    public javax.swing.JTextField txtgiro;
    public javax.swing.JTextField txthorario;
    public javax.swing.JTextField txtnombre;
    public javax.swing.JTextField txtnombreneg;
    public javax.swing.JTextField txtnumempleados;
    public javax.swing.JTextField txtreferencianeg;
    public javax.swing.JTextField txtrutas;
    public javax.swing.JTextField txttelneg;
    public javax.swing.JTextField txttiempofun;
    public javax.swing.JTextField txtutilidad;
    // End of variables declaration//GEN-END:variables
}
