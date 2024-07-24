import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


    static long[][] dp = new long[101][10];
    static long mod = 1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Arrays.fill(dp[1], 1);
        dp[1][0] = 0;

        for(int i=2;i<=n;i++){
            dp[i][0] = dp[i-1][1];
            for(int j=1;j<9;j++){
                dp[i][j] = (dp[i-1][j-1]+dp[i-1][j+1])%mod;
            }
            dp[i][9] = dp[i-1][8];
        }


        long result = 0;
        for(int i=0;i<=9;i++){
            result += dp[n][i];
        }

        System.out.println(result%mod);
    }
}