package maze.map;

public class FloorMap {

    private MapCell[][] floorCells;

    private int xSize;
    private int ySize;

    private int floorNo;

    public FloorMap(int floorNo, int xSize, int ySize) {
        this.floorNo = floorNo;
        this.xSize = xSize;
        this.ySize = ySize;

        // this.floorCells = new BaseCell[getXSize()][getYSize()];
    }

    public int getFloorNo() {
        return this.floorNo;
    }

    public int getXSize() {
        return this.xSize;
    }

    public int getYSize() {
        return this.ySize;
    }

    void setFloorCells(MapCell[][] aFloorCells) {
        this.floorCells = aFloorCells;
    }

    public MapCell getCell(int aLocatuonX, int aLocationY) {
        return this.floorCells[aLocatuonX][aLocationY];
    }
}
