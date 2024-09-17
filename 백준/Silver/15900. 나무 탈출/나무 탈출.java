import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();

    static class Pair {
        int a;
        int index;
        public Pair(int x, int y) {
            this.a = x;
            this.index = y;
        }
    }

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n;

    static ArrayList<Integer>[] arr = new ArrayList[500001];
    static boolean[] chk = new boolean[500001];

    static int sum = 0;

    public static void dfs(int start, int d){
        chk[start] = true;

        //System.out.println(arr[d]);
        for(int next : arr[start]){
            if(!chk[next]){
                dfs(next , d+1);
            }
        }

        if(start != 1 && arr[start].size() == 1){
            sum += d;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());


        for(int i=1;i<=500000;i++){
            arr[i] = new ArrayList<Integer>();
        }

        for(int i=0;i<n-1;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a].add(b);
            arr[b].add(a);
        }
        dfs(1, 0);
        if(sum % 2 == 0){
            System.out.println("No");
        }
        else System.out.println("Yes");

    }
}
