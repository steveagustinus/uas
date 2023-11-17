package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.Controller;

public class MenuLogin extends JFrame {
    private Controller controller = new Controller();

    public MenuLogin() {
        initializeComponent();
        showMenuLogin();
    }

    public void showMenuLogin() {
        this.setVisible(true);
    }

    public void initializeComponent() {
        this.setTitle("Menu Login");
        this.setLayout(null);
        this.setSize(265, 150);

        JLabel labelEmail = new JLabel("Email");
        labelEmail.setBounds(5, 5, 100, 20);

        JLabel labelPassword = new JLabel("Password");
        labelPassword.setBounds(5, 30, 100, 20);

        JTextField fieldEmail = new JTextField();
        fieldEmail.setSize(150, 20);
        fieldEmail.setLocation(105, 5);

        JPasswordField fieldPassword = new JPasswordField();
        fieldPassword.setSize(150, 20);
        fieldPassword.setLocation(105, 30);

        JButton buttonLogin = new JButton("Login");
        buttonLogin.setBounds(5, 55, 100, 30);

        buttonLogin.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (controller.login(fieldEmail.getText(), fieldPassword.getText()) != null) {
                    JOptionPane.showMessageDialog(null, "Login berhasil!", "Login", JOptionPane.PLAIN_MESSAGE);
                    close();
                } else {
                    JOptionPane.showMessageDialog(null, "Email atau password tidak cocok!", "Login", JOptionPane.ERROR_MESSAGE);
                }
            }

        });
        this.add(labelEmail);
        this.add(labelPassword);
        this.add(fieldEmail);
        this.add(fieldPassword);
        this.add(buttonLogin);
    }

    public void close() {
        this.setVisible(false);
        this.dispose();
    }
}
