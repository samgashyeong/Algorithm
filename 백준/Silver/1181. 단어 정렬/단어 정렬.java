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

        int n = Integer.parseInt(br.readLine());
        

        HashSet<String> input = new HashSet<>();

        for(int i=0;i<n;i++){
            input.add(br.readLine());
        }

        ArrayList<String> arr = new ArrayList<>(input);

        Collections.sort(arr, new Comparator<String>() {
			
			@Override
			public int compare(String o1, String o2) {

                if(o1.length() == o2.length()){
                    return o1.compareTo(o2);
                }
				else{
                    return o1.length()-o2.length();
                }
			}
		});


        for(int i=0;i<arr.size();i++){
            System.out.println(arr.get(i));
        }
        



	}
}