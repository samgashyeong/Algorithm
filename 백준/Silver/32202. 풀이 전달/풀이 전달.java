import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));

        long[] dp = new long[10000001];
        int n = Integer.parseInt(br.readLine());
        dp[1] = 3;
        dp[2] = 8;

        for(int i=3;i<=n;i++){
            dp[i] = (2*dp[i-1] + 2*dp[i-2]) % (1000000000+7);
        }

        System.out.println(dp[n]);
    }
}