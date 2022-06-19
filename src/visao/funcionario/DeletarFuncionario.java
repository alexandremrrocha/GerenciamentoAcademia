package visao.funcionario;

import visao.cliente.Principal;
import controlador.CFuncionario;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.dominio.Funcionario;

/**
 *
 * @author Raquel Dornelas e Alexandre Rocha
 */
public class DeletarFuncionario extends javax.swing.JFrame {

    /**
     * Creates new form Deletar
     */
    public DeletarFuncionario() {
        initComponents();
        
        CFuncionario cFuncionario = new CFuncionario();
        ArrayList<Funcionario> listaFuncionario = new ArrayList<Funcionario>();
        
         if((listaFuncionario = cFuncionario.visualizarFuncionario()) != null)
         {
            //criando um modelo para a JTable
            DefaultTableModel modelo = (DefaultTableModel) tabelaDados.getModel();
            for(Funcionario funcionario : listaFuncionario)
            {
                Object[] dados = {funcionario.getNome(), funcionario.getCpf(), funcionario.getEndereco(), funcionario.getCidade(), funcionario.getUf(),
                funcionario.getCargo(), funcionario.getDataContratacao(), funcionario.getSalario(),
                };
                modelo.addRow(dados);
            }
            
            tabelaDados.getColumnModel().getColumn(0).setMinWidth(0);
//          tabelaDados.getColumnModel().getColumn(0).setMinWidth(0);
//          tabelaDados.getColumnModel().getColumn(0).setPreferredWidth(0);
//          tabelaDados.getColumnModel().getColumn(0).setMaxWidth(0);
         }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaDados = new javax.swing.JTable();
        botaoVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Deletar Funcionário");

        jPanel1.setBackground(new java.awt.Color(216, 216, 242));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/logoborda.png"))); // NOI18N

        tabelaDados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "CPF", "Endereço", "Cidade", "UF", "Cargo", "D. Contratação", "Salário"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaDados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaDadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaDados);

        botaoVoltar.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        botaoVoltar.setText("Voltar");
        botaoVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 454, Short.MAX_VALUE)
                        .addComponent(botaoVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(448, 448, 448)
                        .addComponent(jLabel11)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(botaoVoltar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel11)))
                .addGap(0, 31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tabelaDadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaDadosMouseClicked
        // TODO add your handling code here:
        int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir esse registro?");
        if(resposta == 0)
        {
            int linha = tabelaDados.getSelectedRow();
            String cpf = (tabelaDados.getValueAt(linha, 1).toString());
            CFuncionario remover = new CFuncionario();
            if(remover.deletarFuncionario(cpf))
            {
                JOptionPane.showMessageDialog(null, "Registro removido com sucesso!");
                DefaultTableModel modeloRemoveLinha = (DefaultTableModel)tabelaDados.getModel(); 
                modeloRemoveLinha.removeRow(tabelaDados.getSelectedRow());  
                tabelaDados.setModel(modeloRemoveLinha);  
            }
        }
    }//GEN-LAST:event_tabelaDadosMouseClicked

    private void botaoVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVoltarActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new Principal().setVisible(true);
    }//GEN-LAST:event_botaoVoltarActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(DeletarFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DeletarFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DeletarFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DeletarFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DeletarFuncionario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoVoltar;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaDados;
    // End of variables declaration//GEN-END:variables
}
