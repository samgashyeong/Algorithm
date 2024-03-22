import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;
public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> que = new PriorityQueue<>(n, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b){
                if(a>b){
                    return -1;
                }
                else{
                    return 1;
                }
            }
        });
        for(int i=0;i<n;i++){
            int input = Integer.parseInt(br.readLine());
            if(input == 0){
                if(que.size() == 0){
                    sb.append("0").append("\n");
                }
                else{
                    sb.append(que.poll()).append("\n");
                }
            }
            else{
                que.add(input);
            }
        }

        System.out.println(sb);
        
    }
}