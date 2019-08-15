package leetcode.Array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * 标签：数组遍历
 * 首先对数组进行排序，排序后固定一个数 nums[i]，再使用左右指针指向 nums[i]后面的两端，数字分别为 nums[L] 和 nums[R]，计算三个数的和sum 判断是否满足为 00，满足则添加进结果集
 * 如果 nums[i]大于 00，则三数之和必然无法等于 00，结束循环
 * 如果 nums[i] == nums[i-1]，则说明该数字重复，会导致结果重复，所以应该跳过
 * 当 sum == 00 时，nums[L]== nums[L+1] 则会导致结果重复，应该跳过，L++L++
 * 当 sum == 00 时，nums[R] == nums[R−1] 则会导致结果重复，应该跳过，R--R−−
 *
 * 作者：guanpengchn
 * 链接：https://leetcode-cn.com/problems/two-sum/solution/hua-jie-suan-fa-15-san-shu-zhi-he-by-guanpengchn/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

public class code15 {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList();
        int left; int right; int sum;
        int len = nums.length;

        //特殊情况
        if(nums.length < 3){
            return list;
        }

        //排序
        Arrays.sort(nums);
        for(int i = 0; i < len; i++){

            //num[i]>0, 无符合项
            if(nums[i] > 0) break;

            //去重
            if(i > 0 && nums[i] == nums[i-1]) continue;

            //首尾指针
            left = i+1; right = len-1;
            while (left < right){
                sum = nums[i] + nums[left] + nums[right];
                if(sum==0){
                    list.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    //去重
                    while (left < right && nums[left] == nums[left+1]) left++;
                    while (left < right && nums[right] == nums[right-1]) right--;
                    left++;
                    right--;
                }
                else if(sum < 0){
                    left++;
                }
                else if(sum > 0){
                    right--;
                }
            }
        }
        return list;
    }

    @Test
    public void test1(){

        int[] nums = {-1, 2, -1, 0, -3, 2, 4};

        List<List<Integer>> res = threeSum(nums);
        System.out.println(res);
    }
}

