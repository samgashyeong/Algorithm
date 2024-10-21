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

        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<Integer> arr = new ArrayList<>();

        int max = -1;
        while(st.hasMoreElements()){
            int num = Integer.parseInt(st.nextToken());
            max = Math.max(max, num);
            arr.add(num);
        }

        for(int i=1;i<=1000000;i++){
            int sum = 0;

            for(int a : arr){
                if(i % a == 0){
                    sum++;
                }
            }

            if(sum >= 3){
                System.out.println(i);
                return;
            }
        }

    }
}
