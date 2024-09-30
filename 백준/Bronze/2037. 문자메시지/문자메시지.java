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

        StringTokenizer st = new StringTokenizer(br.readLine());

        int p = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        HashMap<Character, Pair> hm = new HashMap<>();
        hm.put(' ', new Pair(1, 1));
        hm.put('A', new Pair(2, 1));
        hm.put('B', new Pair(2, 2));
        hm.put('C', new Pair(2, 3));
        hm.put('D', new Pair(3, 1));
        hm.put('E', new Pair(3, 2));
        hm.put('F', new Pair(3, 3));
        hm.put('G', new Pair(4, 1));
        hm.put('H', new Pair(4, 2));
        hm.put('I', new Pair(4, 3));
        hm.put('J', new Pair(5, 1));
        hm.put('K', new Pair(5, 2));
        hm.put('L', new Pair(5, 3));
        hm.put('M', new Pair(6, 1));
        hm.put('N', new Pair(6, 2));
        hm.put('O', new Pair(6, 3));
        hm.put('P', new Pair(7, 1));
        hm.put('Q', new Pair(7, 2));
        hm.put('R', new Pair(7, 3));
        hm.put('S', new Pair(7, 4));
        hm.put('T', new Pair(8, 1));
        hm.put('U', new Pair(8, 2));
        hm.put('V', new Pair(8, 3));
        hm.put('W', new Pair(9, 1));
        hm.put('X', new Pair(9, 2));
        hm.put('Y', new Pair(9, 3));
        hm.put('Z', new Pair(9, 4));

        String input = br.readLine();
        int result = p*hm.get(input.charAt(0)).second;
        int before = hm.get(input.charAt(0)).first;
        for(int i=1;i<input.length();i++){
            Pair cur = hm.get(input.charAt(i));
            if(cur.first == before && before != 1){
                result += w;
            }
            result+=p* cur.second;
            before = hm.get(input.charAt(i)).first;
        }

        System.out.println(result);
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
