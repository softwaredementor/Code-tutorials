package codeutils;

import apple.laf.JRSUIUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static java.util.Arrays.*;

/**
 * Created by srikanthmannepalle on 8/25/16.
 */
public class Utils {
    public static int[] getIntArray() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter array size = ");
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0 ; i <n ; i++) {
            array[i] = sc.nextInt();
        }
        return array;
    }

    public static int[] getIntArrayInRange(int low, int high) {
        int[] array = new int[high - low + 1];
        for (int i = 0 ; i <array.length ; i++) {
            array[i] = ++low;
        }
        return array;
    }

    public static void printArray(int[] array) {
        for (int i = 0 ; i <array.length ; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void printArraySkippingElements(int[] array, boolean isMatch, int ...x) {
        for (int i = 0 ; i <array.length ; i++) {
            if (isMatch) {
                System.out.print(array[i] + " ");
            } else {
                for (int j = 0 ; j < x.length; j ++) {
                    if (array[i] != x[j]) {
                        System.out.print(array[i] + " ");
                    }
                }
            }
        }
        System.out.println();
    }

    public static int[] createRandomArray(int n, int low, int high) {
        int[] arr = new int[n];
        Random random = new Random();
        for (int i = 0; i<n ;i++) {
            arr[i] =  low + random.nextInt(high - low + 1);
        }
        return arr;
    }

    public static TreeNode constructBinaryTree(int n, int low, int high) {
        int[] arr = createRandomArray(n, low, high);
        printArray(arr);
        TreeNode root = new TreeNode(arr[0]);
        for (int i = 1 ; i < arr.length; i++) {
            insertNode(root, arr[i]);
        }
        return root;
    }

    private static void insertNode(TreeNode root, int x) {
        TreeNode tempRoot = root;
        TreeNode node = new TreeNode(x);
        do {
            if (node.getData() >= tempRoot.getData()) {
                if (null != tempRoot.getRightNode()) {
                    insertNode(tempRoot.getRightNode(), node.getData());
                } else {
                    tempRoot.setRightNode(node);
                }
            } else {
                if (null != tempRoot.getLeftNode()) {
                    insertNode(tempRoot.getLeftNode(),  node.getData());
                } else {
                    tempRoot.setLeftNode(node);
                }
            }
            return;
        } while(null != tempRoot.getRightNode() || null != tempRoot.getLeftNode());
    }
}
