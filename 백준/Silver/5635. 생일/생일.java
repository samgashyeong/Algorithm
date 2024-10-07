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

        ArrayList<Three> arr = new ArrayList<>();

        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int day = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken());

            arr.add(new Three(name, day, month, year));
        }

        arr.sort(new Comparator<Three>() {
            @Override
            public int compare(Three o1, Three o2) {
                if(o1.fth == o2.fth){

                    if(o1.third == o2.third){
                        return o1.second - o2.third;
                    }
                    else{
                        return o1.third - o2.third;
                    }
                }
                return o1.fth - o2.fth;
            }
        });

        System.out.println(arr.get(n-1).first);
        System.out.println(arr.get(0).first);
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
        String first;
        int second;
        int third;
        int fth;
        public Three(String x, int y, int z, int a) {
            this.first = x;
            this.second = y;
            this.third = z;
            this.fth = a;
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
