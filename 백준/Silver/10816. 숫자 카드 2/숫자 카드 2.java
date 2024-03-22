import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
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

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for(int i=0;i<m;i++){
            int num = Integer.parseInt(st.nextToken());
        
            int max = arr.length;
            int min = 0;
        
            int mid = 0;
            int ub = arr.length;
            while(max>min){
                mid = (max+min)/2;
                if(arr[mid] <= num){
                    min = mid + 1;
                } else {
                    max = mid;
                }
            }
            ub = min;
        
            max = arr.length;
            min = 0;
        
            mid = 0;
            int lb = 0;
            while(max>min){
                mid = (max+min)/2;
                if(arr[mid] >= num){
                    max = mid;
                } else {
                    min = mid + 1;
                }
            }
            lb = max;
        
            sb.append(ub - lb).append(" ");
        }
        System.out.println(sb);
    }
}