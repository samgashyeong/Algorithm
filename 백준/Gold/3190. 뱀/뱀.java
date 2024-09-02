import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();

    static class Pair{
        int x;
        int y;

        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] arr = new int[111][111];

        ArrayList<Integer> arrD = new ArrayList<>();
        ArrayList<Character> arrDS = new ArrayList<Character>();

        Deque<Pair> xy = new ArrayDeque<>();

        int n = Integer.parseInt(br.readLine());

        int k = Integer.parseInt(br.readLine());

        while(k-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[x][y] = 1;
        }

        int l = Integer.parseInt(br.readLine());

        while(l-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);

            arrD.add(x);
            arrDS.add(c);
        }

        int cnt = 1;

        arr[1][1] = 2;
        xy.add(new Pair(1, 1));
        int cntD = 0;
        int currentX = 1;
        int currentY = 1;
        while(true){
            int nx = currentX+dx[cntD];
            int ny = currentY+dy[cntD];

            if(nx<=0 || nx >n || ny <= 0 || ny > n){
                System.out.println(cnt);
                return;
            }
            else if(arr[ny][nx] == 2){
                System.out.println(cnt);
                return;
            }
            else if(arr[ny][nx] == 1){
                arr[ny][nx] = 2;
                xy.add(new Pair(nx, ny));
            }
            else{
                arr[ny][nx] = 2;
                xy.add(new Pair(nx, ny));

                int cY = xy.getFirst().y;
                int cX = xy.getFirst().x;
                arr[cY][cX] = 0;

                xy.removeFirst();
            }

            if(arrD.contains(cnt)){
                int nd = cntD;

                if(arrDS.get(arrD.indexOf(cnt)) == 'L'){
                    nd--;
                }
                else{
                    nd++;
                }

                if(nd == -1){
                    nd = 3;
                }
                else if(nd == 4){
                    nd = 0;
                }

                cntD = nd;
            }

            cnt++;

            currentX = nx;
            currentY = ny;

            /*for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();*/
        }
    }
}
