package WangYi;

import java.util.*;

public class test {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());

        List<Integer> list = new ArrayList<>();
        for(int sample = 0; sample < t; sample++){
            int n = Integer.parseInt(scanner.nextLine());

            Set<Integer> set = new HashSet<>();

            for(int i = 0 ; i < n-1; i++) {
                int arr = scanner.nextInt();
                String binaryStr = Integer.toBinaryString(arr);
                int count = 0;
                for(int j = 0; j < binaryStr.length(); j++){
                    if(binaryStr.charAt(j) == '1'){
                        count++;
                    }
                }
                set.add(count);
            }

            int leiBie = set.size();
            System.out.println(leiBie);
            list.add(leiBie);
        }

        /*
        for(int s = 0; s < list.size()-1; s++){
            System.out.print(list.get(s) + " ");
        }
        System.out.println(list.get(list.size()-1));
        */
    }
}
