import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();

    static int n;
    static int m;

    static int diffChar(String a, String b) {
        int cnt = 0;
        for (int i = 0; i < 4; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        

        while (t-- > 0) {

            int min = 101010;
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            // String[] mbti = new String[n];
            ArrayList<String> mbti = new ArrayList<>();
            if (n > 32) {
                sb.append(0).append("\n");
                continue;
            }
            for (int i = 0; i < n; i++) {
                mbti.add(st.nextToken());
            }
            ArrayList<Integer> diff = new ArrayList<>();
            for (int i = 0; i < mbti.size(); i++) {
                for (int j = i + 1; j < mbti.size(); j++) {
                    for(int k=j+1;k<mbti.size();k++){
                        int cnt = diffChar(mbti.get(i), mbti.get(j)) + diffChar(mbti.get(i), mbti.get(k)) + diffChar(mbti.get(j), mbti.get(k));
                        if(cnt<min){
                            min = cnt;
                        } 
                    }
                }
            }

            sb.append(min).append("\n");

        }

        System.out.println(sb);
    }
}