import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class RightPanel extends JPanel implements Observable {

    private static RightPanel rightPanel;
    private static ArrayList<Box> boxes;
    private static ArrayList<Box> mouseTracker;

    private RightPanel() {
    }

    JPanel jPanel;

    public static RightPanel getRightPanel() {

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
                    Box newBox = new Box(x, y, className);
                    boxes.add(newBox);
                    // addupdate

                    rightPanel.add(newBox);
                    rightPanel.revalidate();
                    rightPanel.repaint();
                    rightPanel.sendUpdate();
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
            // System.out.println("Invoke an arrow function");

            // JOptionPane popup = new JOptionPane();

            // JRadioButton nicSelect = new JRadioButton("What is the relationship");
            // JRadioButton b1 = new JRadioButton("Inheritance");
            // JRadioButton b2 = new JRadioButton("Composition");
            // JRadioButton b3 = new JRadioButton("Association");
            // popup.add(nicSelect);
            // popup.add(b1);
            // popup.add(b2);
            // popup.add(b3);

            // String[] options = new String[] { "Inheritance", "Composition", "Association"
            // };
            // int response = JOptionPane.showOptionDialog(null, "Select Relation",
            // "Relation",
            // JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
            // null, options, options[0]);

            int response = 0;
            if (response == 0) {
                System.out.println("Inheritance");
                Arrow inheritanceLine = new InheritanceDecoration(new JustLine());
                System.out.println(inheritanceLine);
                rightPanel.add(inheritanceLine.drawLine(100, 100, 500, 100));
                rightPanel.revalidate();
                rightPanel.repaint();
            } else if (response == 1) {
                System.out.println("Composition");
            } else
                System.out.println("Association");

            mouseTracker.clear();
        }
    }

    @Override
    public void addSubscriber(Observer o) {
        observerArrayList.add(o);
    }

    @Override
    public void removeSubscriber(Observer o) {
        int observerIndex = observerArrayList.indexOf(o);
        observerArrayList.remove(observerIndex);
    }

    @Override
    public void sendUpdate() {
        for (Observer observer : observerArrayList) {
            observer.update(boxes);
        }
    }
}