package FORMS.PANELS;

import CONTROLADORES.DatosPersonalesJpaController;
import Entidades.DatosPersonales;
import MODELOSTBL.modeloClientes;

/**
 *
 * @author DFUENTES
 */
public class REPORTE_CLIENTES_PNL extends javax.swing.JPanel {

    private modeloClientes modelo = new modeloClientes();

    private DatosPersonalesJpaController djc = new DatosPersonalesJpaController();

    public REPORTE_CLIENTES_PNL() {

        initComponents();

    }

    public void cargarObservacion(int indice) {
        txtObservaciones.setText(modelo.obtenerCliente(indice).getObservacion());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rbngroup = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        btnCargarClientes = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtObservaciones = new javax.swing.JTextArea();
        lblnombre = new javax.swing.JLabel();
        rbnProcede = new javax.swing.JRadioButton();
        rbnTodos = new javax.swing.JRadioButton();
        rbnNoprocede = new javax.swing.JRadioButton();
        rbnActivos = new javax.swing.JRadioButton();

        setBackground(new java.awt.Color(240, 236, 236));

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblClientes.setRowHeight(30);
        tblClientes.setSelectionBackground(new java.awt.Color(204, 255, 204));
        tblClientes.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tblClientes.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblClientes);
        tblClientes.setModel(modelo);

        tblClientes.getColumnModel().getColumn(0).setPreferredWidth(280);
        tblClientes.getColumnModel().getColumn(1).setPreferredWidth(100);
        tblClientes.getColumnModel().getColumn(2).setPreferredWidth(100);
        tblClientes.getColumnModel().getColumn(3).setPreferredWidth(560);

        tblClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                cargarObservacion(tblClientes.getSelectedRow());
            }
        });

        jLabel6.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("CLIENTES REGISTRADOS");

        btnCargarClientes.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        btnCargarClientes.setText("Cargar Clientes");
        btnCargarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarClientesActionPerformed(evt);
            }
        });

        txtObservaciones.setColumns(20);
        txtObservaciones.setLineWrap(true);
        txtObservaciones.setRows(5);
        jScrollPane2.setViewportView(txtObservaciones);

        lblnombre.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        lblnombre.setForeground(new java.awt.Color(51, 51, 51));
        lblnombre.setText("Observaciones sobre  el cliente:");

        rbnProcede.setBackground(new java.awt.Color(240, 236, 236));
        rbngroup.add(rbnProcede);
        rbnProcede.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        rbnProcede.setForeground(new java.awt.Color(51, 51, 51));
        rbnProcede.setText("Procede");

        rbnTodos.setBackground(new java.awt.Color(240, 236, 236));
        rbngroup.add(rbnTodos);
        rbnTodos.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        rbnTodos.setForeground(new java.awt.Color(51, 51, 51));
        rbnTodos.setText("Todos");

        rbnNoprocede.setBackground(new java.awt.Color(240, 236, 236));
        rbngroup.add(rbnNoprocede);
        rbnNoprocede.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        rbnNoprocede.setForeground(new java.awt.Color(51, 51, 51));
        rbnNoprocede.setText("No Procede");

        rbnActivos.setBackground(new java.awt.Color(240, 236, 236));
        rbngroup.add(rbnActivos);
        rbnActivos.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        rbnActivos.setForeground(new java.awt.Color(51, 51, 51));
        rbnActivos.setText("Con Créditos Activos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblnombre)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 664, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rbnTodos)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rbnProcede)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rbnNoprocede)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rbnActivos)
                                .addGap(18, 18, 18)
                                .addComponent(btnCargarClientes))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1040, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 27, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCargarClientes)
                    .addComponent(rbnProcede)
                    .addComponent(rbnTodos)
                    .addComponent(rbnNoprocede)
                    .addComponent(rbnActivos))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblnombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCargarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarClientesActionPerformed

        if (rbnTodos.isSelected()) {
            modelo.borrartodos();
            for (DatosPersonales dp : djc.findDatosPersonalesEntities()) {
                modelo.agregarCliente(dp);
            }
        } else if (rbnProcede.isSelected()) {
            modelo.borrartodos();
            for (DatosPersonales dp : djc.findByProcede(true)) {
                modelo.agregarCliente(dp);
            }
        } else if (rbnNoprocede.isSelected()) {
            modelo.borrartodos();
            for (DatosPersonales dp : djc.findByProcede(false)) {
                modelo.agregarCliente(dp);
            }
        } else if(rbnActivos.isSelected()){
            modelo.borrartodos();
            short estado = 2;
            for(DatosPersonales dp: djc.findConCreditosActivos(estado)){
                modelo.agregarCliente(dp);
            }
        }

    }//GEN-LAST:event_btnCargarClientesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCargarClientes;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblnombre;
    private javax.swing.JRadioButton rbnActivos;
    private javax.swing.JRadioButton rbnNoprocede;
    private javax.swing.JRadioButton rbnProcede;
    private javax.swing.JRadioButton rbnTodos;
    private javax.swing.ButtonGroup rbngroup;
    public javax.swing.JTable tblClientes;
    private javax.swing.JTextArea txtObservaciones;
    // End of variables declaration//GEN-END:variables
}
