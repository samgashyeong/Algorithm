import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Pair {
        int first;
        float second;

        public Pair(int first, float second) {
            this.first = first;
            this.second = second;
        }
    }

    static int n, m, k;
    static boolean[] chk;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        chk = new boolean[n + 1];
        Arrays.fill(chk, false);

        ArrayList<Pair> arr = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int p = Integer.parseInt(st.nextToken());
                float s = Float.parseFloat(st.nextToken());
                arr.add(new Pair(p, s));
            }
        }

        Collections.sort(arr, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return Float.compare(o2.second, o1.second);
            }
        });

        float sum = 0;
        int chkN = 0;
        int i = 0;
        while (chkN < k && i < arr.size()) {
            if (!chk[arr.get(i).first]) {
                sum += arr.get(i).second;
                chk[arr.get(i).first] = true;
                chkN++;
            }
            i++;
        }

        System.out.printf("%.1f%n", sum);
    }
}
