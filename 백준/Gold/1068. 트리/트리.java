import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static boolean[] chk;
    static ArrayList<Integer>[] map;
    static int target;
    static int node;
    static int result = 0;

    public static class Pair{
        int x;
        int y;

        public Pair(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new ArrayList[n+1];
        chk = new boolean[n+1];
        for(int i=0;i<n;i++){
            map[i] = new ArrayList<>();
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            int num = Integer.parseInt(st.nextToken());

            if(num == -1){
                node = i;
                continue;
            }

            map[num].add(i);
        }
        target = Integer.parseInt(br.readLine());

        if(target == node){
            System.out.println(0);
            return;
        }
        else{
            fun(node);
        }
        System.out.println(result);
    }

    private static void fun(int t) {


        int nodeCnt = 0;
        for(int i=0;i<map[t].size();i++) {
            int cn = map[t].get(i);
            if (cn != target && !chk[cn]) {
                nodeCnt ++;
                chk[cn] = true;
                fun(cn);
            }
        }

        if(nodeCnt == 0){
            result++;
        }
    }
}
