import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;

public class Main extends JFrame{
    public static void main(String[] args) {
        JMenu file, help;
        JMenuItem New, save, load;
        Component left, right;
        JFrame frame = new JFrame("SplitPaneFrame");
        Mouse m = new Mouse();
        JMenuBar mb=new JMenuBar();
        file=new JMenu("File");
        help=new JMenu("help");
        New=new JMenuItem("New");
        save=new JMenuItem("Save");
        load=new JMenuItem("Load");
        file.add(New);
        file.add(save);
        file.add(load);
        mb.add(file);
        mb.add(help);
        LeftPanel lp = new LeftPanel();
        left = lp.addText();
        RightPanel rp = new RightPanel(m);
        right = rp.plotGui(m);
        JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, left, right);
        split.setDividerLocation(500);
        frame.getContentPane().add(split);
        frame.setJMenuBar(mb);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(8000, 1000);
        frame.setVisible(true);

//        System.out.println("Hello world!");
//        JFrame frame = new JFrame("Assignment 4");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        JPanel mainPanel, subPanel1;
//        mainPanel = new JPanel(); // main panel
//        mainPanel.setLayout(new GridLayout(1, 2));
//        JTextArea jt = new JTextArea(10, 10);
//        mainPanel.add(jt);
////        mainPanel.setPreferredSize(new Dimension(100, 250));
//        mainPanel.setBounds(100,100, 150,150);
//        mainPanel.setBorder(BorderFactory.createLineBorder(Color.black, 1));
//        subPanel1 = new JPanel(); // sub-panel 1
//        subPanel1.add(new JLabel("Panel One", SwingConstants.CENTER));
//        subPanel1.setBackground(Color.red);
//        mainPanel.add(subPanel1);
//        frame.add(mainPanel);
//        frame.setSize(400, 300);
//        frame.setVisible(true);

    }
}