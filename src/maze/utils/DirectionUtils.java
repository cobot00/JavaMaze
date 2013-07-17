package maze.utils;

public class DirectionUtils {

    private DirectionUtils() {
        // コンストラクタの隠蔽
    }

    public final static int getLeftDirection(int direction) {
        if (direction == MazeConstant.DIRECTION_OF_NORTH) {
            return MazeConstant.DIRECTION_OF_WEST;
        }
        return direction - 1;
    }

    public final static int getRightDirection(int direction) {
        if (direction == MazeConstant.DIRECTION_OF_WEST) {
            return MazeConstant.DIRECTION_OF_NORTH;
        }
        return direction + 1;
    }
}
