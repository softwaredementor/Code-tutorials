package problems;

import codeutils.TreeNode;
import codeutils.Utils;

/**
 * Created by srikanthmannepalle on 8/25/16.
 */
public class PostOrderTraversal {
    public static void main(String[] args) {
        TreeNode rootNode = Utils.constructBinaryTree(10, 2, 10);
        System.out.println("Print the tree");
        printPostOrder(rootNode);
    }

    private static void printPostOrder(TreeNode root) {
        if (null == root) {
            return;
        }
        printPostOrder(root.getLeftNode());
        printPostOrder(root.getRightNode());
        System.out.print(root.getData() + " ");

    }
}
