package maze.map;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

import maze.utils.*;

public class MapLoader {

    MapLoader() {
        //
    }

    FloorMap load(String filePath, int floorNo, int xSize, int ySize) {
        final FloorMap result = new FloorMap(floorNo, xSize, ySize);

        try {
            final File csv = new File(filePath); // CSVデータファイル
            final BufferedReader br = new BufferedReader(new FileReader(csv));

            final MapCell[][] floorCells = new MapCell[xSize][ySize];

            try {

                String line = "";
                int dataCount = 0;

                while ((line = br.readLine()) != null) {
                    dataCount++;

                    // 1行目は読み飛ばす
                    if (dataCount == 1) {
                        continue;
                    }

                    // 1行をデータの要素に分割
                    StringTokenizer st = new StringTokenizer(line, ",");

                    final ArrayList<String> cellInfo = new ArrayList<String>();
                    while (st.hasMoreTokens()) {
                        cellInfo.add(st.nextToken());
                    }

                    // 配列にセット
                    final int x = convertToAttribute(cellInfo,
                            MazeConstant.MAP_CSV_INDEX_X);
                    final int y = convertToAttribute(cellInfo,
                            MazeConstant.MAP_CSV_INDEX_Y);
                    floorCells[x][y] = createMapCell(cellInfo);
                }

                // マップ情報をセット
                result.setFloorCells(floorCells);

                System.out.println("dataCount = " + dataCount);
            } finally {
                br.close();
            }

        } catch (FileNotFoundException e) {
            // Fileオブジェクト生成時の例外捕捉
            e.printStackTrace();
        } catch (IOException e) {
            // BufferedReaderオブジェクトのクローズ時の例外捕捉
            e.printStackTrace();
        }

        return result;
    }

    private MapCell createMapCell(ArrayList<String> cellInfo) {
        // 各セル単位の情報を取得
        final int attributeOfNorth = convertToAttribute(cellInfo,
                MazeConstant.MAP_CSV_INDEX_NORTH);
        final int attributeOfEast = convertToAttribute(cellInfo,
                MazeConstant.MAP_CSV_INDEX_EAST);
        final int attributeOfSouth = convertToAttribute(cellInfo,
                MazeConstant.MAP_CSV_INDEX_SOUTH);
        final int attributeOfWest = convertToAttribute(cellInfo,
                MazeConstant.MAP_CSV_INDEX_WEST);

        return new MapCell(attributeOfNorth, attributeOfEast,
                attributeOfSouth, attributeOfWest);
    }

    private int convertToAttribute(ArrayList<String> value, int index) {
        return Integer.valueOf(value.get(index)).intValue();
    }
}
