import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static long a;
    static long b;

    static long result = Long.MAX_VALUE;

    static void dfs(long aTob, int d){
        if(aTob > b){
            return;
        }
        else if(aTob == b){
            result = Math.min(d, result);
        }

        dfs(aTob*2, d+1);
        dfs(aTob*10+1, d+1);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        dfs(a, 1);

        if(result == Long.MAX_VALUE) System.out.println(-1);
        else{
            System.out.println(result);
        }
    }
}