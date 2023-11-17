package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import controller.Controller;

public class MenuGameList extends JFrame {
    private Controller controller = new Controller();

    public MenuGameList() {
        initializeComponent();
        showMenuGameList();
    }

    public void showMenuGameList() {
        this.setVisible(true);
    }

    public void initializeComponent() {
        this.setSize(500, 500);
        this.setLayout(null);

        JButton buttonTransaction = new JButton("Transactions");
        buttonTransaction.setSize(this.getWidth() - 10, 30);
        buttonTransaction.setLocation(5, 5);

        buttonTransaction.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new MenuTransactions();
            }

        });

        this.add(buttonTransaction);
    }
}
