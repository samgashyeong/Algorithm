import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;


public class Main {

     
    public static void f(int n, int m, boolean[] chk, int d, ArrayList<Integer> arr, ArrayList<Set<Integer>> set){

        if(d == m){
            Set<Integer> mySet = new HashSet<>(arr);
            for(Set<Integer> a : set){
                if(mySet.equals(a)){
                    return;
                }
            }
            for(int num : arr){
                System.out.print(num + " ");
            }
            set.add(mySet);
            System.out.println();
            return;
        }

        for(int i=1;i<=n;i++){
            if(chk[i] == false){
                chk[i] = true;
                arr.add(i);
                f(n, m, chk, d+1, arr, set);
                chk[i] = false;
                arr.remove(arr.size()-1);
            }
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<Set<Integer>> set1 = new ArrayList();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[] chk = new boolean[n+1];

        for(int i =0;i<=n;i++){
            chk[i] = false;
        }




        f(n, m, chk, 0, new ArrayList<>(), set1);
    }
}