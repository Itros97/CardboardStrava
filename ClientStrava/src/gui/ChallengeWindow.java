package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChallengeWindow extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JList list;//declaramos La Lista
    private DefaultListModel model;//declaramos el Modelo
    private JScrollPane scrollList;

    /**
     * Create the frame.
     */
    public ChallengeWindow() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 886, 514);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton bCheckAcceptedChallenges = new JButton("Check accepted challenges");
        bCheckAcceptedChallenges.setFont(new Font("Tahoma", Font.PLAIN, 14));
        bCheckAcceptedChallenges.setBounds(253, 82, 205, 49);
        contentPane.add(bCheckAcceptedChallenges);

        JButton bObtainActiveChallenges = new JButton("Obtain active challenges");
        bObtainActiveChallenges.setFont(new Font("Tahoma", Font.PLAIN, 14));
        bObtainActiveChallenges.setBounds(253, 170, 205, 49);
        contentPane.add(bObtainActiveChallenges);

        JButton btnAcceptChallenge = new JButton("Accept Challenge");
        btnAcceptChallenge.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnAcceptChallenge.setBounds(253, 256, 205, 49);
        contentPane.add(btnAcceptChallenge);

        JLabel lblNewLabel = new JLabel("Name");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel.setBounds(474, 47, 64, 28);
        contentPane.add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(600, 50, 207, 28);
        contentPane.add(textField);
        textField.setColumns(10);

        JLabel lblSport = new JLabel("Start date");
        lblSport.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblSport.setBounds(474, 96, 100, 28);
        contentPane.add(lblSport);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(600, 99, 207, 28);
        contentPane.add(textField_1);

        JLabel lblDistanceInKm = new JLabel("End Date");
        lblDistanceInKm.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblDistanceInKm.setBounds(474, 159, 130, 28);
        contentPane.add(lblDistanceInKm);

        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(600, 159, 207, 28);
        contentPane.add(textField_2);

        JLabel lblDateOfStart = new JLabel("Distance");
        lblDateOfStart.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblDateOfStart.setBounds(474, 211, 98, 28);
        contentPane.add(lblDateOfStart);

        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(600, 214, 207, 28);
        contentPane.add(textField_3);

        JLabel lblStartHour = new JLabel("Aim time");
        lblStartHour.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblStartHour.setBounds(474, 276, 98, 28);
        contentPane.add(lblStartHour);

        textField_4 = new JTextField();
        textField_4.setColumns(10);
        textField_4.setBounds(600, 273, 207, 28);
        contentPane.add(textField_4);

        JLabel lblDuration = new JLabel("Sport");
        lblDuration.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblDuration.setBounds(474, 323, 98, 28);
        contentPane.add(lblDuration);

        textField_5 = new JTextField();
        textField_5.setColumns(10);
        textField_5.setBounds(600, 326, 207, 28);
        contentPane.add(textField_5);

        JButton btnCreateTrainingSession = new JButton("Create Challenge");
        btnCreateTrainingSession.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnCreateTrainingSession.setBounds(508, 393, 181, 49);
        contentPane.add(btnCreateTrainingSession);

        JButton bBack = new JButton("Back");
        bBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
        bBack.setBounds(720, 393, 70, 49);
        contentPane.add(bBack);
        bBack.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        list = new JList();
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION );
        model = new DefaultListModel();
        list.setModel(model);
        scrollList = new JScrollPane();
        scrollList.setBounds(20, 120,220, 80);
        list.setBounds(20, 20,220, 435);
        contentPane.add(list);
    }
}