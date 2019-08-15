package leetcode.DFS;



import javafx.util.Pair;
import leetcode.TreeNode;
import org.junit.Test;
import sun.reflect.generics.tree.Tree;

import java.io.IOException;
import java.util.*;

import static java.lang.Math.max;


/**
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * DFS与BFS有两点不同：
 * 1. DFS要用到栈而不是队列，所以是cur_dep, node = stack.pop()
 * 2. DFS（先序遍历）节点右孩子先入栈，左孩子再入栈
 *
 */

public class code104 {
    //递归
   public int maxDepth1(TreeNode root) {

        if(root == null){
            return 0;
        }
        int left_height = maxDepth1(root.left);
        int right_height = maxDepth1(root.right);
        return max(left_height, right_height) + 1;
    }

    //迭代 BFS
    public int maxDepth2(TreeNode root){
        if(root == null) return 0;
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        if(root != null){
            queue.add(new Pair<>(root, 1));
        }
        int depth = 0;
        while (!queue.isEmpty()){
            Pair<TreeNode, Integer> current = queue.poll();
            root = current.getKey();
            int curr_depth = current.getValue();

            if(root != null){
                depth = max(curr_depth, depth);
                queue.add(new Pair<>(root.left, curr_depth+1));
                queue.add(new Pair<>(root.right, curr_depth+1));
            }
        }
        return depth;
    }

    //迭代 DFS
    public int maxDepth3(TreeNode root){
       if(root == null) return 0;
       Deque<Pair<TreeNode, Integer>> stack = new LinkedList<>();
       stack.push(new Pair<>(root,1));
       int depth = 0;
       while(!stack.isEmpty()){
           Pair<TreeNode, Integer> current = stack.pop();
           root = current.getKey();
           int curr_depth = current.getValue();
           if(root != null){
               depth = max(depth, curr_depth);
               stack.push(new Pair<>(root.right, curr_depth+1));
               stack.push(new Pair<>(root.left, curr_depth+1));
           }
       }
       return depth;
    }

    @Test
    public void test() throws IOException {
        String line = "[3,9,20,null,null,15,7]";
        TreeNode root = TreeNode.stringToTreeNode(line);
        TreeNode.prettyPrintTree(root);

        int max1 = maxDepth1(root);
        int max2 = maxDepth2(root);
        int max3 = maxDepth3(root);
        System.out.println(max1);
        System.out.println(max2);
        System.out.println(max3);

    }
}
