package gui;

import controller.ChallengeController;
import controller.LoginController;
import controller.RegisterController;
import controller.TrainingSessionController;
import ServiceLocator.ServiceLocator;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeWindowAndMain extends JFrame {
    private final JPanel contentPane;
    private final JLabel lWelcomeToStrava;
    private final JLabel lLogout;
    private final JLabel lLogin;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        ServiceLocator serviceLocator = new ServiceLocator();

        //args[0] = RMIRegistry IP
        //args[1] = RMIRegistry Port
        //args[2] = Service Name
        serviceLocator.setService(args[0], args[1], args[2]);

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    HomeWindowAndMain frame = new HomeWindowAndMain(serviceLocator);
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
    public HomeWindowAndMain(ServiceLocator serviceLocator) {
        LoginController loginController = new LoginController(serviceLocator);
        RegisterController registerController = new RegisterController(serviceLocator);
        ChallengeController challengeController = new ChallengeController(serviceLocator);
        TrainingSessionController trainingSessionController = new TrainingSessionController(serviceLocator);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 739, 468);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        lWelcomeToStrava = new JLabel("WELCOME TO STRAVA");
        lWelcomeToStrava.setBackground(Color.GRAY);
        lWelcomeToStrava.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lWelcomeToStrava.setHorizontalAlignment(SwingConstants.CENTER);
        lWelcomeToStrava.setBounds(10, 10, 324, 88);
        contentPane.add(lWelcomeToStrava);

        lLogout = new JLabel("");
        lLogout.setBackground(Color.GRAY);
        lLogout.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lLogout.setHorizontalAlignment(SwingConstants.CENTER);
        lLogout.setBounds(500, 30, 324, 88);
        contentPane.add(lLogout);

        lLogin = new JLabel("Welcome, user");
        lLogin.setBackground(Color.GRAY);
        lLogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lLogin.setBounds(37, 265, 800, 88);
        contentPane.add(lLogin);

        JButton bLogout = new JButton("Log out");
        bLogout.setFont(new Font("Tahoma", Font.PLAIN, 14));
        bLogout.setBounds(611, 10, 104, 40);
        contentPane.add(bLogout);
        bLogout.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Thread tLogout = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            if (!loginController.logout()) {
                                lLogout.setText("Log out OK");
                                lLogin.setText("You can now login again");
                            } else {
                                lLogout.setText("Error in log out");
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        //lLogout.setText("Log out OK");
                    }
                });
                tLogout.start();
            }
        });

        JButton bLogin = new JButton("Login");
        bLogin.setFont(new Font("Tahoma", Font.PLAIN, 13));
        bLogin.setBounds(32, 327, 104, 40);
        contentPane.add(bLogin);
        bLogin.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                    Thread tLogin = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            if (!loginController.getToken()) {
                                try {
                                    LoginWindow frame = new LoginWindow(loginController);
                                    frame.setVisible(true);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            } else {
                                lLogin.setText(loginController.getMail() + ", if you wish to log in with a different account, please logout first");
                            }
                        }
                    });
                    tLogin.start();
            }
        });

        JButton bRegister = new JButton("Register");
        bRegister.setFont(new Font("Tahoma", Font.PLAIN, 13));
        bRegister.setBounds(203, 327, 104, 40);
        contentPane.add(bRegister);
        bRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Thread tRegister = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            RegisterWindow frame = new RegisterWindow(registerController);
                            frame.setVisible(true);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                tRegister.start();
            }
        });

        JButton bChallenges = new JButton("Challenges");
        bChallenges.setFont(new Font("Tahoma", Font.PLAIN, 13));
        bChallenges.setBounds(402, 327, 104, 40);
        contentPane.add(bChallenges);
        bChallenges.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Thread tChallenge = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            ChallengeWindow frame = new ChallengeWindow(challengeController, loginController);
                            frame.setVisible(true);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                tChallenge.start();
            }
        });

        JButton bTrainingSessions = new JButton("Training Sessions");
        bTrainingSessions.setFont(new Font("Tahoma", Font.PLAIN, 13));
        bTrainingSessions.setBounds(552, 327, 139, 40);
        contentPane.add(bTrainingSessions);
        bTrainingSessions.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Thread tTrainingSession = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            TrainingSessionWindow frame = new TrainingSessionWindow(trainingSessionController, loginController);
                            frame.setVisible(true);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                tTrainingSession.start();
            }
        });
    }
}
