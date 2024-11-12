package br.com.pedro.classes.personalizacao;

import javax.swing.*;
import java.awt.*;

public class Fundo extends JPanel {
    private Image background;

    public Fundo(String imagePath) {
        background = new ImageIcon(getClass().getResource(imagePath)).getImage();
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
    }
}
