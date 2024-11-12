package br.com.pedro.classes;

import br.com.pedro.classes.formularios.frmLogin;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            frmLogin login = new frmLogin();
            login.setLocationRelativeTo(null); // Centraliza o formulário na tela
            login.setVisible(true);            // Exibe o formulário
        });
    }
}
