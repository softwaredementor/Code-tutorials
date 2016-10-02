package problems;

import java.util.Scanner;

/**
 * Created by srikanthmannepalle on 8/24/16.
 */
public class CircularList {
    private int data;
    private CircularList nextNode;

    private CircularList(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public CircularList getNextNode() {
        return nextNode;
    }

    public void setNextNode(CircularList nextNode) {
        this.nextNode = nextNode;
    }

    private static void printAllElements(CircularList head) {
        CircularList temp = head;
        while (null != temp) {
            System.out.println(temp.data);
            temp = temp.nextNode;
        }
    }

    private static void printCyclicElement(CircularList head, int index) {
        CircularList temp = head;
        int count = 0;
        while (null != temp && ++count != index) {
            temp = temp.nextNode;
        }
        System.out.println("Element at " + index + " cyclic position = " + temp.data);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        CircularList head = new CircularList(sc.nextInt());
        CircularList movingPointer = head;
        int count = 0;
        while (++count <= n -1) {
            CircularList tempNode = new CircularList(sc.nextInt());
            movingPointer.nextNode = tempNode;
            movingPointer = tempNode;
        }

        printAllElements(head);

        //to make this cyclic
        movingPointer.nextNode = head;

        System.out.println("Enter index");
        printCyclicElement(head, sc.nextInt());
    }

}
