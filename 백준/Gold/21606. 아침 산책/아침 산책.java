import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static java.lang.String input;
    static int result;
    static ArrayList<Integer>[] arr  = new ArrayList[200001];
    static boolean[] chk = new boolean[200001];
    static void dfs(int d, int cur){
        if(d>1 &&  '1' == input.charAt(cur-1)){
            result++;
            return;
        }

        for(int i=0;i<arr[cur].size();i++){
            if(!chk[arr[cur].get(i)]){
                //System.out.println(arr[cur].get(i));
                chk[arr[cur].get(i)] = true;
                dfs(d+1, arr[cur].get(i));
                chk[arr[cur].get(i)] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int n = Integer.parseInt(br.readLine());

        input = br.readLine();

        for(int i=0;i<n;i++){
            arr[i+1] = new ArrayList<Integer>();
        }

        for(int i=0;i<n-1;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int m1 = Integer.parseInt(st.nextToken());
            arr[n1].add(m1);
            arr[m1].add(n1);
        }

        for(int i=0;i<n;i++){
            if('1' == input.charAt(i)){
                chk[i+1] = true;
                dfs(1, i+1);
                chk[i+1] = false;
//                for(int j=0;j<n;j++){
//                    chk[j+1] = false;
//                }
            }
        }

        System.out.println(result);
    }
}