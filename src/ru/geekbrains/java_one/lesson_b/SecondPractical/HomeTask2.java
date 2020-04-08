package ru.geekbrains.java_one.lesson_b.SecondPractical;


import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.stream.IntStream;

public class HomeTask2 {
    public static int[] arr1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
    public static int[] arr2;
    public static int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
    public static int lengthArray = 8;
    public static int[] check = {2, 2, 2, 1, 2, 2, 10, 1};
    public static int[] check1 = {2, 2, 2, 1, 2, 2, 10, 4};
    public static int k = 4;

    /*
    1. Задать целочисленный массив, состоящий из элементов 0 и 1.
    Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
    С помощью цикла и условия заменить 0 на 1, 1 на 0;
     */
    public static int[] ChangeArray(int[] name){
        for (int i = 0; i < name.length; i++){
            if (name[i] == 1)
                name[i] = 0;
            else name[i] = 1;}
        return name;
    }

    /*
    2. Задать пустой целочисленный массив размером 8.
    С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
     */
    public static int[] FillArray(int[] array){
        array = new int[8];
        for (int i = 0; i < array.length; i++ ) {
            array[i] = i * 3;
        }

        return array;
    }

    /*
    Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ]
     пройти по нему циклом, и числа меньшие 6 умножить на 2;
     */
    public static int[] MultipleArray(int[] array){
        for (int i = 0;i < array.length; i++ ){
            if (array[i] < 6) array[i] *= 2;
        }
        return array;
    }

    /*
    4. Создать квадратный двумерный целочисленный массив
    (количество строк и столбцов одинаковое),
    и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
     */
    public static int[][] QuadArray(int length){
        int[][] array = new int[length][length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length;j++) {
                if (i == j) array[i][j] = 1;
            }
        }
        return array;
    }

    /*
    5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
     */
    public static void MinMaxNumber(int[] name){
        int max = name[0], min = name[0];
        for (int i = 0; i < name.length; i++){
            if (name[i] > max)
                max = name[i] ;
            if (name[i] < min)
                min = name[i];
        }
        System.out.println("Минимимальное значение массива: " + min + ". Максимальное значение массива: " + max);
    }

    /*
    6. ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true,
     если в массиве есть место, в котором сумма левой и правой части массива равны.
     Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true,
     граница показана символами ||, эти символы в массив не входят.
     */
    public static boolean CheckBalance(int[] name){
        //double total = IntStream.of(name).sum();
        double halfSum = (IntStream.of(name).sum())/2;
       int rightSum = 0, leftSum = 0;
       while (rightSum == leftSum)
        for (int i = 0; i < name.length; i++){ // читаем строку сначала
            for (int j = 0; j <= i; j++) {
                leftSum += name[j];
            }
            for (int k = name.length; k >= 0; k--){ //читаем строку с конца
                rightSum -= name[k];
            }
        }
            if (leftSum == rightSum){
                return true;
            }
        return false;
    }

    /*
    7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным),
    при этом метод должен сместить все элементы массива на n позиций. Для усложнения задачи нельзя пользоваться вспомогательными массивами.
     */
    public static int[] RotateArray(int[] array, int n){

        if (n > 0){
            for (int i = 0; i < n; i++){
                int buffer = array[array.length - 1];
                System.arraycopy(array, 0, array, 1, array.length-1);
                array[0] = buffer;
            }
        }
        if (n < 0){
            for (int i = 0; i > n; i--){
                int buffer = array[0];
                System.arraycopy(array, 1, array, 0, array.length-1);
                array[array.length - 1] = buffer;
            }
        }
        return array;
    }

    public static void main(String[] args) {

        System.out.println("Исходный массив  : " + Arrays.toString(arr1));
        System.out.println("Измененный массив: " + Arrays.toString(ChangeArray(arr1)));
        System.out.println("Заполненный массив: " + Arrays.toString(FillArray(arr2)));
        System.out.println("Умножение элементов массива: " + Arrays.toString(arr3) + " \n меньше 6 на 2: " + Arrays.toString(MultipleArray(arr3)));
        System.out.println("Вывод массива с 1 по диагонали: ");
        Arrays.stream(QuadArray(lengthArray)).map(Arrays::toString).forEach(System.out::println);
        MinMaxNumber(arr3);
        //System.out.println("If array has balance point? " + CheckBalance(check));
        //System.out.println("If array has balance point? " + CheckBalance(check1));
        System.out.println("Смещение элементов массива: " + Arrays.toString(arr3) + " на " + k + " позиции.");
        System.out.println(Arrays.toString(RotateArray(arr3, k)));
    }
}
