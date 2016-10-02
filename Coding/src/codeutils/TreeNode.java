package codeutils;

/**
 * Created by srikanthmannepalle on 8/25/16.
 */
public class TreeNode {

    private TreeNode leftNode;
    private TreeNode rightNode;
    private int data;

    public TreeNode(int n) {
        this.data = n;
    }

    public TreeNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(TreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public TreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(TreeNode rightNode) {
        this.rightNode = rightNode;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

}
