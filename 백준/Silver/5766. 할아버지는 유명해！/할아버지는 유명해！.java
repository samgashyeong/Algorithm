import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static char[][] mp;
    static int[] dy = {-1, -1, -1, 0, 0, 1, 1};
    static int[] dx = {-1, 0, 1, -1, 1, 1, -1};
    static boolean[][] chk;
    static int result = 0;


    static void fun(int sy, int sx){
        chk[sy][sx] = true;

        Queue<Pair> que = new ArrayDeque<>();
        que.add(new Pair(sy, sx));

        while(!que.isEmpty()){

            Pair cur = que.poll();
            for(int i=0;i<7;i++){
                int ny = cur.f + dy[i];
                int nx = cur.s + dx[i];

                if((0<= ny && ny < n) && (0<= nx && nx < n)){
                    if(!chk[ny][nx]){
                        if(mp[ny][nx] == '.'){
                            que.add(new Pair(ny, nx));
                            result++;
                            chk[ny][nx] = true;
                        }
                    }
                }
            }
        }
    }

    static class Pair{
        int f;
        int s;

        public Pair(int f, int s){
            this.f = f;
            this.s = s;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            if(n == 0 && m == 0){
                break;
            }
            HashMap<Integer, Integer> hs = new HashMap<>();

            for(int i=0;i<n;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<m;j++){
                    int num = Integer.parseInt(st.nextToken());
                    hs.put(num, hs.getOrDefault(num, 0)+1);
                }
            }

            ArrayList<Pair> p = new ArrayList<>();

            for(Map.Entry<Integer, Integer> a : hs.entrySet()){
                p.add(new Pair(a.getKey(), a.getValue()));
            }

            Collections.sort(p, new Comparator<Pair>() {
                @Override
                public int compare(Pair o1, Pair o2) {
                    return -(o1.s - o2.s);
                }
            });


            ArrayList<Integer> r = new ArrayList<>();
            r.add(p.get(1).f);
            for(int i = 2;i<p.size();i++){
                if(p.get(i-1).s != p.get(i).s){
                    break;
                }
                r.add(p.get(i).f);
            }

            Collections.sort(r);

            for(int a : r){
                System.out.print(a + " ");
            }
            System.out.println();
        }
    }
}
