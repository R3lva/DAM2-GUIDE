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

public class tecladoNumerico extends JPanel {

    private pantallaLcd pantalla;

    public tecladoNumerico(pantallaLcd pantalla) {
        this.pantalla = pantalla;

        setLayout(null);
        setOpaque(false);
        setBounds(0, 0, 400, 600);

        JButton[] botons = new JButton[12];
        String[] textos = {
            "1", "2", "3",
            "4", "5", "6",
            "7", "8", "9",
            "0", ".", "±"
        };

        /// --- Buttons --- ///
        for (int i = 0; i < 12; i++) {
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

            if (i < 11) {
                botons[i].setBackground(new Color(255, 190, 0));
            } else {
                botons[i].setBackground(new Color(240, 125, 45));
            }

            add(botons[i]);

            // Key Binding
            asociarTecla(textos[i]);
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
        botons[10].setBounds(155, 475, 95, 95);
        botons[11].setBounds(285, 475, 95, 95);
    }

    private void accion(String txt) {
        if (txt.equals("±")) {
            pantalla.cambiarSigno();
        } else {
            pantalla.change(txt);
        }
    }

    // Key Binding: la tecla hace lo mismo que pulsar el botón con el ratón
    private void asociarTecla(String txt) {
        char tecla = txt.equals("±") ? 'n' : txt.charAt(0);
        String nombre = "tecla_" + txt;

        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
            .put(KeyStroke.getKeyStroke(tecla), nombre);
        getActionMap().put(nombre, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                accion(txt);
            }
        });
    }
}