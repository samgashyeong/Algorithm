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

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[31];

        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 3;

        for(int i=4;i<=n;i++){
            if(i%2 == 0){
                dp[i] = dp[i-2]*3+2;

                for(int j=4;j<n-1;j+=2){
                    if(i-j < 0){
                        continue;
                    }
                    dp[i] += dp[i-j]*2;
                }
            }
        }

        System.out.println(dp[n]);
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
        String first;
        int second;
        int third;
        int fth;
        public Three(String x, int y, int z, int a) {
            this.first = x;
            this.second = y;
            this.third = z;
            this.fth = a;
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
