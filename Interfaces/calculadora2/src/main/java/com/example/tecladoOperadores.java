package com.example;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.border.LineBorder;

public class tecladoOperadores extends JPanel {

    private pantallaLcd pantalla;

    public tecladoOperadores(pantallaLcd pantalla) {
        this.pantalla = pantalla;

        setLayout(null);
        setOpaque(false);
        setBounds(400, 130, 90, 455);

        JButton[] botons = new JButton[6];
        String[] textos = {"C", "+", "-", "X", "/", "="};

        /// --- Buttons --- ///
        for (int i = 0; i < 6; i++) {
            botons[i] = new JButton(textos[i]);
            botons[i].setLayout(new BorderLayout());

            botons[i].addActionListener(e -> accion(e.getActionCommand()));

            botons[i].putClientProperty("JButton.arc", 25);
            botons[i].setFont(new Font("Arial", Font.BOLD, 34));
            botons[i].setForeground(Color.WHITE);
            botons[i].setFocusPainted(false);
            botons[i].setFocusable(false);

            // Borde azul oscuro
            botons[i].setBorder(
                new LineBorder(new Color(30, 55, 95), 2, true)
            );

            botons[i].setBackground(new Color(240, 125, 45));

            add(botons[i]);

            // Key Binding
            asociarTecla(textos[i]);
        }

        // --- Operator Buttons --- //  (coordenadas relativas al panel)
        botons[0].setBounds(10, 10, 60, 60);    // C (borrar)
        botons[1].setBounds(10, 85, 60, 60);    // +
        botons[2].setBounds(10, 160, 60, 60);   // -
        botons[3].setBounds(10, 235, 60, 60);   // X
        botons[4].setBounds(10, 310, 60, 60);   // /

        // --- Equal Button --- //
        botons[5].setBounds(10, 385, 60, 60);
        botons[5].setBackground(new Color(65, 110, 185));

        // --- Clear Button --- //
        botons[0].setBackground(new Color(190, 50, 50));
    }

    private void accion(String txt) {
        if (txt.equals("C")) {
            pantalla.borrar();
        } else {
            pantalla.change(txt);
        }
    }

    // Key Binding: la tecla hace lo mismo que pulsar el botón con el ratón
    private void asociarTecla(String txt) {
        String nombre = "op_" + txt;
        var inputMap = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);

        if (txt.equals("C")) {
            inputMap.put(KeyStroke.getKeyStroke('c'), nombre);
            inputMap.put(KeyStroke.getKeyStroke('C'), nombre);
            inputMap.put(KeyStroke.getKeyStroke("DELETE"), nombre);
        } else if (txt.equals("X")) {
            inputMap.put(KeyStroke.getKeyStroke('x'), nombre);
            inputMap.put(KeyStroke.getKeyStroke('X'), nombre);
            inputMap.put(KeyStroke.getKeyStroke('*'), nombre);
        } else {
            inputMap.put(KeyStroke.getKeyStroke(txt.charAt(0)), nombre);
        }

        getActionMap().put(nombre, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                accion(txt);
            }
        });
    }
}