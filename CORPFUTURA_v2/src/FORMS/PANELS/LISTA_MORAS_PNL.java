
package FORMS.PANELS;

import CONTROLADORES.CreditosJpaController;
import CONTROLADORES.MoraJpaController;
import Entidades.Creditos;
import Entidades.DatosPersonales;
import Entidades.Mora;
import Entidades.MoraPK;
import MODELOSTBL.modeloCreditos;
import MODELOSTBL.modeloMoras;
import UTILIDADES.monto;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableCellRenderer;
import UTILIDADES.fechas;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author DFUENTES
 */
public class LISTA_MORAS_PNL extends javax.swing.JPanel {

    public modeloMoras modelo = new modeloMoras();
    public MoraJpaController mjc = new  MoraJpaController();
    public CreditosJpaController cjc = new  CreditosJpaController();
    
    public List<Creditos> listaCreditos;
    
    public CREDITOS_PNL panel;
    
    
    public LISTA_MORAS_PNL(CREDITOS_PNL panel1) {
        
        initComponents();
        cargarModelo();
        listaCreditos = cjc.getCreditosActivos((short)2);
        panel=panel1;
    
    }
    
    public void cargarModelo(){
   
        short estado =0;
        modelo.borrartodos();
        List<Mora> lista = mjc.getMorasActivas(estado);
            for(Mora mora:lista){
                modelo.agregarMora(mora); 
            }
        tblMoras.clearSelection();
        tblMoras.updateUI();
    
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblMoras = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        calcularMora = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        txtmontopendiente = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        txtcuotaspendientes = new javax.swing.JTextField();

        setBackground(new java.awt.Color(240, 236, 236));

        tblMoras.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tblMoras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblMoras.setRowHeight(30);
        tblMoras.setSelectionBackground(new java.awt.Color(204, 255, 204));
        tblMoras.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tblMoras.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblMoras);
        tblMoras.setModel(modelo);
        DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
        leftRenderer.setHorizontalAlignment(DefaultTableCellRenderer.LEFT);

        tblMoras.getColumnModel().getColumn(1).setPreferredWidth(250);
        tblMoras.getColumnModel().getColumn(0).setPreferredWidth(50);
        tblMoras.getColumn("Crédito").setCellRenderer( leftRenderer );
        tblMoras.getColumn("Cliente").setCellRenderer( leftRenderer );
        tblMoras.getColumn("Monto").setCellRenderer( leftRenderer );
        tblMoras.getColumn("Mora Pendiente").setCellRenderer( leftRenderer );
        tblMoras.getColumn("Mora Pagada").setCellRenderer( leftRenderer );
        tblMoras.getColumn("Mora Total").setCellRenderer( leftRenderer );

