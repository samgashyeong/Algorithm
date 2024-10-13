import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static int[][] map;
    static int[][] chk;
    static int targetX;
    static int targetY;
    static int l;
    static int[] dx = {1, 2, -1, -2, 1, 2, -1 ,-2};
    static int[] dy = {-2, -1, -2, -1, 2, 1, 2, 1};
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

        int t = Integer.parseInt(br.readLine());

        while(t-->0){
            l = Integer.parseInt(br.readLine());

            map = new int[l][l];

            chk = new int[l][l];

            StringTokenizer st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            targetX = Integer.parseInt(st.nextToken());
            targetY = Integer.parseInt(st.nextToken());

            if(targetX == startX && targetY == startY){
                System.out.println(0);
                continue;
            }
            fun(new Pair(startY, startX));

            System.out.println(chk[targetY][targetX]);

            for(int i=0;i<l;i++){
                Arrays.fill(chk[i], 0);
            }
        }
    }

    private static void fun(Pair pair) {

        chk[pair.y][pair.x] = 0;

        Queue<Pair> que = new ArrayDeque<>();
        que.add(pair);

        Loop:
        while(!que.isEmpty()){
            Pair cp = que.poll();

            for(int i=0;i<8;i++){
                int nx = cp.x + dx[i];
                int ny = cp.y + dy[i];

                if((0<=nx && nx < l) && (0<=ny && ny < l)){
                    if(chk[ny][nx] == 0){
                        if(ny == targetY && nx == targetX){
                            chk[ny][nx] = chk[cp.y][cp.x] + 1;
                            break Loop;
                        }

                        chk[ny][nx] = chk[cp.y][cp.x] + 1;
                        que.add(new Pair(ny, nx));
                    }
                }
            }
        }
    }
}
