import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();

    static class Pair {
        int a;
        int index;
        public Pair(int x, int y) {
            this.a = x;
            this.index = y;
        }
    }

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[250001];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            int num = Integer.parseInt(st.nextToken());
            arr[i] = arr[i]  - num;
        }

        for(int i=1;i<n;i++){
            if(arr[i] > arr[i-1]){
                arr[i] = arr[i-1];
            }
        }

        for(int i=0;i<n;i++){
            arr[i] *= -1;
        }

        //System.out.println(Arrays.toString(arr));;



        int t = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        while(t-->0){
            int w = Integer.parseInt(st.nextToken());

            w *= -1;
            int start = 0;
            int last = n;
            int answer = 0;
            while(start<=last){
                int mid = (start+last)/2;

                if(arr[mid] > w){
                    answer = mid;
                    last = mid-1;
                }
                else{
                    start = mid+1;
                }
            }

            System.out.println(answer);
        }
    }
}
