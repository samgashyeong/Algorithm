import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        int num = Integer.parseInt(br.readLine());
        int n = num;
        int nCopy = num;
        int m = Integer.parseInt(br.readLine());
        

        boolean[] brk = new boolean[10];
        
        if(m != 0){
            st = new StringTokenizer(br.readLine());
        }
        else{
            st = new StringTokenizer("");
        }

        for(int i=0;i<m;i++){
            brk[Integer.parseInt(st.nextToken())] = true;
        }

        
        int result = Math.abs(num-100);
        if(n != 100){
            for(int i=0;i<999999;i++){
                String str = String.valueOf(i);
                
                boolean isBreak = false;
                for(int j=0;j<str.length();j++){
                    if(brk[str.charAt(j) - '0']) { //고장난 버튼을 눌러야 하면
                        isBreak = true; 
                        break; //더 이상 탐색하지 않고 빠져나온다.
                    }
                    
                }

                if(!isBreak){
                    int iResult = Math.abs(n-i)+str.length();

                    result = Math.min(result, iResult);
                }
            }
        }
        else{
            System.out.println(0);
            return;
        }
        
        
        System.out.println(result);

        
        
    }
}