        tblMoras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {

            }
        });

        jLabel1.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("MORA DE  CRÉDITOS ACTIVOS");

        calcularMora.setText("Calcular Mora ");
        calcularMora.setMaximumSize(new java.awt.Dimension(100, 23));
        calcularMora.setPreferredSize(new java.awt.Dimension(100, 30));
        calcularMora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calcularMoraActionPerformed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(51, 51, 51));
        jLabel25.setText("MONTO PENDIENTE");

        txtmontopendiente.setEditable(false);
        txtmontopendiente.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N

        jLabel26.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(51, 51, 51));
        jLabel26.setText("Nº  CUOTAS PENDIENTES");

        txtcuotaspendientes.setEditable(false);
        txtcuotaspendientes.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1040, Short.MAX_VALUE)
                        .addGap(25, 25, 25))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(calcularMora, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel25)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtmontopendiente, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel26)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtcuotaspendientes, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(calcularMora, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel25)
                    .addComponent(txtmontopendiente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtcuotaspendientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26))
                .addContainerGap(248, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void calcularMoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calcularMoraActionPerformed
      
        for(Creditos credito: listaCreditos){
            
            if(fechas.verificarPrimerPago(credito.getFechaPrimerPago(), panel.fechasistema.getDate())){
                
               int cuotas = fechas.numerodepagos(credito.getFormaPago(),credito.getFechaPrimerPago(), panel.fechasistema.getDate());
                
               if(credito.getDescuentoCf()){
                   if(!fechas.esLunes_miercoles(panel.fechasistema.getDate())){
                       
                        int cuotasPagadas = cjc.getCuotasPagadascf(credito);
                        if(cuotasPagadas<cuotas){
                           
                            Mora mora = credito.getSolicitudCredito().getMora();
                            if(mora==null){
                        
                                mora = obtenerMoraconDatos(credito,cuotas);                        
                                try { mjc.create(mora);} catch (Exception ex) 
                                {Logger.getLogger(LISTA_MORAS_PNL.class.getName()).log(Level.SEVERE, null, ex);}
                            
                            }else{
                                
                                if(mora.getEstado()==0){
                                    
                                    if(mora.getUltimaCuotaEnMora()<cuotas){

                                      mora = nuevoTotalMora(mora,cuotas,credito);
                                      try { mjc.edit(mora);} catch (Exception ex) 
                                      {Logger.getLogger(LISTA_MORAS_PNL.class.getName()).log(Level.SEVERE, null, ex);}
                                        
                                    }
                                       
                                }else{
                                
                                    mora = actualizarTotalMora(mora,cuotas,credito);
                                    try { mjc.edit(mora);} catch (Exception ex) 
                                    {Logger.getLogger(LISTA_MORAS_PNL.class.getName()).log(Level.SEVERE, null, ex);}
                                    
                                }
                                       
                            }
                           
                        }
                       
                   }
               }else{
                   if(credito.getSolicitudCredito().getTipoCredito()!=5){
                        
                        if(!fechas.esLunes(panel.fechasistema.getDate())){
                           
                            if(credito.getCuotasPagadas()<cuotas){
                      
                                Mora mora = credito.getSolicitudCredito().getMora();
                                if(mora==null){
                        
                                    mora = obtenerMoraconDatos(credito, cuotas); 
                                    try { mjc.create(mora);} catch (Exception ex) 
                                    {Logger.getLogger(LISTA_MORAS_PNL.class.getName()).log(Level.SEVERE, null, ex);}
                            
                                }else{
                               
                                    if(mora.getEstado()==0){
                                    
                                        if(mora.getUltimaCuotaEnMora()<cuotas){
                                        
                                            mora = nuevoTotalMora(mora,cuotas,credito);                                  
                                            try { mjc.edit(mora);} catch (Exception ex) 
                                            {Logger.getLogger(LISTA_MORAS_PNL.class.getName()).log(Level.SEVERE, null, ex);}
                                    
                                        }
                                    
                                    }else{
                                
                                        mora = actualizarTotalMora(mora,cuotas,credito);
                                        try { mjc.edit(mora);} catch (Exception ex) 
                                        {Logger.getLogger(LISTA_MORAS_PNL.class.getName()).log(Level.SEVERE, null, ex);}
                                    }
                                   
                                }
                          
                            }
                        
                        }
                        
                   }else{
                    
                        if(credito.getCuotasPagadas()<cuotas){
                      
                                Mora mora = credito.getSolicitudCredito().getMora();
                                if(mora==null){
                        
                                    mora = obtenerMoraconDatos(credito, cuotas); 
                                    try { mjc.create(mora);} catch (Exception ex) 
                                    {Logger.getLogger(LISTA_MORAS_PNL.class.getName()).log(Level.SEVERE, null, ex);}
                            
                                }else{
                                
                                    if(mora.getEstado()==0){

                                            mora = nuevoTotalMoraExpressDias(mora,cuotas,credito);                                  
                                            try { mjc.edit(mora);} catch (Exception ex) 
                                            {Logger.getLogger(LISTA_MORAS_PNL.class.getName()).log(Level.SEVERE, null, ex);}
                                        
                                    }else{
                                            
                                    
                                    }
                                    
                                
                                
                                }
                        }
                  }
               }
                    
            }  
                
        }
    
        cargarModelo();
        listaCreditos = cjc.getCreditosActivos((short)2);
        panel.cp.cargarModelo();
        
        
    }//GEN-LAST:event_calcularMoraActionPerformed

    public Mora obtenerMoraconDatos(Creditos credito,int cuota){
    
        
        Mora mora = new Mora();
        MoraPK morapk = new MoraPK(credito.getCreditosPK().getDui(),credito.getCreditosPK().getIdSolicitudCredito());
        
        mora.setMoraPK(morapk);
        
        mora.setEstado((short)0);
        if(credito.getSolicitudCredito().getTipoCredito()!=5){mora.setMoraTotal(5.65);}
        else{mora.setMoraTotal(11.30);}
        mora.setMoraCancelada(0.0);
        mora.setUltimaCuotaEnMora((short)cuota);
        mora.setCoutasMoraPendiente((short)1);
        mora.setCoutasPendientes((short)1);
        
        mora.setListaCuotasEnMora(listaCuotasMora(mora.getListaCuotasEnMora(),cuota));
        
        mora.setCapitalVencido(cjc.capitalVencido(credito, cuota));
        mora.setInteresVencido(cjc.interesesVencidos(credito, cuota));
        mora.setIvaVencido(cjc.ivaVencidos(credito, cuota));
        
        if(credito.getSolicitudCredito().getTipoCredito()==5){
            mora.setDiasAtrasoXpress((short)1);
            mora.setUltimaFechaMora(panel.fechasistema.getDate());}
        
        mora.setSolicitudCredito(credito.getSolicitudCredito());
        
        
        return mora;
    }
    
    public Mora nuevoTotalMora(Mora mora, int cuotas, Creditos credito){
    
        mora.setUltimaCuotaEnMora((short)cuotas);
        mora.setCoutasMoraPendiente((short)(mora.getCoutasMoraPendiente()+1));
        mora.setCoutasPendientes((short)(mora.getCoutasPendientes()+1));
        mora.setListaCuotasEnMora(listaCuotasMora(mora.getListaCuotasEnMora(),cuotas));
        
        mora.setCapitalVencido(cjc.capitalVencido(credito, cuotas));
        mora.setInteresVencido(cjc.interesesVencidos(credito, cuotas));
        mora.setIvaVencido(cjc.ivaVencidos(credito, cuotas));
        
        mora.setMoraTotal(monto.redondear(mora.getMoraTotal()+5.65,2));
        
        return mora;
        
    }
    
    public Mora nuevoTotalMoraExpressDias(Mora mora, int cuotas, Creditos credito){
        
        Date fechamora = fechas.normalizarFecha(mora.getUltimaFechaMora());
        Date fechaActual = fechas.normalizarFecha(panel.fechasistema.getDate());
        
        if(mora.getUltimaCuotaEnMora()==cuotas){
            
            if(fechamora.before(fechaActual)){ 
                
                mora.setMoraTotal(monto.redondear(mora.getMoraTotal()+1.13,2));
                mora.setUltimaFechaMora(fechaActual);
            }
            
        }else if(cuotas>mora.getUltimaCuotaEnMora()){
        
            mora.setUltimaCuotaEnMora((short)cuotas);
            mora.setCoutasMoraPendiente((short)(mora.getCoutasMoraPendiente()+1));
            mora.setCoutasPendientes((short)(mora.getCoutasPendientes()+1));
            mora.setListaCuotasEnMora(listaCuotasMora(mora.getListaCuotasEnMora(),cuotas));
            
            mora.setCapitalVencido(cjc.capitalVencido(credito, cuotas));
            mora.setInteresVencido(cjc.interesesVencidos(credito, cuotas));
            mora.setIvaVencido(cjc.ivaVencidos(credito, cuotas));
            
            mora.setUltimaFechaMora(fechaActual);
                
        }
        
        return mora;     
    }
    
    public Mora actualizarTotalMora(Mora mora, int cuotas, Creditos credito){
    
        mora.setEstado((short)0);
        mora.setUltimaCuotaEnMora((short)cuotas);
        mora.setCoutasMoraPendiente((short)1);
        mora.setCoutasPendientes((short)1);
        mora.setListaCuotasEnMora(listaCuotasMora(mora.getListaCuotasEnMora(),cuotas));
        
        mora.setCapitalVencido(cjc.capitalVencido(credito, cuotas));
        mora.setInteresVencido(cjc.interesesVencidos(credito, cuotas));
        mora.setIvaVencido(cjc.ivaVencidos(credito, cuotas));
        
        mora.setMoraTotal(monto.redondear(mora.getMoraTotal()+5.65,2));
        
        return mora;
        
    }
    
    public String listaCuotasMora(String lista,int cuota){
       
        if(lista==null){lista="";}
        lista=lista+cuota+"-";
        
        return lista;
    }
    
    
    

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton calcularMora;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tblMoras;
    private javax.swing.JTextField txtcuotaspendientes;
    private javax.swing.JTextField txtmontopendiente;
    // End of variables declaration//GEN-END:variables
}
