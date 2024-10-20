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

        int[] arr = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        int sum = 0;
        for(int i=0;i<n;i++){
            int num = Integer.parseInt(st.nextToken());
            sum += num;
            arr[i] = num;
        }

        Arrays.sort(arr);

        int result = 0;
        for(int i=0;i<n;i++){
            sum -= arr[i];
            //System.out.println(sum * arr[i]);
            result += sum * arr[i];
        }

        System.out.println(result);

    }
}
