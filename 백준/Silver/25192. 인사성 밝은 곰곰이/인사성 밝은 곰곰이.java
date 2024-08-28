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


        int result = 0;

        int n = Integer.parseInt(br.readLine());

        HashSet<String> arr = new HashSet<>();

        for(int i=0;i<n;i++){
            String str = br.readLine();

            if(str.equals("ENTER")){
                result+=arr.size();
                arr.clear();
            }
            else{
                arr.add(str);
            }
        }
        System.out.println(arr.size()+result);
    }
}
