import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;
 
public class Main {
    static int[] h = new int[100001];
    static int[] o = new int[100001];
	public static void main(String[] args) throws Exception{
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int result = 0;

        HashSet<String> set = new HashSet<>();
        ArrayList<String> arrName = new ArrayList<>();
        for(int i=0;i<n;i++){
            String name = br.readLine();

            set.add(name);
        }

        for(int i=0;i<m;i++){
            String name = br.readLine();
            if(set.contains(name)){
                arrName.add(name);
                result++;
            }
        }

        StringBuilder sb = new StringBuilder();

        sb.append(result).append("\n");

        Collections.sort(arrName);
        for(int i=0;i<arrName.size();i++){
            sb.append(arrName.get(i)).append("\n");
        }

        
        System.out.println(sb);
	}
}