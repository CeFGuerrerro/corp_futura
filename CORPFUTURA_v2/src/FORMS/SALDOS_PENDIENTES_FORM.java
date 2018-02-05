
package FORMS;


import CONTROLADORES.CreditosJpaController;
import CONTROLADORES.MoraJpaController;
import Entidades.Creditos;
import Entidades.DatosPersonales;
import Entidades.SolicitudCredito;
import MODELOSTBL.modeloCreditoxCliente;
import UTILIDADES.fechas;
import UTILIDADES.monto;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author DFUENTES
 */
public class SALDOS_PENDIENTES_FORM extends javax.swing.JFrame {

    public DatosPersonales datospersonales; 
    public int tipocredito;
    public Creditos credito;
    
    public modeloCreditoxCliente modelo = new modeloCreditoxCliente();
    public CreditosJpaController cjc = new CreditosJpaController();
    public MoraJpaController mjc = new MoraJpaController();
    public NUEVA_SOLICITUD_FORM form;
  
    public double total;
    public double totalIntereses;
    public double totalIva;
    
    private final String cadena = "-Intereses por pagar\n-Iva por pagar\n-Intereses vencidos\n-Mora vencida\n-Capital pendiente\n-TOTAL";
    
    public Date fecha;
    public int cuotasaldia;
    
    
    public SALDOS_PENDIENTES_FORM(DatosPersonales datospersonales1, int tipocredito1, NUEVA_SOLICITUD_FORM form1) {
        
        initComponents();
        this.setLocationRelativeTo(null);
        
        datospersonales = datospersonales1;
        tipocredito = tipocredito1;
        form = form1;
        cargarModelo();
        fecha = form.fechasistema;
        
         
    }
    
    public void cargarModelo(){
   
       for(SolicitudCredito solicitud: datospersonales.getSolicitudCreditoList()){
           if(solicitud.getCreditos()!=null){
            if(solicitud.getCreditos().getEstado()==2){modelo.agregarCredito(solicitud.getCreditos());}
           }
       }
       tblCreditos.clearSelection();
       tblCreditos.updateUI();
    }
    
    public void cargarTotalesCredito(int indice){
    
        credito = modelo.obtenerCredito(indice);
        
        if(fechas.verificarPrimerPago(credito.getFechaPrimerPago(), fecha)){
            cuotasaldia = fechas.numerodepagos(credito.getFormaPago(),credito.getFechaPrimerPago(), fecha);
         }else{cuotasaldia = 0;}
        
        double porcentaje = (cjc.obtenerTotalPagado(credito)/cjc.obtenerTotalAPagar(credito))*100;
        porcentaje = monto.redondear(porcentaje, 2);
                
        txtTotalPago.setText(String.valueOf(cjc.obtenerTotalAPagar(credito)));
        txtTotalPagado.setText(String.valueOf(cjc.obtenerTotalPagado(credito)));
        txtporcentajepago.setText(String.valueOf(porcentaje));
        
        txtTotalIntereses.setText(String.valueOf(credito.getTotalIntereses()));
        txtTotalIva.setText(String.valueOf(credito.getTotalIva()));
        txtTotalCapital.setText(String.valueOf(credito.getMonto()));
        txtNumeroCuotas.setText(String.valueOf(credito.getCuotasPorPagar()));
        
        txtTotalInteresesPagados.setText(String.valueOf(credito.getInteresPagados()));
        txtTotalIvaPagado.setText(String.valueOf(credito.getIvaPagado()));
        txtTotalCapitalPagado.setText(String.valueOf(credito.getSaldoPagado()));
        txtCuotasPagadas.setText(String.valueOf(credito.getCuotasPagadas()));
        
        double capitalpendiente = monto.redondear((credito.getMonto()-credito.getSaldoPagado()), 2);
        totalIntereses = monto.redondear(credito.getTotalIntereses()-credito.getInteresPagados(), 2);
        totalIva = monto.redondear(credito.getTotalIva()-credito.getIvaPagado(), 2);
              
        txtivapendiente.setText(String.valueOf(totalIva));
        txtInteresespendientes.setText(String.valueOf(totalIntereses));
        txtCapitalPendiente.setText(String.valueOf(capitalpendiente));
     
        double intvencidos = cjc.interesesVencidos(credito,cuotasaldia);
        intvencidos = intvencidos + cjc.ivaVencidos(credito, cuotasaldia);
        intvencidos = monto.redondear(intvencidos, 2);
        txtInteresesVencidos.setText(String.valueOf(intvencidos));
        txtMoraVencida.setText(String.valueOf(mjc.getMoraPendiente(credito)));

        total = capitalpendiente+intvencidos+mjc.getMoraPendiente(credito);
        total = monto.redondear(total, 2);
        txtTotal.setText(String.valueOf(total));
        
        
    }
    
