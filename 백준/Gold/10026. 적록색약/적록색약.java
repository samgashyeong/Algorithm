import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n;

    static char[][] arr = new char[101][101];
    static boolean[][] chk = new boolean[101][101];

    static void run1(Pair startP){

        Queue<Pair> que = new ArrayDeque<>();
        int startX = startP.x;
        int startY = startP.y;

        chk[startY][startX] = true;
        char start = arr[startY][startX];
        que.add(startP);
        while(!que.isEmpty()){
            Pair cur = que.poll();
            int curX = cur.x;
            int curY = cur.y;

            for(int i=0;i<4;i++){
                int nx = curX+dx[i];
                int ny = curY+dy[i];

                //System.out.println(nx + " " + ny  + " " + n);
                if(0<=nx && nx < n && 0<=ny && ny < n){
                    if(!chk[ny][nx]){
                        //System.out.println("xfff");
                        if(arr[ny][nx] == start){
                            chk[ny][nx] = true;
                            que.add(new Pair(nx, ny));
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++){
            String str = br.readLine();
            for(int j=0;j<n;j++){
                arr[i][j] = str.charAt(j);
            }
        }

        int yes = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!chk[i][j]){
                    yes++;
                    run1(new Pair(j, i));
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j] == 'G'){
                    arr[i][j] = 'R';
                }
            }
        }

        for(int i=0;i<n;i++){
            Arrays.fill(chk[i], false);
        }

        int no = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!chk[i][j]){
                    no++;
                    run1(new Pair(j, i));
                }
            }
        }
        System.out.println(yes +  " " + no);

    }
}
