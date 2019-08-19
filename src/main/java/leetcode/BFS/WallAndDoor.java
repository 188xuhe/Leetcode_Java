package leetcode.BFS;

/**
 * 你被给定一个 m × n 的二维网格，网格中有以下三种可能的初始化值：
 *
 * -1 表示墙或是障碍物
 * 0 表示一扇门
 * INF 无限表示一个空的房间。然后，我们用 2**31 - 1 = 2147483647 代表 INF。你可以认为通往门的距离总是小于 2147483647 的。
 * 你要给每个空房间位上填上该房间到 最近 门的距离，如果无法到达门，则填 INF 即可。
 *
 * 示例：
 *
 * 给定二维网格：
 *
 * INF  -1  0  INF
 * INF INF INF  -1
 * INF  -1 INF  -1
 *   0  -1 INF INF
 * 运行完你的函数后，该网格应该变成：
 *
 *   3  -1   0   1
 *   2   2   1  -1
 *   1  -1   2  -1
 *   0  -1   3   4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/walls-and-gates
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import javafx.util.Pair;
import leetcode.TreeNode;
import org.junit.Test;

import java.io.IOException;
import java.util.*;

public class WallAndDoor {
    private static final int WALL = -1;
    private static final int GATE = 0;
    private static final int EMPTY = Integer.MAX_VALUE;
    private static final List<int[]> Direction = Arrays.asList(
            new int[] {-1, 0},
            new int[] {1, 0},
            new int[] {0, 1},
            new int[] {0, -1}
    );

    public void wallsAndGates1(int[][] rooms) {
        int m = rooms.length;
        int n = rooms[0].length;
        if (m == 0) return;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (rooms[i][j] == GATE)
                    queue.add(new int[] {i, j});
            }
        }

        while (!queue.isEmpty()){
            int[] p = queue.poll();
            int row = p[0];
            int col = p[1];
            for (int[] dir : Direction){
                int r = row + dir[0];
                int c = col + dir[1];
                if (r <0 || r >= m || c < 0 || c >= n || rooms[r][c] != EMPTY){
                    continue;
                }
                rooms[r][c] = rooms[row][col] + 1;
                queue.add(new int[] {r,c});
            }
        }
    }


    @Test
    public void test() throws IOException {
        int[][] rooms = new int[][] {{2147483647,-1,0,2147483647},{2147483647,2147483647,2147483647,-1},{2147483647,-1,2147483647,-1},{0,-1,2147483647,2147483647}};
        wallsAndGates1(rooms);
        int m = rooms.length;
        int n = rooms[0].length;
        for (int i = 0; i < m; i++){
            System.out.println();
            for (int j = 0; j < n; j++){
                System.out.print(rooms[i][j] + " ");
            }
        }
    }
}
