package leetcode.BFS;

import javafx.util.Pair;
import org.junit.Test;

import java.util.*;

/**
 * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为  '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
 *
 * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
 *
 * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
 *
 * 字符串 target 代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解锁，返回 -1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/open-the-lock
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class OpenLock {
    public int openLock(String[] deadends, String target) {
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        Set<String> set = new HashSet<>(Arrays.asList(deadends));
        if (set.contains("0000") || target == null)
            return -1;
        queue.add(new Pair<>("0000",0));
        int depth = 0;

        while (!queue.isEmpty()){
            Pair<String, Integer> curr = queue.poll();
            String curr_str = curr.getKey();

            int curr_depth = curr.getValue();
            if (curr_str.equals(target)) {
                return curr_depth;
            }else {
                depth = curr_depth + 1;
                for (int i = 0 ; i < 4;i++){
                    for (int oper: new int[]{-1,1}){
                        String str = curr_str.substring(0,i) + String.valueOf((curr_str.charAt(i) - '0' + 10 + oper)%10) + curr_str.substring(i+1);
                        if (!set.contains(str)){
                            //*重要：这一步易错，放在出队列时是不对的
                            set.add(str);
                            queue.add(new Pair<String,Integer>(str,depth));
                        }
                    }
                }
            }
        }
        return -1;
    }

    @Test
    public void test() {
        String[] dendends = {"0201","0101","0102","1212","2002"};
        String target = "0202";
        int res = openLock(dendends, target);
        System.out.println(res);
    }

    @Test
    public void test2(){
        String string = "8888";
        for (int i = 0 ; i < 4;i++){
            for (int oper: new int[]{-1,1}){
                // "emptiness".substring(9) returns "" (an empty string)
                String str = string.substring(0,i) + String.valueOf((string.charAt(i) - '0' + 10 + oper)%10) + string.substring(i+1);
                System.out.println(str);
            }
        }
    }

}

