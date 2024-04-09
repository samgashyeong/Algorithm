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
 
        StringTokenizer st;
 
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            int in = Integer.parseInt(st.nextToken());
            arr[i] = in;
        }

        int nowIdx = 0;

        int cnt = 0;
        for(int i=0;nowIdx < n;i++){
            int one = 0;
            int two = 0;

            int cntLoop = Math.min(k, n-nowIdx);
            //System.out.println(cntLoop);
            for(int j=0;j<cntLoop;j++){
                if(arr[nowIdx+j] == 1){
                    one++;
                }
                else{
                    two++;
                }

                
                
            }

            if(two == 0){
                nowIdx++;
            }
            else if(one == 0){
                nowIdx++;
            }
            else{
                nowIdx += 2;
            }
            //System.out.println(one + " " + two + " " + nowIdx);
            cnt++;
        }

        System.out.println(cnt);
    }
}
