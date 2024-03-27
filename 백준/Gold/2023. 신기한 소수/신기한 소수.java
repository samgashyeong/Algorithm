import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static StringBuilder sb = new StringBuilder();

    static void f(int num, int d){

        if(d==n+1){
            sb.append(num/10).append("\n");

            return;
        }

        for(int i=num;i<=num+9;i++){
            if(isPri(i)){
                f(i*10, d+1);
            }
        }
    }


    static boolean isPri(int num){
        if(num<2){
            return false;
        }
        for(int i=2;i<num;i++){
            if(num%i==0){
                
                return false;
            }
        }
        return true;
    }
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        
        n = Integer.parseInt(br.readLine());
        f(0*10, 1);

        System.out.println(sb);
    }
}