package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class Project extends JFrame implements ActionListener {
    String aType,meter;
     Project(String aType,String meter){
         super("ElectroBill");
         this.aType = aType;
         this.meter = meter;
         ImageIcon a = new ImageIcon(ClassLoader.getSystemResource("icon/icon00900.png"));
         this.setIconImage(a.getImage());

         setExtendedState(JFrame.MAXIMIZED_BOTH);
         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/elect1.jpg"));
         Image i2 = i1.getImage().getScaledInstance(1550,850, Image.SCALE_DEFAULT);
         JLabel label = new JLabel(new ImageIcon(i2));
         this.add(label);

         // adding menu Bar
         JMenuBar mb = new JMenuBar();
         this.setJMenuBar(mb);

         JMenu master = new JMenu("Master");
         master.setForeground(Color.blue);


         JMenuItem newCustomer = new JMenuItem("New Customer");
         newCustomer.setFont(new Font("monospaced", Font.PLAIN, 12));
         ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("icon/icon1.png"));
         Image image1 = icon1.getImage().getScaledInstance(20,20, Image.SCALE_DEFAULT);
         newCustomer.setIcon(new ImageIcon(image1));
         newCustomer.setMnemonic('C');
         newCustomer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
         newCustomer.setFocusable(false);
         newCustomer.addActionListener(this);
         newCustomer.setBackground(Color.WHITE);
         master.add(newCustomer);

         JMenuItem customerDetails = new JMenuItem("Customer Details");
         customerDetails.setFont(new Font("monospaced", Font.PLAIN, 12));
         ImageIcon icon2 = new ImageIcon(ClassLoader.getSystemResource("icon/icon2.png"));
         Image image2 = icon2.getImage().getScaledInstance(20,20, Image.SCALE_DEFAULT);
         customerDetails.setIcon(new ImageIcon(image2));
         customerDetails.setMnemonic('M');
         customerDetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.CTRL_MASK));
         customerDetails.setFocusable(false);
         customerDetails.addActionListener(this);
         customerDetails.setBackground(Color.WHITE);
         master.add(customerDetails);

         JMenuItem DepositDetails = new JMenuItem("Deposit Details");
         DepositDetails.setFont(new Font("monospaced", Font.PLAIN, 12));
         ImageIcon icon3 = new ImageIcon(ClassLoader.getSystemResource("icon/icon3.png"));
         Image image3 = icon3.getImage().getScaledInstance(20,20, Image.SCALE_DEFAULT);
         DepositDetails.setIcon(new ImageIcon(image3));
         DepositDetails.setMnemonic('D');
         DepositDetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
         DepositDetails.setFocusable(false);
         DepositDetails.addActionListener(this);
         DepositDetails.setBackground(Color.WHITE);
         master.add(DepositDetails);

         JMenuItem CalculateBill = new JMenuItem("Calculate Bill");
         CalculateBill.setFont(new Font("monospaced", Font.PLAIN, 12));
         ImageIcon icon4 = new ImageIcon(ClassLoader.getSystemResource("icon/icon5.png"));
         Image image4 = icon4.getImage().getScaledInstance(20,20, Image.SCALE_DEFAULT);
         CalculateBill.setIcon(new ImageIcon(image4));
         CalculateBill.setMnemonic('B');
         CalculateBill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
         CalculateBill.setFocusable(false);
         CalculateBill.addActionListener(this);
         CalculateBill.setBackground(Color.WHITE);
         master.add(CalculateBill);

         JMenu info = new JMenu("Information");
         info.setForeground(Color.RED);


         JMenuItem UpdateInfo = new JMenuItem("Update Information");
         UpdateInfo.setFont(new Font("monospaced", Font.PLAIN, 12));
         ImageIcon icon5 = new ImageIcon(ClassLoader.getSystemResource("icon/icon4.png"));
         Image image5 = icon5.getImage().getScaledInstance(20,20, Image.SCALE_DEFAULT);
         UpdateInfo.setIcon(new ImageIcon(image5));
         UpdateInfo.setMnemonic('P');
         UpdateInfo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
         UpdateInfo.setFocusable(false);
         UpdateInfo.addActionListener(this);
         UpdateInfo.setBackground(Color.WHITE);
         info.add(UpdateInfo);

         JMenuItem ViewInfo = new JMenuItem("View Information");
         ViewInfo.setFont(new Font("monospaced", Font.PLAIN, 12));
         ImageIcon icon6 = new ImageIcon(ClassLoader.getSystemResource("icon/icon6.png"));
         Image image6 = icon6.getImage().getScaledInstance(20,20, Image.SCALE_DEFAULT);
         ViewInfo.setIcon(new ImageIcon(image6));
         ViewInfo.setMnemonic('L');
         ViewInfo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
         ViewInfo.setFocusable(false);
         ViewInfo.addActionListener(this);
         ViewInfo.setBackground(Color.WHITE);
         info.add(ViewInfo);

         JMenu User = new JMenu("User");
         User.setForeground(Color.BLUE);

         JMenuItem payBill = new JMenuItem("Pay Bill");
         payBill.setFont(new Font("monospaced", Font.PLAIN, 12));
         ImageIcon icon7 = new ImageIcon(ClassLoader.getSystemResource("icon/icon4.png"));
         Image image7 = icon7.getImage().getScaledInstance(20,20, Image.SCALE_DEFAULT);
         payBill.setIcon(new ImageIcon(image7));
         payBill.setMnemonic('R');
         payBill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));
         payBill.setFocusable(false);
         payBill.addActionListener(this);
         payBill.setBackground(Color.WHITE);
         User.add(payBill);

         JMenuItem bill_details = new JMenuItem("Bill Details");
         bill_details.setFont(new Font("monospaced", Font.PLAIN, 12));
         ImageIcon icon8 = new ImageIcon(ClassLoader.getSystemResource("icon/icon6.png"));
         Image image8 = icon8.getImage().getScaledInstance(20,20, Image.SCALE_DEFAULT);
         bill_details.setIcon(new ImageIcon(image8));
         bill_details.setMnemonic('B');
         bill_details.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
         bill_details.setFocusable(false);
         bill_details.addActionListener(this);
         bill_details.setBackground(Color.WHITE);
         User.add(bill_details);

         JMenu report = new JMenu("Report");
         report.setForeground(Color.RED);


         JMenuItem generate_bill = new JMenuItem("Generate Bill");
         generate_bill.setFont(new Font("monospaced", Font.PLAIN, 12));
         ImageIcon icon9= new ImageIcon(ClassLoader.getSystemResource("icon/icon7.png"));
         Image image9 = icon9.getImage().getScaledInstance(20,20, Image.SCALE_DEFAULT);
         generate_bill.setIcon(new ImageIcon(image9));
         generate_bill.setMnemonic('G');
         generate_bill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, ActionEvent.CTRL_MASK));
         generate_bill.setFocusable(false);
         generate_bill.addActionListener(this);
         generate_bill.setBackground(Color.WHITE);
         report.add(generate_bill);

         JMenu utility = new JMenu("Utility");
         utility.setForeground(Color.BLUE);


         JMenuItem notepad = new JMenuItem("Notepad");
         notepad.setFont(new Font("monospaced", Font.PLAIN, 12));
         ImageIcon icon10= new ImageIcon(ClassLoader.getSystemResource("icon/icon12.png"));
         Image image10 = icon10.getImage().getScaledInstance(20,20, Image.SCALE_DEFAULT);
         notepad.setIcon(new ImageIcon(image10));
         notepad.setMnemonic('N');
         notepad.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
         notepad.setFocusable(false);
         notepad.addActionListener(this);
         notepad.setBackground(Color.WHITE);
         utility.add(notepad);

         JMenuItem calculator = new JMenuItem("Calculator");
         calculator.setFont(new Font("monospaced", Font.PLAIN, 12));
         ImageIcon icon11= new ImageIcon(ClassLoader.getSystemResource("icon/icon9.png"));
         Image image11 = icon11.getImage().getScaledInstance(20,20, Image.SCALE_DEFAULT);
         calculator.setIcon(new ImageIcon(image11));
         calculator.setMnemonic('A');
         calculator.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
         calculator.setFocusable(false);
         calculator.addActionListener(this);
         calculator.setBackground(Color.WHITE);
         utility.add(calculator);

         JMenu exit = new JMenu("Exit");
         exit.setForeground(Color.RED);
         if(aType.equals("Admin")) {
             mb.add(master);
         }else {
             mb.add(info);
             mb.add(User);
             mb.add(report);
         }
         mb.add(utility);
         mb.add(exit);


         JMenuItem exit1 = new JMenuItem("Exit");
         notepad.setFont(new Font("monospaced", Font.PLAIN, 12));
         ImageIcon icon12= new ImageIcon(ClassLoader.getSystemResource("icon/icon11.png"));
         Image image12 = icon12.getImage().getScaledInstance(20,20, Image.SCALE_DEFAULT);
         exit1.setIcon(new ImageIcon(image12));
         exit1.setMnemonic('W');
         exit1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK));
         exit1.setFocusable(false);
         exit1.addActionListener(this);
         exit1.setBackground(Color.WHITE);
         exit.add(exit1);

         setLayout(new FlowLayout());
         setVisible(true);
     }
    public static void main(String[] args) {
        new Project("","");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String msg = e.getActionCommand();
        if(msg.equals("New Customer")){
            new NewCustomer();
        } else if (msg.equals("Customer Details")) {
            new CustomerDetails();
        } else if (msg.equals("Deposit Details")) {
            new DepositDetails();
        } else if (msg.equals("Calculate Bill")) {
            new CalculateBills();
        } else if (msg.equals("View Information")) {
            new ViewInformation(meter);
        }else if (msg.equals("Update Information")){
            new UpdateInformation(meter);
        }else if (msg.equals("Bill Details")){
            new BillDetails(meter);
        }else if (msg.equals("Notepad")){
            try{
                Runtime.getRuntime().exec("notepad.exe");
            }catch (Exception ee){
                ee.printStackTrace();
            }
        } else if (msg.equals("Calculator")) {
            try {
                Runtime.getRuntime().exec("calc.exe");
            }catch (Exception e1){
                e1.printStackTrace();
            }
        } else if (msg.equals("Exit")) {
            setVisible(false);
            new Login();
        } else if (msg.equals("Pay Bill")) {
            new PayBill(meter);
        }else if (msg.equals("Generate Bill")){
            new GenerateBill(meter);
        }
    }
}
