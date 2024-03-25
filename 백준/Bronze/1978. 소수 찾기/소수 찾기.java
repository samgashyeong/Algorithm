import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());


        int result = 0;
        for(int i=0;i<num;i++){
            int input = Integer.parseInt(st.nextToken());

        
            if(input == 1){
                continue;
            }
            else if(input == 2){
                result++;
            }
            else{
                for(int j=2;j<input;j++){
                    if(input%j == 0){
                        break;
                    }
                    else if(j == input-1){
                        result++;
                    }
                }
            }
        }

        System.out.println(result);
    }
}
