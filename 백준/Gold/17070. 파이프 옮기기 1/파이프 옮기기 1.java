import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] map;
    static boolean[][] chk;
    static int targetX;
    static int targetY;
    static int n;
    static int result;
    static int[] hx = {1, 1};
    static int[] hy = {0, 1};
    static int[] vx = {0, 1};
    static int[] vy = {1, 1};
    static int[] dix = {1, 0, 1};
    static int[] diy = {0, 1, 1};
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

        map = new int[n][n];
        chk = new boolean[n][n];
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        chk[0][0] = true;
        chk[0][1] = true;

        fun(1, 0, 0);

        System.out.println(result);
    }

    private static void fun(int x, int y, int c) {
        if(x == n-1 && y == n-1){
            result++;
            return;
        }

        if(c == 0){
            for(int i=0;i<2;i++){
                int nx = x + hx[i];
                int ny = y + hy[i];

                if((0<=nx && nx< n ) && (0<=ny && ny< n ) && (map[ny][nx] == 0)){
                    if(!chk[ny][nx]){
                        if(i == 1 && (map[ny-1][nx] == 0) && (map[ny][nx-1] == 0)){
                            chk[ny][nx] = true;
                            fun(nx, ny, 2);
                            chk[ny][nx] = false;
                        }
                        if(i == 0){
                            chk[ny][nx] = true;
                            fun(nx, ny, 0);
                            chk[ny][nx] = false;
                        }
                    }
                }
            }
        }
        else if(c == 1){
            for(int i=0;i<2;i++){
                int nx = x + vx[i];
                int ny = y + vy[i];

                if((0<=nx && nx< n ) && (0<=ny && ny< n ) && (map[ny][nx] == 0)){
                    if(!chk[ny][nx]){
                        if(i == 1 && (map[ny-1][nx] == 0) && (map[ny][nx-1] == 0)){
                            chk[ny][nx] = true;
                            fun(nx, ny, 2);
                            chk[ny][nx] = false;
                        }
                        if(i == 0){
                            chk[ny][nx] = true;
                            fun(nx, ny, 1);
                            chk[ny][nx] = false;
                        }
                    }
                }
            }
        }
        else if(c == 2){
            for(int i=0;i<3;i++){
                int nx = x + dix[i];
                int ny = y + diy[i];

                if((0<=nx && nx< n ) && (0<=ny && ny< n ) && (map[ny][nx] == 0)){
                    if(!chk[ny][nx]){
                        if(i == 2 && (map[ny-1][nx] == 0) && (map[ny][nx-1] == 0)){
                            chk[ny][nx] = true;
                            fun(nx, ny, 2);
                            chk[ny][nx] = false;
                        }
                        else if(i == 1){
                            chk[ny][nx] = true;
                            fun(nx, ny, 1);
                            chk[ny][nx] = false;
                        }
                        else if(i == 0){
                            chk[ny][nx] = true;
                            fun(nx, ny, 0);
                            chk[ny][nx] = false;
                        }
                    }
                }
            }
        }
    }

}
