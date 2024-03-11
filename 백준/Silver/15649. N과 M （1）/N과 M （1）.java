import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    

    public static void f(int num, int n, int m, ArrayList<Boolean> chk, ArrayList<Integer> result){
        if(num == m){
            for(int a : result){
                System.out.print(a + " ");
            }
            System.out.println();
           return;
        }
        
        for(int i = 1;i<=n;i++){
            if(chk.get(i) == false){
                chk.set(i, true);
                result.add(i);
                f(num+1, n, m, chk, result);
                chk.set(i, false);
                result.remove(result.size()-1);
            }
        }

    }

    public static void main(String[] args) throws Exception{
        //BufferedReader로 입력 더 빠르게 하기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<Boolean> chk = new ArrayList<Boolean>();
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0;i<=n;i++){
            chk.add(false);
        }



        f(0, n, m, chk, result);
    }

}
