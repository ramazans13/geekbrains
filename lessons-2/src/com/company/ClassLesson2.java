package com.company;

public class ClassLesson2 {

    public static void main(String[] args) {

        //1. Задать целочисленный массив, состоящий из элементов 0 и 1.
        // Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
        System.out.println("\r\n1 - задание");
        int[] arr1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = arr1[i] == 1 ? 0 : 1;
            System.out.print(arr1[i] + " ");
        }

        //2. Задать пустой целочисленный массив размером 8.
        // С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
        System.out.println("\r\n2 - задание");
        int[] arr2 = new int[8];
        for (int i = 1, j = 0; i < arr2.length; i++) arr2[i] = j += 3;
        for (int x : arr2) System.out.print(x + " ");

        //3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом,
        // и числа меньшие 6 умножить на 2;
        System.out.println("\r\n3 - задание");
        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr3.length; i++) {
            if (arr3[i] < 6) arr3[i] *= 2;
            System.out.print(arr3[i] + " ");
        }

        //4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
        // и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
        System.out.println("\r\n4 - задание");
        int[][] arr4 = new int[7][7];
        for (int i = 0; i < arr4.length; i++) {
            for (int j = 0, j2 = arr4[i].length; j < arr4[i].length; j++, j2--) {
                if (i == j || i == (j2 - 1)) arr4[i][j] = 1;
                System.out.print(arr4[i][j] + " ");
            }
            System.out.print("\r\n");
        }

        //5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
        System.out.println("\r\n5 - задание");
        int[] arr5 = {10, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int min = arr5[0], max = arr5[0], indMax = 0, indMin = 0;
        for (int i = 0; i < arr5.length; i++) {
            if (arr5[i] > max) {
                max = arr5[i];
                indMax = i;
            }
            if (arr5[i] < min) {
                min = arr5[i];
                indMin = i;
            }
        }
        System.out.println("Максимальный элемент находится в массиве под индексом " + indMax + " со значением  = " + max);
        System.out.println("Минимальный элемент находится в массиве под индексом " + indMin + " со значением  = " + min);


        //Следующие задания сделаем с помощью методов, а вызов методов будет делать здесь

        int[] arr6 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        System.out.println("\r\n6 - задание, результат = " + checkBalance(arr6));

        System.out.println("\r\n7 - задание +3 сдвига");
        shiftOfNumbers(arr6, 3);

        System.out.println("\r\n7 - задание -3 сдвига");
        shiftOfNumbers(arr6, -3);

        System.out.println("\r\nДополнительное домашнее задание");
        fillSnake(4, 4);
    }

    //6. ** Написать метод, в который передается не пустой одномерный целочисленный массив,
    // метод должен вернуть true если в массиве есть место, в котором сумма левой и правой части массива равны.
    // Примеры: checkBalance([1, 1, 1, || 2, 1]) → true, checkBalance ([2, 1, 1, 2, 1]) → false, checkBalance ([10, || 10]) → true,
    // граница показана символами ||, эти символы в массив не входят.
    private static boolean checkBalance(int[] arrParam) {
        int lSum, rSum;

        for (int i = 0; i < arrParam.length + 1; i++) {
            lSum = 0;
            rSum = 0;

            for (int j = 0; j < i; j++) {
                lSum += arrParam[j];
            }

            for (int j = i; j < arrParam.length; j++) {
                rSum += arrParam[j];
            }

            if (lSum == rSum) return true;
        }
        return false;
    }


    //7. **** Написать метод, которому на вход подается одномерный массив и число n
    // (может быть положительным, или отрицательным),
    // при этом метод должен сместить все элементымассива на n позиций.
    // Для усложнения задачи нельзя пользоваться вспомогательными массивами.
    private static void shiftOfNumbers(int[] arrParam, int n) {
        //посмотрим матрицу до сдвмга
        for (int i : arrParam) System.out.print(i + " ");
        System.out.println("\r\n");

        if (n > 0) {
            for (int x = 0; x < n; x++) {
                int buf = arrParam[arrParam.length - 1];
                if (arrParam.length - 1 >= 0) System.arraycopy(arrParam, 0, arrParam, 1, arrParam.length - 1);
                arrParam[0] = buf;
                //смотрим матрицу после каждого сдвига
                for (int i : arrParam) System.out.print(i + " ");
                System.out.println();
            }
        }
        if (n < 0) {
            for (int x = 0; x > n; x--) {
                int buf = arrParam[0];
                System.arraycopy(arrParam, 1, arrParam, 0, arrParam.length - 1);
                arrParam[arrParam.length - 1] = buf;
                //смотрим матрицу после каждого сдвига
                for (int i : arrParam) System.out.print(i + " ");
                System.out.print("\r\n");
            }
        }
    }


    // Дополнительное домашнее задание
    //1 Задать размерность матрицы от 5 до 7
    //2 Создать матрицу с указанной размерностью
    //3 Заполнить матрицу по спирали (числа увеличиваются на 1) (число начинается с 1)
    private static void fillSnake(int row, int col) {

        int[][] array = new int[col][row];
        int c = 0, d = 0, s = 1;

        while (s + 1 < col * row) {

            //Движемся вправо.
            while ((d + 1) < row && array[c][d + 1] == 0)
                array[c][d++] = s++;

            //Движемся вниз.
            while ((c + 1) < col && array[c + 1][d] == 0 )
                array[c++][d] = s++;

            //Движемся влево.
            while (d > 0 && array[c][d - 1] == 0)
                array[c][d--] = s++;

            //Движемся вверх.
            while (array[c - 1][d] == 0)
                array[c--][d] = s++;
        }

        //Заполним последнию ячейку
        for (int x = 0; x < col; x++) {
            for (int y = 0; y < row; y++) {
                if (array[x][y] == 0) array[x][y] = s;
            }
        }

        //Посмотрим что получилось у нас
        for (int x = 0; x < col; x++) {
            for (int y = 0; y < row; y++) {
                System.out.print(array[x][y] + "  ");
            }
            System.out.println();
        }
    }
}