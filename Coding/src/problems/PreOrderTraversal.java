package problems;

import codeutils.TreeNode;
import codeutils.Utils;

/**
 * Created by srikanthmannepalle on 8/25/16.
 */
public class PreOrderTraversal {
    public static void main(String[] args) {
        TreeNode rootNode = Utils.constructBinaryTree(10, 2, 10);
        System.out.println("Print the tree");
        printPreOrder(rootNode);
    }

    private static void printPreOrder(TreeNode root) {
        if (null == root) {
            return;
        }
        System.out.print(root.getData() + " ");
        printPreOrder(root.getLeftNode());
        printPreOrder(root.getRightNode());
    }
}
