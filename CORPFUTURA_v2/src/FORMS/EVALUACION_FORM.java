
package FORMS;


import Entidades.SolicitudCredito;
import UTILIDADES.monto;
import CONTROLADORES.EvaluacionCreditoJpaController;
import CONTROLADORES.SolicitudCreditoJpaController;
import Entidades.EvaluacionCredito;
import Entidades.EvaluacionCreditoPK;
import FORMS.PANELS.LISTA_SOLICITUDES_PNL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author DFUENTES
 */
public class EVALUACION_FORM extends javax.swing.JFrame {

    public LISTA_SOLICITUDES_PNL listasolicitud;

    
    private EvaluacionCredito evaluacion;
    private SolicitudCredito solicitud;
    private monto mont = new monto();
    private int indice;
    
    private EvaluacionCreditoJpaController ecjc = new EvaluacionCreditoJpaController();
    private SolicitudCreditoJpaController scjc = new SolicitudCreditoJpaController();

    public EVALUACION_FORM(SolicitudCredito solicitud,LISTA_SOLICITUDES_PNL listap) {
        
        initComponents();
        this.setLocationRelativeTo(null);
        this.solicitud = solicitud;
        this.listasolicitud=listap;
        this.indice = listap.tblSolicitudes.getSelectedRow();
        cargarSolicitud(this.solicitud);
        cargarEvaluacion(this.solicitud);
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
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtmonto = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cmbplazos = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        cmbformapagos = new javax.swing.JComboBox<>();
        btnCalcular = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        chkAsesoria = new javax.swing.JCheckBox();
        chkcuotafinal = new javax.swing.JCheckBox();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtmorad = new javax.swing.JTextField();
        txtinteresesd = new javax.swing.JTextField();
        txtcapitald = new javax.swing.JTextField();
        txtcuotafinal = new javax.swing.JTextField();
        txtAsesoria = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtcuota = new javax.swing.JTextField();
        txtInteresCuota = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtIvaCuota = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        txtTotalPago = new javax.swing.JTextField();
        txtTotalIva = new javax.swing.JTextField();
        txtTotalIntereses = new javax.swing.JTextField();
        txtmontorecibir = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel27 = new javax.swing.JLabel();
        fechsolicitud = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        cmbtipocredito = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtmontosol = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        cmbplazossol = new javax.swing.JComboBox<>();
        jLabel28 = new javax.swing.JLabel();
        cmbformapagossol = new javax.swing.JComboBox<>();
        jLabel29 = new javax.swing.JLabel();
        cmbfondos = new javax.swing.JComboBox<>();
        jLabel30 = new javax.swing.JLabel();
        cmbtipogarantia = new javax.swing.JComboBox<>();
        jLabel31 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtjustificacion = new javax.swing.JTextArea();
        jLabel32 = new javax.swing.JLabel();
        cmbEstadocredito = new javax.swing.JComboBox<>();
        btnGuardar = new javax.swing.JButton();
        jLabel33 = new javax.swing.JLabel();
        fechevaluacion = new com.toedter.calendar.JDateChooser();
        txtCapitalCuota = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        txttasa = new javax.swing.JTextField();

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
        jLabel1.setText("EVALUACION DE  SOLICITUD");

        javax.swing.GroupLayout encabezadoLayout = new javax.swing.GroupLayout(encabezado);
        encabezado.setLayout(encabezadoLayout);
        encabezadoLayout.setHorizontalGroup(
            encabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, encabezadoLayout.createSequentialGroup()
                .addGap(387, 387, 387)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        jLabel3.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("SOLICITUD DE CREDITO");

        jLabel7.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Tipo de Crédito:");

        jLabel8.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Monto:");

        jLabel13.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 51, 51));
        jLabel13.setText("$");

