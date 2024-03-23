import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
 
public class Main {
    static boolean[][] arr = new boolean[15][15];

	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        

        for(int i=0;i<n;i++){
            
            st = new StringTokenizer(br.readLine());

            int cnt = Integer.parseInt(st.nextToken());

            String input = st.nextToken();


            for(int j=0;j<input.length();j++){
                char a = input.charAt(j);

                for(int z=0;z<cnt;z++){
                    sb.append(a);
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
	}
}