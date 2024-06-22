import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

        int T = Integer.parseInt(br.readLine());

        for(int h=1;h<=T;h++){
            int[] gan = new int[7];
            int[] sa = new int[7];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int i=0;i<6;i++){
                gan[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());

            for(int i=0;i<7;i++){
                sa[i] = Integer.parseInt(st.nextToken());
            }


            gan[1] = gan[1]*2;
            gan[2] = gan[2]*3;
            gan[3] = gan[3]*3;
            gan[4] = gan[4]*4;
            gan[5] = gan[5]*10;

            sa[1] = sa[1]*2;
            sa[2] = sa[2]*2;
            sa[3] = sa[3]*2;
            sa[4] = sa[4]*3;
            sa[5] = sa[5]*5;
            sa[6] = sa[6]*10;

            int sum1 = Arrays.stream(gan).sum();
            int sum2 = Arrays.stream(sa).sum();

            if(sum1>sum2) System.out.println("Battle " + h +": Good triumphs over Evil");
            else if(sum1<sum2) System.out.println("Battle " + h +": Evil eradicates all trace of Good");
            else System.out.println("Battle " + h +": No victor on this battle field");

        }
    }
}