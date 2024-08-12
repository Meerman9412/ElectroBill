package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MeterInfo extends JFrame implements ActionListener {
    JTextField tFName,tFAddress,tFState,tFCity,tFEmail,tFPhone;
    JButton next,cancel;
    JLabel lblMeter;
    Choice meterLocation,meterType,phaseCode,billType;
    String meterNumber;
    MeterInfo(String meterNumber){
        super("New Customer");
        ImageIcon a = new ImageIcon(ClassLoader.getSystemResource("icon/icon00900.png"));
        this.setIconImage(a.getImage());
        this.meterNumber = meterNumber;
        this.setBounds(400,125,700,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(173,216,230));
        add(p);

        JLabel heading = new JLabel("Meter Information");
        heading.setBounds(180,10,200,25);
        heading.setFont(new Font("Tahoma",Font.PLAIN,24));
        p.add(heading);

        JLabel lblname = new JLabel("Meter Number");
        lblname.setBounds(100,80,100,20);
        p.add(lblname);

        JLabel lblMeterNumber = new JLabel(meterNumber);
        lblMeterNumber.setBounds(240,80,100,20);
        p.add(lblMeterNumber);

        JLabel MNumber = new JLabel("Meter Location");
        MNumber.setBounds(100,120,100,20);
        p.add(MNumber);

        meterLocation = new Choice();
        meterLocation.setBounds(240,120,200,20);
        meterLocation.setFocusable(false);
        meterLocation.add("OutSide");
        meterLocation.add("Inside");
        p.add(meterLocation);

        JLabel lblAddress = new JLabel("Meter Type");
        lblAddress.setBounds(100,160,100,20);
        p.add(lblAddress);

        meterType = new Choice();
        meterType.setBounds(240,160,200,20);
        meterType.setFocusable(false);
        meterType.add("Electric Meter");
        meterType.add("Solar Meter");
        meterType.add("Smart Meter");
        p.add(meterType);

        JLabel lblCity = new JLabel("Phase Code");
        lblCity.setBounds(100,200,100,20);
        p.add(lblCity);

        phaseCode = new Choice();
        phaseCode.setBounds(240,200,200,20);
        phaseCode.setFocusable(false);
        phaseCode.add("011");
        phaseCode.add("022");
        phaseCode.add("033");
        phaseCode.add("044");
        phaseCode.add("055");
        phaseCode.add("066");
        phaseCode.add("077");
        phaseCode.add("088");
        phaseCode.add("099");
        p.add(phaseCode);

        JLabel lblState = new JLabel("Bill Type");
        lblState.setBounds(100,240,100,20);
        p.add(lblState);

        billType = new Choice();
        billType.setBounds(240,240,200,20);
        billType.setFocusable(false);
        billType.add("HouseHold");
        billType.add("Industrial");
        p.add(billType);

        JLabel lblEmail = new JLabel("Days");
        lblEmail.setBounds(100,280,100,20);
        p.add(lblEmail);

        JLabel lblEmails = new JLabel("30 Days");
        lblEmails.setBounds(240,280,500,20);
        p.add(lblEmails);

        JLabel lblPhone = new JLabel("Note");
        lblPhone.setBounds(100,320,100,20);
        p.add(lblPhone);

        JLabel lblPhones = new JLabel("By Default Bill is calculated for 30 days only");
        lblPhones.setBounds(240,320,500,20);
        p.add(lblPhones);


        next = new JButton("Submit");
        next.setBounds(220,390,100,25);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        next.setFocusable(false);
        p.add(next);

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
            String meter = meterNumber;
            String location = meterLocation.getSelectedItem();
            String type = meterType.getSelectedItem();
            String code = phaseCode.getSelectedItem();
            String BillType = billType.getSelectedItem();
            String days = "30";

            String query1 = "Insert into meter_info values('"+meter+"','"+location+"','"+type+"','"+code+"','"+BillType+"','"+days+"')";


            try{
                Conn c = new Conn();
                c.s.executeUpdate(query1);
                JOptionPane.showMessageDialog(null, "Meter Information Added Successfully");
                setVisible(false);

                // new frame
            }catch (Exception e){
                e.printStackTrace();
            }
        } else if (ae.getSource() == cancel) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {

    }
}


