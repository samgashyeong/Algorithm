import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br;
        br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n+1][m+1];

        for(int i=1;i<=n;i++){
            st = new StringTokenizer(br.readLine());

            for(int j=1;j<=m;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[n+1][m+1];

        dp[1][1] = arr[1][1];

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                int dia = 0;
                int back = 0;
                int top = 0;

                if(i-1 > 0 && j-1 > 0){
                    dia = dp[i-1][j-1];
                }
                if(j-1 > 0){
                    back = dp[i][j-1];
                }
                if(i-1>0){
                    top = dp[i-1][j];
                }

                dp[i][j] = Math.max(dia, Math.max(back, top)) + arr[i][j];
            }
        }

//        for(int i=1;i<=n;i++){
//
//            for(int j=1;j<=m;j++){
//                System.out.print(dp[i][j]);
//            }
//            System.out.println();
//        }

        System.out.println(dp[n][m]);
    }
}