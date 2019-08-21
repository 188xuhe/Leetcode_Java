package leetcode.DFS;

import javafx.util.Pair;
import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

public class code394 {
    public String decodeString(String s) {
        String res = "";
        int multi = 0;
        Deque<Pair<Integer,String>> stack = new LinkedList<>();
        for(char c : s.toCharArray()) {
            if(c == '[') {
                //遇到'[' 就入栈
                stack.push(new Pair<>(multi, res));
                //入栈后，初始化multi, res
                multi = 0;
                res = "";
            }
            else if(c == ']') {
                Pair<Integer,String> curr = stack.pop();
                int curr_multi = curr.getKey();
                String last_res = curr.getValue();
                String tmp = "";
                for(int i = 0; i < curr_multi; i++)
                    tmp += res;
                res = last_res + tmp;
            }
            else if(c >= '0' && c <= '9') multi = multi * 10 + Integer.parseInt(c + "");
            else res += c;
        }
        return res.toString();
    }


    @Test
    public void test(){
        System.out.println(decodeString("3[4[b]]"));
    }

}
