import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int k;
    static int a;
    static ArrayList<Integer> map = new ArrayList<>();
    static int INF = 100000*1000;
    static int result = 0;
    static boolean[] chk = new boolean[1000001];
    static HashMap<Character, Integer> base;
    public static class Pair{
        int f;
        int s;

        public Pair(int f, int s){
            this.f = f;
            this.s = s;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        fun(a, 0);
        Collections.sort(map);
        System.out.println(result);
    }

    static void fun(int result1, int d){

        Queue<Pair> que = new ArrayDeque<>();

        que.add(new Pair(result1, 0));

        while(!que.isEmpty()){
            Pair cur = que.poll();

            int plus = cur.f + 1;
            int mul = cur.f * 2;

            if(plus == k){
                result = cur.s+1;
                return;
            }
            else if(plus < k && !chk[plus]){
                que.add(new Pair(plus,cur.s+1));
                chk[plus] = true;
            }

            if(mul == k){
                result = cur.s+1;
                return;
            }
            else if(mul < k && !chk[mul]){
                que.add(new Pair(mul,cur.s+1));
            }
        }
    }

}
