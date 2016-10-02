package problems;

import java.util.Scanner;

/**
 * Created by srikanthmannepalle on 8/25/16.
 */
public class PowerOf2 {
    public static void  main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number");
        int n = sc.nextInt();
        method1(n);
        method2(n);
    }

    private static void method1(int n) {
        if (n > 0 && (n & n-1) == 0) {
            System.out.println("Is a power of 2");
        } else {
            System.out.println("Is not a power of 2");
        }
    }

    private static void method2(int n) {
        if (n > 0 && (n ^ n-1) == 2*n -1) {
            System.out.println("XORed output = " + (n ^ n-1));
            System.out.println("Is a power of 2");
        } else {
            System.out.println("Is not a power of 2");
        }
    }
}
