package FORMS;

import CONTROLADORES.CreditosJpaController;
import CONTROLADORES.MoraJpaController;
import CONTROLADORES.PagosJpaController;
import DOCS_DATASOURCES.DS_HistorialPagos;
import DOCS_DATASOURCES.JasperGenerator;
import Entidades.Creditos;
import Entidades.Mora;
import Entidades.Pagos;
import FORMS.PANELS.LISTA_CREDITOS_PNL;
import FORMS.PANELS.LISTA_MORAS_PNL;
import MODELOSTBL.modeloPagos;
import UTILIDADES.fechas;
import UTILIDADES.monto;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author DFUENTES
 */
public class PAGO_FORM extends javax.swing.JFrame {

    public Creditos credito;
    public Mora mora;
    public Pagos pago;

    public LISTA_CREDITOS_PNL cp;
    public LISTA_MORAS_PNL mp;

    private modeloPagos modelo = new modeloPagos();

    private int cuotasalafecha;
    private int cuotaspagadas;
    private int cuotaCap;
    private int cuotaInt;
    private int cuotaIva;

    private double capitalxcuota;
    private double interesxcuota;
    private double ivaxcuota;

    private boolean montosPendientes = false;
    private double morapendiente;
    private double capitalV;
    private double interesV;
    private double ivaV;

    private double montoPago;
    private double pagoMora;
    private double pagoInteres;
    private double pagoIva;
    private double pagoCapital;

    private double totalInteresPagado;
    private double totalIvaPagado;
    private double totalCapitalPagado;

    private double totalPagado;

    private int cuotasAd;

    private DS_HistorialPagos pagos = new DS_HistorialPagos();
    private JasperGenerator jasper = new JasperGenerator();
    private Map parametros = new HashMap();
    private List<Pagos> listaPagos = new ArrayList<Pagos>();

    public CreditosJpaController cjc = new CreditosJpaController();
    public PagosJpaController pjc = new PagosJpaController();
    public MoraJpaController mjc = new MoraJpaController();

