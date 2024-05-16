import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class A{
    int k;
    int n;

    public A(int k, int n){
        this.k = k;
        this.n = n;
    }
}

public class Main {
    static A[] arr;
    static int[] memo;
    static boolean[] chk;


//    static int f(int i) {
//        if (memo[i] != -1) {
//            return memo[i];
//        }
//
//        int ret = 1;
//        for (int j = 1; j < i; j++) {
//            if (arr[i] > arr[j]) {
//                ret = Math.max(ret, 1 + f(j));
//            }
//        }
//
//        memo[i] = ret;  // 결과 저장
//        return ret;
//    }

//    static int f(int start){
//        if (memo[start] != -1) {
//            return memo[start];
//        }
//
//        int ret = arr[start].k;
//
//        for(int i=0;i<)
//    }


//    static int go(int a){
//        if(a==1){
//            re
//        }
//    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

         int n = Integer.parseInt(br.readLine());

         memo = new int[n+2];

         for(int i=0;i<n+2;i++){
             memo[i] = 1234567890;
         }
         memo[1] =  0;


         for(int i=2;i<=n;i++){
             if(i%3 == 0) memo[i] = Math.min(memo[i], memo[i/3]+1);
             if(i%2 == 0) memo[i] = Math.min(memo[i], memo[i/2]+1);
             memo[i] = Math.min(memo[i], memo[i- 1]+1);
         }


        System.out.println(memo[n]);
    }
}
