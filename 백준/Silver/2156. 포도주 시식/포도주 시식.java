import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


    static long[] dp = new long[10101];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[10101];
        for(int i=0;i<n;i++){
            arr[i+1] = Integer.parseInt(br.readLine());
        }

        dp[0] = 0;
        dp[1] = arr[1];
        dp[2] = arr[1] + arr[2];

        for(int i = 3; i <= n;i++){
            dp[i] = Math.max(Math.max(dp[i-3]+arr[i]+arr[i-1], dp[i-2]+arr[i]), dp[i-1]);
        }

        System.out.println(dp[n]);
    }
}