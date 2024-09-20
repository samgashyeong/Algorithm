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

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[16];
        Pair[] arr = new Pair[16];

        for(int i=1;i<=n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            arr[i] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        if(arr[1].f <= n){

            dp[1] = arr[1].s;
        }
        else{
            dp[1] = 0;
        }
        for(int i=2;i<=n;i++){

            if(arr[i].f+i-1 <= n){
                int max = -1;
                for(int j=i-1;j>=1;j--){
                    if(arr[j].f+j <= i){
                        //System.out.println(i + " " + j + " " + arr[j].s);
                        max = Math.max(max, dp[j]);
                    }
                }

                if(max != -1){
                    dp[i] = arr[i].s+max;
                }
                else{
                    dp[i] = arr[i].s;
                }
            }
            else{
                dp[i] = dp[i-1];
            }
        }

        int max = 0;
        for(int i=1;i<=n;i++){
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}
