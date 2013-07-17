package maze.utils;

public class MazeConstant {

    public final static int X_LENGTH = 800;
    public final static int Y_LENGTH = 800;

    public final static int DIRECTION_OF_NORTH = 0;
    public final static int DIRECTION_OF_EAST = 1;
    public final static int DIRECTION_OF_SOUTH = 2;
    public final static int DIRECTION_OF_WEST = 3;

    public final static int DIRECTION_OF_START = 0;
    public final static int DIRECTION_OF_END = 3;

    public final static int ATTRIBUTE_OF_NON = 0;
    public final static int ATTRIBUTE_OF_WALL = 1;
    public final static int ATTRIBUTE_OF_DOOR = 2;

    public final static String INIT_MAP_FILE = "TestMap.csv";
    public final static int INIT_MAP_FLOOR_NO = 1;
    public final static int INIT_MAP_SIZE_X = 5;
    public final static int INIT_MAP_SIZE_Y = 5;

    public final static int MAP_CSV_INDEX_X = 0;
    public final static int MAP_CSV_INDEX_Y = 1;
    public final static int MAP_CSV_INDEX_NORTH = 2;
    public final static int MAP_CSV_INDEX_EAST = 3;
    public final static int MAP_CSV_INDEX_SOUTH = 4;
    public final static int MAP_CSV_INDEX_WEST = 5;

    public final static int LOCATION_ORIGIN_X = 0;
    public final static int LOCATION_ORIGIN_Y = 0;

    public static final int INPUT_KEY_UP = 38;
    public static final int INPUT_KEY_RIGHT = 39;
    public static final int INPUT_KEY_DOWN = 40;
    public static final int INPUT_KEY_LEFT = 37;

    public static final int VISIBILITY_RANGE_NORMAL = 3;
    public static final int VISIBILITY_RANGE_WIDE = 5;
}