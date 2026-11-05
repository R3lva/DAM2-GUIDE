package com.example;

import com.formdev.flatlaf.FlatDarkLaf;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class Main {
    // --- Credits --- //
    // Made By Fernando Relva Da Silva //
    // Date : 23/09/2026 //

    // --- Components --- //
    static JFrame jf = new JFrame("Calculadora");
    static JPanel jp = new JPanel();
    static JLabel jl2 = new JLabel("Calculadora by Fernando");

    public static void main(String[] args) {

        FlatDarkLaf.setup();

        jf.setLayout(new BorderLayout());

        /// ----------------------------------------------- ///
        jf.setSize(500, 700);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLocationRelativeTo(null);
        jf.setResizable(false);

        jp.setLayout(null);
        jp.setBackground(Color.WHITE);
        jp.setBorder(new LineBorder(Color.BLACK, 1));
        /// ----------------------------------------------- ///

        /// --- Componentes reusables --- ///
        pantallaLcd pantalla = new pantallaLcd();
        tecladoNumerico tNumerico = new tecladoNumerico(pantalla);
        tecladoOperadores tOperadores = new tecladoOperadores(pantalla);

        jl2.setBounds(125, 610, 300, 40);
        jl2.setFont(new Font("Arial", Font.PLAIN, 22));
        jl2.setForeground(Color.BLACK);

        /// --- ComboBox Modo de Calculadora --- ///
        String[] modos = {"Normal", "Científica"};
        JComboBox<String> comboModo = new JComboBox<>(modos);
        comboModo.setBounds(15, 90, 130, 30);
        comboModo.setFont(new Font("Arial", Font.BOLD, 14));
        comboModo.setFocusable(false);
        jp.add(comboModo);

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

        comboModo.addActionListener(e -> {
            boolean esNormal = comboModo.getSelectedItem().equals("Normal");
            tOperadores.setVisible(esNormal);
            vertical3.setVisible(esNormal);
        });

        // --- Add Components --- //
        jp.add(tNumerico);
        jp.add(tOperadores);

        jp.add(linea1);
        jp.add(linea2);
        jp.add(linea3);
        jp.add(linea4);
        jp.add(linea5);

        jp.add(vertical1);
        jp.add(vertical2);
        jp.add(vertical3);

        jp.add(pantalla);
        jp.add(jl2);

        jf.add(jp);
        jf.setVisible(true);
    }
}