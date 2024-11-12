package br.com.pedro.classes.formularios;

import br.com.pedro.classes.conexao.Banco;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class frmCadastroUsuario extends JFrame {
    private JTextField nomeField;
    private JTextField loginField;
    private JPasswordField senhaField;
    private JButton salvarButton;

    public frmCadastroUsuario() {
        // Configurações da janela
        setTitle("Cadastro de Usuário");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); // Centraliza a janela

        // Criação do painel e layout
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Campos de entrada e rótulos
        panel.add(new JLabel("Nome:"));
        nomeField = new JTextField();
        panel.add(nomeField);

        panel.add(new JLabel("Login:"));
        loginField = new JTextField();
        panel.add(loginField);

        panel.add(new JLabel("Senha:"));
        senhaField = new JPasswordField();
        panel.add(senhaField);

        // Botão de salvar
        salvarButton = new JButton("Salvar");
        salvarButton.addActionListener(this::salvarUsuario);
        panel.add(salvarButton);

        // Adiciona o painel à janela
        add(panel);
    }

    private void salvarUsuario(ActionEvent e) {
        // Recupera os valores dos campos
        String nome = nomeField.getText();
        String login = loginField.getText();
        String senha = new String(senhaField.getPassword());

        // Conecta e insere o documento no MongoDB
        MongoDatabase database = Banco.getDatabase();
        database.getCollection("funcionarios").insertOne(
                new Document("nome", nome)
                        .append("login", login)
                        .append("senha", senha)
        );

        JOptionPane.showMessageDialog(this, "Usuário cadastrado com sucesso!");
        dispose(); // Fecha a janela de cadastro após salvar
    }

}
