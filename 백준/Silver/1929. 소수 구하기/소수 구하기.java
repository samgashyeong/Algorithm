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


        StringTokenizer st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        for(int i=s;i<=e;i++){
            if(arr[i] == 0){
                System.out.println(i);
            }
        }
	}
}