package problems; /**
 * Created by srikanthmannepalle on 8/25/16.
 */

import java.util.Arrays;
import java.util.Scanner;

/**
 * Given an array, find inversion count of array.

 Inversion Count for an array indicates – how far (or close) the array is from being sorted.
 If array is already sorted then inversion count is 0. If array is sorted in reverse order that inversion count is the maximum.
 Formally speaking, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.
 The sequence 2, 4, 1, 3, 5 has three inversions (2, 1), (4, 1), (4, 3).
 http://www.practice.geeksforgeeks.org/problem-page.php?pid=558
 */

public class InversionOfArray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter array size");
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        method1(arr);
    }

    private static void method1(int[] arr) {
        int inversionCount = 0;
        for (int i = 0 ; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    inversionCount++;
                    System.out.println("Inversion pair = {" + arr[i] + "," + arr[j] + "}");
                }
            }
        }
        System.out.println("Total inversion pairs = " + inversionCount);
    }
}
