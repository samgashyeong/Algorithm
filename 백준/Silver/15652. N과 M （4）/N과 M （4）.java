import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Boolean> chk = new ArrayList<>();
    static ArrayList<Integer> result = new ArrayList<>();
    static ArrayList<ArrayList<Integer>> setArr = new ArrayList();

    static StringBuilder sb = new StringBuilder();
    public static void f(int n, int m, int d, int a){
        if(m == d){
            for(int b : result){
                sb.append(b).append(" ");
            }
            sb.append("\n");
           return;
        }
        
        for(int i = a;i<=n;i++){
            result.add(i);
            f(n, m, d+1, i);
            result.remove(result.size()-1);
        }
    }

    public static void main(String[] args) throws Exception{
        //BufferedReader로 입력 더 빠르게 하기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        f(n, m, 0, 1);
        System.out.println(sb);
    }

}
