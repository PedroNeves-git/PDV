package br.com.pedro.classes.formularios;

import br.com.pedro.classes.Dados;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

public class frmLogin extends JFrame {
    public JPanel getpLogin() {
        return pLogin;
    }

    public void setpLogin(JPanel pLogin) {
        this.pLogin = pLogin;
    }

    private JPanel pLogin;
    private JLabel lblUsuario;
    private JLabel lblSenha;
    private JPasswordField pfSenha;
    private JTextField tfLogin;
    private JButton btnSair;
    private JButton btnLogin;
    private JButton btnCadastro;

    public frmLogin() {
        pLogin = new JPanel();


        if (pLogin == null) {
            throw new NullPointerException("O painel pLogin não foi inicializado.");
        }

        // Configurações da janela
        setTitle("Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centraliza a janela na tela

        // Define o painel gerado no designer como o conteúdo principal
        setContentPane(pLogin);

        // Ação do botão Login
        btnLogin.addActionListener(this::btnLoginActionPerformed);

        // Ação do botão Sair
        btnSair.addActionListener(this::btnSairActionPerformed);

        // Ação do botão Cdastro
        btnCadastro.addActionListener(this::btnCadastroActionPerformed);

    }

    private void btnSairActionPerformed(ActionEvent e) {
        //BOTAO SAIR
        this.dispose();
    }

    private void btnLoginActionPerformed(ActionEvent e) {
        //BOTAO LOGIN
        Dados dados = new Dados();
        if (dados.validaUsuario(tfLogin.getText(), pfSenha.getText())) {
            JOptionPane.showMessageDialog(null, "Login realizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos!", "Erro", JOptionPane.ERROR_MESSAGE);
            tfLogin.setText("");
            pfSenha.setText("");
            tfLogin.requestFocusInWindow();
            return;
        }
        frmMenu frmMenu = new frmMenu();
        frmMenu.setVisible(true);
    }

    private void btnCadastroActionPerformed(ActionEvent e) {
        frmCadastroUsuario frmCadUsu = new frmCadastroUsuario();
        frmCadUsu.setVisible(true);
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public static void main(String[] args) {
        // Cria e exibe a janela
        SwingUtilities.invokeLater(() -> {
            frmLogin menu = new frmLogin();
            menu.setVisible(true);
        });
    }

}
