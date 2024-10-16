import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static ArrayList<Long> map = new ArrayList<>();
    static int INF = 100000*1000;
    static boolean result = false;
    static boolean[] chk;
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

        for(int i=0;i<=9;i++){
            fun(0, i);
        }
        Collections.sort(map);

        //System.out.println(map.size());
        if(n > 1022){
            System.out.println(-1);
        }
        else{

            System.out.println(map.get(n));
        }
    }

    private static void fun(int d, long result) {

        if(d >= 10){
            return;
        }

        map.add(result);

        for(int i=0;i<=9;i++){
            int num = (int) (result / Math.pow(10, d));

            if(num < i){
                result = (long) (i*Math.pow(10, d+1) + result);
                fun(d+1, result);
                result = (long) (result % Math.pow(10, d+1));
            }
        }
    }
}
