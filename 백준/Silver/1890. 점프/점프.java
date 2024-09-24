import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br;
        br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n+1][n+1];

        for(int i=1;i<=n;i++){
            st = new StringTokenizer(br.readLine());

            for(int j=1;j<=n;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        long[][] dp = new long[n+1][n+1];

        dp[1][1] = 1;

        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){

                for(int z=1;z<=9;z++){
                    int by = i-z;
                    int bx = j-z;

                    if(by > 0 && arr[by][j] == z && dp[by][j] > 0){
                        dp[i][j] += dp[by][j];
                    }
                    if(bx > 0 && arr[i][bx] == z && dp[i][bx] > 0){
                        dp[i][j] += dp[i][bx];
                    }
                }
            }
        }

//        for(int i=1;i<=n;i++){
//
//            for(int j=1;j<=n;j++){
//                System.out.print(dp[i][j] + "    ");
//            }
//            System.out.println();
//        }

        System.out.println(dp[n][n]);
    }
}