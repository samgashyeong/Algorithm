import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int[] memo;

    static int f(int i) {
        if (memo[i] != -1) {
            return memo[i]; 
        }

        int ret = 1;
        for (int j = 1; j < i; j++) { 
            if (arr[i] > arr[j]) {
                ret = Math.max(ret, 1 + f(j)); 
            }
        }

        memo[i] = ret;  // 결과 저장
        return ret;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        memo = new int[n + 1];

        
        for (int i = 0; i <= n; i++) {
            memo[i] = -1;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int maxLen = 0;
        for (int i = 1; i <= n; i++) {
            maxLen = Math.max(maxLen, f(i));
        }

        System.out.println(maxLen);
    }
}
