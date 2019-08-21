package BasicAlgorithms;

import org.junit.Test;

import java.util.Arrays;

public class BubbleSort {
    public void sort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            // 设定一个标记，若为true，则表示此次循环没有进行交换，也就是待排序列已经有序，排序已经完成。
            boolean flag = true;

            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;

                    flag = false;
                }
            }

            if (flag) {
                break;
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
