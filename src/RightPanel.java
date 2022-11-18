import javax.swing.*;
import java.awt.*;

public class RightPanel extends JPanel{
    Mouse m;
    RightPanel() {
        JPanel p1 = new JPanel();
    }
    RightPanel(Mouse m){
        this.m = m;
    }
    Component plotGui(Mouse m){
//        JPanel subPanel1 = new JPanel();
        this.addMouseListener(m);
        return this;
    }
//
//    Box getbox(Box b){
//
//    }
    @Override
    public void paintComponent (Graphics g)
    {

        int xCoord = m.getXCoord();
        int yCoord = m.getYCoord();

        System.out.println(xCoord + " " + yCoord);

        Box box = new Box(xCoord, yCoord);

        super.paintComponent(g);
        setForeground(Color.black);
        setForeground(Color.yellow);
        //g.drawLine(xpoints[0], ypoints[0],xpoints[1], ypoints[1]);

        g.fillRect(xCoord, yCoord, 200, 100);
    }
}
