package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class NewCustomer extends JFrame implements ActionListener {
    JTextField tFName,tFAddress,tFState,tFCity,tFEmail,tFPhone;
    JButton next,cancel;
    JLabel lblMeter;
    NewCustomer(){
        super("New Customer");
        ImageIcon a = new ImageIcon(ClassLoader.getSystemResource("icon/icon00900.png"));
        this.setIconImage(a.getImage());
        this.setBounds(400,125,700,500);

        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(173,216,230));
        add(p);

        JLabel heading = new JLabel("New Customer");
        heading.setBounds(180,10,200,25);
        heading.setFont(new Font("Tahoma",Font.PLAIN,24));
        p.add(heading);

        JLabel lblname = new JLabel("Customer name");
        lblname.setBounds(100,80,100,20);
        p.add(lblname);

        tFName =  new JTextField();
        tFName.setBounds(240,80,200,20);
        p.add(tFName);

        JLabel MNumber = new JLabel("Meter Number");
        MNumber.setBounds(100,120,100,20);
        p.add(MNumber);

        lblMeter = new JLabel("");
        lblMeter.setBounds(240,120,100,20);
        p.add(lblMeter);

        Random ran = new Random();
        long number = ran.nextLong() % 1000000;
        lblMeter.setText("" + Math.abs(number));

        JLabel lblAddress = new JLabel("Address");
        lblAddress.setBounds(100,160,100,20);
        p.add(lblAddress);

        tFAddress =  new JTextField();
        tFAddress.setBounds(240,160,200,20);
        p.add(tFAddress);

        JLabel lblCity = new JLabel("City");
        lblCity.setBounds(100,200,100,20);
        p.add(lblCity);

        tFCity =  new JTextField();
        tFCity.setBounds(240,200,200,20);
        p.add(tFCity);

        JLabel lblState = new JLabel("State");
        lblState.setBounds(100,240,100,20);
        p.add(lblState);

        tFState =  new JTextField();
        tFState.setBounds(240,240,200,20);
        p.add(tFState);

        JLabel lblEmail = new JLabel("Email");
        lblEmail.setBounds(100,280,100,20);
        p.add(lblEmail);

        tFEmail =  new JTextField();
        tFEmail.setBounds(240,280,200,20);
        p.add(tFEmail);

        JLabel lblPhone = new JLabel("Phone");
        lblPhone.setBounds(100,320,100,20);
        p.add(lblPhone);

        tFPhone =  new JTextField();
        tFPhone.setBounds(240,320,200,20);
        p.add(tFPhone);

        next = new JButton("Next");
        next.setBounds(120,390,100,25);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        next.setFocusable(false);
        p.add(next);

        cancel = new JButton("Cancel");
        cancel.setBounds(250,390,100,25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFocusable(false);
        p.add(cancel);

        setLayout(new BorderLayout());
        add(p,"Center");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/hicon1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(150,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image,"West");

        getContentPane().setBackground(Color.WHITE);

        this.setVisible(true);
    }

    public void actionPerformed (ActionEvent ae){
        if (ae.getSource() == next){
            String sName = tFName.getText();
            String sMeter = lblMeter.getText();
            String sAddress = tFAddress.getText();
            String sCity = tFCity.getText();
            String sState = tFState.getText();
            String sEmail = tFEmail.getText();
            String sPhone = tFPhone.getText();

            String query1 = "Insert into customer values('"+sName+"','"+sMeter+"','"+sAddress+"','"+sCity+"','"+sState+"','"+sEmail+"','"+sPhone+"')";
            String query2 = "Insert into login values('"+sMeter+"', '','"+sName+"', '', '') ";

            try{
                Conn c = new Conn();
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null, "Customer Details Added Successfully");
                setVisible(false);

                // new frame
                new MeterInfo(sMeter);
            }catch (Exception e){
                e.printStackTrace();
            }
        } else if (ae.getSource() == cancel) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new NewCustomer();
    }
}
