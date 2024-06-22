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

        String A = st.nextToken();
        String B = st.nextToken();

        int aPos = 0;
        int bPos = 0;

        Loop:
        for(int i=0;i<A.length();i++){
            for(int j=0;j<B.length();j++){
                if(A.charAt(i) == B.charAt(j)){
                    aPos = j;
                    bPos = i;
                    break Loop;
                }
            }
        }

        char[][] ans = new char[101][101];

        for(int i=0;i<31;i++){
            Arrays.fill(ans[i], '.');
        }


        for(int i=0;i<A.length();i++){
            ans[aPos][i] = A.charAt(i);
        }

        for(int i=0;i<B.length();i++){
            ans[i][bPos] = B.charAt(i);
        }

        for(int i=0;i<B.length();i++){
            for(int j=0;j<A.length();j++){
                System.out.print(ans[i][j]);
            }
            System.out.println();
        }
    }
}