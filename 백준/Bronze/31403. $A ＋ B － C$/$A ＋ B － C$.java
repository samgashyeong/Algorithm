import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static int h;
    static boolean[] chk;
    static int result = 0;
    static ArrayList<Pair>[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String a = br.readLine();
        String b = br.readLine();
        String c = br.readLine();

        System.out.println(Integer.parseInt(a)+Integer.parseInt(b)-Integer.parseInt(c));
        System.out.println(Integer.parseInt(a+b)-Integer.parseInt(c));
    }

    static class Pair {
        int first, second;

        public Pair(int x, int y) {
            this.first = x;
            this.second = y;
        }
    }

    static void fun(int start, int w) {
        result = Math.max(result, w);
        for (int i = 0; i < map[start].size(); i++) {
            Pair next = map[start].get(i);
            if (!chk[next.first]) {
                chk[next.first] = true;
                fun(next.first, w + next.second);
                chk[next.first] = false;
            }
        }
    }
}
