package maze.view.line;

public class LinePoint {

    private final DrawPoint fromPoint;
    private final DrawPoint toPoint;

    LinePoint(DrawPoint fromPoint, DrawPoint toPoint) {
        this.fromPoint = fromPoint;
        this.toPoint = toPoint;
    }

    DrawPoint getFromPoint() {
        return fromPoint;
    }

    DrawPoint getToPoint() {
        return toPoint;
    }
}
