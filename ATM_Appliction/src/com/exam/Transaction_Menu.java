package com.exam;

import com.sun.corba.se.pept.transport.ContactInfo;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

class Transaction_menu_page extends JFrame implements ActionListener {

    private Container c;
    private JPanel panel;
    private JLabel iconlabel1, hlabel;
    private ImageIcon icon1, icon2;
    private JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7;
    private Font font, font2;
    private PreparedStatement pst;
    private ResultSet rst;
    static long ac_no, ac_no2;
    private String query;
    private double balance;

    Transaction_menu_page() {
        initcomponents();
    }

    public void initcomponents() {
        ac_no = LoginPage.ac_no;
        if (ac_no < Withdrawl_page_demo.ac_no) {
            ac_no = Withdrawl_page_demo.ac_no;
        } else if (ac_no < Deposit_page_demo.ac_no) {
            ac_no = Deposit_page_demo.ac_no;
        } else if (ac_no < Fast_cash_dmeo.ac_no) {
            ac_no = Fast_cash_dmeo.ac_no;
        } else if (ac_no < Account_statement_forms.ac_no) {
            ac_no = Account_statement_forms.ac_no;
        }
        System.out.println(ac_no);
        font = new Font("Monospaced", Font.BOLD, 20);
        font2 = new Font("Monospaced", Font.BOLD, 16);

        icon1 = new ImageIcon("src/Images/atm2.png");

        hlabel = new JLabel("Please Select Preferred Transaction");
        hlabel.setBounds(20, 40, 490, 50);
        hlabel.setFont(font);
        hlabel.setIcon(icon1);
        hlabel.setBackground(new Color(227, 245, 243));
        hlabel.setOpaque(true);
        hlabel.setBorder(BorderFactory.createLineBorder(new Color(158, 200, 195), 2, true));

        icon2 = new ImageIcon("src/Images/money.png");
        iconlabel1 = new JLabel(icon2);
        iconlabel1.setBounds(215, 200, icon2.getIconWidth(), icon2.getIconHeight());

        btn1 = new JButton("DEPOSIT");
        btn1.setBounds(60, 140, 180, 40);
        btn1.setFont(font2);
        //
        btn2 = new JButton("CASH WITHDRAWL");
        btn2.setBounds(270, 140, 180, 40);
        btn2.setFont(font2);

        btn3 = new JButton("FAST CASH");
        btn3.setBounds(20, 230, 180, 40);
        btn3.setFont(font2);
        //
        btn4 = new JButton("MINI STAEMENT");
        btn4.setBounds(325, 230, 180, 40);
        btn4.setFont(font2);

        btn5 = new JButton("PIN CHANGE");
        btn5.setBounds(60, 320, 180, 40);
        btn5.setFont(font2);
        //
        btn6 = new JButton("BALANCE ENQUIRY");
        btn6.setBounds(270, 320, 180, 40);
        btn6.setFont(font2);

        btn7 = new JButton("EXIT");
        btn7.setBounds(165, 400, 180, 40);
        btn7.setFont(font2);

        panel = new JPanel();
        panel.setBounds(52, 0, 530, 500);
        panel.setBackground(new Color(234, 252, 250));
        panel.setLayout(null);
        panel.add(hlabel);
        panel.add(iconlabel1);
        panel.add(btn1);
        panel.add(btn2);
        panel.add(btn3);
        panel.add(btn4);
        panel.add(btn5);
        panel.add(btn6);
        panel.add(btn7);

        this.setSize(650, 600);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(new Color(227, 245, 243));
        c.add(panel);

        //----add Listener part------
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        btn4.addActionListener(this);
        btn5.addActionListener(this);
        btn6.addActionListener(this);
        btn7.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        Connection_data connection = new Connection_data();
        if (e.getSource() == btn1) {
            new Deposit_page_demo();
            dispose();
        } else if (e.getSource() == btn2) {
            new Withdrawl_page_demo();
            dispose();
        } else if (e.getSource() == btn3) {
            new Fast_cash_dmeo();
            dispose();
        } else if (e.getSource() == btn4) {
            new Account_statement_forms();
            dispose();
        } else if (e.getSource() == btn5) {
            new Change_pin_demo();
            dispose();
        } else if (e.getSource() == btn6) {
            Connection_data connection = new Connection_data();
            try {
                query = "select balance from transaction_details where account_no=? and t_date =(select max(t_date) from transaction_details where account_no=?)";
                pst = connection.conn.prepareStatement(query);
                pst.setLong(1, ac_no);
                pst.setLong(2, ac_no);
                rst = pst.executeQuery();
                if (rst.next()) {
                    balance = rst.getDouble(1);
                    JOptionPane.showMessageDialog(null, "Your Current Account Balane : " + balance);
                }
            } catch (Exception ev) {
                ev.printStackTrace();
            }
        } else {
            System.exit(0);
        }

    }

}

public class Transaction_Menu {

    public static void main(String[] args) throws Exception {
        String str = "javax.swing.plaf.nimbus.NimbusLookAndFeel";
        UIManager.setLookAndFeel(str);
        new Transaction_menu_page();

    }
}
