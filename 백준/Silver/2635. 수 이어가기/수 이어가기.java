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

        int N = Integer.parseInt(br.readLine());

        int max = -1;
        ArrayList<Integer> arr = new ArrayList<>();
        ArrayList<Integer> maxArr = new ArrayList<>();
        for(int i=1;i<=N;i++){
            arr.clear();
            arr.add(N);
            arr.add(i);

            int j = 2;
            while(true){
                int num = arr.get(j-2) - arr.get(j-1);
                if(num<0){
                    if(arr.size() >=  max){
                        maxArr = (ArrayList<Integer>) arr.clone();
                        max = arr.size();
                    }
                    break;
                }
                arr.add(num);
                j++;
            }
        }

        System.out.println(max);
        for(int i=0;i<maxArr.size();i++){
            System.out.print(maxArr.get(i) + " ");
        }
    }
}