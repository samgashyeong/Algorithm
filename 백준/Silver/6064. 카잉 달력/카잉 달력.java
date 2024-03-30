import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();

    static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;

            long k = -1;

            // Loop:
            // for(int i=1;i<=M*N/gcd(M, N);i++){
            //     if(i%M == x && i%N == y){
            //         k = i;
            //         break Loop;
            //     }
            // }

            Loop : for (int i = x; i < (N * M); i += M) {
				if (i % N == y) {
                    k = i+1;
					break Loop;
				}
			}

            //System.out.println(k);
            sb.append(k).append("\n");
        }

        System.out.println(sb);
    }
}