import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int a1 = 0, a2 = 0, a3 = 0;
        long result = Long.MAX_VALUE;
        
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                int left = j + 1;
                int right = n - 1;
                
                while (left <= right) {
                    int mid = (left + right) / 2;
                    long sum = (long) arr[i] + arr[j] + arr[mid];

                    if (Math.abs(sum) < result) {
                        result = Math.abs(sum);
                        a1 = i;
                        a2 = j;
                        a3 = mid;
                    }
                    if (sum < 0) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
            }
        }

        int[] resultArr = {arr[a1], arr[a2], arr[a3]};
        Arrays.sort(resultArr);
        System.out.println(resultArr[0] + " " + resultArr[1] + " " + resultArr[2]);
    }
}