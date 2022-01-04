package com.exam;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.Border;

class LoginPage extends JFrame implements ActionListener  {

    private Container c;
    private JLabel plabel, titlelabel, hlabel, nolabel, pinlabel, qlabel, accountlabel;
    private JTextField nofield;
    private JPasswordField pinfield;
    private ImageIcon icon, icon2, icon3;
    private Font font, font2;
    private JButton accessbtn, clearbtn;
    private Cursor cursor;
    String space = "";
    private PreparedStatement pst;
    private ResultSet rst;
    static long ac_no;

    LoginPage() {
        initcomponents();
    }

    public void initcomponents() {
        Border border = BorderFactory.createLineBorder(Color.yellow, 2);
        font = new Font("Monospaced", Font.BOLD, 16);
        font2 = new Font("Monospaced", Font.BOLD, 14);
        cursor = new Cursor(Cursor.HAND_CURSOR);

        plabel = new JLabel();
        plabel.setBounds(0, 0, 250, 550);
        icon = new ImageIcon("src/Images/currencys pic.jpg");
        Image image2 = icon.getImage();
        Image image3 = image2.getScaledInstance(plabel.getWidth(), plabel.getHeight(), Image.SCALE_SMOOTH);
        icon = new ImageIcon(image3);
        plabel.setIcon(icon);

        icon2 = new ImageIcon("src/Images/bankname2.png");
        titlelabel = new JLabel();
        titlelabel.setBounds(320, 0, icon2.getIconWidth(), 60);
//        titlelabel.setBorder(border);
        titlelabel.setIcon(icon2);

        hlabel = new JLabel("Welcome To ATM");
        hlabel.setBounds(350, 100, 200, 50);
        hlabel.setFont(new Font("Monospaced", Font.BOLD, 23));

        nolabel = new JLabel("Card No");
        nolabel.setBounds(290, 170, 80, 40);
        nolabel.setFont(font);

        nofield = new JTextField();
        nofield.setBounds(380, 170, 210, 40);
        nofield.setFont(font2);

        pinlabel = new JLabel("Pin");
        pinlabel.setBounds(290, 220, 80, 40);
        pinlabel.setFont(font);

        pinfield = new JPasswordField();
        pinfield.setBounds(380, 220, 210, 40);
        pinfield.setFont(font2);
        pinfield.setEchoChar('*');

        accessbtn = new JButton("Access");
        accessbtn.setBounds(380, 300, 100, 40);
        accessbtn.setFont(font);
        accessbtn.setFocusable(false);
        accessbtn.setCursor(cursor);

        clearbtn = new JButton("Clear");
        clearbtn.setBounds(490, 300, 100, 40);
        clearbtn.setFont(font);
        clearbtn.setFocusable(false);
        clearbtn.setCursor(cursor);

        qlabel = new JLabel("Dont't Have Any Account?");
        qlabel.setBounds(290, 380, 200, 40);
        qlabel.setFont(font2);

        accountlabel = new JLabel("Create Account!");
        accountlabel.setBounds(490, 380, 150, 40);
        accountlabel.setFont(font2);
        accountlabel.setForeground(Color.blue);
        accountlabel.setCursor(cursor);

        icon3 = new ImageIcon("src/Images/logo2.png");
        title();
        this.setSize(650, 550);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
//        this.setTitle(space + "Automated Teller Machine");
//        this.setUndecorated(true);
        this.setVisible(true);
        this.setIconImage(icon3.getImage());
        c = this.getContentPane();
        c.setBackground(new Color(227, 245, 243));
        c.setLayout(null);
        c.add(plabel);
        c.add(titlelabel);
        c.add(hlabel);
        c.add(nolabel);
        c.add(nofield);
        c.add(pinlabel);
        c.add(pinfield);
        c.add(accessbtn);
        c.add(clearbtn);
        c.add(qlabel);
        c.add(accountlabel);
        accessbtn.addActionListener(this);
        clearbtn.addActionListener(this);
        accountlabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new Account_forms_1();
                dispose();
            }
        });

    }

    public void title() {
        this.setFont(new Font("System", font.BOLD, 19));
        Font font = this.getFont();
        FontMetrics fm = this.getFontMetrics(font);
        int titlewidth = fm.stringWidth("Automated Teller Machine");
        int spacewidth = fm.stringWidth(" ");
        int tspacewidth = (650 - titlewidth);
        int startspace = tspacewidth / spacewidth;
        space = String.format("%" + startspace + "s", space);
        this.setTitle(space + "Automated Teller Machine");

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == accessbtn) {
            Connection_data connection = new Connection_data();
            try {
                String query = "select * from account_details where card_no=? and pin_no=?";
                pst = connection.conn.prepareStatement(query);
                pst.setLong(1, Long.parseLong(nofield.getText()));
                pst.setInt(2, Integer.parseInt(pinfield.getText()));
                rst = pst.executeQuery();
                if (rst.next()) {
                    ac_no = rst.getLong(1);
                    new Transaction_menu_page();
                    dispose();
                }
            } catch (Exception ev) {
                ev.printStackTrace();
            }

        } else {
            nofield.setText(null);
            pinfield.setText(null);
        }

    }
}

public class Login_page {

    public static void main(String[] args) throws Exception {
        String str = "javax.swing.plaf.nimbus.NimbusLookAndFeel";
        UIManager.setLookAndFeel(str);
        new LoginPage();

    }

}
