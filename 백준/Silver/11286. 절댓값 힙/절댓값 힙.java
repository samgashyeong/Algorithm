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

        PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b){
                int num1 = Math.abs(a);
                int num2 = Math.abs(b);
                if(num1>num2)
                    return 1;
                else if(num1 == num2){
                    if(a>b) return 1;
                    else return -1;
                }
                else
                    return -1;
            }
        });


        int n = Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++){
            int x = Integer.parseInt(br.readLine());
            if(x!=0){
                q.add(x);
            }
            else if(x == 0){
                if(q.size() == 0){
                    //System.out.println(0);
                    sb.append("0").append("\n");
                }
                else{
                    //System.out.println(q.poll().value);
                    sb.append(q.poll()).append("\n");
                }
            }
        }

        System.out.println(sb);

    }
}