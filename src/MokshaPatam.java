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


        // While there are still nodes left in the queue: 			O(V)

        //	currentNode = queue.remove()								O(1)
        //	If currentNode == last square, return its roll #!	O(1)
        //	For each roll (1-6), r:									O(1)
        //		node = the node r spaces away.						O(1)
        //		If it is the beginning of a snake/ladder:			O(1)
        //			node = the ending node of the snake/ladder	O(1)
        //		If node has never been visited:						O(1)
        //			Save the # of rolls it took to get to node	O(1)
        //			Add node to the back of the queue


        // Add the first node, 1, to the queue
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[boardsize +1];
        queue.add(1);
        visited[1] = true;
        int numRolls = 0;

        // While there are still nodes left in the queue:
        while (!queue.isEmpty()) {
            // Number of nodes at depth level
            int size = queue.size();
            numRolls++;

            // Go through all positions at depth level
            for (int i = 0; i<size; i++) {
                //	currentNode = queue.remove()
                int currentNode = queue.remove();

                //	If currentNode == last square, return its roll #!
                if (currentNode == boardsize) {
                    // Return number of rolls to get there
                    return numRolls - 1;
                }

                //	For each roll (1-6), r:
                for (int j = 1; j <= 6; j++){
                    int nextSpot = currentNode+j;
                    // To avoid going out of bounds
                    if (nextSpot > boardsize){
                        continue;
                    }
                    // Node = the node r spaces away so move to the next spot
                    nextSpot = board[nextSpot];

                    // If node has never been visited:
                    if (!visited[nextSpot]) {
                        visited[nextSpot] = true;

                        // Save the # of rolls it took to get to node
                        // Add node to the back of the queue
                        queue.add(nextSpot);
                    }

                }
            }
        }
        // If no path to final square, return -1
        return -1;
    }
}
