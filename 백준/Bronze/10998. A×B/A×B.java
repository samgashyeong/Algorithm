

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        System.out.println(a*b);
    }
}