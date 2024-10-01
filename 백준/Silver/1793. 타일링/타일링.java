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

        BigInteger[] dp = new BigInteger[251];

        String input;
        dp[0] = BigInteger.ONE;
        dp[1] = BigInteger.ONE;
        dp[2] = BigInteger.valueOf(3);

        for(int i=3;i<=250;i++){
            dp[i] = dp[i-1].add(dp[i-2].multiply(BigInteger.valueOf(2)));
        }
        while((input = br.readLine()) != null){
            System.out.println(dp[Integer.parseInt(input)]);
        }
    }

    static class Pair {
        int first, second;

        public Pair(int x, int y) {
            this.first = x;
            this.second = y;
        }
    }

    static void fun(int start, int w) {
        result = Math.max(result, w);
        for (int i = 0; i < map[start].size(); i++) {
            Pair next = map[start].get(i);
            if (!chk[next.first]) {
                chk[next.first] = true;
                fun(next.first, w + next.second);
                chk[next.first] = false;
            }
        }
    }
}
