package maze.map;

import maze.utils.*;

public class MapCell {

    private int[] attributeOfSide = new int[4];

    MapCell(int aAttributeOfNorthSide, int aAttributeOfEastSide,
            int aAttributeOfSouthSide, int aAttributeOfWestSide) {
        this.attributeOfSide[MazeConstant.DIRECTION_OF_NORTH] = aAttributeOfNorthSide;
        this.attributeOfSide[MazeConstant.DIRECTION_OF_EAST] = aAttributeOfEastSide;
        this.attributeOfSide[MazeConstant.DIRECTION_OF_SOUTH] = aAttributeOfSouthSide;
        this.attributeOfSide[MazeConstant.DIRECTION_OF_WEST] = aAttributeOfWestSide;
    }

    private int getAttributeOfSide(int direction) {
        return this.attributeOfSide[direction];
    }

    public boolean isExistWall(int direction) {
        return (getAttributeOfSide(direction) == MazeConstant.ATTRIBUTE_OF_WALL);
    }

    public boolean isExistDoor(int direction) {
        return (getAttributeOfSide(direction) == MazeConstant.ATTRIBUTE_OF_DOOR);
    }

    public boolean isExistLeftWall(int direction) {
        return (getAttributeOfSide(DirectionUtils.getLeftDirection(direction)) == MazeConstant.ATTRIBUTE_OF_WALL);
    }

    public boolean isExistRightWall(int direction) {
        return (getAttributeOfSide(DirectionUtils.getRightDirection(direction)) == MazeConstant.ATTRIBUTE_OF_WALL);
    }
}
