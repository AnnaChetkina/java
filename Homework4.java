import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Homework4 {
    public static void main(String[] args) {
        wave(getInitMap());
    }

    public static int[][] getInitMap() {
        // -1 стена; -2 выход; 1 - исходная позиция
        int[][] initMap = {
                {0, 0,   0,   0,  0,  0,  0,  0, 0},
                {0, -1, -1,  -1,  0,  0,  0,  0, 0},
                {0,  0,  0,   0, -1,  0,  0,  0, 0},
                {0,  0,  0,  -1, -1, -1,  0,  0, 0},
                {0,  0,  1,  -1,  0,  0, -1,  0, 0},
                {0,  0,  0,  -1,  0,  0, -1,  0, 0},
                {0,  0,  0,  -1,  0,  0, -1, -1, 0},
                {0,  0,  0,   0,  0,  0,  0,  0, 0},
                {0,  0,  0,   0,  0,  0, -2,  0, 0},
        };

//        int[][] intMap = {
//                {4, 6, 10},
//                {40, 69, 0}
//        };
        // 4 6 10 40 69 0 / i - это колонки, j - стрки
//        System.out.println(intMap[1][1]);
        return initMap;
    }

    public static void PrintMap(int[][] map) {
        for (int i = 0; i < map[0].length; i++) {
            for (int j = 0; j < map[1].length; j++) {
                if (map[i][j] < 10 && map[i][j] > -1) {
                    System.out.printf("%d   ", map[i][j]);
                }
                else {
                    System.out.printf("%d  ", map[i][j]);
                }
            }
            System.out.println();
        }
    }


    public static void wave(int[][] arr) {
        System.out.println("изначальная карта");
        PrintMap(arr);
        // начальная позиция, x = row, y = col
        int initX = 4;
        int initY = 2;
        Queue<Integer> queue = new LinkedList<Integer>();
        int k = posToСoefficient(initX, initY);
        queue.add(k); // добавяем начальную точку в очередь

//        System.out.println(queue);
//        System.out.println(queue.size() - 1);

        int width = arr[0].length; // cols
        int height = arr[1].length; // rows

        while (!queue.isEmpty()){
            Map<String, Integer> coordinates = сoefficientToPos(queue.remove());
            Integer row = coordinates.get("row");
            Integer col = coordinates.get("col");
            System.out.println(row);
            System.out.println(col);
            System.out.println("***********");

            if (row > 0 && col > 0 && row < width && col < height){

                if (row > 0 && arr[row - 1][col] == 0) {
                    queue.add(posToСoefficient(row - 1, col));
                    arr[row - 1][col] = arr[row][col] + 1;
                    System.out.printf("1: row = %d, col = %d ;", row - 1, col);
                    System.out.println();
                }

                if (col < height - 1 && arr[row][col + 1] == 0) {
                    queue.add(posToСoefficient(row, col + 1));
                    arr[row][col + 1] = arr[row][col] + 1;
                    System.out.printf("2: row = %d, col = %d ;", row, col + 1);
                    System.out.println();
                }

                if (row < width - 1 && arr[row + 1][col] == 0) {
                    queue.add(posToСoefficient(row + 1, col));
                    arr[row + 1][col] = arr[row][col] + 1;
                    System.out.printf("3: row = %d, col = %d ;", row + 1, col);
                    System.out.println();
                }

                if (col > 0 && arr[row][col - 1] == 0) {
                    queue.add(posToСoefficient(row, col - 1));
                    arr[row][col - 1] = arr[row][col] + 1;
                    System.out.printf("4: row = %d, col = %d ;", row, col - 1);
                    System.out.println();
                }
            }

            PrintMap(arr);
            System.out.println("++++++++++");
        }
//        return arr;
    }

    // преобпазователь координат для записи в очередь
    public static int posToСoefficient(int row, int col) {
        // k = row * 10 + col;
        // row = k / 10
        // col = k % 10
        return row * 10 + col;
    }

    // преобпазователь координат для извлечения из очередь
    public static Map<String, Integer> сoefficientToPos(int k) {
        Map<String, Integer> coordinates = new HashMap<>();
        int row = k / 10;
        int col = k % 10;
        coordinates.put("row", row);
        coordinates.put("col", col);
        return coordinates;
    }
}
