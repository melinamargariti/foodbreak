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
        try {
            // Presentations check
            System.out.println("Give number of presentations. " +
                    "(Integer, 1<=N<=10^5");

            presentations = scanner.nextInt();

            if (presentations < 1 || presentations > Math.pow(10,5)) {
                throw new Exception("Presentations amount out of permitted bounds.");
            }

            // Length check
            System.out.println("Give length of day, in time units." +
                    "(Integer, 1<=T<=10^9");

            length = scanner.nextInt();

            if (length < 1 || length > Math.pow(10,9)) {
                throw new Exception("Length out of permitted bounds.");
            }

        } catch (InputMismatchException e) {
            System.err.println("The 2 numbers need to be integers.");
            return;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return;
        }

        int[][] arr = new int[presentations + 1][2];

        // Fill array
        int start = 0;
        int end = 0;
        arr[0][0] = presentations;
        arr[0][1] = length;

        for (int i = 1; i < arr.length; i++) {
            try {
                System.out.println("Give the starting time of lecture: " + i);
                start = scanner.nextInt();
                System.out.println("Give the end time of lecture: " + i);
                end = scanner.nextInt();

                if (start < 0 || end < 0 || end > length || start >= end) {
                    throw new Exception("Start and/or end time out of bounds.");
                }
            } catch (InputMismatchException e) {
                System.err.println("Start and end times must be integers.");
                return;
            } catch (Exception e) {
                System.err.println(e.getMessage());
                return;
            }
            arr[i][0] = start;
            arr[i][1] = end;

        }


//        // Dummy Data
//        presentations = 3;
//        length = 60;
//        int[][] arr = {
//                {3, 60},
//                {0,10},
//                {20,30},
//                {35,40}
//        };
//
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

        System.out.println("Max break: " + maxGap);
    }
}