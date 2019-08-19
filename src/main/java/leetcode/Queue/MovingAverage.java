package leetcode.Queue;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {
    public Queue<Integer> queue = new LinkedList<>();
    public int size;

    public MovingAverage(int size) {
        this.size = size;
    }

    public double next(int val) {
        if (queue.size() < size){
            queue.add(val);
        }else {
            queue.poll();
            queue.add(val);
        }

            return Avg(queue);
    }

    public double Avg(Queue<Integer> queue){
        if (queue.size() == 0) return 0;
        int sum = 0;
        for (int i : queue){
            sum += i;
        }
        return sum * 1.0 / queue.size() ;
    }
}
