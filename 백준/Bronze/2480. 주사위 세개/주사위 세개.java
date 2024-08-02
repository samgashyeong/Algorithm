
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


        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        if(a== b && b == c && c == a){
            System.out.println(10000+a*1000);
        }
        else if((a == b && b != c) || (b == c && c != a) || (a == c && b != a)){
            int result = 0;
            if(a == b){
                result = a;
            }
            else if(b == c){
                result = c;
            }
            else if(a == c){
                result = a;
            }
            System.out.println(1000+result*100);
        }
        else{
            System.out.println(Math.max(Math.max(a, b), c)*100);
        }
    }
}