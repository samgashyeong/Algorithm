import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();

    static int n;
    static int m;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        int[][] arrCopy = new int[n][m];

        int min = 257;
        int max = -1;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;

                min = Math.min(min, num);
                max = Math.max(max, num);
            }
        }

        int second = 100000000;
        int result = 0;
        for (int i = max; i >= min; i--) {
            int checkB = b;
            int cnt = 0;

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (i < arr[j][k]) {
                        checkB += arr[j][k] - i;
                        cnt += 2*(arr[j][k]-i);
                    }

                    if (i > arr[j][k]) {
                        checkB -= i - arr[j][k];
                        cnt += 1*(i-arr[j][k]);
                    }
                }
            }

            boolean isB = true;
            if (checkB < 0) {
                isB = false;
            }

            if (isB) {
                if(second>cnt) {
                    second = cnt;
                    result = i;
                }
            }
        }

        

        System.out.println(second + " " + result);

    }
}