package leetcode.Tree;

import leetcode.TreeNode;
import org.junit.Test;

import javax.xml.ws.handler.Handler;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class code144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> sol = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()){
            if(curr != null){
                sol.add(curr.val);
                stack.push(curr.right);
                curr = curr.left;
            }else {
                curr = stack.pop();
            }
        }
        return sol;

    }

    @Test
    public void test() {
        String line = "[1,null,2,3]";
        TreeNode root = TreeNode.stringToTreeNode(line);
        TreeNode.prettyPrintTree(root);
        List<Integer> res = preorderTraversal(root);
        System.out.println(res);
    }
}
