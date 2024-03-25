import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 

public class Main {

	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int max = 1000001;
        int[] arr = new int[max];

        arr[0] = 1;
        arr[1] = 1;
        for(int i=2;i*i<max;i++){
            
            for(int j=i*i;j<max;j+=i){

                if(arr[j] == 1){
                    continue;
                }
                else{
                    arr[j] = 1;
                }
            }
        }

        int input;
        while(true){
            input = Integer.parseInt(br.readLine());

            if(input==0) break;

            int s1 = 0;
            int s2 = 0;

            for(int i = 3;i<input+1;i++){
                
                
                if(arr[i] != 1 && arr[input-i] != 1){
                    System.out.println(input + " = " + i + " + " + (input-i));
                    break;
                }
            }

    
        }
	}
}