import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);


        long max = (long)arr[0]*m;
        long min = 0;
        long result = 1;
        while(max>=min){
            long mid = (max+min)/2;
            long cnt = 0;
            for(int i=0;i<n;i++){
                cnt+=mid/arr[i];
            }
            if(m<=cnt){
                max = mid-1;
                result = mid;
            }
            else{
                min = mid+1;
            }
        }
        System.out.println(result);
    }
}