import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {

    static int n;
    static int h;
    static boolean[] chk;
    static int result = 0;
    static ArrayList<Pair>[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();

        for(int i=0;i<n;i++){
            a.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());

        for(int i=0;i<n;i++){
            b.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(a);
        Collections.sort(b, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -(o1-o2);
            }
        });

        int sum = 0;
        for(int i=0;i<n;i++){
            sum += a.get(i)* b.get(i);
        }

        System.out.println(sum);
    }

    static class Pair {
        int first;
        int second;

        public Pair(int x, int y) {
            this.first = x;
            this.second = y;
        }
    }

    static class Three {
        int first;
        int second;
        int third;
        public Three(int x, int y, int z) {
            this.first = x;
            this.second = y;
            this.third = z;
        }
    }

//    static void fun(int start, int w) {
//        result = Math.max(result, w);
//        for (int i = 0; i < map[start].size(); i++) {
//            Pair next = map[start].get(i);
//            if (!chk[next.first]) {
//                chk[next.first] = true;
//                fun(next.first, w + next.second);
//                chk[next.first] = false;
//            }
//        }
//    }
}
