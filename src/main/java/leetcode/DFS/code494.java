package leetcode.DFS;

import javafx.util.Pair;
import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
 *
 * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 *
 * 示例 1:
 *
 * 输入: nums: [1, 1, 1, 1, 1], S: 3
 * 输出: 5
 * 解释:
 *
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 *
 * 一共有5种方法让最终目标和为3。
 * 注意:
 *
 * 数组的长度不会超过20，并且数组中的值全为正数。
 * 初始的数组的和不会超过1000。
 * 保证返回的最终结果为32位整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/target-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code494 {
    public int findTargetSumWays1(int[] nums, int S) {
        //记录0的数量
        int f0;
        if (nums == null) return 0;
        //Pair第一位放位置，第二位放和
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();

        //放入第一位
        queue.add(new Pair<>(0, nums[0]));
        queue.add(new Pair<>(0, -1 * nums[0]));
        if (nums[0] == 0)
            f0 = 1;

        int count = 0;
        while (!queue.isEmpty()){
            Pair<Integer, Integer> curr = queue.poll();
            int curr_num = curr.getKey();
            int curr_sum = curr.getValue();

            if (curr_sum == S && curr_num == nums.length-1)
                count++;

            if (curr_num+1 < nums.length){
                for (int i : new int[] {-1, 1}){
                    queue.add(new Pair<>(curr_num+1, curr_sum + i * nums[curr_num+1]));
                }
            }
        }
        return count;
    }

    /******************************************************************************************/

    private int res = 0;
    public int S;


    public int findTargetSumWays2(int[] nums, int S) {
        this.S = S;
        DFS(nums, 0, 0);  //递归
        return res;
    }

    private void DFS(int[] nums, int sum, int p){
        //当轮询到nums的最后，就返回，若此时的sum=S，res++
        if(p >= nums.length){
            if(S == sum)
                res++;
            return;
        }

        DFS(nums, sum + nums[p], p + 1);
        DFS(nums, sum - nums[p], p + 1);
    }

    @Test
    public void test(){
        int[] nums = {1,1,1,1,1};
        int s = 3;
        System.out.println(findTargetSumWays2(nums, s));
    }

}
