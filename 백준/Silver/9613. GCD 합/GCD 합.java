import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());

            ArrayList<Integer> arr = new ArrayList<>();
            while (num-- > 0) {
            
                arr.add(Integer.parseInt(st.nextToken()));
            }

            long sum = 0;

            for (int i = 0; i < arr.size() - 1; i++) {
                for (int j = i + 1; j < arr.size(); j++) {
                    sum += gcd(arr.get(i), arr.get(j));
                }
            }

            sb.append(sum).append("\n");

        }

        System.out.println(sb);
    }
}