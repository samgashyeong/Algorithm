import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[][] chk;
    static int[][] map;
    static int target;
    static int node;
    static int result = -1;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

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

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n+1][m+1];
        chk = new int[n+1][m+1];

        for(int i=0;i<n;i++){
            String in = br.readLine();

            for(int j=0;j<m;j++){
                if(in.charAt(j) == 'L'){
                    map[i][j] = 1;
                }
                else{
                    map[i][j] = 0;
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(map[i][j] == 1){
                    fun(j, i);
                }
                check();
            }
        }

        System.out.println(result);
    }

    private static void check() {
        int z = -1;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                z = Math.max(z, chk[i][j]);
            }
        }

        result = Math.max(z, result);

        for(int i=0;i<n;i++){
            Arrays.fill(chk[i], 0);
        }
    }

    private static void fun(int startX , int startY) {

        Queue<Pair> que = new ArrayDeque<>();

        que.add(new Pair(startY, startX));
        while(!que.isEmpty()) {
            Pair cur = que.poll();

            for(int i=0;i<4;i++){
                int nx = cur.x+dx[i];
                int ny = cur.y+dy[i];

                if((0<=nx && nx < m) && (0<=ny && ny < n) && map[ny][nx] == 1){
                    if(chk[ny][nx] == 0 && !(startX == nx && startY == ny)){
                        chk[ny][nx] = 1 + chk[cur.y][cur.x];

                        que.add(new Pair(ny, nx));
                    }
                }
            }
        }
    }
}
