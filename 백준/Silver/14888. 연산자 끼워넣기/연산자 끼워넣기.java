import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {

    static LinkedList<Integer> list = new LinkedList<>();

    static int add;
    static int minus;
    static int multi;
    static int substt;
    static int n;
    static ArrayList<Integer> arr = new ArrayList<>();
    static ArrayList<Integer> result = new ArrayList<>();

    static void f(int d, int cnt) {

        if (d == n) {
            //System.out.println(cnt);
            result.add(cnt);
            return;
        }

        
        if (add > 0) {
            cnt += arr.get(d);
            add--;
            //System.out.println(cnt+"더하기");
            f(d + 1, cnt);
            add++;
            cnt -= arr.get(d);
        }
        if (minus > 0) {
            cnt -= arr.get(d);
            minus--;
            f(d + 1, cnt);
            minus++;
            cnt += arr.get(d);
        }
        if (multi > 0) {
            cnt *= arr.get(d);
            multi--;
            //System.out.println(cnt+"곱");
            f(d + 1, cnt);
            multi++;
            cnt /= arr.get(d);
        }
        if (substt > 0) {
            cnt /= arr.get(d);
            substt--;
            f(d + 1, cnt);
            substt++;
            cnt *= arr.get(d);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());

        add = Integer.parseInt(st.nextToken());
        minus = Integer.parseInt(st.nextToken());
        multi = Integer.parseInt(st.nextToken());
        substt = Integer.parseInt(st.nextToken());

        f(1, arr.get(0));

        System.out.println(Collections.max(result));
        System.out.println(Collections.min(result));
    }
}