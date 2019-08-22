package BasicAlgorithms;

import org.junit.Test;

import java.util.Arrays;

public class QuickSort {
    public void sort(int[] arr, int left, int right){
        //选取第一位为基准
        int povit = arr[left];
        int l = left;
        int h = right;

        while (l < h){
            //从后往前搜索，查到比基准小的放到基准的位置上
            while (h > l && arr[h] >= povit)
                h--;
            if (l < h){
                arr[l] = arr[h];
                l++;
            }

            //从前往后搜索，查到比基准大的放到基准的位置上
            while (l < h && arr[l] <= povit)
                l++;
            if (l < h){
                arr[h] = arr[l];
                h--;
            }
        }

        //最终l==h,放入基准值
        arr[l] = povit;

        //判断基准的左边是否有序列
        if (l - 1 > left) sort(arr, left, l - 1);
        //判断基准的右边是否有序列
        if (h + 1 < right) sort(arr, h + 1, right);
    }

    @Test
    public void test(){
        int[] a = new int[] {22, 34, 3, 32, 82, 55, 89, 50, 37, 5, 64, 35, 9, 70};
        sort(a, 0, a.length-1);
        System.out.println(Arrays.toString(a));
    }
}
