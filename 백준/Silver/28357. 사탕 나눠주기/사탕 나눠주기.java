import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long k = Long.parseLong(st.nextToken());

        ArrayList<Long> arr = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr.add(Long.parseLong(st.nextToken()));
        }

        long max = Long.parseLong("1000000000009");
        long min = 0;


        long mid = 0;
        long v = 0;
        while(max>=min){

            mid = (max+min)/2;

            long result = k;

            for(int i=0;i<n;i++){
                if(arr.get(i) >= mid){
                    result -= (arr.get(i)-mid);
                }
            }

            //System.out.println(result);
            if(result >= 0){
                v = mid;
                max = mid-1;
            }
            else{
                min = mid+1;
            }
            //System.out.println(mid + " /" + min  + " " + max);
        }

        System.out.println(v);
    }
}
