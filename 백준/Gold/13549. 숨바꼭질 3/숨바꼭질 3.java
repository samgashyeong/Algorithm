

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    static int n;
    static int m;
    static int h;
    static ArrayList<String> result = new ArrayList<>();
    static int[][][] map = new int[n+1][n+1][n+1];
    static int[][] ori = new int[n+1][n+1];
    static int[] chk = new int[100005];
    static int max;
    static long resultN = Long.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        Arrays.fill(chk, 100000);
        fun();
        System.out.println(chk[m]);
    }

    static int[] dx = new int[]{1, 0, -1, 0, 0, 0};
    static int[] dy = new int[]{0, 1, 0, -1, 0, 0};
    static int[] dh = new int[]{0, 0, 0, 0, 1, -1};

    static class Pair{
        int x;
        int y;

        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static Queue<Pair> que = new ArrayDeque<>();
    private static void fun() {

        chk[n] = 0;
        que.add(new Pair(n, 0));
        while(!que.isEmpty()){

            Pair cur = que.poll();

            if(0<=cur.x*2 && cur.x*2 <= 100000 && chk[cur.x*2] > cur.y){
                chk[cur.x*2] = cur.y;
                que.add(new Pair(cur.x*2, cur.y));
            }
            if(0<=cur.x-1 && cur.x-1 <= 100000 && chk[cur.x-1] > cur.y+1){
                chk[cur.x-1] = cur.y+1;
                que.add(new Pair(cur.x-1, cur.y+1));
            }
            if(0<=cur.x+1 && cur.x+1 <= 100000 && chk[cur.x+1] > cur.y+1){
                chk[cur.x+1] = cur.y+1;
                que.add(new Pair(cur.x+1, cur.y+1));
            }
        }
    }
}