
package FORMS;


import CONTROLADORES.CreditosJpaController;
import CONTROLADORES.SolicitudCreditoJpaController;
import CONTROLADORES.exceptions.NonexistentEntityException;
import CONTROLADORES.exceptions.PreexistingEntityException;
import Entidades.Creditos;
import Entidades.CreditosPK;
import Entidades.EvaluacionCredito;
import Entidades.SolicitudCredito;
import FORMS.PANELS.LISTA_SOLICITUDES_PNL;
import UTILIDADES.monto;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author DFUENTES
 */
public class RESOLUCION_FORM extends javax.swing.JFrame {
    
    private SolicitudCredito solicitud;
    private Creditos credito;
    private CreditosJpaController cjc = new CreditosJpaController();
    private SolicitudCreditoJpaController scjc = new SolicitudCreditoJpaController();
    private LISTA_SOLICITUDES_PNL listasolicitud;
    private int indice;
    
    public RESOLUCION_FORM(SolicitudCredito solicitud,LISTA_SOLICITUDES_PNL lista) {
        
        initComponents();
        this.setLocationRelativeTo(null);
        this.solicitud = solicitud;
        this.listasolicitud = lista;
        this.indice = lista.tblSolicitudes.getSelectedRow();

        cargarSolicitud(this.solicitud);
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
        txtIdsolicitud = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        fechinicio = new com.toedter.calendar.JDateChooser();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        fechvencimiento = new com.toedter.calendar.JDateChooser();
        jLabel28 = new javax.swing.JLabel();
        fechprimerpago = new com.toedter.calendar.JDateChooser();
        btnguardar = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        fechevaluacion = new com.toedter.calendar.JDateChooser();
        cmbresolucion = new javax.swing.JComboBox<>();
        jLabel32 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        txtmontoaprobado = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        txtdeducciones = new javax.swing.JTextField();

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
        jLabel1.setText("RESOLUCION DEL COMITE");

        javax.swing.GroupLayout encabezadoLayout = new javax.swing.GroupLayout(encabezado);
        encabezado.setLayout(encabezadoLayout);
        encabezadoLayout.setHorizontalGroup(
            encabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, encabezadoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(383, 383, 383)
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
        jLabel3.setText("RESOLUCION DEL COMITE");

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

        txtmorad.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        txtmorad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtmoradKeyTyped(evt);
            }
        });

        txtinteresesd.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        txtinteresesd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtinteresesdKeyTyped(evt);
            }
        });

        txtcapitald.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        txtcapitald.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcapitaldKeyTyped(evt);
            }
        });

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
        jLabel12.setText("DETALLE DE MONTOS A PAGAR");

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

        fechsolicitud.setBackground(new java.awt.Color(240, 236, 236));

        jLabel6.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Solicitud:");

        txtIdsolicitud.setEditable(false);
        txtIdsolicitud.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N

        jLabel26.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(51, 51, 51));
        jLabel26.setText("DESEMBOLSO:");

        jLabel15.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(51, 51, 51));
        jLabel15.setText("Fecha de Resolucion:");

        jLabel16.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(51, 51, 51));
        jLabel16.setText("Fecha de Vencimiento:");

        jLabel28.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(51, 51, 51));
        jLabel28.setText("Fecha Primer Pago:");

        btnguardar.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        btnguardar.setText("GUARDAR");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(51, 51, 51));
        jLabel29.setText("Fecha de Evaluacion:");

        fechevaluacion.setBackground(new java.awt.Color(240, 236, 236));

        cmbresolucion.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        cmbresolucion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<SELECCIONAR>", "APROBADO", "DENEGADO" }));

        jLabel32.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(51, 51, 51));
        jLabel32.setText("Resolución:");

        jLabel30.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(51, 51, 51));
        jLabel30.setText("MONTO APROBADO:");

        txtmontoaprobado.setEditable(false);
        txtmontoaprobado.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N

        jLabel31.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(51, 51, 51));
        jLabel31.setText("DEDUCCIONES:");

        txtdeducciones.setEditable(false);
        txtdeducciones.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N

        javax.swing.GroupLayout contenidoLayout = new javax.swing.GroupLayout(contenido);
        contenido.setLayout(contenidoLayout);
        contenidoLayout.setHorizontalGroup(
            contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenidoLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contenidoLayout.createSequentialGroup()
                        .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(contenidoLayout.createSequentialGroup()
                                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(contenidoLayout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel20)
                                            .addComponent(jLabel18)
                                            .addComponent(jLabel21)))
                                    .addComponent(chkAsesoria)
                                    .addComponent(chkcuotafinal))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtAsesoria, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                                    .addComponent(txtcapitald)
                                    .addComponent(txtinteresesd)
                                    .addComponent(txtmorad)
                                    .addComponent(txtcuotafinal)))
                            .addGroup(contenidoLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbtipocredito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2))
                        .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(contenidoLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 28, Short.MAX_VALUE)
                                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(contenidoLayout.createSequentialGroup()
                                        .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel14)
                                            .addComponent(jLabel17)
                                            .addComponent(jLabel19))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtIvaCuota, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                                            .addComponent(txtInteresCuota, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                                            .addComponent(txtcuota)))
                                    .addComponent(jLabel10))
                                .addGap(50, 50, 50)
                                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(contenidoLayout.createSequentialGroup()
                                        .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel23)
                                            .addComponent(jLabel24)
                                            .addComponent(jLabel25))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(contenidoLayout.createSequentialGroup()
                                                .addComponent(txtTotalPago, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel26)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtmontorecibir, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(contenidoLayout.createSequentialGroup()
                                                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtTotalIva, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtTotalIntereses, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(34, 34, 34)
                                                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addGroup(contenidoLayout.createSequentialGroup()
                                                        .addComponent(jLabel30)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(txtmontoaprobado, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(contenidoLayout.createSequentialGroup()
                                                        .addComponent(jLabel31)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(txtdeducciones, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                    .addComponent(jLabel12))
                                .addGap(67, 67, 67))
                            .addGroup(contenidoLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                                .addComponent(cmbformapagos, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(30, Short.MAX_VALUE))))
                    .addGroup(contenidoLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(686, 686, 686))))
            .addGroup(contenidoLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDui, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtIdsolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(contenidoLayout.createSequentialGroup()
                        .addComponent(fechsolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fechevaluacion, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 49, Short.MAX_VALUE))
            .addGroup(contenidoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1)
                    .addComponent(jSeparator2))
                .addContainerGap())
            .addGroup(contenidoLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contenidoLayout.createSequentialGroup()
                        .addComponent(jLabel32)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbresolucion, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(contenidoLayout.createSequentialGroup()
                        .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(contenidoLayout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fechinicio, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel28)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fechprimerpago, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fechvencimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        contenidoLayout.setVerticalGroup(
            contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenidoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel5)
                    .addComponent(txtDui, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtIdsolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel4)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fechsolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27)
                    .addComponent(fechevaluacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(cmbformapagos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(cmbplazos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtmonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel8)
                    .addComponent(cmbtipocredito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(btnCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel10)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtcuota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(txtAsesoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkAsesoria, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addComponent(txtTotalIntereses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtmontoaprobado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contenidoLayout.createSequentialGroup()
                        .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel17)
                                .addComponent(txtInteresCuota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel24)
                                .addComponent(txtTotalIva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                .addComponent(txtdeducciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel31)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(contenidoLayout.createSequentialGroup()
                                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel19)
                                    .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtIvaCuota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel25)
                                        .addComponent(txtTotalPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(jLabel20)
                                    .addComponent(txtinteresesd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(jLabel21)
                                    .addComponent(txtmorad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                .addComponent(jLabel26)
                                .addComponent(txtmontorecibir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(contenidoLayout.createSequentialGroup()
                        .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(chkcuotafinal, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtcuotafinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel18)
                            .addComponent(txtcapitald, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel28)
                    .addComponent(jLabel15)
                    .addComponent(fechinicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fechprimerpago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(fechvencimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(cmbresolucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
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
            monto monto1 = new monto(txtmonto.getText(),cmbplazos.getSelectedIndex(),cmbformapagos.getSelectedIndex(), solicitud.getTasaInteres()); 
            obtenerdetallemonto(monto1);          
        }
        

    }//GEN-LAST:event_btnCalcularActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        boolean valido = true;
        if(validarCampos()){
            if(cmbresolucion.getSelectedIndex()==1){
                llenarCredito();
                try {
                    solicitud.setEstado((short)4);
                    scjc.edit(solicitud);
                    cjc.create(credito);
                    
                } catch (Exception ex) {
                    valido=false;
                    Logger.getLogger(RESOLUCION_FORM.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                solicitud.setEstado((short)5);
                try {
                    scjc.edit(solicitud);
                }catch (Exception ex){
                    valido=false;
                    Logger.getLogger(RESOLUCION_FORM.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if(valido){
                listasolicitud.cargarModelo();
                listasolicitud.tblSolicitudes.clearSelection();
                if(solicitud.getEstado()==4){
                    listasolicitud.tblSolicitudes.setRowSelectionInterval(indice, indice);
                    listasolicitud.cargarsolicitud(indice);
                }else{
                    listasolicitud.limpiarcampos();
                }
                this.dispose();
            }else{ JOptionPane.showMessageDialog(null,"Ocurrio un error al conectarse a la base de datos");}
        
        }else{JOptionPane.showMessageDialog(null,"Hace falta especificar campos necesarios.");}
        
    }//GEN-LAST:event_btnguardarActionPerformed

    private void txtcapitaldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcapitaldKeyTyped
        char caracter= evt.getKeyChar();
        char punto = '.';
        if((!Character.isDigit(caracter)) && (caracter!=punto)) evt.consume();
    }//GEN-LAST:event_txtcapitaldKeyTyped

    private void txtinteresesdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtinteresesdKeyTyped
        char caracter= evt.getKeyChar();
        char punto = '.';
        if((!Character.isDigit(caracter)) && (caracter!=punto)) evt.consume();
    }//GEN-LAST:event_txtinteresesdKeyTyped

    private void txtmoradKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtmoradKeyTyped
        char caracter= evt.getKeyChar();
        char punto = '.';
        if((!Character.isDigit(caracter)) && (caracter!=punto)) evt.consume();
    }//GEN-LAST:event_txtmoradKeyTyped

    public void cargarSolicitud(SolicitudCredito solicitud){
        
        txtDui.setText(solicitud.getDatosPersonales().getDui());
        txtNombre.setText(solicitud.getDatosPersonales().getNombre());
        txtIdsolicitud.setText(String.valueOf(solicitud.getSolicitudCreditoPK().getIdSolicitudCredito()));
        fechsolicitud.setDate(solicitud.getFechaSolicitud());
        if(solicitud.getEvaluacionCredito().getFechaEvaluacion() != null){
        fechevaluacion.setDate(solicitud.getEvaluacionCredito().getFechaEvaluacion());}
        cargarEvaluacion(solicitud.getEvaluacionCredito());
    }
   
    public void cargarEvaluacion(EvaluacionCredito evaluacion){     
            cmbtipocredito.setSelectedIndex(solicitud.getTipoCredito());
            txtmonto.setText(String.valueOf(evaluacion.getMonto())); 
            cmbplazos.setSelectedIndex(evaluacion.getPlazo());
            cmbformapagos.setSelectedIndex(evaluacion.getFormaPago());  
    }
    
    public void obtenerdetallemonto(monto monto){
        
        txtmontoaprobado.setText(txtmonto.getText());
        txtTotalIntereses.setText(monto.getTotalIntereses());
        txtTotalIva.setText(monto.getTotalIva());
        txtcuota.setText(monto.getCuota());
        txtInteresCuota.setText(monto.valorXCuota(monto.getTotalIntereses()));
        txtIvaCuota.setText(monto.valorXCuota(monto.getTotalIva()));
        
        if(chkAsesoria.isSelected()){txtAsesoria.setText(monto.getAsesoria());}
        if(chkcuotafinal.isSelected()){txtcuotafinal.setText(monto.getCuota());}
        
        monto.settotalDeducciones(chkAsesoria.isSelected(),chkcuotafinal.isSelected(),txtinteresesd.getText(),txtcapitald.getText(),txtmorad.getText());
        txtdeducciones.setText(monto.getTotalDeducciones());
        txtmontorecibir.setText(monto.getMontoRecibir());
        txtTotalPago.setText(monto.getTotalPago());     
        
    }
    
    public boolean validarCampos(){
        boolean valido = true;
        if(txtmonto.getText().trim().isEmpty() || cmbplazos.getSelectedIndex()==0 || cmbformapagos.getSelectedIndex()==0 ||
           fechinicio.getDate() == null || fechprimerpago.getDate() == null || fechvencimiento.getDate() == null ||
           cmbresolucion.getSelectedIndex() ==0){ valido = false;}
        return valido;
    }
    
    public void llenarCredito(){
    
        credito = new Creditos();
        CreditosPK pk = new CreditosPK();
        pk.setDui(solicitud.getSolicitudCreditoPK().getDui());
        pk.setIdSolicitudCredito(solicitud.getSolicitudCreditoPK().getIdSolicitudCredito());
        credito.setCreditosPK(pk);
        credito.setSolicitudCredito(solicitud);
        
        credito.setFormaPago((short)cmbformapagos.getSelectedIndex());
        credito.setMonto(Double.parseDouble(txtmonto.getText()));
        credito.setPlazo((short)cmbplazos.getSelectedIndex());
        credito.setFechaInicio(fechinicio.getDate());
        credito.setFechaPrimerPago(fechprimerpago.getDate());
        credito.setFechaVencimiento(fechvencimiento.getDate());
        
        monto monto = new monto(txtmonto.getText(),cmbplazos.getSelectedIndex(),cmbformapagos.getSelectedIndex(), solicitud.getTasaInteres());
        credito.setCuota(Double.parseDouble(monto.getCuota()));
        if(chkAsesoria.isSelected()){credito.setAsesoria(Double.parseDouble(monto.getAsesoria()));}
        if(chkcuotafinal.isSelected()){credito.setCuotaFinal(Double.parseDouble(monto.getCuota()));}
        credito.setDescuentoCf(chkcuotafinal.isSelected());
        credito.setCuotasPorPagar(monto.numeroCuotas());
        credito.setCuotasPagadas(0);
        credito.setInteresPagados(0.0);
        credito.setIvaPagado(0.0);
        credito.setSaldoPagado(0.0);
        credito.setMoraPagada(0.0);
       
       
        
        credito.setEstado((short)1); 
          
    }
    
    
    
    
    
    
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgroup;
    private javax.swing.JButton btnCalcular;
    private javax.swing.JButton btnguardar;
    private javax.swing.JCheckBox chkAsesoria;
    private javax.swing.JCheckBox chkcuotafinal;
    private javax.swing.JComboBox<String> cmbformapagos;
    private javax.swing.JComboBox<String> cmbplazos;
    private javax.swing.JComboBox<String> cmbresolucion;
    private javax.swing.JComboBox<String> cmbtipocredito;
    private javax.swing.JPanel contenido;
    private javax.swing.JPanel encabezado;
    private com.toedter.calendar.JDateChooser fechevaluacion;
    private com.toedter.calendar.JDateChooser fechinicio;
    private com.toedter.calendar.JDateChooser fechprimerpago;
    private com.toedter.calendar.JDateChooser fechsolicitud;
    private com.toedter.calendar.JDateChooser fechvencimiento;
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
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField txtAsesoria;
    private javax.swing.JTextField txtDui;
    private javax.swing.JTextField txtIdsolicitud;
    private javax.swing.JTextField txtInteresCuota;
    private javax.swing.JTextField txtIvaCuota;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTotalIntereses;
    private javax.swing.JTextField txtTotalIva;
    private javax.swing.JTextField txtTotalPago;
    private javax.swing.JTextField txtcapitald;
    private javax.swing.JTextField txtcuota;
    private javax.swing.JTextField txtcuotafinal;
    private javax.swing.JTextField txtdeducciones;
    private javax.swing.JTextField txtinteresesd;
    private javax.swing.JTextField txtmonto;
    private javax.swing.JTextField txtmontoaprobado;
    private javax.swing.JTextField txtmontorecibir;
    private javax.swing.JTextField txtmorad;
    // End of variables declaration//GEN-END:variables
}
