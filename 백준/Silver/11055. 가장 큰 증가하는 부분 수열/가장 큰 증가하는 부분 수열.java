import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br;
        br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        long[] arr = new long[n+1];
        long[] dp = new long[n+1];
        for(int i=1;i<=n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[1] = arr[1];
        for(int i=2;i<=n;i++){
            dp[i] = arr[i];
            for(int j=i-1;j>=1;j--){
                if(arr[i] > arr[j]){
                    dp[i] = Math.max(arr[i]+dp[j], dp[i]);
                }
            }
        }


        long result = -1;

        for(int i=1;i<=n;i++){
            result = Math.max(result, dp[i]);
        }

        System.out.println(result);
    }
}