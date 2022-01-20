package gui;

import controller.RegisterController;
import data.domain.PasswordProfile;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;

public class RegisterWindow extends JFrame {
    private RegisterController controller;

    private JPanel contentPane;
    private JButton bGoogle;
    private JButton bFacebook;
    private JLabel lEmail;
    private JLabel lNickname;
    private JTextField tEmail;
    private JTextField tNickname;
    private JLabel lPassword;
    private JLabel lBirthdate;
    private JTextField tPassword;
    private JTextField tYear;
    private JTextField tMonth;
    private JTextField tDay;
    private JLabel lWeightInKg;
    private JLabel lHeightInCm;
    private JTextField tWeight;
    private JTextField tHeight;
    private JLabel lMaxHeartRate;
    private JLabel lReposeHeartRate;
    private JTextField tMaxHeartRate;
    private JTextField tReposeHeartRate;
    private JButton btnRegister;
    private JButton btnBack;
    private String registerType;

    /**
     * Create the frame.
     */
    public RegisterWindow(RegisterController registerController) {
        this.controller = registerController;

        registerType = "";

        setTitle("Register Window");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 813, 596);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        lEmail = new JLabel("Email");
        lEmail.setBackground(Color.GRAY);
        lEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lEmail.setBounds(10, 85, 365, 26);
        contentPane.add(lEmail);

        lNickname = new JLabel("Nickname");
        lNickname.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lNickname.setBounds(413, 85, 365, 26);
        contentPane.add(lNickname);

        tEmail = new JTextField("");
        tEmail.setBounds(10, 121, 365, 26);
        contentPane.add(tEmail);
        tEmail.setColumns(10);

        tNickname = new JTextField("");
        tNickname.setColumns(10);
        tNickname.setBounds(413, 121, 365, 26);
        contentPane.add(tNickname);

        lPassword = new JLabel("Password");
        lPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lPassword.setBackground(Color.GRAY);
        lPassword.setBounds(10, 177, 365, 26);
        contentPane.add(lPassword);

        lBirthdate = new JLabel("Birthdate");
        lBirthdate.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lBirthdate.setBounds(413, 177, 365, 26);
        contentPane.add(lBirthdate);

        tPassword = new JTextField("");
        tPassword.setColumns(10);
        tPassword.setBounds(10, 224, 365, 26);
        contentPane.add(tPassword);

        tYear = new JTextField("Year");
        tYear.setColumns(10);
        tYear.setBounds(413, 224, 120, 26);
        contentPane.add(tYear);

        tMonth = new JTextField("Month");
        tMonth.setColumns(10);
        tMonth.setBounds(533, 224, 120, 26);
        contentPane.add(tMonth);

        tDay = new JTextField("Day");
        tDay.setColumns(10);
        tDay.setBounds(653, 224, 120, 26);
        contentPane.add(tDay);

        lWeightInKg = new JLabel("Weight in kg (optional)");
        lWeightInKg.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lWeightInKg.setBackground(Color.GRAY);
        lWeightInKg.setBounds(10, 293, 365, 26);
        contentPane.add(lWeightInKg);

        lHeightInCm = new JLabel("Height in cm (optional)");
        lHeightInCm.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lHeightInCm.setBackground(Color.GRAY);
        lHeightInCm.setBounds(413, 293, 365, 26);
        contentPane.add(lHeightInCm);

        tWeight = new JTextField("");
        tWeight.setColumns(10);
        tWeight.setBounds(10, 329, 365, 26);
        contentPane.add(tWeight);

        tHeight = new JTextField("");
        tHeight.setColumns(10);
        tHeight.setBounds(413, 329, 365, 26);
        contentPane.add(tHeight);

        lMaxHeartRate = new JLabel("Max heart rate in b/min (optional)");
        lMaxHeartRate.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lMaxHeartRate.setBackground(Color.GRAY);
        lMaxHeartRate.setBounds(10, 398, 365, 26);
        contentPane.add(lMaxHeartRate);

        lReposeHeartRate = new JLabel("Repose heart rate in b/min (optional)");
        lReposeHeartRate.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lReposeHeartRate.setBackground(Color.GRAY);
        lReposeHeartRate.setBounds(413, 398, 365, 26);
        contentPane.add(lReposeHeartRate);

        tMaxHeartRate = new JTextField("");
        tMaxHeartRate.setColumns(10);
        tMaxHeartRate.setBounds(10, 434, 365, 26);
        contentPane.add(tMaxHeartRate);

        tReposeHeartRate = new JTextField("");
        tReposeHeartRate.setColumns(10);
        tReposeHeartRate.setBounds(413, 434, 365, 26);
        contentPane.add(tReposeHeartRate);

        bGoogle = new JButton("GOOGLE");
        //btnNewButton.setBackground(Color.RED);
        bGoogle.setFont(new Font("Tahoma", Font.PLAIN, 15));
        bGoogle.setBounds(10, 21, 365, 37);
        contentPane.add(bGoogle);
        bGoogle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                registerType = "google";
            }
        });

        bFacebook = new JButton("FACEBOOK");
        bFacebook.setFont(new Font("Tahoma", Font.PLAIN, 15));
        //btnNewButton_1.setBackground(Color.BLUE);
        bFacebook.setBounds(413, 21, 375, 37);
        contentPane.add(bFacebook);
        bFacebook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                registerType = "facebook";
            }
        });

        btnRegister = new JButton("Register");
        btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 15));
        //btnRegister.setBackground(Color.BLACK);
        btnRegister.setBounds(10, 508, 365, 26);
        contentPane.add(btnRegister);
        btnRegister.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                PasswordProfile p = new PasswordProfile();

                p.setEmail(tEmail.getText());
                p.setNickname(tNickname.getText());

                GregorianCalendar calendar = new GregorianCalendar();
                calendar.set(Integer.parseInt(tYear.getText()), Integer.parseInt(tMonth.getText()), Integer.parseInt(tDay.getText()));
                p.setBirthdate(calendar);
                p.setWeightKg(Double.parseDouble(tWeight.getText()));
                p.setHeightCm(Integer.parseInt(tHeight.getText()));
                p.setMaximumHeartRate(Integer.parseInt(tMaxHeartRate.getText()));
                p.setReposeHeartRate(Integer.parseInt(tReposeHeartRate.getText()));

                p.setRegisterType(registerType);

                p.setPassword(tPassword.getText());

                controller.register(p);
                //POR IMPLEMENTAR: un if para registrar Profiles o PasswordProfiles
            }
        });

        btnBack = new JButton("Back");
        btnBack.setFont(new Font("Tahoma", Font.PLAIN, 15));
        //btnBack.setBackground(Color.BLACK);
        btnBack.setBounds(413, 508, 375, 26);
        contentPane.add(btnBack);
        btnBack.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}