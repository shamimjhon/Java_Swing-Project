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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

class Account_statement_forms extends JFrame implements ActionListener {

    private Container c;
    private JPanel panel;
    private JLabel hlabel1, hlabel2, iconlabel, label1, label2, label3;
    private JComboBox cbox;
    private String[] type = {"", "Date Wise", "All"};
    private JSpinner dspinner, mspinner, yspinner, dspinner2, mspinner2, yspinner2;
    private SpinnerModel dmodel, mmodel, ymodel, dmodel2, mmodel2, ymodel2;
    private String[] month = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    private JButton btn1, btn2, btn3, backbtn;
    private ImageIcon icon;
    private Font font, font2, font3;
    private Cursor cursor;
    private PreparedStatement pst, pst2, pst3;
    private ResultSet rst, rst2, rst3;
    private String query, query2, query3;
    static long ac_no;
    double withdraw, deposit, obalance, cbalance;

    Account_statement_forms() {
        initcomponent();
    }

    public void initcomponent() {
        ac_no = LoginPage.ac_no;
        System.out.println(ac_no);
        font = new Font("Monospaced", font.BOLD, 20);
        font2 = new Font("Monospaced", font.BOLD, 16);
        font3 = new Font("Monospaced", font.BOLD, 14);
        cursor = new Cursor(Cursor.HAND_CURSOR);

        Border border = BorderFactory.createLineBorder(Color.yellow, 1);

        hlabel1 = new JLabel("get Your Account Statement");
        hlabel1.setBounds(110, 50, 330, 30);
        hlabel1.setFont(font);
//        hlabel1.setBorder(border);
        //
        hlabel2 = new JLabel("As Required!");
        hlabel2.setBounds(250, 80, 150, 30);
        hlabel2.setFont(font);
//        hlabel2.setBorder(border);

        icon = new ImageIcon("src/Images/writing.png");
        iconlabel = new JLabel(icon);
        iconlabel.setBounds(300, 115, icon.getIconWidth(), icon.getIconHeight());

        label1 = new JLabel("Statement Type");
        label1.setBounds(50, 170, 160, 30);
        label1.setFont(font2);
        //
        cbox = new JComboBox(type);
        cbox.setBounds(210, 170, 260, 30);
        cbox.setFont(font3);

        label2 = new JLabel("Start Date");
        label2.setBounds(50, 220, 160, 30);
        label2.setFont(font2);

        //----SpinnerDateModel-----
        String y = String.valueOf(java.time.Year.now());
        int year = Integer.parseInt(y);

        dmodel = new SpinnerNumberModel(1, 1, 31, 1);
        mmodel = new SpinnerListModel(month);
        ymodel = new SpinnerNumberModel(year, year - 100, year, 1);
        //
        dspinner = new JSpinner(dmodel);
        dspinner.setBounds(210, 220, 60, 30);
        dspinner.setFont(font3);
        //
        mspinner = new JSpinner(mmodel);
        mspinner.setBounds(280, 220, 100, 30);
        mspinner.setFont(font3);
        //
        yspinner = new JSpinner(ymodel);
        yspinner.setBounds(390, 220, 80, 30);
        yspinner.setFont(font3);

        label3 = new JLabel("End Date");
        label3.setBounds(50, 270, 160, 30);
        label3.setFont(font2);

        dmodel2 = new SpinnerNumberModel(1, 1, 31, 1);
        mmodel2 = new SpinnerListModel(month);
        ymodel2 = new SpinnerNumberModel(year, year - 100, year, 1);
        //
        dspinner2 = new JSpinner(dmodel2);
        dspinner2.setBounds(210, 270, 60, 30);
        dspinner2.setFont(font3);
        //
        mspinner2 = new JSpinner(mmodel2);
        mspinner2.setBounds(280, 270, 100, 30);
        mspinner2.setFont(font3);
        //
        yspinner2 = new JSpinner(ymodel2);
        yspinner2.setBounds(390, 270, 80, 30);
        yspinner2.setFont(font3);

        //----button-----
        btn1 = new JButton("GENERATE");
        btn1.setBounds(210, 340, 120, 40);
        btn1.setFont(font2);
        btn1.setFocusable(false);
        btn1.setCursor(cursor);
        //
        btn2 = new JButton("CLEAR");
        btn2.setBounds(350, 340, 120, 40);
        btn2.setFont(font2);
        btn2.setFocusable(false);
        btn2.setCursor(cursor);
        //
        btn3 = new JButton("Exit");
        btn3.setBounds(210, 410, 260, 40);
        btn3.setFont(font2);
        btn3.setFocusable(false);
        btn3.setCursor(cursor);
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
        panel.add(hlabel1);
        panel.add(hlabel2);
        panel.add(label1);
        panel.add(cbox);
        panel.add(label2);
        panel.add(dspinner);
        panel.add(mspinner);
        panel.add(yspinner);
        panel.add(label3);
        panel.add(dspinner2);
        panel.add(mspinner2);
        panel.add(yspinner2);
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
        btn3.addActionListener(this);
        backbtn.addActionListener(this);
    }

