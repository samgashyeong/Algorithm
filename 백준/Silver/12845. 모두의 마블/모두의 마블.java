import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n;

    static String[] arr = new String[11];
    static boolean[] chk = new boolean[11];

    static String[] result = new String[11];
    static int min = 10101;

    static int priCnt = 0;

    static void run(int d) {
        if (d == n + 1) {
            String f = "";
            int cnt = 0;
            for (int i = 1; i < n; i++) {
                if ((result[i].charAt(result[i].length()-1) == '1' && result[i+1].charAt(0) == '0') || (result[i].charAt(result[i].length()-1) == '0' && result[i+1].charAt(0) == '1')) {
                    cnt++;
                }
            }


//            System.out.println(Arrays.toString(result));
//            System.out.println();
            min = Math.min(cnt, min);
            return;
        }


        for (int i = 1; i <= n; i++) {

            if (!chk[i]) {
                chk[i] = true;
                result[d] = arr[i];
                run(d + 1);
                chk[i] = false;
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<Integer> arr = new ArrayList<>();
        while(st.hasMoreElements()){
            arr.add(Integer.parseInt(st.nextToken()));
        }


        Collections.sort(arr);
        Collections.reverse(arr);


        int sum =0;
        for(int i=1;i<n;i++){
            sum += (arr.get(i) + arr.get(0));
        }
        System.out.println(sum);
    }
}
