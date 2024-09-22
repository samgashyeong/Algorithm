import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br;
        br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long[][] dp = new long[n+1][10];

        for(int i=0;i<=9;i++){
            dp[1][i] = 1;
        }

        for(int i=2;i<=n;i++){
            for(int j=0;j<=9;j++){
                long sum = 0;
                for(int z=j;z<=9;z++){
                    sum += dp[i-1][z];
                }

                dp[i][j] = sum%10007;
            }
        }

        long result = 0;
        for(int i=0;i<=9;i++){
            result+=dp[n][i];
        }

        System.out.println(result%10007);
    }
}