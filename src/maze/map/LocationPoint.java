package maze.map;

public class LocationPoint {

    private final int locationX;
    private final int locationY;

    public LocationPoint(int locationX, int locationY) {
        this.locationX = locationX;
        this.locationY = locationY;
    }

    public int getLocationX() {
        return locationX;
    }

    public int getLocationY() {
        return locationY;
    }
}
