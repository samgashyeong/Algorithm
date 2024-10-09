import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {

    static int n;
    static int h;
    static boolean[] chk;
    static int result = 0;
    static ArrayList<Pair>[] map;
    static int size;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String n =br.readLine();
        int size = String.valueOf(n).length();
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0;i<size;i++){
            arr.add(Integer.parseInt(String.valueOf(String.valueOf(n).charAt(i))));
        }

        Collections.sort(arr);

        if(arr.get(0) != 0){
            System.out.println(-1);
        }
        else{
            int sum = 0;
            for(int i=1;i<size;i++){
                sum += arr.get(i);

            }
            if(sum % 3 == 0){
                for(int i=size-1;i>=0;i--){
                    System.out.print(arr.get(i));
                }
            }
            else{
                System.out.println(-1);
            }
        }
    }

    static class Pair {
        int first;
        int second;

        public Pair(int x, int y) {
            this.first = x;
            this.second = y;
        }
    }

    static class Three {
        int first;
        int second;
        int third;
        public Three(int x, int y, int z) {
            this.first = x;
            this.second = y;
            this.third = z;
        }
    }

//    static void fun(int start, int w) {
//        result = Math.max(result, w);
//        for (int i = 0; i < map[start].size(); i++) {
//            Pair next = map[start].get(i);
//            if (!chk[next.first]) {
//                chk[next.first] = true;
//                fun(next.first, w + next.second);
//                chk[next.first] = false;
//            }
//        }
//    }
}
