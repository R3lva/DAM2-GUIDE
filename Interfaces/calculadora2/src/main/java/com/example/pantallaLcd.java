package com.example;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class pantallaLcd extends JLabel {

    public pantallaLcd() {
        super("0.");

        setFont(new Font("Arial", Font.BOLD, 38));
        setOpaque(true);
        setBackground(Color.BLACK);
        setForeground(Color.WHITE);
        setHorizontalAlignment(SwingConstants.RIGHT);
        setBorder(new LineBorder(new Color(30, 55, 95), 2, true));
        setBounds(15, 15, 455, 65);

        // Quitamos el foco de la pantalla
        setFocusable(false);
    }

    public void change(String txt) {
        if (getText().equals("0.")) {
            setText("");
        }
        setText(getText() + txt);
    }
    
        public void borrar() {
        setText("0.");
    }

    public void cambiarSigno() {
        String actual = getText();
        if (actual.equals("0.") || actual.isEmpty()) {
            return;
        }
        if (actual.startsWith("-")) {
            setText(actual.substring(1));
        } else {
            setText("-" + actual);
        }
    }
}