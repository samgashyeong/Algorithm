import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();

    static class Pair{
        int x;
        int y;

        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n;

    static int[] arr = new int[40321];
    static boolean[] chk = new boolean[40321];
    static void run(int d){
        if(d==n+1){
            for(int i=1;i<=n;i++){
                System.out.print(arr[i]+ " ");
            }
            System.out.println();
            return;
        }


        for(int i=1;i<=n;i++){
            if(!chk[i]){
                arr[d] = i;
                chk[i] = true;
                run(d+1);
                chk[i] = false;;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       n = Integer.parseInt(br.readLine());

       run(1);
    }
}
