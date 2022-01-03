package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeWindow extends JFrame {

    private JPanel contentPane;
    private JLabel txtWelcomeToStrava;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    HomeWindow frame = new HomeWindow();
                    frame.setTitle("Home Window");
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public HomeWindow() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 739, 468);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        txtWelcomeToStrava = new JLabel();
        txtWelcomeToStrava.setBackground(Color.GRAY);
        txtWelcomeToStrava.setFont(new Font("Tahoma", Font.PLAIN, 17));
        txtWelcomeToStrava.setHorizontalAlignment(SwingConstants.CENTER);
        txtWelcomeToStrava.setText("WELCOME TO STRAVA");
        txtWelcomeToStrava.setBounds(10, 10, 324, 88);
        contentPane.add(txtWelcomeToStrava);

        JButton btnNewButton = new JButton("Log out");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnNewButton.setBounds(611, 10, 104, 40);
        contentPane.add(btnNewButton);
        btnNewButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JButton btnNewButton_1 = new JButton("Login");
        btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnNewButton_1.setBounds(32, 327, 104, 40);
        contentPane.add(btnNewButton_1);



        JButton btnNewButton_1_1 = new JButton("Register");
        btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnNewButton_1_1.setBounds(203, 327, 104, 40);
        contentPane.add(btnNewButton_1_1);

        JButton btnNewButton_1_2 = new JButton("Challenges");
        btnNewButton_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnNewButton_1_2.setBounds(402, 327, 104, 40);
        contentPane.add(btnNewButton_1_2);

        JButton btnNewButton_1_1_1 = new JButton("Training Sessions");
        btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnNewButton_1_1_1.setBounds(552, 327, 139, 40);
        contentPane.add(btnNewButton_1_1_1);
    }

}
