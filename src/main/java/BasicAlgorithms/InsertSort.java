package BasicAlgorithms;

import org.junit.Test;

import java.util.Arrays;

public class InsertSort {
    public void sort(int[] a){
        for (int i = 1; i < a.length; i++){
            //先把要插入的数拿出来
            int temp = a[i];
            //有序数列的最高位
            int j = i-1;
            while (j>=0 && temp < a[j]){
                //将大于temp的数向后移动一位
                a[j+1] = a[j];
                j--;
            }
            //因为多一次j--，所以要j+1
            if (j+1 != i)
                a[j+1] = temp;
        }
    }

    @Test
    public void test(){
        int[] a = new int[] {22, 34, 3, 32, 82, 55, 89, 50, 37, 5, 64, 35, 9, 70};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
