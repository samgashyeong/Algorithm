import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int c;
    static long pw(long a, long b){
        if(b==0) return 1;
        if(b%2 == 1) return a*pw(a, b-1)%c;
        long ret = pw(a,b/2)%c;
        return (ret*ret)%c;
    }

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int a, b;

        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        System.out.println(pw(a, b));
        
        System.out.println(sb);
    }
}