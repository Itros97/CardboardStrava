package gui;

import controller.ChallengeController;
import controller.LoginController;
import data.DTO.ChallengeDTO;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;
import java.util.List;

public class ChallengeWindow extends JFrame {
    ChallengeController controller;

    private final JPanel contentPane;
    private final JTextField tName;
    private final JTextField tYear1;
    private final JTextField tYear2;
    private final JTextField tMonth1;
    private final JTextField tMonth2;
    private final JTextField tDay1;
    private final JTextField tDay2;
    private final JTextField tDistance;
    private final JTextField tAimTime;
    private final JTextField tSport;
    private final JList list;//declaramos La Lista
    private final DefaultListModel model;//declaramos el Modelo

    /**
     * Create the frame.
     */
    public ChallengeWindow(ChallengeController challengeController, LoginController loginController) {
        this.controller = challengeController;

        final String[] typeOfChallenge = {""};

        setTitle("Challenge Window");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 886, 514);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lName = new JLabel("Name");
        lName.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lName.setBounds(474, 47, 64, 28);
        contentPane.add(lName);

        tName = new JTextField("");
        tName.setBounds(600, 50, 207, 28);
        contentPane.add(tName);

        JLabel lStartDate = new JLabel("Start date");
        lStartDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lStartDate.setBounds(474, 96, 100, 28);
        contentPane.add(lStartDate);

        tYear1 = new JTextField("Year");
        tYear1.setBounds(600, 99, 66, 28);
        contentPane.add(tYear1);

        tMonth1 = new JTextField("Month");
        tMonth1.setBounds(670, 99, 66, 28);
        contentPane.add(tMonth1);

        tDay1 = new JTextField("Day");
        tDay1.setBounds(740, 99, 66, 28);
        contentPane.add(tDay1);

        JLabel lDistanceInKm = new JLabel("End Date");
        lDistanceInKm.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lDistanceInKm.setBounds(474, 159, 130, 28);
        contentPane.add(lDistanceInKm);

        tYear2 = new JTextField("Year");
        tYear2.setBounds(600, 159, 66, 28);
        contentPane.add(tYear2);

        tMonth2 = new JTextField("Month");
        tMonth2.setBounds(670, 159, 66, 28);
        contentPane.add(tMonth2);

        tDay2 = new JTextField("Day");
        tDay2.setBounds(740, 159, 66, 28);
        contentPane.add(tDay2);

        JLabel lDistance = new JLabel("Distance");
        lDistance.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lDistance.setBounds(474, 211, 98, 28);
        contentPane.add(lDistance);

        tDistance = new JTextField("");
        tDistance.setBounds(600, 214, 207, 28);
        contentPane.add(tDistance);

        JLabel lAviso = new JLabel("Fill distance or time optionally, but not both");
        lAviso.setFont(new Font("Tahoma", Font.PLAIN, 10));
        lAviso.setBounds(474, 244, 400, 28);
        contentPane.add(lAviso);

        JLabel lAimTime = new JLabel("Aim time");
        lAimTime.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lAimTime.setBounds(474, 276, 98, 28);
        contentPane.add(lAimTime);

        tAimTime = new JTextField("");
        tAimTime.setBounds(600, 273, 207, 28);
        contentPane.add(tAimTime);

        JLabel lSport = new JLabel("Sport");
        lSport.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lSport.setBounds(474, 323, 98, 28);
        contentPane.add(lSport);

        tSport = new JTextField("");
        tSport.setBounds(600, 326, 207, 28);
        contentPane.add(tSport);

        list = new JList();
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION );
        model = new DefaultListModel();
        list.setModel(model);
        list.setBounds(20, 20,430, 335);
        contentPane.add(list);

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

        JButton bCreateChallenge = new JButton("Create Challenge");
        bCreateChallenge.setFont(new Font("Tahoma", Font.PLAIN, 14));
        bCreateChallenge.setBounds(498, 393, 181, 49);
        contentPane.add(bCreateChallenge);
        bCreateChallenge.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                GregorianCalendar dateOfStart = new GregorianCalendar();
                GregorianCalendar dateOfEnd = new GregorianCalendar();
                dateOfStart.set(Integer.parseInt(tYear1.getText()), Integer.parseInt(tMonth1.getText()), Integer.parseInt(tDay1.getText()));
                dateOfEnd.set(Integer.parseInt(tYear2.getText()), Integer.parseInt(tMonth2.getText()), Integer.parseInt(tDay2.getText()));

                if (tDistance.getText().equals("")) {
                    typeOfChallenge[0] = "time";
                } else if (tAimTime.getText().equals("")) {
                    typeOfChallenge[0] = "distance";
                }

                if (tDistance.getText().equals("")) {
                    controller.createChallenge(typeOfChallenge[0], tName.getText(),
                            dateOfStart, dateOfEnd, tSport.getText(),
                            0,
                            Integer.parseInt(tAimTime.getText()));
                } else {
                    controller.createChallenge(typeOfChallenge[0], tName.getText(),
                            dateOfStart, dateOfEnd, tSport.getText(),
                            Integer.parseInt(tDistance.getText()),
                            0);
                }

                //TIENE QUE APARECER UN JLABEL DE FEEDBACK EN LA VENTANA
            }
        });

        JButton bObtainActiveChallenges = new JButton("Obtain active challenges");
        bObtainActiveChallenges.setFont(new Font("Tahoma", Font.PLAIN, 10));
        bObtainActiveChallenges.setBounds(24, 393, 140, 49);
        contentPane.add(bObtainActiveChallenges);
        bObtainActiveChallenges.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(" - Getting all active challenges...");
                List<ChallengeDTO> activeChallenges = controller.getUnfinishedChallenges();
                if (activeChallenges != null) {
                    Thread tActiveChallenges = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            model.removeAllElements();
                            for (ChallengeDTO ch : activeChallenges) {
                                model.addElement(ch.getName() + ": " + ch.getSport() + " ");
                            }
                        }
                    });
                    tActiveChallenges.start();
                }
            }
        });

        JButton bCheckAcceptedChallenges = new JButton("Check accepted challenges");
        bCheckAcceptedChallenges.setFont(new Font("Tahoma", Font.PLAIN, 10));
        bCheckAcceptedChallenges.setBounds(172, 393, 155, 49);
        contentPane.add(bCheckAcceptedChallenges);
        bCheckAcceptedChallenges.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(" - Getting accepted challenges...");
                List<ChallengeDTO> acceptedChallenges = controller.getAcceptedChallenges(loginController.getMail());
                if (acceptedChallenges != null) {
                    Thread tAcceptedChallenges = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            model.removeAllElements();
                            for (ChallengeDTO ch : acceptedChallenges) {
                                model.addElement(ch.getName() + ": " + ch.getSport());
                            }
                        }
                    });
                    tAcceptedChallenges.start();
                }
            }
        });

        JButton bAcceptChallenge = new JButton("Accept Challenge");
        bAcceptChallenge.setFont(new Font("Tahoma", Font.PLAIN, 10));
        bAcceptChallenge.setBounds(336, 393, 110, 49);
        contentPane.add(bAcceptChallenge);
        bAcceptChallenge.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.acceptChallenge(tName.getText(), loginController.getMail());

                //TIENE QUE APARECER UN JLABEL DE FEEDBACK EN LA VENTANA
            }
        });
    }
}