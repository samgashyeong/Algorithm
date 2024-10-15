import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int x;
    static int[][] map;
    static int[][] dist;
    static boolean[][] chk;
    static long[] result;
    static int INF = 125*10;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static class Pair{
        int f;
        int s;
        int third;


        public Pair(int f, int s, int third){
            this.f = f;
            this.s = s;
            this.third = third;
        }
    }

    public static class PairN{
        int f;
        long s;
        boolean fN = false;
        boolean sN = false;

        public PairN(int f, long s){
            this.f = f;
            this.s = s;
        }

        public PairN(int f, long s, boolean fN, boolean sN){
            this.f = f;
            this.s = s;
            this.fN = fN;
            this.sN = sN;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = 1;

        while(true){
            n = Integer.parseInt(br.readLine());

            if(n==0){
                break;
            }

            map = new int[n+1][n+1];
            dist = new int[n+1][n+1];
            chk = new boolean[n+1][n+1];
            for(int i=0;i<n;i++){
                StringTokenizer st = new StringTokenizer(br.readLine());

                for(int j=0;j<n;j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i=0;i<n;i++){
                Arrays.fill(dist[i], INF);
                Arrays.fill(chk[i], false);
            }

            fun();

            System.out.println("Problem "+a +": "+ dist[n-1][n-1]);
            a++;
        }
    }

    private static void fun() {

        PriorityQueue<Pair> que = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return Integer.compare(o1.third, o2.third);
            }
        });

        que.add(new Pair(0, 0, map[0][0]));
        dist[0][0] = map[0][0];

        while(!que.isEmpty()){
            Pair cur = que.poll();

            if(chk[cur.s][cur.f]) continue;
            chk[cur.s][cur.f] = true;

            for(int i=0;i<4;i++){
                int nx = cur.f + dx[i];
                int ny = cur.s + dy[i];

                if((0<= nx && nx < n) && (0<= ny && ny < n)){
                    if(dist[ny][nx] > dist[cur.s][cur.f] + map[ny][nx]){
                        dist[ny][nx] = dist[cur.s][cur.f] + map[ny][nx];
                        que.add(new Pair(nx,ny,dist[ny][nx]));
                    }
                }
            }
        }
    }
}
