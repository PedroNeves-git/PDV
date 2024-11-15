package br.com.pedro.classes.formularios;

import br.com.pedro.classes.conexao.Banco;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class frmCadastroProduto extends JFrame {

    private JTextField precoField;  // Declarei a variável precoField aqui

    public frmCadastroProduto() {
        // Configurações da janela de cadastro
        setTitle("Cadastro de Produto");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); // Centraliza a janela

        // Criação dos componentes para o cadastro de produto
        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Definindo a cor de fundo do painel
        panel.setBackground(new Color(0, 191, 255));  // Azul piscina

        // Labels e campos
        JLabel nomeLabel = new JLabel("Nome do Produto:");
        JTextField nomeField = new JTextField();

        JLabel descLabel = new JLabel("Descrição:");
        JTextField descField = new JTextField();

        JLabel precoLabel = new JLabel("Preço Unitário:");
        precoField = new JTextField();  // Agora está declarado corretamente

        JLabel categoriaLabel = new JLabel("Categoria:");
        String[] categorias = {"Bebidas", "Frios", "Bebidas Alcoólicas", "Açougue", "Padaria", "Diversos"};
        JComboBox<String> categoriaCombo = new JComboBox<>(categorias);

        JLabel codBarrasLabel = new JLabel("Cód. Barras:");
        JTextField codBarrasField = new JTextField();

        // Botão Salvar
        JButton salvarButton = new JButton("Salvar");

        // Adicionando os componentes ao painel
        panel.add(nomeLabel);
        panel.add(nomeField);
        panel.add(descLabel);
        panel.add(descField);
        panel.add(precoLabel);
        panel.add(precoField);
        panel.add(categoriaLabel);
        panel.add(categoriaCombo);
        panel.add(codBarrasLabel);
        panel.add(codBarrasField);

        // Adicionando o painel à janela
        add(panel, BorderLayout.CENTER);
        add(salvarButton, BorderLayout.SOUTH);

        // Estabelece a cor do fundo do form
        getContentPane().setBackground(new Color(0, 191, 255));  // Azul piscina

        // Evento para aceitar apenas números no campo de preço
        precoField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                validarPreco();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                validarPreco();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                validarPreco();
            }
        });

        // Ação do botão salvar
        salvarButton.addActionListener(e -> {
            String nome = nomeField.getText();
            String descricao = descField.getText();
            String precoTexto = precoField.getText().replace(",", ".");
            double preco = 0;
            try {
                preco = Double.parseDouble(precoTexto);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Preço inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String categoria = (String) categoriaCombo.getSelectedItem();
            String codBarras = codBarrasField.getText();

            // Salvar no banco de dados
            if (salvarProduto(nome, descricao, preco, categoria, codBarras)) {
                JOptionPane.showMessageDialog(this, "Produto cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                limparCampos(nomeField, descField, precoField, codBarrasField);
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao cadastrar produto.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Exibe a janela
        setVisible(true);
    }

    // Método para validar o preço (permitindo apenas números)
    private void validarPreco() {
        String text = precoField.getText();
        // Remove todos os caracteres que não são números ou vírgula
        if (!text.matches("[0-9,]*")) {
            precoField.setText(text.replaceAll("[^0-9,]", ""));  // Remove caracteres inválidos
        }
    }

    // Método para salvar o produto no MongoDB
    private boolean salvarProduto(String nome, String descricao, double preco, String categoria, String codBarras) {
        try {
            // Obtendo a conexão com o banco de dados
            MongoDatabase database = Banco.getDatabase();
            MongoCollection<Document> collection = database.getCollection("produtos");

            // Criando o documento com os dados do produto
            Document produto = new Document("nome", nome)
                    .append("descricao", descricao)
                    .append("preco", preco)
                    .append("categoria", categoria)
                    .append("cod_barras", codBarras);

            // Inserindo o documento na coleção
            collection.insertOne(produto);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para limpar os campos do formulário
    private void limparCampos(JTextField nomeField, JTextField descField, JTextField precoField, JTextField codBarrasField) {
        nomeField.setText("");
        descField.setText("");
        precoField.setText("");
        codBarrasField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new frmCadastroProduto());
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
    }
}
