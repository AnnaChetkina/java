package homework2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

// +Реализовать функцию возведения числа а в степень b. a, b ∈ Z. Сводя количество выполняемых действий к минимуму.
// Пример 1: а = 3, b = 2, ответ: 9
// Пример 2: а = 2, b = -2, ответ: 0.25
// Пример 3: а = 3, b = 0, ответ: 1
// Пример 4: а = 0, b = 0, ответ: не определено
// Пример 5
// входные данные находятся в файле input.txt в виде
// b 3
// a 10
// Результат нужно сохранить в файле output.txt
// 1000
public class Homework2 {
    public static void main(String[] args) throws Exception {

        String sPath = "C:/GeekBrains 22/intro_to_java/seminars/out/production/seminars/homework2/input.txt";
        String sRes = readFile(sPath);
        Map<String, Integer> initNumbers = getNumbersInit(sRes);
        Integer a = initNumbers.get("a");
        Integer b = initNumbers.get("b");
//        System.out.println(a);
//        System.out.println(b);


    }

    static String readFile(String path) throws Exception {
        String sRes;
        BufferedReader br = new BufferedReader(new FileReader(path));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            sRes = sb.toString();
        } finally {
            br.close();
        }
        return sRes;
    }

    static Map<String, Integer> getNumbersInit(String sRes) {

        Map<String, Integer> initNumbers = new HashMap<>();

        Integer a = 0;
        Integer b = 0;

        String[] aStr = sRes.split("\n");

        for (int i = 0; i < aStr.length; i++) {
//            System.out.println(s[i]);
            if (aStr[i].indexOf('a') > -1){
                a = getNum(aStr[i]);
            }

            if (aStr[i].indexOf('b') > -1){
                b = getNum(aStr[i]);
            }
        }

//        System.out.println(a);
//        System.out.println(a instanceof Integer);
//        System.out.println(b);
//        System.out.println(b instanceof Integer);

        initNumbers.put("a", a);
        initNumbers.put("b", b);

        return initNumbers;
    }

    static Integer getNum(String sNum) {
        String sA = sNum.split("=")[1];
        return Integer.parseInt(sA.trim());
    }

}
