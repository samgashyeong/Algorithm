import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static int n;
    static long b;
    public static int[][] ans(int[][] a, int[][] B){
        int[][] ans = new int[n][n];
        for(int i=0;i<n;i++){
            int q = 0;
            for(int j=0;j<n;j++){

                for(int k = 0;k<n;k++){
                    q += a[i][k]*B[k][j];
                    //System.out.println(a[i][k] + " " + B[k][j] + " " + q);
                }
                ans[i][j] = q% 1000;
                q = 0;
            }
        }
        return ans;
    }

    public static int[][] you(int[][] a, long b){

        if(b == 1){
            return a;
        }

        int[][] sub = you(a, b/2);

        if(b%2 == 1){
            return ans(ans(sub, sub), a);
        }
        else{
            return ans(sub, sub);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        b = Long.parseLong(st.nextToken());

        int[][] a = new int[n][n];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                a[i][j] = Integer.parseInt(st.nextToken()) % 1000;
            }
        }

        int[][] ans= you(a, b);

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}