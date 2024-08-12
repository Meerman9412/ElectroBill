package electricity.billing.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
public class DepositDetails extends JFrame implements ActionListener {
    Choice meterNumber,meterMonth;
    JTable table;
    JButton search,print;
    DepositDetails(){
        super("Deposit Details");
        ImageIcon a = new ImageIcon(ClassLoader.getSystemResource("icon/icon00900.png"));
        this.setIconImage(a.getImage());
        this.setBounds(400,50,700,600);

        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel lblMeterNumber = new JLabel("Search By Meter Number");
        lblMeterNumber.setBounds(20,20,150,20);
        this.add(lblMeterNumber);

        meterNumber = new Choice();
        meterNumber.setBounds(180,20,150,20);
        meterNumber.setFocusable(false);
        this.add(meterNumber);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while (rs.next()){
                meterNumber.add(rs.getString("meter_no"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel lblMonth = new JLabel("Search By Month");
        lblMonth.setBounds(400,20,100,20);
        this.add(lblMonth);

        meterMonth = new Choice();
        meterMonth.setBounds(520,20,150,20);
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

        table = new JTable();
         try{
             Conn c = new Conn();
             ResultSet rs = c.s.executeQuery("select * from bill");
             table.setModel(DbUtils.resultSetToTableModel(rs));
         }catch (Exception ee){
             ee.printStackTrace();
         }
         JScrollPane sp = new JScrollPane(table);
         sp.setBounds(0,100,700,600);
         add(sp);

         search = new JButton("Search");
         search.setBounds(20,70,80,20);
         search.setFocusable(false);
         search.addActionListener(this);
         add(search);

        print = new JButton("Print");
        print.setBounds(120,70,80,20);
        print.setFocusable(false);
        print.addActionListener(this);
        this.add(print );

        setVisible(true);
    }
    public static void main(String[] args) {
        new DepositDetails();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==search){
            String query = "select * from bill where meter_no = '"+meterNumber.getSelectedItem()+"'and month = '"+meterMonth.getSelectedItem()+"'";

            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch (Exception eee){
                eee.printStackTrace();
            }
        } else if (e.getSource() == print) {
            try{
                table.print();
            }catch (Exception ee){
                ee.printStackTrace();
            }
        }
    }
}
