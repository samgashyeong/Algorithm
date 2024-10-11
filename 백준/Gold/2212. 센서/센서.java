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
    static int[][] a;
    static int[][] b;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] a = new int[n];

        for(int i=0;i<n;i++){
            a[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);
        Integer[] diff = new Integer[n-1];

        for(int i=1;i<n;i++){
            diff[i-1] = a[i]-a[i-1];
        }

        Arrays.sort(diff, Collections.reverseOrder());


        int result = 0;
        for(int i=k-1;i<n-1;i++){
            result += diff[i];
        }

        System.out.println(result);

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
