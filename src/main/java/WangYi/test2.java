package WangYi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        List<String[]> collect = new ArrayList<>();
        String[] strings;
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < Integer.valueOf(str); i++){
            strings = new String[6];
            for(int j = 0; j < 6; j++){
                strings[j] = in.next();

            }
            collect.add(strings);
            for(String[] split: collect){
                Integer m = Integer.valueOf(split[0]);
                Integer t = Integer.valueOf(split[1]);
                Integer m1 = Integer.valueOf(split[2]);
                Integer t1 = Integer.valueOf(split[3]);
                Integer m2 = Integer.valueOf(split[4]);
                Integer t2 = Integer.valueOf(split[5]);

                Integer result1 = m1*((t + t1*2 - 1)/(t1*2)) + m1*((t/(t1*2))+1) - m2*((t + t2*2 - 1)/(t2*2)) - m2*((t/(t2*2))+1);

                if(result1 <0){
                    result1 = 0;
                }
                if(result1 > m){
                    result1 = m;
                }
                result.add(result1);
            }
            for(Integer res : result){
                System.out.println(res);
            }
        }

    }
}