        txtmonto.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        txtmonto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtmontoKeyTyped(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Plazo:");

        cmbplazos.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        cmbplazos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<SELECCIONAR>", "1 mes / 4 semanas", "2 meses / 8 semanas", "3 meses / 12 semanas", "4 meses / 16 semanas", "5 meses / 20 semanas", "6 meses / 24 semanas", "7 meses / 28 semanas", "8 meses / 32 semanas", "9 meses / 36 semanas", "10 meses / 40 semanas", "11 meses / 44 semanas", "12 meses / 48 semanas" }));

        jLabel11.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("Forma de Pago:");

        cmbformapagos.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        cmbformapagos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<SELECCIONAR>", "SEMANAL", "CATORCENAL", "MENSUAL" }));

        btnCalcular.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        btnCalcular.setText("CALCULAR");
        btnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("DETALLE DE DEDUCCIONES");

        chkAsesoria.setBackground(new java.awt.Color(240, 236, 236));
        chkAsesoria.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        chkAsesoria.setForeground(new java.awt.Color(51, 51, 51));
        chkAsesoria.setText("Asesoría:");

        chkcuotafinal.setBackground(new java.awt.Color(240, 236, 236));
        chkcuotafinal.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        chkcuotafinal.setForeground(new java.awt.Color(51, 51, 51));
        chkcuotafinal.setText("Cuota Final:");

        jLabel18.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(51, 51, 51));
        jLabel18.setText("Capital:");

