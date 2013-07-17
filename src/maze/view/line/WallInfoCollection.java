package maze.view.line;

import java.util.ArrayList;
import java.util.Iterator;

public class WallInfoCollection implements Iterable<WallInfo> {

    private final ArrayList<WallInfo> wallInfoList;

    public WallInfoCollection() {
        wallInfoList = new ArrayList<WallInfo>();
    }

    public void add(WallInfo wallInfo) {
        wallInfoList.add(wallInfo);
    }

    WallInfo get(int index) {
        return wallInfoList.get(index);
    }

    @Override
    public Iterator<WallInfo> iterator() {
        return wallInfoList.iterator();
    }
}
