package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ViewInformation extends JFrame implements ActionListener {
    JButton cancel;
    ViewInformation(String meter){
        super("View Information");
        ImageIcon a = new ImageIcon(ClassLoader.getSystemResource("icon/icon00900.png"));
        this.setIconImage(a.getImage());

        this.setBounds(300,60,850,650);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("View Customer Information");
        heading.setBounds(250,0,500,40);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 20));
        this.add(heading);

        JLabel lblName = new JLabel("Name");
        lblName.setBounds(70,80,100,20);
        this.add(lblName);

        JLabel name = new JLabel("");
        name.setBounds(250,80,120,20);
        this.add(name);

        JLabel lblMeterNumber = new JLabel("Meter Number");
        lblMeterNumber.setBounds(70,140,100,20);
        this.add(lblMeterNumber);

        JLabel meterNumber = new JLabel("");
        meterNumber.setBounds(250,140,100,20);
        this.add(meterNumber);

        JLabel lblAddress = new JLabel("Address");
        lblAddress.setBounds(70,200,100,20);
        this.add(lblAddress);

        JLabel address = new JLabel("");
        address.setBounds(250,200,100,20);
        this.add(address);

        JLabel lblCity= new JLabel("City");
        lblCity.setBounds(70,260,100,20);
        this.add(lblCity);

        JLabel City = new JLabel("");
        City.setBounds(250,260,100,20);
        this.add(City);

        JLabel lblState = new JLabel("State");
        lblState.setBounds(500,80,100,20);
        this.add(lblState);

        JLabel state = new JLabel("");
        state.setBounds(620,80,100,20);
        this.add(state);

        JLabel lblEmail = new JLabel("Email");
        lblEmail.setBounds(500,140,100,20);
        this.add(lblEmail);

        JLabel email = new JLabel("");
        email.setBounds(620,140,160,20);
        this.add(email);

        JLabel lblPhone = new JLabel("Phone");
        lblPhone.setBounds(500,200,100,20);
        this.add(lblPhone);

        JLabel phone = new JLabel("");
        phone.setBounds(620,200,120,20);
        this.add(phone);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer where meter_no = '"+meter+"'");
            while (rs.next()){
                name.setText(rs.getString("name"));
                address.setText(rs.getString("address"));
                City.setText(rs.getString("city"));
                state.setText(rs.getString("state"));
                phone.setText(rs.getString("phone"));
                meterNumber.setText(rs.getString("meter_no"));
                email.setText(rs.getString("email"));

            }
        }catch(Exception e){
            e.printStackTrace();
        }

        cancel = new JButton("Cancel");
        cancel.setFocusable(false);
        cancel.setBounds(350,340,100,25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        add(cancel);
        cancel.addActionListener(this);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/viewcustomer.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(20,350,600,300);
        add(image);

        this.setVisible(true);
    }
    public static void main(String[] args) {
        new ViewInformation("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == cancel){
            setVisible(false);
        }
    }
}
