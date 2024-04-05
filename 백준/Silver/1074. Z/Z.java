import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();

    static char[] arr = new char[15];
    static int cnt = 0;

    static void f(int size, int r, int c) {
        if(size == 1){
            return;
        }
        
        if(r<size/2 && c<size/2){
            //System.out.println(cnt);
            f(size/2, r, c);
        }
        else if(r<size/2 && c>=size/2){
            cnt += (size*size)/4;
            //System.out.println(cnt);
            f(size/2, r, c-size/2);
        }
        else if(r>=size/2 && c<size/2){
            cnt += 2*((size*size)/4);
            //System.out.println(cnt);
            f(size/2, r-size/2, c);
        }
        else if(r>=size/2 && c>=size/2){
            cnt += 3*((size*size)/4);
            //System.out.println(cnt);
            f(size/2, r-size/2, c-size/2);
        }
    }
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int num = (int)Math.pow(2, n);
        //System.out.println(num);
        f(num, r, c);
        System.out.println(cnt);
    }
}