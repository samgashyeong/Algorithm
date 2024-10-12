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

        System.out.println("YES");

        int arr[] = new int[n];


        ArrayList<Integer> cnt = new ArrayList<>();
        if(n%2 == 0){
            int t = n-1;

            for(int i=0;i<n/2;i++){
                arr[i] = t;
                cnt.add(i+1);
                t--;
                if(t == 0){
                    break;
                }
                cnt.add(n-i);
                arr[n-1-i] = t;
                t--;
            }
            cnt.add(n/2+1);
            arr[n/2] = n;
        }
        else{
            int t = n-1;
            for(int i=0;i<n/2;i++){
                arr[i] = t;
                cnt.add(i+1);
                t--;
                cnt.add(n-i);
                arr[n-1-i] = t;
                t--;
            }
            cnt.add(n/2+1);
            arr[n/2] = n;

            //System.out.println(Arrays.toString(arr));
        }

        for(int i=0;i<n;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        for(int i=0;i<n;i++){
            System.out.print(cnt.get(i) + " ");
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
