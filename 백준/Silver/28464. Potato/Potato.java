import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static int n;
    static int answer;
    static int cnt;
    static boolean[] chk = new boolean[301];
    static int[] arr = new int[301];

    public static void dfs(int index, int d) {
        if(d < 0){
            return;
        }

        if (index == n) {
            if(answer == d){
                cnt++;
            }

            return;
        }

        dfs(index+1, d+arr[index]);
        dfs(index+1, d-arr[index]);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();
        int s = 0;
        int p = 0;
        for(int i=0;i<n;i++){
            arr.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(arr);

        //System.out.println(arr);
        for(int i=0;i<n;i++){
            if(i%2 == 0){
                p += arr.get(arr.size()-1);
                arr.remove(arr.size()-1);
            }
            else{
                s += arr.get(0);
                arr.remove(0);

            }
        }

        System.out.println(s + " " + p);
    }
}
