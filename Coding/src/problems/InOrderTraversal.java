package problems;

import codeutils.TreeNode;
import codeutils.Utils;

/**
 * Created by srikanthmannepalle on 8/25/16.
 */
public class InOrderTraversal {
    public static void main(String[] args) {
        TreeNode rootNode = Utils.constructBinaryTree(10, 2, 10);
        System.out.println("Print the tree");
        printInOrder(rootNode);
    }

    private static void printInOrder(TreeNode root) {
        if (null == root) {
            return;
        }
        printInOrder(root.getLeftNode());
        System.out.print(root.getData() + " ");
        printInOrder(root.getRightNode());
    }
}
