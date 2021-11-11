package gui;

import javax.swing.*;

public class home {

    private JTextField ifYouAreAnTextField;
    private JTextField ifYouArenTTextField;
    private JButton trainingSessionsButton;
    private JButton challengesButton;
    private JButton logOutButton;
    private JButton logInButton;
    private JButton registerButton;
    private JPanel panelhome;

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("Register User");
        frame.setContentPane(new home().panelhome);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