        jLabel20.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(51, 51, 51));
        jLabel20.setText("Intereses:");

        jLabel21.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(51, 51, 51));
        jLabel21.setText("Mora:");

        txtmorad.setEditable(false);
        txtmorad.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N

        txtinteresesd.setEditable(false);
        txtinteresesd.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N

        txtcapitald.setEditable(false);
        txtcapitald.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N

        txtcuotafinal.setEditable(false);
        txtcuotafinal.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N

        txtAsesoria.setEditable(false);
        txtAsesoria.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("DETALLE DE CUOTAS");

        jLabel14.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 51, 51));
        jLabel14.setText("Cuota:");

        txtcuota.setEditable(false);
        txtcuota.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N

        txtInteresCuota.setEditable(false);
        txtInteresCuota.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N

        jLabel17.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(51, 51, 51));
        jLabel17.setText("Interes:");

        jLabel19.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(51, 51, 51));
        jLabel19.setText("IVA:");

        txtIvaCuota.setEditable(false);
        txtIvaCuota.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setText("DETALLE DE MONTOS");

        jLabel22.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(51, 51, 51));
        jLabel22.setText("Monto a recibir:");

        jLabel23.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(51, 51, 51));
        jLabel23.setText("Total Intereses:");

        jLabel24.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(51, 51, 51));
        jLabel24.setText("Total IVA:");

        jLabel25.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(51, 51, 51));
        jLabel25.setText("Total a pagar:");

        txtTotalPago.setEditable(false);
        txtTotalPago.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N

        txtTotalIva.setEditable(false);
        txtTotalIva.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N

        txtTotalIntereses.setEditable(false);
        txtTotalIntereses.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N

        txtmontorecibir.setEditable(false);
        txtmontorecibir.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N

        jLabel27.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(51, 51, 51));
        jLabel27.setText("Fecha de Solicitud:");

        fechsolicitud.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("EVALUACION  DE CREDITO");

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        cmbtipocredito.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        cmbtipocredito.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<SELECCIONAR>", "CLIENTE NUEVO", "RECURRENTE", "GESTION DE ARREGLO", "REFINANCIAMIENTO", "EXPRESS" }));
        cmbtipocredito.setEnabled(false);

        jLabel15.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(51, 51, 51));
        jLabel15.setText("Monto:");

        jLabel16.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(51, 51, 51));
        jLabel16.setText("$");

        txtmontosol.setEditable(false);
        txtmontosol.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N

        jLabel26.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(51, 51, 51));
        jLabel26.setText("Plazo:");

        cmbplazossol.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        cmbplazossol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<SELECCIONAR>", "1 mes / 4 semanas", "2 meses / 8 semanas", "3 meses / 12 semanas", "4 meses / 16 semanas", "5 meses / 20 semanas", "6 meses / 24 semanas", "7 meses / 28 semanas", "8 meses / 32 semanas", "9 meses / 36 semanas", "10 meses / 40 semanas", "11 meses / 44 semanas", "12 meses / 48 semanas" }));
        cmbplazossol.setEnabled(false);

        jLabel28.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(51, 51, 51));
        jLabel28.setText("Forma de Pago:");

        cmbformapagossol.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        cmbformapagossol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<SELECCIONAR>", "SEMANAL", "CATORCENAL", "MENSUAL" }));
        cmbformapagossol.setEnabled(false);

        jLabel29.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(51, 51, 51));
        jLabel29.setText("Fuente de los Fondos:");

        cmbfondos.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        cmbfondos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<SELECCIONAR>", "PROPIOS", "SALARIO" }));

        jLabel30.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(51, 51, 51));
        jLabel30.setText("Tipo de Garantía:");

        cmbtipogarantia.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        cmbtipogarantia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<SELECCIONAR>", "Codeduores Solidarios y Garantía Prendaria", "Codeudores Solidarios", "Garantía Prendaria" }));

        jLabel31.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(51, 51, 51));
        jLabel31.setText("Justificación:");

        txtjustificacion.setColumns(20);
        txtjustificacion.setLineWrap(true);
        txtjustificacion.setRows(5);
        txtjustificacion.setAutoscrolls(false);
        jScrollPane1.setViewportView(txtjustificacion);

        jLabel32.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(51, 51, 51));
        jLabel32.setText("Estado:");

        cmbEstadocredito.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        cmbEstadocredito.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<SELECCIONAR>", "VISITA PENDIENTE", "EN PROCESO", "RESOLUCION  PENDIENTE" }));

        btnGuardar.setText("GUARDAR EVALUACION");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jLabel33.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(51, 51, 51));
        jLabel33.setText("Fecha de Evaluación:");

        txtCapitalCuota.setEditable(false);
        txtCapitalCuota.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N

        jLabel34.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(51, 51, 51));
        jLabel34.setText("Capital:");

        jLabel35.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(51, 51, 51));
        jLabel35.setText("Tasa:");

        jLabel36.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(51, 51, 51));
        jLabel36.setText("%");

        txttasa.setEditable(false);
        txttasa.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        txttasa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txttasaKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout contenidoLayout = new javax.swing.GroupLayout(contenido);
        contenido.setLayout(contenidoLayout);
        contenidoLayout.setHorizontalGroup(
            contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenidoLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contenidoLayout.createSequentialGroup()
                        .addComponent(jLabel35)
                        .addGap(1, 1, 1)
                        .addComponent(jLabel36)
                        .addGap(46, 46, 46)
                        .addComponent(txttasa, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3)
                    .addGroup(contenidoLayout.createSequentialGroup()
                        .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(contenidoLayout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(1, 1, 1)
                                .addComponent(jLabel16)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbtipocredito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtmontosol, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(contenidoLayout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addGap(55, 55, 55)
                        .addComponent(cmbplazossol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(contenidoLayout.createSequentialGroup()
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbformapagossol, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contenidoLayout.createSequentialGroup()
                        .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(btnCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(contenidoLayout.createSequentialGroup()
                                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(contenidoLayout.createSequentialGroup()
                                            .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(contenidoLayout.createSequentialGroup()
                                                    .addGap(21, 21, 21)
                                                    .addComponent(jLabel18))
                                                .addComponent(chkAsesoria))
                                            .addGap(22, 22, 22))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contenidoLayout.createSequentialGroup()
                                            .addComponent(chkcuotafinal)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                    .addGroup(contenidoLayout.createSequentialGroup()
                                        .addGap(22, 22, 22)
                                        .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel20)
                                            .addComponent(jLabel21))
                                        .addGap(22, 22, 22)))
                                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtmorad, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtAsesoria)
                                        .addComponent(txtcapitald)
                                        .addComponent(txtcuotafinal, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtinteresesd, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(18, 18, 18)
                        .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(contenidoLayout.createSequentialGroup()
                                .addComponent(jLabel34)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCapitalCuota))
                            .addComponent(jLabel10)
                            .addGroup(contenidoLayout.createSequentialGroup()
                                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel19))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtIvaCuota)
                                    .addComponent(txtInteresCuota)
                                    .addComponent(txtcuota, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(contenidoLayout.createSequentialGroup()
                                    .addComponent(jLabel22)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtmontorecibir))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, contenidoLayout.createSequentialGroup()
                                    .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel23)
                                        .addComponent(jLabel24)
                                        .addComponent(jLabel25))
                                    .addGap(5, 5, 5)
                                    .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtTotalPago, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtTotalIva)
                                            .addComponent(txtTotalIntereses, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                    .addGroup(contenidoLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(1, 1, 1)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtmonto, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9)
                        .addGap(4, 4, 4)
                        .addComponent(cmbplazos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbformapagos, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6))
                .addGap(57, 57, 57))
            .addGroup(contenidoLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contenidoLayout.createSequentialGroup()
                        .addComponent(jSeparator1)
                        .addContainerGap())
                    .addGroup(contenidoLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fechsolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(contenidoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contenidoLayout.createSequentialGroup()
                        .addComponent(jSeparator2)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contenidoLayout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(jScrollPane1)
                        .addGap(27, 27, 27)
                        .addComponent(btnGuardar)
                        .addGap(70, 70, 70))
                    .addGroup(contenidoLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbtipogarantia, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbfondos, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(contenidoLayout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(jLabel33))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contenidoLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel32)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fechevaluacion, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbEstadocredito, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(contenidoLayout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDui, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        contenidoLayout.setVerticalGroup(
            contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenidoLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel5)
                    .addComponent(txtDui, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contenidoLayout.createSequentialGroup()
                        .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel27)
                            .addComponent(fechsolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(contenidoLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(25, 25, 25)
                                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(cmbformapagos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11)
                                    .addComponent(cmbplazos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9)
                                    .addComponent(txtmonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel8))
                                .addGap(18, 18, 18)
                                .addComponent(btnCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19)
                                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel12))
                                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(contenidoLayout.createSequentialGroup()
                                        .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                            .addComponent(chkAsesoria, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtAsesoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel14)
                                            .addComponent(txtcuota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtTotalPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel25))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                            .addComponent(chkcuotafinal, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtcuotafinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel17)
                                            .addComponent(txtInteresCuota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel23)
                                            .addComponent(txtTotalIntereses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(txtTotalIva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel24))
                                            .addComponent(jLabel19)
                                            .addComponent(txtIvaCuota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                                .addComponent(jLabel18)
                                                .addComponent(txtcapitald, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                                        .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                            .addComponent(jLabel20)
                                            .addComponent(txtinteresesd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel34)
                                            .addComponent(txtCapitalCuota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtmorad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel21)))
                                    .addGroup(contenidoLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                            .addComponent(jLabel22)
                                            .addComponent(txtmontorecibir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(contenidoLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(23, 23, 23)
                                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(jLabel7)
                                    .addComponent(cmbtipocredito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel16)
                                    .addComponent(txtmontosol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(jLabel26)
                                    .addComponent(cmbplazossol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(cmbformapagossol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel28))
                                .addGap(8, 8, 8)
                                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(jLabel35)
                                    .addComponent(jLabel36)
                                    .addComponent(txttasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(contenidoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contenidoLayout.createSequentialGroup()
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel29)
                            .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel32)
                                .addComponent(cmbEstadocredito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cmbfondos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel30)
                            .addComponent(cmbtipogarantia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel33)
                            .addComponent(fechevaluacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel31)))
                    .addComponent(btnGuardar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
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
                .addGap(0, 0, 0)
                .addComponent(contenido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void hvCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hvCerrarMouseClicked
        this.dispose();
    }//GEN-LAST:event_hvCerrarMouseClicked

    private void txtmontoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtmontoKeyTyped

        char caracter= evt.getKeyChar();
        char punto = '.';
        if((!Character.isDigit(caracter)) && (caracter!=punto)) evt.consume();

    }//GEN-LAST:event_txtmontoKeyTyped

    private void btnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularActionPerformed
        
        txtAsesoria.setText("");
        txtcuotafinal.setText("");
        if(!txtmonto.getText().isEmpty() && cmbplazos.getSelectedIndex()!=0 && cmbformapagos.getSelectedIndex()!=0){
           if(solicitud.getTipoCredito()!=3){
                mont = new monto(txtmonto.getText(),cmbplazos.getSelectedIndex(),cmbformapagos.getSelectedIndex(),solicitud.getTasaInteres()); 
                mont.settotalDeducciones(chkAsesoria.isSelected(),chkcuotafinal.isSelected(),txtinteresesd.getText(),txtcapitald.getText(),txtmorad.getText());
                txtTotalIntereses.setText(mont.getTotalIntereses());
                txtTotalIva.setText(mont.getTotalIva());
            }else{
                mont = new monto(txtmonto.getText(),cmbplazos.getSelectedIndex(),cmbformapagos.getSelectedIndex(), txtTotalIva.getText(), txtTotalIntereses.getText());
                mont.settotalDeducciones(chkAsesoria.isSelected(),chkcuotafinal.isSelected());
            }
            obtenerdetallemonto(mont);     
        }
    }//GEN-LAST:event_btnCalcularActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        boolean valido = true;
        
        if(validarcampos()){
            llenarevaluacion();
            if(solicitud.getEvaluacionCredito()==null){
                try {
                    ecjc.create(evaluacion);
                } catch (Exception ex) {
                    valido = false;
                    Logger.getLogger(EVALUACION_FORM.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                try {
                    ecjc.edit(evaluacion);
                } catch (Exception ex) {
                    valido = false;
                    Logger.getLogger(EVALUACION_FORM.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if(solicitud.getEstado()!=cmbEstadocredito.getSelectedIndex()){
                solicitud.setEstado((short)cmbEstadocredito.getSelectedIndex());
                solicitud.setEvaluacionCredito(evaluacion);
                try {
                    scjc.edit(solicitud);
                } catch (Exception ex) {
                    valido = false;
                    Logger.getLogger(EVALUACION_FORM.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if(valido){
                listasolicitud.cargarModelo();
                listasolicitud.tblSolicitudes.clearSelection();
                listasolicitud.tblSolicitudes.setRowSelectionInterval(indice, indice);
                listasolicitud.cargarsolicitud(indice);
                this.dispose();
            }else{
                JOptionPane.showMessageDialog(null,"Error al registrar la evaluacion en la base de datos");
            }

        }else{JOptionPane.showMessageDialog(null,"Hace falta llenar campos obligatorios");}

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txttasaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttasaKeyTyped
        char caracter= evt.getKeyChar();
        if(!Character.isDigit(caracter)) evt.consume();
    }//GEN-LAST:event_txttasaKeyTyped

    public void llenarevaluacion(){
    
        evaluacion = new EvaluacionCredito();
        
        EvaluacionCreditoPK pk = new EvaluacionCreditoPK();
        pk.setDui(solicitud.getSolicitudCreditoPK().getDui());
        pk.setIdSolicitudCredito(solicitud.getSolicitudCreditoPK().getIdSolicitudCredito());
        evaluacion.setEvaluacionCreditoPK(pk);
        evaluacion.setSolicitudCredito(solicitud);
        
        evaluacion.setMonto(Double.valueOf(txtmonto.getText()));
        evaluacion.setPlazo((short)cmbplazos.getSelectedIndex());
        evaluacion.setFormaPago((short)cmbformapagos.getSelectedIndex());
        evaluacion.setFechaEvaluacion(fechevaluacion.getDate());
        evaluacion.setFuentesFondos((short)cmbfondos.getSelectedIndex());
        evaluacion.setTipoGarantia((short)cmbtipogarantia.getSelectedIndex());
        evaluacion.setJustificacion(txtjustificacion.getText());
        
        
        monto monto = new monto(txtmonto.getText(),cmbplazos.getSelectedIndex(),cmbformapagos.getSelectedIndex(),solicitud.getTasaInteres());
        evaluacion.setCuota(Double.valueOf(monto.getCuota()));
        
        evaluacion.setDescuentoAsesoria(chkAsesoria.isSelected());
        evaluacion.setDescuentoCf(chkcuotafinal.isSelected());
        
    }
    
    public void cargarSolicitud(SolicitudCredito solicitud){
         
        txtNombre.setText(solicitud.getDatosPersonales().getNombre());
        txtDui.setText(solicitud.getDatosPersonales().getDui());
        fechsolicitud.setDate(solicitud.getFechaSolicitud());
        cmbtipocredito.setSelectedIndex(solicitud.getTipoCredito());
        txtmontosol.setText(String.valueOf(solicitud.getMontoRequerido())); 
        cmbplazossol.setSelectedIndex(solicitud.getPlazo());
        cmbformapagossol.setSelectedIndex(solicitud.getFormaPago());
        cargarEstadoSolicitud(solicitud.getEstado());
        txttasa.setText(solicitud.getTasaInteres());
        chkcuotafinal.setSelected(solicitud.getDescuentoCf());
        chkAsesoria.setSelected(solicitud.getDescuentoAsesoria());
        
        
        
           
    }
    
    public void cargarEvaluacion(SolicitudCredito solicitud){
        
        
        txtcapitald.setText(solicitud.getCapitalDes().toString());
        txtinteresesd.setText(solicitud.getInteresesDes().toString());
        txtmorad.setText(solicitud.getMoraDes().toString());
        if(cmbtipocredito.getSelectedIndex()==3){ 
               txtTotalIntereses.setText(solicitud.getInteresesGa().toString());
               txtTotalIva.setText(solicitud.getIvaGa().toString());
        }
        
        if(solicitud.getEvaluacionCredito()==null){
             txtmonto.setText(String.valueOf(solicitud.getMontoRequerido()));
             cmbplazos.setSelectedIndex(solicitud.getPlazo());
             cmbformapagos.setSelectedIndex(solicitud.getFormaPago()); 
        }else{
            //btnGuardar.setEnabled(false);
            evaluacion = solicitud.getEvaluacionCredito();
            txtmonto.setText(String.valueOf(evaluacion.getMonto())); 
            cmbplazos.setSelectedIndex(evaluacion.getPlazo());
            cmbformapagos.setSelectedIndex(evaluacion.getFormaPago()); 
            cmbfondos.setSelectedIndex(evaluacion.getFuentesFondos());
            cmbtipogarantia.setSelectedIndex(evaluacion.getTipoGarantia());
            fechevaluacion.setDate(evaluacion.getFechaEvaluacion());
            txtjustificacion.setText(evaluacion.getJustificacion());
            chkcuotafinal.setSelected(evaluacion.getDescuentoCf());
            chkAsesoria.setSelected(evaluacion.getDescuentoAsesoria());
        }
        
        cargarEstadoSolicitud(solicitud.getEstado());
        
        
        if(solicitud.getTipoCredito()!=3){
            mont = new monto(txtmonto.getText(),cmbplazos.getSelectedIndex(),cmbformapagos.getSelectedIndex(),solicitud.getTasaInteres()); 
            mont.settotalDeducciones(chkAsesoria.isSelected(),chkcuotafinal.isSelected(),txtinteresesd.getText(),txtcapitald.getText(),txtmorad.getText());
            txtTotalIntereses.setText(mont.getTotalIntereses());
            txtTotalIva.setText(mont.getTotalIva());
        }else{
            mont = new monto(txtmonto.getText(),cmbplazos.getSelectedIndex(),cmbformapagos.getSelectedIndex(), txtTotalIva.getText(), txtTotalIntereses.getText());
            mont.settotalDeducciones(chkAsesoria.isSelected(),chkcuotafinal.isSelected());
        }
        obtenerdetallemonto(mont);
    }
    
    public void obtenerdetallemonto(monto monto){
        
        txtcuota.setText(monto.getCuota());
        txtInteresCuota.setText(monto.valorXCuota(monto.getTotalIntereses()));
        txtIvaCuota.setText(monto.valorXCuota(monto.getTotalIva()));
        txtCapitalCuota.setText(monto.valorXCuota(String.valueOf(mont.getMonto())));
        
        if(chkAsesoria.isSelected()){txtAsesoria.setText(monto.getAsesoria());}
        if(chkcuotafinal.isSelected()){txtcuotafinal.setText(monto.getCuota());}
        
        txtmontorecibir.setText(monto.getMontoRecibir());
        txtTotalPago.setText(monto.getTotalPago());      
      
    }
    
    public boolean validarcampos(){
        boolean validacion = true;
         if(txtmonto.getText().trim().isEmpty() || cmbplazos.getSelectedIndex()==0 || cmbformapagos.getSelectedIndex()==0 
            || cmbEstadocredito.getSelectedIndex()==0 || fechevaluacion.getDate()==null || cmbfondos.getSelectedIndex()==0
            || cmbtipogarantia.getSelectedIndex()==0 || txtjustificacion.getText().trim().isEmpty())
         {validacion = false;}         
        return validacion;
    }
    
    public void cargarEstadoSolicitud(int estado){
    
        if(estado<=2){cmbEstadocredito.setSelectedIndex(solicitud.getEstado());}
        else{
            cmbEstadocredito.setEnabled(false);
            cmbEstadocredito.addItem("Aprobado");
            cmbEstadocredito.setSelectedIndex(solicitud.getEstado());
        }  
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgroup;
    private javax.swing.JButton btnCalcular;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JCheckBox chkAsesoria;
    private javax.swing.JCheckBox chkcuotafinal;
    private javax.swing.JComboBox<String> cmbEstadocredito;
    public javax.swing.JComboBox<String> cmbfondos;
    private javax.swing.JComboBox<String> cmbformapagos;
    private javax.swing.JComboBox<String> cmbformapagossol;
    private javax.swing.JComboBox<String> cmbplazos;
    private javax.swing.JComboBox<String> cmbplazossol;
    private javax.swing.JComboBox<String> cmbtipocredito;
    public javax.swing.JComboBox<String> cmbtipogarantia;
    private javax.swing.JPanel contenido;
    private javax.swing.JPanel encabezado;
    private com.toedter.calendar.JDateChooser fechevaluacion;
    private com.toedter.calendar.JDateChooser fechsolicitud;
    private Label.HoverIcon hvCerrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField txtAsesoria;
    private javax.swing.JTextField txtCapitalCuota;
    private javax.swing.JTextField txtDui;
    private javax.swing.JTextField txtInteresCuota;
    private javax.swing.JTextField txtIvaCuota;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTotalIntereses;
    private javax.swing.JTextField txtTotalIva;
    private javax.swing.JTextField txtTotalPago;
    private javax.swing.JTextField txtcapitald;
    private javax.swing.JTextField txtcuota;
    private javax.swing.JTextField txtcuotafinal;
    private javax.swing.JTextField txtinteresesd;
    public javax.swing.JTextArea txtjustificacion;
    private javax.swing.JTextField txtmonto;
    private javax.swing.JTextField txtmontorecibir;
    private javax.swing.JTextField txtmontosol;
    private javax.swing.JTextField txtmorad;
    private javax.swing.JTextField txttasa;
    // End of variables declaration//GEN-END:variables
}
