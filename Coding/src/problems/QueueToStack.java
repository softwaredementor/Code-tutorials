package problems;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by srikanthmannepalle on 9/4/16.
 */
public class QueueToStack {
    static Queue<Integer> queue1 = new LinkedList<>();
    static Queue<Integer> queue2 = new LinkedList<>();

    static int calls;

    public static void main(String[] args) {
        //Original Queue implementation

         queue1.add(1);
         queue1.add(2);
         queue1.add(3);
         queue1.add(4);
         printStack();
         insertIntoStack(5);
         removeFromStack();
         printStack();

    }

    public static void insertIntoStack(Integer integer) {
         System.out.println(integer + " inserted into the stack");
         queue1.add(integer);
    }

    public static void removeFromStack() {
         while(queue1.size() != 1) {
             queue2.add(queue1.poll());
         }
         System.out.println("Element removed = " + queue1.peek());
         queue1.remove();
         while(!queue2.isEmpty()) {
             queue1.add(queue2.poll());
         }
    }

    public static void printStack() {
        System.out.println("Current stack ");
        for (Integer integer : queue1) {
            System.out.println(integer);
        }
    }

}
