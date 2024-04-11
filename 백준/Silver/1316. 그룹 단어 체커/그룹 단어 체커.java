import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;
 
public class Main {
 
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        
        int cnt = 0;
        while(n-->0){
            String str = br.readLine();
            HashSet<Character> has = new HashSet<>();    
            char be = str.charAt(0);
            has.add(be);
            boolean cntB = true;
            
            for(int i=1;i<str.length();i++){
                if(has.contains(str.charAt(i))){

                    if(be != str.charAt(i)) {
                        cntB = false;
                        break;
                    }
                    
                }
                else{
                    be = str.charAt(i);
                    has.add(be);
                }
            }

            if(cntB){
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
