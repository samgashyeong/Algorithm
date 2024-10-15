import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int k;
    static int x;
    static ArrayList<Pair>[] map;
    static boolean[] chk;
    static long[] dist;
    static int target;
    static int node;
    static int result = -1;
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
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        dist = new long[n+1];
        map = new ArrayList[n+1];
        chk = new boolean[n+1];

        for(int i=1;i<=n;i++){
            map[i] = new ArrayList<>();
        }
        Arrays.fill(dist, Long.MAX_VALUE);

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            map[from].add(new Pair(to, 1));
        }

        fun(x);

        ArrayList<Long> arr = new ArrayList<>();
        for(int i=1;i<=n;i++){
            if(k == dist[i]){
                arr.add((long) i);
            }
        }

        if(arr.size() == 0){
            System.out.println(-1);
        }
        else{
            Collections.sort(arr);
            for(int i=0;i<arr.size();i++){
                System.out.println(arr.get(i));
            }
        }
    }

    private static void fun(int start) {

        PriorityQueue<Pair> que = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return Long.compare(o1.s, o2.s);
            }
        });


        que.add(new Pair(start, 0));
        dist[start] = 0;
        while(!que.isEmpty()){
            Pair cur = que.poll();

            for(Pair next : map[cur.f]){
                if(dist[next.f] > dist[cur.f]+next.s){
                    dist[next.f] = dist[cur.f] + next.s;
                    que.add(new Pair(next.f, dist[next.f]));
                }
            }
        }
    }
}
