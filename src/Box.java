import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.event.MouseInputAdapter;
import javax.swing.event.MouseInputListener;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class Box extends JPanel implements MouseInputListener {

   int x, y;
   RightPanel rp;
   String className = "noClassName";
   boolean pressedCancel = false;

   // CAN USE BOX FACTORY FOR VALIDATION > IF THEY PRESSED CANCEL ON DIALOG;
   public Box(int x, int y, String className) {
      // String className = JOptionPane.showInputDialog("Class Name");
      // if ((className != null)) {
      // if (className.length() == 0) {
      // className = "no ClassName";
      // }
      this.rp = RightPanel.getRightPanel();
      this.className = className;
      addMouseListener(this);
      this.setLayout(new GridBagLayout());
      this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
      this.x = x;
      this.y = y;
      this.setLocation(x, y);
      JTextArea ta = new JTextArea();
      this.setSize(200, 60);
      ta.setSize(100, 40);
      ta.setBackground(Color.YELLOW);
      ta.setText(className);
      this.add(ta);
      this.setBackground(Color.RED);
   // }else this.pressedCancel=true;

   }

   public boolean boxCreated() {
      return !this.pressedCancel;
   }

   @Override
   public void mouseClicked(MouseEvent e) {
      rp.boxClickTracker(this);
   }

   @Override
   public void mousePressed(MouseEvent e) {

   }

   @Override
   public void mouseReleased(MouseEvent e) {

   }

   @Override
   public void mouseEntered(MouseEvent e) {

   }

   @Override
   public void mouseExited(MouseEvent e) {

   }

   @Override
   public void mouseDragged(MouseEvent e) {

   }

   @Override
   public void mouseMoved(MouseEvent e) {

   }

}