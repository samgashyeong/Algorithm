import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static ArrayList<Integer>[] map;
    static int INF = 100000*1000;
    static boolean result = false;
    static boolean[] chk;
    public static class Pair{
        int f;
        int s;

        public Pair(int f, int s){
            this.f = f;
            this.s = s;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new ArrayList[n+1];
        chk = new boolean[n+1];

        for(int i=0;i<n;i++){
            map[i] = new ArrayList<>();
        }
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            map[from].add(to);
            map[to].add(from);
        }

        for(int i=0;i<n;i++){
            fun(i, 0);
            Arrays.fill(chk, false);
        }

        if(result) System.out.println(1);
        else System.out.println(0);
    }

    private static void fun(int start, int d) {

        if(d == 5){
             result = true;

            return;
        }


        for(int i=0;i<map[start].size();i++){
            int next = map[start].get(i);

            if(!chk[next]){
                chk[next] = true;
                fun(next, d+1);
                chk[next] = false;
                if(result) return;
            }
        }
    }
}
