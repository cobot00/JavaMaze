package maze.view.line;

import java.util.*;

public class WallFactory {

    private static final int WALL_COUNT = 3;

    // 左壁描画に関する座標設定
    static final int[][] LEFT_CEILING_POINTS = { { 0, 0 }, { 120, 120 },
            { 240, 240 }, { 320, 320 } };
    static final int[][] LEFT_FLOOR_POINTS = { { 0, 800 }, { 120, 680 },
            { 240, 560 }, { 320, 480 } };

    // 右壁描画に関する座標設定
    static final int[][] RIGHT_CEILING_POINTS = { { 800, 0 }, { 680, 120 },
            { 560, 240 }, { 480, 320 } };
    static final int[][] RIGHT_FLOOR_POINTS = { { 800, 800 }, { 680, 680 },
            { 560, 560 }, { 480, 480 } };

    private static final int INDEX_X = 0;
    private static final int INDEX_Y = 1;

    private WallFactory() {
        // コンストラクタの隠蔽
    }

    /**
     * 左右の壁に関する座標情報を生成します。
     * 
     * @param ceilingPoints
     * @param floorPoints
     * @return
     */
    public static List<Wall> createSideWallList(int[][] ceilingPoints,
            int[][] floorPoints) {
        final List<Wall> result = new ArrayList<Wall>();

        for (int i = 0; i < WALL_COUNT; i++) {
            result.add(new Wall(createSideLinePoint(ceilingPoints, i),
                    createSideLinePoint(floorPoints, i)));
        }

        return result;
    }

    /**
     * 左右の壁に関する座標情報を生成します。
     * 
     * @param points
     * @param index
     * @return
     */
    private static LinePoint createSideLinePoint(int[][] points, int index) {
        final DrawPoint fromPoint = new DrawPoint(points[index][INDEX_X],
                points[index][INDEX_Y]);
        final DrawPoint toPoint = new DrawPoint(points[index + 1][INDEX_X],
                points[index + 1][INDEX_Y]);

        return new LinePoint(fromPoint, toPoint);
    }

    public static List<Wall> createFrontWallList() {
        final List<Wall> result = new ArrayList<Wall>();

        for (int i = 1; i <= WALL_COUNT; i++) {
            result.add(new Wall(createFrontLinePoint(LEFT_CEILING_POINTS[i],
                    RIGHT_CEILING_POINTS[i]), createFrontLinePoint(
                    LEFT_FLOOR_POINTS[i], RIGHT_FLOOR_POINTS[i])));
        }

        return result;
    }

    private static LinePoint createFrontLinePoint(int[] leftPoint,
            int[] rightPoint) {
        final DrawPoint fromPoint = new DrawPoint(leftPoint[INDEX_X],
                leftPoint[INDEX_Y]);
        final DrawPoint toPoint = new DrawPoint(rightPoint[INDEX_X],
                rightPoint[INDEX_Y]);

        return new LinePoint(fromPoint, toPoint);
    }
}
