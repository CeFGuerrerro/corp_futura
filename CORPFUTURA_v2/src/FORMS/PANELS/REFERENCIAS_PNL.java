
package FORMS.PANELS;

import Entidades.DatosPersonales;
import Entidades.Familiares;
import Entidades.Referencias;
import MODELOSTBL.modeloFamiliares;
import MODELOSTBL.modeloReferencias;
import CONTROLADORES.FamiliaresJpaController;
import CONTROLADORES.ReferenciasJpaController;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author DFUENTES
 */
public class REFERENCIAS_PNL extends javax.swing.JPanel {

    public modeloReferencias modeloreffam  = new modeloReferencias();
    public modeloReferencias modelorefpart = new modeloReferencias();
    public modeloFamiliares  modelofam     = new modeloFamiliares();
    
    public DatosPersonales datospersonales;
    
    public List<Referencias> reffam = new LinkedList();
    public List<Referencias> refpart = new LinkedList();
    public List<Familiares>  familiares = new LinkedList();
    
    public ReferenciasJpaController rjc = new ReferenciasJpaController();
    public FamiliaresJpaController fjc = new FamiliaresJpaController();
    
    public int indexreffam=0;
    public int indexrefpart=0;
 
    
    public REFERENCIAS_PNL() {
        initComponents();
        
        modelofam.nuevaFila();
        modeloreffam.nuevaFila();
        modelorefpart.nuevaFila();
        
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        tblRefPart = new javax.swing.JTable();
        chkrefpart = new javax.swing.JCheckBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblRefFam = new javax.swing.JTable();
        chkreffam = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDatosFam = new javax.swing.JTable();
        chkdatosFam = new javax.swing.JCheckBox();
        jLabel11 = new javax.swing.JLabel();
        lbldui = new javax.swing.JLabel();
        txtdui = new javax.swing.JTextField();
        txtnombre = new javax.swing.JTextField();
        lblnombre = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnGuardar = new javax.swing.JButton();
        hvminus = new Label.HoverIcon();
        hvadd = new Label.HoverIcon();
        hvpasar = new Label.HoverIcon();
        hvminus1 = new Label.HoverIcon();
        hvadd1 = new Label.HoverIcon();
        hvminus2 = new Label.HoverIcon();
        hvadd2 = new Label.HoverIcon();

        setBackground(new java.awt.Color(240, 236, 236));

        tblRefPart.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        tblRefPart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblRefPart.setRowHeight(20);
        tblRefPart.setSelectionBackground(new java.awt.Color(204, 255, 204));
        tblRefPart.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tblRefPart.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblRefPartKeyPressed(evt);
            }
        });
        jScrollPane3.setViewportView(tblRefPart);
        tblRefPart.setModel(modelorefpart);
        tblRefPart.getColumnModel().getColumn(0).setMaxWidth(100);
        tblRefPart.getColumnModel().getColumn(4).setMaxWidth(100);
        tblRefPart.getColumnModel().getColumn(1).setMaxWidth(240);
        tblRefPart.getColumnModel().getColumn(2).setMaxWidth(200);
        tblRefPart.getColumnModel().getColumn(3).setMaxWidth(240);

        chkrefpart.setBackground(new java.awt.Color(240, 236, 236));
        chkrefpart.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        chkrefpart.setForeground(new java.awt.Color(51, 51, 51));
        chkrefpart.setText("REFERENCIAS PARTICULARES");

        tblRefFam.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        tblRefFam.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblRefFam.setRowHeight(20);
        tblRefFam.setSelectionBackground(new java.awt.Color(204, 255, 204));
        tblRefFam.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tblRefFam.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblRefFamKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(tblRefFam);
        tblRefFam.setModel(modeloreffam);
        tblRefFam.getColumnModel().getColumn(0).setMaxWidth(100);
        tblRefFam.getColumnModel().getColumn(4).setMaxWidth(100);
        tblRefFam.getColumnModel().getColumn(1).setMaxWidth(240);
        tblRefFam.getColumnModel().getColumn(2).setMaxWidth(200);
        tblRefFam.getColumnModel().getColumn(3).setMaxWidth(240);

        chkreffam.setBackground(new java.awt.Color(240, 236, 236));
        chkreffam.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        chkreffam.setForeground(new java.awt.Color(51, 51, 51));
        chkreffam.setText("REFERENCIAS FAMILIARES");

        tblDatosFam.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        tblDatosFam.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblDatosFam.setRowHeight(20);
        tblDatosFam.setSelectionBackground(new java.awt.Color(204, 255, 204));
        tblDatosFam.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tblDatosFam.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblDatosFamKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblDatosFam);
        tblDatosFam.setModel(modelofam);
        tblDatosFam.getColumnModel().getColumn(0).setMaxWidth(100);
        tblDatosFam.getColumnModel().getColumn(3).setMaxWidth(100);
        tblDatosFam.getColumnModel().getColumn(1).setMaxWidth(340);
        tblDatosFam.getColumnModel().getColumn(2).setMaxWidth(340);

        chkdatosFam.setBackground(new java.awt.Color(240, 236, 236));
        chkdatosFam.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        chkdatosFam.setForeground(new java.awt.Color(51, 51, 51));
        chkdatosFam.setText("DATOS DE FAMILIARES");

        jLabel11.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("CLIENTE");

        lbldui.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        lbldui.setForeground(new java.awt.Color(51, 51, 51));
        lbldui.setText("DUI:");

        txtdui.setEditable(false);
        txtdui.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N

        txtnombre.setEditable(false);
        txtnombre.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        txtnombre.setSelectionColor(new java.awt.Color(51, 255, 204));

        lblnombre.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        lblnombre.setForeground(new java.awt.Color(51, 51, 51));
        lblnombre.setText("Nombre:");

        btnGuardar.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(51, 51, 51));
        btnGuardar.setText("GUARDAR");
        btnGuardar.setEnabled(false);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        hvminus.setText("hoverIcon1");
        hvminus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hvminusMouseClicked(evt);
            }
        });

        hvadd.setText("hoverIcon1");
        hvadd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hvaddMouseClicked(evt);
            }
        });

        hvpasar.setText("hoverIcon1");
        hvpasar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hvpasarMouseClicked(evt);
            }
        });

        hvminus1.setText("hoverIcon1");
        hvminus1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hvminus1MouseClicked(evt);
            }
        });

        hvadd1.setText("hoverIcon1");
        hvadd1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hvadd1MouseClicked(evt);
            }
        });

        hvminus2.setText("hoverIcon1");
        hvminus2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hvminus2MouseClicked(evt);
            }
        });

        hvadd2.setText("hoverIcon1");
        hvadd2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hvadd2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 1099, Short.MAX_VALUE)
                            .addComponent(jLabel11)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbldui)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtdui, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblnombre)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(chkdatosFam)
                            .addComponent(chkreffam)
                            .addComponent(chkrefpart))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 880, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(hvadd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(hvminus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(hvpasar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(hvminus1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(hvadd1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(hvminus2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(hvadd2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lbldui)
                    .addComponent(txtdui, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblnombre)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(chkdatosFam)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(chkreffam))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hvadd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addComponent(hvminus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(hvpasar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(chkrefpart))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(hvadd1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(hvminus1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(hvadd2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(hvminus2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49))
        );

        hvminus.setImages("/IMAGES/ICONS/minus1.png","/IMAGES/ICONS/minus.png");
        hvadd.setImages("/IMAGES/ICONS/add1.png","/IMAGES/ICONS/add.png");
        hvpasar.setImages("/IMAGES/ICONS/pasar1.png","/IMAGES/ICONS/pasar.png");
        hvminus1.setImages("/IMAGES/ICONS/minus1.png","/IMAGES/ICONS/minus.png");
        hvadd1.setImages("/IMAGES/ICONS/add1.png","/IMAGES/ICONS/add.png");
        hvminus2.setImages("/IMAGES/ICONS/minus1.png","/IMAGES/ICONS/minus.png");
        hvadd2.setImages("/IMAGES/ICONS/add1.png","/IMAGES/ICONS/add.png");
    }// </editor-fold>//GEN-END:initComponents

    private void tblRefPartKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblRefPartKeyPressed

        int columna = tblRefPart.getSelectedColumn();
        int fila= tblRefPart.getSelectedRow();

        if(columna==3 && evt.getKeyCode() == KeyEvent.VK_ENTER){
            modelorefpart.nuevaFila();
            tblRefPart.updateUI();
            tblRefPart.changeSelection(fila, 0, false, false);
        }

    }//GEN-LAST:event_tblRefPartKeyPressed

    private void tblRefFamKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblRefFamKeyPressed

        int columna = tblRefFam.getSelectedColumn();
        int fila= tblRefFam.getSelectedRow();

        if(columna==3 && evt.getKeyCode() == KeyEvent.VK_ENTER){
            modeloreffam.nuevaFila();
            tblRefFam.updateUI();
            tblRefFam.changeSelection(fila, 0, false, false);
        }

    }//GEN-LAST:event_tblRefFamKeyPressed

    private void tblDatosFamKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblDatosFamKeyPressed

        int columna = tblDatosFam.getSelectedColumn();
        int fila= tblDatosFam.getSelectedRow();

        if(columna==3 && evt.getKeyCode() == KeyEvent.VK_ENTER){
            modelofam.nuevaFila();
            tblDatosFam.updateUI();
            tblDatosFam.changeSelection(fila, 0, false, false);
        }

    }//GEN-LAST:event_tblDatosFamKeyPressed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        if (validarmodelos() == false){
            JOptionPane.showMessageDialog(null, "Falta llenar campos obligatorios");
        }else{
            boolean verificacion=true;
            
            familiares = modelofam.llenarLista(datospersonales);
            if(chkdatosFam.isSelected()){
                try{
                    if(datospersonales.getFamiliaresList().isEmpty()){
                        for (Familiares fam : familiares){fjc.create(fam);} 
                    }else{
                        if(compararFamiliares()){
                            for (Familiares fam : familiares){fjc.edit(fam);}
                        }else{
                            fjc.actualizarFamiliares(familiares,datospersonales.getFamiliaresList());
                        }
                    } 
                }catch (Exception ex) {
                    verificacion=false;
                }
            }
            datospersonales.setFamiliaresList(familiares);
            
            reffam = modeloreffam.llenarlista(1, datospersonales, false);
            if(chkreffam.isSelected()){
                try{
                    if(indexreffam==0){
                        for (Referencias ref : reffam){rjc.create(ref);}
                    }else{
                        if(compararreferencias(indexreffam,false)){
                            for (Referencias ref : reffam){rjc.edit(ref);}
                        }else{
                            rjc.actualizarReferencias(reffam,oldListReferencias(false));
                        }
                    }
                    indexreffam=reffam.size();
                }catch (Exception ex) {
                    verificacion=false;
                }
            }
            
            refpart = modelorefpart.llenarlista(6, datospersonales, true);
            if(chkrefpart.isSelected()){ 
                try{
                    if(indexrefpart==0){
                        for (Referencias ref : refpart){rjc.create(ref);}
                    }else{
                        if(compararreferencias(indexrefpart,true)){
                            for (Referencias ref : refpart){rjc.edit(ref);}
                        }else{
                            rjc.actualizarReferencias(refpart,oldListReferencias(true));
                        }
                    }
                    indexrefpart=refpart.size();
                }catch (Exception ex) {
                    verificacion=false;
                }
            }
            datospersonales.setReferenciasList(actualizarRefsDp());
            
            if(verificacion=true){JOptionPane.showMessageDialog(null,"Referencias registradas con éxito.");}
                           
       }

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void hvaddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hvaddMouseClicked
       modelofam.nuevaFila(); tblDatosFam.updateUI();
    }//GEN-LAST:event_hvaddMouseClicked

    private void hvadd1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hvadd1MouseClicked
       modeloreffam.nuevaFila(); tblRefFam.updateUI();
    }//GEN-LAST:event_hvadd1MouseClicked

    private void hvadd2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hvadd2MouseClicked
       modelorefpart.nuevaFila(); tblRefPart.updateUI();
    }//GEN-LAST:event_hvadd2MouseClicked

    private void hvminusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hvminusMouseClicked
        if(tblDatosFam.getSelectedRow()!= -1){         
                modelofam.borraFamiliar(tblDatosFam.getSelectedRow());     
        }
    }//GEN-LAST:event_hvminusMouseClicked

    private void hvminus1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hvminus1MouseClicked
        if(tblRefFam.getSelectedRow()!= -1){
                modeloreffam.borrarReferencia(tblRefFam.getSelectedRow());
        }
    }//GEN-LAST:event_hvminus1MouseClicked

    private void hvminus2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hvminus2MouseClicked
        if(tblRefPart.getSelectedRow()!= -1){
                modelorefpart.borrarReferencia(tblRefPart.getSelectedRow());
        }
    }//GEN-LAST:event_hvminus2MouseClicked

    private void hvpasarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hvpasarMouseClicked
          if(tblDatosFam.getSelectedRow()!=-1){ 
             modeloreffam.agregarReferencia(familiarAReferencia(tblDatosFam.getSelectedRow()));
          }
    }//GEN-LAST:event_hvpasarMouseClicked

    public boolean validarmodelos(){
        
        boolean validacion=true;
        
        if(chkdatosFam.isSelected()){
            if(modelofam.validar()==false){validacion=false;}
        }
        
        if(chkreffam.isSelected()){
            if(modeloreffam.validar()==false){validacion=false;}
        }
        
        if(chkrefpart.isSelected()){
            if(modelorefpart.validar()==false){validacion=false;}
        }
       
        return validacion;
    }
    
    public void limpiarcampos(){
        
        modelofam.borrartodos();
        tblDatosFam.updateUI();
        modeloreffam.borrartodos();
        tblRefFam.updateUI();
        modelorefpart.borrartodos();
        tblRefPart.updateUI();
        
        chkdatosFam.setSelected(true);
        chkreffam.setSelected(true);
        chkrefpart.setSelected(true);
        
        indexrefpart =0;
        indexreffam = 0;
        
        datospersonales=null;
        
         reffam.clear();
         refpart.clear();
         familiares.clear();
            
        
    }
    
    public void cargarCliente(DatosPersonales dp){
        
        txtnombre.setText(dp.getNombre());
        txtdui.setText(dp.getDui());
        datospersonales = dp;
    }
    
    public void recibirDatos(DatosPersonales dp){
    
        cargarCliente(dp);

        modelofam.llenarModelo(dp);      
        indexreffam=modeloreffam.llenarModelo(dp, false);     
        indexrefpart=modelorefpart.llenarModelo(dp, true);    
    }
    
    public boolean compararFamiliares(){
        boolean cumple=false;
        if(modelofam.getRowCount()==datospersonales.getFamiliaresList().size()){cumple=true;}
        return cumple;
    }
    
    public boolean compararreferencias(int indice, boolean tiporef){
        //false=familiar
        //true=particular
        boolean cumple=false;
        if(tiporef==false){
                if(modeloreffam.getRowCount()==indice){cumple=true;}
        }else{
                if(modelorefpart.getRowCount()==indice){cumple=true;}
        }
        
        return cumple;
    }
   
    public List<Referencias> oldListReferencias(boolean tipoRef){
            
           List<Referencias> oldList = new LinkedList();
           for(Referencias ref: datospersonales.getReferenciasList()){
               if(ref.getTipoReferencia()==tipoRef){
                   oldList.add(ref);
               }
           }
        
           return oldList;
    }
    
    public Referencias familiarAReferencia(int indice){
        Referencias ref = new Referencias();
        ref.setParentesco(modelofam.obtenerFamiliar(indice).getParentesco());
        ref.setNombre(modelofam.obtenerFamiliar(indice).getNombre());
        ref.setEmpresa(modelofam.obtenerFamiliar(indice).getLugarTrabajo());
        ref.setTelefono(modelofam.obtenerFamiliar(indice).getTelefono());
        return ref;
    }
    
    public List<Referencias> actualizarRefsDp(){   
           
        List<Referencias> list = new LinkedList();         
               for(Referencias ref:reffam){list.add(ref);}
               for(Referencias ref:refpart){list.add(ref);}
       return list;
    }
    
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnGuardar;
    public javax.swing.JCheckBox chkdatosFam;
    public javax.swing.JCheckBox chkreffam;
    public javax.swing.JCheckBox chkrefpart;
    private Label.HoverIcon hvadd;
    private Label.HoverIcon hvadd1;
    private Label.HoverIcon hvadd2;
    private Label.HoverIcon hvminus;
    private Label.HoverIcon hvminus1;
    private Label.HoverIcon hvminus2;
    private Label.HoverIcon hvpasar;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbldui;
    private javax.swing.JLabel lblnombre;
    public javax.swing.JTable tblDatosFam;
    public javax.swing.JTable tblRefFam;
    public javax.swing.JTable tblRefPart;
    public javax.swing.JTextField txtdui;
    public javax.swing.JTextField txtnombre;
    // End of variables declaration//GEN-END:variables
}
