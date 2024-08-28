import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();

    static class Pair{
        int first;
        int second;

        public Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
    static int[][] arr = new int[303][303];
    static int[][] ori = new int[303][303];

    static boolean[][] chk = new boolean[303][303];

    static int n;
    static int m;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static int result = 0;


    static void run(int startX, int startY){

        Queue<Pair> que = new LinkedList<>();

        chk[startY][startX] = true;

        que.add(new Pair(startX, startY));
        while(!que.isEmpty()){
            Pair cur = que.poll();

            for(int i=0;i<4;i++){
                if(0 <= cur.first+dx[i] && cur.first+dx[i] < m && 0 <= cur.second+dy[i] && cur.second+dy[i] < n){
                    if(!chk[cur.second+dy[i]][cur.first+dx[i]] && arr[cur.second+dy[i]][cur.first+dx[i]] != 0){
                        que.add(new Pair(cur.first+dx[i],cur.second+dy[i]));
                        chk[cur.second+dy[i]][cur.first+dx[i]] = true;
                    }
                }
            }
        }
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());


        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;
                ori[i][j] = num;
            }
        }

        int cnt = 0;
        Loop:
        while(result<=1){
            result = 0;
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(arr[i][j] != 0){
                        for(int z=0;z<4;z++){
                            if(0<=j+dx[z] && j+dx[z] < m && 0 <= i+dy[z] && i+dy[z] < n){
                                if(ori[i+dy[z]][j+dx[z]] == 0){
                                    arr[i][j]--;
                                    if(arr[i][j] < 0) arr[i][j] = 0;
                                }
                            }
                        }
                    }
                }
            }


            boolean zero = true;
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(!chk[i][j] && arr[i][j] != 0){
                        run(j, i);
                        zero = false;
                        result++;
                    }
                    ori[i][j] = arr[i][j];
                }
            }

            if(zero) {
                cnt = 0;
                break Loop;
            }

            cnt++;
            for(int i=0;i<n;i++){
                Arrays.fill(chk[i], false);
            }
        }
        System.out.println(cnt);
    }
}
