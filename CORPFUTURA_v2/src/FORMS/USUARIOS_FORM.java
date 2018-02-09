package FORMS;

import CONTROLADORES.UsuariosJpaController;
import CONTROLADORES.exceptions.IllegalOrphanException;
import CONTROLADORES.exceptions.NonexistentEntityException;
import Entidades.Usuarios;
import MODELOSTBL.modeloUsuarios;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author DFUENTES
 */
public class USUARIOS_FORM extends javax.swing.JFrame {

    public modeloUsuarios modelo = new modeloUsuarios();
    public Usuarios usuario = new Usuarios();
    public UsuariosJpaController ujc = new UsuariosJpaController();

    public USUARIOS_FORM() {
        initComponents();
        this.setLocationRelativeTo(null);
        cargarModelo();
        txtCartera.setEnabled(false);
        btnModificar.setVisible(false);
        btnEliminar.setVisible(false);

    }

    public void cargarModelo() {
        modelo.borrartodos();

        for (Usuarios usuario : ujc.findUsuariosEntities()) {
            modelo.agregarUsuario(usuario);
        }
        tblUsuarios.clearSelection();
        tblUsuarios.updateUI();
    }

    public boolean GuardarUsuario(Usuarios usuario) {
        boolean estado = true;
       
            usuario.setIdUsuario(ujc.getUsuariosCount() + 1);
            usuario.setNombre(txtNombre.getText());
            usuario.setRol((short) cmbRol.getSelectedIndex());
            if (chkCartera.isSelected()) {
                usuario.setChkCartera(true);
                usuario.setCartera(Short.parseShort(txtCartera.getText()));
            } else {
                usuario.setChkCartera(false);
            }
            try {
                ujc.create(usuario);
            } catch (Exception ex) {
                estado = false;
            }
        return estado;
    }
    
    public boolean ModificarUsuario(Usuarios usuario) {
        boolean estado = true;
    
            usuario.setNombre(txtNombre.getText());
            usuario.setRol((short) cmbRol.getSelectedIndex());
            if (chkCartera.isSelected()) {
                usuario.setChkCartera(true);
                usuario.setCartera(Short.parseShort(txtCartera.getText()));
            } else {
                usuario.setChkCartera(false);
            }
            try {
                ujc.edit(usuario);
            } catch (Exception ex) {
                estado = false;
            }
        return estado;
    }

    public void limpiarUsuario() {
        txtNombre.setText("");
        txtCartera.setText("");
        chkCartera.setSelected(false);
        cmbRol.setSelectedIndex(0);
    }

    public boolean validarUsuario() {
        boolean validacion = true;
        if (txtNombre.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Falta rellenar el nombre");
            validacion = false;
        }
        if (chkCartera.isSelected() && txtCartera.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Falta rellenar el campo de la Cartera");
            validacion = false;
        }
        if (cmbRol.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Falta seleccionar un rol");
            validacion = false;
        }
        return validacion;
    }

