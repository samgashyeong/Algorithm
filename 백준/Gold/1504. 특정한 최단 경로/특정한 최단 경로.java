import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int e;
    static ArrayList<PairN>[] map;
    static boolean[] chk;
    static long[] dist;
    static int target;
    static int node;
    static int result = -1;
    static int fN;
    static int sN;
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

        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        map = new ArrayList[n+1];
        dist = new long[n+1];
        chk = new boolean[n+1];

        Arrays.fill(dist, INF);
        for(int i=1;i<=n;i++){
            map[i] = new ArrayList<>();
        }
        for(int i=0;i<e;i++){
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            map[from].add(new PairN(to, w));
            map[to].add(new PairN(from, w));
        }

        st = new StringTokenizer(br.readLine());

        fN = Integer.parseInt(st.nextToken());
        sN = Integer.parseInt(st.nextToken());

        long result;
        long first = 0;
        long second = 0;
        fun(1);
        first += dist[fN];
        Arrays.fill(chk, false);Arrays.fill(dist, INF);
        fun(fN);
        first += dist[sN];
        Arrays.fill(chk, false);Arrays.fill(dist, INF);
        fun(sN);
        first += dist[n];
        Arrays.fill(chk, false);Arrays.fill(dist, INF);

        fun(1);
        second += dist[sN];
        Arrays.fill(chk, false);Arrays.fill(dist, INF);
        fun(sN);
        second += dist[fN];
        Arrays.fill(chk, false);Arrays.fill(dist, INF);
        fun(fN);
        second += dist[n];
        Arrays.fill(chk, false);Arrays.fill(dist, INF);

        if(first >= INF && second >= INF){
            System.out.println(-1);
        }
        else{
            System.out.println(Math.min(first, second));
        }
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
