package electricity.billing.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BillDetails extends JFrame implements ActionListener {

    BillDetails(String meter){
        super("Bill Details");
        ImageIcon a = new ImageIcon(ClassLoader.getSystemResource("icon/icon00900.png"));
        this.setIconImage(a.getImage());
        getContentPane().setBackground(Color.WHITE);

        JTable table = new JTable();

        try{
            Conn c = new Conn();
            String query = "select * from where meter_no = '"+meter+"'";
            ResultSet rs = c.s.executeQuery(query);

            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e){
            e.printStackTrace();
        }

        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(0,0,700,650);
        this.add(table);
        setVisible(true);
    }

    public static void main(String[] args) {
        new BillDetails("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
