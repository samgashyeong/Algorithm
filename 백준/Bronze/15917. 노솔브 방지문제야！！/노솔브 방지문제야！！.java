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
        StringBuilder sb = new StringBuilder();
        int Q = Integer.parseInt(br.readLine());

        for(int i=0;i<Q;i++){
            int n = Integer.parseInt(br.readLine());

            int test = 1;

            if(test == n){
                sb.append(1).append("\n");
                continue;
            }
            for(int t=1;;t++){
                test *= 2;
                if(test == n){
                    sb.append(1).append("\n");
                    break;
                }
                if(Math.pow(2,t) > n){
                    sb.append(0).append("\n");
                    break;
                }
            }
        }

        System.out.println(sb);

    }
}