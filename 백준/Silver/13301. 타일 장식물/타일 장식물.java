

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static long[] a = new long[90];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));




        a[1] = 1;
        a[2] = 1;


        int input = Integer.parseInt(br.readLine());

        if(input==1){
            System.out.println(4);
        }
        else if(input == 2){
            System.out.println(6);
        }
        else{
            for(int i =3;i<=input;i++){
                a[i] = a[i-1] + a[i-2];
            }

            System.out.println(a[input]*4 + a[input-1]*2);
        }

    }


}