package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class PayBill extends JFrame implements ActionListener {
    JButton pay,back;
    Choice meterMonth;
    String meter;
    PayBill(String meter){
        super("Pay Bill");
        ImageIcon a = new ImageIcon(ClassLoader.getSystemResource("icon/icon00900.png"));
        this.setIconImage(a.getImage());

        this.meter = meter;
        setLayout(null);
        setBounds(270,50,900,600);

        JLabel heading = new JLabel("Electricity Bill");
        heading.setFont(new Font("Tahoma", Font.BOLD, 24));
        heading.setBounds(120,5,400,30);
        add(heading);

        JLabel lblMeterNumber = new JLabel("Electricity Bill");
        lblMeterNumber.setBounds(35,80,200,20);
        add(lblMeterNumber);

        JLabel meterNumber = new JLabel("");
        meterNumber.setBounds(300,80,200,20);
        add(meterNumber);

        JLabel lblName = new JLabel("Name");
        lblName.setBounds(35,140,200,20);
        add(lblName);

        JLabel name = new JLabel("");
        name.setBounds(300,140,200,20);
        add(name);

        JLabel lblMonth = new JLabel("Month");
        lblMonth.setBounds(35,200,200,20);
        add(lblMonth);

        meterMonth = new Choice();
        meterMonth.setBounds(300,200,200,20);
        meterMonth.setFocusable(false);
        meterMonth.add("January");
        meterMonth.add("February");
        meterMonth.add("March");
        meterMonth.add("April");
        meterMonth.add("May");
        meterMonth.add("June");
        meterMonth.add("July");
        meterMonth.add("August");
        meterMonth.add("September");
        meterMonth.add("October");
        meterMonth.add("November");
        meterMonth.add("December");
        this.add(meterMonth);

        JLabel lblUnits = new JLabel("Units");
        lblUnits.setBounds(35,260,200,20);
        add(lblUnits);

        JLabel labelUnits = new JLabel("");
        labelUnits.setBounds(300,260,200,20);
        add(labelUnits);

        JLabel lblTotalBill = new JLabel("Total Bill");
        lblTotalBill.setBounds(35,320,200,20);
        add(lblTotalBill);

        JLabel labelTotalBill = new JLabel("");
        labelTotalBill.setBounds(300,320,200,20);
        add(labelTotalBill);

        JLabel lblStatus = new JLabel("Total Bill");
        lblStatus.setBounds(35,380,200,20);
        add(lblStatus);

        JLabel labelStatus = new JLabel("");
        labelStatus.setBounds(300,380,200,20);
        labelStatus.setForeground(Color.RED);
        add(labelStatus);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer where meter_no = '"+meter+"'");
            while (rs.next()){
                meterNumber.setText(meter);
                name.setText(rs.getString("name"));
            }
            rs = c.s.executeQuery("select * from bill where meter_no = '"+meter+"' AND month = 'January'");
            while (rs.next()){
                labelUnits.setText(rs.getString("units"));
                labelTotalBill.setText(rs.getString("totalBill"));
                labelStatus.setText(rs.getString("status"));

            }
        }catch (Exception e){
            e.printStackTrace();
        }

        meterMonth.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {

                try{
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery("select * from bill where meter_no = '"+meter+"' AND month = '"+meterMonth.getSelectedItem()+"'");
                    while (rs.next()){
                        labelUnits.setText(rs.getString("units"));
                        labelTotalBill.setText(rs.getString("totalBill"));
                        labelStatus.setText(rs.getString("status"));

                    }
                }catch (Exception e2){
                    e2.printStackTrace();
                }
            }
        });

        pay = new JButton("Pay");
        pay.setBackground(Color.BLACK);
        pay.setForeground(Color.WHITE);
        pay.setBounds(100,460,100,25);
        pay.setFocusable(false);
        pay.addActionListener(this);
        this.add(pay);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(230,460,100,25);
        back.setFocusable(false);
        back.addActionListener(this);
        this.add(back);

        getContentPane().setBackground(Color.WHITE);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bill.png"));
        Image i2 = i1.getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,120,600,300);
        add(image);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == pay){
            try{
                Conn c =new Conn();
                c.s.executeUpdate("update bill set status = 'Paid' where meter_no = '"+meter+"' AND month = '"+meterMonth.getSelectedItem()+"'");
            }catch (Exception e3){
                e3.printStackTrace();
            }
            setVisible(false);
            new Paytm(meter);
        }else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new PayBill("");
    }
}
