import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br;
        br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[100001];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;



        for(int i=4;i<=n;i++){
            dp[i] = i;
            for(int j=1;j*j<=i;j++){
                dp[i] = Math.min(dp[i-j*j]+1, dp[i]);
            }
        }

        System.out.println(dp[n]);
    }
}