import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;
 
public class Main {
    static boolean[][] arr = new boolean[15][15];

	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<Integer> arrK = new ArrayList<>();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long max = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int num = Integer.parseInt(br.readLine());
            if(max<num){
                max = num;
            }
            arrK.add(num);
        }

        long min = 1;
        long mid = max;
        while(min<=max){
            long cnt = 0;
            mid = (max + min) / 2;
            

            for(int i=0;i<n;i++){
                long num = arrK.get(i);
                cnt += num/mid;
            }
            if(cnt<m){
                max = mid-1;
            }
            else{
                min = mid+1;
            }
        }

        System.out.println(max);
	}
}