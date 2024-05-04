import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;


//보자마자 배열을 생각하면서 풀었는데 베이스 케이스를 잘못 설정해서 조금 고생했던 문제
public class Main {

    static ArrayList<Integer>[] list = new ArrayList[101010];
    static boolean[] chk = new boolean[101010];

    static int n;

    static void dfs(int start){

        System.out.print(start + " ");
        chk[start] = true;
        for(int i=0;i<list[start].size();i++){
            if(!chk[list[start].get(i)]){
                dfs(list[start].get(i));
            }
        }
    }

    static void bfs(int start){
        
        Queue<Integer> que = new LinkedList<>();

        que.add(start);
        chk[start] = true;
        while(que.size() >0){
            int current = que.peek();
            System.out.print(que.poll() + " ");
            for(int i=0;i<list[current].size();i++){
                if(!chk[list[current].get(i)]){
                    que.add(list[current].get(i));
                    chk[list[current].get(i)] = true;
                }
            }
            //System.out.println(que);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= n; i++){
            chk[i] = false;  // 변경된 부분: 초기화를 1부터 n까지로 변경
            list[i] = new ArrayList<>();  // 변경된 부분: 초기화를 1부터 n까지로 변경
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
        Arrays.fill(chk, false);  // 변경된 부분: 배열 초기화 방식 변경
        bfs(v);
    }
}