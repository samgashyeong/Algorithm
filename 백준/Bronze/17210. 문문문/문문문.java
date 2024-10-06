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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());
        int f = Integer.parseInt(br.readLine());

        if(n > 5){
            System.out.println("Love is open door");
        }
        else{
            for(int i=2;i<=n;i++){
                if(f == 0){
                    f = 1;
                    System.out.println(f);
                }
                else{
                    f = 0;
                    System.out.println(f);
                }
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
