import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

//1
        Scanner scaner = new Scanner(System.in);
        System.out.println("введите выражение");
        String s = scaner.nextLine();
//        String[] rimNun = {"I", "V", "X", "C"};
//        String s = "5-10";
//        String s = "I+II";
        String[] arr = s.split("");
        String[] oper = {"+", "-", "*", "/"};
        String operat = "";
        char hh = 3;
        char g = (oper[1]).charAt(0);
        int razd = 0, iskl = 0, a = 0, b = 0;
        boolean flag = false;

        //*************ПРОВЕРКА НА ОПЕРАТОР**********************


        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i <= 3; i++) {
                hh = s.charAt(j); //возвр букву по индексу
                g = (oper[i]).charAt(0);
                if (hh == g) {
                    razd = j;
                    iskl += 1;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (i == razd) continue;
            try {
                Integer.valueOf(arr[i]);
            } catch (NumberFormatException e) {
                flag = true;
            }
        }
        if (flag) {
            outRim(arr, razd);
        }
        if (flag == false) {
            KalkRimOutRim(arr, razd);
        }
    }

    //***********************Работа с арабскими числами***************************
    private static void KalkRimOutRim(String[] arr, int razd) throws IOException {
//            //***************************************
//        System.out.println(s.charAt(0));
        int a = 0, b = 0, sum = 0;
        String aa = "", bb = "";
        String operat = arr[razd];
        for (int ss = 0; ss < arr.length; ss++) {
            if (ss < razd) aa += arr[ss];
            else if (ss == razd) continue;
            else bb += arr[ss];
        }
        b = Integer.parseInt(bb);
        a = Integer.parseInt(aa);

        sum = MathInOut(a, b, operat);
        System.out.println(sum);
    }

    ///*******************   МАТЕМАТИКА   ********************************
    private static int MathInOut(int a, int b, String operat) throws IOException {
        int out = 0;


        if ((a > 10) || (b > 10)) {
            throw new IOException("заданием ввод ограничен  числом 10");
        }
        if (b == 0) {
            throw new IOException("НА НОЛЬ НЕЛЬЗЯ ДЕЛИТЬ");
        }
        switch (operat) {
            case "+":
                out = a + b;
                break;
            case "-":
                out = a - b;
                break;
            case "*":
                out = a * b;
                break;
            case "/":
                out = a / b;
                break;
        }
        return out;
    }

    //********************вывод римских цифр и их перевод///////////////////////////////////////
    private static void outRim(String arr[], int razd) throws IOException {//вывод римских цифр и их перевод

        int a = 0, b = 0, sum = 0;
        String aa = "", bb = "";
        String operat = arr[razd];
        for (int ss = 0; ss < arr.length; ss++) {
            if (ss < razd) aa += arr[ss];
            else if (ss == razd) continue;
            else bb += arr[ss];
        }
        String[] rimNun = {"I", "V", "X"};
        String[] oper = {"+", "-", "*", "/"};
        String num = "";


        rimNun = new String[]{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        for (int i = 0; i < rimNun.length; i++) {
            if (aa.equals(rimNun[i])) {
                a = i + 1;
                break;
            }
        }
        for (int i = 0; i < rimNun.length; i++) {
            if (bb.equals(rimNun[i])) {
                b = i + 1;
                break;
            }
        }

        if ((aa == "") || (bb == "")) {
            throw new IOException("нет числа для операции");
        }
        if ((a == 0) || (b == 0)) {
            throw new IOException("одно либо оба числа не удовлетворяют тех заданию");
        }
        sum = MathInOut(a, b, operat);
        if ((sum < 0)) {
            throw new IOException("вывод результата не возможен, поскольку не существует отрицательных римских чисел");
        }
        if ((sum == 0)) {
            throw new IOException("вывод результата не возможен, поскольку не существует нуля в римских числах");

        }
        System.out.println(outRimNum(sum));
    }

    private static String outRimNum(int x) {

        String S1[] = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String S10[] = {"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC", "C"};
        //                1   2      3     4      5    6     7       8     9     10
        int y1 = 0, y10 = 10;
        String f = "", a = "", b = "";
        y10 = x % 10;
        y1 = x / 10;
        if (x < 10) f = S1[y10 - 1];
        if (x == 10 || x == 100) f = S10[y1 - 1];
        if (x > 10 && x < 100) {
            if (y10 == 0) f = S10[y1 - 1];
            else {
                f = S10[y1 - 1].concat(S1[y10 - 1]);
            }
        }
        return f;
    }

}



