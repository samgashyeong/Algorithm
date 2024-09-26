

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    static int n;
    static ArrayList<String> result = new ArrayList<>();
    static int[][] map = new int[n+1][n+1];
    static int[][] ori = new int[n+1][n+1];
    static boolean[][] chk = new boolean[n+1][n+1];
    static int max;
    static int resultN = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new int[n+1][n+1];
        ori = new int[n+1][n+1];
        chk = new boolean[n+1][n+1];
        for(int i=0;i<n;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                max = Math.max(max, num);
                ori[i][j] = num;
                map[i][j] = num;
            }
        }

        int few = 0;

        for(int i=0;i<n;i++){
            Arrays.fill(chk[i], false);
        }

        for(int m=0;m<=max;m++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(!chk[i][j] && map[i][j] > m){
                        few++;
                        fun(j, i, m);
                    }
                }
            }

            resultN = Math.max(resultN, few);
            for(int i=0;i<n;i++){
                Arrays.fill(chk[i], false);
            }
            few = 0;

        }

        System.out.println(resultN);

    }

    static int[] dx = new int[]{1, 0, -1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    static class Pair{
        int x;
        int y;

        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    private static void fun(int x, int y, int max) {
        chk[y][x] = true;

        Queue<Pair> que = new ArrayDeque<>();
        que.add(new Pair(x, y));

        while(!que.isEmpty()){
            Pair crt = que.poll();

            for(int i=0;i<4;i++){
                int nx = crt.x + dx[i];
                int ny = crt.y + dy[i];

                if((0<= nx && nx < n) && (0<=ny && ny < n)){
                    if(!chk[ny][nx]){
                        if(max < map[ny][nx]){
                            que.add(new Pair(nx, ny));
                            chk[ny][nx] = true;
                        }
                    }
                }
            }
        }
    }
}