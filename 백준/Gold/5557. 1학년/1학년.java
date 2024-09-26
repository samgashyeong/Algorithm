

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

        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n+2];
        long[][] dp = new long[n+2][25];

        int answer;
        for(int i=1;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        answer = Integer.parseInt(st.nextToken());

        dp[1][arr[1]] = 1;

        for(int i=2;i<n;i++){
            for(int j=0;j<=20;j++){
                if(dp[i-1][j] > 0){
                    if(j-arr[i] >= 0){
                        dp[i][j-arr[i]] += dp[i-1][j];
                    }
                    if(j+arr[i] <= 20){
                        dp[i][j+arr[i]] += dp[i-1][j];
                    }
                }
            }
        }


        System.out.println(dp[n-1][answer]);
    }
}