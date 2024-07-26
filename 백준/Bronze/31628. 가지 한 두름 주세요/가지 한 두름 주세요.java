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

        for(int i=0;i<10;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j=0;j<10;j++){
                arr[i][j] = st.nextToken();
            }
        }



        boolean ok = false;
        for(int i=0;i<10;i++){
            String a = arr[0][i];

            int result = 0;
            for(int j=1;j<10;j++){
                if (a.compareTo(arr[j][i]) == 0) {
                    result++;
                }
            }
            if(result == 9){
                ok = true;
                break;
            }
        }

        boolean ok2 = false;
        for(int i=0;i<10;i++){
            String a = arr[i][0];

            int result = 0;
            for(int j=1;j<10;j++){
                if (a.compareTo(arr[i][j]) == 0) {
                    result++;
                }
            }
            if(result == 9){
                ok2 = true;
                break;
            }
        }

        if(ok2 || ok){
            System.out.println(1);
        }
        else{
            System.out.println(0);
        }

    }
}