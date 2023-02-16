//Дана прямоугольная карта размера MxN (N, M меньше 20)
//        На карте стоит фигура в точке(Х, Y), которая может ходить на одну клеточку вправо или вниз за один ход
//        Посчитать количество маршрутов, которым фигура может попасть в нижнюю правую клетку
//        * * На карте могут быть стены
//        * ** M и N могут быть до 1000
//        Задачу разбить на методы

import java.util.HashMap;
import java.util.Map;

public class Homework3 {
    public static void main(String[] args) {
//        System.out.println(getFactorial(6));
        System.out.println(getRoutesCount(5, 5)); // 137846528820

    }

    public static long getFactorial(int num) {
        int result = 1;
        for (int i = 1; i <= num; i++) {
            result = result * i;
        }
        return result;
    }

    public static long getRoutesCount(int n, int m){
        long res = 0;
//        n -= 1;
//        m -= 1;
        System.out.println(n);
        System.out.println(m);
//
//        long factSum = getFactorial(n * m);
//        long factN = getFactorial(n);
//        long factM = getFactorial(m);
        System.out.println(getFactorial(n * m));
//        System.out.println(factN);
//        System.out.println(factM);
//        long factMult = factN * factM;
        long r = getFactorial(n) * getFactorial(m);
//        System.out.println(factMult);
//        res = factSum / factMult;
        res = getFactorial(n * m) / (getFactorial(n) * getFactorial(m));
        return res;

//        M -= 1
//        N -= 1
//        res = factorial(N+M)//(factorial(N)*factorial(M))
    }

    static Map<String, Integer> getInitCoordinates() {

        Map<String, Integer> initCoordinates = new HashMap<>();

//        initCoordinates.put("a", a);
//        initCoordinates.put("b", b);

        return initCoordinates;
    }
}

