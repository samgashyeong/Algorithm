import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static int h;
    static boolean[] chk;
    static int result = 0;
    static ArrayList<Pair>[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        long[][] dp = new long[k+1][n+1];

        for(int i=0;i<=n;i++){
            dp[1][i] = 1;
        }

        for(int i=0;i<=k;i++){
            dp[i][0] = 1;
        }
        for(int i=2;i<=k;i++){
            for(int j=1;j<=n;j++){
                dp[i][j] =( dp[i][j-1] + dp[i-1][j]) % 1000000000;
            }
        }
        System.out.println(dp[k][n]);
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
