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

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        a = new int[n+1][m+1];
        b = new int[n+1][m+1];

        if(n < 3 || m < 3){
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(a[i][j] != b[i][j]){
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }
        for(int i=0;i<n;i++){
            String in = br.readLine();
            for(int j=0;j<in.length();j++){
                a[i][j] = Integer.parseInt(String.valueOf(in.charAt(j)));
            }
        }

        for(int i=0;i<n;i++){
            String in = br.readLine();
            for(int j=0;j<in.length();j++){
                b[i][j] = Integer.parseInt(String.valueOf(in.charAt(j)));
            }
        }

        int result = 0;
        for(int i=0;i<n-2;i++){
            for(int j=0;j<m-2;j++){
                if(a[i][j] != b[i][j]){
                    filp(i, j);
                    result++;
                }
            }
        }



        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(a[i][j] != b[i][j]){
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(result);
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
