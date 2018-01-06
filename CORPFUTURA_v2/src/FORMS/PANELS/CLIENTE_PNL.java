
package FORMS.PANELS;


import Entidades.DatosPersonales;
import CONTROLADORES.DatosPersonalesJpaController;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author DFUENTES
 */
public class CLIENTE_PNL extends javax.swing.JPanel {

    public DATOS_PERSONALES_PNL dpp = new DATOS_PERSONALES_PNL(this);
    public NEGOCIO_PNL          inp = new NEGOCIO_PNL();
    public CONYUGE_PNL          icp = new CONYUGE_PNL();
    public CODEUDORES_PNL       cop = new CODEUDORES_PNL();
    public BIENES_PNL           dbp = new BIENES_PNL();
    public REFERENCIAS_PNL      rfp = new REFERENCIAS_PNL();
    
    public DatosPersonales              datospersonalesdb   = new DatosPersonales();
    public DatosPersonalesJpaController dtjc                = new DatosPersonalesJpaController();
    
    
    public CLIENTE_PNL() {
       initComponents();
       cargarPanel(dpp);
       
    }
    
    public void cargarPanel(JPanel panel){
        
            panel.setLocation(0,0);
            panel.setSize(500,500);
            contenidoCliente.removeAll();
            contenidoCliente.add(panel);
            contenidoCliente.revalidate();
            contenidoCliente.repaint();
    
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgroup = new javax.swing.ButtonGroup();
        menuCliente = new javax.swing.JPanel();
        txtBusqueda = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        rbndui = new javax.swing.JRadioButton();
        rbnnombre = new javax.swing.JRadioButton();
        hvConyuge = new Label.HvLabel();
        hvNegocio = new Label.HvLabel();
        hvBienes = new Label.HvLabel();
        hvCodeudores = new Label.HvLabel();
        hvDatosPerson = new Label.HvLabel();
        hvNuevoCliente = new Label.HoverIcon();
        hvReferencias = new Label.HvLabel();
        jSeparator2 = new javax.swing.JSeparator();
        contenidoCliente = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 51, 153));

        menuCliente.setBackground(new java.awt.Color(71, 109, 146));
        menuCliente.setPreferredSize(new java.awt.Dimension(539, 140));

        txtBusqueda.setBackground(new java.awt.Color(71, 109, 146));
        txtBusqueda.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        txtBusqueda.setForeground(new java.awt.Color(204, 204, 204));
        txtBusqueda.setBorder(null);
        txtBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBusquedaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBusquedaKeyTyped(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/ICONS/search.png"))); // NOI18N

        rbndui.setBackground(new java.awt.Color(71, 109, 146));
        bgroup.add(rbndui);
        rbndui.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        rbndui.setForeground(new java.awt.Color(204, 204, 204));
        rbndui.setText("DUI");

        rbnnombre.setBackground(new java.awt.Color(71, 109, 146));
        bgroup.add(rbnnombre);
        rbnnombre.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        rbnnombre.setForeground(new java.awt.Color(204, 204, 204));
        rbnnombre.setText("NOMBRE");

        hvConyuge.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/LABELS/conyugeDes.png"))); // NOI18N
        hvConyuge.setPreferredSize(new java.awt.Dimension(100, 50));
        hvConyuge.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hvConyugeMouseClicked(evt);
            }
        });

        hvNegocio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/LABELS/negocioDes.png"))); // NOI18N
        hvNegocio.setPreferredSize(new java.awt.Dimension(100, 50));
        hvNegocio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hvNegocioMouseClicked(evt);
            }
        });

        hvBienes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/LABELS/bienesDes.png"))); // NOI18N
        hvBienes.setPreferredSize(new java.awt.Dimension(100, 50));
        hvBienes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hvBienesMouseClicked(evt);
            }
        });

        hvCodeudores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/LABELS/codeudoresDes.png"))); // NOI18N
        hvCodeudores.setPreferredSize(new java.awt.Dimension(100, 50));
        hvCodeudores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hvCodeudoresMouseClicked(evt);
            }
        });

        hvDatosPerson.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/LABELS/datosPersonalesAct.png"))); // NOI18N
        hvDatosPerson.setPreferredSize(new java.awt.Dimension(100, 50));
        hvDatosPerson.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hvDatosPersonMouseClicked(evt);
            }
        });

        hvNuevoCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/LABELS/nuevoClienteAct.png"))); // NOI18N
        hvNuevoCliente.setPreferredSize(new java.awt.Dimension(100, 50));
        hvNuevoCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hvNuevoClienteMouseClicked(evt);
            }
        });

        hvReferencias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/LABELS/referenciasDes.png"))); // NOI18N
        hvReferencias.setPreferredSize(new java.awt.Dimension(100, 50));
        hvReferencias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hvReferenciasMouseClicked(evt);
            }
        });

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator2.setPreferredSize(new java.awt.Dimension(50, 15));

        javax.swing.GroupLayout menuClienteLayout = new javax.swing.GroupLayout(menuCliente);
        menuCliente.setLayout(menuClienteLayout);
        menuClienteLayout.setHorizontalGroup(
            menuClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuClienteLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(menuClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menuClienteLayout.createSequentialGroup()
                        .addComponent(hvNuevoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(hvDatosPerson, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(hvConyuge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(hvNegocio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(hvReferencias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(hvBienes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(hvCodeudores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(menuClienteLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(menuClienteLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(10, 10, 10)
                        .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(rbnnombre)
                        .addGap(8, 8, 8)
                        .addComponent(rbndui)))
                .addContainerGap(191, Short.MAX_VALUE))
        );
        menuClienteLayout.setVerticalGroup(
            menuClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuClienteLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(menuClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbnnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbndui, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(menuClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menuClienteLayout.createSequentialGroup()
                        .addGap(0, 5, Short.MAX_VALUE)
                        .addGroup(menuClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hvConyuge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hvNegocio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hvBienes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hvCodeudores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hvDatosPerson, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hvNuevoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hvReferencias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(11, 11, 11))
        );

        rbnnombre.setSelected(true);
        hvConyuge.setImages("/IMAGES/LABELS/conyugeAct.png", "/IMAGES/LABELS/conyugeAct.png", "/IMAGES/LABELS/conyugeDes.png");
        hvNegocio.setImages("/IMAGES/LABELS/negocioAct.png", "/IMAGES/LABELS/negocioAct.png", "/IMAGES/LABELS/negocioDes.png");
        hvBienes.setImages("/IMAGES/LABELS/bienesAct.png", "/IMAGES/LABELS/bienesAct.png", "/IMAGES/LABELS/bienesDes.png");
        hvCodeudores.setImages("/IMAGES/LABELS/codeudoresAct.png", "/IMAGES/LABELS/codeudoresAct.png", "/IMAGES/LABELS/codeudoresDes.png");
        hvDatosPerson.setImagesDefault("/IMAGES/LABELS/datosPersonalesAct.png", "/IMAGES/LABELS/datosPersonalesAct.png", "/IMAGES/LABELS/datosPersonalesDes.png");
        hvNuevoCliente.setImages("/IMAGES/LABELS/nuevoClienteDes.png","/IMAGES/LABELS/nuevoClienteAct.png");
        hvReferencias.setImages("/IMAGES/LABELS/referenciasAct.png", "/IMAGES/LABELS/referenciasAct.png", "/IMAGES/LABELS/referenciasDes.png");

        contenidoCliente.setBackground(new java.awt.Color(240, 236, 236));
        contenidoCliente.setLayout(new javax.swing.BoxLayout(contenidoCliente, javax.swing.BoxLayout.LINE_AXIS));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 934, Short.MAX_VALUE)
            .addComponent(contenidoCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(menuCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(contenidoCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void hvNegocioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hvNegocioMouseClicked
       inp.telpersonal=dpp.txttelpers.getText();
       inp.direccionpersonal=dpp.txtdireccion.getText();
       inp.puntorefpersonal=dpp.txtreferencia.getText();
       cargarPanel(inp);
       hvNegocio.setSeleccionado( hvDatosPerson,hvConyuge,hvBienes,hvCodeudores,hvReferencias);
        
    }//GEN-LAST:event_hvNegocioMouseClicked

    private void hvDatosPersonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hvDatosPersonMouseClicked
       
        cargarPanel(dpp);
        hvDatosPerson.setSeleccionado( hvNegocio,hvConyuge,hvBienes,hvCodeudores,hvReferencias);
        
    }//GEN-LAST:event_hvDatosPersonMouseClicked

    private void hvConyugeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hvConyugeMouseClicked
        icp.direccionpersonal=dpp.txtdireccion.getText();
        cargarPanel(icp);
        hvConyuge.setSeleccionado( hvNegocio,hvDatosPerson,hvBienes,hvCodeudores,hvReferencias);
        
    }//GEN-LAST:event_hvConyugeMouseClicked

    private void hvCodeudoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hvCodeudoresMouseClicked
      
        cargarPanel(cop);
        hvCodeudores.setSeleccionado( hvNegocio,hvDatosPerson,hvBienes,hvConyuge,hvReferencias);
        
    }//GEN-LAST:event_hvCodeudoresMouseClicked

    private void hvReferenciasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hvReferenciasMouseClicked
        
        cargarPanel(rfp);
        hvReferencias.setSeleccionado( hvNegocio,hvDatosPerson,hvBienes,hvConyuge,hvCodeudores);
        
    }//GEN-LAST:event_hvReferenciasMouseClicked

    private void hvBienesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hvBienesMouseClicked
        
        cargarPanel(dbp);
        hvBienes.setSeleccionado( hvNegocio,hvDatosPerson,hvCodeudores,hvConyuge,hvReferencias);
        
    }//GEN-LAST:event_hvBienesMouseClicked

    private void txtBusquedaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaKeyTyped
        
        Character c = evt.getKeyChar();
        if(Character.isLetter(c)) {
            evt.setKeyChar(Character.toUpperCase(c));
        }
        
    }//GEN-LAST:event_txtBusquedaKeyTyped

    private void txtBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaKeyReleased
        
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!txtBusqueda.getText().isEmpty() && (rbnnombre.isSelected() != false || rbndui.isSelected() != false)) {
                cargarPanel(dpp);
                hvDatosPerson.setSeleccionado( hvNegocio,hvConyuge,hvBienes,hvCodeudores,hvReferencias);
                limpiar();
                if (rbndui.isSelected() == true) {
                    dtjc = new DatosPersonalesJpaController();
                    try{
                        if (dtjc.findDatosPersonales(txtBusqueda.getText()) != null) {
                            datospersonalesdb = dtjc.findDatosPersonales(txtBusqueda.getText());
                            cargarDatos(); activarBtnGuardar();
                        } else {
                            JOptionPane.showMessageDialog(this, "el cliente con el dui: " + txtBusqueda.getText() + "\nNo existe en la base de datos");
                        }
                    }catch(Exception ex){JOptionPane.showMessageDialog(this, "Error al conectarse con la base de datos.");}
                    
                } else if (rbnnombre.isSelected() == true) {
                    dtjc = new DatosPersonalesJpaController();
                    try{
                        if (dtjc.findByNombre(txtBusqueda.getText()) != null) {
                            datospersonalesdb = dtjc.findByNombre(txtBusqueda.getText());
                            cargarDatos(); activarBtnGuardar();
                        } else { 
                            JOptionPane.showMessageDialog(this, "el cliente con el nombre: " + txtBusqueda.getText() + "\nNo existe en la base de datos");
                        }
                    }catch(Exception ex){JOptionPane.showMessageDialog(this, "Error al conectarse con la base de datos.");}
                    
                }
            } else {
                limpiar();
                JOptionPane.showMessageDialog(null, "ingrese el nombre o dui del cliente");
            }
        } 
        
    }//GEN-LAST:event_txtBusquedaKeyReleased

    private void hvNuevoClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hvNuevoClienteMouseClicked
        limpiar();
        txtBusqueda.setText("");
        cargarPanel(dpp);
        dpp.txtnombre.requestFocus();
        hvDatosPerson.setSeleccionado( hvNegocio,hvConyuge,hvBienes,hvCodeudores,hvReferencias);
    }//GEN-LAST:event_hvNuevoClienteMouseClicked

    public void limpiar(){
        
        datospersonalesdb = null; datospersonalesdb = new DatosPersonales();
        dpp.limpiarcampos();
        inp.limpiarcampos();
        icp.limpiarcampos();
        rfp.limpiarcampos();
        cop.limpiarcampos();
        dbp.limpiarcampos();
    }
    
    public void cargarDatos(){
    
        dpp.recibirDatos(datospersonalesdb);
        inp.recibirDatos(datospersonalesdb);
        icp.recibirDatos(datospersonalesdb);
        rfp.recibirDatos(datospersonalesdb);
        cop.recibirDatos(datospersonalesdb);
        dbp.recibirDatos(datospersonalesdb);
    }
    
    public void actualizarPanelesCliente(){
        
        inp.cargarCliente(dpp.datospersonales);
        icp.cargarCliente(dpp.datospersonales);
        rfp.cargarCliente(dpp.datospersonales);
        cop.cargarCliente(dpp.datospersonales);
        dbp.cargarCliente(dpp.datospersonales);
        
        activarBtnGuardar();
        
    }
    
    public void activarBtnGuardar(){
        icp.btnGuardar.setEnabled(true);
        inp.btnGuardar.setEnabled(true);
        rfp.btnGuardar.setEnabled(true);
        cop.btnGuardar.setEnabled(true);
        dbp.btnGuardar.setEnabled(true);
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgroup;
    private javax.swing.JPanel contenidoCliente;
    private Label.HvLabel hvBienes;
    private Label.HvLabel hvCodeudores;
    private Label.HvLabel hvConyuge;
    private Label.HvLabel hvDatosPerson;
    private Label.HvLabel hvNegocio;
    private Label.HoverIcon hvNuevoCliente;
    private Label.HvLabel hvReferencias;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel menuCliente;
    private javax.swing.JRadioButton rbndui;
    private javax.swing.JRadioButton rbnnombre;
    private javax.swing.JTextField txtBusqueda;
    // End of variables declaration//GEN-END:variables
}
