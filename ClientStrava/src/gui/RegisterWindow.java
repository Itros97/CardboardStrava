package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterWindow extends JFrame {

    private JPanel contentPane;
    private JButton btnNewButton;
    private JButton btnNewButton_1;
    private JLabel lblNewLabel;
    private JLabel lblName;
    private JTextField textField;
    private JTextField textField_1;
    private JLabel lblPassword;
    private JLabel lblBirthdate;
    private JTextField textField_2;
    private JTextField textField_3;
    private JLabel lblWeightInKg;
    private JLabel lblHeightInCm;
    private JTextField textField_4;
    private JTextField textField_5;
    private JLabel lblMaxHeartRate;
    private JLabel lblReposeHeartRate;
    private JTextField textField_6;
    private JTextField textField_7;
    private JButton btnRegister;
    private JButton btnBack;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    RegisterWindow frame = new RegisterWindow();
                    frame.setTitle("Register Window");
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
    public RegisterWindow() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 813, 596);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        btnNewButton = new JButton("GOOGLE");
        //btnNewButton.setBackground(Color.RED);
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnNewButton.setBounds(10, 21, 365, 37);
        contentPane.add(btnNewButton);

        btnNewButton_1 = new JButton("FACEBOOK");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        //btnNewButton_1.setBackground(Color.BLUE);
        btnNewButton_1.setBounds(413, 21, 375, 37);
        contentPane.add(btnNewButton_1);

        lblNewLabel = new JLabel("Email");
        lblNewLabel.setBackground(Color.GRAY);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel.setBounds(10, 85, 365, 26);
        contentPane.add(lblNewLabel);

        lblName = new JLabel("Name");
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblName.setBounds(413, 85, 365, 26);
        contentPane.add(lblName);

        textField = new JTextField();
        textField.setBounds(10, 121, 365, 26);
        contentPane.add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(413, 121, 365, 26);
        contentPane.add(textField_1);

        lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblPassword.setBackground(Color.GRAY);
        lblPassword.setBounds(10, 177, 365, 26);
        contentPane.add(lblPassword);

        lblBirthdate = new JLabel("Birthdate");
        lblBirthdate.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblBirthdate.setBounds(413, 177, 365, 26);
        contentPane.add(lblBirthdate);

        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(10, 224, 365, 26);
        contentPane.add(textField_2);

        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(413, 224, 365, 26);
        contentPane.add(textField_3);

        lblWeightInKg = new JLabel("Weight in kg (optional)");
        lblWeightInKg.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblWeightInKg.setBackground(Color.GRAY);
        lblWeightInKg.setBounds(10, 293, 365, 26);
        contentPane.add(lblWeightInKg);

        lblHeightInCm = new JLabel("Height in cm (optional)");
        lblHeightInCm.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblHeightInCm.setBackground(Color.GRAY);
        lblHeightInCm.setBounds(413, 293, 365, 26);
        contentPane.add(lblHeightInCm);

        textField_4 = new JTextField();
        textField_4.setColumns(10);
        textField_4.setBounds(10, 329, 365, 26);
        contentPane.add(textField_4);

        textField_5 = new JTextField();
        textField_5.setColumns(10);
        textField_5.setBounds(413, 329, 365, 26);
        contentPane.add(textField_5);

        lblMaxHeartRate = new JLabel("Max heart rate in b/min (optional)");
        lblMaxHeartRate.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblMaxHeartRate.setBackground(Color.GRAY);
        lblMaxHeartRate.setBounds(10, 398, 365, 26);
        contentPane.add(lblMaxHeartRate);

        lblReposeHeartRate = new JLabel("Repose heart rate in b/min (optional)");
        lblReposeHeartRate.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblReposeHeartRate.setBackground(Color.GRAY);
        lblReposeHeartRate.setBounds(413, 398, 365, 26);
        contentPane.add(lblReposeHeartRate);

        textField_6 = new JTextField();
        textField_6.setColumns(10);
        textField_6.setBounds(10, 434, 365, 26);
        contentPane.add(textField_6);

        textField_7 = new JTextField();
        textField_7.setColumns(10);
        textField_7.setBounds(413, 434, 365, 26);
        contentPane.add(textField_7);

        btnRegister = new JButton("Register");
        btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 15));
        //btnRegister.setBackground(Color.BLACK);
        btnRegister.setBounds(10, 508, 365, 26);
        contentPane.add(btnRegister);

        btnBack = new JButton("Back");
        btnBack.setFont(new Font("Tahoma", Font.PLAIN, 15));
        //btnBack.setBackground(Color.BLACK);
        btnBack.setBounds(413, 508, 375, 26);
        contentPane.add(btnBack);
    }
}