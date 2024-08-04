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
        StringBuilder sb = new StringBuilder();

        int a = Integer.parseInt(br.readLine());

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[111];
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());

            arr[i] = num*count;
        }

        if(Arrays.stream(arr).sum() != a){
            System.out.println("No");
        }
        else{
            System.out.println("Yes");
        }
    }
}