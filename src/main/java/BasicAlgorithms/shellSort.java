package BasicAlgorithms;

import org.junit.Test;

import java.util.Arrays;

public class shellSort {
    public void sort(int[] arr){
        //gap为分组用增量
        int gap = 0;
        if(gap < (double) arr.length/3)
            gap = gap * 3 + 1;
        while (gap > 0){
                //插入排序
                for (int i = gap; i < arr.length; i++){
                    //先把要插入的数拿出来
                    int temp = arr[i];
                    //有序数列的最高位
                    int j = i - gap;

                    while (j>=0 && temp < arr[j]){
                        arr[j+gap] = arr[j];
                        j -= gap;
                    }
                    arr[j+gap] = temp;

                }
                gap = (int) Math.floor(gap/3);
        }
    }

    @Test
    public void test(){
        //int[] a = new int[] {22, 34, 3, 32, 82, 55, 89, 50, 37, 5, 64, 35, 9, 70};
        int[] a = new int[] {32, 24};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
