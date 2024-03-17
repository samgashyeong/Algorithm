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
    static String[][] arr = new String[5][15];

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0;i<5;i++){
            for(int j=0;j<15;j++){
                arr[i][j] = "";
            }
        }

        int max = -1;
        for(int i=0;i<5;i++){
            String s = br.readLine();

            if(max<s.length()){
                max = s.length();
            }
            for(int j=0;j<s.length();j++){
                arr[i][j] = String.valueOf(s.charAt(j));
            }
        }

        for(int i=0;i<max;i++){
            for(int j=0;j<5;j++){
                sb.append(arr[j][i]);
            }
        }
        
        System.out.println(sb);
    }
}