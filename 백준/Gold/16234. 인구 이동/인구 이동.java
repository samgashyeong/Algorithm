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

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        chk = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            boolean moved = false;
            for (int i = 0; i < n; i++) {
                Arrays.fill(chk[i], false);
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!chk[i][j]) {
                        arr.clear();
                        // 좌표 순서 수정: fun(j, i)
                        int sum = fun(j, i);
                        if (arr.size() > 1) {
                            moved = true;
                            int avg = Math.floorDiv(sum, arr.size());
                            for (Pair p : arr) {
                                map[p.y][p.x] = avg;
                            }
                        }
                    }
                }
            }

            if (!moved) {
                System.out.println(result);
                return;
            }
            result++;
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
                        sum += map[ny][nx];
                    }
                }
            }
        }
        return sum;
    }
}
