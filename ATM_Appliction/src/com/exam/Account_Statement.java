package com.exam;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

class Account_Statement_demo extends JFrame {

    private Container c;
    private JPanel panel;
    JLabel iconlabel, hlabel, label1, label2, label3, label4, label5, label6, label7, label8, label9, label10, label11, label12, label13, label14, label15, label16, label17, label18, label19, label20;
    JTable table;
    private JScrollPane scroll;
    DefaultTableModel model;
    private String[] col = {"Date", "Description", "Withdrawl", "Deposit", "Balance"};
    private Object[] data = new Object[5];
    private ImageIcon icon;
    private Font font, font2, font3;
    long ac_no;

    Account_Statement_demo() {

        initcomponents();
        settable();

    }

    public void settable() {
        ac_no = LoginPage.ac_no;
        System.out.println(ac_no);

        model = new DefaultTableModel();
        model.setColumnIdentifiers(col);
        table = new JTable();
        table.setModel(model);
        table.getColumnModel().getColumn(0).setPreferredWidth(80);
        table.getColumnModel().getColumn(1).setPreferredWidth(140);
        scroll = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setBounds(0, 210, 530, 200);
        panel.add(scroll);

    }

    public void initcomponents() {
        font = new Font("Monospaced", Font.BOLD, 22);
        font2 = new Font("Monospaced", Font.BOLD, 12);
        font3 = new Font("Monospaced", Font.BOLD, 15);
        Border border = BorderFactory.createLineBorder(Color.yellow, 1);

        icon = new ImageIcon("src/Images/bankname3.png");
        iconlabel = new JLabel(icon);
        iconlabel.setBounds(115, 0, icon.getIconWidth(), icon.getIconHeight());
        hlabel = new JLabel("Statement of Account");
        hlabel.setBounds(140, 60, 270, 40);
        hlabel.setFont(font);

        label1 = new JLabel("Period From :");
        label1.setBounds(280, 120, 100, 20);
        label1.setFont(font2);
//        label1.setBorder(border);
        //
        label2 = new JLabel("11-12-10 To 13-12-10");
        label2.setBounds(382, 120, 150, 20);
        label2.setFont(font2);
//        label2.setBorder(border);

        label3 = new JLabel("Account No  :");
        label3.setBounds(280, 140, 100, 20);
        label3.setFont(font2);
//        label3.setBorder(border);
        //
        label4 = new JLabel("1256215632455");
        label4.setBounds(382, 140, 150, 20);
        label4.setFont(font2);
//        label4.setBorder(border);

        label5 = new JLabel("Account Type:");
        label5.setBounds(280, 160, 100, 20);
        label5.setFont(font2);
//        label5.setBorder(border);
        //
        label6 = new JLabel("1256215632455");
        label6.setBounds(382, 160, 150, 20);
        label6.setFont(font2);
//        label6.setBorder(border);

        label7 = new JLabel("Currency    :");
        label7.setBounds(280, 180, 100, 20);
        label7.setFont(font2);
//        label7.setBorder(border);
        //
        label8 = new JLabel("BDT");
        label8.setBounds(382, 180, 150, 20);
        label8.setFont(font2);
//        label8.setBorder(border);

        label9 = new JLabel("Md. Shamim Hossain");
        label9.setBounds(5, 120, 180, 20);
        label9.setFont(font3);
//        label9.setBorder(border);
        //
        label10 = new JLabel("Badda Link Road");
        label10.setBounds(5, 140, 180, 20);
        label10.setFont(font2);
//        label10.setBorder(border);
        //
        label11 = new JLabel("Dhaka-1212");
        label11.setBounds(5, 160, 180, 20);
        label11.setFont(font2);
//        label11.setBorder(border);

        label12 = new JLabel("Total Withdraw : ");
        label12.setBounds(5, 420, 125, 20);
        label12.setFont(font2);
//        label12.setBorder(border);
        //
        label13 = new JLabel("1,00,000");
        label13.setBounds(130, 420, 100, 20);
        label13.setFont(font2);
//        label13.setBorder(border);

        label14 = new JLabel("Total Deposit  : ");
        label14.setBounds(5, 440, 125, 20);
        label14.setFont(font2);
//        label14.setBorder(border);
        //
        label15 = new JLabel("1,00,000");
        label15.setBounds(130, 440, 100, 20);
        label15.setFont(font2);
//        label15.setBorder(border);

        label16 = new JLabel("Opening Balance : ");
        label16.setBounds(300, 420, 130, 20);
        label16.setFont(font2);
//        label16.setBorder(border);
        //
        label17 = new JLabel("1,00,000");
        label17.setBounds(430, 420, 100, 20);
        label17.setFont(font2);
//        label17.setBorder(border);

        label18 = new JLabel("Closing Balance : ");
        label18.setBounds(300, 440, 130, 20);
        label18.setFont(font2);
//        label18.setBorder(border);
        //
        label19 = new JLabel("1,00,000");
        label19.setBounds(430, 440, 100, 20);
        label19.setFont(font2);
//        label19.setBorder(border);

        label20 = new JLabel("---------------------- End ----------------------");
        label20.setBounds(90, 470, 350, 20);
        label20.setFont(font2);
//        label20.setBorder(border);

        panel = new JPanel();
        panel.setBounds(52, 0, 530, 500);
        panel.setBackground(new Color(234, 252, 250));
        panel.setLayout(null);
        panel.add(iconlabel);
        panel.add(hlabel);
        panel.add(label1);
        panel.add(label2);
        panel.add(label3);
        panel.add(label4);
        panel.add(label5);
        panel.add(label6);
        panel.add(label7);
        panel.add(label8);
        panel.add(label9);
        panel.add(label10);
        panel.add(label11);
        panel.add(label12);
        panel.add(label13);
        panel.add(label14);
        panel.add(label15);
        panel.add(label16);
        panel.add(label17);
        panel.add(label18);
        panel.add(label19);
        panel.add(label20);

        this.setSize(650, 600);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
//        this.setVisible(true);
        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(new Color(227, 245, 243));
        c.add(panel);
    }


}

public class Account_Statement {

    public static void main(String[] args) throws Exception {
        String str = "javax.swing.plaf.nimbus.NimbusLookAndFeel";
        UIManager.setLookAndFeel(str);
        Account_Statement_demo sdemo = new Account_Statement_demo();
        sdemo.setVisible(true);

    }

}
