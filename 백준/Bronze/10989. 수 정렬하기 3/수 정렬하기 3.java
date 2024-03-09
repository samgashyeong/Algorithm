import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    //2일 동안 고민하면서 별의 별 짓을 다 해봐도 안되서 결국에는 정답을 봤던 문제. 수학 법칙 중에 분배법칙을 떠올렸으면 진짜 쉽게 풀 수 있을 문제였는데 안 떠올라서 못 풀었던 문제
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        
        int max = 0;
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            int tmp = Integer.parseInt(br.readLine());

            arr[i] = tmp;
            if(tmp > max){
                max = tmp;
            }
        }

        int[] arrCnt = new int[max];

        for(int i =0;i<max;i++){
            arrCnt[i] = 0;
        }

        for(int i =0;i<n;i++){
            arrCnt[arr[i]-1] = arrCnt[arr[i]-1]+1;
        }
        
        for(int i = 0;i<max;i++){

            if(arrCnt[i] != 0){
                for(int j=0;j<arrCnt[i];j++){
                    sb.append(i+1).append("\n");
                    //System.out.println(i+1);
                }
            }
        }

        System.out.println(sb);
    }
}