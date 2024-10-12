import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static int m;
    static int[][] dp = new int[501][501];
    static int result = 0;
    static int map[][] = new int[501][501];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());

            for(int j=0;j<m;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<n;i++){
            Arrays.fill(dp[i], -1);
        }

        System.out.println(fun(0, 0, map[0][0]));
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

    static int fun(int x, int y, int v) {
        if(x == m-1 && y == n-1){
            return 1;
        }
        if(dp[y][x] != -1){
            return dp[y][x];
        }
        dp[y][x] = 0;
        for(int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if((0<=nx && nx < m) && (0<=ny && ny < n)){
                if(map[y][x] > map[ny][nx]){
                    dp[y][x] += fun(nx, ny, map[ny][nx]);
                }
            }
        }

        return dp[y][x];
    }
}