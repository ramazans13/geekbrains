package com.company;

import java.util.Random;
import java.util.Scanner;

public class ClassLesson3 {

    private static Random random = new Random();

    public static void main(String[] args) {
        //1 задание основного домешнего задания
        //  guessNumber();
        //2 задание основого домашнего задания
        //  guessFruit();
        //дополнительное домашнее задание
        //   calculator();
        advancedCalculator();
    }


    //1. Написать программу, которая загадывает случайное число от 0 до 9, и пользователю дается 3 попытки угадать это число.
    // При каждой попытке компьютер должен сообщить больше ли указанное пользователем число чем загаданное, или меньше.
    // После победы или проигрыша выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).
    private static void guessNumber() {
        //инициализируем сканер
        Scanner scanner = new Scanner(System.in);
        do {
            int numComp = random.nextInt(10);
            System.out.println("Угдай число с 3 попыток от 0 до 9");
            for (int i = 3; i > 0; i--) {
                System.out.println("Введи свой ответ: (для выхода из игры, просто нажмите Enter)");
                int questionNum = scanner.nextInt(); //try не будем ставить, так как еще не узучали :)
                if (questionNum == numComp) {
                    System.out.println("Вы угадали число, молодец!");
                    break;
                }
                System.out.println(questionNum > numComp ? "Введенное чилсо больше " : "Введенное число меньше ");
                System.out.println((i-1) > 0 ? " у вас осталось " + (i-1) + " попыток." : "Попытки закончились, вы проиграли.");
            }
            System.out.println("Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет)");
        }
        while (scanner.nextInt() == 1);//try не будем ставить, так как еще не узучали :)
    }

    //2 * Создать массив из слов String[]
    // words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli",
    // "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
    // "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
    //При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
    //сравнивает его с загаданным словом и сообщает правильно ли ответил пользователь. Если слово не угадано, компьютер показывает буквы которые стоят на своих местах.
    //apple – загаданное
    //apricot - ответ игрока
    //ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
    //Для сравнения двух слов посимвольно, можно пользоваться:
    //String str = "apple";
    //str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
    //Играем до тех пор, пока игрок не отгадает слово
    //Используем только маленькие буквы
    private static void guessFruit() {

        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut",
                "pear", "pepper", "pineapple", "pumpkin", "potato"};
        //загадаем слово из массива
        int indWord = random.nextInt(words.length - 1);
        String word = words[indWord];
        int lenWord = word.length();
        System.out.println("Я загадал слово, попробуй отгадать его");
        System.out.println(word);
        //инициализируем сканер
        Scanner scanner = new Scanner(System.in);
        do {
            //спрашиваем ответ
            System.out.println("Введи свой ответ: (для выхода из игры, просто нажмите Enter)");
            String answer = scanner.nextLine();
            //если нам надоес играть то мы выйдем
            if (answer.equals("")) break;
            else if (word.equals(answer)) {
                System.out.println("Вы угадали слово, игра закончена!!!");
                break;
            }
            //так как наш игрок не угадал то будем готовить для него подсказку
            char[] charsAnswer = answer.toCharArray();
            for (int i = 0; i < lenWord; i++) {
                if (i >= charsAnswer.length) break;
                if (word.charAt(i) != charsAnswer[i]) charsAnswer[i] = '#';
            }
            StringBuilder comment = new StringBuilder(String.valueOf(charsAnswer));
            for (int i = comment.length(); i < 15; i++) comment.append("#");
            System.out.println(comment);
        }
        while (true);
    }

    //Создать консольный калькулятор
    //
    //1 Базовый калькулятор
    //Введите два числа через пробел, пример
    //1 + 2
    //или
    //2 * 2
    //
    //(должно быть доступно 4 операции + - / *)
    //
    //при этом если пользователь выбирает какое-либо другое дествие нужно об этом сказать
    private static void calculator() {

        System.out.println("Введите два номера и операцию с пробелами между ними");

        Scanner scanner = new Scanner(System.in);
        String calculation = scanner.nextLine();

        String [] arr = calculation.split(" ");

        int answer;
        int part1 = Integer.parseInt(arr[0]);
        int part2 = Integer.parseInt(arr[2]);

        String operation = arr[1];

        switch (operation) {
            case "+":
                answer = part1 + part2;
                break;
            case "-":
                answer = part1 - part2;
                break;
            case "*":
                answer = part1 * part2;
                break;
            case "/":
                answer = part1 / part2;
                break;
            default:
                System.out.println("Неверный оператор: " + operation);
                return;
        }
        System.out.println("Ответ: " + answer);
    }

    //2 Продвинутый калькулятор
    //
    //Количество элементов не ограничено
    private static void advancedCalculator() {
        System.out.println("Введите два номера и операцию с пробелами между ними");

        Scanner scanner = new Scanner(System.in);
        String calculation = "+ " + scanner.nextLine();
        double answer = 0, num;

        String [] arr = calculation.split(" ");
        String operation = "+";
        for(int i = 0; i < arr.length; i++ ) {

            if(i % 2 == 0) {
                operation = arr[i];
                continue;
            }

            num = Double.parseDouble(arr[i]);

            switch (operation) {
                case "+":
                    answer += num;
                    break;
                case "-":
                    answer -= num;
                    break;
                case "*":
                    answer *= num;
                    break;
                case "/":
                    answer /= num;
                    break;
                default:
                    System.out.println("Неверный оператор: " + operation);
                    return;
            }

        }
        System.out.println("Ответ: " + answer);
    }
}