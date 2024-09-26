

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static boolean[] chk = new boolean[21];

    static int n;
    static ArrayList<String> result = new ArrayList<>();
    static int[] arr = new int[21];
    static void fun(int n, int d){
        if(n+1 == d){
            java.lang.String resultS = "";

            for(int i=1;i<=n;i++){
                resultS += arr[i] + " ";
            }

            result.add(resultS);
            return;
        }

        for(int i=1;i<=n;i++){
            if(chk[i] == false){
                chk[i] = true;
                arr[d] = i;
                fun(n, d+1);
                chk[i] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


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

        long[][] dp = new long[n+1][m+1];
        dp[1][1] = arr[1][1];

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                long top = 100000005;
                long back = 100000005;
                if(i==1 && j==1){
                    continue;
                }
                if(i-1 > 0){
                    top = dp[i-1][j];
                }
                if(j-1 > 0){
                    back = dp[i][j-1];
                }

                dp[i][j] = Math.min(top, back) + arr[i][j];
            }
        }
        int h = Integer.parseInt(br.readLine());

        if(dp[n][m] > h){
            System.out.println("NO");
        }
        else{
            System.out.println("YES");
            System.out.println(dp[n][m]);
        }
    }
}