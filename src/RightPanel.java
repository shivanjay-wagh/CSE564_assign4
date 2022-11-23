import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import javax.swing.event.MouseInputListener;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class RightPanel extends JPanel implements Observable {

    private static RightPanel rightPanel;
    private static ArrayList<Box> boxes;
    private static ArrayList<Box> mouseTracker;

    public RightPanel() {
    }

    JPanel jPanel;

    public RightPanel getRightPanel() {

        if (rightPanel == null) {
            rightPanel = new RightPanel();
            boxes = new ArrayList<>();
            mouseTracker = new ArrayList<>();
        }

        rightPanel.setLayout(null);
        rightPanel.addMouseListener(new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();

                String className = JOptionPane.showInputDialog("Class Name");
                if ((className != null)) {
                    if (className.length() == 0) {
                        // Can generate a random class name as well
                        className = "noClassName";
                    }
                    Box newBox = new Box(x, y, className, rightPanel);
                    boxes.add(newBox);
                    //addupdate

                    rightPanel.add(newBox);
                    rightPanel.revalidate();
                    rightPanel.repaint();
                    sendUpdate();
                }
            }
        });
        return rightPanel;
    }

    public void listRenderedBoxes() {
        for (Box x : boxes)
            System.out.print(x + ",");
        System.out.println();
    }

    public void boxClickTracker(Box box) {
        mouseTracker.add(box);
        if (mouseTracker.size() == 2) {
            System.out.println("Invoke an arrow function");
            System.out.println(mouseTracker.get(0));
            System.out.println(mouseTracker.get(1));
            mouseTracker.clear();

            JOptionPane popup = new JOptionPane();

            JRadioButton nicSelect = new JRadioButton("What is the relationship");
            JRadioButton b1 = new JRadioButton("Inheritance");
            JRadioButton b2 = new JRadioButton("Composition");
            JRadioButton b3 = new JRadioButton("Association");
            popup.add(nicSelect);
            popup.add(b1);
            popup.add(b2);
            popup.add(b3);

            //JPanel panel = new JPanel();
//            this.add(new JRadioButton("radio"));
//            JOptionPane.showOptionDialog(null, this,
//                    "Radio Test", JOptionPane.YES_NO_CANCEL_OPTION,
//                    JOptionPane.QUESTION_MESSAGE, null, null, null);



            String[] options = new String[] {"Inheritance", "Composition", "Association"};
            int response = JOptionPane.showOptionDialog(null, "Select Relation", "Relation",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                    null, options, options[0]);
            //System.out.println("response" + response);   //response 0 = inheritance

            if(response==0){
                System.out.println("Inheritance");
            }
            else if(response==1){
                System.out.println("Composition");
            }
            else System.out.println("Association");


        




        }

    }


    @Override
    public void addSubscriber(Observer o) {
        observerArrayList.add(o);
        System.out.println("in addsubscriber");

    }

    @Override
    public void removeSubscriber(Observer o) {
        int observerIndex = observerArrayList.indexOf(o);
        observerArrayList.remove(observerIndex);
    }

    @Override
    public void sendUpdate() {
        for(Observer observer: observerArrayList){
            observer.update(boxes);
        }


    }
}