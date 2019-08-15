package leetcode.DFS;


import javafx.util.Pair;
import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;



/**
 * 给定一个 N 叉树，找到其最大深度。
 *
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 *
 * 例如，给定一个 3叉树 :
 * *        3
 *  *    / |  \
 *  *   9  20  34
 *  *     / \
 *  *    15  7
 * 我们应返回其最大深度，3。
 *
 * 说明:
 *
 * 树的深度不会超过 1000。
 * 树的节点总不会超过 5000。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

public class code559 {
    public int maxDepth(Node root) {
        if(root == null) return 0;

        Deque<Pair<Node, Integer>> stack = new LinkedList<>();
        stack.push(new Pair<>(root, 1));
        int depth = 0;
        while (!stack.isEmpty()){
            Pair<Node, Integer> current = stack.pop();
            root = current.getKey();
            int curr_depth = current.getValue();
            if(root != null){
                depth = Math.max(depth, curr_depth);
                for(Node node : root.children){
                    stack.push(new Pair<>(node, curr_depth+1));
                }
            }
        }
        return depth;
    }

    @Test
    public void test(){

    }
}
