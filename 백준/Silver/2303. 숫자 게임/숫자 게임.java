
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;
import java.math.MathContext;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int max = -1;
        int maxNum = 0;
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] arr = new int[5];
            for(int j=0;j<5;j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }

            for(int x=0;x<3;x++){
                for(int y=1;y<4;y++){
                    for(int z=2;z<5;z++){
                        int num = -2;

                        if(x != y && y != z && z != x){
                            num = (arr[x]+arr[y]+arr[z])%10;
                        }
                        if(max<=num){
                            //System.out.println(max + " " + num);
                            maxNum = i+1;
                            max = num;
                        }
                    }
                }
            }
        }


        System.out.println(maxNum);
    }
}