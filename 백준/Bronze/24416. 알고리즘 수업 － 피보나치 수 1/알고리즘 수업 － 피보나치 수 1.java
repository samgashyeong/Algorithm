

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] coin;
    static int n,k;
    static int[] dp = new int[101];
    static long[] a = new long[90];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        dp[3] = 2;
        dp[4] = 3;

        for(int i=5;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        System.out.println(dp[n] +" "+(n-2));
    }


}