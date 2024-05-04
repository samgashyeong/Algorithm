import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static ArrayList<Integer>[] list = new ArrayList[101010];
    static boolean[] chk = new boolean[101010];

    static int n;

    static void dfs(int start){
        System.out.print(start + " ");
        chk[start] = true;
        for(int i = 0; i < list[start].size(); i++){
            int next = list[start].get(i);
            if(!chk[next]){
                dfs(next);
            }
        }
    }

    static void bfs(int start){
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        chk[start] = true;
        while(!que.isEmpty()){
            int current = que.poll();
            System.out.print(current + " ");
            for(int i = 0; i < list[current].size(); i++){
                int next = list[current].get(i);
                if(!chk[next]){
                    que.add(next);
                    chk[next] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= n; i++){
            chk[i] = false;
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int m1 = Integer.parseInt(st.nextToken());

            list[n1].add(m1);
            list[m1].add(n1);
        }

        for(int i = 1; i <= n; i++){
            Collections.sort(list[i]);
        }

        dfs(v);
        System.out.println();
        Arrays.fill(chk, false);
        bfs(v);
    }
}
