import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n  = Integer.parseInt(br.readLine());

        HashMap<Integer, Integer> map = new HashMap<>();

        while(n-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            map.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        int r = Integer.parseInt(br.readLine());

        while(r-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int cnt = Integer.parseInt(st.nextToken());

            boolean died = false;
            StringBuilder resultS = new StringBuilder();
            for(int i = 0; i < cnt; i++){
                int result = map.getOrDefault(Integer.parseInt(st.nextToken()), -1);

                if(result == -1){
                    resultS = new StringBuilder("YOU DIED");
                    break;
                } else {
                    resultS.append(result).append(" ");
                }
            }

            sb.append(resultS.toString() + "\n");
        }
        System.out.print(sb);
    }
}
