/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package br.com.infox.telas;

import java.sql.*;
import br.com.infox.dal.ModuloConexao;
import javax.swing.JOptionPane;

/**
 *
 * @author Pedro Lucas
 */
public class TelaUsuario extends javax.swing.JInternalFrame {
// Usando a variável 'conexao' do DAL

    Connection conexao = null;

    // Criando variáveis especiais para conexão com o banco
    // Prepared Statement e ResultSet são frameworks do pacote java.sql
    // E servem para preparar e executar as instruções SQL
    PreparedStatement pst = null;
    ResultSet rs = null;

    /**
     * Creates new form TelaUsuario
     */
    public TelaUsuario() {
        initComponents();
        conexao = ModuloConexao.conector();
    }

    // Método para consultar usuários
    private void consultar() {
        String sql = "select * from tbusuarios where iduser = ?";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtUsuarioId.getText());
            rs = pst.executeQuery();

            if (rs.next()) {
                txtUsuarioNome.setText(rs.getString(2));
                txtUsuarioFone.setText(rs.getString(3));
                txtUsuarioLogin.setText(rs.getString(4));
                txtUsuarioSenha.setText(rs.getString(5));
                // A linha abaixo se refere ao combobox
                cboUsuarioPerfil.setSelectedItem(rs.getString(6));
            } else {
                JOptionPane.showMessageDialog(null, "Usuário não cadastrado");

                // As linhas abaixo "limpam" os campos
                txtUsuarioNome.setText(null);
                txtUsuarioFone.setText(null);
                txtUsuarioLogin.setText(null);
                txtUsuarioSenha.setText(null);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    // Método para adicionar usuários
    private void adicionar() {
        String sql = "insert into tbusuarios(iduser, usuario, fone, login, senha, perfil)"
                + "values(?, ?, ?, ?, ?, ?)";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtUsuarioId.getText());
            pst.setString(2, txtUsuarioNome.getText());
            pst.setString(3, txtUsuarioFone.getText());
            pst.setString(4, txtUsuarioLogin.getText());
            pst.setString(5, txtUsuarioSenha.getText());
            pst.setString(6, cboUsuarioPerfil.getSelectedItem().toString());

            // Validação dos campos obrigatórios
            if (txtUsuarioId.getText().isEmpty() || (txtUsuarioNome.getText().isEmpty())
                    || (txtUsuarioLogin.getText().isEmpty()) || (txtUsuarioSenha.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios");
            } else {

                // A linha abaixo atualiza a tabela usuarios com os dados do formulário
                int adicionado = pst.executeUpdate();

                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Usuário adicionado com sucesso");

                    // As linhas abaixo "limpam" os campos
                    txtUsuarioId.setText(null);
                    txtUsuarioNome.setText(null);
                    txtUsuarioFone.setText(null);
                    txtUsuarioLogin.setText(null);
                    txtUsuarioSenha.setText(null);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    // Criando o método para alterar os dados do usuário
    private void alterar() {
        String sql = "update tbusuarios set usuario = ?, fone = ?, login = ?, senha = ?, perfil = ?"
                + "where iduser = ?";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtUsuarioNome.getText());
            pst.setString(2, txtUsuarioFone.getText());
            pst.setString(3, txtUsuarioLogin.getText());
            pst.setString(4, txtUsuarioSenha.getText());
            pst.setString(5, cboUsuarioPerfil.getSelectedItem().toString());
            pst.setString(6, txtUsuarioId.getText());

            // Validação dos campos obrigatórios
            if (txtUsuarioId.getText().isEmpty() || (txtUsuarioNome.getText().isEmpty())
                    || (txtUsuarioLogin.getText().isEmpty()) || (txtUsuarioSenha.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios");
            } else {

                // A linha abaixo atualiza a tabela usuarios com os dados do formulário
                int adicionado = pst.executeUpdate();

                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Dados do usuário alterados com sucesso");

                    // As linhas abaixo "limpam" os campos
                    txtUsuarioId.setText(null);
                    txtUsuarioNome.setText(null);
                    txtUsuarioFone.setText(null);
                    txtUsuarioLogin.setText(null);
                    txtUsuarioSenha.setText(null);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtUsuarioId = new javax.swing.JTextField();
        txtUsuarioNome = new javax.swing.JTextField();
        txtUsuarioLogin = new javax.swing.JTextField();
        txtUsuarioSenha = new javax.swing.JTextField();
        cboUsuarioPerfil = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtUsuarioFone = new javax.swing.JTextField();
        btnUsuarioConsultar = new javax.swing.JButton();
        btnUsuarioAlterar = new javax.swing.JButton();
        btnUsuarioDeletar = new javax.swing.JButton();
        btnUsuarioAdicionar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Usuários");

        jLabel1.setText("*Id");

        jLabel2.setText("*Nome");

        jLabel3.setText("*Login");

        jLabel4.setText("*Senha");

        jLabel5.setText("*Perfil");

        cboUsuarioPerfil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "admin", "user" }));

        jLabel6.setText("Fone");

        btnUsuarioConsultar.setText("Consultar");
        btnUsuarioConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuarioConsultarActionPerformed(evt);
            }
        });

        btnUsuarioAlterar.setText("Alterar");
        btnUsuarioAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuarioAlterarActionPerformed(evt);
            }
        });

        btnUsuarioDeletar.setText("Remover");

        btnUsuarioAdicionar.setText("Adicionar");
        btnUsuarioAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuarioAdicionarActionPerformed(evt);
            }
        });

        jLabel7.setText("*Campos obrigatórios");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtUsuarioSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel6))
                                .addGap(18, 79, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(18, 18, 18)
                                        .addComponent(cboUsuarioPerfil, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtUsuarioLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnUsuarioAdicionar)
                                .addGap(18, 18, 18)
                                .addComponent(btnUsuarioConsultar)
                                .addGap(18, 18, 18)
                                .addComponent(btnUsuarioAlterar)
                                .addGap(18, 18, 18)
                                .addComponent(btnUsuarioDeletar)
                                .addGap(74, 74, 74))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(jLabel1)
                                .addGap(40, 40, 40))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtUsuarioFone, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtUsuarioId, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7))
                            .addComponent(txtUsuarioNome))))
                .addGap(69, 69, 69))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtUsuarioId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtUsuarioNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtUsuarioLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtUsuarioFone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cboUsuarioPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtUsuarioSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUsuarioConsultar)
                    .addComponent(btnUsuarioAlterar)
                    .addComponent(btnUsuarioDeletar)
                    .addComponent(btnUsuarioAdicionar))
                .addContainerGap(141, Short.MAX_VALUE))
        );

        setBounds(0, 0, 640, 480);
    }// </editor-fold>//GEN-END:initComponents

    private void btnUsuarioConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuarioConsultarActionPerformed
        // Chamando o método "consultar"
        consultar();
    }//GEN-LAST:event_btnUsuarioConsultarActionPerformed

    private void btnUsuarioAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuarioAdicionarActionPerformed
        // Chamando o método "adicionar"
        adicionar();
    }//GEN-LAST:event_btnUsuarioAdicionarActionPerformed

    private void btnUsuarioAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuarioAlterarActionPerformed
        // Chamando o método "alterar"
        alterar();
    }//GEN-LAST:event_btnUsuarioAlterarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnUsuarioAdicionar;
    private javax.swing.JButton btnUsuarioAlterar;
    private javax.swing.JButton btnUsuarioConsultar;
    private javax.swing.JButton btnUsuarioDeletar;
    private javax.swing.JComboBox<String> cboUsuarioPerfil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField txtUsuarioFone;
    private javax.swing.JTextField txtUsuarioId;
    private javax.swing.JTextField txtUsuarioLogin;
    private javax.swing.JTextField txtUsuarioNome;
    private javax.swing.JTextField txtUsuarioSenha;
    // End of variables declaration//GEN-END:variables
}
