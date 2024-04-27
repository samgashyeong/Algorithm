import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[55];

        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }



    
        int das = arr[0];
        while(true){
            int maxIdx = 0;
            for(int j=1;j<n;j++){
                if(arr[j] >= arr[maxIdx]){
                    maxIdx = j;
                }
            }

            if(maxIdx != 0){
                arr[0]++;
                arr[maxIdx] -= 1;
                //System.out.println(arr[0] +  " " + arr[maxIdx]);
            }
            else{
                break;
            }
        }


        System.out.println(arr[0]-das);
    }
}