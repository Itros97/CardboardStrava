package gui;

import javax.swing.*;
import java.awt.*;

public class LoginWindow extends JFrame {
    private JTextField txtInsertUser;
    private JPasswordField passwordField;

    /**
     * Create the frame.
     */
    public LoginWindow() {
        setTitle("Login Window");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 385);
        getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("User e-mail");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 30));
        lblNewLabel.setBounds(70, 50, 150, 30);
        getContentPane().add(lblNewLabel);

        txtInsertUser = new JTextField();
        txtInsertUser.setToolTipText("insert user");
        txtInsertUser.setFont(new Font("Arial", Font.PLAIN, 15));
        txtInsertUser.setBounds(40, 100, 400, 25);
        getContentPane().add(txtInsertUser);
        txtInsertUser.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("User e-mail password");
        lblNewLabel_1.setFont(new Font("Calibri", Font.PLAIN, 30));
        lblNewLabel_1.setBounds(70, 170, 300, 30);
        getContentPane().add(lblNewLabel_1);

        JButton btnNewButton = new JButton("Login");
        btnNewButton.setBounds(140, 290, 88, 25);
        getContentPane().add(btnNewButton);

        JButton bBack = new JButton("Back");
        bBack.setBounds(260, 290, 88, 25);
        getContentPane().add(bBack);

        passwordField = new JPasswordField();
        passwordField.setToolTipText("insert password");
        passwordField.setFont(new Font("Arial", Font.PLAIN, 15));
        passwordField.setBounds(40, 220, 400, 25);
        getContentPane().add(passwordField);
    }
}