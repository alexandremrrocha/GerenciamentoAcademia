package visao.funcionario;

import visao.cliente.Principal;
import controlador.CFuncionario;
import static controlador.CFuncionario.converteStringDate;
import javax.swing.JOptionPane;
import modelo.DAO.DAOFuncionario;
import modelo.dominio.Funcionario;

/**
 *
 * @author Raquel Dornelas e Alexandre Rocha
 */
public class AtualizarFormulario extends javax.swing.JFrame {

    /**
     * Creates new form AtualizarFormulario
     */
    public AtualizarFormulario() {
        initComponents();
    }
    
    public AtualizarFormulario(Funcionario funcionario) {
        initComponents();
        
        String[] auxDataContratacaoVetor = CFuncionario.converteDataString(funcionario.getDataContratacao())
                .split("/");
        String auxDataContratacao = "";
        
        for(int i = 0; i < auxDataContratacaoVetor.length; i++){
            auxDataContratacao += auxDataContratacaoVetor[i];
        }
        
        campoNome.setText(funcionario.getNome());
        campoCPF.setText(funcionario.getCpf());
        campoEndereco.setText(funcionario.getEndereco());
        campoCidade.setText(funcionario.getCidade());
        campoUF.setText(funcionario.getUf());
        campoCargo.setText(funcionario.getCargo());
        campoDataContratacao.setText(auxDataContratacao);
        campoSalario.setText(funcionario.getSalario());
  
    }                       

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoSexo = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        campoNome = new javax.swing.JTextField();
        campoCPF = new javax.swing.JTextField();
        campoCidade = new javax.swing.JTextField();
        campoUF = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        campoDataContratacao = new javax.swing.JFormattedTextField();
        campoSalario = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        botaoAtualizar = new javax.swing.JButton();
        botaoVoltar = new javax.swing.JButton();
        campoEndereco = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        campoCargo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Atualizar funcionário");

        jPanel1.setBackground(new java.awt.Color(216, 216, 242));

        jLabel1.setFont(new java.awt.Font("Perpetua", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Atualizar Funcionário");

        jLabel2.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        jLabel2.setText("Nome:");

        jLabel3.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        jLabel3.setText("Endereço:");

        jLabel4.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        jLabel4.setText("Cidade:");

        jLabel5.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        jLabel5.setText("UF:");

        campoCPF.setEditable(false);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/logoborda.png"))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        jLabel9.setText("Salário:");

        jLabel12.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        jLabel12.setText("Data de contratação:");

        try {
            campoDataContratacao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jPanel2.setBackground(new java.awt.Color(216, 216, 242));
        jPanel2.setLayout(new java.awt.GridLayout(1, 2, 100, 0));

        botaoAtualizar.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        botaoAtualizar.setText("Atualizar");
        botaoAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAtualizarActionPerformed(evt);
            }
        });
        jPanel2.add(botaoAtualizar);

        botaoVoltar.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        botaoVoltar.setText("Voltar");
        botaoVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVoltarActionPerformed(evt);
            }
        });
        jPanel2.add(botaoVoltar);

        jLabel13.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        jLabel13.setText("CPF:");

        jLabel6.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        jLabel6.setText("Cargo:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(122, 122, 122)
                                .addComponent(jLabel6)
                                .addGap(173, 173, 173)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(campoDataContratacao, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(campoEndereco)
                                .addComponent(campoNome, javax.swing.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(campoUF, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(65, 65, 65)
                                .addComponent(campoCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel13)
                            .addComponent(campoCPF, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                            .addComponent(jLabel4)
                            .addComponent(campoCidade)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel9)
                                .addComponent(campoSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(148, 148, 148)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel11))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(jLabel9)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(campoCargo)
                    .addComponent(campoUF, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(campoDataContratacao, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(campoSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botaoAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAtualizarActionPerformed
        
        Funcionario funcionario = new Funcionario();
        
        funcionario.setNome(campoNome.getText());
        funcionario.setCpf(campoCPF.getText());
        funcionario.setEndereco(campoEndereco.getText());
        funcionario.setCidade(campoCidade.getText());
        funcionario.setUf(campoUF.getText());
        funcionario.setCargo(campoCargo.getText());
        
        if(!campoDataContratacao.getText().equals("  /  /    ")){
            funcionario.setDataContratacao(converteStringDate(campoDataContratacao.getText()));
        }
 
        funcionario.setSalario(campoSalario.getText());
        

        DAOFuncionario atualizar = new DAOFuncionario();
        if (atualizar.alteraFuncionario(funcionario)) {
            JOptionPane.showMessageDialog(null, "Funcionário atualizado com sucesso!");
            
            this.dispose();
            new AtualizarFuncionario().setVisible(true);
        }
                                                   
    }//GEN-LAST:event_botaoAtualizarActionPerformed

    private void botaoVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVoltarActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new Principal().setVisible(true);
    }//GEN-LAST:event_botaoVoltarActionPerformed

    public void limparCampos(){
        campoNome.setText("");
        campoCPF.setText("");
        campoEndereco.setText("");
        campoCidade.setText("");
        campoUF.setText("");
        campoCargo.setText("");
        campoDataContratacao.setText("");
        campoSalario.setText("");
        
    }
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
            java.util.logging.Logger.getLogger(AtualizarFormulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AtualizarFormulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AtualizarFormulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AtualizarFormulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AtualizarFormulario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoAtualizar;
    private javax.swing.JButton botaoVoltar;
    private javax.swing.JTextField campoCPF;
    private javax.swing.JTextField campoCargo;
    private javax.swing.JTextField campoCidade;
    private javax.swing.JFormattedTextField campoDataContratacao;
    private javax.swing.JTextField campoEndereco;
    private javax.swing.JTextField campoNome;
    private javax.swing.JTextField campoSalario;
    private javax.swing.JTextField campoUF;
    private javax.swing.ButtonGroup grupoSexo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
