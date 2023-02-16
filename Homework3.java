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
//        System.out.println(getRoutesCount(getInitCoordinates(), 0, 2));

//        System.out.println(getRoutesCount(3, 3));
//        System.out.println(getRoutesCount(8, 8));
//        System.out.println(getRoutesCount(9, 8));


    }

    static Map<String, Integer> getInitCoordinates() {

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
            System.out.println("err 1");
            return 0;
        }

        Integer x = initCoordinates.get("x");
        Integer y = initCoordinates.get("y");

        System.out.println("============");
        System.out.println(x);
        System.out.println(y);
        System.out.println("============");




        if (x >= n || y >= m){
            System.out.println("err");
            return 0;
        }

        int[][] multi = prefillArr(n, m);

//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                System.out.println(multi[i][j]);
//            }
//        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                multi[i][j] = multi[i-1][j] + multi[i][j-1];
//                System.out.println(multi[i][j]);
//                System.out.println("+++++++++++++");
            }
        }
        System.out.println(multi[n - 1][m - 1]);

        return multi[n - 1][m - 1];
    }


    public static int[][] prefillArr(int n, int m){
        int[][] multi = new int[n][m];
        for (int i = 1; i < multi[0].length; i++) {
            multi[i][0] = 1;
        }
        for (int i = 1; i < multi[1].length; i++) {
            multi[0][i] = 1;
        }
        return multi;
    }
}

