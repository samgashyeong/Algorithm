import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static StringBuffer str = new StringBuffer();
    static int[][] squre;
    static int blue = 0;
    static int white = 0;
    
    static void f(int n, int subSqure[][], int startX, int startY, int startColor){

        boolean isAllC = true;

        Loop1:
        for(int i=startX;i<n+startX;i++){
            for(int j=startY;j<n+startY;j++){
                if(subSqure[i][j] != startColor){
                    isAllC = false;
                    //System.out.println(subSqure[i][j] + " " +startColor);
                    break Loop1;
                }
            }
        }
        if(isAllC) {
            if(startColor == 1){
                blue++;
            }
            else{
                white++;
            }
            return;
        }
        else if(n == 1){
            return;
        }
        else{
            f(n/2, subSqure, startX, startY, subSqure[startX][startY]);
            f(n/2, subSqure, startX+(n/2), startY, subSqure[startX+(n/2)][startY]);
            f(n/2, subSqure, startX+(n/2), startY+(n/2), subSqure[startX+(n/2)][startY+(n/2)]);
            f(n/2, subSqure, startX, startY+(n/2), subSqure[startX][startY+(n/2)]);
        }
        
    }
    public static void main(String[] args) throws Exception{
        //BufferedReader로 입력 더 빠르게 하기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        squre = new int[n][n];


        

        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                squre[i][j] = Integer.parseInt(st.nextToken());
            }
        }



        f(n, squre, 0, 0, squre[0][0]);
        
        StringBuilder sb = new StringBuilder();
        sb.append(white).append("\n").append(blue);
        System.out.println(white);
        System.out.println(blue);

        
    }
}
