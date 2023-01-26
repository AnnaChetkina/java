import java.util.List;

// Написать программу вычисления n-ого треугольного числа
public class homework1 {
    public static void main(String[] args) {
        getTriangularNumber(5); // 15
        getTriangularNumber(7); // 28
        getTriangularNumber(10); // 55
    }

    static void getTriangularNumber(int num) {
        int res = (num * (num + 1)) / 2;
        System.out.println(res);
    }
}
