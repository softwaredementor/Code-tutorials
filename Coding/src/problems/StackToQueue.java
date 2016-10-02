package problems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by srikanthmannepalle on 9/4/16.
 */
public class StackToQueue {

    static Queue<Integer>  queue = new LinkedList<>();
    static Stack<Integer> stack1 = new Stack<>();
    static Stack<Integer> stack2 = new Stack<>();
    static int calls;

    public static void main(String[] args) {
        //Original Queue implementation
        /**
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.poll();
        printQueue(queue);
        queue.element();
        queue.offer(1);
        queue.peek();
        */


        //implement the actual logic
        insertUsingStacks(5);
        insertUsingStacks(6);
        insertUsingStacks(7);
        insertUsingStacks(8);
        insertUsingStacks(9);
        insertUsingStacks(8);

        removeUsingStacks();
        removeUsingStacks();
        printQueueStacks();

    }

    public static void insertUsingStacks(Integer integer) {
        stack1.add(integer);
    }

    public static void removeUsingStacks() {
       while(!stack1.empty()) {
           stack2.add(stack1.pop());
       }
       System.out.println("Element removed = " + stack2.peek());
       stack2.pop();
       while(!stack2.empty()) {
           stack1.add(stack2.pop());
       }
    }

    public static void printQueueStacks() {
        System.out.println("Current queue");
        for (Integer integer : stack1) {
            System.out.println(integer);
        }
    }

    public static void printQueue(Queue<Integer> queue) {
        System.out.println("Queue state after call = " + (++calls));
        for (Integer integer : queue) {
            System.out.println(integer);
        }
    }
}
