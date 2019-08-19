package leetcode.BFS;

import org.junit.Test;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 *
 * 示例 1:
 *
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 * 示例 2:
 *
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 */

public class NumSquares {
    private static class Node {
        int val;
        int step;

        Node(int val, int step) {
            this.val = val;
            this.step = step;
        }
    }

    public int numSquares(int n) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(n, 1));
        Set<Integer> used = new HashSet<>();
        while (!queue.isEmpty()) {
            Node curr_node = queue.poll();
            int val = curr_node.val;
            int step = curr_node.step;

            // 每一层的广度遍历
            for (int i = 1;; i++) {
                int nextVal = val - i * i;
                // 说明已到最大平方数
                if (nextVal < 0)
                    break;

                // 由于是广度遍历，所以当遍历到0时，肯定是最短路径
                if(nextVal == 0)
                    return step;

                // 当再次出现时没有必要加入，因为在该节点的路径长度肯定不小于第一次出现的路径长
                if(!used.contains(nextVal)){
                    queue.add(new Node(nextVal, step + 1));
                    used.add(nextVal);
                }
            }
        }
        return -1;
    }


    @Test
    public void test() {
        System.out.println(new NumSquares().numSquares(24));
    }

}

