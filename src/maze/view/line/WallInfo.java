package maze.view.line;

public class WallInfo {

    private final int distance;
    private final boolean existLeftWall;
    private final boolean existRightWall;
    private final boolean existFrontWall;

    public WallInfo(int location, boolean existLeftWall,
            boolean existRightWall, boolean existFrontWall) {
        this.distance = location;
        this.existLeftWall = existLeftWall;
        this.existRightWall = existRightWall;
        this.existFrontWall = existFrontWall;
    }

    /**
     * 現在位置から対象のセルまでの距離。<br>
     * 現在位置のセルなら0が返されます。
     * 
     * @return
     */
    int getDistance() {
        return distance;
    }

    boolean isExistLeftWall() {
        return existLeftWall;
    }

    boolean isExistRightWall() {
        return existRightWall;
    }

    boolean isExistFrontWall() {
        return existFrontWall;
    }
}
