package br.com.pedro.classes.formularios;

import javax.swing.*;
import java.awt.*;

public class frmCadastroProduto extends JFrame {
    public frmCadastroProduto() {
        // Configurações da janela de cadastro
        setTitle("Cadastro de Produto");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); // Centraliza a janela

        // Criação dos componentes para o cadastro de produto
        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel nomeLabel = new JLabel("Nome do Produto:");
        JTextField nomeField = new JTextField();

        JLabel precoLabel = new JLabel("Preço:");
        JTextField precoField = new JTextField();

        JButton salvarButton = new JButton("Salvar");

        // Adicionando os componentes ao painel
        panel.add(nomeLabel);
        panel.add(nomeField);
        panel.add(precoLabel);
        panel.add(precoField);
        panel.add(salvarButton);

        // Adiciona o painel à janela
        add(panel);

        // Exibe a janela
        setVisible(true);
    }

}

