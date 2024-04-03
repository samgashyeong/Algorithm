import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    // static int[][] before = new int[15][15];
    // static int[][] chs = new int[15][15];
    // static int n;
    // static int cnt = 0;

    // static void copyArr(int[][] target, int[][] targetBy){
    // for(int i=0;i<n;i++){
    // for(int j=0;j<n;j++){
    // target[i][j] = targetBy[i][j];
    // }
    // }
    // }
    // static boolean putQ(int x, int y){
    // //가로
    // for(int i=0;i<n;i++){
    // if(before[y][i] == 1){
    // copyArr(chs, before);
    // return false;
    // }
    // chs[y][i] = 1;
    // }

    // //세로
    // for(int i=0;i<n;i++){
    // if(before[i][x] == 1){
    // copyArr(chs, before);
    // return false;
    // }
    // chs[i][x] = 1;
    // }

    // //대각선
    // int posX = x+1;
    // int posY = y-1;
    // while(true){
    // if(posX>n-1){
    // break;
    // }
    // if(posY<0){
    // break;
    // }

    // if(before[posY][posX] == 1){
    // copyArr(chs, before);
    // return false;
    // }
    // chs[posY][posX] = 1;
    // posX++;
    // posY--;
    // }

    // posX = x-1;
    // posY = y+1;
    // while(true){
    // if(posX<0){
    // break;
    // }
    // if(posY>n-1){
    // break;
    // }

    // if(before[posY][posX] == 1){
    // copyArr(chs, before);
    // return false;
    // }
    // chs[posY][posX] = 1;
    // posX--;
    // posY++;
    // }

    // posX = x-1;
    // posY = y-1;
    // while(true){
    // if(posX<0){
    // break;
    // }
    // if(posY<0){
    // break;
    // }
    // if(before[posY][posX] == 1){
    // copyArr(chs, before);
    // return false;
    // }
    // chs[posY][posX] = 1;
    // posX--;
    // posY--;
    // }

    // posX = x+1;
    // posY = y+1;
    // while(true){
    // if(posX>n-1){
    // break;
    // }
    // if(posY>n-1){
    // break;
    // }

    // if(before[posY][posX] == 1){
    // copyArr(chs, before);
    // return false;
    // }
    // chs[posY][posX] = 1;
    // posX++;
    // posY++;
    // }

    // copyArr(before, chs);
    // return true;
    // }

    // static void f(int x, int y, int d){
    // if(d==n){
    // cnt++;
    // return;
    // }

    // System.out.println(x + " " + y + " " + d);
    // for(int i=y;i<n;i++){
    // for(int j=x;j<n;j++){
    // System.out.println("계산");
    // if(putQ(j,i)){
    // for(int a=0;a<n;a++){
    // for(int b=0;b<n;b++){
    // System.out.print(chs[a][b] + " ");
    // }
    // System.out.println();
    // }

    // f(x, y, d+1);
    // }

    // if(i==n-1 && j==n-1){
    // f(x+1, y, d-1);
    // }

    // }
    // }
    // }ic

    static int n;
    static int cnt = 0;

    static int[] chs = new int[15];

    static void f(int d) {

        if (d == n) {
            cnt++;
            // for (int i = 0; i < n; i++) {
            //     System.out.print(chs[i] + " ");
            // }
            // System.out.println();
            return;
        }

        for (int i = 0; i < n; i++) {
            chs[d] = i;
            
            boolean nextStep = true;
            Loop:
            for (int j = 0; j < d; j++) {
                if (chs[d] == chs[j]){
                    nextStep = false;
                    break Loop;
                }

                if (Math.abs(d - j) == Math.abs(chs[d] - chs[j])) {
                    nextStep = false;
                    break Loop;
                }
                
            }
            if(nextStep){
                f(d + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        // for(int i=0;i<n;i++){
        // for(int j=0;j<n;j++){
        // System.out.print(chs[i][j] + " ");
        // }
        // System.out.println();
        // }
        f(0);

        System.out.println(cnt);
    }
}