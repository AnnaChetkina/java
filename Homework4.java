import java.util.*;

public class Homework4 {
    public static void main(String[] args) {
        int[][] wave = wavePropogation(getInitMap());
        Queue<Integer> route = restoringPath(wave, 4, 2);
        printPath(wave, route);
    }

    public static int[][] getInitMap() {
        // -1 стена;
        // -2 выход - устанавливает метод setExit
        // 1 - исходная позиция
        int[][] initMap = {
                {0,  0,  0,   0,  0,  0,  0,  0, 0},
                {0, -1, -1,  -1,  0,  0,  0,  0, 0},
                {0,  0,  0,   0, -1,  0,  0,  0, 0},
                {0,  0, -1,  -1, -1, -1,  0,  0, 0},
                {0,  0,  1,  -1,  0,  0, -1,  0, 0},
                {0,  0,  0,  -1,  0,  0, -1,  0, 0},
                {0,  0,  0,  -1,  0,  0, -1, -1, 0},
                {0,  0,  0,   0,  0,  0,  0,  0, 0},
                {0,  0,  0,   0,  0,  0,  0,  0, 0},
        };

//        int[][] initMap = {
//                {0,  0,  0,   0,  0},
//                {0,  -1,  -1,   0,  0},
//                {0,  0,  -1,   -1,  0},
//                {0,  1,  0,   0,  0},
//                {0,  0,  0,   -2,  0},
//        };
        return initMap;
    }

    public static int[] setExit(int[][] map) {
        int exitX = 0;
        int exitY = 6;
        int [] exitCoordinates = {exitX, exitY};
        return exitCoordinates;
    }

    public static void printMap(int[][] map) {
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

    public static void printPath(int[][] map, Queue<Integer> route) {
        System.out.printf("длина пути = %d;", route.size());
        System.out.println();
        while (!route.isEmpty()) {
            Map<String, Integer> coordinates = сoefficientToPos(route.remove());
            Integer row = coordinates.get("row");
            Integer col = coordinates.get("col");
            if (route.size() != 0) map[row][col] = -9;
        }
        printMap(map);
    }

        public static int[][] wavePropogation(int[][] arr) {
        System.out.println("изначальная карта");
        printMap(arr);
        // начальная позиция, x = row, y = col
        int initX = 4;
        int initY = 2;

        Queue<Integer> queue = new LinkedList<Integer>();
        int k = posToСoefficient(initX, initY);
        queue.add(k); // добавяем начальную точку в очередь

        int width = arr[0].length; // cols
        int height = arr[1].length; // rows

        while (!queue.isEmpty()){
            Map<String, Integer> coordinates = сoefficientToPos(queue.remove());
            Integer row = coordinates.get("row");
            Integer col = coordinates.get("col");
            System.out.printf("позиция: row = %d, col = %d;", row, col);
            System.out.println();
            System.out.print("очередь после извлечения элемента ");
            System.out.println(queue);
            int step = arr[row][col] + 1;

            if (row > 0 && arr[row - 1][col] == 0) {
                queue.add(posToСoefficient(row - 1, col));
                arr[row - 1][col] = step;
                System.out.printf("1. шаг вверх: row = %d, col = %d;", row - 1, col);
                System.out.println();
            }

            if (col < height - 1 && arr[row][col + 1] == 0) {
                queue.add(posToСoefficient(row, col + 1));
                arr[row][col + 1] = step;
                System.out.printf("2. шаг вправо: row = %d, col = %d ;", row, col + 1);
                System.out.println();
            }

            if (row < width - 1 && arr[row + 1][col] == 0) {
                queue.add(posToСoefficient(row + 1, col));
                arr[row + 1][col] = step;
                System.out.printf("3. шаг вниз: row = %d, col = %d;", row + 1, col);
                System.out.println();
            }

            if (col > 0 && arr[row][col - 1] == 0) {
                queue.add(posToСoefficient(row, col - 1));
                arr[row][col - 1] = step;
                System.out.printf("4. шаг влево: row = %d, col = %d;", row, col - 1);
                System.out.println();
            }

            System.out.print("очередь после возможного добавления элементов ");
            System.out.println(queue);

            System.out.println("результат распространения волны на данном шаге");
            System.out.println("************");
            printMap(arr);
            System.out.println("************");
        }
        return arr;
    }

    public static Queue<Integer> restoringPath(int[][] arr, int iniX, int initY) {

        Queue<Integer> route = new LinkedList<Integer>();

        int width = arr[0].length; // cols
        int height = arr[1].length; // rows

        // пока рассматривается ситуация, что путь выход 1
//
        int [] exitCoordinates = setExit(arr);
        int currentRow = exitCoordinates[0];
        int currentCol = exitCoordinates[1];

        while (currentRow != iniX || currentCol != initY) {
            if (currentRow > 0 && arr[currentRow - 1][currentCol] == arr[currentRow][currentCol] - 1) {
                currentRow = currentRow - 1;
                route.add(posToСoefficient(currentRow, currentCol));
            }
            if (currentCol < height - 1 && arr[currentRow][currentCol + 1] == arr[currentRow][currentCol] - 1) {
                currentCol = currentCol + 1;
                route.add(posToСoefficient(currentRow, currentCol));
            }
            if (currentRow < width - 1 && arr[currentRow + 1][currentCol] == arr[currentRow][currentCol] - 1) {
                currentRow = currentRow + 1;
                route.add(posToСoefficient(currentRow, currentCol));
            }
            if (currentCol > 0 && arr[currentRow][currentCol - 1] == arr[currentRow][currentCol] - 1) {
                currentCol = currentCol - 1;
                route.add(posToСoefficient(currentRow, currentCol));
            }
        }

        System.out.println("путь = ");
        System.out.println(route);

        return route;
    }

    // преобразователь координат для записи в очередь
    public static int posToСoefficient(int row, int col) {
        // k = row * 10 + col;
        // row = k / 10
        // col = k % 10
        return row * 10 + col;
    }

    // преобразователь координат для извлечения из очередь
    public static Map<String, Integer> сoefficientToPos(int k) {
        Map<String, Integer> coordinates = new HashMap<>();
        int row = k / 10;
        int col = k % 10;
        coordinates.put("row", row);
        coordinates.put("col", col);
        return coordinates;
    }
}


