package BasicAlgorithms;

import org.junit.Test;

import java.util.Arrays;

public class SelectionSort {
    public void sort(int[] a){

        for (int i = 0; i < a.length - 1; i++){
            //每轮遍历开始都认为min在第一位
            int min = i;

            //遍历一遍查找最小值
            //j从i+1位置开始查找
            for (int j = i+1; j < a.length; j++){
                if (a[j] < a[min]){
                    min = j;
                }
            }

            if (min != i){
                int temp = a[i];
                a[i] = a[min];
                a[min] = temp;
            }
        }
    }

    @Test
    public void test(){
        int[] a = new int[] {22, 34, 3, 32, 82, 55, 89, 50, 37, 5, 64, 35, 9, 70};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
