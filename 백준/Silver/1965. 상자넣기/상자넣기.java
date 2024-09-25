import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Pair{
        int cnt;
        int next;

        public Pair(int cnt, int next){
            this.cnt = cnt;
            this.next = next;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br;
        br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n+1];
        int[] dp = new int[n+1];

        for(int i=1;i<=n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[1]= 1;

        for(int i = 2; i <= n; i++) {
            dp[i] = 1;  // 최소 길이는 1
            for (int j = 1; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int result = 0;
        for (int i = 1; i <= n; i++) {
            result = Math.max(result, dp[i]);
        }
        System.out.println(result);
    }
}