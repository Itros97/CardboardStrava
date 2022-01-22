package gui;

import controller.TrainingSessionController;
import data.DTO.TrainingSessionDTO;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;
import java.util.List;

public class TrainingSessionWindow extends JFrame {
    private final TrainingSessionController controller;

    private final JPanel contentPane;
    private final JTextField tTitle;
    private final JTextField tSport;
    private final JTextField tDistanceInKm;
    private final JTextField tYear;
    private final JTextField tMonth;
    private final JTextField tDay;
    private final JTextField tHour;
    private final JTextField tDuration;
    private final JList list;//declaramos La Lista
    private final DefaultListModel model;//declaramos el Modelo
    private final JScrollPane scrollList;

    /**
     * Create the frame.
     */
    public TrainingSessionWindow(TrainingSessionController trainingSessionController, String email) {
        this.controller = trainingSessionController;

        setTitle("Training Session Window");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 886, 514);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lTitle = new JLabel("Title");
        lTitle.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lTitle.setBounds(464, 47, 64, 28);
        contentPane.add(lTitle);

        tTitle = new JTextField("");
        tTitle.setBounds(600, 50, 207, 28);
        contentPane.add(tTitle);
        tTitle.setColumns(10);

        JLabel lSport = new JLabel("Sport");
        lSport.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lSport.setBounds(464, 96, 64, 28);
        contentPane.add(lSport);

        tSport = new JTextField("");
        tSport.setColumns(10);
        tSport.setBounds(600, 99, 207, 28);
        contentPane.add(tSport);

        JLabel lDistanceInKm = new JLabel("Distance in km");
        lDistanceInKm.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lDistanceInKm.setBounds(464, 159, 130, 28);
        contentPane.add(lDistanceInKm);

        tDistanceInKm = new JTextField("");
        tDistanceInKm.setColumns(10);
        tDistanceInKm.setBounds(600, 159, 207, 28);
        contentPane.add(tDistanceInKm);

        JLabel lDateOfStart = new JLabel("Time of start");
        lDateOfStart.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lDateOfStart.setBounds(464, 211, 98, 28);
        contentPane.add(lDateOfStart);

        tYear = new JTextField("Year");
        tYear.setColumns(10);
        tYear.setBounds(600, 214, 51, 28);
        contentPane.add(tYear);

        tMonth = new JTextField("Month");
        tMonth.setColumns(10);
        tMonth.setBounds(651, 214, 51, 28);
        contentPane.add(tMonth);

        tDay = new JTextField("Day");
        tDay.setColumns(10);
        tDay.setBounds(702, 214, 51, 28);
        contentPane.add(tDay);

        tHour = new JTextField("Hour");
        tHour.setColumns(10);
        tHour.setBounds(753, 214, 51, 28);
        contentPane.add(tHour);

        JLabel lDuration = new JLabel("Duration in min");
        lDuration.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lDuration.setBounds(464, 323, 108, 28);
        contentPane.add(lDuration);

        tDuration = new JTextField("");
        tDuration.setColumns(10);
        tDuration.setBounds(600, 326, 207, 28);
        contentPane.add(tDuration);

        list = new JList();
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION );
        model = new DefaultListModel();
        list.setModel(model);
        scrollList = new JScrollPane();
        scrollList.setBounds(20, 120,220, 80);
        list.setBounds(20, 20,220, 435);
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

        JButton bCreateTrainingSession = new JButton("Create Training Session");
        bCreateTrainingSession.setFont(new Font("Tahoma", Font.PLAIN, 14));
        bCreateTrainingSession.setBounds(508, 393, 181, 49);
        contentPane.add(bCreateTrainingSession);
        bCreateTrainingSession.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                GregorianCalendar timeOfStart = new GregorianCalendar();
                timeOfStart.set(Integer.parseInt(tYear.getText()), Integer.parseInt(tMonth.getText()), Integer.parseInt(tDay.getText()), Integer.parseInt(tHour.getText()), 0);
                java.time.LocalDateTime.now();
                controller.createTrainingSession(tTitle.getText(),
                        tSport.getText(), Double.parseDouble(tDistanceInKm.getText()),
                        timeOfStart, Double.parseDouble(tDuration.getText()), email);
            }
        });

        JButton bConsultSessions = new JButton("Consult all sessions");
        bConsultSessions.setFont(new Font("Tahoma", Font.PLAIN, 14));
        bConsultSessions.setBounds(258, 82, 181, 49);
        contentPane.add(bConsultSessions);
        bConsultSessions.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(" - Getting all the training sessions...");
                List<TrainingSessionDTO> sessions = controller.getTrainingSessions();
                if (sessions != null) {
                    Thread tSessions = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            model.removeAllElements();
                            for (TrainingSessionDTO session : sessions) {
                                model.addElement(session.getTitle());
                            }
                        }
                    });
                    tSessions.start();
                }
            }
        });

        JButton bConsultOwnSessions = new JButton("Consult own sessions");
        bConsultOwnSessions.setFont(new Font("Tahoma", Font.PLAIN, 14));
        bConsultOwnSessions.setBounds(258, 256, 181, 49);
        contentPane.add(bConsultOwnSessions);
        bConsultOwnSessions.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(" - Getting own training sessions...");
                List<TrainingSessionDTO> ownSessions = controller.getOwnTrainingSessions(email);
                if (ownSessions != null) {
                    Thread tAcceptedSessions = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            model.removeAllElements();
                            for (TrainingSessionDTO session : ownSessions) {
                                model.addElement(session.getTitle());
                            }
                        }
                    });
                    tAcceptedSessions.start();
                }
            }
        });
    }
}