import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());


        int limit = v-a;

        
        
        int count = (int)limit/(a-b);

        if(limit%(a-b) == 0){
            System.out.println(count+1);
        }
        else{
            System.out.println((limit/(a-b))+2);
        }
        // if((float)v/a<=2f){
        //     System.out.println(count+1);
        //     System.out.println(count1+1);
        // }
        // else{
        //     System.out.println(count+1);
        // }
    }
}
