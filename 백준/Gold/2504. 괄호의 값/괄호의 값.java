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

        String str = br.readLine();
        
        Stack<Character> stk = new Stack<>();

        int count = 1;
        int result = 0;
        for(int j=0;j<str.length();j++){
            if(str.charAt(j) == ')' && stk.size() != 0 && stk.peek() == '('){
                stk.pop();
                if(str.charAt(j-1) == '('){
                    result += count;
                }
                count/=2;
            }
            else if(str.charAt(j) == ']' && stk.size() != 0 && stk.peek() == '['){
                stk.pop();
                if(str.charAt(j-1) == '['){
                    result += count;
                }
                count/=3;
            }
            else if(str.charAt(j) == '('){
                stk.push(str.charAt(j));
                count = count*2;
            }
            else if(str.charAt(j) == '['){
                stk.push(str.charAt(j));
                count = count*3;
            }
            else{
                stk.push(str.charAt(j));
            }
        }

        if(stk.size() == 0){
            System.out.println(result);
        }
        else{
            System.out.println("0");
        }
    }
}