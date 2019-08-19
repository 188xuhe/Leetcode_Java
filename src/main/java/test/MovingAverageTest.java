package test;

import leetcode.Queue.MovingAverage;
import org.junit.Test;

public class MovingAverageTest {
    @Test
    public void test(){
        int size = 1;
        MovingAverage obj = new MovingAverage(size);
        //System.out.println(obj.next(1));
        System.out.println(obj.next(4));
        System.out.println(obj.next(0));
        //System.out.println(obj.next(5));

        //结果为123， 注意int / int 的结果为 int
        System.out.println(12345 / 100);
        System.out.println(12345 * 1.0 / 100 );
    }
}
