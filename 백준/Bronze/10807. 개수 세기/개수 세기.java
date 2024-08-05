import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static String[][] arr = new String[11][11];
    public static void main(String[] args) throws IOException {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[101];

        int n = Integer.parseInt(br.readLine());


        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int a = Integer.parseInt(br.readLine());


        int sum = 0;
        for(int i=0;i<n;i++){
            if(arr[i] == a){
                sum++;
            }
        }

        System.out.println(sum);
    }
}