    public boolean guardarTotalesPendientes(){
    
        boolean valoresValidos = true;
        boolean cargar =true;
        
        if(monto.validarDouble(txtCapitalPendiente.getText())){form.capitalRef=txtCapitalPendiente.getText();}else{valoresValidos=false;}
        if(monto.validarDouble(txtInteresesVencidos.getText())){ form.interesRef=txtInteresesVencidos.getText();}else{valoresValidos=false;}
        if(monto.validarDouble(txtMoraVencida.getText())){form.moraRef=txtMoraVencida.getText();}else{valoresValidos=false;}
        if(monto.validarDouble(txtInteresespendientes.getText())){form.interesesGC= txtInteresespendientes.getText();}else{valoresValidos=false;}
        if(monto.validarDouble(txtivapendiente.getText())){form.ivaGC = txtivapendiente.getText();}else{valoresValidos=false;}
        if(!monto.validarDouble(txtTotal.getText())){valoresValidos=false;}
        
        if(!chkSinCreditos.isSelected()){
            if(credito!=null){
                if(valoresValidos == true){
                        if(tipocredito==3){cargarGestionArreglo();}
                        else if(tipocredito==4){cargarRefinanciamiento();}
                         form.idCreditoACambiar=credito.getCreditosPK().getIdSolicitudCredito();
                         form.tasa = credito.getSolicitudCredito().getTasaInteres();
                }else{JOptionPane.showMessageDialog(this, "Es necesario especificar de forma correcta el valor de los campos:\n"+cadena); cargar =false;}
            }else{JOptionPane.showMessageDialog(this, "Es necesario especificar el Credito a Refinanciar o reestructurar."); cargar = false; }      
        }else{
            if(valoresValidos == true){
                        if(tipocredito==3){cargarGestionArreglo();}
                        else if(tipocredito==4){cargarRefinanciamiento();}
                        form.sinCreditos=true;
                        form.idCreditoACambiar=-1;
            }else{JOptionPane.showMessageDialog(this, "Es necesario especificar de forma correcta el valor de los campos:\n"+cadena); cargar = false;}
        }
        return cargar;
    }
    
    public void cargarRefinanciamiento(){
    
         form.txtcapitald.setText(txtCapitalPendiente.getText());
         form.txtinteresesd.setText(txtInteresesVencidos.getText());
         form.txtmorad.setText(txtMoraVencida.getText());
    }
    
