package leetcode.DFS;

/**
 * 给定一个非空二叉树，返回其最大路径和。
 *
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 *
 *        1
 *       / \
 *      2   3
 *
 * 输出: 6
 * 示例 2:
 *
 * 输入: [-10,9,20,null,null,15,7]
 *
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 输出: 42
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-maximum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import leetcode.TreeNode;
import org.junit.Test;

import java.io.IOException;


public class code124 {
    //全局变量以记录每个节点的max_sum
    public int max_sum;

    public int max_gain(TreeNode root){
        if (root == null) return 0;

        //判断左、右是否保留
        int left_gain = Math.max(max_gain(root.left), 0);
        int right_gain = Math.max(max_gain(root.right), 0);

        //以当前节点为开始节点计算最高增益
        int price_gain = root.val + left_gain + right_gain;
        max_sum = Math.max(max_sum, price_gain);

        //选择走左边还是右边
        return root.val + Math.max(left_gain, right_gain);

    }
    public int maxPathSum(TreeNode root) {
        max_sum = Integer.MIN_VALUE;
        max_gain(root);
        return max_sum;
    }

    @Test
    public void test() throws IOException {
        String line = "[-10,9,20,null,null,15,7]";
        TreeNode root = TreeNode.stringToTreeNode(line);
        TreeNode.prettyPrintTree(root);

        int res = maxPathSum(root);
        System.out.println(res);

    }
}
