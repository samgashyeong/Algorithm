import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int k;
    static int a;
    static ArrayList<Integer> map = new ArrayList<>();
    static int INF = 100000*1000;
    static int result = 0;
    static boolean[] chk = new boolean[100001];
    static HashMap<Character, Integer> base;
    public static class Pair{
        int f;
        int s;

        public Pair(int f, int s){
            this.f = f;
            this.s = s;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[] arr = new int[m+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 100001;
        int result = 0;
        while(left <= right){
            int i = (left+right)/2;

            Arrays.fill(chk, false);

            boolean ff = true;

            if(arr[0] - i > 0){
                ff = false;
            }
            for(int j=1;j<m-1;j++){
                if(arr[j] - i > arr[j-1] + i){
                    ff = false;
                }
            }

            if(arr[m-1] + i < n){
                ff = false;
            }

            if(ff){
                result = i;
                right = i-1;
            }
            else{
                left = i+1;
            }
        }

        System.out.println(result);
    }

}
