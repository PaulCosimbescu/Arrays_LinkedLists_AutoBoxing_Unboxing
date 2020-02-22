package ArrayChallenge;

import java.util.Scanner;

public class ArrayChallenge {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("How long do you want the array: ");
        int number = scanner.nextInt();
        int[] array = getIntegers(number);

        array = sortArray(array);

        printArray(array);

    }

    public static int[] getIntegers(int number) {
        int[] array = new int[number];
        System.out.println("Enter " + number + " integer values:\r");

        for(int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        return array;
    }

    public static int[] sortArray(int[] array) {
        int[] sortedArray = new int[array.length];
        System.arraycopy(array, 0, sortedArray, 0, array.length);
        boolean flag = true;
        int temp;

        while(flag) {
            flag = false;
            for(int i = 0; i < sortedArray.length - 1; i++) {
                if(sortedArray[i] < sortedArray[i + 1]) {
                    temp = sortedArray[i];
                    sortedArray[i] = sortedArray[i + 1];
                    sortedArray[i + 1] = temp;
                    flag = true;
                }
            }
        }
        return sortedArray;
    }

    public static void printArray(int[] array) {
        System.out.println();
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}