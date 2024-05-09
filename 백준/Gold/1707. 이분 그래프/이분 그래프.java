import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] adj;
    static int[] color;

    static boolean dfs(int v, int c) {
        color[v] = c;
        for (int u : adj[v]) {
            if (color[u] == 0) {
                if (!dfs(u, -c)) return false;  // 재귀적으로 색칠하고 검사
            } else if (color[u] == color[v]) {
                return false;  // 충돌 발견
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            adj = new ArrayList[v + 1];
            color = new int[v + 1];

            for (int i = 1; i <= v; i++) {
                adj[i] = new ArrayList<>();
            }

            for (int i = 0; i < e; i++) {
                st = new StringTokenizer(br.readLine().trim());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                adj[from].add(to);
                adj[to].add(from);
            }

            boolean isBipartite = true;
            for (int i = 1; i <= v; i++) {
                if (color[i] == 0) {  // 방문하지 않음
                    if (!dfs(i, 1)) {
                        isBipartite = false;
                        break;
                    }
                }
            }

            System.out.println(isBipartite ? "YES" : "NO");
       
        }
    }
}