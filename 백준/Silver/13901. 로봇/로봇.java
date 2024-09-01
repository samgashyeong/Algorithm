import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] arr = new int[1001][1001];

        //System.out.println(arr[0][0]);

        StringTokenizer st = new StringTokenizer(br.readLine());

        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());


        int k = Integer.parseInt(br.readLine());

        while(k-->0){
            st = new StringTokenizer(br.readLine());

            int sy = Integer.parseInt(st.nextToken());
            int sx = Integer.parseInt(st.nextToken());

            arr[sy][sx] = 1;
        }

        st = new StringTokenizer(br.readLine());
        int startY = Integer.parseInt(st.nextToken());
        int startX = Integer.parseInt(st.nextToken());

        arr[startY][startX] = 1;

        Deque<Integer> dq = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine());

        while(st.hasMoreElements()){
            dq.add(Integer.parseInt(st.nextToken()));
        }

        int currentX = startX;
        int currentY = startY;

        int cnt = 0;
        while(true){
            int direct = dq.getFirst()-1;

            while(true){
                int nx = currentX+dx[direct];
                int ny = currentY+dy[direct];

                if((nx < 0 || nx >= x || ny < 0 || ny >= y) || arr[ny][nx] == 1){
                    dq.removeFirst();
                    dq.addLast(direct+1);
                    cnt++;
                    break;
                }
                else{
                    currentX = nx;
                    currentY = ny;
                    arr[ny][nx] = 1;

//                    for(int i=0;i<y;i++){
//                        for(int j=0;j<x;j++){
//                            System.out.print(arr[i][j] + " ");
//                        }
//                        System.out.println();
//                    }
                    //System.out.println();
                    cnt = 0;
                }

            }
            if(cnt>7){
                System.out.println(currentY + " " + currentX);
                return;
            }
        }
    }
}
