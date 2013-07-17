package maze.view.line;

import java.awt.Color;
import java.awt.Graphics;

public class Wall {

    private final LinePoint ceilingPoint;
    private final LinePoint floorPoint;

    Wall(LinePoint ceilingPoint, LinePoint floorPoint) {
        this.ceilingPoint = ceilingPoint;
        this.floorPoint = floorPoint;
    }

    void drawWall(Graphics graphics) {
        // 天井側のライン
        drawWall(graphics, ceilingPoint.getFromPoint(),
                ceilingPoint.getToPoint());
        // 床側のライン
        drawWall(graphics, floorPoint.getFromPoint(), floorPoint.getToPoint());

        // 壁の区切りライン
        drawWall(graphics, ceilingPoint.getToPoint(), floorPoint.getToPoint());
    }

    private void drawWall(Graphics graphics, DrawPoint fromPoint,
            DrawPoint toPoint) {
        graphics.setColor(Color.WHITE);
        graphics.drawLine(fromPoint.getPointX(), fromPoint.getPointY(),
                toPoint.getPointX(), toPoint.getPointY());
    }

}
