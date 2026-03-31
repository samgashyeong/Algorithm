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
        

        ArrayList<Integer> arrNum = new ArrayList<>();
        int sum = 0;
        for(int i =0;i<9;i++){
            int input = Integer.parseInt(br.readLine());
            arrNum.add(input);
            
            sum+=input;
        }


        breakLoop:
        for(int i=0;i<9;i++){
            int num1 = arrNum.get(i);
            for(int j=1;j<9;j++){
                int num2 = arrNum.get(j);

                if(i == j){
                    continue;
                }
                else if(sum-(num1+num2)==100){
                    if(i > j){
                        arrNum.remove(i);
                        arrNum.remove(j);
                    }
                    else{
                        arrNum.remove(j);
                        arrNum.remove(i);
                    }
                    break breakLoop;
                }
            }
        }

        Collections.sort(arrNum);

        for(int i =0;i<7;i++){
            System.out.println(arrNum.get(i));
        }
    }
}
