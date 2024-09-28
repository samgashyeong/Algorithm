import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static int l;
    static int r;
    static int[][] map;
    static boolean[][] chk;
    static int result = 0;

    static ArrayList<Pair> arr = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Integer.parseInt(st.nextToken());
        long p = Integer.parseInt(st.nextToken());

        ArrayList<Long> arr = new ArrayList<>();
        arr.add(a);
        for(int i=0;;i++){
            long num = 0;
            long curNum = arr.get(i);
            int few = 10;
            int asdf = 10000;
            while(curNum % 10 != curNum){
                num += (long) Math.pow(curNum%few,p);
                curNum = curNum/few;
            }
            num += (long) Math.pow(curNum%few,p);

            if(arr.contains(num)){
                System.out.println(arr.indexOf(num));

//                for(int z=0;z<=arr.indexOf(num);z++){
//                    System.out.print(arr.get(z) + " ");
//                }
                return;
            }
            arr.add(num);
        }
    }

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int fun(int x, int y) {
        Queue<Pair> que = new ArrayDeque<>();
        que.add(new Pair(x, y));
        chk[y][x] = true;
        arr.add(new Pair(x, y));

        int sum = map[y][x];

        while (!que.isEmpty()) {
            Pair cur = que.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n && !chk[ny][nx]) {
                    int diff = Math.abs(map[cur.y][cur.x] - map[ny][nx]);
                    if (l <= diff && diff <= r) {
                        que.add(new Pair(nx, ny));
                        chk[ny][nx] = true;
                        arr.add(new Pair(nx, ny));
                        sum += map[ny][nx];  // 인구 합산
                    }
                }
            }
        }
        return sum;
    }
}