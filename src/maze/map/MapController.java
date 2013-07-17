package maze.map;

import java.awt.*;

import maze.view.line.*;
import maze.utils.*;

public class MapController {

    private FloorMap floorMap;

    private int floorNo;
    private int xSize;
    private int ySize;

    private LocationController locationController;
    private LinePointHolder linePointHolder;

    public MapController(String mapFile, int floorNo, int xSize, int ySize) {
        this.floorNo = floorNo;
        this.xSize = xSize;
        this.ySize = ySize;

        this.locationController = new LocationController();
        this.linePointHolder = new LinePointHolder();

        init(mapFile);
    }

    private void init(String mapFile) {
        final MapLoader mapLoader = new MapLoader();

        this.floorMap = mapLoader.load(mapFile, getFloorNo(), getXSize(),
                getYSize());
    }

    private int getFloorNo() {
        return this.floorNo;
    }

    private int getXSize() {
        return this.xSize;
    }

    private int getYSize() {
        return this.ySize;
    }

    private FloorMap getFloorMap() {
        return this.floorMap;
    }

    private LocationController getLocationController() {
        return this.locationController;
    }

    private LinePointHolder getLinePointHolder() {
        return this.linePointHolder;
    }

    public String getLocationXForDisp() {
        return String.valueOf(getLocationController().getLocationX());
    }

    public String getLocationYForDisp() {
        return String.valueOf(getLocationController().getLocationY());
    }

    public String getDirectionForDisp() {
        switch (getLocationController().getDirection()) {
        case MazeConstant.DIRECTION_OF_NORTH:
            return "N";
        case MazeConstant.DIRECTION_OF_EAST:
            return "E";
        case MazeConstant.DIRECTION_OF_SOUTH:
            return "S";
        case MazeConstant.DIRECTION_OF_WEST:
            return "W";
        }
        return "?";
    }

    public void doAction(int aKeyCode) {
        switch (aKeyCode) {
        case MazeConstant.INPUT_KEY_UP:
            doMove();
            break;
        case MazeConstant.INPUT_KEY_RIGHT:
            getLocationController().turnRight();
            break;
        case MazeConstant.INPUT_KEY_DOWN:
            getLocationController().turnBack();
            break;
        case MazeConstant.INPUT_KEY_LEFT:
            getLocationController().turnLeft();
            break;
        }
    }

    private void doMove() {
        // 進行方向に壁がないかチェックする
        final MapCell cell = getFloorMap().getCell(
                getLocationController().getLocationX(),
                getLocationController().getLocationY());
        if (cell.isExistWall(getLocationController().getDirection())) {
            System.out.println("X = " + getLocationController().getLocationX()
                    + " Y = " + getLocationController().getLocationY());
            return;
        }

        getLocationController().move();
    }

    public void drawWall(Graphics aGraphics) {
        getLinePointHolder().drawWall(
                aGraphics,
                WallInfoCollectionFactory.createWallInfoCollection(
                        getLocationController(), getFloorMap()));
    }
}
