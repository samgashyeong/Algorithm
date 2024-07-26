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

        int n = Integer.parseInt(br.readLine());

        int result = 0;
        for(int namgu=1;namgu<=n;namgu++){
            for(int young=1;young<=n;young++){
                for(int taek=1;taek<=n;taek++){
                    if(taek+young+namgu == n){
                        if(namgu>=young+2){
                            if(taek%2==0){
                                result++;
                            }
                        }
                    }
                }
            }
        }

        System.out.println(result);


    }
}