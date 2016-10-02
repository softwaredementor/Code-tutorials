package problems;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by srikanthmannepalle on 8/26/16.
 * http://www.geeksforgeeks.org/check-if-an-array-can-be-divided-into-pairs-whose-sum-is-divisible-by-k/
 */
public class ArrayPairsSumDivisibleByK {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter array size");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter array elements");
        for (int i = 0 ; i < n ; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter the value of K = ");
        int k = sc.nextInt();
        //method1(n, k, arr);

    }
        public static void method2(int[] arr) {

        }

        public static void method1(int n, int k, int[] arr) {
            Arrays.sort(arr);
            boolean isPairFound = false;
            if (n%2 != 0) {
                System.out.println("False");
            } else {
                int start = 0, end = n - 1;
                while (start < end && end >= 0) {
                    System.out.println("Current elements compared = " + arr[start] + " " + arr[end]);
                    if ((arr[start] + arr[end]) % k == 0) {
                        System.out.println("Pair found = " + arr[start] + " " + arr[end]);
                        start++;
                        end--;
                        isPairFound = true;
                    } else {
                        end--;
                    }
                }

                if (!isPairFound) {
                    System.out.println("False");
                }
        }
    }
}
