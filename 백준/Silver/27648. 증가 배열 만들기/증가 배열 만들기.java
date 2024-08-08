import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static long sum = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        if(n+m-1<=k){
            System.out.println("YES");

            for(int i=1;i<=n;i++){
                for(int j=1;j<=m;j++){
                    sb.append((i-1)+j + " ");
                }
                sb.append("\n");
            }

            System.out.print(sb);
        }
        else{
            System.out.print("NO");
        }
    }
}
