import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int x;
    static ArrayList<PairN>[] map;
    static boolean[] chk;
    static long[] dist;
    static long[] result;
    static long INF = 200000*800+1;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static class Pair{
        int f;
        long s;



        public Pair(int f, long s){
            this.f = f;
            this.s = s;
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

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        map = new ArrayList[n+1];
        dist = new long[n+1];
        chk = new boolean[n+1];
        result = new long[n+1];

        Arrays.fill(dist, INF);
        for(int i=0;i<=n;i++){
            map[i] = new ArrayList<>();
        }
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            map[from].add(new PairN(to, w));
        }

        result[x] = 0;
        fun(x);
        for(int i=1;i<=n;i++){
            result[i] = dist[i];
        }
        Arrays.fill(chk, false);
        Arrays.fill(dist, INF);
        for(int i=1;i<=n;i++){
            if(i == x){
                continue;
            }
            fun(i);

            result[i] += dist[x];
            Arrays.fill(chk, false);
            Arrays.fill(dist, INF);
        }

        Arrays.sort(result);

        System.out.println(result[n]);
    }

    private static void fun(int start) {

        PriorityQueue<PairN> que = new PriorityQueue<>(new Comparator<PairN>() {
            @Override
            public int compare(PairN o1, PairN o2) {
                return Long.compare(o1.s, o2.s);
            }
        });


        que.add(new PairN(start, 0));
        dist[start] = 0;
        while(!que.isEmpty()){
            PairN cur = que.poll();

            if(chk[cur.f]) continue;
            chk[cur.f] = true;

            for(PairN next : map[cur.f]){
                if(dist[next.f] > dist[cur.f]+next.s){
                    dist[next.f] = dist[cur.f] + next.s;
                    que.add(new PairN(next.f, dist[next.f]));
                }
            }
        }
    }
}
