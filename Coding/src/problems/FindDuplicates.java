package problems;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by srikanthmannepalle on 8/25/16.
 */
public class FindDuplicates {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size");
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < arr.length ; i++) {
            arr[i] = sc.nextInt();
        }
        // 1 2 3 2 4 4 6 7 1 5
        // 1 1 2 2 3 4 4 5 6 7
        //method1(arr);
        method2(arr, sc);
    }


    private static void method1(int[] arr) { // O(n) + O(nlogn) = O(nlogn)
        Arrays.sort(arr);

        //sorted array
        for (int i = 0; i < arr.length ; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        int totalDuplicates = 0;

        //Test data
        /**
         * 10
         * 1 2 3 2 4 4 6 7 1 5
         */
        for (int i = 0 , j = i + 1, count = 0; i < arr.length; j++) {
            if (i != arr.length -1 && arr[i] == arr[j]) {
                count++;
            } else {
                System.out.println("Total duplicates for a[" + i + "]th element = " + arr[i] +" is " + count);
                i = j;
                totalDuplicates += count;
                count = 0;
            }
        }
        System.out.println("Total duplicate count = " + totalDuplicates);
    }

    private static void method2(int[] arr, Scanner sc) {
        int totalCount = 0 ;
        for (int i = 0 ; i < arr.length ; i++) {
            if (arr[Math.abs(arr[i])] > 0) {
                arr[Math.abs(arr[i])] *= -1;
                for (int j = 0; j < arr.length ; j++) {
                    System.out.print(arr[j] + " ");
                }
                System.out.println();
            } else {
                totalCount += 1;
            }
        }
        System.out.println("Total duplicate element found for = " + totalCount);
    }
}
