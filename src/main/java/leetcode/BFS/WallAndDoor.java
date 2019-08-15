package leetcode.BFS;

import javafx.util.Pair;
import leetcode.TreeNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WallAndDoor {
    public void wallsAndGates(int[][] rooms) {
        Queue<Pair<Integer,Integer,Integer>> queue = new LinkedList<>();  // store all nodes which are waiting to be processed
        Set<Pair<Integer,Integer>> used = new HashSet<>();

        int step = 0;       // number of steps neeeded from root to current node
        int m = rooms.length;
        int n = rooms[0].length;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++){
                if (rooms[i][j] == 0)
                    queue.add(new Pair<>(i, j));
                    used.add(new Pair<>(i, j));
            }

        while (!queue.isEmpty()) {
            step = step + 1;
            // iterate the nodes which are already in the queue
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                Pair cur = queue.poll();
                return step if cur is target;
                for (TreeNode next : the neighbors of cur) {
                    if (next is not in used) {
                        add next to queue;
                        add next to used;
                    }
                }
                remove the first node from queue;
            }
        }
        return -1;          // there is no path from root to target
    }
}
