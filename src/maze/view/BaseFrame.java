package maze.view;

import java.awt.*;
import java.awt.event.*;

import maze.utils.*;

import maze.map.*;

public class BaseFrame extends Frame implements KeyListener {

    private static final long serialVersionUID = 1L;

    private final int X_LENGTH = 800;
    private final int Y_LENGTH = 800;

    private final int WINDOW_X_POSITION = 200;
    private final int WINDOW_Y_POSITION = 200;

    private MapController mapManager;

    public BaseFrame() {
        super();

        init();
    }

    private void createMapManager() {
        this.mapManager = new MapController(MazeConstant.INIT_MAP_FILE,
                MazeConstant.INIT_MAP_FLOOR_NO, MazeConstant.INIT_MAP_SIZE_X,
                MazeConstant.INIT_MAP_SIZE_Y);
    }

    private MapController getMapManager() {
        return this.mapManager;
    }

    private void init() {

        // マップ作成
        createMapManager();

        // サイズ設定
        setSize(X_LENGTH, Y_LENGTH);

        // タイトル設定
        setTitle("Wizardy");

        // 表示位置
        setLocation(WINDOW_X_POSITION, WINDOW_Y_POSITION);

        // 背景色設定
        setBackground(Color.BLACK);

        // フォント設定
        setFont(new Font("", Font.BOLD, 24));

        // ウィンドウメッセージ取得用設定
        WindowListener windowListener = new WindowListener();
        addWindowListener(windowListener);

        // KeyListnerのセット
        this.addKeyListener(this);

        // キー入力取得用設定
        BaseKeyListener keyListener = new BaseKeyListener(this);

        addKeyListener(keyListener);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

    }

    public void keyPressed(KeyEvent e) {
        final int keyCode = e.getKeyCode();

        getMapManager().doAction(keyCode);
    }

    public void keyReleased(KeyEvent e) {
        //
    }

    public void keyTyped(KeyEvent e) {
        //
    }

    public void paint(Graphics graphics) {
        getMapManager().drawWall(graphics);

        // 座標表示
        graphics.setColor(Color.WHITE);
        graphics.drawString("X = " + getMapManager().getLocationXForDisp(), 30,
                70);
        graphics.drawString("Y = " + getMapManager().getLocationYForDisp(), 30,
                100);
        graphics.drawString("Dir " + getMapManager().getDirectionForDisp(), 30,
                130);
    }
}
