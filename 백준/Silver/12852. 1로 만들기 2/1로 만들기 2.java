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

        Pair[] dp = new Pair[1000005];
        dp[0] = new Pair(1000004, 1000004);
        dp[1] = new Pair(0, 0);


        for(int i=2;i<=n;i++){
            int thr = 0;
            int two = 0;
            int minusOne = i-1;

            if(i%3==0){
                thr = i/3;
            }
            if(i%2==0){
                two = i/2;
            }

            int min = Math.min(dp[thr].cnt, Math.min(dp[two].cnt, dp[minusOne].cnt));
            if(min == dp[thr].cnt){
                dp[i] = new Pair(min+1, thr);
            }
            else if(min == dp[two].cnt){
                dp[i] = new Pair(min+1, two);
            }
            else{
                dp[i] = new Pair(min+1, minusOne);
            }
        }

        System.out.println(dp[n].cnt);
        int next = n;
        while(true){
            System.out.print(next + " ");

            if(dp[next].next == 0){
                break;
            }
            next = dp[next].next;

        }
    }
}