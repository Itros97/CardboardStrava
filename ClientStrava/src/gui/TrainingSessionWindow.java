package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class TrainingSessionWindow extends JFrame {

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
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TrainingSessionWindow frame = new TrainingSessionWindow();
                    frame.setTitle("Training Session Window");
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
    public TrainingSessionWindow() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 886, 514);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnNewButton = new JButton("Consult all sessions");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnNewButton.setBounds(258, 82, 181, 49);
        contentPane.add(btnNewButton);

        JButton btnConsultOwnSessions = new JButton("Consult own sessions");
        btnConsultOwnSessions.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnConsultOwnSessions.setBounds(258, 256, 181, 49);
        contentPane.add(btnConsultOwnSessions);

        JLabel lblNewLabel = new JLabel("Title");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel.setBounds(474, 47, 64, 28);
        contentPane.add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(600, 50, 207, 28);
        contentPane.add(textField);
        textField.setColumns(10);

        JLabel lblSport = new JLabel("Sport");
        lblSport.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblSport.setBounds(474, 96, 64, 28);
        contentPane.add(lblSport);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(600, 99, 207, 28);
        contentPane.add(textField_1);

        JLabel lblDistanceInKm = new JLabel("Distance in km");
        lblDistanceInKm.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblDistanceInKm.setBounds(474, 159, 130, 28);
        contentPane.add(lblDistanceInKm);

        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(600, 159, 207, 28);
        contentPane.add(textField_2);

        JLabel lblDateOfStart = new JLabel("Date of start");
        lblDateOfStart.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblDateOfStart.setBounds(474, 211, 98, 28);
        contentPane.add(lblDateOfStart);

        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(600, 214, 207, 28);
        contentPane.add(textField_3);

        JLabel lblStartHour = new JLabel("Start hour");
        lblStartHour.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblStartHour.setBounds(474, 276, 98, 28);
        contentPane.add(lblStartHour);

        textField_4 = new JTextField();
        textField_4.setColumns(10);
        textField_4.setBounds(600, 273, 207, 28);
        contentPane.add(textField_4);

        JLabel lblDuration = new JLabel("Duration");
        lblDuration.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblDuration.setBounds(474, 323, 98, 28);
        contentPane.add(lblDuration);

        textField_5 = new JTextField();
        textField_5.setColumns(10);
        textField_5.setBounds(600, 326, 207, 28);
        contentPane.add(textField_5);

        JButton btnCreateTrainingSession = new JButton("Create Training Session");
        btnCreateTrainingSession.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnCreateTrainingSession.setBounds(508, 393, 181, 49);
        contentPane.add(btnCreateTrainingSession);

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