
package FORMS.PANELS;


import Entidades.DatosPersonales;
import Entidades.Domicilio;
import CONTROLADORES.DatosPersonalesJpaController;

import CONTROLADORES.DomicilioJpaController;
import CONTROLADORES.exceptions.NonexistentEntityException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author DFUENTES
 */
public class DATOS_PERSONALES_PNL extends javax.swing.JPanel {
    
    CLIENTE_PNL panelppal;
    
    public DatosPersonales datospersonales = new DatosPersonales();
    public Domicilio       domicilio       = new Domicilio();
    
    public DatosPersonalesJpaController dtjc = new DatosPersonalesJpaController();
    public DomicilioJpaController       domjc= new DomicilioJpaController();
    
    public String msjValidacion;
    
    public DATOS_PERSONALES_PNL(CLIENTE_PNL ppal) {
        initComponents();  
        panelppal = ppal;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbldatospersonales = new javax.swing.JLabel();
        lblnombre = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        txtdui = new javax.swing.JTextField();
        lbldui = new javax.swing.JLabel();
        dtexpedicion = new com.toedter.calendar.JDateChooser();
        lblfechexp = new javax.swing.JLabel();
        lblcivil = new javax.swing.JLabel();
        cmbcivil = new javax.swing.JComboBox<>();
        lblnacimiento = new javax.swing.JLabel();
        dtnacimiento = new com.toedter.calendar.JDateChooser();
        lbledad = new javax.swing.JLabel();
        txtedad = new javax.swing.JTextField();
        txtnit = new javax.swing.JTextField();
        lblnit = new javax.swing.JLabel();
        lblocupacion = new javax.swing.JLabel();
        lblocupacion1 = new javax.swing.JLabel();
        txtocupacion = new javax.swing.JTextField();
        txtprofesion = new javax.swing.JTextField();
        cmbestudio = new javax.swing.JComboBox<>();
        lblnivelest = new javax.swing.JLabel();
        lbltel = new javax.swing.JLabel();
        txttelpers = new javax.swing.JTextField();
        lblcel = new javax.swing.JLabel();
        txtcel = new javax.swing.JTextField();
        lblconyugue1 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtanios = new javax.swing.JTextField();
        txtllegar = new javax.swing.JTextField();
        txtreferencia = new javax.swing.JTextField();
        txtdireccion = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        cmbsituacionv = new javax.swing.JComboBox<>();
        jLabel24 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtdependen = new javax.swing.JTextField();
        txtnumhijos = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();

        setBackground(new java.awt.Color(240, 236, 236));
        setPreferredSize(new java.awt.Dimension(934, 661));

        lbldatospersonales.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        lbldatospersonales.setForeground(new java.awt.Color(51, 51, 51));
        lbldatospersonales.setText("DATOS PERSONALES");

        lblnombre.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        lblnombre.setForeground(new java.awt.Color(51, 51, 51));
        lblnombre.setText("Nombre:");

        txtnombre.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        txtnombre.setPreferredSize(new java.awt.Dimension(400, 19));
        txtnombre.setSelectionColor(new java.awt.Color(51, 255, 204));
        txtnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnombreKeyTyped(evt);
            }
        });

        txtdui.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N

        lbldui.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        lbldui.setForeground(new java.awt.Color(51, 51, 51));
        lbldui.setText("DUI:");

        dtexpedicion.setBackground(new java.awt.Color(240, 236, 236));

        lblfechexp.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        lblfechexp.setForeground(new java.awt.Color(51, 51, 51));
        lblfechexp.setText("Fecha de expedición:");

        lblcivil.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        lblcivil.setForeground(new java.awt.Color(51, 51, 51));
        lblcivil.setText("Estado Civil:");

        cmbcivil.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        cmbcivil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<SELECCIONAR>", "SOLTERO/A", "CASADO/A", "DIVORCIADO/A", "VIUDO/A" }));

        lblnacimiento.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        lblnacimiento.setForeground(new java.awt.Color(51, 51, 51));
        lblnacimiento.setText("Fecha de nacimiento:");

        dtnacimiento.setBackground(new java.awt.Color(240, 236, 236));

        lbledad.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        lbledad.setForeground(new java.awt.Color(51, 51, 51));
        lbledad.setText("Edad:");

        txtedad.setEditable(false);
        txtedad.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N

        txtnit.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N

        lblnit.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        lblnit.setForeground(new java.awt.Color(51, 51, 51));
        lblnit.setText("NIT:");

        lblocupacion.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        lblocupacion.setForeground(new java.awt.Color(51, 51, 51));
        lblocupacion.setText("Profesión:");

        lblocupacion1.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        lblocupacion1.setForeground(new java.awt.Color(51, 51, 51));
        lblocupacion1.setText("Ocupación:");

        txtocupacion.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        txtocupacion.setPreferredSize(new java.awt.Dimension(400, 19));
        txtocupacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtocupacionKeyTyped(evt);
            }
        });

        txtprofesion.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        txtprofesion.setPreferredSize(new java.awt.Dimension(400, 19));
        txtprofesion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtprofesionKeyTyped(evt);
            }
        });

        cmbestudio.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        cmbestudio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<SELECCIONAR>", "PRIMARIA", "EDUCACION BASICA", "BACHILLERATO", "TECNICO", "UNIVERSITARIO" }));

        lblnivelest.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        lblnivelest.setForeground(new java.awt.Color(51, 51, 51));
        lblnivelest.setText("Nivel de Estudio:");

        lbltel.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        lbltel.setForeground(new java.awt.Color(51, 51, 51));
        lbltel.setText("Télefono:");

        txttelpers.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N

        lblcel.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        lblcel.setForeground(new java.awt.Color(51, 51, 51));
        lblcel.setText("Celular:");

        txtcel.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N

        lblconyugue1.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        lblconyugue1.setForeground(new java.awt.Color(51, 51, 51));
        lblconyugue1.setText("DOMICILIO");

        jLabel18.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(51, 51, 51));
        jLabel18.setText("Dirección:");

        jLabel13.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 51, 51));
        jLabel13.setText("Punto de referencia:");

        jLabel14.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 51, 51));
        jLabel14.setText("Como llegar:");

        jLabel15.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(51, 51, 51));
        jLabel15.setText("Años:");

        txtanios.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N

        txtllegar.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        txtllegar.setPreferredSize(new java.awt.Dimension(674, 19));
        txtllegar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtllegarKeyTyped(evt);
            }
        });

        txtreferencia.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        txtreferencia.setPreferredSize(new java.awt.Dimension(674, 19));
        txtreferencia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtreferenciaKeyTyped(evt);
            }
        });

        txtdireccion.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        txtdireccion.setPreferredSize(new java.awt.Dimension(400, 19));
        txtdireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtdireccionKeyTyped(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(51, 51, 51));
        jLabel16.setText("Situación de vivienda:");

        cmbsituacionv.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        cmbsituacionv.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<SELECCIONAR>", "PROPIA", "ALQUILADA", "FAMILIAR" }));

        jLabel24.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(51, 51, 51));
        jLabel24.setText("Dependen Economicamente:");

        jLabel19.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(51, 51, 51));
        jLabel19.setText("Nº de hijos:");

        txtdependen.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N

        txtnumhijos.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N

        btnGuardar.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(51, 51, 51));
        btnGuardar.setText("GUARDAR");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
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
                            .addComponent(lblnombre, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbldui, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblfechexp, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblcivil, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblnacimiento, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblocupacion, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblocupacion1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblnivelest, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbltel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbsituacionv, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(dtnacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbledad)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtedad, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txttelpers, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblcel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtcel, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtdui, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblnit)
                                .addGap(5, 5, 5)
                                .addComponent(txtnit, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cmbestudio, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbcivil, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dtexpedicion, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtanios, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtocupacion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtprofesion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtnombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtdependen, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtnumhijos, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(txtreferencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtllegar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblconyugue1)
                    .addComponent(lbldatospersonales)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(115, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lbldatospersonales)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblnombre)
                    .addComponent(txtnombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lbldui)
                    .addComponent(txtdui, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblnit)
                    .addComponent(txtnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblfechexp)
                    .addComponent(dtexpedicion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblcivil)
                    .addComponent(cmbcivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lbledad)
                    .addComponent(txtedad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dtnacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblnacimiento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblocupacion)
                            .addComponent(txtprofesion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(lblocupacion1)
                            .addComponent(txtocupacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(txtdependen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtnumhijos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19))
                        .addGap(5, 5, 5)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblnivelest)
                    .addComponent(cmbestudio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lbltel)
                    .addComponent(txttelpers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblcel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblconyugue1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtdireccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtreferencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtllegar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtanios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)))
                    .addComponent(cmbsituacionv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel16)))
                .addGap(18, 18, 18)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(211, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtnombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombreKeyTyped
        Character c = evt.getKeyChar();
        if(Character.isLetter(c)) {
            evt.setKeyChar(Character.toUpperCase(c));
        }
    }//GEN-LAST:event_txtnombreKeyTyped

    private void txtocupacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtocupacionKeyTyped
        Character c = evt.getKeyChar();
        if(Character.isLetter(c)) {
            evt.setKeyChar(Character.toUpperCase(c));
        }
    }//GEN-LAST:event_txtocupacionKeyTyped

    private void txtprofesionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtprofesionKeyTyped
        Character c = evt.getKeyChar();
        if(Character.isLetter(c)) {
            evt.setKeyChar(Character.toUpperCase(c));
        }
    }//GEN-LAST:event_txtprofesionKeyTyped

    private void txtllegarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtllegarKeyTyped
        Character c = evt.getKeyChar();
        if(Character.isLetter(c)) {
            evt.setKeyChar(Character.toUpperCase(c));
        }
    }//GEN-LAST:event_txtllegarKeyTyped

    private void txtreferenciaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtreferenciaKeyTyped
        Character c = evt.getKeyChar();
        if(Character.isLetter(c)) {
            evt.setKeyChar(Character.toUpperCase(c));
        }
    }//GEN-LAST:event_txtreferenciaKeyTyped

    private void txtdireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdireccionKeyTyped
        Character c = evt.getKeyChar();
        if(Character.isLetter(c)) {
            evt.setKeyChar(Character.toUpperCase(c));
        }
    }//GEN-LAST:event_txtdireccionKeyTyped

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        boolean verificacion = true;
        boolean edicion = false;
        
        try{
            if (dtjc.findDatosPersonales(txtdui.getText()) != null) {
                edicion = true;
            }
        }catch(Exception ex){JOptionPane.showMessageDialog(null, "Error de conexión a la base.\n");}

        if (validarCampos() == false) {
            JOptionPane.showMessageDialog(null, msjValidacion);
        } else {

            llenardatospersonales();
            llenardatosdomicilio();

            if (edicion == false) {
                try {
                    dtjc.create(datospersonales);
                    domjc.create(domicilio);
                    panelppal.actualizarPanelesCliente();
                } catch (Exception ex) {
                    verificacion=false;
                    JOptionPane.showMessageDialog(null, "Error al registrar el cliente.\n");
                }
                if(verificacion){JOptionPane.showMessageDialog(null, "Datos del Cliente Registrados con éxito.");}
                
            } else {

                try {
                    dtjc.edit(datospersonales);
                    domjc.edit(domicilio);
                } catch (NonexistentEntityException ex) {
                    verificacion = false;
                    JOptionPane.showMessageDialog(null, "Error al actualizar el cliente.\n");
                } catch (Exception ex) {
                    verificacion = false;
                    JOptionPane.showMessageDialog(null, "Error al actualizar el cliente.\n");
                }
                if(verificacion){JOptionPane.showMessageDialog(null, "Datos del Cliente actualizados con éxito.");}
            }
        }
        
    }//GEN-LAST:event_btnGuardarActionPerformed

    public void limpiarcampos(){
        
        //DATOS PERSONALES 
        txtdui.setText("");
        txtnombre.setText("");
        txtnit.setText("");
        dtnacimiento.setDate(null);
        cmbcivil.setSelectedIndex(0);
        txtedad.setText("");
        dtexpedicion.setDate(null);
        txtprofesion.setText("");
        txtocupacion.setText("");
        cmbestudio.setSelectedIndex(0);
        txttelpers.setText("");
        txtcel.setText("");
        txtdependen.setText("");
        txtnumhijos.setText("");
        
            //DATOS DOMICILIO
        txtdireccion.setText("");
        txtreferencia.setText("");
        txtllegar.setText("");
        txtanios.setText("");
        cmbsituacionv.setSelectedIndex(0);
        
        domicilio = null; domicilio = new Domicilio();
        datospersonales = null; datospersonales = new DatosPersonales();

    }
    
    public void llenardatospersonales(){
        
            datospersonales.setCelular(txtcel.getText().trim());
            datospersonales.setDui(txtdui.getText().trim());
            datospersonales.setEstadoCivil((short)cmbcivil.getSelectedIndex());
            datospersonales.setFechaExpedicion(dtexpedicion.getDate());
            datospersonales.setFechaNacimiento(dtnacimiento.getDate());
            datospersonales.setNit(txtnit.getText().trim());
            datospersonales.setNivelEstudio((short)cmbestudio.getSelectedIndex());
            datospersonales.setNombre(txtnombre.getText().trim());
            datospersonales.setOcupacion(txtocupacion.getText().trim());
            datospersonales.setProfesion(txtprofesion.getText().trim());
            datospersonales.setTelefono(txttelpers.getText().trim());
            if (txtnumhijos.getText().isEmpty() == false) {
                    datospersonales.setCantidadHijos(txtnumhijos.getText().trim());
            } else {
                    datospersonales.setCantidadHijos("0");}
            if (txtdependen.getText().isEmpty() == false) {
                    datospersonales.setDependen(txtdependen.getText().trim());
            } else {
                    datospersonales.setDependen("0");}
    }

    public void llenardatosdomicilio(){
            domicilio.setDui(txtdui.getText());
            domicilio.setComoLlegar(txtllegar.getText());
            domicilio.setDomicilio(txtdireccion.getText());
            domicilio.setPuntoReferencia(txtreferencia.getText());
            domicilio.setSituacionVivienta((short)cmbsituacionv.getSelectedIndex());
            domicilio.setDatosPersonales(datospersonales);
            if (txtanios.getText().isEmpty() == false) {
                    domicilio.setTiempoVivienda(txtanios.getText());
            } else {
                    domicilio.setTiempoVivienda("0");}

    }
    
    public void cargardatospersonales(DatosPersonales dt){
           
        txtdui.setText(dt.getDui());
        txtnombre.setText(dt.getNombre());
        txtnit.setText(dt.getNit());
        txttelpers.setText(dt.getTelefono());
        txtcel.setText(dt.getCelular());
        txtprofesion.setText(dt.getProfesion());
        txtocupacion.setText(dt.getOcupacion());
        cmbcivil.setSelectedIndex(dt.getEstadoCivil());
        cmbestudio.setSelectedIndex(dt.getNivelEstudio());
        dtnacimiento.setDate(dt.getFechaNacimiento());
        dtexpedicion.setDate(dt.getFechaExpedicion());  
        txtdependen.setText(dt.getDependen());
        txtnumhijos.setText(dt.getCantidadHijos());
    
    }
    
    public void cargardomicilio(Domicilio dom){
        
        txtdireccion.setText(dom.getDomicilio());
        txtreferencia.setText(dom.getPuntoReferencia());
        txtllegar.setText(dom.getComoLlegar());
        txtanios.setText(dom.getTiempoVivienda());
        cmbsituacionv.setSelectedIndex(dom.getSituacionVivienta());
          
    }
    
    public void recibirDatos(DatosPersonales dp){
    
        datospersonales = dp;
        domicilio = dp.getDomicilio();
        
        if (datospersonales != null) {cargardatospersonales(datospersonales); }
        if (domicilio != null) {cargardomicilio(domicilio);}

    }
    
    public boolean validarCampos(){
            
            msjValidacion = "Falta llenar campos obligatorios:\n";
            boolean validacion =true; 
            if(txtnombre.getText().trim().isEmpty()){validacion=false; msjValidacion += "*Nombre\n";}
            if(txtdui.getText().trim().isEmpty()){validacion=false; msjValidacion += "*DUI\n"; }
            if(txtnit.getText().trim().isEmpty()){validacion=false; msjValidacion += "*NIT\n";}
            if(dtexpedicion.getDate() == null ){validacion=false; msjValidacion += "*Fecha de Expedición (DUI)\n";}
            if(dtnacimiento.getDate() == null ){validacion=false; msjValidacion += "*Fecha de Nacimiento (DUI)\n";}
            if(cmbcivil.getSelectedIndex()==0){validacion=false; msjValidacion += "*Estado Civil\n";} 
            if(cmbestudio.getSelectedIndex()==0){validacion=false; msjValidacion += "*Nivel de Estudio\n";} 
            if(txtdireccion.getText().trim().isEmpty()){validacion=false; msjValidacion += "*Dirección de vivienda\n"; }
            if(txtanios.getText().trim().isEmpty()){validacion=false; msjValidacion += "*Años en vivienda\n";}
            if(cmbsituacionv.getSelectedIndex()==0){validacion=false; msjValidacion += "*Situación en vivienda\n";}
            return validacion;
    }
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    public javax.swing.JComboBox<String> cmbcivil;
    public javax.swing.JComboBox<String> cmbestudio;
    public javax.swing.JComboBox<String> cmbsituacionv;
    private com.toedter.calendar.JDateChooser dtexpedicion;
    private com.toedter.calendar.JDateChooser dtnacimiento;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel lblcel;
    private javax.swing.JLabel lblcivil;
    private javax.swing.JLabel lblconyugue1;
    private javax.swing.JLabel lbldatospersonales;
    private javax.swing.JLabel lbldui;
    private javax.swing.JLabel lbledad;
    private javax.swing.JLabel lblfechexp;
    private javax.swing.JLabel lblnacimiento;
    private javax.swing.JLabel lblnit;
    private javax.swing.JLabel lblnivelest;
    private javax.swing.JLabel lblnombre;
    private javax.swing.JLabel lblocupacion;
    private javax.swing.JLabel lblocupacion1;
    private javax.swing.JLabel lbltel;
    public javax.swing.JTextField txtanios;
    public javax.swing.JTextField txtcel;
    public javax.swing.JTextField txtdependen;
    public javax.swing.JTextField txtdireccion;
    public javax.swing.JTextField txtdui;
    public javax.swing.JTextField txtedad;
    public javax.swing.JTextField txtllegar;
    public javax.swing.JTextField txtnit;
    public javax.swing.JTextField txtnombre;
    public javax.swing.JTextField txtnumhijos;
    public javax.swing.JTextField txtocupacion;
    public javax.swing.JTextField txtprofesion;
    public javax.swing.JTextField txtreferencia;
    public javax.swing.JTextField txttelpers;
    // End of variables declaration//GEN-END:variables
}
