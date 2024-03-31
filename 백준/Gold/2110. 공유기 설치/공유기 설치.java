import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] house = new int[n];
        for (int i = 0; i < n; i++) {
            house[i] = Integer.parseInt(br.readLine());

        }

        Arrays.sort(house);
        long max = 1000000001;

        long result = 0;
        long min = 0;

        while (max >= min) {
            long mid = (max + min) / 2;
            long cnt = 1;
            int idx = 0;
            for (int i = idx + 1; i < n; i++) {
                if (house[idx] + mid <= house[i]) {
                    cnt++;
                    idx = i;
                }
            }

            //System.out.println(cnt + " " + mid);
            if(cnt<c){
                max = mid-1;
                result = max;
            }
            else{
                min = mid+1;
            }
        }

        System.out.println(result);

    }
}