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

    static String[][] arr = new String[11][11];
    public static void main(String[] args) throws IOException {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int S1 = Integer.parseInt(st.nextToken());
        int S2 = Integer.parseInt(st.nextToken());
        int S3 = Integer.parseInt(st.nextToken());

        int[] arr = new int[150];

        Arrays.fill(arr, 0);
        for(int i=1;i<=S1;i++){
            for(int j=1;j<=S2;j++){
                for(int k=1;k<=S3;k++){
                    arr[i+j+k]++;
                }
            }
        }

        int max = -1;
        int maxIndex = 0;
        for(int i=0;i<150;i++){
            if(arr[i] > max){
                maxIndex = i;
                max = arr[i];
            }
        }

        System.out.println(maxIndex);
    }
}