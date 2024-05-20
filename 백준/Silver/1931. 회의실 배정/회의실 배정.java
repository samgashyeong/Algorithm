

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Pair {
    int start;
    int end;

    public Pair(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

//탑다운으로 푼 문제
public class Main {

    static ArrayList<Pair> pr = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            pr.add(new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        pr.sort((Pair a, Pair b) -> {
            int cnt = a.end - b.end;
            if(cnt == 0){
                return a.start - b.start;
            }
            return a.end - b.end;
        });

//        for(int i=0;i<n;i++){
//            System.out.println(pr.get(i).end);
//        }
        Pair start = pr.get(0);
        int result = 1;
        for (int i = 1; i < n; i++) {
            if (pr.get(i).start >= start.end) {
                result++;
                start = pr.get(i);
            }
        }
        System.out.println(result);
    }
}
