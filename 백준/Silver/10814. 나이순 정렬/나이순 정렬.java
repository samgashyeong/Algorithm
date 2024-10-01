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

        ArrayList<Pair> arr = new ArrayList<>();
        while(n-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr.add(new Pair(Integer.parseInt(st.nextToken()), st.nextToken()));
        }

        arr.sort(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.first-o2.first;
            }
        });

        for(int i=0;i<arr.size();i++){
            System.out.println(arr.get(i).first+ " " + arr.get(i).second);
        }
    }

    static class Pair {
        int first;
        String second;

        public Pair(int x, String y) {
            this.first = x;
            this.second = y;
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
