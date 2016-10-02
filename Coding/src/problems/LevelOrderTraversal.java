package problems;

import codeutils.TreeNode;
import codeutils.Utils;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by srikanthmannepalle on 8/25/16.
 */
public class LevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode rootNode = Utils.constructBinaryTree(10, 2, 10);
        System.out.println("Print the tree");
        printLevelOrder(rootNode);
    }

    private static void printLevelOrder(TreeNode root) {
        if (null == root) {
            return;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        System.out.print(queue.poll().getData() + " ");
        printLevelOrder(root.getLeftNode());
        printLevelOrder(root.getRightNode());
    }
}
