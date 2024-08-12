package electricity.billing.system;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Paytm extends JFrame implements ActionListener {
    String meter;
    JButton back ;
    Paytm(String meter){
        super("Paytm");
        ImageIcon a = new ImageIcon(ClassLoader.getSystemResource("icon/icon00900.png"));
        this.setIconImage(a.getImage());
        this.meter = meter;

        JEditorPane j  = new JEditorPane();
        j.setEditable(false);

        try {
            j.setPage("https://paytm.com/online-payments");
        }catch (Exception e){
            j.setContentType("text/html");
            j.setText("<html>Could not load<html>");
        }

        JScrollPane pane = new JScrollPane(j);
        add(pane);

        back = new JButton("Back");
        back.setBounds(640,20,80,30);
        back.addActionListener(this);
        j.add(back);

        setBounds(350,100,800,600);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Paytm("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new PayBill(meter);
    }
}
