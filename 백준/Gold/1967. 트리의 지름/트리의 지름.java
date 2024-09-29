import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static int h;
    //static int[][] map = new int[51][51];
    static boolean[] chk = new boolean[10001];
    static int result = 0;
    static ArrayList<Pair>[] map = new ArrayList[10001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        for(int i=0;i<=n;i++){
            map[i] = new ArrayList<>();
        }
        for(int i=0;i<n-1;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            map[f].add(new Pair(t, w));
            map[t].add(new Pair(f, w));
        }

        for(int i=1;i<=n;i++){
            chk[i] = true;
            fun(i, 0);

            Arrays.fill(chk, false);
        }

        System.out.println(result);
    }

    static int[] dx = {1, 0, -1, 0, 1, 1, -1, -1};
    static int[] dy = {0, 1, 0, -1, -1, 1, -1, 1};

    static class Pair {
        int first, second;

        public Pair(int x, int y) {
            this.first = x;
            this.second = y;
        }
    }

    static void fun(int start, int w) {
        result = Math.max(result,w);
        for(int i=0;i<map[start].size();i++){
            Pair next = map[start].get(i);
            if(!chk[next.first]){
                chk[next.first] = true;
                fun(next.first, w+next.second);
                chk[next.first] = false;
            }
        }
    }
}