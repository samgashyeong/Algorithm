import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {

    static int n;
    static int m;
    static boolean[][] chk;
    static int result = 0;
    static char[][] map;
    static int size;
    static int a;
    static int b;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n+1][m+1];
        chk = new boolean[n+1][m+1];
        int sx =0, sy = 0;
        for(int i=0;i<n;i++){
            String in = br.readLine();
            for(int j=0;j<m;j++){
                char ch = in.charAt(j);
                map[i][j] = ch;
                if(ch == 'I'){
                   sx = j;
                   sy = i;
                }
            }
        }

        chk[sy][sx] = true;
        fun(sy, sx);


        if(result == 0){
            System.out.println("TT");
        }
        else{
            System.out.println(result);
        }

    }

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    private static void fun(int sy, int sx) {
        if(map[sy][sx] != 'I' && map[sy][sx] == 'X'){
            return;
        }
        else if(map[sy][sx] == 'P'){
            result++;
        }

        for(int i=0;i<4;i++){
            int nx = sx + dx[i];
            int ny = sy + dy[i];

            if(0 <= nx && nx < m && 0<=ny && ny < n){
                if(!chk[ny][nx]){
                    chk[ny][nx] = true;
                    fun(ny, nx);
                }
            }
        }
    }


    static class Pair {
        int first;
        int second;

        public Pair(int x, int y) {
            this.first = x;
            this.second = y;
        }
    }

    static class Three {
        int first;
        int second;
        int third;
        public Three(int x, int y, int z) {
            this.first = x;
            this.second = y;
            this.third = z;
        }
    }
}
