import java.io.*;
import java.util.*;


public class Main {

    static long[] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int k = Integer.parseInt(br.readLine());

        int result = n;

        boolean[] chk = new boolean[n+10];

        Arrays.fill(chk, true);

        for(int i=2;i<=n;i++){
            for(int j=i+i;j<=n;j+=i){
                if(chk[j]){
                    chk[j] = false;
                }
            }
        }

        // for(int i=0;i<=n;i++){
        //     if(chk[i]){
        //         System.out.println(i);
        //     }
        // }

        int[] resultArr = new int[n+10];
        
        Arrays.fill(resultArr, 1);
        for(int i=2;i<=n;i++){
            if(chk[i] && i>k){
                for(int j=i;j<=n;j+=i){
                    resultArr[j] = 0;
                }
            }
        }

        result = 0;
        for(int i=1;i<=n;i++){
            result+=resultArr[i];
        }
        
        System.out.println(result);
    }

}