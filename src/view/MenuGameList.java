package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.Controller;
import model.Games;

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

        Games[] games = controller.getGames();

        JPanel[] panels = new JPanel[games.length];
        for (int i = 0; i < games.length; i++) {
            JPanel panel = new JPanel();
            panel.setLayout(null);
            panel.setSize(50, 100);

            if (i == 0) {
                panel.setLocation(5, 5);
            } else {
                panel.setLocation(
                    panels[i - 1].getX() + panels[i - 1].getWidth() + 5,
                    panels[i - 1].getY()
                );

                if (panel.getX() + panel.getWidth() + 5 > this.getWidth()) {
                    panel.setLocation(
                        5,
                        panels[i - 1].getY() + panels[i - 1].getHeight() + 5
                    );
                }
            }

            panel.setBackground(Color.CYAN);
            this.add(panel);
        }

        this.add(buttonTransaction);
    }
}
