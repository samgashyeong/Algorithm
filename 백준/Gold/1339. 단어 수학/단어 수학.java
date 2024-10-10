import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {

    static int n;
    static int h;
    static boolean[] chk;
    static int result = 0;
    static ArrayList<Pair>[] map;
    static int size;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long[] map = new long[26];

        int n = Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++){
            String in = br.readLine();

            for(int j=0;j<in.length();j++){
                char ch = in.charAt(j);
                map[ch-'A'] += (int)Math.pow(10, in.length()-j-1);
            }
        }

        Arrays.sort(map);

        int q = 9;
        long sum = 0;
        for(int i=25;i>=0;i--){
            if(map[i] != 0){
                sum += map[i] * q;
                q--;
            }
        }

        System.out.println(sum);
    }

    static class Pair {
        int first;
        int second;

        public Pair(int x, int y) {
            this.first = x;
            this.second = y;
        }
    }

    static class Three {
        int first;
        int second;
        int third;
        public Three(int x, int y, int z) {
            this.first = x;
            this.second = y;
            this.third = z;
        }
    }
}
