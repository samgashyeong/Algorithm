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
        int n = Integer.parseInt(br.readLine());
        
        ArrayList<Integer> arr = new ArrayList<>();
        
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            
            arr.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(arr);

        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++){
            
            int num = Integer.parseInt(st.nextToken());

            
            int le = 0;
            int ri = n-1;
            int ans = 0;
            while(le<=ri){
                int mid=(le+ri)/2;
                
                if(arr.get(mid) >= num){
                    ri = mid-1;
                    ans = mid;
                }
                else le=mid+1;
            }
            if(arr.get(ans)==num){
                sb.append(1).append("\n");
            }
            else{
                sb.append(0).append("\n");
            }
        }
        System.out.println(sb);
	}
}