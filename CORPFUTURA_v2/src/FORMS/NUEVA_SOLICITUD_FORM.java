
package FORMS;


import Entidades.DatosPersonales;
import Entidades.SolicitudCredito;
import Entidades.SolicitudCreditoPK;
import Entidades.Usuarios;
import FORMS.PANELS.LISTA_SOLICITUDES_PNL;
import UTILIDADES.monto;
import CONTROLADORES.DatosPersonalesJpaController;
import CONTROLADORES.SolicitudCreditoJpaController;
import CONTROLADORES.UsuariosJpaController;
import UTILIDADES.archivos;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author DFUENTES
 */
public class NUEVA_SOLICITUD_FORM extends javax.swing.JFrame {

    public DatosPersonales datospersonales;
    public SolicitudCredito solicitud;
    public monto mont;
    public SALDOS_PENDIENTES_FORM saldosform;
    
    public DefaultComboBoxModel modeloCarteras = new DefaultComboBoxModel();
    private ArrayList<Usuarios> usuarios = new ArrayList();
    
    public boolean desCargados=false;
    public boolean sinCreditos=false;
    public int idCreditoACambiar=0;
    public String interesesGC;
    public String ivaGC;
    public String interesRef;
    public String moraRef;
    public String capitalRef;
    public String tasa="";
    

    public LISTA_SOLICITUDES_PNL listasolicitud;
    
