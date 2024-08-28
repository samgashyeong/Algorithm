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


        HashSet<String> set = new HashSet<>();
        while(n-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();

            if(a.equals("ChongChong")){
                set.add(b);
            }
            else if(b.equals("ChongChong")){
                set.add(a);
            }


            if(set.contains(a)){
                set.add(b);
            }
            else if(set.contains(b)){
                set.add(a);
            }
        }

        System.out.println(set.size());
    }
}
