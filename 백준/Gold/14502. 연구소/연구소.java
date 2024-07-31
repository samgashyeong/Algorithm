

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



    static int max = -1;
    static int n, m;
    static int[][] arr = new int[10][10];
    static int[][] testArr = new int[10][10];
    static boolean[] chk = new boolean[111];

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static void run(Pair dr){
        Queue<Pair> queue = new LinkedList<>();

        queue.add(dr);
        while(!queue.isEmpty()){
            Pair curDr = queue.poll();

            for(int i=0;i<4;i++){
                if(0<=curDr.first+dx[i] && curDr.first+dx[i]< m && 0<=curDr.second+dy[i] && curDr.second+dy[i] < n){
                    if(testArr[curDr.second+dy[i]][curDr.first+dx[i]] == 0){
                        testArr[curDr.second+dy[i]][curDr.first+dx[i]] = 2;
                        queue.add(new Pair(curDr.first+dx[i], curDr.second+dy[i]));
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
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<n;i++){
            testArr[i] = arr[i].clone();
        }




        for(int i=0;i<n*m-2;i++){
            while(arr[i/m][i%m] != 0){
                i++;
            }
            for(int j=i+1;j<n*m-1;j++){
                while(arr[j/m][j%m] != 0){
                    j++;
                }

                Loop:
                for(int k=j+1;k<n*m;k++){

                    while(arr[k/m][k%m] != 0) {
                        if(k+1 >= n*m){
                            break Loop;
                        }
                        k++;
                    }

                    testArr[i/m][i%m] = 1;
                    testArr[j/m][j%m] = 1;
                    testArr[k/m][k%m] = 1;

//                    for(int y=0;y<n;y++){
//                        for(int x=0;x<m;x++){
//                            System.out.print(testArr[y][x] + " ");
//                        }
//                        System.out.println();
//                    }
//                    System.out.println();

                    //System.out.println("before " +""+Arrays.deepToString(testArr));
                    for(int y=0;y<n;y++){
                        for(int x=0;x<m;x++){
                            if(testArr[y][x] == 2){
                                run(new Pair(x, y));
                            }
                        }
                    }

                    int result = 0;
                    for(int y=0;y<n;y++){
                        for(int x=0;x<m;x++){
                            if(testArr[y][x] == 0) result++;
                        }
                    }

//                    if(result >= 1){
//                        for(int y=0;y<n;y++){
//                            for(int x=0;x<m;x++){
//                                System.out.print(testArr[y][x] + " ");
//                            }
//                            System.out.println();
//                        }
//                        System.out.println();
//                    }

                    max = Math.max(max, result);
                    for(int x=0;x<n;x++){
                        testArr[x] = arr[x].clone();
                    }
                }
            }
        }


        System.out.println(max);

    }


}