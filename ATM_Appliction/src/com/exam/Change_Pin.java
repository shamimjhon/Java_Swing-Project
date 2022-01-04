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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

class Change_pin_demo extends JFrame implements ActionListener {

    private Container c;
    private JPanel panel;
    private JLabel hlabel, hlabel2, iconlabel, label1, label2, label3;
    private JPasswordField field1, field2, field3;
    private JButton btn1, btn2, btn3, backbtn;
    private ImageIcon icon;
    private Font font, font2, font3;
    private Cursor cursor;
    private PreparedStatement pst;
    private ResultSet rst;
    private String query;
    long ac_no;

    Change_pin_demo() {
        initcoponents();
    }

    public void initcoponents() {
        ac_no = LoginPage.ac_no;
        System.out.println(ac_no);

        font = new Font("Monospaced", Font.BOLD, 20);
        font2 = new Font("Monospaced", Font.BOLD, 16);
        font3 = new Font("Monospaced", Font.BOLD, 12);
        cursor = new Cursor(Cursor.HAND_CURSOR);

        hlabel = new JLabel("Please Change Your Pin With");
        hlabel.setBounds(90, 50, 350, 40);
        hlabel.setFont(font);

        hlabel2 = new JLabel("Digit Only!");
        hlabel2.setBounds(260, 90, 140, 30);
        hlabel2.setFont(font);

        icon = new ImageIcon("src/Images/writing.png");
        iconlabel = new JLabel(icon);
        iconlabel.setBounds(300, 130, icon.getIconWidth(), icon.getIconHeight());

        label1 = new JLabel("Current Pin");
        label1.setBounds(50, 200, 160, 40);
        label1.setFont(font2);
        //
        field1 = new JPasswordField();
        field1.setBounds(220, 200, 250, 40);
        field1.setFont(font3);
        field1.setEchoChar('*');

        label2 = new JLabel("New Pin");
        label2.setBounds(50, 260, 160, 40);
        label2.setFont(font2);
        //
        field2 = new JPasswordField();
        field2.setBounds(220, 260, 250, 40);
        field2.setFont(font3);
        field2.setEchoChar('*');

        label3 = new JLabel("New Confirm Pin");
        label3.setBounds(50, 320, 160, 40);
        label3.setFont(font2);
        //
        field3 = new JPasswordField();
        field3.setBounds(220, 320, 250, 40);
        field3.setFont(font3);
        field3.setEchoChar('*');

        btn1 = new JButton("CHANGE");
        btn1.setBounds(220, 380, 120, 40);
        btn1.setFont(font2);
        btn1.setFocusable(false);
        //
        btn2 = new JButton("CLEAR");
        btn2.setBounds(350, 380, 120, 40);
        btn2.setFont(font2);
        btn2.setFocusable(false);
        //
        btn3 = new JButton("Exit");
        btn3.setBounds(220, 440, 250, 40);
        btn3.setFont(font2);
        btn3.setFocusable(false);
        //
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
        panel.add(hlabel2);
        panel.add(iconlabel);
        panel.add(label1);
        panel.add(field1);
        panel.add(label2);
        panel.add(field2);
        panel.add(label3);
        panel.add(field3);
        panel.add(btn1);
        panel.add(btn2);
        panel.add(btn3);

        this.setSize(650, 600);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(new Color(227, 245, 243));
        c.add(panel);
        c.add(backbtn);
        //this.setBckground.getContentPane(color.red);
        
        //---add listener------
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        backbtn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn1) {
            String oldpin = field1.getText();
            String newpin = field2.getText();
            String cnewpin = field3.getText();
            try {
                Connection_data connection = new Connection_data();
                query = "update account_details set pin_no=? where account_no=? and pin_no=?";
                pst = connection.conn.prepareStatement(query);
                pst.setInt(1, Integer.parseInt(cnewpin));
                pst.setLong(2, ac_no);
                pst.setInt(3, Integer.parseInt(oldpin));
                rst = pst.executeQuery();
                if (rst.next()) {
                    JOptionPane.showMessageDialog(null, oldpin + " pin changed by " + newpin + " successfully!");
                }
            } catch (Exception ev) {
                ev.printStackTrace();
            }
        } else if (e.getSource() == btn2) {
            field1.setText(null);
            field2.setText(null);
            field3.setText(null);
        } else if (e.getSource() == btn3) {
            System.exit(0);
        } else {
            new Transaction_menu_page();
            dispose();
        }
    }
}

public class Change_Pin {

    public static void main(String[] args) throws Exception {
        String str = "javax.swing.plaf.nimbus.NimbusLookAndFeel";
        UIManager.setLookAndFeel(str);
        new Change_pin_demo();

    }

}
