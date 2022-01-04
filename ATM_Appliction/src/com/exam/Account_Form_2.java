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
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

class Account_forms_2 extends JFrame implements ActionListener {

    private Container c;
    private JPanel panel;
    private JLabel tlabel, hlabel, rlabel, elabel, olabel, ilabel, nlabel, plabel, emaillabel, nominelabel, namelabel, phonelabel, relabel, pagelabel;
    private JComboBox rbox, ebox;
    private JButton nextbtn;
    private JTextField ofield, ifield, nfield, pfield, emailfield, namefield, phonefield, refield;
    private Font font, font2, font3;
    private PreparedStatement pst,pst2;
    private ResultSet rst,rst2;

    Account_forms_2() {
        initcomponents();
    }

    public void initcomponents() {
        font = new Font("Monospaced", Font.BOLD, 16);
        font2 = new Font("Monospaced", Font.BOLD, 12);
        font3 = new Font("Monospaced", Font.BOLD, 14);

        tlabel = new JLabel("Application Form");
        tlabel.setBounds(140, 0, 260, 30);
        tlabel.setFont(new Font("Monospaced", Font.BOLD, 25));

        hlabel = new JLabel("Additional Details");
        hlabel.setBounds(170, 30, 200, 30);
        hlabel.setFont(new Font("Monospaced", Font.BOLD, 18));

        rlabel = new JLabel("Religion");
        rlabel.setBounds(50, 80, 140, 30);
        rlabel.setFont(font);
        String[] religion = {"", "Islam", "Christian", "Hindu", "Bathousim", "Others"};
        rbox = new JComboBox(religion);
        rbox.setBounds(200, 80, 260, 30);
        rbox.setFont(font2);

        elabel = new JLabel("Education");
        elabel.setBounds(50, 120, 140, 30);
        elabel.setFont(font);
        String[] education = {"", "Five", "Eight", "SSC", "HSC", "Graduate", "Non-Graduate"};
        ebox = new JComboBox(education);
        ebox.setBounds(200, 120, 260, 30);
        ebox.setFont(font2);

        olabel = new JLabel("Ocupation");
        olabel.setBounds(50, 160, 140, 30);
        olabel.setFont(font);
        ofield = new JTextField();
        ofield.setBounds(200, 160, 260, 30);
        ofield.setFont(font2);

        ilabel = new JLabel("Income");
        ilabel.setBounds(50, 200, 140, 30);
        ilabel.setFont(font);
        ifield = new JTextField();
        ifield.setBounds(200, 200, 260, 30);
        ifield.setFont(font2);

        nlabel = new JLabel("NID");
        nlabel.setBounds(50, 240, 140, 30);
        nlabel.setFont(font);
        nfield = new JTextField();
        nfield.setBounds(200, 240, 260, 30);
        nfield.setFont(font2);

        plabel = new JLabel("Phone");
        plabel.setBounds(50, 280, 140, 30);
        plabel.setFont(font);
        pfield = new JTextField();
        pfield.setBounds(200, 280, 260, 30);
        pfield.setFont(font2);

        emaillabel = new JLabel("Email");
        emaillabel.setBounds(50, 320, 140, 30);
        emaillabel.setFont(font);
        emailfield = new JTextField();
        emailfield.setBounds(200, 320, 260, 30);
        emailfield.setFont(font2);

        nominelabel = new JLabel("Nomine Details");
        nominelabel.setBounds(170, 360, 200, 30);
        nominelabel.setFont(new Font("Monospaced", Font.BOLD, 18));

        namelabel = new JLabel("Name");
        namelabel.setBounds(50, 400, 140, 30);
        namelabel.setFont(font);
        namefield = new JTextField();
        namefield.setBounds(200, 400, 260, 30);
        namefield.setFont(font2);

        phonelabel = new JLabel("Phone");
        phonelabel.setBounds(50, 440, 140, 30);
        phonelabel.setFont(font);
        phonefield = new JTextField();
        phonefield.setBounds(200, 440, 260, 30);
        phonefield.setFont(font2);

        relabel = new JLabel("Relation");
        relabel.setBounds(50, 480, 140, 30);
        relabel.setFont(font);
        refield = new JTextField();
        refield.setBounds(200, 480, 260, 30);
        refield.setFont(font2);

        pagelabel = new JLabel("page 1");
        pagelabel.setBounds(52, 530, 100, 30);
        pagelabel.setFont(font);

        nextbtn = new JButton("Next->");
        nextbtn.setBounds(502, 530, 80, 30);
        nextbtn.setFont(font);
        nextbtn.setBorder(BorderFactory.createEmptyBorder());
        nextbtn.setBackground(new Color(227, 245, 243));
        nextbtn.setFocusable(false);
        nextbtn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        panel = new JPanel();
        panel.setBounds(52, 0, 530, 520);
        panel.setBackground(new Color(234, 252, 250));
        panel.setLayout(null);
        panel.add(tlabel);
        panel.add(hlabel);
        panel.add(rlabel);
        panel.add(rbox);
        panel.add(elabel);
        panel.add(ebox);
        panel.add(olabel);
        panel.add(ofield);
        panel.add(ilabel);
        panel.add(ifield);
        panel.add(nlabel);
        panel.add(nfield);
        panel.add(plabel);
        panel.add(pfield);
        panel.add(emaillabel);
        panel.add(emailfield);
        panel.add(nominelabel);
        panel.add(namelabel);
        panel.add(namefield);
        panel.add(phonelabel);
        panel.add(phonefield);
        panel.add(relabel);
        panel.add(refield);

        this.setSize(650, 610);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(new Color(227, 245, 243));
        c.add(panel);
        c.add(pagelabel);
        c.add(nextbtn);
        nextbtn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Connection_data connection = new Connection_data();
        try {
            long ac = 0;
            String query = "select max(account_no) from personal_details";
            pst = connection.conn.prepareStatement(query);
            rst = pst.executeQuery();
            if (rst.next()) {
                ac = rst.getLong(1);
            }
            String query2 = "insert into additional_details values(?,?,?,?,?,?,?,?,?,?)";
            pst2 = connection.conn.prepareStatement(query2);
            pst2.setLong(1, ac);
            pst2.setString(2, ebox.getSelectedItem().toString());
            pst2.setString(3, ofield.getText());
            pst2.setInt(4, Integer.parseInt(ifield.getText()));
            pst2.setLong(5, Long.parseLong(nfield.getText()));
            pst2.setLong(6, Long.parseLong(pfield.getText()));
            pst2.setString(7, emailfield.getText());
            pst2.setString(8, namefield.getText());
            pst2.setLong(9, Long.parseLong(phonefield.getText()));
            pst2.setString(10, refield.getText());
            rst2 = pst2.executeQuery();
            if(rst2.next()){
             new Account_forms_3();
             dispose();
            }

        } catch (Exception ev) {
            ev.printStackTrace();
        }

    }
}

public class Account_Form_2 {

    public static void main(String[] args) throws Exception {
        String str = "javax.swing.plaf.nimbus.NimbusLookAndFeel";
        UIManager.setLookAndFeel(str);
        new Account_forms_2();

    }
}
