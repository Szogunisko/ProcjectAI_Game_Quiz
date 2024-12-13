package com.sample;

import javax.swing.*;
import java.awt.*;

public class FinalGame {
    private JFrame frame;

    public FinalGame(String game) {
        frame = new JFrame("Question");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 300);
        frame.setLayout(new BorderLayout());

        // Dodanie labelki z du¿ym napisem
        JLabel questionLabel = new JLabel(game);
        questionLabel.setHorizontalAlignment(SwingConstants.CENTER);
        questionLabel.setFont(new Font("Serif", Font.BOLD, 48)); // Ustawienie du¿ej czcionki
        frame.add(questionLabel, BorderLayout.CENTER);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
