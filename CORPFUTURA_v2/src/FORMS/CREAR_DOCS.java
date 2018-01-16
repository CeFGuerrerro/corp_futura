package FORMS;

import CONTROLADORES.DatosPersonalesJpaController;
import DOCS_DATASOURCES.DS_Autorizacion;
import DOCS_DATASOURCES.DS_DeclaracionBienes;
import DOCS_DATASOURCES.DS_HojaDesembolso;
import DOCS_DATASOURCES.DS_PerfilCliente;
import DOCS_DATASOURCES.DS_ResolucionComite;
import DOCS_DATASOURCES.DS_Solicitud1;
import DOCS_DATASOURCES.DS_Solicitud2;
import DOCS_DATASOURCES.JasperGenerator;
import Entidades.Codeudores;
import Entidades.DatosPersonales;
import Entidades.DeclaracionBienes;
import Entidades.Referencias;
import Entidades.SolicitudCredito;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author DFUENTES
 */
public class CREAR_DOCS extends javax.swing.JFrame {

    private SolicitudCredito solicitud;
    private String total = null;
    private List<Referencias> listaRefFam = new ArrayList<Referencias>();
    private List<Referencias> listaRefPer = new ArrayList<Referencias>();
    private List<DatosPersonales> listaCod = new ArrayList<DatosPersonales>();
    private List<DeclaracionBienes> listaBienes = new ArrayList<DeclaracionBienes>();
    private Map parametros = new HashMap();
    private JasperGenerator jasper = new JasperGenerator();
    private DS_Autorizacion aut = new DS_Autorizacion();
    private DS_Solicitud1 sol1 = new DS_Solicitud1();
    private DS_Solicitud2 sol2 = new DS_Solicitud2();
    private DS_PerfilCliente perf = new DS_PerfilCliente();
    private DS_ResolucionComite resc = new DS_ResolucionComite();
    private DS_DeclaracionBienes decl = new DS_DeclaracionBienes();
    private DS_HojaDesembolso hoja = new DS_HojaDesembolso();

    public CREAR_DOCS(SolicitudCredito sol) {

        initComponents();
        this.setLocationRelativeTo(null);
        solicitud = sol;
        cargarSolicitud();
        getTotalBienes();
        getCodeudores();
        validarDocumentos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgroup = new javax.swing.ButtonGroup();
        encabezado = new javax.swing.JPanel();
        hvCerrar = new Label.HoverIcon();
        jLabel1 = new javax.swing.JLabel();
        contenido = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtDui = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtIdsolicitud = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        fechsolicitud = new com.toedter.calendar.JDateChooser();
        jLabel16 = new javax.swing.JLabel();
        chkformAutorizaciones = new javax.swing.JCheckBox();
        chkdeclaracionbienes = new javax.swing.JCheckBox();
        chksolicitud = new javax.swing.JCheckBox();
        chkresolucion = new javax.swing.JCheckBox();
        chkperfil = new javax.swing.JCheckBox();
        btnGenerar = new javax.swing.JButton();
        chkhojadesembolso = new javax.swing.JCheckBox();

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
        jLabel1.setText("GENERAR DOCUMENTOS DEL PERFIL");

        javax.swing.GroupLayout encabezadoLayout = new javax.swing.GroupLayout(encabezado);
        encabezado.setLayout(encabezadoLayout);
        encabezadoLayout.setHorizontalGroup(
            encabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, encabezadoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(221, 221, 221)
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

        jLabel5.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("DUI:");

        txtDui.setEditable(false);
        txtDui.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Nombre:");

        txtNombre.setEditable(false);
        txtNombre.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("SOLICITUD DE CREDITO");

        jLabel6.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("CLIENTE");

        txtIdsolicitud.setEditable(false);
        txtIdsolicitud.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N

        jLabel15.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(51, 51, 51));
        jLabel15.setText("Solicitud:");

        jLabel28.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(51, 51, 51));
        jLabel28.setText("Fecha de Solicitud:");

        fechsolicitud.setBackground(new java.awt.Color(240, 236, 236));

