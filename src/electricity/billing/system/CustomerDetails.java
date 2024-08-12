package electricity.billing.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class CustomerDetails extends JFrame implements ActionListener {
    Choice meterNumber,meterMonth;
    JTable table;
    JButton search,print;
    CustomerDetails(){
        super("Customer Details");
        ImageIcon a = new ImageIcon(ClassLoader.getSystemResource("icon/icon00900.png"));
        this.setIconImage(a.getImage());
        this.setBounds(100,60,1200,650);


        table = new JTable();
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception ee){
            ee.printStackTrace();
        }
        JScrollPane sp = new JScrollPane(table);
        add(sp);

        print = new JButton("Print");
        print.setFocusable(false);
        print.addActionListener(this);
        this.add(print,"South");

        setVisible(true);
    }
    public static void main(String[] args) {
        new CustomerDetails();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            try{
                table.print();
            }catch (Exception ee){
                ee.printStackTrace();
            }
        }
    }

