import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] a = new int[n][m];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int m1 = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[][] B = new int[m1][b];

        for(int i=0;i<m1;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<b;j++){
                B[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] ans = new int[n][b];
        for(int i=0;i<n;i++){
            int q = 0;
            for(int j=0;j<b;j++){

                for(int k = 0;k<m1;k++){
                    q += a[i][k]*B[k][j];
                    //System.out.println(a[i][k] + " " + B[k][j] + " " + q);
                }
                ans[i][j] = q;
                q = 0;
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<b;j++){
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}