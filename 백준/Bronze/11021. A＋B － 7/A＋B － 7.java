
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;
import java.math.MathContext;

public class Main {
    static int[] coin;
    static int n,k;
    static int[][] dp = new int[3][1010];
    static long[] a = new long[90];
    static int[][] arr = new int[3][1010];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());

        for(int i=0;i<a;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            System.out.println("Case "+"#"+(i+1)+": "+(Integer.parseInt(st.nextToken())+Integer.parseInt(st.nextToken())));
        }
    }
}