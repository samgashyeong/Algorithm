import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//탑다운으로 푼 문제
public class Main {

    static int t;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<Integer> input = new ArrayList<>();

        for(int i=0;i<n;i++){
            input.add(Integer.parseInt(st.nextToken()));
        }

        System.out.println(2*(Collections.max(input)-Collections.min(input)));
    }
}
