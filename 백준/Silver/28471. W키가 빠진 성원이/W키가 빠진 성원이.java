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

        n = Integer.parseInt(br.readLine());
        mp = new char[n][n];
        chk = new boolean[n][n];
        int sx = 0;
        int sy = 0;
        for(int i=0;i<n;i++){
            char[] in = br.readLine().toCharArray();
            for(int j=0;j<in.length;j++){
                mp[i][j] = in[j];
                if(in[j] == 'F'){
                    sx = j;
                    sy = i;
                }
            }
        }

        fun(sy, sx);
        System.out.println(result);
    }
}