    public void cargarGestionArreglo(){
    
         form.txtmonto.setText(txtTotal.getText());
         form.txtTotalIntereses.setText(txtInteresespendientes.getText()); 
         form.txtTotalIva.setText(txtivapendiente.getText()); 
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgroup = new javax.swing.ButtonGroup();
        encabezado = new javax.swing.JPanel();
        hvCerrar = new Label.HoverIcon();
        jLabel1 = new javax.swing.JLabel();
        contenido = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        txtTotalPago = new javax.swing.JTextField();
        txtTotalIva = new javax.swing.JTextField();
        txtTotalIntereses = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCreditos = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        txtporcentajepago = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        txtTotalPagado = new javax.swing.JTextField();
        txtTotalCapital = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        txtNumeroCuotas = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        txtTotalInteresesPagados = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        txtTotalIvaPagado = new javax.swing.JTextField();
        txtTotalCapitalPagado = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        txtCuotasPagadas = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        txtInteresesVencidos = new javax.swing.JTextField();
        txtCapitalPendiente = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        txtMoraVencida = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        jLabel34 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        txtivapendiente = new javax.swing.JTextField();
        txtInteresespendientes = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        chkSinCreditos = new javax.swing.JCheckBox();

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
        jLabel1.setText("CREDITOS ACTIVOS");

        javax.swing.GroupLayout encabezadoLayout = new javax.swing.GroupLayout(encabezado);
        encabezado.setLayout(encabezadoLayout);
        encabezadoLayout.setHorizontalGroup(
            encabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, encabezadoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(358, 358, 358)
                .addComponent(hvCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        encabezadoLayout.setVerticalGroup(
            encabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(encabezadoLayout.createSequentialGroup()
                .addGroup(encabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(hvCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        hvCerrar.setImages("/IMAGES/ICONS/cerrarSel2.png","/IMAGES/ICONS/cerrarDes2.png");

        contenido.setBackground(new java.awt.Color(240, 236, 236));
        contenido.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(45, 74, 103), 2));

        jLabel3.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("TOTALES A PAGAR");

        jLabel23.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(51, 51, 51));
        jLabel23.setText("Intereses:");

        jLabel24.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(51, 51, 51));
        jLabel24.setText("IVA:");

        jLabel25.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(51, 51, 51));
        jLabel25.setText("Total a pagar:");

        txtTotalPago.setEditable(false);
        txtTotalPago.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N

        txtTotalIva.setEditable(false);
        txtTotalIva.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N

        txtTotalIntereses.setEditable(false);
        txtTotalIntereses.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("CREDITOS");

        tblCreditos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tblCreditos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblCreditos.setRowHeight(30);
        tblCreditos.setSelectionBackground(new java.awt.Color(204, 255, 204));
        tblCreditos.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(tblCreditos);
        tblCreditos.setModel(modelo);
        DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
        leftRenderer.setHorizontalAlignment(DefaultTableCellRenderer.LEFT);

        tblCreditos.getColumn("Crédito").setCellRenderer( leftRenderer );
        tblCreditos.getColumn("Tipo").setCellRenderer( leftRenderer );
        tblCreditos.getColumn("Monto Aprobado").setCellRenderer( leftRenderer );
        tblCreditos.getColumn("Tasa Interes").setCellRenderer( leftRenderer );
        tblCreditos.getColumn("Plazo(Meses)").setCellRenderer( leftRenderer );
        tblCreditos.getColumn("Forma Pago").setCellRenderer( leftRenderer );
        tblCreditos.getColumnModel().getColumn(0).setPreferredWidth(25);
        tblCreditos.getColumnModel().getColumn(1).setPreferredWidth(150);

        tblCreditos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                cargarTotalesCredito(tblCreditos.getSelectedRow());
            }
        });

        jLabel15.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(51, 51, 51));
        jLabel15.setText("PROGRESO DEL CREDITO");

        txtporcentajepago.setEditable(false);
        txtporcentajepago.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N

        jLabel16.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(51, 51, 51));
        jLabel16.setText("%");

        jLabel28.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(51, 51, 51));
        jLabel28.setText("Total Pagado:");

        txtTotalPagado.setEditable(false);
        txtTotalPagado.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N

        txtTotalCapital.setEditable(false);
        txtTotalCapital.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N

        jLabel26.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(51, 51, 51));
        jLabel26.setText("Capital:");

        jLabel27.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(51, 51, 51));
        jLabel27.setText("Cuotas:");

        txtNumeroCuotas.setEditable(false);
        txtNumeroCuotas.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("TOTALES PAGADOS");

        jLabel29.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(51, 51, 51));
        jLabel29.setText("Intereses:");

        txtTotalInteresesPagados.setEditable(false);
        txtTotalInteresesPagados.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N

        jLabel30.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(51, 51, 51));
        jLabel30.setText("IVA:");

        txtTotalIvaPagado.setEditable(false);
        txtTotalIvaPagado.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N

        txtTotalCapitalPagado.setEditable(false);
        txtTotalCapitalPagado.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N

        jLabel31.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(51, 51, 51));
        jLabel31.setText("Capital:");

        jLabel32.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(51, 51, 51));
        jLabel32.setText("Cuotas:");

        txtCuotasPagadas.setEditable(false);
        txtCuotasPagadas.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N

        jLabel33.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(51, 51, 51));
        jLabel33.setText("Intereses + IVA vencidos:");

        txtInteresesVencidos.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N

        txtCapitalPendiente.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N

        jLabel35.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(51, 51, 51));
        jLabel35.setText("Capital pendiente:");

        jLabel36.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(51, 51, 51));
        jLabel36.setText("Mora pendiente:");

        txtMoraVencida.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N

        jLabel37.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(51, 51, 51));
        jLabel37.setText("TOTAL:");

        txtTotal.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N

        btnGuardar.setText("GUARDAR");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jLabel34.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(51, 51, 51));
        jLabel34.setText("Intereses por pagar:");

        jLabel38.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(51, 51, 51));
        jLabel38.setText("IVA por pagar:");

        txtivapendiente.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N

        txtInteresespendientes.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        chkSinCreditos.setBackground(new java.awt.Color(240, 236, 236));
        chkSinCreditos.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        chkSinCreditos.setForeground(new java.awt.Color(51, 51, 51));
        chkSinCreditos.setText("Crédito no registrado");

        javax.swing.GroupLayout contenidoLayout = new javax.swing.GroupLayout(contenido);
        contenido.setLayout(contenidoLayout);
        contenidoLayout.setHorizontalGroup(
            contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenidoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1)
                .addContainerGap())
            .addGroup(contenidoLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contenidoLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addGap(18, 18, 18)
                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtporcentajepago, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, contenidoLayout.createSequentialGroup()
                            .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(contenidoLayout.createSequentialGroup()
                                    .addComponent(jLabel28)
                                    .addGap(3, 3, 3))
                                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(contenidoLayout.createSequentialGroup()
                                        .addComponent(jLabel25)
                                        .addGap(5, 5, 5))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contenidoLayout.createSequentialGroup()
                                        .addComponent(jLabel16)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))))
                            .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtTotalPagado, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtTotalPago, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(38, 38, 38))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contenidoLayout.createSequentialGroup()
                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(contenidoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(contenidoLayout.createSequentialGroup()
                        .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(contenidoLayout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addGroup(contenidoLayout.createSequentialGroup()
                                        .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel24)
                                            .addComponent(jLabel23)
                                            .addComponent(jLabel27)
                                            .addComponent(jLabel26))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtTotalIntereses, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtTotalIva, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtTotalCapital, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtNumeroCuotas, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(chkSinCreditos))
                                .addGap(20, 20, 20)
                                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel31)
                                    .addComponent(jLabel30)
                                    .addComponent(jLabel29)
                                    .addComponent(jLabel32))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCuotasPagadas, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTotalCapitalPagado, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTotalIvaPagado, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTotalInteresesPagados, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(contenidoLayout.createSequentialGroup()
                                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(contenidoLayout.createSequentialGroup()
                                        .addGap(209, 209, 209)
                                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(contenidoLayout.createSequentialGroup()
                                        .addGap(218, 218, 218)
                                        .addComponent(jLabel4)))
                                .addGap(58, 58, 58)))
                        .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(contenidoLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel37))
                            .addGroup(contenidoLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel38)
                                    .addComponent(jLabel34))
                                .addGap(10, 10, 10)
                                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtInteresespendientes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtivapendiente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)
                                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel36, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel35, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel33, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addGap(10, 10, 10)
                        .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtInteresesVencidos, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtMoraVencida, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtCapitalPendiente, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(41, 41, 41))
        );
        contenidoLayout.setVerticalGroup(
            contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenidoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(contenidoLayout.createSequentialGroup()
                        .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel25)
                            .addComponent(txtTotalPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel28)
                            .addComponent(txtTotalPagado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtporcentajepago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))))
                .addGap(28, 28, 28)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chkSinCreditos)
                .addGap(18, 18, 18)
                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(13, 13, 13)
                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel23)
                    .addComponent(txtTotalIntereses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29)
                    .addComponent(txtTotalInteresesPagados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34)
                    .addComponent(txtInteresespendientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33)
                    .addComponent(txtInteresesVencidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel24)
                    .addComponent(txtTotalIva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30)
                    .addComponent(txtTotalIvaPagado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel38)
                    .addComponent(txtivapendiente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36)
                    .addComponent(txtMoraVencida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel26)
                    .addComponent(txtTotalCapital, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31)
                    .addComponent(txtTotalCapitalPagado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35)
                    .addComponent(txtCapitalPendiente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel27)
                    .addComponent(txtNumeroCuotas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCuotasPagadas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32)
                    .addComponent(jLabel37)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardar)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(encabezado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(contenido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(encabezado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(contenido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void hvCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hvCerrarMouseClicked
        this.dispose();
    }//GEN-LAST:event_hvCerrarMouseClicked

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if(guardarTotalesPendientes()){
            form.desCargados=true;
            this.dispose();
        }
        
    }//GEN-LAST:event_btnGuardarActionPerformed

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgroup;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JCheckBox chkSinCreditos;
    private javax.swing.JPanel contenido;
    private javax.swing.JPanel encabezado;
    private Label.HoverIcon hvCerrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
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
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable tblCreditos;
    private javax.swing.JTextField txtCapitalPendiente;
    private javax.swing.JTextField txtCuotasPagadas;
    private javax.swing.JTextField txtInteresesVencidos;
    private javax.swing.JTextField txtInteresespendientes;
    private javax.swing.JTextField txtMoraVencida;
    private javax.swing.JTextField txtNumeroCuotas;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtTotalCapital;
    private javax.swing.JTextField txtTotalCapitalPagado;
    private javax.swing.JTextField txtTotalIntereses;
    private javax.swing.JTextField txtTotalInteresesPagados;
    private javax.swing.JTextField txtTotalIva;
    private javax.swing.JTextField txtTotalIvaPagado;
    private javax.swing.JTextField txtTotalPagado;
    private javax.swing.JTextField txtTotalPago;
    private javax.swing.JTextField txtivapendiente;
    private javax.swing.JTextField txtporcentajepago;
    // End of variables declaration//GEN-END:variables
}
