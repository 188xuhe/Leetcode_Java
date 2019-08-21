import org.junit.Test;

import java.util.Arrays;

public class shuiyi {

    public int[] arr;
    public void sort(int[] arr, int low, int high) {
        int l = low;
        int h = high;
        this.arr = arr;
        int povit = arr[low];

        while (l < h) {
            //将小的放在前面
            while (l < h && arr[h] >= povit)
                h--;
            if (l < h) {
                arr[l] = arr[h];
                l++;
            }

            //将大的放在后面
            while (l < h && arr[l] <= povit)
                l++;

            if (l < h) {
                arr[h] = arr[l];
                h--;
            }
        }

        arr[l] = povit;

        System.out.print("l=" + (l + 1) + ";h=" + (h + 1) + ";povit=" + povit + "\n");
        System.out.println(Arrays.toString(arr));
        if (l - 1 > low) sort(arr, low, l - 1);
        if (h + 1 < high) sort(arr, h + 1, high);
    }

    @Test
    public void test(){
        sort(new int[] {1,2,3,7,9,5,3,4}, 0, 7);
        System.out.println(Arrays.toString(arr));
    }
}
