package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class CalculateBills extends JFrame implements ActionListener {
    JTextField tFName,tFAddress,tFState,tFUnits,tFEmail,tFPhone;
    JButton Submit,cancel;
    JLabel lblName,labelAddress;
    Choice meterNumber,cMonth;
    CalculateBills(){
        super("Calculate Bills");
        ImageIcon a = new ImageIcon(ClassLoader.getSystemResource("icon/icon00900.png"));
        this.setIconImage(a.getImage());
        this.setBounds(400,125,700,500);

        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(173,216,230));
        add(p);

        JLabel heading = new JLabel("Calculate Electricity Bills");
        heading.setBounds(100,25,300,25);
        heading.setFont(new Font("Tahoma",Font.PLAIN,24));
        p.add(heading);

        JLabel lblMeterNumber = new JLabel("Meter Number");
        lblMeterNumber.setBounds(100,80,100,20);
        p.add(lblMeterNumber);

        meterNumber = new Choice();
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while (rs.next()){
                meterNumber.add(rs.getString("meter_no"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        meterNumber.setBounds(240,80,200,20);
        meterNumber.setFocusable(false);
        p.add(meterNumber);

        JLabel MNumber = new JLabel("Name");
        MNumber.setBounds(100,120,100,20);
        p.add(MNumber);

        lblName = new JLabel("");
        lblName.setBounds(240,120,120,20);
        p.add(lblName);

        JLabel lblAddress = new JLabel("Address");
        lblAddress.setBounds(100,160,100,20);
        p.add(lblAddress);

        labelAddress =  new JLabel();
        labelAddress.setBounds(240,160,200,20);
        p.add(labelAddress);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("Select * from customer where meter_no ='"+meterNumber.getSelectedItem()+"'");
            while (rs.next()) {
                lblName.setText(rs.getString("name"));
                labelAddress.setText(rs.getString("address"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        // it to change name and address when we are going to select another meterNumber after coming to this calculate bill frame
        meterNumber.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try{
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery("Select * from customer where meter_no ='"+meterNumber.getSelectedItem()+"'");
                    while (rs.next()) {
                        lblName.setText(rs.getString("name"));
                        labelAddress.setText(rs.getString("address"));
                    }
                    }catch (Exception ae){
                    ae.printStackTrace();
                }
            }
        });

        JLabel lblCity = new JLabel("Units Consumed");
        lblCity.setBounds(100,200,100,20);
        p.add(lblCity);

        tFUnits =  new JTextField();
        tFUnits.setBounds(240,200,200,20);
        p.add(tFUnits);

        JLabel lblState = new JLabel("Month");
        lblState.setBounds(100,240,100,20);
        p.add(lblState);

        cMonth = new Choice();
        cMonth.setBounds(240,240,200,20);
        cMonth.setFocusable(false);
        cMonth.add("January");
        cMonth.add("February");
        cMonth.add("March");
        cMonth.add("April");
        cMonth.add("May");
        cMonth.add("June");
        cMonth.add("July");
        cMonth.add("August");
        cMonth.add("September");
        cMonth.add("October");
        cMonth.add("November");
        cMonth.add("December");
        p.add(cMonth);

        Submit = new JButton("Submit");
        Submit.setBounds(120,350,100,25);
        Submit.setBackground(Color.BLACK);
        Submit.setForeground(Color.WHITE);
        Submit.addActionListener(this);
        Submit.setFocusable(false);
        p.add(Submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(250,350,100,25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFocusable(false);
        p.add(cancel);

        setLayout(new BorderLayout());
        add(p,"Center");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/hicon2.jpg"));
        Image i2 = i1.getImage().getScaledInstance(150,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image,"West");

        getContentPane().setBackground(Color.WHITE);

        this.setVisible(true);
    }

    public void actionPerformed (ActionEvent ae){
        if (ae.getSource() == Submit){
            String meter = meterNumber.getSelectedItem();
            String units = tFUnits.getText();
            String month = cMonth.getSelectedItem();

            int totalBill = 0;
            int unit_consumed = Integer.parseInt(units);
            String query1 = "Select * from tax";

            try{
                Conn c = new Conn();
                 ResultSet rs = c.s.executeQuery(query1);
                 while(rs.next()){
                     totalBill += unit_consumed*Integer.parseInt(rs.getString("cost_per_unit"));
                     totalBill += Integer.parseInt(rs.getString("meter_rent"));
                     totalBill += Integer.parseInt(rs.getString("service_charge"));
                     totalBill += Integer.parseInt(rs.getString("service_tax"));
                     totalBill += Integer.parseInt(rs.getString("swacch_bharat_tax"));
                     totalBill += Integer.parseInt(rs.getString("fixed_tax"));
                 }
            }catch (Exception e){
                e.printStackTrace();
            }

            String query2 = "insert into bill values('"+meter+"','"+month+"','"+units+"','"+totalBill+"','Not Paid')";
            try {
                Conn c = new Conn();
                c.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null, "Customer Bill Updated Successfully");
                setVisible(false);
            }
            catch (Exception ea){
                ea.printStackTrace();
            }
        } else if (ae.getSource() == cancel) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new CalculateBills();
    }
}
