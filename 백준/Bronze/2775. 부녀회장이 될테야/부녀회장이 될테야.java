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

        int[][] arr = new int[15][15];
        for(int i=1;i<=14;i++){
            arr[0][i] = i;
        }

        for(int i=1;i<=14;i++){
            for(int j=1;j<=14;j++){
                for(int z=1;z<=j;z++){
                    arr[i][j] += arr[i-1][z];
                }
            }
        }

        while(n-->0){
            int k = Integer.parseInt(br.readLine());
            int n1 = Integer.parseInt(br.readLine());

            System.out.println(arr[k][n1]);
        }
    }
}
