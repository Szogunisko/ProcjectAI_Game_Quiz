package com.sample;

import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuestionDialog {
    private JFrame frame;
    private String selectedAnswer;

    public QuestionDialog(String question, List<String> answers) {
        frame = new JFrame("Question");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 300);
        frame.setLayout(new BorderLayout());

        // Dodanie labelki
        JLabel questionLabel = new JLabel(question);
        questionLabel.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(questionLabel, BorderLayout.NORTH);

        // Panel wyboru
        JPanel optionsPanel = new JPanel();
        optionsPanel.setLayout(new GridLayout(answers.size(), 1));

        ButtonGroup group = new ButtonGroup();
        for (String answer : answers) {
            JRadioButton optionButton = new JRadioButton(answer);
            optionButton.setActionCommand(answer);
            group.add(optionButton);
            optionsPanel.add(optionButton);
        }

        frame.add(optionsPanel, BorderLayout.CENTER);

        // Submit
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedAnswer = group.getSelection() != null ? group.getSelection().getActionCommand() : null;
                synchronized (frame) {
                    frame.notify();
                }
            }
        });
        frame.add(submitButton, BorderLayout.SOUTH);

        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }

    public String showAndWait() {
        synchronized (frame) {
            try {
                frame.wait(); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        frame.dispose();
        return selectedAnswer;
    }
}
