import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
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

        PriorityQueue<Integer> que = new PriorityQueue<>();

        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
            que.add(Integer.parseInt(br.readLine()));
        }

        int result = 0;
        while(que.size() > 1){
            int a = que.poll();
            int b = que.poll();
            
            result += (a+b);
            que.add(a+b);
        }

        System.out.println(result);
    }
}