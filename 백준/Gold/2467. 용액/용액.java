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
        int[] arr = new int[n];
        ArrayList<Integer> mixArr = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = 2147483647;
        int minLeftI = 0;
        int minRightI = 0;
        for(int i=0;i<n;i++){
            
            int target = arr[i];

            int max = arr.length-1;
            int min = i+1;
            
            while(max>=min){
                int mid = (max+min)/2;
                int sum = arr[mid] + target;
                if(Math.abs(sum)<result){
                    result = Math.abs(sum);
                    minLeftI = i;
                    minRightI = mid; 
                }

                if(sum<0){
                    min = mid+1;
                }
                else{
                    max = mid-1;
                }
            }


            //System.out.println(result + " " + minLeftI + " "  + minRightI);
        }

        System.out.println(arr[minLeftI] + " " + arr[minRightI]);
    }
}