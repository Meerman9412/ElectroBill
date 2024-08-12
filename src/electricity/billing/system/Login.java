package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
    
public class Login extends JFrame implements ActionListener {
    JButton login,cancel,signUp;
    JTextField userName,password;
    Choice loginin;
    Login(){
        super("Login Page");
        ImageIcon a = new ImageIcon(ClassLoader.getSystemResource("icon/icon00900.png"));
        this.setIconImage(a.getImage());
        getContentPane().setBackground(Color.WHITE);
        this.setLayout(null);

        JLabel labeluserName = new JLabel("Username");
        labeluserName.setBounds(300,20,100,20);
        add(labeluserName);

        userName = new JTextField();
        userName.setBounds(400,20,150,20);
        add(userName);

        JLabel labelpassword = new JLabel("Password");
        labelpassword.setBounds(300,60,100,20);
        add(labelpassword);

        password = new JTextField();
        password.setBounds(400,60,150,20);
        add(password);

        JLabel labellogginginas = new JLabel("Login in as");
        labellogginginas.setBounds(300,100,100,20);
        add(labellogginginas);

        loginin = new Choice();
        loginin.add("Admin");
        loginin.add("Customer");
        loginin.setBounds(400,100,150,20);
        add(loginin);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
        Image i2 = i1.getImage().getScaledInstance(20, 16, Image.SCALE_DEFAULT);
        login = new JButton("Login",new ImageIcon(i2));
        login.addActionListener(this);
        login.setFocusable(false);
        login.setBounds(330,160,100,20);
        add(login);

        ImageIcon i3 = new ImageIcon(ClassLoader.getSystemResource("icon/cancel.jpg"));
        Image i4 = i3.getImage().getScaledInstance(20, 16, Image.SCALE_DEFAULT);
        cancel = new JButton("Cancel",new ImageIcon(i4));
        cancel.addActionListener(this);
        cancel.setFocusable(false);
        cancel.setBounds(450,160,100,20);
        add(cancel);

        ImageIcon i5 = new ImageIcon(ClassLoader.getSystemResource("icon/signup.png"));
        Image i6 = i5.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        signUp = new JButton("Sign Up",new ImageIcon(i6));
        signUp.addActionListener(this);
        signUp.setFocusable(false);
        signUp.setBounds(380,200,100,20);
        add(signUp);

        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icon/second.jpg"));
        Image i8 = i7.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel image = new JLabel(i9);
        image.setBounds(0,0,250,250);
        add(image);

        this.setSize(640,300);
        this.setLocation(400,200);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == login){
            String suername = userName.getText();
            String spassword = password.getText();
            String user = loginin.getSelectedItem();

            try {
                Conn c = new Conn();
                String query = "select * from login where username = '"+suername+"' and password = '"+spassword+"'and user = '"+user+"'";
                ResultSet rs = c.s.executeQuery(query);

                if(rs.next()){
                    String meter = rs.getString("meter_no");
                    setVisible(false);
                    new Project(user,meter);
                }else{
                    userName.setText("");
                    password.setText("");
                    JOptionPane.showMessageDialog(null,"Invalid Login");
                }
            }
            catch (Exception ea){
                ea.printStackTrace();
            }
        } else if (ae.getSource() == cancel) {
            setVisible(false);
        }else if (ae.getSource() == signUp){
            setVisible(false);
            new SignUp();
        }

    }
    public static void main(String[] args) {
        new Login();
    }
}