    public PAGO_FORM(Creditos credito1, LISTA_CREDITOS_PNL cp1, LISTA_MORAS_PNL mp1) {

        initComponents();
        this.setLocationRelativeTo(null);

        credito = credito1;
        mora = credito.getSolicitudCredito().getMora();

        cp = cp1;
        mp = mp1;

        rbnAbonoCuotas.setSelected(true);

        cargarCredito();
        cargarListaCuotas();
        cargarPagos();
        cargarMontosPendientes();
        pagos.addCredito(credito);
        getPagos();

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
        txtCredito = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        btnguardar = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        txtCuota = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        txtCapitalCuota = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        txtInteresCuota = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        txtIvaCuota = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cmbformapagos = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        cmbplazos = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPagos = new javax.swing.JTable();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel32 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtListaCuotas = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtmonto = new javax.swing.JTextField();
        hvreload = new Label.HoverIcon();
        jLabel15 = new javax.swing.JLabel();
        fechpago = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        txtfactura = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtcapital = new javax.swing.JTextField();
        txtintereses = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtMora = new javax.swing.JTextField();
        txtIVA = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        btnGenerarFactura = new javax.swing.JButton();
        rbnAbonoCapital = new javax.swing.JRadioButton();
        rbnAbonoCuotas = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txtTotalPendiente = new javax.swing.JTextField();
        txtMontoPendiente = new javax.swing.JTextField();
        txtMoraPendiente = new javax.swing.JTextField();
        rbnAbonoCuotasyCap = new javax.swing.JRadioButton();
        btnGenerarHistorial = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(240, 236, 236));
        setModalExclusionType(java.awt.Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        setUndecorated(true);
        setResizable(false);

        encabezado.setBackground(new java.awt.Color(0, 23, 46));

        hvCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/ICONS/cerrarDes2.png"))); // NOI18N
        hvCerrar.setText("hoverIcon1");
        hvCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hvCerrarMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("REGISTRO DE PAGO");

        javax.swing.GroupLayout encabezadoLayout = new javax.swing.GroupLayout(encabezado);
        encabezado.setLayout(encabezadoLayout);
        encabezadoLayout.setHorizontalGroup(
            encabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, encabezadoLayout.createSequentialGroup()
                .addGap(521, 521, 521)
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
        contenido.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 23, 46), 2));

        jLabel5.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("ID Crédito:");

        txtCredito.setEditable(false);
        txtCredito.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Nombre:");

        txtNombre.setEditable(false);
        txtNombre.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N

        btnguardar.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        btnguardar.setText("GUARDAR");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(51, 51, 51));
        jLabel27.setText("Monto de Cuota:");

        txtCuota.setEditable(false);
        txtCuota.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N

        jLabel28.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(51, 51, 51));
        jLabel28.setText("Capital:");

        txtCapitalCuota.setEditable(false);
        txtCapitalCuota.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N

        jLabel29.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(51, 51, 51));
        jLabel29.setText("Intereses:");

        txtInteresCuota.setEditable(false);
        txtInteresCuota.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N

        jLabel30.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(51, 51, 51));
        jLabel30.setText("IVA:");

        txtIvaCuota.setEditable(false);
        txtIvaCuota.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N

        jLabel31.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(51, 51, 51));
        jLabel31.setText("DETALLE DE CUOTA:");

        jLabel11.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("Forma de Pago:");

        cmbformapagos.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        cmbformapagos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "SEMANAL", "CATORCENAL", "MENSUAL" }));
        cmbformapagos.setFocusable(false);

        jLabel9.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Plazo:");

        cmbplazos.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        cmbplazos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "1 mes / 4 semanas", "2 meses / 8 semanas", "3 meses / 12 semanas", "4 meses / 16 semanas", "5 meses / 20 semanas", "6 meses / 24 semanas", "7 meses / 28 semanas", "8 meses / 32 semanas", "9 meses / 36 semanas", "10 meses / 40 semanas", "11 meses / 44 semanas", "12 meses / 48 semanas" }));

        tblPagos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tblPagos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblPagos.setRowHeight(30);
        tblPagos.setSelectionBackground(new java.awt.Color(204, 255, 204));
        tblPagos.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tblPagos.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblPagos);
        tblPagos.setModel(modelo);
        DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
        leftRenderer.setHorizontalAlignment(DefaultTableCellRenderer.LEFT);

        jLabel32.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(51, 51, 51));
        jLabel32.setText("CUOTAS:");

        txtListaCuotas.setColumns(20);
        txtListaCuotas.setRows(5);
        jScrollPane2.setViewportView(txtListaCuotas);

        jLabel6.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("MONTO DEL PAGO");

        jLabel8.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Monto:");

        txtmonto.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        txtmonto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtmontoKeyTyped(evt);
            }
        });

        hvreload.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/ICONS/reload.png"))); // NOI18N
        hvreload.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hvreloadMouseClicked(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(51, 51, 51));
        jLabel15.setText("Fecha de Pago:");

        jLabel10.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("Nº de Factura:");

        txtfactura.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N

        jLabel18.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(51, 51, 51));
        jLabel18.setText("Capital:");

        jLabel20.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(51, 51, 51));
        jLabel20.setText("Intereses:");

        txtcapital.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        txtcapital.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcapitalKeyTyped(evt);
            }
        });

        txtintereses.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        txtintereses.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtinteresesKeyTyped(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(51, 51, 51));
        jLabel22.setText("IVA:");

        jLabel21.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(51, 51, 51));
        jLabel21.setText("Mora:");

        txtMora.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        txtMora.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMoraKeyTyped(evt);
            }
        });

        txtIVA.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        txtIVA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIVAKeyTyped(evt);
            }
        });

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        btnGenerarFactura.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        btnGenerarFactura.setText("Generar Factura");

        rbnAbonoCapital.setBackground(new java.awt.Color(240, 236, 236));
        bgroup.add(rbnAbonoCapital);
        rbnAbonoCapital.setText("Abono a  Capital");

        rbnAbonoCuotas.setBackground(new java.awt.Color(240, 236, 236));
        bgroup.add(rbnAbonoCuotas);
        rbnAbonoCuotas.setText("Abono a Cuotas");

        jLabel7.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Tipo de Pago:");

        jLabel12.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setText("DETALLE DE MORA");

        jLabel19.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(51, 51, 51));
        jLabel19.setText("Mora pendiente de pag0:");

        jLabel24.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(51, 51, 51));
        jLabel24.setText("Monto pendiente de pago:");

        jLabel26.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(51, 51, 51));
        jLabel26.setText("Total Pendiente:");

        txtTotalPendiente.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N

        txtMontoPendiente.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N

        txtMoraPendiente.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N

        rbnAbonoCuotasyCap.setBackground(new java.awt.Color(240, 236, 236));
        bgroup.add(rbnAbonoCuotasyCap);
        rbnAbonoCuotasyCap.setText("Pago de Cuotas y abono a Capital");

        btnGenerarHistorial.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        btnGenerarHistorial.setText("Generar historial de pagos");
        btnGenerarHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarHistorialActionPerformed(evt);
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
                        .addGap(28, 28, 28)
                        .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(contenidoLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCredito, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel31)
                            .addGroup(contenidoLayout.createSequentialGroup()
                                .addComponent(jLabel27)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCuota, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel28)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCapitalCuota, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel29)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtInteresCuota, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel30)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtIvaCuota, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbformapagos, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbplazos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(contenidoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(contenidoLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 805, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel32))
                                .addGap(0, 25, Short.MAX_VALUE))
                            .addComponent(jSeparator3))))
                .addContainerGap())
            .addGroup(contenidoLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contenidoLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(contenidoLayout.createSequentialGroup()
                        .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTotalPendiente, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtMontoPendiente, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtMoraPendiente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(contenidoLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6))
                            .addGroup(contenidoLayout.createSequentialGroup()
                                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(contenidoLayout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtmonto, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(hvreload, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(contenidoLayout.createSequentialGroup()
                                        .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(contenidoLayout.createSequentialGroup()
                                                .addGap(5, 5, 5)
                                                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(txtMora, javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtIVA, javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtcapital, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(contenidoLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtintereses, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(18, 18, 18)
                                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rbnAbonoCapital)
                                    .addComponent(rbnAbonoCuotasyCap)
                                    .addComponent(rbnAbonoCuotas)
                                    .addGroup(contenidoLayout.createSequentialGroup()
                                        .addComponent(jLabel15)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fechpago, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel10)
                                        .addGap(4, 4, 4)
                                        .addComponent(txtfactura, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel7))
                                .addGap(56, 56, 56)
                                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(btnGenerarHistorial)
                                    .addComponent(btnGenerarFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(42, 42, 42))))
        );
        contenidoLayout.setVerticalGroup(
            contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenidoLayout.createSequentialGroup()
                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contenidoLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel4)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(txtCredito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(contenidoLayout.createSequentialGroup()
                                .addComponent(jLabel31)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel27)
                                    .addComponent(txtCuota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel28)
                                    .addComponent(txtCapitalCuota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel29)
                                    .addComponent(txtInteresCuota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel30)
                                    .addComponent(txtIvaCuota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                .addComponent(jLabel11)
                                .addComponent(cmbformapagos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9)
                                .addComponent(cmbplazos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(contenidoLayout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(jLabel8)
                                    .addComponent(txtmonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(hvreload, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15)
                                    .addComponent(fechpago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel10)
                                        .addComponent(txtfactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnGenerarFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(contenidoLayout.createSequentialGroup()
                                        .addGap(11, 11, 11)
                                        .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                            .addComponent(jLabel18)
                                            .addComponent(txtcapital, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel7))
                                        .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(contenidoLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(txtintereses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel20))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                                    .addComponent(jLabel22)
                                                    .addComponent(txtIVA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                                    .addComponent(jLabel21)
                                                    .addComponent(txtMora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(contenidoLayout.createSequentialGroup()
                                                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contenidoLayout.createSequentialGroup()
                                                        .addComponent(rbnAbonoCuotas)
                                                        .addGap(27, 27, 27))
                                                    .addGroup(contenidoLayout.createSequentialGroup()
                                                        .addGap(25, 25, 25)
                                                        .addComponent(rbnAbonoCuotasyCap)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                                .addComponent(rbnAbonoCapital))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contenidoLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnGenerarHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(contenidoLayout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jLabel12)
                                .addGap(18, 18, 18)
                                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(jLabel19)
                                    .addComponent(txtMoraPendiente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(jLabel24)
                                    .addComponent(txtMontoPendiente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtTotalPendiente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel26)))))
                    .addGroup(contenidoLayout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(contenidoLayout.createSequentialGroup()
                        .addComponent(jLabel32)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        hvreload.setImages("/IMAGES/ICONS/reload1.png","/IMAGES/ICONS/reload.png");

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

    private void txtIVAKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIVAKeyTyped
        char caracter = evt.getKeyChar();
        char punto = '.';
        if ((!Character.isDigit(caracter)) && (caracter != punto)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtIVAKeyTyped

    private void txtMoraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMoraKeyTyped
        char caracter = evt.getKeyChar();
        char punto = '.';
        if ((!Character.isDigit(caracter)) && (caracter != punto)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtMoraKeyTyped

    private void txtinteresesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtinteresesKeyTyped
        char caracter = evt.getKeyChar();
        char punto = '.';
        if ((!Character.isDigit(caracter)) && (caracter != punto)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtinteresesKeyTyped

    private void txtcapitalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcapitalKeyTyped
        char caracter = evt.getKeyChar();
        char punto = '.';
        if ((!Character.isDigit(caracter)) && (caracter != punto)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtcapitalKeyTyped

    private void hvreloadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hvreloadMouseClicked

        limpiarMontos();
        montoPago = Double.parseDouble(txtmonto.getText());

        if (montosPendientes == true) {

            if (morapendiente > 0) {
                acumularPagoMora();
            }

            if (montoPago > 0) {
                while (montoPago > 0 && cancelacionDeMontosVencidos()) {
                    ivaV = ivaV - acumularPagoIvaxCuota();
                    interesV = interesV - acumularPagoInteresesxCuota();
                    capitalV = capitalV - acumularPagoCapitalxCuota();
                }
            }

        }

        if (montoPago > 0) {

            if (rbnAbonoCuotas.isSelected()) {

                while (montoPago > 0) {

                    acumularPagoIvaxCuota();
                    acumularPagoInteresesxCuota();
                    acumularPagoCapitalxCuota();
                }

            } else if (rbnAbonoCuotasyCap.isSelected()) {
            } else if (rbnAbonoCapital.isSelected()) {
            }

        }

        txtMora.setText(String.valueOf(pagoMora));
        txtintereses.setText(String.valueOf(pagoInteres));
        txtIVA.setText(String.valueOf(pagoIva));
        txtcapital.setText(String.valueOf(pagoCapital));


    }//GEN-LAST:event_hvreloadMouseClicked

    private void txtmontoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtmontoKeyTyped

        char caracter = evt.getKeyChar();
        char punto = '.';
        if ((!Character.isDigit(caracter)) && (caracter != punto)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtmontoKeyTyped

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed

        if (fechpago.getDate() != null && !txtfactura.getText().trim().isEmpty() && !txtmonto.getText().trim().isEmpty()) {

            llenarPago();
            actualizarCredito();

            try {
                pjc.create(pago);
            } catch (Exception ex) {
                Logger.getLogger(PAGO_FORM.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                cjc.edit(credito);
            } catch (Exception ex) {
                Logger.getLogger(PAGO_FORM.class.getName()).log(Level.SEVERE, null, ex);
            }

            cargarPagos();

        } else {
            JOptionPane.showMessageDialog(this, "Es necesario especificar la fecha de pago y número de factura.");
        }

    }//GEN-LAST:event_btnguardarActionPerformed

    private void btnGenerarHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarHistorialActionPerformed
        String doc = "HistorialPagos";
        parametros.clear();
        parametros.put("Pagos", listaPagos);
        try {
            jasper.crearReporteConParam(doc, credito.getSolicitudCredito().getDatosPersonales().getNombre(), parametros, pagos);
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, "Error al crear el documento: " + ex.getMessage());;
        }
        this.dispose();
    }//GEN-LAST:event_btnGenerarHistorialActionPerformed

    private List<Pagos> getPagos() {
        for (Pagos p : credito.getSolicitudCredito().getPagosList()) {
            listaPagos.add(p);
        }
        return listaPagos;
    }

    private void limpiarMontos() {

        montoPago = 0;
        pagoMora = 0;
        pagoInteres = 0;
        pagoIva = 0;
        pagoCapital = 0;

        totalInteresPagado = cjc.obtenerInteresesPagados(credito);
        totalIvaPagado = cjc.obtenerIvaPagado(credito);
        totalCapitalPagado = cjc.obtenerCapitalPagado(credito);

        cargarMontosPendientes();

        cuotaspagadas = cjc.getCuotasPagadas(credito);

    }

    private void cargarCredito() {

        txtNombre.setText(credito.getSolicitudCredito().getDatosPersonales().getNombre());
        txtCredito.setText(String.valueOf(credito.getCreditosPK().getIdSolicitudCredito()));
        txtCuota.setText(credito.getCuota().toString());
        cmbplazos.setSelectedIndex(credito.getPlazo());
        cmbformapagos.setSelectedIndex(credito.getFormaPago());

        capitalxcuota = monto.valorXCuota(credito.getMonto(), credito.getPlazo(), credito.getFormaPago());
        interesxcuota = monto.valorXCuota(credito.getTotalIntereses(), credito.getPlazo(), credito.getFormaPago());
        ivaxcuota = monto.valorXCuota(credito.getTotalIva(), credito.getPlazo(), credito.getFormaPago());

        txtCapitalCuota.setText(String.valueOf(capitalxcuota));
        txtInteresCuota.setText(String.valueOf(interesxcuota));
        txtIvaCuota.setText(String.valueOf(ivaxcuota));

        cuotasalafecha = fechas.numerodepagos(credito.getFormaPago(), credito.getFechaPrimerPago(), mp.panel.fechasistema.getDate());
        cuotaspagadas = cjc.getCuotasPagadas(credito);
        cuotasAd = credito.getCuotasPorPagar() - credito.getCuotasAdelantadas();

        totalInteresPagado = cjc.obtenerInteresesPagados(credito);
        totalIvaPagado = cjc.obtenerIvaPagado(credito);
        totalCapitalPagado = cjc.obtenerCapitalPagado(credito);

        totalPagado = totalInteresPagado + totalIvaPagado + totalCapitalPagado;
        totalPagado = monto.redondear(totalPagado, 2);

    }

    private void cargarListaCuotas() {

        ArrayList<String> listaCuotas = fechas.fechasdeCuotas(credito);

        int contador = 1;
        int pagadas = credito.getCuotasPorPagar() - credito.getCuotasAdelantadas();

        for (String cuota : listaCuotas) {

            if (contador <= cjc.getCuotasPagadas(credito)) {
                txtListaCuotas.setText(txtListaCuotas.getText() + cuota + "\tCancelada\n");
            } else {

                if (contador == (cjc.getCuotasPagadas(credito) + 1)) {
                    double total = monto.redondear((credito.getCuota() * cuotaspagadas), 2);
                    if (totalPagado > total) {
                        total = monto.redondear((totalPagado - total), 2);
                        txtListaCuotas.setText(txtListaCuotas.getText() + cuota + "\tAbonada: " + total + "\n");
                    } else {
                        txtListaCuotas.setText(txtListaCuotas.getText() + cuota + "\n");
                    }

                } else {

                    if (credito.getCuotasAdelantadas() > 0) {
                        if (contador > cuotasAd) {
                            txtListaCuotas.setText(txtListaCuotas.getText() + cuota + "\tCancelada\n");
                        } else {
                            txtListaCuotas.setText(txtListaCuotas.getText() + cuota + "\n");
                        }
                    } else {
                        txtListaCuotas.setText(txtListaCuotas.getText() + cuota + "\n");
                    }

                }
            }

            contador++;
        }

    }

    private void cargarMontosPendientes() {

        if (fechas.verificarPrimerPago(credito.getFechaPrimerPago(), mp.panel.fechasistema.getDate())) {

            if (mora != null) {

                if (mora.getEstado() == 0) {

                    montosPendientes = true;
                    morapendiente = monto.redondear(mora.getMoraTotal() - mora.getMoraCancelada(), 2);
                    txtMoraPendiente.setText(String.valueOf(morapendiente));

                    interesV = mora.getInteresVencido();
                    ivaV = mora.getIvaVencido();
                    capitalV = mora.getCapitalVencido();
                    txtMontoPendiente.setText(String.valueOf(interesV + ivaV + capitalV));
                    txtTotalPendiente.setText(String.valueOf(interesV + ivaV + capitalV + morapendiente));
                }

            } else {

                txtTotalPendiente.setText("0.0");
            }
        }

    }

    private void cargarPagos() {
        modelo.borrartodos();
        if (credito.getSolicitudCredito().getPagosList().size() > 0) {
            for (Pagos pago : credito.getSolicitudCredito().getPagosList()) {
                modelo.agregarPago(pago);
            }
        }
        tblPagos.updateUI();
    }

    private boolean cancelacionDeMontosVencidos() {
        boolean pago = true;
        if (ivaV == 0 && interesV == 0 && capitalV == 0) {
            pago = false;
        }
        return pago;
    }

    private void acumularPagoMora() {

        if (morapendiente > 0) {
            if (montoPago > morapendiente) {
                pagoMora = morapendiente;
                montoPago = montoPago - morapendiente;
            } else {
                pagoMora = montoPago;
                montoPago = 0.0;
            }
        }

    }

    private double acumularPagoInteresesxCuota() {

        double pago = 0.0;
        double interesesCP = cuotaspagadas * interesxcuota;
        interesesCP = monto.redondear(interesesCP, 2);

        if (totalInteresPagado > interesesCP) {

            double adelanto = cjc.obtenerInteresesPagados(credito) - interesesCP;
            adelanto = monto.redondear(adelanto, 2);
            if (adelanto < interesxcuota) {
                double interesapagar = interesxcuota - adelanto;
                if (montoPago >= interesapagar) {
                    pagoInteres = pagoInteres + interesapagar;
                    pagoInteres = monto.redondear(pagoInteres, 2);
                    pago = interesapagar;
                    montoPago = montoPago - interesapagar;
                } else {
                    pagoInteres = pagoInteres + montoPago;
                    pagoInteres = monto.redondear(pagoInteres, 2);
                    pago = montoPago;
                    montoPago = 0.0;
                }

            }

        } else if (totalInteresPagado == interesesCP) {

            if (cuotaspagadas < cuotasAd) {
                if (montoPago >= interesxcuota) {
                    pagoInteres = pagoInteres + interesxcuota;
                    pagoInteres = monto.redondear(pagoInteres, 2);
                    pago = interesxcuota;
                    montoPago = montoPago - interesxcuota;
                } else {
                    pagoInteres = pagoInteres + montoPago;
                    pagoInteres = monto.redondear(pagoInteres, 2);
                    pago = montoPago;
                    montoPago = 0.0;
                }
            }
        }

        totalInteresPagado = monto.redondear((totalInteresPagado + pago), 2);

        return pago;

    }

    private double acumularPagoIvaxCuota() {

        double pago = 0.0;
        double ivaCP = cuotaspagadas * ivaxcuota;
        ivaCP = monto.redondear(ivaCP, 2);

        if (totalIvaPagado > ivaCP) {

            double adelanto = cjc.obtenerIvaPagado(credito) - ivaCP;
            adelanto = monto.redondear(adelanto, 2);
            if (adelanto < ivaxcuota) {
                double ivaapagar = ivaxcuota - adelanto;
                if (montoPago >= ivaapagar) {
                    pagoIva = pagoIva + ivaapagar;
                    pagoIva = monto.redondear(pagoInteres, 2);
                    pago = ivaapagar;
                    montoPago = montoPago - ivaapagar;
                    montoPago = monto.redondear(montoPago, 2);
                } else {
                    pagoIva = pagoIva + montoPago;
                    pagoIva = monto.redondear(pagoIva, 2);
                    pago = montoPago;
                    montoPago = 0.0;
                }

            }

        } else if (totalIvaPagado == ivaCP) {

            if (cuotaspagadas < cuotasAd) {
                if (montoPago >= ivaxcuota) {
                    pagoIva = pagoIva + ivaxcuota;
                    pagoIva = monto.redondear(pagoIva, 2);
                    pago = ivaxcuota;
                    montoPago = montoPago - ivaxcuota;
                    montoPago = monto.redondear(montoPago, 2);
                } else {
                    pagoIva = pagoIva + montoPago;
                    pagoIva = monto.redondear(pagoIva, 2);
                    pago = montoPago;
                    montoPago = 0.0;
                }
            }

        }

        totalIvaPagado = monto.redondear((totalIvaPagado + pago), 2);

        return pago;

    }

    private double acumularPagoCapitalxCuota() {

        double pago = 0.0;
        double capitalCP = cuotaspagadas * capitalxcuota;
        capitalCP = monto.redondear(capitalCP, 2);

        if (totalCapitalPagado > capitalCP) {

            if (cuotaspagadas < (cuotasAd - 1)) {
                double adelanto = cjc.obtenerCapitalPagado(credito) - capitalCP;
                adelanto = monto.redondear(adelanto, 2);
                if (adelanto < capitalxcuota) {
                    double capitalapagar = capitalxcuota - adelanto;
                    if (montoPago >= capitalapagar) {
                        pagoCapital = pagoCapital + capitalapagar;
                        pagoCapital = monto.redondear(pagoCapital, 2);
                        pago = capitalapagar;
                        montoPago = montoPago - capitalapagar;
                        montoPago = monto.redondear(montoPago, 2);
                        cuotaspagadas = cuotaspagadas + 1;
                    } else {
                        pagoCapital = pagoCapital + montoPago;
                        pagoCapital = monto.redondear(pagoCapital, 2);
                        pago = montoPago;
                        montoPago = 0.0;
                    }
                }
            } else {
                pago = pagoUltimaCuota();
            }

        } else if (totalCapitalPagado == capitalCP) {

            if (cuotaspagadas < (cuotasAd - 1)) {
                if (montoPago >= capitalxcuota) {
                    pagoCapital = pagoCapital + capitalxcuota;
                    pagoCapital = monto.redondear(pagoCapital, 2);
                    pago = capitalxcuota;
                    montoPago = montoPago - capitalxcuota;
                    montoPago = monto.redondear(montoPago, 2);
                    cuotaspagadas = cuotaspagadas + 1;
                } else {
                    pagoCapital = pagoCapital + montoPago;
                    pagoCapital = monto.redondear(pagoCapital, 2);
                    pago = montoPago;
                    montoPago = 0.0;
                }
            } else if (cuotaspagadas == (cuotasAd - 1)) {
                pago = pagoUltimaCuota();
            }

        }

        totalCapitalPagado = monto.redondear((totalCapitalPagado + pago), 2);

        return pago;

    }

    private double pagoUltimaCuota() {

        double pago = 0.0;
        double pendiente = credito.getMonto() - credito.getSaldoPagado() - pagoCapital;
        pendiente = monto.redondear(pendiente, 2);

        if (montoPago > pendiente) {
            pagoCapital = pagoCapital + pendiente;
            pagoCapital = monto.redondear(pagoCapital, 2);
            pago = pendiente;
            montoPago = montoPago - pendiente;
            montoPago = monto.redondear(montoPago, 2);
            cuotaspagadas = cuotaspagadas + 1;
            JOptionPane.showMessageDialog(this, "El credito se ha pagado totalmente.\nMonto restante del pago: " + montoPago);
        } else {
            pagoCapital = pagoCapital + montoPago;
            pagoCapital = monto.redondear(pagoCapital, 2);
            pago = montoPago;
            if (montoPago == pendiente) {
                cuotaspagadas = cuotaspagadas + 1;
            }
        }

        montoPago = 0.0;

        return pago;
    }

    private void llenarPago() {

        pago = new Pagos();

        pago.setSolicitudCredito(credito.getSolicitudCredito());
        pago.setIdPago(pjc.getPagosCount() + 1);

        pago.setFechaPago(fechpago.getDate());
        pago.setNumFactura(txtfactura.getText());

        pago.setInteres(pagoInteres);
        pago.setIvaIntereses(pagoIva);
        pago.setCapitalAbonado(pagoCapital);

        double morasinIva = monto.redondear((pagoMora / 1.13), 2);
        double ivaMora = monto.redondear((pagoMora - morasinIva), 2);

        pago.setMora(morasinIva);
        pago.setIvaMora(ivaMora);

        double pendiente = credito.getMonto() - credito.getSaldoPagado() - pagoCapital;
        pago.setCapitalPendiente(monto.redondear(pendiente, 2));

        pago.setMontoPagado(Double.valueOf(txtmonto.getText()));

    }

    private void actualizarCredito() {

        credito.setSaldoPagado(credito.getSaldoPagado() + pagoCapital);
        credito.setInteresPagados(credito.getInteresPagados() + pagoInteres);
        credito.setIvaPagado(credito.getIvaPagado() + pagoIva);

        if (pagoMora > 0) {
            credito.setMoraPagada(credito.getMoraPagada() + pagoMora);
        }

        credito.setCuotasPagadas((short) (cuotaspagadas + credito.getCuotasAdelantadas()));

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgroup;
    private javax.swing.JButton btnGenerarFactura;
    private javax.swing.JButton btnGenerarHistorial;
    private javax.swing.JButton btnguardar;
    private javax.swing.JComboBox<String> cmbformapagos;
    private javax.swing.JComboBox<String> cmbplazos;
    private javax.swing.JPanel contenido;
    private javax.swing.JPanel encabezado;
    private com.toedter.calendar.JDateChooser fechpago;
    private Label.HoverIcon hvCerrar;
    private Label.HoverIcon hvreload;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JRadioButton rbnAbonoCapital;
    private javax.swing.JRadioButton rbnAbonoCuotas;
    private javax.swing.JRadioButton rbnAbonoCuotasyCap;
    public javax.swing.JTable tblPagos;
    private javax.swing.JTextField txtCapitalCuota;
    private javax.swing.JTextField txtCredito;
    private javax.swing.JTextField txtCuota;
    private javax.swing.JTextField txtIVA;
    private javax.swing.JTextField txtInteresCuota;
    private javax.swing.JTextField txtIvaCuota;
    private javax.swing.JTextArea txtListaCuotas;
    private javax.swing.JTextField txtMontoPendiente;
    private javax.swing.JTextField txtMora;
    private javax.swing.JTextField txtMoraPendiente;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTotalPendiente;
    private javax.swing.JTextField txtcapital;
    private javax.swing.JTextField txtfactura;
    private javax.swing.JTextField txtintereses;
    private javax.swing.JTextField txtmonto;
    // End of variables declaration//GEN-END:variables
}
