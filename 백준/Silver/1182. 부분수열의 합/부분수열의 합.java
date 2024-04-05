import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();

    static int[] arr = new int[21];
    static int n;
    static int s;
    static int cnt;

    static void f(int d, int[] sum, int inx) {

        if (d > n) {
            return;
        }

        if (d > 0) {
            int sumA = 0;
            // for (int i = 0; i < d; i++) {
            //     System.out.print(sum[i] + " ");
            // }
            // System.out.println();
            for (int i = 0; i < d; i++) {
                sumA += sum[i];
            }

            if (sumA == s) {
                cnt++;
            }
        }

        for (int i = inx; i < n; i++) {
            sum[d] = arr[i];
            f(d + 1, sum, i + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, 0, n);
        // for (int i = 0; i < n; i++) {
        // System.out.print(arr[i]);
        // }
        // System.out.println();
        f(0, new int[n], 0);

        System.out.println(cnt);
    }
}