        jLabel16.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(51, 51, 51));
        jLabel16.setText("DOCUMENTOS DEL PERFIL");

        chkformAutorizaciones.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        chkformAutorizaciones.setText("Formulario de Autorizaciones Varias (F-CREDNPN-02 y 04):");
        chkformAutorizaciones.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        chkdeclaracionbienes.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        chkdeclaracionbienes.setText("Declaración de Bienes Muebles y Fotografías:");
        chkdeclaracionbienes.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        chksolicitud.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        chksolicitud.setText("Solicitud de Crédito:");
        chksolicitud.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        chkresolucion.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        chkresolucion.setText("Resolución del Cómite:");
        chkresolucion.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        chkperfil.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        chkperfil.setText("Perfil del Cliente");
        chkperfil.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        btnGenerar.setText("Generar Documentos");
        btnGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarActionPerformed(evt);
            }
        });

        chkhojadesembolso.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        chkhojadesembolso.setText("Hoja de desembolso:");
        chkhojadesembolso.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout contenidoLayout = new javax.swing.GroupLayout(contenido);
        contenido.setLayout(contenidoLayout);
        contenidoLayout.setHorizontalGroup(
            contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenidoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contenidoLayout.createSequentialGroup()
                        .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(contenidoLayout.createSequentialGroup()
                                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDui, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(33, 33, 33)
                                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIdsolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fechsolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(contenidoLayout.createSequentialGroup()
                        .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 695, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(contenidoLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(chkdeclaracionbienes)
                                    .addComponent(chkperfil)
                                    .addComponent(chkresolucion)
                                    .addComponent(chkformAutorizaciones)
                                    .addComponent(chksolicitud)
                                    .addComponent(jLabel16)
                                    .addComponent(chkhojadesembolso))))
                        .addGap(0, 10, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contenidoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGenerar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        contenidoLayout.setVerticalGroup(
            contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenidoLayout.createSequentialGroup()
                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contenidoLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contenidoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(contenidoLayout.createSequentialGroup()
                        .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel5)
                            .addComponent(txtDui, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addGroup(contenidoLayout.createSequentialGroup()
                        .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel15)
                            .addComponent(txtIdsolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(fechsolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28))))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chkformAutorizaciones)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chksolicitud)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkdeclaracionbienes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkperfil)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkresolucion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkhojadesembolso)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(btnGenerar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(encabezado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(contenido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(encabezado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(contenido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void hvCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hvCerrarMouseClicked
        this.dispose();
    }//GEN-LAST:event_hvCerrarMouseClicked

    private void btnGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarActionPerformed

        if (chkformAutorizaciones.isSelected()) {
            String doc = "Autorizacion";
            try {
                jasper.crearReporte(doc, solicitud.getDatosPersonales().getNombre(), aut);
            } catch (JRException ex) {
                JOptionPane.showMessageDialog(null, "Error al crear el documento: " + ex.getMessage());

            }
        }
        if (chksolicitud.isSelected()) {
            String doc1 = "Solicitud1";
            String doc2 = "Solicitud2";
            parametros.put("Familiares", solicitud.getDatosPersonales().getFamiliaresList());
            try {
                jasper.crearReporteConParam(doc1, solicitud.getDatosPersonales().getNombre(), parametros, sol1);
            } catch (JRException ex) {
                JOptionPane.showMessageDialog(null, "Error al crear el documento: " + ex.getMessage());

            }
            parametros.clear();
            parametros.put("RefFamiliares", listaRefFam);
            parametros.put("RefPersonales", listaRefPer);
            try {
                jasper.crearReporteConParam(doc2, solicitud.getDatosPersonales().getNombre(), parametros, sol2);
            } catch (JRException ex) {
                JOptionPane.showMessageDialog(null, "Error al crear el documento: " + ex.getMessage());

            }
        }
        if (chkperfil.isSelected()) {
            String doc = "PerfilCliente";
            parametros.clear();
            parametros.put("Total", total);
            parametros.put("Codeudores", listaCod);
            try {
                jasper.crearReporteConParam(doc, solicitud.getDatosPersonales().getNombre(), parametros, perf);
            } catch (JRException ex) {
                JOptionPane.showMessageDialog(null, "Error al crear el documento: " + ex.getMessage());;
            }
        }
        if (chkresolucion.isSelected()) {
            String doc = "ResolucionComite";
            try {
                jasper.crearReporteConParam(doc, solicitud.getDatosPersonales().getNombre(), parametros, resc);
            } catch (JRException ex) {
                JOptionPane.showMessageDialog(null, "Error al crear el documento: " + ex.getMessage());;
            }

        }
        if (chkhojadesembolso.isSelected()) {
            String doc = "HojaDesembolso";
            try {
                jasper.crearReporte(doc, solicitud.getDatosPersonales().getNombre(), hoja);
            } catch (JRException ex) {
                JOptionPane.showMessageDialog(null, "Error al crear el documento: " + ex.getMessage());

            }
        }
        if (chkdeclaracionbienes.isSelected()) {
            String doc = "DeclaracionJuradaBienes";

            try {
                parametros.clear();
                parametros.put("Bienes", listaBienes);
                parametros.put("TotalBienes", total);
                jasper.crearReporteConParam(doc, solicitud.getDatosPersonales().getNombre(), parametros, decl);
            } catch (JRException ex) {
                JOptionPane.showMessageDialog(null, "Error al crear el documento: " + ex.getMessage());;
            }
        }

    }//GEN-LAST:event_btnGenerarActionPerformed

    public void cargarSolicitud() {

        txtNombre.setText(solicitud.getDatosPersonales().getNombre());
        txtDui.setText(solicitud.getDatosPersonales().getDui());
        fechsolicitud.setDate(solicitud.getFechaSolicitud());
        txtIdsolicitud.setText(String.valueOf(solicitud.getSolicitudCreditoPK().getIdSolicitudCredito()));

        aut.addDatosPersonales(solicitud.getDatosPersonales());
        sol1.addSolicitud(solicitud);
        sol2.addSolicitud(solicitud);
        perf.addSolicitud(solicitud);
        resc.addResolucion(solicitud);
        decl.addSolicitud(solicitud);
        hoja.addResolucion(solicitud);

        for (Referencias r : solicitud.getDatosPersonales().getReferenciasList()) {
            if (r.getTipoReferencia() == false) {
                listaRefFam.add(r);
            } else {
                listaRefPer.add(r);
            }
        }
        for (DeclaracionBienes b : solicitud.getDatosPersonales().getDeclaracionBienesList()) {
            listaBienes.add(b);
        }
    }

    public String getTotalBienes() {
        double subtotal = 0;
        for (DeclaracionBienes bien : solicitud.getDatosPersonales().getDeclaracionBienesList()) {
            if (bien.getCantidad() != null && bien.getValuo() != null) {
                bien.setTotalGarantia(bien.getValuo() * bien.getCantidad());
                subtotal += bien.getTotalGarantia();
            }
            total = String.valueOf(subtotal);
        }
        return total;

    }

    public List<DatosPersonales> getCodeudores() {
        for (Codeudores c : solicitud.getDatosPersonales().getCodeudoresList1()) {
            listaCod.add(c.getDuiCodeudor());
        }
        return listaCod;
    }
    
    public void validarDocumentos(){
        if(solicitud.getDatosPersonales().getDeclaracionBienesList().isEmpty() == true){
            chkdeclaracionbienes.setEnabled(false);
        }
        if(solicitud.getEvaluacionCredito() == null){
            chkperfil.setEnabled(false);
        }
        if(solicitud.getCreditos() == null){
            chkresolucion.setEnabled(false);
            chkhojadesembolso.setEnabled(false);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgroup;
    private javax.swing.JButton btnGenerar;
    public javax.swing.JCheckBox chkdeclaracionbienes;
    public javax.swing.JCheckBox chkformAutorizaciones;
    public javax.swing.JCheckBox chkhojadesembolso;
    public javax.swing.JCheckBox chkperfil;
    public javax.swing.JCheckBox chkresolucion;
    public javax.swing.JCheckBox chksolicitud;
    private javax.swing.JPanel contenido;
    private javax.swing.JPanel encabezado;
    private com.toedter.calendar.JDateChooser fechsolicitud;
    private Label.HoverIcon hvCerrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField txtDui;
    private javax.swing.JTextField txtIdsolicitud;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
