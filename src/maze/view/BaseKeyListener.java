package maze.view;

import java.awt.event.*;

public class BaseKeyListener extends KeyAdapter {

    private final BaseFrame frame;

    BaseKeyListener(BaseFrame frame) {
        this.frame = frame;
    }

    public void keyPressed(KeyEvent e) {
        getFrame().repaint();
    }

    private BaseFrame getFrame() {
        return this.frame;
    }
}
