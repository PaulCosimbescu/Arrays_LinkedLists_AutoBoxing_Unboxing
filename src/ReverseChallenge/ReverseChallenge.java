package ReverseChallenge;

import java.util.Arrays;

public class ReverseChallenge {

    public static void main(String[] args) {

        int[] array = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(array));
        reverse(array);

        System.out.println(Arrays.toString(array));

        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    private static void reverse(int[] array) {
        int[] reverse = new int[array.length];
        System.arraycopy(array,0, reverse,0, array.length);

        int j = 0;
        for(int i = array.length - 1; i > -1; i --) {
            reverse[j] = array[i];
            j++;
        }
        System.arraycopy(reverse, 0, array, 0, reverse.length);
    }
}