import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Pair{
        int first;
        int second;

        public Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }

    static int[][] arr = new int[30][30];
    static int[] dpx = {1, -1, 0, 0};
    static int[] dpy = {0, 0, 1, -1};

    static int n;
    static boolean[][] chk = new boolean[30][30];
    static int run(int startX, int startY){

        Queue<Pair> queue = new LinkedList<>();


        chk[startY][startX] = true;

        queue.add(new Pair(startX, startY));

        int result = 1;
        while(!queue.isEmpty()){
            Pair now = queue.poll();
            int nowX = now.first;
            int nowY = now.second;

            chk[startY][startX] = true;

            for(int i=0;i<4;i++){
                if(((nowX+dpx[i] >= 0) && (nowX+dpx[i] < n)) && ((nowY+dpy[i] >=0) && (nowY+dpy[i]<n))){

                    if(!chk[nowY + dpy[i]][nowX + dpx[i]] && arr[nowY+dpy[i]][nowX+dpx[i]] == 1){
                        chk[nowY + dpy[i]][nowX + dpx[i]] = true;
                        result++;
                        queue.add(new Pair(nowX+dpx[i], nowY+dpy[i]));
                    }
                }
            }
        }
        return result;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0;i<n;i++){
            String input = br.readLine();

            for(int j=0;j<n;j++){
                arr[i][j] = Integer.parseInt(String.valueOf(input.charAt(j)));
            }
        }

        for(int i=0;i<n;i++){

            for(int j=0;j<n;j++){

                if(!chk[i][j] && arr[i][j] == 1){
                    int a = run(j, i);

                    result.add(a);
                }

            }
        }

        System.out.println(result.size());

        Collections.sort(result);
        for(int i=0;i<result.size();i++){
            System.out.println(result.get(i));

        }

    }
}