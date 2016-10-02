package problems;

/**
 * Created by srikanthmannepalle on 8/26/16.
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Print all subarrays with 0 sum
 Given an array, print all subarrays in the array which has sum 0.

 Examples:

 Input:  arr = [6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7]
 Output:
 Subarray found from Index 2 to 4
 Subarray found from Index 2 to 6
 Subarray found from Index 5 to 6
 Subarray found from Index 6 to 9
 Subarray found from Index 0 to 10
 */

public class AllSubArraysWithZeroSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int sum = 0;
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0 ; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        //method1(arr);
        method2(arr);
    }

    private static void  method1(int[] arr) {
        for (int i = 0 ; i < arr.length; i++) {
            int sum = arr[i];
            for (int j = i + 1 ; j < arr.length; j++) {
                sum += arr[j];
                if ( sum == 0 ) {
                    System.out.println(" Subarray found from Index " + i + " to " + j);
                }
            }
        }
    }

    private static void method2(int[] arr) {
        Map<Integer, Integer> sumMap = new HashMap<>();
        int sum = 0 ;
        for (int i = 0 ; i < arr.length; i++) {
            sum += arr[i];
            if (null == sumMap.get(sum)) {
                sumMap.put(sum, i);
            } else {
                System.out.println(" Subarray found from Index " + (sumMap.get(sum) + 1) + " to " + i);
                sumMap.put(sum, i);
            }
        }
    }
}
