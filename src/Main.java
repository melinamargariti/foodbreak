import java.util.Arrays;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int presentations = 0;
        int length = 0;


        // Input data
//        try {
//            System.out.println("Give number of presentations. " +
//                    "(Integer, 1<=N<=10^5");
//
//            presentations = scanner.nextInt();
//
//            System.out.println("Give length of day, in time units." +
//                    "(Integer, 1<=T<=10^9");
//
//            length = scanner.nextInt();
//        } catch (InputMismatchException e) {
//            System.err.println("The 2 numbers need to be integers.");
//        }
//
//        scanner.nextLine();
//
//        int[][] arr = new int[presentations][2];
//
//        // TODO: Array input


        // Dummy Data
        presentations = 3;
        length = 60;
        int[][] arr = {
                {3, 60},
                {0,10},
                {20,30},
                {35,40}
        };

        // Array Sort
        Arrays.sort(arr, 1, arr.length,
                Comparator.comparingInt(row -> row[0]));

        for (int[] i : arr) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
        System.out.println();

        // Finding the biggest gap
        // caution: first gap, overlaps, last gap
        int maxGap = arr[1][0];
        int numberToSurpass = arr[1][1];

        for (int i = 2; i < arr.length; i++) {
            if (arr[i][0] > numberToSurpass) {
                maxGap = Math.max(maxGap, arr[i][0] - numberToSurpass);
            }

            numberToSurpass = Math.max(numberToSurpass, arr[i][1]);
        }

        // Only useful when the time after the final occupied presentation is the biggest so far
        maxGap = Math.max(maxGap, length - numberToSurpass);

        System.out.println(maxGap);
    }
}