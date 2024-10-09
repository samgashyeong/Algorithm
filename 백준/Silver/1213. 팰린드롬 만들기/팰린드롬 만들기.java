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
    static int size;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<Character, Integer> hs = new HashMap<>();

        String st = br.readLine();

        for(int i=0;i<st.length();i++){
            hs.put(st.charAt(i), hs.getOrDefault(st.charAt(i), 0)+1);
        }

        int sum = 0;
        for(int i=65;i<=90;i++){
            //System.out.println((char)i);
            int cnt = hs.getOrDefault((char)i, 0);

            if(cnt % 2 != 0){
                sum++;
            }
        }

        if(sum > 1){
            System.out.println("I'm Sorry Hansoo");
            return;
        }

        char[] result = new char[st.length()+1];

        int n = 0;
        for(int i=65;i<=90;i++){
            int cnt = hs.getOrDefault((char)i, 0);
            if(cnt > 1){
//                result[n] = (char)i;
//                n++;
//                hs.put((char)i, hs.get((char)i)-2);
                while(hs.getOrDefault((char)i, 0) > 1){
                    result[n] = (char) i;
                    n++;
                    hs.put((char)i, hs.get((char)i)-2);
                }
                if(hs.getOrDefault((char)i, 0)  == 1){
                    result[st.length()/2] = (char)i;
                }
            }

            if(cnt == 1){
                result[st.length()/2] = (char)i;
            }
        }

        //System.out.println(Arrays.toString(result));
        if(st.length() % 2 == 0){
            for(int i=0;i<st.length()/2;i++){
                System.out.print(result[i]);
            }
            for(int i=st.length()/2-1;i>=0;i--){
                System.out.print(result[i]);
            }
        }
        else{
            for(int i=0;i<st.length()/2;i++){
                System.out.print(result[i]);
            }
            System.out.print(result[st.length()/2]);
            for(int i=st.length()/2-1;i>=0;i--){
                System.out.print(result[i]);
            }
        }

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
