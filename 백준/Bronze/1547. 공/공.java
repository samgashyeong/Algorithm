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

        boolean[] arr = new boolean[4];
        arr[1] = true;

        int n = Integer.parseInt(br.readLine());

        while(n-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            boolean tmp = arr[a];
            arr[a] = arr[b];
            arr[b] = tmp;
        }

        for(int i=1;i<=3;i++){
            if(arr[i]) System.out.println(i);
        }
    }
}
