package electricity.billing.system;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame implements Runnable {
    Splash(){
        super("Electricity Billing System");
        ImageIcon a = new ImageIcon(ClassLoader.getSystemResource("icon/icon00900.png"));
        this.setIconImage(a.getImage());
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icon/elect.jpg"));
        Image i2 = i1.getImage().getScaledInstance(730,550, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image2 = new JLabel(i3);
        add(image2);

        this.setVisible(true);

        int x =0;
        for(int i =2;i<600;i+=4,x+=1) {
            this.setSize(i+x, i);
            this.setLocation(700 -((i+x)/2), 350 - (i/2));
            try{
                Thread.sleep(1);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        Thread t = new Thread(this);
        t.start();
    }
    public static void main(String[] args) {
        new Splash();
    }

    @Override
    public void run() {
        try{
            Thread.sleep(7000);
            this.setVisible(false);

            // login page
            new Login();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
