package maze.view.line;

import java.awt.Graphics;
import java.util.*;

public class LinePointHolder {

    private final List<Wall> leftWallList;
    private final List<Wall> rightWallList;
    private final List<Wall> frontWallList;

    public LinePointHolder() {
        leftWallList = WallFactory.createSideWallList(
                WallFactory.LEFT_CEILING_POINTS, WallFactory.LEFT_FLOOR_POINTS);
        rightWallList = WallFactory.createSideWallList(
                WallFactory.RIGHT_CEILING_POINTS,
                WallFactory.RIGHT_FLOOR_POINTS);

        frontWallList = WallFactory.createFrontWallList();
    }

    public void drawWall(Graphics graphics,
            WallInfoCollection wallInfoCollection) {

        for (WallInfo each : wallInfoCollection) {
            // 左壁の描画
            if (each.isExistLeftWall()) {
                leftWallList.get(each.getDistance()).drawWall(graphics);
            }

            // 右壁の描画
            if (each.isExistRightWall()) {
                rightWallList.get(each.getDistance()).drawWall(graphics);
            }

            // 正面壁の描画
            if (each.isExistFrontWall()) {
                frontWallList.get(each.getDistance()).drawWall(graphics);
            }

        }
    }
}
