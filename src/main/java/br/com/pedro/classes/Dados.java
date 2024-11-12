package br.com.pedro.classes;

public class Dados {


    public boolean validaUsuario(String usuario, String senha) {
        if (usuario.equals("admin") && senha.equals("admin")) {

            return true;
        } else {
            return false;
        }
    }
}
