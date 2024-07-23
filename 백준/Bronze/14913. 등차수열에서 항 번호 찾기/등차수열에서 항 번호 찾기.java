import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());


        int a = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());


        int i = 0;

//        while(true){
//            if(a+d*i > k){
//                System.out.println("X");
//                return;
//            }
//            if(a+d*i == k){
//                System.out.println(i+1);
//                return;
//            }
//            i++;
//        }

        if(d > 0){
            while(true){
                if(a+d*i > k){
                    System.out.println("X");
                    return;
                }
                if(a+d*i == k){
                    System.out.println(i+1);
                    return;
                }
                i++;
            }
        }
        else{
            while(true){
                if(a+d*i < k){
                    System.out.println("X");
                    return;
                }
                if(a+d*i == k){
                    System.out.println(i+1);
                    return;
                }
                i++;
            }
        }
    }
}