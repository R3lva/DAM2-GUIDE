package com.example;

import com.formdev.flatlaf.FlatDarkLaf;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class Main {
    // --- Credits --- //
    // Made By Fernando Relva Da Silva //
    // Date : 23/09/2026 //

    // --- Components --- //
    static JFrame jf = new JFrame("Calculadora");
    static JPanel jp = new JPanel();
    static JLabel jl = new JLabel("0.");
    static JLabel jl2 = new JLabel("Calculadora by Fernando");

    public static void change(String txt) {
        if (jl.getText().equals("0.")) {
            jl.setText("");
        }
        jl.setText(jl.getText() + txt);
    }

    public static void main(String[] args) {

        FlatDarkLaf.setup();

        JButton[] botons = new JButton[16];
        jf.setLayout(new BorderLayout());
        String[] textos = {
            "1", "2", "3", "4",
            "5", "6", "7", "8",
            "9", "0", "+", "-",
            "X", "/", "=", "."
        };

        /// ----------------------------------------------- ///
        jf.setSize(500, 700);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLocationRelativeTo(null);
        jf.setResizable(false);

        jp.setLayout(null);
        jp.setBackground(Color.WHITE);
        jp.setBorder(new LineBorder(Color.BLACK, 1));
        /// ----------------------------------------------- ///

        /// --- Texto Edit --- ///
        jl.setFont(new Font("Arial", Font.BOLD, 38));
        jl.setOpaque(true);
        jl.setBackground(Color.BLACK);
        jl.setForeground(Color.WHITE);
        jl.setHorizontalAlignment(SwingConstants.RIGHT);
        jl.setBorder(new LineBorder(new Color(30, 55, 95), 2, true));
        jl.setBounds(15, 15, 455, 65);

        jl2.setBounds(125, 610, 300, 40);
        jl2.setFont(new Font("Arial", Font.PLAIN, 22));
        jl2.setForeground(Color.BLACK);

        /// --- ComboBox Modo de Calculadora --- ///
        String[] modos = {"Normal", "Científica"};
        JComboBox<String> comboModo = new JComboBox<>(modos);
        comboModo.setBounds(15, 90, 130, 30);
        comboModo.setFont(new Font("Arial", Font.BOLD, 14));
        jp.add(comboModo);

        /// --------------------------------------------- ///
        /// --- Buttons --- ///

        for (int i = 0; i < 16; i++) {
            botons[i] = new JButton(textos[i]);
            botons[i].setLayout(new BorderLayout());

            // Listener directo sin problemas de variables efectivas finales
            botons[i].addActionListener(e -> change(e.getActionCommand()));

            botons[i].putClientProperty("JButton.arc", 25);
            botons[i].setFont(new Font("Arial", Font.BOLD, 34));
            botons[i].setForeground(Color.WHITE);
            botons[i].setFocusPainted(false);

            // Borde azul oscuro
            botons[i].setBorder(
                new LineBorder(new Color(30, 55, 95), 2, true)
            );

            if (i < 10 || i == 15) {
                botons[i].setBackground(new Color(255, 190, 0));
            } else {
                botons[i].setBackground(new Color(240, 125, 45));
            }

            jp.add(botons[i]);
        }

        // --- First Line --- //
        botons[0].setBounds(25, 145, 95, 95);
        botons[1].setBounds(155, 145, 95, 95);
        botons[2].setBounds(285, 145, 95, 95);

        // --- Second Line --- //
        botons[3].setBounds(25, 255, 95, 95);
        botons[4].setBounds(155, 255, 95, 95);
        botons[5].setBounds(285, 255, 95, 95);

        // --- Three Line --- //
        botons[6].setBounds(25, 365, 95, 95);
        botons[7].setBounds(155, 365, 95, 95);
        botons[8].setBounds(285, 365, 95, 95);

        // --- Final Line --- //
        botons[9].setBounds(25, 475, 95, 95);
        botons[15].setBounds(155, 475, 95, 95);

        // --- Operator Buttons --- //
        botons[10].setBounds(410, 145, 60, 60);
        botons[11].setBounds(410, 235, 60, 60);
        botons[12].setBounds(410, 325, 60, 60);
        botons[13].setBounds(410, 415, 60, 60);

        // --- Equal Button --- //
        botons[14].setBounds(410, 505, 60, 60);
        botons[14].setBackground(new Color(65, 110, 185));

        // --- Separator Lines --- //

        // Horizontal
        JPanel linea1 = new JPanel();
        linea1.setBackground(Color.BLACK);
        linea1.setBounds(15, 130, 455, 1);

        JPanel linea2 = new JPanel();
        linea2.setBackground(Color.BLACK);
        linea2.setBounds(15, 245, 375, 1);

        JPanel linea3 = new JPanel();
        linea3.setBackground(Color.BLACK);
        linea3.setBounds(15, 355, 375, 1);

        JPanel linea4 = new JPanel();
        linea4.setBackground(Color.BLACK);
        linea4.setBounds(15, 465, 375, 1);

        JPanel linea5 = new JPanel();
        linea5.setBackground(Color.BLACK);
        linea5.setBounds(15, 585, 455, 1);

        // Vertical
        JPanel vertical1 = new JPanel();
        vertical1.setBackground(Color.BLACK);
        vertical1.setBounds(140, 130, 1, 455);

        JPanel vertical2 = new JPanel();
        vertical2.setBackground(Color.BLACK);
        vertical2.setBounds(270, 130, 1, 455);

        JPanel vertical3 = new JPanel();
        vertical3.setBackground(Color.BLACK);
        vertical3.setBounds(390, 130, 1, 455);

        comboModo.addKeyListener(null);
        comboModo.addActionListener(e -> {
            boolean esNormal = comboModo.getSelectedItem().equals("Normal");
            for (int i = 10; i <= 14; i++) {
                botons[i].setVisible(esNormal);
            }
            vertical3.setVisible(esNormal);
        });

        // --- Add Components --- //
        jp.add(linea1);
        jp.add(linea2);
        jp.add(linea3);
        jp.add(linea4);
        jp.add(linea5);

        jp.add(vertical1);
        jp.add(vertical2);
        jp.add(vertical3);

        jp.add(jl);
        jp.add(jl2);

        jf.add(jp);
        jf.setVisible(true);
    }
}