import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static ArrayList<Pair>[] map;
    static int[] dist;
    static boolean[] chk;
    static ArrayList<Integer> route;
    static int INF = 100000*1000;
    public static class Pair{
        int f;
        int s;
        ArrayList<Integer> route;

        public Pair(int f, int s, ArrayList<Integer> third){
            this.f = f;
            this.s = s;
            this.route = third;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        dist = new int[n+1];
        Arrays.fill(dist, INF);
        map = new ArrayList[n+1];
        chk = new boolean[n+1];
        for(int i=0;i<=n;i++){
            map[i] = new ArrayList<>();
        }
        for(int i=0;i<m;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            map[from].add(new Pair(to, w, new ArrayList<Integer>(Arrays.asList(from))));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        fun(start, end);

        System.out.println(dist[end]);
        System.out.println(route.size());
        for(int a : route){
            System.out.print(a + " ");
        }
    }

    private static void fun(int start, int end) {

        PriorityQueue<Pair> que = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return Integer.compare(o1.s, o2.s);
            }
        });

        dist[start] = 0;

        que.add(new Pair(start, 0, new ArrayList<Integer>(Arrays.asList(start))));

        while(!que.isEmpty()){
            Pair cur = que.poll();

            if(chk[cur.f]) continue;
            chk[cur.f] = true;


            for(Pair next : map[cur.f]){
                if(dist[next.f] > dist[cur.f] + next.s){
                    dist[next.f] = dist[cur.f] + next.s;

                    ArrayList<Integer> arr = new ArrayList<>(cur.route);
                    arr.add(next.f);
                    que.add(new Pair(next.f, dist[next.f], arr));

                    if(next.f == end){
                        route = arr;
                    }
                }
            }
        }
    }
}
