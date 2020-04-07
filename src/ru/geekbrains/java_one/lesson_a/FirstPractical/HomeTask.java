package ru.geekbrains.java_one.lesson_a.FirstPractical;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Year;

public class HomeTask {
    public static int a = 10;
    public static int b = 12;
    public static int c = 6;
    public static int d = 4;
    public static int e = 10;
    public static int f = 18;
    public static int g = -121;
    public static int year = 1985;

    public static void main(String[] args) throws IOException {
        System.out.println(Calculation(a, b, c, d));
        System.out.println(Summary (e , f));
        CheckPositive(g);
        SayHello();
        LeapYear(year);

    }

    private static double Calculation(int a, int b, int c, int d) {
        return a * (b + (c / (double) d));
    }
    private static boolean Summary(int e, int f) {
        int sum = e + f;
        return sum <= 20 && sum >= 10;
    }

    private static void CheckPositive (int g){
        if (g >= 0)
            System.out.println("Число положительное");
        else
            System.out.println("Число отрицательное");
    }
    private static void SayHello() throws IOException {
        System.out.println("Введите имя:");
        BufferedReader reader = new BufferedReader( new InputStreamReader( System.in));
        String name = reader.readLine();
        System.out.println("Привет, " + name);
    }

    private static void LeapYear(int year){
        if ( !(year % 4 == 0) || ((year % 100 == 0) && !(year % 400 == 0)))
            System.out.println(year + " г. не високосный");
        else
            System.out.println(year + " г. високосный");
    }
}
