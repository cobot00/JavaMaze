package maze.view.line;

import maze.map.*;
import maze.utils.*;

public class WallInfoCollectionFactory {

    private WallInfoCollectionFactory() {
        // コンストラクタの隠蔽
    }

    public static WallInfoCollection createWallInfoCollection(
            LocationController locationController, FloorMap floorMap) {
        final WallInfoCollection result = new WallInfoCollection();

        // 初期値として現在座標をセットする
        LocationPoint locationPoint = new LocationPoint(
                locationController.getLocationX(),
                locationController.getLocationY());

        for (int i = 0; i < getVisibilityRange(); i++) {
            // 対象座標のセル情報を取得する
            final MapCell mapCell = floorMap.getCell(
                    locationPoint.getLocationX(), locationPoint.getLocationY());

            // 対象セルの壁情報を生成する
            final WallInfo wallInfo = new WallInfo(
                    i,
                    mapCell.isExistLeftWall(locationController.getDirection()),
                    mapCell.isExistRightWall(locationController.getDirection()),
                    mapCell.isExistWall(locationController.getDirection()));
            result.add(wallInfo);

            // 正面が壁ならそこで終了
            if (mapCell.isExistWall(locationController.getDirection())) {
                break;
            }

            // 次のセル座標を取得する
            locationPoint = getNextLocationPoint(locationPoint,
                    locationController.getDirection());
        }
        return result;
    }

    private static int getVisibilityRange() {
        return MazeConstant.VISIBILITY_RANGE_NORMAL;
    }

    private static LocationPoint getNextLocationPoint(
            LocationPoint locationPoint, int direction) {
        int x = locationPoint.getLocationX();
        int y = locationPoint.getLocationY();

        // 方角毎に次の座標は異なる
        switch (direction) {
        case MazeConstant.DIRECTION_OF_NORTH:
            y++;
            break;
        case MazeConstant.DIRECTION_OF_EAST:
            x++;
            break;
        case MazeConstant.DIRECTION_OF_SOUTH:
            y--;
            break;
        case MazeConstant.DIRECTION_OF_WEST:
            x--;
            break;
        }
        return new LocationPoint(x, y);
    }
}
