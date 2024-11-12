package br.com.pedro.classes.formularios;

import br.com.pedro.classes.personalizacao.Fundo;

import javax.swing.*;
import java.awt.*;

public class frmMenu extends JFrame {
    private JPanel pMenu; // Declara o painel

    public frmMenu() {
        // Configurações da janela

        setTitle("Menu");
        setSize(1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centraliza a janela

        // Inicializa o painel
        pMenu = new JPanel(); // Agora pMenu é um JPanel válido

        this.pMenu = new Fundo("/exe.jpeg");
        // Define o painel de conteúdo como o painel com imagem de fundo

        // Se você quiser um layout, defina aqui
        pMenu.setLayout(new FlowLayout()); // Exemplo de layout

        // Adiciona o painel à janela
        add(pMenu);

        barraMenu();

    }

    private void barraMenu() {
        // Criação da barra de menu
        JMenuBar menuBar = new JMenuBar();

        // Criação dos menus
        JMenu cadastroMenu = new JMenu("Cadastro");
        JMenu arquivoMenu = new JMenu("Arquivo");
        JMenu movimentoMenu = new JMenu("Movimento");
        JMenu editarMenu = new JMenu("Editar");


        // CADASTRO
        JMenuItem produto = new JMenuItem("Produto");
        produto.addActionListener(e -> new frmCadastroProduto());
        cadastroMenu.add(produto);
        arquivoMenu.addSeparator();
        JMenuItem usuario = new JMenuItem("Usuário");
        cadastroMenu.add(usuario);
        menuBar.add(cadastroMenu);

        // ARQUIVO
        JMenuItem abrirItem = new JMenuItem("Abrir");
        arquivoMenu.add(abrirItem);//Adicionando items criado ao menu arquivo
        arquivoMenu.addSeparator(); // Adiciona uma linha separadora
        JMenuItem sairItem = new JMenuItem("Sair");
        arquivoMenu.add(sairItem);
        menuBar.add(arquivoMenu);// Adicionando o menu "Arquivo" à barra de menu

        // EDITAR
        JMenuItem editarUsuario = new JMenuItem("Usuario");
        editarMenu.add(editarUsuario);
        editarMenu.addSeparator();
        JMenuItem editarPerfil = new JMenuItem("Perfil");
        editarMenu.add(editarPerfil);
        menuBar.add(editarMenu);

        // MOVIMENTO
        menuBar.add(movimentoMenu);
        // Associa a barra de menu ao JFrame
        setJMenuBar(menuBar);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public static void main(String[] args) {
        // Cria e exibe a janela
        SwingUtilities.invokeLater(() -> {
            frmMenu menu = new frmMenu();
            menu.setVisible(true);
        });
    }

}
