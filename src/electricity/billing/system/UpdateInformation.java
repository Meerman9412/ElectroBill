package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateInformation extends JFrame implements ActionListener {
    JButton cancel,update;
    JTextField tFaddress,tFCity,tFstate,tFEmail,tFPhone;
    String meter;
    UpdateInformation(String meter){
        super("Update Information");
        this.meter = meter;
        ImageIcon a = new ImageIcon(ClassLoader.getSystemResource("icon/icon00900.png"));
        this.setIconImage(a.getImage());

        setBounds(250,150,1050,450);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Update Customer Information");
        heading.setBounds(110,0,400,30);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 20));
        this.add(heading);

        JLabel lblName = new JLabel("Name");
        lblName.setBounds(30,70,100,20);
        this.add(lblName);

        JLabel name = new JLabel("");
        name.setBounds(230,70,200,20);
        this.add(name);

        JLabel lblMeterNumber = new JLabel("Meter Number");
        lblMeterNumber.setBounds(30,110,100,20);
        this.add(lblMeterNumber);

        JLabel meterNumber = new JLabel("");
        meterNumber.setBounds(230,110,200,20);
        this.add(meterNumber);

        JLabel lblAddress = new JLabel("Address");
        lblAddress.setBounds(30,150,100,20);
        this.add(lblAddress);

        tFaddress = new JTextField();
        tFaddress.setBounds(230,150,200,20);
        this.add(tFaddress);

        JLabel lblCity= new JLabel("City");
        lblCity.setBounds(30,190,100,20);
        this.add(lblCity);

        tFCity  = new JTextField();
        tFCity.setBounds(230,190,200,20);
        this.add(tFCity);

        JLabel lblState = new JLabel("State");
        lblState.setBounds(30,230,100,20);
        this.add(lblState);

        tFstate = new JTextField();
        tFstate.setBounds(230,230,200,20);
        this.add(tFstate);

        JLabel lblEmail = new JLabel("Email");
        lblEmail.setBounds(30,270,100,20);
        this.add(lblEmail);

        tFEmail = new JTextField();
        tFEmail.setBounds(230,270,200,20);
        this.add(tFEmail);

        JLabel lblPhone = new JLabel("Phone");
        lblPhone.setBounds(30,310,100,20);
        this.add(lblPhone);

        tFPhone = new JTextField();
        tFPhone.setBounds(230,310,200,20);
        this.add(tFPhone);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer where meter_no = '"+meter+"'");
            while (rs.next()){
                name.setText(rs.getString("name"));
                tFaddress.setText(rs.getString("address"));
                tFCity.setText(rs.getString("city"));
                tFstate.setText(rs.getString("state"));
                tFPhone.setText(rs.getString("phone"));
                meterNumber.setText(rs.getString("meter_no"));
                tFEmail.setText(rs.getString("email"));

            }
        }catch(Exception e){
            e.printStackTrace();
        }

        update = new JButton("Update");
        update.setFocusable(false);
        update.setBounds(70,360,100,25);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        add(update);
        update.addActionListener(this);

        cancel = new JButton("Cancel");
        cancel.setFocusable(false);
        cancel.setBounds(230,360,100,25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        add(cancel);
        cancel.addActionListener(this);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/update.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(550,50,400,300);
        add(image);

        setVisible(true);
    }

    public static void main(String[] args) {
        new UpdateInformation("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == update){
            String address = tFaddress.getText();
            String city = tFCity.getText();
            String state = tFstate.getText();
            String email = tFEmail.getText();
            String phone = tFPhone.getText();

            try{
                Conn c = new Conn();
                c.s.executeUpdate("update customer set address = '"+address+"', city = '"+city+"', state = '"+state+"', email = '"+email+"', phone = '"+phone+"' where meter_no = '"+meter+"'");

                JOptionPane.showMessageDialog(null, "User Information Updated Successfully");
                setVisible(false);
            }catch (Exception ee){
                ee.printStackTrace();
            }
        } else if (e.getSource() == cancel) {
            this.setVisible(false);
        }
    }
}
