import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int w;
    static int h;
    static int[][] map = new int[51][51];
    static boolean[][] chk = new boolean[51][51];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            int result = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());

            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if(w == 0 && h == 0){
                break;
            }

            for(int i = 0; i< h; i++){
                st = new StringTokenizer(br.readLine());

                for(int j = 0; j< w; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i = 0; i< h; i++){
                for(int j = 0; j< w; j++){
                    if(map[i][j] == 1 && !chk[i][j]){
                        fun(i, j);
                        result++;
                    }
                }
            }
            System.out.println(result);

            for(int i=0;i<h;i++){
                Arrays.fill(chk[i], false);
            }
        }


    }

    static int[] dx = {1, 0, -1, 0, 1, 1, -1, -1};
    static int[] dy = {0, 1, 0, -1, -1, 1, -1, 1};

    static class Pair {
        int first, second;

        public Pair(int x, int y) {
            this.first = x;
            this.second = y;
        }
    }

    static void fun(int y, int x) {
        for(int i=0;i<8;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if((0<=nx && nx < w) && (0 <=  ny && ny < h)){
                if(!chk[ny][nx] && map[ny][nx] == 1){
                    chk[ny][nx] = true;
                    fun(ny, nx);
                }
            }
        }
    }
}