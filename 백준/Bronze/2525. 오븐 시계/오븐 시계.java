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
        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        int num = Integer.parseInt(br.readLine());

        if(m+num>=60){
            int addHour = (m+num)/60;
            if(h+addHour>=24){
                System.out.print((h+addHour)-24+" ");
                System.out.println((m+num)%60);
            }
            else{
                System.out.println(h+addHour+" " + (m+num)%60);
            }
        }
        else{
            System.out.println(h+" " + (m+num));
        }
    }
}