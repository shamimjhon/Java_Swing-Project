package com.exam;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

class Withdrawl_page_demo extends JFrame implements ActionListener {

    private Container c;
    private JPanel panel;
    private JLabel hlabel1, hlabel, hlabel2, iconlabel;
    private ImageIcon icon, icon2;
    private JTextField field;
    private JButton btn1, btn2, btn3, backbtn;
    private Font font, font2;
    private Cursor cursor;
    private PreparedStatement pst, pst2;
    private ResultSet rst, rst2;
    static long ac_no;
    

    Withdrawl_page_demo() {
        initcomponents();
    }

    public void initcomponents() {
        ac_no = Transaction_menu_page.ac_no;
        System.out.println(ac_no);
        font = new Font("Monospaced", Font.BOLD, 20);
        font2 = new Font("Monospaced", Font.BOLD, 16);
        cursor = new Cursor(Cursor.HAND_CURSOR);

        icon2 = new ImageIcon("src/Images/notice.png");

        hlabel1 = new JLabel("Maximum Withdrawl Amount TK.20000!");
        hlabel1.setBounds(30, 20, 470, 45);
        hlabel1.setFont(font);
        hlabel1.setIcon(icon2);
        hlabel1.setBackground(new Color(227, 245, 243));
        hlabel1.setOpaque(true);
        hlabel1.setBorder(BorderFactory.createLineBorder(new Color(224, 172, 167), 2, true));

        hlabel = new JLabel("Please Enter Amount In Multiples ");
        hlabel.setBounds(65, 100, 400, 40);
        hlabel.setFont(font);

        hlabel2 = new JLabel("Of TK.500!");
        hlabel2.setBounds(200, 140, 130, 30);
        hlabel2.setFont(font);

        icon = new ImageIcon("src/Images/writing.png");

        iconlabel = new JLabel(icon);
        iconlabel.setBounds(240, 190, icon.getIconWidth(), icon.getIconHeight());

        field = new JTextField();
        field.setBounds(115, 250, 300, 40);
        field.setFont(new Font("Monospaced", Font.BOLD, 14));

        btn1 = new JButton("WITHDRAW");
        btn1.setBounds(135, 330, 120, 40);
        btn1.setFont(font2);
        btn1.setCursor(cursor);
        //
        btn2 = new JButton("CLEAR");
        btn2.setBounds(275, 330, 120, 40);
        btn2.setFont(font2);
        btn2.setCursor(cursor);

        btn3 = new JButton("EXIT");
        btn3.setBounds(135, 420, 260, 40);
        btn3.setFont(font2);
        btn3.setCursor(cursor);

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
        panel.add(hlabel1);
        panel.add(hlabel);
        panel.add(hlabel2);
        panel.add(field);
        panel.add(btn1);
        panel.add(btn2);
        panel.add(btn3);
        panel.add(iconlabel);

        this.setSize(650, 600);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(new Color(227, 245, 243));
        c.add(panel);
        c.add(backbtn);

        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        backbtn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btn1) {
            try {
                Connection_data connection = new Connection_data();
                String query, query2;
                double balance = 0.00;
                double ebalance = Double.parseDouble(field.getText());
                double fbalance;

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
        } else if (e.getSource() == btn2) {
            field.setText(null);
        } else if (e.getSource() == btn3) {
            System.exit(0);
        } else {
            new Transaction_menu_page();
            dispose();
        }
    }
}

public class Withdrawl_Page {

    public static void main(String[] args) throws Exception {
        String str = "javax.swing.plaf.nimbus.NimbusLookAndFeel";
        UIManager.setLookAndFeel(str);
        new Withdrawl_page_demo();
    }

}
