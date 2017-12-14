
package FORMS.PANELS;

import CONTROLADORES.CreditosJpaController;
import Entidades.SolicitudCredito;
import FORMS.DETALLE_SOLICITUD_FORM;
import MODELOSTBL.modeloSolicitudes;
import CONTROLADORES.SolicitudCreditoJpaController;
import CONTROLADORES.exceptions.NonexistentEntityException;
import Entidades.Creditos;
import Entidades.DatosPersonales;
import UTILIDADES.archivos;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author DFUENTES
 */
public class LISTA_SOLICITUDES_PNL extends javax.swing.JPanel {

     public modeloSolicitudes modelo = new modeloSolicitudes();
     public SolicitudCreditoJpaController scjc = new SolicitudCreditoJpaController();
     public CreditosJpaController cjc = new CreditosJpaController();
    
    public LISTA_SOLICITUDES_PNL() {
        
        initComponents();
        cargarModelo();
    
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblSolicitudes = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        cmbinfored = new javax.swing.JComboBox<>();
        chkestados = new javax.swing.JCheckBox();
        btnActualizarsolicitud = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        fechavisita = new com.toedter.calendar.JDateChooser();
        chkvisita = new javax.swing.JCheckBox();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtobservaciones = new javax.swing.JTextArea();
        btndenegarsolicitud = new javax.swing.JButton();
        chkdesembolso = new javax.swing.JCheckBox();
        habrir = new Label.HoverIcon();
        habrir1 = new Label.HoverIcon();

        setBackground(new java.awt.Color(240, 236, 236));

        tblSolicitudes.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tblSolicitudes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblSolicitudes.setRowHeight(30);
        tblSolicitudes.setSelectionBackground(new java.awt.Color(204, 255, 204));
        tblSolicitudes.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tblSolicitudes.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblSolicitudes);
        tblSolicitudes.setModel(modelo);

        DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
        leftRenderer.setHorizontalAlignment(DefaultTableCellRenderer.LEFT);
        tblSolicitudes.getColumnModel().getColumn(2).setPreferredWidth(300);
        tblSolicitudes.getColumn("Código").setCellRenderer( leftRenderer );
        tblSolicitudes.getColumn("Monto").setCellRenderer( leftRenderer );

