//Дана прямоугольная карта размера MxN (N, M меньше 20)
//        На карте стоит фигура в точке(Х, Y), которая может ходить на одну клеточку вправо или вниз за один ход
//        Посчитать количество маршрутов, которым фигура может попасть в нижнюю правую клетку
//        * * На карте могут быть стены
//        * ** M и N могут быть до 1000
//        Задачу разбить на методы

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Homework3 {
    public static void main(String[] args) {
//        System.out.println(getRoutesCount(getInitCoordinates(), 10, 8));
        System.out.println(getRoutesCount(getInitCoordinates(),8, 8));
//        System.out.println(getRoutesCount(getInitCoordinates(), 0, 2)); // проверка некорректного ввода

    }

    static Map<String,   Integer> getInitCoordinates() {

        Map<String, Integer> initCoordinates = new HashMap<>();
        int x = 0;
        int y = 0;

        Scanner in = new Scanner(System.in);
        System.out.print("Input initial coordinate x: ");
        x = in.nextInt();
        System.out.print("Input initial coordinate y: ");
        y = in.nextInt();
        in.close();

        initCoordinates.put("x", x);
        initCoordinates.put("y", y);

        return initCoordinates;
    }

    public static int getRoutesCount(Map<String, Integer> initCoordinates, int n, int m){
        if ((n < 1 || m < 1) || (n == 1 && m == 1)){
            System.out.println("Введено некорректное значение n или m");
            return 0;
        }

        Integer x = initCoordinates.get("x");
        Integer y = initCoordinates.get("y");

        if ((x >= n || y >= m) || (x <= 0 || y <= 0)){
            System.out.println("Введено некорректное значение точки(Х, Y)");
            return 0;
        }

        int[][] multi = prefillArr(n, m);

        x -= 1;
        y -= 1;

        for (int i = 1; i < n - x; i++) {
            for (int j = 1; j < m - y; j++) {
                multi[i][j] = multi[i-1][j] + multi[i][j-1];
            }
        }
        return multi[n - x - 1][m - y - 1];
    }

    public static int[][] prefillArr(int n, int m){
        int[][] multi = new int[n][m];
        for (int i = 0; i < multi[0].length; i++) {
            for (int j = 0; j < multi[1].length; j++) {
                multi[i][j] = 1;
            }
        }
        return multi;
    }
}

