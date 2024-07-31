

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.math.MathContext;

public class Main {
    static int[] coin;
    static int n,k;
    static int[][] dp = new int[3][1010];
    static long[] a = new long[90];
    static int[][] arr = new int[3][1010];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            arr[0][i] = Integer.parseInt(st.nextToken());
            arr[1][i] = Integer.parseInt(st.nextToken());
            arr[2][i] = Integer.parseInt(st.nextToken());
        }

        int min = Math.min(Math.min(arr[1][0], arr[2][0]), arr[0][0]);
        dp[0][0] = arr[0][0];
        dp[1][0] = arr[1][0];
        dp[2][0] = arr[2][0];

        for(int i=1;i<n;i++){
            dp[0][i] = Math.min(dp[1][i-1], dp[2][i-1]) + arr[0][i];
            dp[1][i] = Math.min(dp[0][i-1], dp[2][i-1]) + arr[1][i];
            dp[2][i] = Math.min(dp[0][i-1], dp[1][i-1]) + arr[2][i];
        }

        System.out.println(Math.min(Math.min(dp[0][n-1], dp[1][n-1]), dp[2][n-1]));
    }
}