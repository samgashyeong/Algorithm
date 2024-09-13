import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();

    static class Pair {
        BigInteger x;
        BigInteger y;

        public Pair(BigInteger x, BigInteger y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        if((s+k+h)>=100){
            System.out.println("OK");
        }
        else{
            int n = Math.min(s, Math.min(k, h));

            if(s == n){
                System.out.println("Soongsil");
            }
            else if(k == n){
                System.out.println("Korea");
            }
            else{
                System.out.println("Hanyang");
            }
        }
    }
}
