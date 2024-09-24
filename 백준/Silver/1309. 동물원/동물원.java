import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br;
        br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long[] dp = new long[n+10];

        dp[1] = 3;
        dp[2] = 7;
        for(int i=3;i<=n;i++){
            dp[i] = (2*dp[i-1]+dp[i-2])%9901;
        }

        System.out.println(dp[n]);
    }
}