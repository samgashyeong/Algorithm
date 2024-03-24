import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;
 
public class Main {

	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String input = br.readLine();

        input = input.toUpperCase();


        //System.out.println(input);


        Map<Character, Integer> dict = new HashMap<>();
        for(int i=0;i<input.length();i++){
            if(!dict.containsKey(input.charAt(i))){
                dict.put(input.charAt(i), 1);
            }
            else{
                int cnt = dict.get(input.charAt(i));
                dict.replace(input.charAt(i), cnt+1);
            }
        } 
        
        int max = -1;
        String maxCh = "";
        for(Map.Entry<Character, Integer> entry : dict.entrySet()){
            if(entry.getValue() > max){
                max = entry.getValue();
                maxCh = String.valueOf(entry.getKey());
            }
        }

        int cnt = 0;
        for(Map.Entry<Character, Integer> entry : dict.entrySet()){
            if(entry.getValue() == max){
                
                if(cnt == 1){
                    System.out.println("?");
                    return;
                }
                else{
                    cnt++;
                }
            }
        }

        System.out.println(maxCh);

	}
}