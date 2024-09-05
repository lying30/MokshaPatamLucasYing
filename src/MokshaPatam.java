import java.util.LinkedList;
import java.util.Queue;

/**
 * Moksha Patam
 * A puzzle created by Zach Blick
 * for Adventures in Algorithms
 * at Menlo School in Atherton, CA
 *
 * Completed by: [Lucas Ying]
 *
 */

public class MokshaPatam {

    /**
     * TODO: Complete this function, fewestMoves(), to return the minimum number of moves
     *  to reach the final square on a board with the given size, ladders, and snakes.
     */
    public static int fewestMoves(int boardsize, int[][] ladders, int[][] snakes) {

        // Implement some sort of Breadth First Search similar to Maze Solver in CS2
        // In order to do this I will probably need a way to access different points on the board
        // So maybe I start with implementing an array of points to access?


        // I think this array is arraying the board
        int[] board = new int[boardsize + 1];
        for (int i = 1; i <= boardsize; i++){
            board[i] = i;
        }
        for (int[] ladder : ladders) {
            board[ladder[0]] = ladder[1];
        }
        for (int[] snake : snakes) {
            board[snake[0]] = snake[1];
        }

        // Go through and maybe use a queue like we did in maze solver,
        // but this time we do not have to check for the right direction or if we hit a wall.
        // All I am looking for is the fastest way to navigate through the board array while utilizing
        // the ladders and avoiding the snakes

        // Go through the next six spaces ahead of where the current spot is, and check if there is a ladder,
        // if there is a ladder use that turn to go that numebr of spaces, and if there isn't go maximum distance
        // without hitting a snake --> so 6 as long as there isnt a snake on 6
        // If there are two ladders in the upcoming 6 spaces, compare the first number to see which one goes further up the board
        //


        Queue<Integer> queue = new LinkedList<>();
        boolean[] marked = new boolean[boardsize +1];

        queue.add(1);
        marked[1] = true;
        int numMoves


        queue.enqueue(s);
        while (!queue.isEmpty()){
            int v = queue.dequeue();
            for (int w: G.adj(v))
                if (!marked[w])
            {
                edgeTo[w] = v;
                marked[w] = true;
                queue.enqueue(w);
            }

        }




        return 0;
    }
}
