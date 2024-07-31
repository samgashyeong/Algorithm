

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] coin;
    static int n,k;
    static int[] dp;
    static long[] a = new long[90];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        coin = new int[n+1];
        dp = new int[k+1];
        for(int i=0;i<n;i++){
            coin[i+1] = Integer.parseInt(br.readLine());
        }


        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = coin[i]; j <= k; j++)
                dp[j] += dp[j - coin[i]];
        }

        System.out.println(dp[k]);
    }


}