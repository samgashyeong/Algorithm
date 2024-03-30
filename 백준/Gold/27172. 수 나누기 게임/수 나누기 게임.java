import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] input = new int[n];
        int[] result = new int[1000001];
        boolean[] pri = new boolean[1000001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            input[i] = Integer.parseInt(st.nextToken());
            pri[input[i]] = true;
        }

        for(int i=0;i<n;i++){
            for(int j=input[i]+input[i];j<1000001;j+=input[i]){
                if(pri[j] == true){
                    result[j]--;
                    result[input[i]]++;
                    // for(int a=0;a<n;a++){
                    //     if(input[a] == j){
                    //         jIndex = a;
                    //     }
                    // }
                    // if(input[i] % j == 0){
                    //     result[jIndex]++;
                    //     result[i]--;
                    // }
                    // else if(j % input[i] == 0){
                    //     result[jIndex]--;
                    //     result[i]++;
                    // }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
           sb.append(result[input[i]]).append(" ");
        }
        System.out.println(sb);
    }
}