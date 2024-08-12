package electricity.billing.system;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class SignUp extends JFrame implements ActionListener {
    JButton back,create;
    Choice accountType;
    JTextField meter ,username,name,password;
    SignUp(){
        super("Sign Up");
        ImageIcon a = new ImageIcon(ClassLoader.getSystemResource("icon/icon00900.png"));
        this.setIconImage(a.getImage());
        this.setBounds(450,150,700,400);
        this.getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(30,0,650,300);
        panel.setBorder(new TitledBorder(new LineBorder(new Color(172,216,230),2),
                "Create - Account ",TitledBorder.LEADING,TitledBorder.TOP,null,new Color(172,216,230)));
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        panel.setForeground(new Color(34,139,34));
        this.add(panel) ;

        JLabel heading = new JLabel("Create Account As ");
        heading.setBounds(100,50,140,20);
        heading.setForeground(Color.GRAY);
        heading.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(heading);// adding label on panel not on frame

        accountType = new Choice();
        accountType.setFocusable(false);
        accountType.add("Admin");
        accountType.add("Customer");
        accountType.setBounds(260,50,140,20);
        panel.add(accountType);

        JLabel lblMeter = new JLabel("Meter Number");
        lblMeter.setBounds(100,90,140,20);
        lblMeter.setForeground(Color.GRAY);
        lblMeter.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblMeter.setVisible(false);
        panel.add(lblMeter);// adding label on panel not on frame

        meter = new JTextField();
        meter.setBounds(260,90,150,20);
        meter.setVisible(false);
        panel.add(meter);

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBounds(100,130,140,20);
        lblUsername.setForeground(Color.GRAY);
        lblUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(lblUsername);// adding label on panel not on frame
        username = new JTextField();
        username.setBounds(260,130,150,20);
        panel.add(username);

        JLabel lblName = new JLabel("Name");
        lblName.setBounds(100,170,140,20);
        lblName.setForeground(Color.GRAY);
        lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(lblName);// adding label on panel not on frame

        name = new JTextField();
        name.setBounds(260,170,150,20);
        panel.add(name);

        meter.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent   fe) {

            }

            @Override
            public void focusLost(FocusEvent fe) {
                try{
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery("select * from login where meter_no = '"+meter.getText()+"'");
                    while(rs.next()){
                        name.setText(rs.getString("name"));
                    }
                }catch(Exception ee){
                    ee.printStackTrace();
                }
            }
        });

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setBounds(100,210,140,20);
        lblPassword.setForeground(Color.GRAY);
        lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(lblPassword);// adding label on panel not on frame

        password = new JTextField();
        password.setBounds(260,210,150,20);
        panel.add(password);

        accountType.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String user = accountType.getSelectedItem();
                if(user.equals("Customer")){
                     lblMeter.setVisible(true);
                     meter.setVisible(true);
                     name.setEditable(false);
                }else {
                    lblMeter.setVisible(false);
                    meter.setVisible(false);
                    name.setEditable(true);
                }
            }
        });

        create = new JButton("Create");
        create.setBounds(135,260,120,25);
        create.setFocusable(false);
        create.addActionListener(this);
        create.setBackground(Color.GRAY);
        create.setForeground(Color.black);
        panel.add(create);

        back = new JButton("Back");
        back.setBounds(275,260,120,25);
        back.setFocusable(false);
        back.addActionListener(this);
        back.setBackground(Color.GRAY);
        back.setForeground(Color.black);
        panel.add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/signupimage.png"));
        Image i2 = i1.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(415,30,250,250);
        panel.add(image);

        setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == create){
            String aType = accountType.getSelectedItem();
            String susername = username.getText();
            String sname = name.getText();
            String spassword = password.getText();
            String smeter = meter.getText();
            try{
                Conn c = new Conn();
                String query = null;
                if(aType.equals("Admin")) {
                    query = "insert into login values('" + smeter + "','" + susername + "','" + sname + "'," +
                            "'" + spassword + "','" + aType + "')";
                }else{
                    query = "update login set username = '"+susername+"',password = '"+spassword+"',user = '"+aType+"' where meter_no = '"+smeter+"' ";
                }

                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Account Created Successfully");
                setVisible(false);
                new Login();
            }catch (Exception ae){
                ae.printStackTrace();
            }

        } else if (e.getSource() == back) {
            setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args) {
        new SignUp();
    }
}
