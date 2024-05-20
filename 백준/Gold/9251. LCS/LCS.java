import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


//탑다운으로 푼 문제
public class Main {
    static String n;
    static String m;

    static int[][] dp = new int[1010][1010];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = br.readLine();
        m = br.readLine();
        n = " " + n;
        m = " " + m;


        for(int i=1;i<=n.length()-1;i++){
            for(int j=1;j<=m.length()-1;j++){
                dp[i][j] = Math.max(dp[i][j], dp[i-1][j]);
                dp[i][j] = Math.max(dp[i][j], dp[i][j-1]);
                if(n.charAt(i) == m.charAt(j)) dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1]+1);
            }
        }


        System.out.println(dp[n.length()-1][m.length()-1]);
    }
}
