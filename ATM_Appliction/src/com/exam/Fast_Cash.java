package com.exam;

import com.sun.corba.se.pept.transport.ContactInfo;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
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

class Fast_cash_dmeo extends JFrame implements ActionListener {

    private Container c;
    private JPanel panel;
    private JLabel iconlabel1, hlabel;
    private ImageIcon icon2;
    private JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, backbtn;
    private Font font, font2;
    private Cursor cursor;
    private PreparedStatement pst, pst2;
    private ResultSet rst, rst2;
    static long ac_no;
    double balance, ebalance, fbalance;
    String query, query2;

    Fast_cash_dmeo() {
        initcomponents();
    }

    public void initcomponents() {
        ac_no = LoginPage.ac_no;
        System.out.println(ac_no);
        font = new Font("Monospaced", Font.BOLD, 20);
        font2 = new Font("Monospaced", Font.BOLD, 16);
        cursor = new Cursor(Cursor.HAND_CURSOR);

        hlabel = new JLabel("Please Select Instance Withdrawl Amount!");
        hlabel.setBounds(20, 40, 490, 50);
        hlabel.setFont(font);

        icon2 = new ImageIcon("src/Images/man.png");
        iconlabel1 = new JLabel(icon2);
        iconlabel1.setBounds(215, 200, icon2.getIconWidth(), icon2.getIconHeight());

        btn1 = new JButton("TK.500");
        btn1.setBounds(60, 140, 180, 40);
        btn1.setFont(font2);
        btn1.setCursor(cursor);
        //
        btn2 = new JButton("TK.1000");
        btn2.setBounds(270, 140, 180, 40);
        btn2.setFont(font2);
        btn2.setCursor(cursor);

        btn3 = new JButton("TK.2000");
        btn3.setBounds(20, 230, 180, 40);
        btn3.setFont(font2);
        btn3.setCursor(cursor);

        //
        btn4 = new JButton("TK.5000");
        btn4.setBounds(325, 230, 180, 40);
        btn4.setFont(font2);
        btn4.setCursor(cursor);

        btn5 = new JButton("TK.10000");
        btn5.setBounds(60, 320, 180, 40);
        btn5.setFont(font2);
        btn5.setCursor(cursor);

        //
        btn6 = new JButton("TK.20000");
        btn6.setBounds(270, 320, 180, 40);
        btn6.setFont(font2);
        btn6.setCursor(cursor);

        btn7 = new JButton("EXIT");
        btn7.setBounds(165, 400, 180, 40);
        btn7.setFont(font2);
        btn7.setCursor(cursor);

        backbtn = new JButton("<-Back");
        backbtn.setBounds(52, 520, 80, 30);
        backbtn.setFont(font2);
        backbtn.setBorder(BorderFactory.createEmptyBorder());
        backbtn.setBackground(new Color(227, 245, 243));
        backbtn.setFocusable(false);
        backbtn.setCursor(cursor);

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
        c.add(backbtn);

        //----add Listener-----
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        btn4.addActionListener(this);
        btn5.addActionListener(this);
        btn6.addActionListener(this);
        btn7.addActionListener(this);
        backbtn.addActionListener(this);
    }

    public void fastWithdraw() {
        try {
            Connection_data connection = new Connection_data();

            query = "select balance from transaction_details where account_no=? and t_date =(select max(t_date) from transaction_details where account_no=?)";
            pst = connection.conn.prepareStatement(query);
            pst.setLong(1, ac_no);
            pst.setLong(2, ac_no);
            rst = pst.executeQuery();
            if (rst.next()) {
                balance = rst.getDouble(1);
                System.out.println(balance);
            }
            fbalance = balance - ebalance;

            query2 = "insert into transaction_details values(?,sysdate,to_char(sysdate,'hh:mi:ss am'),?,?,?,?)";
            pst2 = connection.conn.prepareStatement(query2);
            pst2.setLong(1, ac_no);
            pst2.setString(2, "Badda Link-Road ATM");
            pst2.setDouble(3, ebalance);
            pst2.setDouble(4, 0.00);
            pst2.setDouble(5, fbalance);
            rst2 = pst2.executeQuery();
            if (rst2.next()) {
                JOptionPane.showMessageDialog(null, ebalance + " Credited Succesfully!" + "\n"
                        + "Your Total Balance is TK." + fbalance);
            }

        } catch (Exception ev) {
            ev.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn1) {
            ebalance = 500;
            fastWithdraw();
        } else if (e.getSource() == btn2) {
            ebalance = 1000;
            fastWithdraw();
        } else if (e.getSource() == btn3) {
            ebalance = 2000;
            fastWithdraw();
        } else if (e.getSource() == btn4) {
            ebalance = 5000;
            fastWithdraw();
        } else if (e.getSource() == btn5) {
            ebalance = 10000;
            fastWithdraw();
        } else if (e.getSource() == btn6) {
            ebalance = 20000;
            fastWithdraw();
        } else if (e.getSource() == btn7) {
            System.exit(0);
        } else if (e.getSource() == backbtn) {
            new Transaction_menu_page();
            dispose();
        }
    }

}

public class Fast_Cash {

    public static void main(String[] args) throws Exception {
        String str = "javax.swing.plaf.nimbus.NimbusLookAndFeel";
        UIManager.setLookAndFeel(str);
        new Fast_cash_dmeo();
    }

}
