import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());

            String name = st.nextToken();

            int age = Integer.parseInt(st.nextToken());
            int wei = Integer.parseInt(st.nextToken());

            if(name.equals("#") && age == 0 && wei == 0){
                
                break;
            }

            if(age > 17 || wei >= 80){
                sb.append(name).append(" Senior").append("\n");
            }
            else{
                sb.append(name).append(" Junior").append("\n");
            }
        }

        System.out.println(sb);
    }
}