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
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] result = new int[n+1];
        for(int i=1;i<=n;i++){
            int num = Integer.parseInt(st.nextToken());
            int t = 0;
            int j =1;
            for(j = 1;;j++){
                if(result[j] != 0){
                    continue;
                }
                if(t == num){
                    break;
                }
                t++;
            }
            result[j] = i;
        }

        for(int i=1;i<=n;i++){
            System.out.print(result[i] + " ");
        }
    }

    private static void filp(int y, int x) {
        for(int i=y;i<y+3;i++){
            for(int j=x;j<x+3;j++){
                a[i][j] = 1-a[i][j];
            }
        }
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
