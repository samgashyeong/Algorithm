import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int[][] arr = new int[64][64];


    static void f(int size, int startX, int startY, int startNum){

        boolean isAllC = true;

        if(size == 1){
            sb.append(startNum);
            return;
        }

        Loop:
        for(int i=startX;i<startX+size;i++){
            for(int j=startY;j<startY+size;j++){
                if(startNum!=arr[i][j]){
                    isAllC = false;
                    break Loop;
                }
            }
        }
        
        if(isAllC){
            sb.append(startNum);
            return;
        }
    
        else{
            sb.append("(");
            f(size/2, startX, startY, arr[startX][startY]);
            f(size/2, startX, startY+size/2, arr[startX][startY+size/2]);
            f(size/2, startX+size/2, startY, arr[startX+size/2][startY]);
            f(size/2, startX+size/2, startY+size/2, arr[startX+size/2][startY+size/2]);
            sb.append(")");
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
            String s = br.readLine();

            for(int j=0;j<n;j++){
                arr[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }

        
        f(n, 0, 0, arr[0][0]);
        

        System.out.println(sb);
    }
}