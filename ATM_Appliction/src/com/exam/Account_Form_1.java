package com.exam;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.naming.spi.DirStateFactory;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
import javax.swing.border.Border;

class Account_forms_1 extends JFrame implements ActionListener {

    private Container c;
    private JPanel panel;
    private JLabel tlabel, hlabel, namelabel, flabel, mlabel, dlabel, glabel, mslabel, alabel, clabel, pslabel, plabel, pagelabel;
    private JTextField nfield, ffield, mfield, afield, cfield, psfield, pfield;
    private JRadioButton malebtn, femalebtn, marridebtn, unmarridebtn;
    private ButtonGroup btngroup, btngroup2;
    private JSpinner dspinner, mspinner, yspinner;
    private SpinnerModel dmodel, mmodel, ymodel;
    private JButton nextbtn;
    private String[] month = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    private Font font, font2, font3;
    private PreparedStatement pst;
    private ResultSet rst;

    Account_forms_1() {
        initcomponents();
    }

    public void initcomponents() {
        font = new Font("Monospaced", Font.BOLD, 16);
        font2 = new Font("Monospaced", Font.BOLD, 12);
        font3 = new Font("Monospaced", Font.BOLD, 14);

        tlabel = new JLabel("Application Form");
        tlabel.setBounds(140, 0, 260, 30);
        tlabel.setFont(new Font("Monospaced", Font.BOLD, 25));

        hlabel = new JLabel("Personal Details");
        hlabel.setBounds(170, 30, 200, 30);
        hlabel.setFont(new Font("Monospaced", Font.BOLD, 18));

        namelabel = new JLabel("Name");
        namelabel.setBounds(50, 80, 140, 30);
        namelabel.setFont(font);
        nfield = new JTextField();
        nfield.setBounds(200, 80, 260, 30);
        nfield.setFont(font2);

        flabel = new JLabel("Father's Name");
        flabel.setBounds(50, 120, 140, 30);
        flabel.setFont(font);
        ffield = new JTextField();
        ffield.setBounds(200, 120, 260, 30);
        ffield.setFont(font2);

        mlabel = new JLabel("Mothers's Name");
        mlabel.setBounds(50, 160, 140, 30);
        mlabel.setFont(font);
        mfield = new JTextField();
        mfield.setBounds(200, 160, 260, 30);
        mfield.setFont(font2);

        dlabel = new JLabel("Date of Birth");
        dlabel.setBounds(50, 200, 140, 30);
        dlabel.setFont(font);
        //----SpinnerDateModel-----
        String y = String.valueOf(java.time.Year.now());
        int year = Integer.parseInt(y);

        dmodel = new SpinnerNumberModel(1, 1, 31, 1);
        mmodel = new SpinnerListModel(month);
        ymodel = new SpinnerNumberModel(year, year - 100, year, 1);
        //
        dspinner = new JSpinner(dmodel);
        dspinner.setBounds(200, 200, 80, 30);
        dspinner.setFont(font2);
        //
        mspinner = new JSpinner(mmodel);
        mspinner.setBounds(290, 200, 80, 30);
        mspinner.setFont(font2);
        //
        yspinner = new JSpinner(ymodel);
        yspinner.setBounds(380, 200, 80, 30);
        yspinner.setFont(font2);
        //--------------------------//

        glabel = new JLabel("Gender");
        glabel.setBounds(50, 240, 140, 30);
        glabel.setFont(font);
        malebtn = new JRadioButton("Male");
        malebtn.setBounds(200, 240, 100, 30);
        malebtn.setFont(font3);
        malebtn.setBackground(new Color(234, 252, 250));
        malebtn.setFocusable(false);
        femalebtn = new JRadioButton("Female");
        femalebtn.setBounds(310, 240, 100, 30);
        femalebtn.setFont(font3);
        femalebtn.setBackground(new Color(234, 252, 250));
        femalebtn.setFocusable(false);
        btngroup = new ButtonGroup();
        btngroup.add(malebtn);
        btngroup.add(femalebtn);

        mslabel = new JLabel("Maritul Status");
        mslabel.setBounds(50, 280, 140, 30);
        mslabel.setFont(font);
        marridebtn = new JRadioButton("Marride");
        marridebtn.setBounds(200, 280, 100, 30);
        marridebtn.setFont(font3);
        marridebtn.setBackground(new Color(234, 252, 250));
        marridebtn.setFocusable(false);
        unmarridebtn = new JRadioButton("Unmarride");
        unmarridebtn.setBounds(310, 280, 120, 30);
        unmarridebtn.setFont(font3);
        unmarridebtn.setBackground(new Color(234, 252, 250));
        unmarridebtn.setFocusable(false);
        btngroup2 = new ButtonGroup();
        btngroup2.add(marridebtn);
        btngroup2.add(unmarridebtn);

        alabel = new JLabel("Address");
        alabel.setBounds(50, 320, 140, 30);
        alabel.setFont(font);
        afield = new JTextField();
        afield.setBounds(200, 320, 260, 30);
        afield.setFont(font2);

        plabel = new JLabel("Post Code");
        plabel.setBounds(50, 360, 140, 30);
        plabel.setFont(font);
        pfield = new JTextField();
        pfield.setBounds(200, 360, 260, 30);
        pfield.setFont(font2);

        pslabel = new JLabel("Police Station");
        pslabel.setBounds(50, 400, 140, 30);
        pslabel.setFont(font);
        psfield = new JTextField();
        psfield.setBounds(200, 400, 260, 30);
        psfield.setFont(font2);

        clabel = new JLabel("City");
        clabel.setBounds(50, 440, 140, 30);
        clabel.setFont(font);
        cfield = new JTextField();
        cfield.setBounds(200, 440, 260, 30);
        cfield.setFont(font2);

        pagelabel = new JLabel("page 1");
        pagelabel.setBounds(52, 520, 100, 30);
        pagelabel.setFont(font);

        nextbtn = new JButton("Next->");
        nextbtn.setBounds(502, 520, 80, 30);
        nextbtn.setFont(font);
        nextbtn.setBorder(BorderFactory.createEmptyBorder());
        nextbtn.setBackground(new Color(227, 245, 243));
        nextbtn.setFocusable(false);
        nextbtn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        panel = new JPanel();
        panel.setBounds(52, 0, 530, 500);
        panel.setBackground(new Color(234, 252, 250));
        panel.setLayout(null);
        panel.add(tlabel);
        panel.add(hlabel);
        panel.add(namelabel);
        panel.add(nfield);
        panel.add(flabel);
        panel.add(ffield);
        panel.add(mlabel);
        panel.add(mfield);
        panel.add(dlabel);
        panel.add(dspinner);
        panel.add(mspinner);
        panel.add(yspinner);
        panel.add(glabel);
        panel.add(malebtn);
        panel.add(femalebtn);
        panel.add(mslabel);
        panel.add(marridebtn);
        panel.add(unmarridebtn);
        panel.add(alabel);
        panel.add(afield);
        panel.add(plabel);
        panel.add(pfield);
        panel.add(pslabel);
        panel.add(psfield);
        panel.add(clabel);
        panel.add(cfield);

        this.setSize(650, 600);
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
        String dob = dspinner.getValue().toString() + "-" + mspinner.getValue().toString() + "-" + yspinner.getValue().toString();
        String gender = malebtn.getText();
        if (femalebtn.isSelected()) {
            gender = femalebtn.getText();
        }

        String maritul = marridebtn.getText();
        if (unmarridebtn.isSelected()) {
            maritul = unmarridebtn.getText();
        }
        try {
            String query = "insert into personal_details values(ac_gen.nextval,?,?,?,to_date('" + dob + "','dd-month-yyyy'),?,?,?,?,?,?)";
            pst = connection.conn.prepareStatement(query);
            pst.setString(1, nfield.getText());
            pst.setString(2, ffield.getText());
            pst.setString(3, mfield.getText());
//            pst.setString(4, "to_date(dob,"dd-month-yyyy"));
            pst.setString(4, gender);
            pst.setString(5, maritul);
            pst.setString(6, afield.getText());
            pst.setString(7, pfield.getText());
            pst.setString(8, psfield.getText());
            pst.setString(9, cfield.getText());
            rst = pst.executeQuery();
            if (rst.next()) {
                new Account_forms_2();
                dispose();
            }
        } catch (Exception ev) {
            ev.printStackTrace();
        }
    }

}

public class Account_Form_1 {

    public static void main(String[] args) throws Exception {
        String str = "javax.swing.plaf.nimbus.NimbusLookAndFeel";
        UIManager.setLookAndFeel(str);
        new Account_forms_1();
    }

}