    private DatosPersonalesJpaController dtjc = new DatosPersonalesJpaController();
    private SolicitudCreditoJpaController scjc = new SolicitudCreditoJpaController();
    private UsuariosJpaController ujc = new UsuariosJpaController();
    
    
    public NUEVA_SOLICITUD_FORM(LISTA_SOLICITUDES_PNL lista) {
        
        initComponents();
        this.setLocationRelativeTo(null);
        listasolicitud = lista;
        cargarCarteras();
        
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
        jLabel6 = new javax.swing.JLabel();
        txtbusqueda = new javax.swing.JTextField();
        rbnnombre = new javax.swing.JRadioButton();
        rbndui = new javax.swing.JRadioButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cmbtipocredito = new javax.swing.JComboBox<>();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        txtObservaciones = new javax.swing.JTextArea();
        jLabel16 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        cmbEstadocredito = new javax.swing.JComboBox<>();
        jLabel26 = new javax.swing.JLabel();
        txtDestinoCredito = new javax.swing.JTextField();
        btnGenerarsolicitud = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        fechsolicitud = new com.toedter.calendar.JDateChooser();
        jLabel28 = new javax.swing.JLabel();
        txtCapitalCuota = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        txttasa = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        btnDetalle = new javax.swing.JButton();
        jLabel31 = new javax.swing.JLabel();
        cmbtipo = new javax.swing.JComboBox<>();
        hvreload = new Label.HoverIcon();
        jLabel32 = new javax.swing.JLabel();
        cmbCarteras = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
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
        jLabel1.setText("REGISTRO DE NUEVA SOLICITUD");

        javax.swing.GroupLayout encabezadoLayout = new javax.swing.GroupLayout(encabezado);
        encabezado.setLayout(encabezadoLayout);
        encabezadoLayout.setHorizontalGroup(
            encabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, encabezadoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(342, 342, 342)
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

        jLabel6.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Buscar:");

        txtbusqueda.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        txtbusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbusquedaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtbusquedaKeyTyped(evt);
            }
        });

        rbnnombre.setBackground(new java.awt.Color(240, 236, 236));
        bgroup.add(rbnnombre);
        rbnnombre.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        rbnnombre.setForeground(new java.awt.Color(51, 51, 51));
        rbnnombre.setText("NONBRE");

        rbndui.setBackground(new java.awt.Color(240, 236, 236));
        bgroup.add(rbndui);
        rbndui.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        rbndui.setForeground(new java.awt.Color(51, 51, 51));
        rbndui.setText("DUI");

        jLabel3.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("SOLICITUD DE CREDITO");

        jLabel7.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Tipo de Crédito:");

        cmbtipocredito.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        cmbtipocredito.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<SELECCIONAR>", "CLIENTE NUEVO", "RECURRENTE", "GESTION DE ARREGLO", "REFINANCIAMIENTO", "EXPRESS" }));

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
        txtmorad.setInheritsPopupMenu(true);

        txtinteresesd.setEditable(false);
        txtinteresesd.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        txtinteresesd.setInheritsPopupMenu(true);

        txtcapitald.setEditable(false);
        txtcapitald.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        txtcapitald.setInheritsPopupMenu(true);

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

        txtObservaciones.setColumns(20);
        txtObservaciones.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        txtObservaciones.setRows(5);
        jScrollPane1.setViewportView(txtObservaciones);

        jLabel16.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(51, 51, 51));
        jLabel16.setText("Observaciones:");

        jLabel15.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(51, 51, 51));
        jLabel15.setText("Estado:");

        cmbEstadocredito.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        cmbEstadocredito.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<SELECCIONAR>", "VISITA PENDIENTE", "EVALUACION EN PROCESO" }));

        jLabel26.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(51, 51, 51));
        jLabel26.setText("Destino del Crédito:");

        txtDestinoCredito.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N

        btnGenerarsolicitud.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        btnGenerarsolicitud.setText("GUARDAR SOLICITUD");
        btnGenerarsolicitud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarsolicitudActionPerformed(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(51, 51, 51));
        jLabel27.setText("Fecha de Solicitud:");

        jLabel28.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(51, 51, 51));
        jLabel28.setText("Capital:");

        txtCapitalCuota.setEditable(false);
        txtCapitalCuota.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N

        jLabel29.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(51, 51, 51));
        jLabel29.setText("Tasa:");

        txttasa.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        txttasa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txttasaKeyTyped(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(51, 51, 51));
        jLabel30.setText("%");

        btnDetalle.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btnDetalle.setText("SALDOS PENDIENTES");
        btnDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetalleActionPerformed(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(51, 51, 51));
        jLabel31.setText("Crédito:");

        cmbtipo.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        cmbtipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<SELECCIONAR>", "COMERCIAL", "EMPLEADO" }));

        hvreload.setText("hoverIcon1");
        hvreload.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hvreloadMouseClicked(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(51, 51, 51));
        jLabel32.setText("Cartera:");

        cmbCarteras.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        cmbCarteras.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<SELECCIONAR>" }));

        javax.swing.GroupLayout contenidoLayout = new javax.swing.GroupLayout(contenido);
        contenido.setLayout(contenidoLayout);
        contenidoLayout.setHorizontalGroup(
            contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contenidoLayout.createSequentialGroup()
                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, contenidoLayout.createSequentialGroup()
                        .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(contenidoLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel32, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbEstadocredito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(contenidoLayout.createSequentialGroup()
                                        .addComponent(fechsolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel31)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cmbtipo, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtDestinoCredito, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbCarteras, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29)
                                .addComponent(btnGenerarsolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(contenidoLayout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(contenidoLayout.createSequentialGroup()
                                        .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(contenidoLayout.createSequentialGroup()
                                                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(chkAsesoria)
                                                    .addComponent(chkcuotafinal)
                                                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(txtAsesoria, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                                                    .addComponent(txtinteresesd)
                                                    .addComponent(txtmorad)
                                                    .addComponent(txtcuotafinal)
                                                    .addComponent(txtcapitald)))
                                            .addGroup(contenidoLayout.createSequentialGroup()
                                                .addGap(38, 38, 38)
                                                .addComponent(jLabel2))
                                            .addGroup(contenidoLayout.createSequentialGroup()
                                                .addComponent(jLabel7)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(btnDetalle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(cmbtipocredito, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(contenidoLayout.createSequentialGroup()
                                                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addGroup(contenidoLayout.createSequentialGroup()
                                                        .addComponent(jLabel29)
                                                        .addGap(1, 1, 1)
                                                        .addComponent(jLabel30)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(txttasa, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(contenidoLayout.createSequentialGroup()
                                                        .addComponent(jLabel8)
                                                        .addGap(1, 1, 1)
                                                        .addComponent(jLabel13)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(txtmonto, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel11)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(cmbplazos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(cmbformapagos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                            .addGroup(contenidoLayout.createSequentialGroup()
                                                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addGroup(contenidoLayout.createSequentialGroup()
                                                        .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addGroup(contenidoLayout.createSequentialGroup()
                                                                .addGap(17, 17, 17)
                                                                .addComponent(jLabel19))
                                                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                            .addComponent(txtIvaCuota, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                                                            .addComponent(txtcuota)))
                                                    .addGroup(contenidoLayout.createSequentialGroup()
                                                        .addComponent(jLabel17)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(txtInteresCuota))
                                                    .addGroup(contenidoLayout.createSequentialGroup()
                                                        .addComponent(jLabel28)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(txtCapitalCuota, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contenidoLayout.createSequentialGroup()
                                                        .addComponent(jLabel10)
                                                        .addGap(16, 16, 16)))
                                                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(contenidoLayout.createSequentialGroup()
                                                        .addGap(87, 87, 87)
                                                        .addComponent(jLabel12))
                                                    .addGroup(contenidoLayout.createSequentialGroup()
                                                        .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addGroup(contenidoLayout.createSequentialGroup()
                                                                .addGap(45, 45, 45)
                                                                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                    .addGroup(contenidoLayout.createSequentialGroup()
                                                                        .addComponent(jLabel25)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(txtTotalPago, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                    .addGroup(contenidoLayout.createSequentialGroup()
                                                                        .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                            .addComponent(jLabel24)
                                                                            .addComponent(jLabel23))
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                            .addComponent(txtTotalIva)
                                                                            .addComponent(txtTotalIntereses, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)))))
                                                            .addGroup(contenidoLayout.createSequentialGroup()
                                                                .addGap(50, 50, 50)
                                                                .addComponent(jLabel9)))
                                                        .addGap(45, 45, 45)
                                                        .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addGroup(contenidoLayout.createSequentialGroup()
                                                                .addComponent(btnCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(hvreload, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                            .addGroup(contenidoLayout.createSequentialGroup()
                                                                .addComponent(jLabel22)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(txtmontorecibir, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
                                    .addGroup(contenidoLayout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtbusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(contenidoLayout.createSequentialGroup()
                                                .addComponent(rbnnombre)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(rbndui)))
                                        .addGap(18, 18, 18)
                                        .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtDui, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel3))))
                        .addGap(0, 49, Short.MAX_VALUE))
                    .addComponent(jSeparator2))
                .addContainerGap())
        );
        contenidoLayout.setVerticalGroup(
            contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenidoLayout.createSequentialGroup()
                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contenidoLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel5)
                            .addComponent(txtDui, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rbnnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(rbndui, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel4)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtbusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel7)
                    .addComponent(cmbtipocredito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtmonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel9)
                    .addComponent(cmbplazos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hvreload, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel29)
                    .addComponent(jLabel30)
                    .addComponent(txttasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(cmbformapagos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDetalle))
                .addGap(24, 24, 24)
                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel2)
                    .addComponent(jLabel10)
                    .addComponent(jLabel12))
                .addGap(15, 15, 15)
                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(chkAsesoria, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAsesoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(txtcuota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25)
                    .addComponent(txtTotalPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel22)
                        .addComponent(txtmontorecibir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                        .addComponent(txtIvaCuota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTotalIva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel24)
                        .addComponent(jLabel19))
                    .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtcapitald, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel18)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel20)
                    .addComponent(txtinteresesd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28)
                    .addComponent(txtCapitalCuota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtmorad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addGap(20, 20, 20)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(fechsolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27)
                    .addComponent(jLabel31)
                    .addComponent(cmbtipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDestinoCredito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(contenidoLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel26)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(cmbCarteras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(cmbEstadocredito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGenerarsolicitud, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );

        rbnnombre.setSelected(true);
        hvreload.setImages("/IMAGES/ICONS/reload1.png","/IMAGES/ICONS/reload.png");
        cmbCarteras.setModel(modeloCarteras);

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

    private void txtbusquedaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbusquedaKeyTyped
        Character c = evt.getKeyChar();
        if(Character.isLetter(c)) {
            evt.setKeyChar(Character.toUpperCase(c));
        }
    }//GEN-LAST:event_txtbusquedaKeyTyped

    private void txtmontoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtmontoKeyTyped

        char caracter= evt.getKeyChar();
        char punto = '.';
        if((!Character.isDigit(caracter)) && (caracter!=punto)) evt.consume();

    }//GEN-LAST:event_txtmontoKeyTyped

    private void btnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularActionPerformed
      
        if(!txtmonto.getText().trim().isEmpty() && cmbplazos.getSelectedIndex()!=0 && cmbformapagos.getSelectedIndex()!=0){
            if(monto.validarDouble(txtmonto.getText())){
                limpiarCampos();
                    //CLIENTE NUEVO, RECURRENTE Y EXPRESS
                    if(cmbtipocredito.getSelectedIndex()<3 || cmbtipocredito.getSelectedIndex()>4){
                       
                        if(!txttasa.getText().trim().isEmpty()){  
                            mont = new monto(txtmonto.getText(),cmbplazos.getSelectedIndex(),cmbformapagos.getSelectedIndex(), txttasa.getText()); 
                            mont.settotalDeducciones(chkAsesoria.isSelected(),chkcuotafinal.isSelected(),txtinteresesd.getText(),txtcapitald.getText(),txtmorad.getText());
                            txtTotalIntereses.setText(mont.getTotalIntereses());
                            txtTotalIva.setText(mont.getTotalIva());
                            cargarCamposMontos(mont);
                        }else{JOptionPane.showMessageDialog(this, "Es necesario Especificar la tasa de Interes");}
                    
                    }else if(desCargados==true){
                        //REFINANCIAMIENTO
                        if(cmbtipocredito.getSelectedIndex()!=3){
                            
                            if(!txttasa.getText().trim().isEmpty()){
                                txtinteresesd.setText(interesRef);
                                txtmorad.setText(moraRef);
                                txtcapitald.setText(capitalRef);
                                mont = new monto(txtmonto.getText(),cmbplazos.getSelectedIndex(),cmbformapagos.getSelectedIndex(), txttasa.getText()); 
                                mont.settotalDeducciones(chkAsesoria.isSelected(),chkcuotafinal.isSelected(),txtinteresesd.getText(),txtcapitald.getText(),txtmorad.getText());
                                txtTotalIntereses.setText(mont.getTotalIntereses());
                                txtTotalIva.setText(mont.getTotalIva());
                                cargarCamposMontos(mont);
                            }else{JOptionPane.showMessageDialog(this, "Es necesario Especificar la tasa de Interes");}
                            
                        //GESTION DE ARREGLO
                        }else{
                            txtTotalIntereses.setText(interesesGC);
                            txtTotalIva.setText(ivaGC);
                            mont = new monto(txtmonto.getText(),cmbplazos.getSelectedIndex(),cmbformapagos.getSelectedIndex(), txtTotalIva.getText(), txtTotalIntereses.getText());
                            mont.settotalDeducciones(chkAsesoria.isSelected(),chkcuotafinal.isSelected());
                            cargarCamposMontos(mont);
                        }

                    }else{JOptionPane.showMessageDialog(this, "No se a escogido el crédito a refinanciar o reestructurar");}
              
                }else { JOptionPane.showMessageDialog(this, "el valor ingresado del monto no es correcto");}    
        }else{ JOptionPane.showMessageDialog(this, "Hace falta especificar valores"); }
      
      
    }//GEN-LAST:event_btnCalcularActionPerformed

    private void btnGenerarsolicitudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarsolicitudActionPerformed

        boolean valido = true;
        if(scjc.comprobarSolicitud(datospersonales)){
            if(scjc.validarCreditosActivos(datospersonales)){
                
                if(validarcampos()){
                    solicitud = new SolicitudCredito();
                    cargarDatosSolicitud(solicitud);
                    try {
                        scjc.create(solicitud);
                    } catch (Exception ex) {
                        valido = false;
                        Logger.getLogger(NUEVA_SOLICITUD_FORM.class.getName()).log(Level.SEVERE, null, ex);
                    }
               
                    if(valido){
                        listasolicitud.cargarModelo();
                        listasolicitud.tblSolicitudes.clearSelection();
                        listasolicitud.tblSolicitudes.updateUI();
                        try {archivos.crearCarpetaPerfil(datospersonales.getNombre());} 
                        catch (IOException ex) {System.out.println(ex);}
                        this.dispose(); 
                    }else{
                        JOptionPane.showMessageDialog(this,"Error al registrar la transaccion en la base de datos");
                    }     
       
                }else{
                    JOptionPane.showMessageDialog(this,"Hace falta especificar algunos campos.");
                }
            }else{
                JOptionPane.showMessageDialog(this,"La Solicitud no puede ser registrada.\nEl Cliente "+datospersonales.getNombre()
                                              +"\nactualmente cuenta con dos Creditos activos.");
            }
        }else{
            JOptionPane.showMessageDialog(this, "La Solicitud no puede ser registrada.\nEl Cliente "+datospersonales.getNombre()
                                          +"\nactualmente cuenta con una solicitud en proceso.");
        }     
    }//GEN-LAST:event_btnGenerarsolicitudActionPerformed

    private void txtbusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbusquedaKeyReleased
       
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!txtbusqueda.getText().isEmpty() && (rbnnombre.isSelected() != false || rbndui.isSelected() != false)) {
                if (rbndui.isSelected() == true) {
                    try{
                        if (dtjc.findDatosPersonales(txtbusqueda.getText()) != null) {
                            datospersonales = dtjc.findDatosPersonales(txtbusqueda.getText());  
                            cargarCliente();
                        } else {
                            JOptionPane.showMessageDialog(this, "el cliente con el dui: " + txtbusqueda.getText() + "\nNo existe en la base de datos");
                        }
                    }catch(Exception ex){JOptionPane.showMessageDialog(this, "Error al conectarse con la base de datos.");}
                } else if (rbnnombre.isSelected() == true) {
                    try{
                        if (dtjc.findByNombre(txtbusqueda.getText()) != null) {
                            datospersonales = dtjc.findByNombre(txtbusqueda.getText());
                            cargarCliente();
                        } else {
                            JOptionPane.showMessageDialog(this, "el cliente con el nombre: " + txtbusqueda.getText() + "\nNo existe en la base de datos");
                        }
                    }catch(Exception ex){JOptionPane.showMessageDialog(this, "Error al conectarse con la base de datos.");}
                }
            } else {
                JOptionPane.showMessageDialog(this, "ingrese el nombre o dui del cliente");
            }
        }
        
    }//GEN-LAST:event_txtbusquedaKeyReleased

    private void txttasaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttasaKeyTyped
        char caracter= evt.getKeyChar();
        if(!Character.isDigit(caracter)) evt.consume();
    }//GEN-LAST:event_txttasaKeyTyped

    private void btnDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetalleActionPerformed
        
        if(datospersonales!=null && cmbtipocredito.getSelectedIndex()!=0){
            saldosform = new SALDOS_PENDIENTES_FORM(datospersonales, cmbtipocredito.getSelectedIndex(), this);
            saldosform.setVisible(true);
        
        }
    
    }//GEN-LAST:event_btnDetalleActionPerformed

    private void hvreloadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hvreloadMouseClicked
        
        limpiarCampos();
        
        
    }//GEN-LAST:event_hvreloadMouseClicked

    public void cargarCliente(){
        txtNombre.setText(datospersonales.getNombre());
        txtDui.setText(datospersonales.getDui());
    }
    
    public void limpiarCampos(){
    
        txtAsesoria.setText("");
        txtcuotafinal.setText("");
        txtcapitald.setText("");
        txtinteresesd.setText("");
        txtmorad.setText("");
        
        txtcuota.setText("");
        txtInteresCuota.setText("");
        txtIvaCuota.setText("");
        txtCapitalCuota.setText("");
        
        txtTotalPago.setText("");
        txtTotalIva.setText("");
        txtTotalIntereses.setText("");
        
        txtmontorecibir.setText("");
    
    
    }
    
    private boolean validarcampos(){
        boolean validacion =true;
            if(datospersonales==null || txtmonto.getText().trim().isEmpty() || cmbplazos.getSelectedIndex()==0
               || cmbformapagos.getSelectedIndex()==0 || cmbtipocredito.getSelectedIndex()==0
               || cmbEstadocredito.getSelectedIndex()==0 || fechsolicitud.getDate().toString().isEmpty()
               || txtDestinoCredito.getText().isEmpty() || cmbtipo.getSelectedIndex()==0 || cmbCarteras.getSelectedIndex()==0 ){validacion=false;}
            
            if(cmbtipocredito.getSelectedIndex()!=3){
                if(txttasa.getText().trim().isEmpty()){validacion=false;}
            }else{
                if(sinCreditos==true){
                    if(txttasa.getText().trim().isEmpty()){validacion=false;}
                }
            }
            
            if(cmbtipocredito.getSelectedIndex()==3 || cmbtipocredito.getSelectedIndex()==4){ 
                if(idCreditoACambiar!=0){validacion=false;}
            }
                
        return validacion;
    }
    
    private void cargarCamposMontos(monto monto1){
    
        txtcuota.setText(monto1.getCuota());
        txtInteresCuota.setText(monto1.valorXCuota(mont.getTotalIntereses()));
        txtIvaCuota.setText(monto1.valorXCuota(mont.getTotalIva()));
        txtCapitalCuota.setText(monto1.valorXCuota(String.valueOf(mont.getMonto())));
             
        if(chkAsesoria.isSelected()){txtAsesoria.setText(monto1.getAsesoria());}
        if(chkcuotafinal.isSelected()){txtcuotafinal.setText(monto1.getCuota());}
                
        txtmontorecibir.setText(monto1.getMontoRecibir());
        txtTotalPago.setText(monto1.getTotalPago());  
  
    }
    
    private void cargarDatosSolicitud(SolicitudCredito solicitud){
        
        SolicitudCreditoPK pk =new SolicitudCreditoPK(scjc.obtenerID(),datospersonales.getDui());
        solicitud.setSolicitudCreditoPK(pk);
        solicitud.setDatosPersonales(datospersonales);
        solicitud.setFechaSolicitud(fechsolicitud.getDate());
        solicitud.setTipoCredito(Short.valueOf(String.valueOf(cmbtipocredito.getSelectedIndex())));
        solicitud.setMontoRequerido(Double.valueOf(txtmonto.getText()));
        solicitud.setPlazo(Short.valueOf(String.valueOf(cmbplazos.getSelectedIndex())));
        solicitud.setFormaPago(Short.valueOf(String.valueOf(cmbformapagos.getSelectedIndex())));
        solicitud.setCuota(Double.valueOf(txtcuota.getText()));
        solicitud.setTipo((short)cmbtipo.getSelectedIndex());
        solicitud.setEstado((short)cmbEstadocredito.getSelectedIndex());
        solicitud.setDesembolso(false);
        solicitud.setIdCreditodes(idCreditoACambiar);
        if(txtDestinoCredito.getText().isEmpty()){solicitud.setDestinoCredito("");}else{solicitud.setDestinoCredito(txtDestinoCredito.getText());}
        if(txtObservaciones.getText().isEmpty()){solicitud.setObservacion("");}else{solicitud.setObservacion(txtObservaciones.getText());}
        
        if(cmbtipocredito.getSelectedIndex()!=3){
            solicitud.setTasaInteres(txttasa.getText());
            solicitud.setIvaGa(0.0);
            solicitud.setInteresesGa(0.0);
        }else{
            if(sinCreditos==false){solicitud.setTasaInteres(tasa);}
            else{solicitud.setTasaInteres(txttasa.getText());}
            solicitud.setIvaGa(Double.valueOf(ivaGC));
            solicitud.setInteresesGa(Double.valueOf(interesesGC));
        }
       
        if(cmbtipocredito.getSelectedIndex()==4){
            solicitud.setInteresesDes(Double.valueOf(interesRef));
            solicitud.setMoraDes(Double.valueOf(moraRef));
            solicitud.setCapitalDes(Double.valueOf(capitalRef));
        }else{
            solicitud.setInteresesDes(0.0);
            solicitud.setMoraDes(0.0);
            solicitud.setCapitalDes(0.0);
        }
        
        solicitud.setIdUsuario(usuarios.get(cmbCarteras.getSelectedIndex()-1));
    
    }
    
    private void cargarCarteras(){
        modeloCarteras.addElement("<SELECCIONAR>");
        for(Usuarios usuario: ujc.findUsuariosEntities())
        {
            if(usuario.getChkCartera()){
                String cartera = usuario.getCartera()+" - "+usuario.getNombre();
                modeloCarteras.addElement(cartera);
                usuarios.add(usuario);
            }
        }
        cmbCarteras.updateUI();
    
    }
    

    
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgroup;
    private javax.swing.JButton btnCalcular;
    private javax.swing.JButton btnDetalle;
    private javax.swing.JButton btnGenerarsolicitud;
    private javax.swing.JCheckBox chkAsesoria;
    private javax.swing.JCheckBox chkcuotafinal;
    private javax.swing.JComboBox<String> cmbCarteras;
    private javax.swing.JComboBox<String> cmbEstadocredito;
    private javax.swing.JComboBox<String> cmbformapagos;
    private javax.swing.JComboBox<String> cmbplazos;
    private javax.swing.JComboBox<String> cmbtipo;
    private javax.swing.JComboBox<String> cmbtipocredito;
    private javax.swing.JPanel contenido;
    private javax.swing.JPanel encabezado;
    private com.toedter.calendar.JDateChooser fechsolicitud;
    private Label.HoverIcon hvCerrar;
    private Label.HoverIcon hvreload;
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JRadioButton rbndui;
    private javax.swing.JRadioButton rbnnombre;
    private javax.swing.JTextField txtAsesoria;
    private javax.swing.JTextField txtCapitalCuota;
    private javax.swing.JTextField txtDestinoCredito;
    private javax.swing.JTextField txtDui;
    private javax.swing.JTextField txtInteresCuota;
    private javax.swing.JTextField txtIvaCuota;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextArea txtObservaciones;
    public javax.swing.JTextField txtTotalIntereses;
    public javax.swing.JTextField txtTotalIva;
    private javax.swing.JTextField txtTotalPago;
    private javax.swing.JTextField txtbusqueda;
    public javax.swing.JTextField txtcapitald;
    private javax.swing.JTextField txtcuota;
    private javax.swing.JTextField txtcuotafinal;
    public javax.swing.JTextField txtinteresesd;
    public javax.swing.JTextField txtmonto;
    private javax.swing.JTextField txtmontorecibir;
    public javax.swing.JTextField txtmorad;
    private javax.swing.JTextField txttasa;
    // End of variables declaration//GEN-END:variables
}
