package maze.view;

import java.awt.event.*;

public class WindowListener extends WindowAdapter {

    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }

}
