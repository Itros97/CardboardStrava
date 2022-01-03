package gui;

import controller.LoginController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginWindow extends JFrame {
    private JTextField txtInsertUser;
    private JPasswordField passwordField;

    /**
     * Create the frame.
     */
    public LoginWindow(LoginController loginController) {
        setTitle("Login Window");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 385);
        getContentPane().setLayout(null);

        JLabel lEmail = new JLabel("User e-mail");
        lEmail.setHorizontalAlignment(SwingConstants.CENTER);
        lEmail.setFont(new Font("Calibri", Font.PLAIN, 30));
        lEmail.setBounds(70, 50, 150, 30);
        getContentPane().add(lEmail);

        txtInsertUser = new JTextField();
        txtInsertUser.setToolTipText("insert email");
        txtInsertUser.setFont(new Font("Arial", Font.PLAIN, 15));
        txtInsertUser.setBounds(40, 100, 400, 25);
        getContentPane().add(txtInsertUser);
        txtInsertUser.setColumns(10);

        JLabel lPassword = new JLabel("User e-mail password");
        lPassword.setFont(new Font("Calibri", Font.PLAIN, 30));
        lPassword.setBounds(70, 170, 300, 30);
        getContentPane().add(lPassword);

        JButton bLogin = new JButton("Login");
        bLogin.setBounds(140, 290, 88, 25);
        getContentPane().add(bLogin);
        bLogin.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                loginController.login(lEmail.getText(), lPassword.getText());
            }
        });

        JButton bBack = new JButton("Back");
        bBack.setBounds(260, 290, 88, 25);
        getContentPane().add(bBack);
        bBack.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        passwordField = new JPasswordField();
        passwordField.setToolTipText("insert password");
        passwordField.setFont(new Font("Arial", Font.PLAIN, 15));
        passwordField.setBounds(40, 220, 400, 25);
        getContentPane().add(passwordField);
    }
}