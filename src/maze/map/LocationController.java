package maze.map;

import maze.utils.*;

public class LocationController {

    private int floorNo;
    private int locationX;
    private int locationY;
    private int direction;

    LocationController() {
        this.floorNo = 1;
        this.locationX = MazeConstant.LOCATION_ORIGIN_X;
        this.locationY = MazeConstant.LOCATION_ORIGIN_Y;
        this.direction = MazeConstant.DIRECTION_OF_NORTH;
    }

    public int getFloorNo() {
        return this.floorNo;
    }

    public int getLocationX() {
        return this.locationX;
    }

    public int getLocationY() {
        return this.locationY;
    }

    public int getDirection() {
        return this.direction;
    }

    void move() {
        switch (getDirection()) {
        case MazeConstant.DIRECTION_OF_NORTH:
            this.locationY = this.locationY + 1;
            break;
        case MazeConstant.DIRECTION_OF_EAST:
            this.locationX = this.locationX + 1;
            break;
        case MazeConstant.DIRECTION_OF_SOUTH:
            this.locationY = this.locationY - 1;
            break;
        case MazeConstant.DIRECTION_OF_WEST:
            this.locationX = this.locationX - 1;
            break;
        }
    }

    void turnRight() {
        this.direction++;

        // 右回りで1周したら北向きになる
        if (this.direction > MazeConstant.DIRECTION_OF_WEST) {
            this.direction = MazeConstant.DIRECTION_OF_NORTH;
        }
    }

    void turnLeft() {
        this.direction--;

        // 左回りで1周したら西向きになる
        if (this.direction < MazeConstant.DIRECTION_OF_NORTH) {
            this.direction = MazeConstant.DIRECTION_OF_WEST;
        }
    }

    void turnBack() {
        // 2回右回りしたことにする
        turnRight();
        turnRight();
    }
}
