import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());


        if(n==1){
            System.out.println(1);
            return;
        }
        for(long i=0;i<=n;i++){
            if((i*(i+1))/2 > n){
                
                System.out.println(i-1);
                return;
            }
        }
    }
}