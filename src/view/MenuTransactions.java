package view;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.Controller;
import controller.Controller.Table;

public class MenuTransactions extends JFrame {
    private Controller controller = new Controller();

    public MenuTransactions() {
        initializeComponent();
        showMenuTransactions();
    }

    public void showMenuTransactions() {
        this.setVisible(true);
    }

    public void initializeComponent() {
        this.setSize(1000, 600);
        
        Table table = controller.getTransactions("1");
        if (table == null) {
            return;
        }

        DefaultTableModel tableModel = new DefaultTableModel(table.columns, 0);

        for (int i = 0; i < table.data.length; i++) {
            tableModel.addRow(table.data[i]);
        }

        JTable jTable = new JTable(tableModel);

        jTable.setSize(995, 595);
        jTable.setLocation(5, 5);

        this.add(jTable);
    }
}
