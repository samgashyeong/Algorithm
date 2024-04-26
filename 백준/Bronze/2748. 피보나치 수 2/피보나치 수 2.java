import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;


//다 풀고 보니깐 DFS라긴 보다는 백트랙킹에 가까운 느낌이 들었다.
public class Main {

    static long[] memo = new long[101];
    static long f(int n){
        if(n==0 || n == 1){
            return n;
        }

        if(memo[n] == -123){
            memo[n] = f(n-2) + f(n-1);
        }

        return memo[n];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[101];

        for(int i=0;i<101;i++){
            memo[i] = -123;
        }

        memo[0] = 0;
        memo[1] = 1;
        int n = Integer.parseInt(br.readLine());
        System.out.println(f(n));
    }
}