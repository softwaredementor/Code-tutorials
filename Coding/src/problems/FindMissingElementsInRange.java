package problems; /**
 * Created by srikanthmannepalle on 8/25/16.
 */

import codeutils.Utils;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Find missing elements of a range
 Given an array arr[0..n-1] of distinct elements and a range [low, high],
 find all numbers that are in range, but not in array.
 The missing elements should be printed in sorted order.

 Examples:

 Input: arr[] = {10, 12, 11, 15},
 low = 10, hight = 15
 Output: 13, 14

 Input: arr[] = {1, 14, 11, 51, 15}, 1, 11, 14, 51, 55
 low = 50, hight = 56
 Output: 50, 52, 53, 54

 http://www.geeksforgeeks.org/find-missing-elements-of-a-range/
 */
//TODO incomplete
public class FindMissingElementsInRange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter low = ");
        int low = sc.nextInt();
        System.out.println("Enter high = ");
        int high = sc.nextInt();
        int[] arr = Utils.getIntArray();
        int[] arrayInRange = Utils.getIntArrayInRange(low, high);
        Arrays.sort(arr);
        for (int i = 0, j = 0; i < arrayInRange.length && j < arr.length;) {
            if (arr[i] > arrayInRange[j]) {
                j++;
            } else {
                i++;
            }
        }
    }
}
