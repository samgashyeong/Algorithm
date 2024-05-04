import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;


//루트 없는 트리 == 그래프
public class Main {
    static ArrayList<Integer>[] list = new ArrayList[101010];
    static int[] parents = new int[101010];
    static int n;

    public static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : list[cur]) {
                if (parents[cur] == next) continue;
                q.add(next);
                parents[next] = cur;
            }
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

    
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int m1 = Integer.parseInt(st.nextToken());
            list[n1].add(m1);
            list[m1].add(n1);
        }

        bfs();

        for (int i = 2; i <= n; i++) {
            System.out.println(parents[i]);
        }
    }
}