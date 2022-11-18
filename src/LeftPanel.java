import javax.swing.*;
import java.awt.*;

public class LeftPanel {
    LeftPanel(){

    }
    Component addText(){
        JTextArea jt = new JTextArea(10, 10);
        Component left = new JScrollPane(jt);
        return left;
    }
}