    public void statement() {
        Connection_data connection = new Connection_data();
        Account_Statement_demo read = new Account_Statement_demo();
        String sdate = dspinner.getValue() + "-" + mspinner.getValue() + "-" + yspinner.getValue();
        String edate = dspinner2.getValue() + "-" + mspinner2.getValue() + "-" + yspinner2.getValue();
        DefaultTableModel model2 = (DefaultTableModel) read.table.getModel();
        Object[] data = new Object[5];
        try {
            query2 = "select ac_name,address,city,p_code from personal_details where account_no=" + ac_no + "";
            pst2 = connection.conn.prepareStatement(query2);
            rst2 = pst2.executeQuery();
            if (rst2.next()) {
                read.label9.setText(rst2.getString(1));
                read.label10.setText(rst2.getString(2));
                read.label11.setText(rst2.getString(3) + "-" + rst2.getString(4));
            }
            query3 = "select account_type from account_details where account_no=" + ac_no + "";
            pst3 = connection.conn.prepareStatement(query3);
            rst3 = pst3.executeQuery();
            if (rst3.next()) {
                read.label4.setText(String.valueOf(ac_no));
                read.label6.setText(rst3.getString(1));
            }

            query = "select t_date,description,withdraw,deposit,balance from transaction_details where t_date between to_date('" + sdate + "','dd-month-yyyy') and to_date('" + edate + " 23:59:59','dd-month-yyyy hh24:mi:ss') and account_no=" + ac_no + " order by t_date";
            pst = connection.conn.prepareStatement(query);
            rst = pst.executeQuery();
            int i = 0;
            withdraw = 0;
            deposit = 0;
            while (rst.next()) {
                data[0] = rst.getDate(1);
                data[1] = rst.getString(2);
                data[2] = rst.getDouble(3);
                data[3] = rst.getDouble(4);
                data[4] = rst.getDouble(5);
                model2.addRow(data);
                withdraw += Double.parseDouble(data[2].toString());
                deposit += Double.parseDouble(data[3].toString());
            }

            //-------set data-------
            read.label13.setText(String.valueOf(withdraw));
            read.label15.setText(String.valueOf(deposit));

            String obalance = read.table.getValueAt(0, 4).toString();
            int rowcount = model2.getRowCount();
            String cbalance = read.table.getValueAt(rowcount - 1, 4).toString();
            read.label17.setText(obalance);
            read.label19.setText(cbalance);

            read.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn1) {
            statement();
        } else if (e.getSource() == btn3) {
            System.exit(0);
        } else if (e.getSource() == backbtn) {
            new Transaction_menu_page();
            dispose();
        }
    }
}

public class Account_Statement_Form {

    public static void main(String[] args) throws Exception {
        String str = "javax.swing.plaf.nimbus.NimbusLookAndFeel";
        UIManager.setLookAndFeel(str);
        new Account_statement_forms();

    }

}
