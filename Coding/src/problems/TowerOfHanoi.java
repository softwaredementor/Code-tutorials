package problems;

/**
 * Created by srikanthmannepalle on 8/25/16.
 */

//TODO : more than 3 disks
public class TowerOfHanoi {
    private static int totMoves;

    public static void main(String[] args) {
        printMoves(2, 'A', 'B', 'C');
        System.out.println("Total number of moves = " + totMoves);
    }

    private static void printMoves(int N, char start, char middle, char end) {
        if (N == 1) {
            System.out.println("Move from start  = " + start + " to end = " + end);
            totMoves++;
            return;
        } else {
            printMoves(N-1, start, end, middle);
            printMoves(1, start, middle, end);
            printMoves(N-1, middle, start, end);
        }
    }
}
