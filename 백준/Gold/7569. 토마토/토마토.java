

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    static int n;
    static int m;
    static int h;
    static ArrayList<String> result = new ArrayList<>();
    static int[][][] map = new int[n+1][n+1][n+1];
    static int[][] ori = new int[n+1][n+1];
    static int[][][] chk = new int[n+1][n+1][n+1];
    static int max;
    static int resultN = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        map = new int[h+1][n+1][m+1];
        chk = new int[h+1][n+1][m+1];
        for(int i=0;i<h;i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for(int k=0;k<m;k++){
                    int num = Integer.parseInt(st.nextToken());
                    max = Math.max(max, num);
                    map[i][j][k] = num;
                }
            }
        }


        for(int i=0;i<h;i++){
            for(int j=0;j<n;j++){
                Arrays.fill(chk[i][j], 0);
            }
        }


        for(int i=0;i<h;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<m;k++){
                    if(map[i][j][k] == 1){
                        //System.out.println(i + " " + j + " " + k);
                        que.add(new Pair(k, j, i));
                        chk[i][j][k] = 1;
                    }
                }
            }
        }


        fun();
        int max = -1;
        for(int i=0;i<h;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<m;k++){
                    if(map[i][j][k] == 0){
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }
        for(int i=0;i<h;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<m;k++){
                    max = Math.max(max, chk[i][j][k]);
                }
            }
        }

        System.out.println(max-1);

    }

    static int[] dx = new int[]{1, 0, -1, 0, 0, 0};
    static int[] dy = new int[]{0, 1, 0, -1, 0, 0};
    static int[] dh = new int[]{0, 0, 0, 0, 1, -1};

    static class Pair{
        int x;
        int y;
        int h;

        public Pair(int x, int y, int h){
            this.x = x;
            this.y = y;
            this.h = h;
        }
    }

    static Queue<Pair> que = new ArrayDeque<>();
    private static void fun() {
        while(!que.isEmpty()){
            Pair crt = que.poll();

            for(int i=0;i<6;i++){
                int nx = crt.x + dx[i];
                int ny = crt.y + dy[i];
                int nh = crt.h + dh[i];

                if((0<= nx && nx < m) && (0<=ny && ny < n) && (0<=nh && nh < h)){
                    if(chk[nh][ny][nx] == 0){
                        if(map[nh][ny][nx] == 0){
                            que.add(new Pair(nx, ny, nh));
                            chk[nh][ny][nx] = chk[crt.h][crt.y][crt.x]+1;
                            map[nh][ny][nx] = 1;
                        }
                    }
                }
            }

        }
    }
}