
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args){

        //未知列数输入，ctrl + D结束输入
        //scannerNext1();

        //已知列数输入，第一行为列数
        //scannerNext2();

        //第一行行数，已知行数输入
        //scannerNextLine();

        //未知多行输入
        //scannerNextLine2();

        //格式化输出
        test();
        }


    /**
     * 1 2 3 4 5 6 ...
     */
    public static void scannerNext1() {
        Scanner scan = new Scanner(System.in);
        String[] str = scan.nextLine().trim().split(" ");
        System.out.println(Arrays.toString(str));
    }
    /*
    public static void scannerNext1() {
        //使用List保存
        ArrayList<String> in = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        // 从键盘接收数据
        // next方式接收字符串
        System.out.println("未知数据个数的next方式接收：");
        // 判断是否还有输入
        while (scan.hasNext()) {
            String str1 = scan.next();
            in.add(str1);
        }
        scan.close();

        for (String string : in) {
            System.out.println(string);
        }
    }
     */

    /**
     * 5
     * 8 7 6 5 9
     */
    public static void scannerNext2() {
        Scanner scan = new Scanner(System.in);
        // 从键盘接收数据
        // next方式接收字符串
        System.out.println("固定个数的数据的next方式接收：");
        // 判断是否还有输入
        List<Integer> in = new ArrayList<>();
        int count = scan.nextInt();
        scan.nextLine();
        for(int i = 0; i < count; i++){
            String str2 = scan.next();
            in.add(Integer.parseInt(str2));
        }
        in.forEach(x -> System.out.println(x));
        scan.close();
    }

    /**
     * 5
     * 2 1
     * 3 2
     * 4 3
     * 5 2
     * 6 1
     */
    public static void scannerNextLine() {
        Scanner in = new Scanner(System.in);
        int count = Integer.parseInt(in.nextLine());
        int[][] num = new int[count][2];
        for(int i=0;i<count;i++){
            String temp = in.nextLine();
            //常常会用到的方法，trim, split
            String[] ss = temp.trim().split(" ");
            num[i][0] = Integer.parseInt(ss[0]);
            num[i][1] = Integer.parseInt(ss[1]);
        }
    }

    /**
     * 1 2 3
     * 2 3 4
     * 4 5 6
     * ...
     */
    public static void scannerNextLine2() {
        Scanner scan = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        while (true){
            String s = scan.nextLine();
            if(s.equals(""))
                break;
            list.add(s);

        }
        System.out.println(list);
    }

    /*
    public static void scannerNextLine2() {
        Scanner scan = new Scanner(System.in);
        // 从键盘接收数据
        List<String> list = new ArrayList<>();
        // nextLine方式接收字符串
        System.out.println("nextLine方式接收：");
        // 判断是否还有输入
        boolean flag;
        while (scan.hasNextLine()) {

            String s = scan.nextLine();
            list.add(s);
        }
        System.out.println(list);
        scan.close();
    }

     */


    public static void test(){
        float num = 3.141592653f;
        int len = 9;
        System.out.printf("%8.2f, %d \n",num,len);

    }

}
