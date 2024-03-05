import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    //문제의 흐름을 잘 따라면 쉽게 풀 수 있는 문제였던 것 같다.
    public static void main(String[] args) throws Exception{
        //BufferedReader로 입력 더 빠르게 하기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Queue<Integer> messList = new LinkedList<>();

        Stack<Integer> notMessStk = new Stack<>();


        StringTokenizer st = new StringTokenizer(br.readLine());

        while(st.hasMoreTokens()){
            messList.add(Integer.parseInt(st.nextToken()));
        }

        int nowPos = 1;
        for(int i = 0;i<n;i++){
            int size = messList.size();
            
            for(int j=0;j<size;j++){
                if(messList.size() != 0 && messList.peek() == i+1){
                    i++;
                    nowPos++;
                    messList.poll();
                }
                else if(notMessStk.size() != 0 && notMessStk.peek() == i+1){
                    i++;
                    j--;
                    nowPos++;
                    notMessStk.pop();
                }
                else{
                    notMessStk.add(messList.poll());
                }
            }
        }


        boolean outNice = true;
        
        while(notMessStk.size() != 0){
            int num = notMessStk.pop();
            if(num != nowPos){
                outNice = false;
                System.out.println("Sad");
                break;
            }
            nowPos++;
        }

        if(outNice){
            System.out.println("Nice");
        }
    }
}