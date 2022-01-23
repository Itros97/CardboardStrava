package gui;

import controller.LoginController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginWindow extends JFrame {
    private final LoginController controller;

    private final JTextField tEmail;
    private final JTextField tPassword;
    private final JLabel lFeedback;

    /**
     * Create the frame.
     */
    public LoginWindow(LoginController loginController) {
        this.controller = loginController;

        setTitle("Login Window");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 500, 385);
        getContentPane().setLayout(null);

        JLabel lEmail = new JLabel("Email");
        lEmail.setHorizontalAlignment(SwingConstants.CENTER);
        lEmail.setFont(new Font("Calibri", Font.PLAIN, 30));
        lEmail.setBounds(30, 50, 150, 30);
        getContentPane().add(lEmail);

        tEmail = new JTextField("");
        tEmail.setToolTipText("insert email");
        tEmail.setFont(new Font("Arial", Font.PLAIN, 15));
        tEmail.setBounds(40, 100, 400, 25);
        getContentPane().add(tEmail);

        JLabel lPassword = new JLabel("Password");
        lPassword.setFont(new Font("Calibri", Font.PLAIN, 30));
        lPassword.setBounds(70, 170, 300, 30);
        getContentPane().add(lPassword);

        tPassword = new JTextField("");
        tPassword.setToolTipText("insert password");
        tPassword.setFont(new Font("Arial", Font.PLAIN, 15));
        tPassword.setBounds(40, 220, 400, 25);
        getContentPane().add(tPassword);

        lFeedback = new JLabel("");
        lFeedback.setBackground(Color.GRAY);
        lFeedback.setFont(new Font("Calibri", Font.PLAIN, 13));
        lFeedback.setHorizontalAlignment(SwingConstants.CENTER);
        lFeedback.setBounds(34, 270, 300, 25);
        getContentPane().add(lFeedback);

        JButton bLogin = new JButton("Login");
        bLogin.setBounds(140, 290, 88, 25);
        getContentPane().add(bLogin);
        bLogin.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tEmail.getText().equals("") || tPassword.getText().equals("")) {
                    lFeedback.setText("Write a mail and a password");
                } else {
                    Thread tLogin = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                if (controller.login(tEmail.getText(), tPassword.getText())) {
                                    lFeedback.setText("Log in OK");
                                    dispose();
                                } else {
                                    lFeedback.setText("Error in log in");
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                    tLogin.start();
                }
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
    }
}