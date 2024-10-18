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

        Map<String, Integer> mp = new HashMap<>();


        while(n-->0){
            String in = br.readLine();

            mp.put(in, mp.getOrDefault(in, 0)+1);
        }

        int max = -1;
        ArrayList<String> arr = new ArrayList<>();
        for(Map.Entry<String, Integer> a : mp.entrySet()){
            //System.out.println(a.getValue());
            if(max <= a.getValue()){
                if(max < a.getValue()){
                    arr.clear();
                    max = a.getValue();
                }
                arr.add(a.getKey());
            }
        }

        //ystem.out.println(arr);
        Collections.sort(arr);
        //System.out.println(arr);
        System.out.println(arr.get(0));

    }
}
