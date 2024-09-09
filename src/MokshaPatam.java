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

        // Map/Array that maps each spot on the board with the ladders and snakes
        // If a ladder or snake is landed on, it directly points to the next spot it leads to using the array
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
                int currentNode = queue.remove();

                //	If currentNode equals the last square, return its roll #!
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
                    // Node equals the node r spaces away so move to the next spot
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
