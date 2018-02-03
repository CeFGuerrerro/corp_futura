
package FORMS;

import FORMS.PANELS.CLIENTE_PNL;
import FORMS.PANELS.CREDITOS_PNL;
import FORMS.PANELS.SOLICITUD_PNL;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author DFUENTES
 */
public class MAIN_FORM extends javax.swing.JFrame {

    private CLIENTE_PNL   cliente   = new CLIENTE_PNL();
    private CREDITOS_PNL creditos = new CREDITOS_PNL();
    private SOLICITUD_PNL solicitud = new SOLICITUD_PNL(creditos);
    
    
    public MAIN_FORM() {
        initComponents();
        this.getContentPane().setBackground(Color.WHITE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        cargarPanel(creditos);       
    }
    
    public void cargarPanel(JPanel panel){
        
            panel.setLocation(0,0);
            panel.setSize(500,500);
            panelPrincipal.removeAll();
            panelPrincipal.add(panel);
            panelPrincipal.revalidate();
            panelPrincipal.repaint();
    
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        a = new javax.swing.JLabel();
        a1 = new javax.swing.JLabel();
        a2 = new javax.swing.JLabel();
        a3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        hvUsuarios = new Label.HvLabel();
        panelPrincipal = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));

        jPanel1.setBackground(new java.awt.Color(45, 74, 103));
        jPanel1.setPreferredSize(new java.awt.Dimension(220, 543));

        a.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/LABELS/clienteDes.png"))); // NOI18N
        a.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                aMouseClicked(evt);
            }
        });

        a1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/LABELS/solicitudDes.png"))); // NOI18N
        a1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                a1MouseClicked(evt);
            }
        });

        a2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/LABELS/creditosAct.png"))); // NOI18N
        a2.setToolTipText("");
        a2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                a2MouseClicked(evt);
            }
        });

        a3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/LABELS/reporteDes.png"))); // NOI18N

        jSeparator1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        jSeparator1.setPreferredSize(new java.awt.Dimension(50, 3));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/LOGO/logo1.png"))); // NOI18N

        hvUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/LABELS/usuariosDes.png"))); // NOI18N
        hvUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hvUsuariosMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(a, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(a1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(a2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(a3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(hvUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(a, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(a1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(a2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(a3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hvUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(183, Short.MAX_VALUE))
        );

        hvUsuarios.setImages("/IMAGES/LABELS/usuariosAct.png", "/IMAGES/LABELS/usuariosAct.png", "/IMAGES/LABELS/usuariosDes.png");

        panelPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        panelPrincipal.setLayout(new javax.swing.BoxLayout(panelPrincipal, javax.swing.BoxLayout.LINE_AXIS));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 626, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void a1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a1MouseClicked
        solicitud = new SOLICITUD_PNL(creditos);
        a1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/LABELS/solicitudAct.png"))); 
        a.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/LABELS/clienteDes.png"))); 
        a2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/LABELS/creditosDes.png")));
        cargarPanel(solicitud);
        
    }//GEN-LAST:event_a1MouseClicked

    private void aMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aMouseClicked

        a1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/LABELS/solicitudDes.png"))); 
        a.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/LABELS/clienteAct.png"))); 
        a2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/LABELS/creditosDes.png")));

        cargarPanel(cliente);
      
    }//GEN-LAST:event_aMouseClicked

    private void a2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a2MouseClicked
        
        a1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/LABELS/solicitudDes.png"))); 
        a.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/LABELS/clienteDes.png"))); 
        a2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/LABELS/creditosAct.png")));

        cargarPanel(creditos);
    }//GEN-LAST:event_a2MouseClicked

    private void hvUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hvUsuariosMouseClicked
        
        USUARIOS_FORM usuarios = new USUARIOS_FORM();
        usuarios.setVisible(true);
        
        
    }//GEN-LAST:event_hvUsuariosMouseClicked

    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MAIN_FORM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MAIN_FORM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MAIN_FORM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MAIN_FORM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MAIN_FORM().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel a;
    private javax.swing.JLabel a1;
    private javax.swing.JLabel a2;
    private javax.swing.JLabel a3;
    private Label.HvLabel hvUsuarios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel panelPrincipal;
    // End of variables declaration//GEN-END:variables
}
