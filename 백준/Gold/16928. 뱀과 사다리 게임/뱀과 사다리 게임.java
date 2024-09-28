import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static int m;
    static int[][] chk = new int[11][11];
    static int result = 101;

    static ArrayList<Pair> lad = new ArrayList<>();
    static ArrayList<Pair> snk = new ArrayList<>();
    static ArrayList<Pair> arr = new ArrayList<>();
    static ArrayList<Integer> startSnk = new ArrayList<>();
    static ArrayList<Integer> startLad = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            lad.add(new Pair(start, Integer.parseInt(st.nextToken())));
            startLad.add(start);
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            snk.add(new Pair(start, Integer.parseInt(st.nextToken())));
            startSnk.add(start);
        }

        for(int i=0;i<10;i++){
            Arrays.fill(chk[i], 101);
        }
        fun();


    }

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static class Pair {
        int first, second;

        public Pair(int x, int y) {
            this.first = x;
            this.second = y;
        }
    }

    static void fun() {
        Queue<Integer> que = new ArrayDeque<>();

        que.add(1);
        chk[0][1] = 0;

        while (!que.isEmpty()) {
            int cur = que.poll();
            int curX = cur%10;
            int curY = cur/10;
            for (int i = 1; i <= 6 ;i++) {
                int nx = (cur+i)%10;
                int ny = (cur+i)/10;

                if(cur+i>100){
                    continue;
                }
                if(chk[ny][nx] > chk[curY][curX]+1){

                    int next = cur+i;
                    boolean chke = false;
                    for(Pair ladI : lad){
                        if(ladI.first == next){
                            que.add(ladI.second);
                            chk[ladI.second/10][ladI.second%10] = Math.min(chk[ladI.second/10][ladI.second%10], chk[curY][curX]+1);
                            chke = true;
                        }
                    }

                    for(Pair ladI : snk){
                        if(ladI.first == next){
                            que.add(ladI.second);
                            chk[ladI.second/10][ladI.second%10] = Math.min(chk[ladI.second/10][ladI.second%10], chk[curY][curX]+1);
                            chke = true;
                        }
                    }

                    if(chke == false){
                        que.add(cur+i);
                        chk[ny][nx] = Math.min(chk[ny][nx], chk[curY][curX]+1);
                    }
                }
                if(cur+i == 100){
                    result = Math.min(result,chk[curY][curX] +1 );
                    System.out.println(chk[curY][curX] +1);
                    return;
                }
            }

//            for(int i=1;i<=9;i++){
//                for(int j=0;j<=9;j++){
//                    System.out.print(chk[i][j] + "    ");
//                }
//                System.out.println();
//            }
//
//            System.out.println();
        }
    }
}