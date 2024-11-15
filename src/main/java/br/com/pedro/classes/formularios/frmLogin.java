package br.com.pedro.classes.formularios;

import br.com.pedro.classes.conexao.Banco;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import br.com.pedro.classes.Dados;
import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Locale;

public class frmLogin extends JFrame {
    private JPanel pLogin;
    private JLabel lblUsuario;
    private JLabel lblSenha;
    private JPasswordField pfSenha;
    private JTextField tfLogin;
    private JButton btnSair;
    private JButton btnLogin;
    private JButton btnCadastro;

    public frmLogin() {
        // Inicializa o painel pLogin
        $$$setupUI$$$();
        createUIComponents();

        // Configurações da janela
        setTitle("Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centraliza a janela na tela
        setContentPane(pLogin);

        // Adiciona os componentes ao painel
        GridBagConstraints gbc = new GridBagConstraints();

        lblUsuario = new JLabel("Usuário");
        lblUsuario.setFont(getCustomFont("Century", Font.BOLD | Font.ITALIC, 14, lblUsuario.getFont()));
        lblUsuario.setForeground(new Color(-196613));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.2;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        pLogin.add(lblUsuario, gbc);

        tfLogin = new JTextField();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pLogin.add(tfLogin, gbc);

        lblSenha = new JLabel("Senha");
        lblSenha.setFont(getCustomFont("Century Schoolbook", Font.BOLD | Font.ITALIC, 15, lblSenha.getFont()));
        lblSenha.setForeground(new Color(-196613));
        gbc.gridx = 0;
        gbc.gridy = 1;
        pLogin.add(lblSenha, gbc);

        pfSenha = new JPasswordField();
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pLogin.add(pfSenha, gbc);

        btnSair = new JButton("SAIR");
        btnSair.setBackground(new Color(-389632));
        btnSair.setForeground(new Color(-15628315));
        gbc.gridx = 0;
        gbc.gridy = 2;
        pLogin.add(btnSair, gbc);
        btnSair.addActionListener(this::btnSairActionPerformed);

        btnCadastro = new JButton("CADASTRO");
        btnCadastro.setBackground(new Color(-16773126));
        btnCadastro.setForeground(new Color(-15628315));
        gbc.gridx = 1;
        gbc.gridy = 2;
        pLogin.add(btnCadastro, gbc);
        btnCadastro.addActionListener(this::btnCadastroActionPerformed);

        btnLogin = new JButton("LOGIN");
        btnLogin.setBackground(new Color(-7537989));
        btnLogin.setForeground(new Color(-15628315));
        gbc.gridx = 2;
        gbc.gridy = 2;
        pLogin.add(btnLogin, gbc);
        btnLogin.addActionListener(this::btnLoginActionPerformed);
    }

    private void createUIComponents() {
        // Inicializa o painel pLogin para evitar o erro de componentes personalizados
        pLogin = new JPanel(new GridBagLayout());
        pLogin.setBackground(Color.BLACK);
        setContentPane(pLogin);
    }


    private void btnSairActionPerformed(ActionEvent e) {
        this.dispose();
    }

    private void btnLoginActionPerformed(ActionEvent e) {
        // Obter as credenciais do campo de login
        String login = tfLogin.getText();
        String senha = new String(pfSenha.getPassword());

        // Conectar ao MongoDB e obter a coleção
        MongoDatabase database = Banco.getDatabase();
        MongoCollection<Document> collection = database.getCollection("funcionarios");

        // Procurar o usuário com login e senha correspondentes
        Document query = new Document("login", login).append("senha", senha);
        Document user = collection.find(query).first();

        if (user != null) {
            JOptionPane.showMessageDialog(null, "Login realizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
            new frmMenu().setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos!", "Erro", JOptionPane.ERROR_MESSAGE);
            tfLogin.setText("");
            pfSenha.setText("");
            tfLogin.requestFocusInWindow();
        }
    }

    private void btnCadastroActionPerformed(ActionEvent e) {
        new frmCadastroUsuario().setVisible(true);
    }

    private Font getCustomFont(String fontName, int style, int size, Font currentFont) {
        String resultName = fontName == null ? currentFont.getName() : fontName;
        Font font = new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
        boolean isMac = System.getProperty("os.name", "").toLowerCase(Locale.ENGLISH).startsWith("mac");
        return isMac ? new Font(font.getFamily(), font.getStyle(), font.getSize()) : new StyleContext().getFont(font.getFamily(), font.getStyle(), font.getSize());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            frmLogin menu = new frmLogin();
            menu.setVisible(true);
        });
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        createUIComponents();
        pLogin.setLayout(new GridBagLayout());
        pLogin.setBackground(new Color(-10511331));
        pLogin.setInheritsPopupMenu(false);
        lblSenha = new JLabel();
        Font lblSenhaFont = this.$$$getFont$$$("Century Schoolbook", Font.BOLD | Font.ITALIC, 15, lblSenha.getFont());
        if (lblSenhaFont != null) lblSenha.setFont(lblSenhaFont);
        lblSenha.setForeground(new Color(-196613));
        lblSenha.setText("Senha:");
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        pLogin.add(lblSenha, gbc);
        pfSenha = new JPasswordField();
        pfSenha.setText("*****");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pLogin.add(pfSenha, gbc);
        tfLogin = new JTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pLogin.add(tfLogin, gbc);
        btnSair = new JButton();
        btnSair.setBackground(new Color(-389632));
        btnSair.setForeground(new Color(-15628315));
        btnSair.setText("SAIR");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pLogin.add(btnSair, gbc);
        btnLogin = new JButton();
        btnLogin.setBackground(new Color(-7537989));
        btnLogin.setForeground(new Color(-15628315));
        btnLogin.setHorizontalTextPosition(2);
        btnLogin.setText("LOGIN");
        btnLogin.setVerticalAlignment(0);
        btnLogin.setVerticalTextPosition(1);
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.weightx = 2.9;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pLogin.add(btnLogin, gbc);
        btnCadastro = new JButton();
        btnCadastro.setBackground(new Color(-16773126));
        btnCadastro.setForeground(new Color(-15628315));
        btnCadastro.setText("CADASTRO");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pLogin.add(btnCadastro, gbc);
        lblUsuario = new JLabel();
        Font lblUsuarioFont = this.$$$getFont$$$("Century", Font.BOLD | Font.ITALIC, 14, lblUsuario.getFont());
        if (lblUsuarioFont != null) lblUsuario.setFont(lblUsuarioFont);
        lblUsuario.setForeground(new Color(-196613));
        lblUsuario.setHorizontalAlignment(10);
        lblUsuario.setHorizontalTextPosition(10);
        lblUsuario.setText("Usuário:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.8;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        pLogin.add(lblUsuario, gbc);
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        Font font = new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
        boolean isMac = System.getProperty("os.name", "").toLowerCase(Locale.ENGLISH).startsWith("mac");
        Font fontWithFallback = isMac ? new Font(font.getFamily(), font.getStyle(), font.getSize()) : new StyleContext().getFont(font.getFamily(), font.getStyle(), font.getSize());
        return fontWithFallback instanceof FontUIResource ? fontWithFallback : new FontUIResource(fontWithFallback);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return pLogin;
    }

}
