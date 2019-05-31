/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi_conta;

import java.awt.Color;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import static rmi_conta.InterfaceCliente.clienteAtual;
//import static rmi_conta.Servidor.clienteAtual;
//import static rmi_conta.Servidor.listaCliente;

/**
 *
 * @author jscal
 */
public class InterfaceCliente extends javax.swing.JFrame {
    public static Cliente clienteAtual = null;
    ServicosConta servicos = null;
    private int rowDelete;
    private String codFuncSelecionado;
    /**
     * Creates new form ClienteInterface
     */
    public InterfaceCliente() {
        initComponents();
        try{
            String localizacao = "//localhost/ServicosConta";
            servicos = (ServicosConta) Naming.lookup(localizacao);
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Erro" + ex.getMessage());
        }
    }
    
    public void criarTabela(Cliente clienteTable){
    DefaultTableModel modelo = new DefaultTableModel();

    modelo.addColumn("Nome");
    modelo.addColumn("Senha");
    modelo.addColumn("Endereço");
    modelo.addColumn("Saldo");
    

//        for (Cliente a : listaCliente) {
//            if(a.getNome().equalsIgnoreCase(this.txtConsultar.getText()))
                modelo.addRow(new Object[]{
                    clienteTable.getNome(), clienteTable.getSenha(), clienteTable.getEndereco(), clienteTable.getSaldo()
                });
//        }
            tableConsulta.setModel(modelo);
            tableConsulta.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent e) {
            int linha = tableConsulta.getSelectedRow();
                    if (linha != -1) {
                        rowDelete = linha;
                        codFuncSelecionado
                                = (String) tableConsulta.getValueAt(linha, 1);
                        /*   A variavel codFuncSelecionado armazenao 
                         * o conteudo referente a coluna determina, 
                         * no caso a coluna determina é a 1, que é
                         * a coluna referente aos TITULOS dos filmes
                         */
                        btEditar.setEnabled(true);
                    } else {
                        btEditar.setEnabled(false);
                    }
            }
            });
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        inputEditarEndereco = new javax.swing.JTextField();
        txtConsultar = new javax.swing.JLabel();
        inputTxtConsulta = new javax.swing.JTextField();
        btConsultar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableConsulta = new javax.swing.JTable();
        btEditar = new javax.swing.JButton();
        txtPagamento = new javax.swing.JLabel();
        inputPagamento = new javax.swing.JTextField();
        btPagamento = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        labelHeader = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        jLabel1.setText("Editar endereço:");

        inputEditarEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputEditarEnderecoActionPerformed(evt);
            }
        });

        txtConsultar.setText("Consultar Cliente:");

        btConsultar.setBackground(new java.awt.Color(23, 81, 152));
        btConsultar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btConsultar.setForeground(new java.awt.Color(255, 255, 255));
        btConsultar.setText("CONSULTAR");
        btConsultar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConsultarActionPerformed(evt);
            }
        });

        tableConsulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nome", "Senha", "Endereço", "Saldo"
            }
        ));
        tableConsulta.setGridColor(new java.awt.Color(248, 209, 23));
        tableConsulta.getTableHeader().setResizingAllowed(false);
        tableConsulta.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tableConsulta);

        btEditar.setBackground(new java.awt.Color(23, 81, 152));
        btEditar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btEditar.setForeground(new java.awt.Color(255, 255, 255));
        btEditar.setText("EDITAR");
        btEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarActionPerformed(evt);
            }
        });

        txtPagamento.setText("Valor do pagamento:");

        btPagamento.setBackground(new java.awt.Color(23, 81, 152));
        btPagamento.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btPagamento.setForeground(new java.awt.Color(255, 255, 255));
        btPagamento.setText("CONFIRMAR");
        btPagamento.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPagamentoActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(248, 209, 23));

        labelHeader.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        labelHeader.setForeground(new java.awt.Color(23, 81, 152));
        labelHeader.setText("Consute sua conta");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rmi_conta/imagem/logobanco.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelHeader)
                .addGap(53, 53, 53))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(labelHeader)))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtConsultar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputTxtConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btConsultar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputEditarEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtPagamento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtConsultar)
                    .addComponent(inputTxtConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btConsultar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btEditar)
                    .addComponent(jLabel1)
                    .addComponent(inputEditarEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(90, 90, 90)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPagamento)
                    .addComponent(inputPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btPagamento))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inputEditarEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputEditarEnderecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputEditarEnderecoActionPerformed

    private void btConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConsultarActionPerformed
        String txtConsulta = inputTxtConsulta.getText();
        try {
            criarTabela(servicos.consultarCadastro(txtConsulta));
            clienteAtual = servicos.consultarCadastro(txtConsulta);
        } catch (RemoteException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_btConsultarActionPerformed

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
        try {
            clienteAtual.setEndereco(inputEditarEndereco.getText());
            
            Cliente editCliente = new Cliente();
            
            editCliente.setId(clienteAtual.getId());
            editCliente.setNome(clienteAtual.getNome());
            editCliente.setSenha(clienteAtual.getSenha());
            editCliente.setEndereco(clienteAtual.getEndereco());
            editCliente.setSaldo(clienteAtual.getSaldo());
            
            servicos.alterarEnredeco(editCliente);
            
            clienteAtual = editCliente;
            criarTabela(servicos.consultarCadastro(clienteAtual.getNome()));
//        try {
//            servicos.alterarEnredeco(inputTxtConsulta.getText(), inputEditarEndereco.getText());
//        } catch (RemoteException ex) {
//            JOptionPane.showMessageDialog(null, ex.getMessage());
//        }
        } catch (RemoteException ex) {
            Logger.getLogger(InterfaceCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btEditarActionPerformed

    private void btPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPagamentoActionPerformed
        Double pagamento = Double.parseDouble(inputPagamento.getText());
        try {
            servicos.realizarVenda(clienteAtual, pagamento);
            criarTabela(servicos.consultarCadastro(clienteAtual.getNome()));
        } catch (RemoteException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            
        }
    }//GEN-LAST:event_btPagamentoActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        this.getContentPane().setBackground(Color.white);
        this.setLocationRelativeTo(null);
//        Cliente cliente = new Cliente("000", "Cassia", "123", "Patrimonio", 97.9);
    }//GEN-LAST:event_formWindowGainedFocus

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
            java.util.logging.Logger.getLogger(InterfaceCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfaceCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfaceCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfaceCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfaceCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btConsultar;
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btPagamento;
    private javax.swing.JTextField inputEditarEndereco;
    private javax.swing.JTextField inputPagamento;
    private javax.swing.JTextField inputTxtConsulta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelHeader;
    private javax.swing.JTable tableConsulta;
    private javax.swing.JLabel txtConsultar;
    private javax.swing.JLabel txtPagamento;
    // End of variables declaration//GEN-END:variables
}
