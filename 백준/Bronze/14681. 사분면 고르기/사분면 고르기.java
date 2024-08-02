

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


        int x = Integer.parseInt(br.readLine());
        int y = Integer.parseInt(br.readLine());

        if(x > 0 && y > 0){
            System.out.println(1);
        }
        else if(x < 0 && y > 0){
            System.out.println(2);
        }
        else if(x < 0 && y < 0){
            System.out.println(3);
        }
        else if(x > 0 && y < 0){
            System.out.println(4);
        }

    }
}