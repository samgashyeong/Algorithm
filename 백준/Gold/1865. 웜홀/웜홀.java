import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.ArrayList;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int INF = Integer.MAX_VALUE;
    static int N;
    static int M;
    static int W;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            bw.write(result() + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static String result() throws Exception {
        return ckMinusCycle() ? "YES" : "NO";
    }

    public static boolean ckMinusCycle() throws Exception {
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); //지점의 수        
        M = Integer.parseInt(st.nextToken()); // 도로의 개수        
        W = Integer.parseInt(st.nextToken()); // 웜홀의 개수                 
        return bellmanFord();
    }

    public static boolean bellmanFord() throws Exception {
        ArrayList<Edge> edge = new ArrayList<>();
        for (int i = 0; i < M + W; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());
            if (i >= M) {
                edge.add(new Edge(S, E, -T));
            } else {
                edge.add(new Edge(S, E, T));
                edge.add(new Edge(E, S, T));
            }
        }
        int[] times = new int[N + 1];
        for (int start = 1; start <= N; start++) {
            Arrays.fill(times, INF);
            times[start] = 0;
            boolean ck = false;
            for (int i = 1; i <= N; i++) {
                ck = false;
                for (int j = 0; j < edge.size(); j++) {
                    Edge cur = edge.get(j);
                    if (times[cur.from] != INF && times[cur.to] > times[cur.from] + cur.time) {
                        times[cur.to] = times[cur.from] + cur.time;
                        ck = true;
                        if (i == N) {
                            return true;
                        }
                    }
                }
                if (!ck) {
                    break;
                }
            }
        }
        return false;
    }
}

class Edge {
    int from;
    int to;
    int time;

    Edge(int from, int to, int time) {
        this.from = from;
        this.to = to;
        this.time = time;
    }
}