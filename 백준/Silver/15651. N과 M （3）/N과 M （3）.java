import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;


public class Main {

    static StringBuilder sb = new StringBuilder();
    

    public static void f(int n, int m, int d, ArrayList<Integer> result){
        if(d == m){
            
            for(int a : result){
                sb.append(a).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=1;i<=n;i++){
            result.add(i);
            f(n,m,d+1, result);
            result.remove(result.size()-1);
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        f(n,m, 0, new ArrayList<>());

        System.out.println(sb);
    }
}