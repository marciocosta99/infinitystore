package interfaces;

import infinitystore.com.JTableRenderer;
import infinitystore.com.LojaAdmin;
import infinitystore.com.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class ProcurarUsuario extends javax.swing.JFrame {
    private LojaAdmin admin = new LojaAdmin();
    private List<Usuario> usuarios = new ArrayList<Usuario>();
    
    public ProcurarUsuario() {
        admin.recuperaDados();
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        nomeDeUsuario = new javax.swing.JTextField();
        procurar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        nomeDeUsuario.setBackground(new java.awt.Color(255, 127, 42));
        nomeDeUsuario.setFont(new java.awt.Font("Glober SemiBold Free", 0, 13)); // NOI18N
        nomeDeUsuario.setForeground(new java.awt.Color(254, 254, 254));
        nomeDeUsuario.setBorder(null);
        nomeDeUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeDeUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(nomeDeUsuario);
        nomeDeUsuario.setBounds(150, 63, 140, 25);

        procurar.setBackground(new java.awt.Color(255, 127, 42));
        procurar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Pesquisar Produtos - Botão.png"))); // NOI18N
        procurar.setBorder(null);
        procurar.setBorderPainted(false);
        procurar.setContentAreaFilled(false);
        procurar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        procurar.setFocusPainted(false);
        procurar.setFocusable(false);
        procurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                procurarActionPerformed(evt);
            }
        });
        getContentPane().add(procurar);
        procurar.setBounds(110, 59, 40, 29);

        tabela.setBorder(null);
        tabela.setFont(new java.awt.Font("Helvetica", 0, 12)); // NOI18N
        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Sobrenome", "Username", "Senha"
            }
        ));
        tabela.setGridColor(new java.awt.Color(255, 127, 42));
        tabela.setRowHeight(25);
        jScrollPane1.setViewportView(tabela);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(96, 141, 479, 124);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Aviso.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(94, 91, 140, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Pesquisar Produtos.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, -26, 710, 410);

        setSize(new java.awt.Dimension(693, 414));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void procurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_procurarActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        
        if(tabela.getRowCount() > 0){   
            while(tabela.getRowCount() > 0){    
                modelo.removeRow(0);
            }
        }
        
        TableColumnModel columnModel = tabela.getColumnModel();
        JTableRenderer renderer = new JTableRenderer();
        columnModel.getColumn(0).setCellRenderer(renderer);
        tabela.setDefaultRenderer(Object.class, new CellRenderer());
        
        List<Usuario> usuarios = admin.procurarUsuario(nomeDeUsuario.getText());
        if(usuarios.size() > 0){
            for(Usuario u: usuarios){
                Object[] linha = {u.getNome(), u.getSobrenome(), u.getNomeDeUsuario(), u.getSenha()};
                modelo.addRow(linha);
            }
        } else{
            JOptionPane.showMessageDialog(null, "Nenhum usuário encontrado");
        }
    }//GEN-LAST:event_procurarActionPerformed

    private void nomeDeUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeDeUsuarioActionPerformed
        procurar.doClick();
    }//GEN-LAST:event_nomeDeUsuarioActionPerformed

    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(ProcurarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProcurarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProcurarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProcurarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProcurarUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nomeDeUsuario;
    private javax.swing.JButton procurar;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
}
