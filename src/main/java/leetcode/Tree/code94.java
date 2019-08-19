package leetcode.Tree;

import leetcode.TreeNode;
import org.junit.Test;

import java.util.*;

/**
 *给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code94 {
    public List<Integer> inorderTraversal1(TreeNode root) {
        if (root == null) return null;
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()){
            while (curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            list.add(curr.val);
            curr = curr.right;
        }
        return list;
    }


    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    public void helper(TreeNode root, List<Integer> res){
        if (root != null){
            if (root.left != null){
                helper(root.left, res);
            }
            res.add(root.val);
            if (root.right != null){
                helper(root.right, res);
            }
        }
    }

    @Test
    public void test() {
        String line = "[1,null,2,3]";
        TreeNode root = TreeNode.stringToTreeNode(line);
        TreeNode.prettyPrintTree(root);
        List<Integer> res = inorderTraversal2(root);
        System.out.println(res);
    }
}