    public void cargarUsuario(int indice) {
        limpiarUsuario();
        usuario = modelo.obtenerUsuario(indice);
        cmbRol.setSelectedIndex(usuario.getRol());
        txtNombre.setText(usuario.getNombre());
        chkCartera.setSelected(usuario.getChkCartera());
        btnModificar.setVisible(true);
        btnGuardar.setVisible(false);
        btnEliminar.setVisible(true);
        if (usuario.getChkCartera()) {
            txtCartera.setText(usuario.getCartera().toString());
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        encabezado = new javax.swing.JPanel();
        hvCerrar = new Label.HoverIcon();
        jLabel1 = new javax.swing.JLabel();
        contenido = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        chkCartera = new javax.swing.JCheckBox();
        btnGuardar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cmbRol = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsuarios = new javax.swing.JTable();
        txtCartera = new javax.swing.JTextField();
        btnEliminar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(240, 236, 236));
        setModalExclusionType(java.awt.Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        setUndecorated(true);
        setResizable(false);

        encabezado.setBackground(new java.awt.Color(45, 74, 103));

        hvCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/ICONS/cerrarDes2.png"))); // NOI18N
        hvCerrar.setText("hoverIcon1");
        hvCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hvCerrarMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("USUARIOS DEL SISTEMA");

        javax.swing.GroupLayout encabezadoLayout = new javax.swing.GroupLayout(encabezado);
        encabezado.setLayout(encabezadoLayout);
        encabezadoLayout.setHorizontalGroup(
            encabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, encabezadoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(319, 319, 319)
                .addComponent(hvCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        encabezadoLayout.setVerticalGroup(
            encabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(encabezadoLayout.createSequentialGroup()
                .addGroup(encabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(hvCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(0, 6, Short.MAX_VALUE))
        );

        hvCerrar.setImages("/IMAGES/ICONS/cerrarSel2.png","/IMAGES/ICONS/cerrarDes2.png");

        contenido.setBackground(new java.awt.Color(240, 236, 236));
        contenido.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(45, 74, 103), 2));

        jLabel4.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Nombre:");

        txtNombre.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("INFORMACION DE USUARIO");

        chkCartera.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        chkCartera.setForeground(new java.awt.Color(51, 51, 51));
        chkCartera.setText("Crear cartera");
        chkCartera.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        chkCartera.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkCarteraItemStateChanged(evt);
            }
        });

        btnGuardar.setText("Guardar Usuario");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Nº de Cartera:");

        jLabel9.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Rol:");

        cmbRol.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        cmbRol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<SELECCIONAR>", "ADMINISTRATIVO", "ASESOR DE CREDITO" }));

        tblUsuarios.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tblUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblUsuarios.setRowHeight(20);
        tblUsuarios.setSelectionBackground(new java.awt.Color(204, 255, 204));
        tblUsuarios.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(tblUsuarios);
        tblUsuarios.setModel(modelo);
        DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
        leftRenderer.setHorizontalAlignment(DefaultTableCellRenderer.LEFT);
        tblUsuarios.getColumn("ID").setCellRenderer( leftRenderer );
        tblUsuarios.getColumnModel().getColumn(0).setPreferredWidth(25);
        tblUsuarios.getColumnModel().getColumn(2).setPreferredWidth(150);

        tblUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                cargarUsuario(tblUsuarios.getSelectedRow());
            }
        });

        txtCartera.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtCartera.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCarteraKeyTyped(evt);
            }
        });

        btnEliminar.setText("Eliminar Usuario");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar Usuario");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout contenidoLayout = new javax.swing.GroupLayout(contenido);
        contenido.setLayout(contenidoLayout);
        contenidoLayout.setHorizontalGroup(
            contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenidoLayout.createSequentialGroup()
                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contenidoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1))
                    .addGroup(contenidoLayout.createSequentialGroup()
                        .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(contenidoLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 791, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(contenidoLayout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(chkCartera)
                                    .addGroup(contenidoLayout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtCartera, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(contenidoLayout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(52, 52, 52)
                                        .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cmbRol, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(3, 3, 3)))
                        .addGap(0, 25, Short.MAX_VALUE)))
                .addContainerGap())
        );
        contenidoLayout.setVerticalGroup(
            contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenidoLayout.createSequentialGroup()
                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contenidoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(cmbRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addComponent(chkCartera)
                        .addGap(18, 18, 18)
                        .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtCartera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(contenidoLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(encabezado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(contenido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(encabezado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(contenido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void hvCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hvCerrarMouseClicked
        this.dispose();
    }//GEN-LAST:event_hvCerrarMouseClicked

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (validarUsuario()) {
            if (GuardarUsuario(usuario)) {
                JOptionPane.showMessageDialog(null, "Usuario registrado con éxito");
                limpiarUsuario();
                cargarModelo();
            } else {
                JOptionPane.showMessageDialog(null, "Error al regstrar el usuario");
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtCarteraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCarteraKeyTyped
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9')) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCarteraKeyTyped

    private void chkCarteraItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkCarteraItemStateChanged
        if (chkCartera.isSelected()) {
            txtCartera.setEnabled(true);
        } else {
            txtCartera.setEnabled(false);
        }
    }//GEN-LAST:event_chkCarteraItemStateChanged

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(null, "Desea eliminar el usuario seleccionado?", "Advertencia", dialogButton);
        if (dialogResult == JOptionPane.YES_OPTION) {
            if (usuario.getSolicitudCreditoList().isEmpty()) {
                try {
                    ujc.destroy(usuario.getIdUsuario());
                    cargarModelo();
                    limpiarUsuario();
                    btnGuardar.setVisible(true);
                    btnModificar.setVisible(false);
                    btnEliminar.setVisible(false);
                    JOptionPane.showMessageDialog(null, "Usuario Eliminado con éxito!");
                } catch (IllegalOrphanException ex) {
                    JOptionPane.showMessageDialog(null, "Error al eliminar al usuario: " + ex);
                } catch (NonexistentEntityException ex) {
                    JOptionPane.showMessageDialog(null, "Error al eliminar al usuario: " + ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se puede eliminar el usuario: Solicitudes activas");
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (validarUsuario()) {
            if (ModificarUsuario(usuario)) {
                JOptionPane.showMessageDialog(null, "Usuario Modificado!!");
                limpiarUsuario();
                cargarModelo();
                btnModificar.setVisible(false);
                btnGuardar.setVisible(true);
                btnEliminar.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "Error al modificar el usuario");
            }
        }
    }//GEN-LAST:event_btnModificarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    public javax.swing.JCheckBox chkCartera;
    private javax.swing.JComboBox<String> cmbRol;
    private javax.swing.JPanel contenido;
    private javax.swing.JPanel encabezado;
    private Label.HoverIcon hvCerrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tblUsuarios;
    private javax.swing.JTextField txtCartera;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
