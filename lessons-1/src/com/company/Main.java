package com.company;

public class Main {

    public static void main(String[] args) {
        int a = 10;
        if (a % 2 == 1) {
            System.out.println("kratno 2");
        } else {
            System.out.println();
        }
    }


    /**
     * 1
     */

    static void task2() {
        byte b = 127;
        short st = 12419;
        char ch = 'A';
        int integer = 24;
        long lg = 124124L;
        float fl = 12.345949f;
        double dl = 4323.45345;
        boolean bool = true;
    }

    /**
     * 2
     */

    static double calc(double a, double b, double c, double d) {
        return a * (b + (c / d));
    }

    /**
     * 3
     */

    static boolean range(int one, int two) {
        int sum = one + two;
        return sum > 9 && sum < 21;
    }

    /**
     * 4
     */

    static void printPositiveOrNegative(int num) {
        String word = "Положительное";
        if (num < 0) word = "Отрицательное";

        System.out.println(word);
    }

    /**
     * 5
     */

    static boolean isNegative(int num) {
        return num < 0;
    }

    /**
     * 6
     */

    static void sayHello(String name) {
        System.out.printf("Привет, %s!\n", name);
    }

    /**
     * 7
     */

    static void printYear(int year) {
        if (isLeapYear(year)) {
            System.out.println("Високосный");
        } else {
            System.out.println("Не високосный");
        }
    }

    /**
     * 8
     */

    private static boolean isLeapYear(int year) {
        if (((year % 4) == 0) && !((year % 100) == 0)) {
            return true;
        } else if ((year % 400) == 0) {
            return true;
        }
        return false;
    }
}