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

        String st = br.readLine();

        int sub = 0;
        int sum = 0;
        String num = "";
        boolean minus = false;
        for(int i=0;i<st.length();i++){
            char ch = st.charAt(i);

            if(ch != '+' && ch != '-'){
                num+=ch;
            }
            else{
                sub += Integer.parseInt(num);

//                if(ch == '+'){
//                    sub += Integer.parseInt(num);
//                }
                if(ch == '-'){
                    if(minus){
                        sum -= sub;
                    }
                    else{
                        sum += sub;
                    }
                    minus = true;
                    sub = 0;
                }
                num = "";
            }
        }
        sub += Integer.parseInt(num);
        if(minus){
            sum -= sub;
        }
        else{
            sum += sub;
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
