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


        int t = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] input = new int[1010];

        for(int i=0;i<t;i++){
            input[i] = Integer.parseInt(st.nextToken());
        }

        int start = input[0];

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(0);
        for(int i=0;i<t-1;i++){
            int s = input[i+1] - input[i];

            if(s<=0){
                arr.add(input[i]-start);
                start = input[i+1];
            }

            if(s>0 && t-1 == i+1){
                arr.add(input[i+1]-start);
            }
        }

        //System.out.println(arr);
        System.out.println(Collections.max(arr));
    }
}