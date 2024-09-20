import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static int n;
    static int answer;
    static int cnt;
    static boolean[] chk = new boolean[301];
    static int[] arr = new int[301];

    static class Pair{
        int f;
        int s;

        public Pair(int f, int s){
            this.f = f;
            this.s = s;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while(t-->0){
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[][] arr = new int[2][n+1];
            for(int i=0;i<n;i++){
                arr[0][i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for(int i=0;i<n;i++){
                arr[1][i] = Integer.parseInt(st.nextToken());
            }

            int[][] dp = new int[2][n+1];

            dp[1][0] = arr[1][0];
            dp[0][0] = arr[0][0];

            dp[1][1] = arr[0][0]+arr[1][1];
            dp[0][1] = arr[1][0]+arr[0][1];
            for(int i=2;i<n;i++){
                dp[1][i] = Math.max(dp[0][i-1], dp[0][i-2]) + arr[1][i];
                dp[0][i] = Math.max(dp[1][i-1], dp[1][i-2]) + arr[0][i];
            }

            System.out.println(Math.max(dp[1][n-1], dp[0][n-1]));
        }
    }
}
