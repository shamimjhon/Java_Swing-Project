package com.exam;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.UIManager;

class Account_forms_3 extends JFrame implements ActionListener {

    private Container c;
    private JPanel panel;
    private JLabel tlabel, hlabel, acclabel, exlabel, cardlabel, cardnolabel, cardmsglabel, pinlabel, pinnolabel, pinmsglabel, servlabel, pagelabel;
    private JRadioButton sbtn, cbtn, fbtn, convbtn, yesbtn, nobtn;
    private JCheckBox checks1, checks2, checks3, checks4, checks5, checks6, checks7;
    private ButtonGroup btngroup, btngroup2;
    private JButton submitbtn, resetbtn, accessbtn;
    private Font font, font2, font3;
    private PreparedStatement pst, pst2, pst3;
    private ResultSet rst, rst2, rst3;
    private int pin;

    Account_forms_3() {
        initcomponents();
    }

    public void initcomponents() {

        font = new Font("Monospaced", Font.BOLD, 16);
        font2 = new Font("Monospaced", Font.BOLD, 12);
        font3 = new Font("Monospaced", Font.BOLD, 14);

        tlabel = new JLabel("Application Form");
        tlabel.setBounds(140, 0, 260, 30);
        tlabel.setFont(new Font("Monospaced", Font.BOLD, 25));

        hlabel = new JLabel("Account Details");
        hlabel.setBounds(170, 30, 200, 30);
        hlabel.setFont(new Font("Monospaced", Font.BOLD, 18));

        acclabel = new JLabel("Account Type :");
        acclabel.setBounds(50, 80, 140, 30);
        acclabel.setFont(font);
        //
        sbtn = new JRadioButton("Savings Account");
        sbtn.setBounds(200, 80, 150, 30);
        sbtn.setFont(font3);
        sbtn.setBackground(new Color(234, 252, 250));
        sbtn.setFocusable(false);
        //
        cbtn = new JRadioButton("Current Account");
        cbtn.setBounds(350, 80, 150, 30);
        cbtn.setFont(font3);
        cbtn.setBackground(new Color(234, 252, 250));
        cbtn.setFocusable(false);
        //
        fbtn = new JRadioButton("Fixed Deposit");
        fbtn.setBounds(200, 120, 150, 30);
        fbtn.setFont(font3);
        fbtn.setBackground(new Color(234, 252, 250));
        fbtn.setFocusable(false);
        //
        convbtn = new JRadioButton("Convertible Taka");
        convbtn.setBounds(350, 120, 160, 30);
        convbtn.setFont(font3);
        convbtn.setBackground(new Color(234, 252, 250));
        convbtn.setFocusable(false);
        //
        btngroup = new ButtonGroup();
        btngroup.add(sbtn);
        btngroup.add(cbtn);
        btngroup.add(fbtn);
        btngroup.add(convbtn);

        exlabel = new JLabel("Exsiting A/C :");
        exlabel.setBounds(50, 160, 140, 30);
        exlabel.setFont(font);
        //
        yesbtn = new JRadioButton("Yes");
        yesbtn.setBounds(200, 160, 100, 30);
        yesbtn.setFont(font3);
        yesbtn.setBackground(new Color(234, 252, 250));
        yesbtn.setFocusable(false);
        //
        nobtn = new JRadioButton("No");
        nobtn.setBounds(350, 160, 100, 30);
        nobtn.setFont(font3);
        nobtn.setBackground(new Color(234, 252, 250));
        nobtn.setFocusable(false);
        //
        btngroup2 = new ButtonGroup();
        btngroup2.add(yesbtn);
        btngroup2.add(nobtn);

        cardlabel = new JLabel("Card Number  :");
        cardlabel.setBounds(50, 200, 140, 30);
        cardlabel.setFont(font);
        cardnolabel = new JLabel("XXXX-XXXX-XXXX-1661");
        cardnolabel.setBounds(200, 200, 250, 30);
        cardnolabel.setFont(font3);
        //
        cardmsglabel = new JLabel("[16-digit card no will appear on ATM card,Cheaque and Bank Statement]");
        cardmsglabel.setBounds(50, 230, 500, 15);
        cardmsglabel.setFont(new Font("Monospaced", Font.BOLD, 12));
        cardmsglabel.setForeground(Color.gray);

        pinlabel = new JLabel("Pin Number   :");
        pinlabel.setBounds(50, 250, 140, 30);
        pinlabel.setFont(font);
        pinnolabel = new JLabel("XXXX");
        pinnolabel.setBounds(200, 250, 250, 30);
        pinnolabel.setFont(font3);
        //
        pinmsglabel = new JLabel("[4-digit pin will give you after Create Account along with ATM Card]");
        pinmsglabel.setBounds(50, 280, 500, 15);
        pinmsglabel.setFont(new Font("Monospaced", Font.BOLD, 12));
        pinmsglabel.setForeground(Color.gray);

        servlabel = new JLabel("Service Required:...");
        servlabel.setBounds(50, 300, 200, 30);
        servlabel.setFont(font);
        //
        checks1 = new JCheckBox("ATM Card");
        checks1.setBounds(205, 330, 150, 30);
        checks1.setFont(font3);
        checks1.setFocusable(false);;
        checks1.setBackground(new Color(234, 252, 250));
        //
        checks2 = new JCheckBox("Internet Banking");
        checks2.setBounds(355, 330, 170, 30);
        checks2.setFont(font3);
        checks2.setFocusable(false);;
        checks2.setBackground(new Color(234, 252, 250));
        //
        checks3 = new JCheckBox("Moblie Banking");
        checks3.setBounds(205, 370, 150, 30);
        checks3.setFont(font3);
        checks3.setFocusable(false);;
        checks3.setBackground(new Color(234, 252, 250));
        //
        checks4 = new JCheckBox("Email Alert");
        checks4.setBounds(355, 370, 150, 30);
        checks4.setFont(font3);
        checks4.setFocusable(false);;
        checks4.setBackground(new Color(234, 252, 250));
        //
        checks5 = new JCheckBox("Cheque Book");
        checks5.setBounds(205, 410, 150, 30);
        checks5.setFont(font3);
        checks5.setFocusable(false);;
        checks5.setBackground(new Color(234, 252, 250));
        //
        checks6 = new JCheckBox("E-Statement");
        checks6.setBounds(355, 410, 150, 30);
        checks6.setFont(font3);
        checks6.setFocusable(false);;
        checks6.setBackground(new Color(234, 252, 250));

        checks7 = new JCheckBox("I hereby declares that avobe entered details absolutly correct.");
        checks7.setBounds(50, 450, 500, 30);
        checks7.setFont(font2);
        checks7.setFocusable(false);;
        checks7.setBackground(new Color(234, 252, 250));

        submitbtn = new JButton("Submit");
        submitbtn.setBounds(205, 490, 100, 40);
        submitbtn.setFont(font);
        submitbtn.setFocusable(false);
        //
        resetbtn = new JButton("Reset");
        resetbtn.setBounds(330, 490, 100, 40);
        resetbtn.setFont(font);
        resetbtn.setFocusable(false);

        pagelabel = new JLabel("page 3");
        pagelabel.setBounds(52, 540, 100, 30);
        pagelabel.setFont(font);

        accessbtn = new JButton("Access!");
        accessbtn.setBounds(502, 540, 80, 30);
        accessbtn.setFont(font);
        accessbtn.setBorder(BorderFactory.createEmptyBorder());
        accessbtn.setBackground(new Color(227, 245, 243));
        accessbtn.setFocusable(false);
        accessbtn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        Random ran = new Random();
        pin = ran.nextInt(9000) + 1000;
        System.out.println(pin);

        panel = new JPanel();
        panel.setBounds(52, 0, 530, 530);
        panel.setBackground(new Color(234, 252, 250));
        panel.setLayout(null);
        panel.add(tlabel);
        panel.add(hlabel);
        panel.add(acclabel);
        panel.add(sbtn);
        panel.add(cbtn);
        panel.add(fbtn);
        panel.add(convbtn);
        panel.add(exlabel);
        panel.add(yesbtn);
        panel.add(nobtn);
        panel.add(cardlabel);
        panel.add(cardnolabel);
        panel.add(cardmsglabel);
        panel.add(pinlabel);
        panel.add(pinnolabel);
        panel.add(pinmsglabel);
        panel.add(servlabel);
        panel.add(checks1);
        panel.add(checks2);
        panel.add(checks3);
        panel.add(checks4);
        panel.add(checks5);
        panel.add(checks6);
        panel.add(checks7);
        panel.add(submitbtn);
        panel.add(resetbtn);

        this.setSize(650, 620);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(new Color(227, 245, 243));
        c.add(panel);
        c.add(pagelabel);
        c.add(accessbtn);
        submitbtn.addActionListener(this);
        accessbtn.addActionListener(this);
        resetbtn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == submitbtn) {
            Connection_data connection = new Connection_data();
            String ac_type = sbtn.getText();
            if (cbtn.isSelected()) {
                ac_type = cbtn.getText();
            } else if (fbtn.isSelected()) {
                ac_type = fbtn.getText();
            } else if (convbtn.isSelected()) {
                ac_type = convbtn.getText();
            }

            String exis_ac = yesbtn.getText();
            if (nobtn.isSelected()) {
                exis_ac = nobtn.getText();
            }
            String cheks = "";
            if (checks1.isSelected()) {
                cheks += checks1.getText() + ",";
            }
            if (checks2.isSelected()) {
                cheks += checks2.getText() + ",";
            }
            if (checks3.isSelected()) {
                cheks += checks3.getText() + ",";
            }
            if (checks4.isSelected()) {
                cheks += checks4.getText() + ",";
            }
            if (checks5.isSelected()) {
                cheks += checks5.getText() + ",";
            }
            if (checks6.isSelected()) {
                cheks += checks6.getText() + ",";
            }
            try {
                long ac = 0;
                String query = "select max(account_no) from personal_details";
                pst = connection.conn.prepareStatement(query);
                rst = pst.executeQuery();
                if (rst.next()) {
                    ac = rst.getLong(1);
                }
                String query2 = "insert into account_details values(?,?,?,card_gen.nextval,?,?)";
                pst2 = connection.conn.prepareStatement(query2);
                pst2.setLong(1, ac);
                pst2.setString(2, ac_type);
                pst2.setString(3, exis_ac);
                pst2.setInt(4, pin);
                pst2.setString(5, cheks);
                rst2 = pst2.executeQuery();

                long card = 0;
                String query3 = "select card_no from account_details where account_no =? and pin_no = ?";
                pst3 = connection.conn.prepareStatement(query3);
                pst3.setLong(1, ac);
                pst3.setInt(2, pin);
                rst3 = pst3.executeQuery();
                if (rst3.next()) {
                    card = rst3.getLong(1);
                    System.out.println(card);
                    submitbtn.setEnabled(false);
                    JOptionPane.showMessageDialog(null,
                            "Your Account_No-" + ac + "\n"
                            + "Your card_No-" + card + "\n"
                            + "Your Pin - " + pin);
                }
            } catch (Exception ev) {
                ev.printStackTrace();
            }
        } else if (e.getSource() == accessbtn) {
            new LoginPage();
            dispose();
        } else {
            btngroup.clearSelection();
            btngroup2.clearSelection();
            checks1.setSelected(false);
            checks2.setSelected(false);
            checks3.setSelected(false);
            checks4.setSelected(false);
            checks5.setSelected(false);
            checks6.setSelected(false);
            checks7.setSelected(false);
        }

    }
}

public class Account_Form_3 {

    public static void main(String[] args) throws Exception {
        String str = "javax.swing.plaf.nimbus.NimbusLookAndFeel";
        UIManager.setLookAndFeel(str);
        new Account_forms_3();

    }

}