        tblSolicitudes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {

                if(e.getClickCount()==2){
                    DETALLE_SOLICITUD_FORM detalle = new DETALLE_SOLICITUD_FORM(modelo.obtenersolicitud(tblSolicitudes.getSelectedRow()));
                    detalle.setVisible(true);
                }
                cargarsolicitud(tblSolicitudes.getSelectedRow());
            }
        });

        jLabel1.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("SOLICITUDES DE CRÉDITO");

        jLabel22.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(51, 51, 51));
        jLabel22.setText("Evaliación de INFORED:");

        cmbinfored.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        cmbinfored.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<SELECCIONAR>", "CATEGORIA 1", "CATEGORIA 2 ", "CATEGORIA 3", "CATEGORIA 4" }));

        chkestados.setBackground(new java.awt.Color(240, 236, 236));
        chkestados.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        chkestados.setForeground(new java.awt.Color(51, 51, 51));
        chkestados.setText("Estados Financieros ");

        btnActualizarsolicitud.setText("GUARDAR");
        btnActualizarsolicitud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarsolicitudActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(51, 51, 51));
        jLabel24.setText("Fecha de Visita:");

        fechavisita.setBackground(new java.awt.Color(240, 236, 236));

        chkvisita.setBackground(new java.awt.Color(240, 236, 236));
        chkvisita.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        chkvisita.setForeground(new java.awt.Color(51, 51, 51));
        chkvisita.setText("Visita Realizada");

        jLabel25.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(51, 51, 51));
        jLabel25.setText("Observaciones:");

        txtobservaciones.setColumns(20);
        txtobservaciones.setRows(5);
        jScrollPane2.setViewportView(txtobservaciones);

        btndenegarsolicitud.setText("DENEGAR SOLICITUD");
        btndenegarsolicitud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndenegarsolicitudActionPerformed(evt);
            }
        });

        chkdesembolso.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        chkdesembolso.setForeground(new java.awt.Color(51, 51, 51));
        chkdesembolso.setText("Desembolso");
        chkdesembolso.setEnabled(false);

        habrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/ICONS/abrir2.png"))); // NOI18N
        habrir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                habrirMouseClicked(evt);
            }
        });

        habrir1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/ICONS/abrir2.png"))); // NOI18N
        habrir1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                habrir1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1040, Short.MAX_VALUE)
                        .addGap(25, 25, 25))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnActualizarsolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbinfored, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(habrir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fechavisita, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(chkvisita)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(chkestados, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(chkdesembolso))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(habrir1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btndenegarsolicitud))
                        .addGap(182, 182, 182))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel25)
                    .addComponent(habrir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbinfored, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel24)
                            .addComponent(fechavisita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(chkvisita)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(chkestados)
                            .addComponent(habrir1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(chkdesembolso)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnActualizarsolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(128, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btndenegarsolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        habrir.setImages("/IMAGES/ICONS/abrir3.png","/IMAGES/ICONS/abrir2.png");
        habrir1.setImages("/IMAGES/ICONS/abrir3.png","/IMAGES/ICONS/abrir2.png");
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualizarsolicitudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarsolicitudActionPerformed
        boolean valido = true;
        if(tblSolicitudes.getSelectedRow()!= -1){
            int indice = tblSolicitudes.getSelectedRow();
            SolicitudCredito solicitud = modelo.obtenersolicitud(indice);
            
            solicitud.setInfored((short)cmbinfored.getSelectedIndex());
            solicitud.setVisita(chkvisita.isSelected());
            solicitud.setEstadosFinancieros(chkestados.isSelected());
            solicitud.setFechaVisita(fechavisita.getDate());
            solicitud.setObservacion(txtobservaciones.getText());
            if(chkvisita.isSelected()==true  && solicitud.getEstado()<2){solicitud.setEstado((short)2);}           
            if (chkdesembolso.isSelected()){solicitud.setDesembolso(true);}
            
            
            try {
                scjc.edit(solicitud);
            } catch (NonexistentEntityException ex) {
                valido=false;
                Logger.getLogger(LISTA_SOLICITUDES_PNL.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                valido=false;
                Logger.getLogger(LISTA_SOLICITUDES_PNL.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if(solicitud.getDesembolso()==true){
                
                Creditos credito = solicitud.getCreditos();
                credito.setEstado((short)2);
                
                try {
                    cjc.edit(credito);
                } catch (Exception ex) {
                    valido=false;
                    Logger.getLogger(LISTA_SOLICITUDES_PNL.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            
            if(valido){              
                JOptionPane.showMessageDialog(null,"Solicitud Actualizada");
                cargarModelo();
                tblSolicitudes.clearSelection();
                if(!chkdesembolso.isSelected()){
                    tblSolicitudes.setRowSelectionInterval(indice, indice);
                    cargarsolicitud(indice);
                }
                else{
                    limpiarcampos(); 
                }
            }
        
        }
        
    }//GEN-LAST:event_btnActualizarsolicitudActionPerformed

    private void btndenegarsolicitudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndenegarsolicitudActionPerformed
        
        if(tblSolicitudes.getSelectedRow()!= -1){
        
            if(!txtobservaciones.getText().trim().isEmpty() && cmbinfored.getSelectedIndex()!=0){
                int respuesta = JOptionPane.showConfirmDialog(null,"Seguro que desea rechazar la solicitud?");
                if(respuesta==0){
                    SolicitudCredito solicitud = modelo.obtenersolicitud(tblSolicitudes.getSelectedRow());
                    solicitud.setEstado((short)5);
                    try {
                        scjc.edit(solicitud);
                    } catch (Exception ex) {
                        Logger.getLogger(LISTA_SOLICITUDES_PNL.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    cargarModelo();
                    tblSolicitudes.clearSelection();
                    limpiarcampos();
                }
                
            }else{JOptionPane.showMessageDialog(null,"Es necesario ingresar la evaluación de infored\n "
            + "y especificar en las observaciones por que se rechaza la solicitud");}
        
        }
        
    }//GEN-LAST:event_btndenegarsolicitudActionPerformed

    private void habrirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_habrirMouseClicked
        
         if(tblSolicitudes.getSelectedRow()!= -1){
            DatosPersonales datos = modelo.obtenersolicitud(tblSolicitudes.getSelectedRow()).getDatosPersonales();
            JFileChooser fc = new JFileChooser();
            fc.setDialogTitle("SELECCIONE EL REPORTE DE INFORED DEL CLIENTE");
            int result = fc.showSaveDialog(null);

            if(result == JFileChooser.APPROVE_OPTION){
                File file = fc.getSelectedFile();
                try {archivos.copiarArchivo(file, datos.getNombre());} 
                catch (IOException ex) {}   
            }
        }
        
    }//GEN-LAST:event_habrirMouseClicked

    private void habrir1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_habrir1MouseClicked
        
        if(tblSolicitudes.getSelectedRow()!= -1){
            DatosPersonales datos = modelo.obtenersolicitud(tblSolicitudes.getSelectedRow()).getDatosPersonales();
            JFileChooser fc = new JFileChooser();
            fc.setDialogTitle("ABRIR EL DOCUMENTO DE ESTADOS FINANCIEROS");
            fc.setCurrentDirectory(archivos.getRootPath(datos.getNombre()));
            
            int result = fc.showOpenDialog(null);
            if(result == JFileChooser.APPROVE_OPTION){
                File file = fc.getSelectedFile();
                
                if(file.getName().equals("Analisis_de_Credito.xlsx")){
                    System.out.println("entra");
                    archivos.ejecutarDocExcel(datos.getNombre());
                }   
            }
        }
    
    }//GEN-LAST:event_habrir1MouseClicked

    public void cargarModelo(){
        short estado =5;
        modelo.borrartodos();
        scjc = new SolicitudCreditoJpaController();
        List<SolicitudCredito> lista = scjc.getSolicitudEnProceso(estado);
            for(SolicitudCredito solicitud:lista){
                modelo.agregarsolicitud(solicitud); 
            }
        tblSolicitudes.updateUI();
    
    }

    public JTable getTblSolicitudes() {
        return tblSolicitudes;
    }
     
    public void cargarsolicitud(int indice){
        
        SolicitudCredito solicitud = modelo.obtenersolicitud(indice);
        if(solicitud.getInfored()==null){cmbinfored.setSelectedIndex(0);}
        else{cmbinfored.setSelectedIndex(solicitud.getInfored());}
        txtobservaciones.setText(solicitud.getObservacion());
        if(solicitud.getEstadosFinancieros()!=null){chkestados.setSelected(solicitud.getEstadosFinancieros());}else{chkestados.setSelected(false);}
        if(solicitud.getVisita()!=null){chkvisita.setSelected(solicitud.getVisita());}else{chkvisita.setSelected(false);}
        fechavisita.setDate(solicitud.getFechaVisita());
        if(solicitud.getEstado()==4){chkdesembolso.setEnabled(true);}else{chkdesembolso.setEnabled(false);}
    }
    
    public void limpiarcampos(){
        cmbinfored.setSelectedIndex(0);
        chkvisita.setSelected(false);
        fechavisita.setDate(null);
        chkestados.setSelected(false);
        txtobservaciones.setText("");   
        chkdesembolso.setSelected(false);
        chkdesembolso.setEnabled(false);
    }
    
    
   
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizarsolicitud;
    private javax.swing.JButton btndenegarsolicitud;
    private javax.swing.JCheckBox chkdesembolso;
    private javax.swing.JCheckBox chkestados;
    private javax.swing.JCheckBox chkvisita;
    private javax.swing.JComboBox<String> cmbinfored;
    private com.toedter.calendar.JDateChooser fechavisita;
    private Label.HoverIcon habrir;
    private Label.HoverIcon habrir1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTable tblSolicitudes;
    private javax.swing.JTextArea txtobservaciones;
    // End of variables declaration//GEN-END:variables
}
