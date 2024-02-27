import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{
        //BufferedReader로 입력 더 빠르게 하기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        

    
        for(int i =0;i<size;i++){
            String s = br.readLine();
    
            Stack<Character> stack = new Stack<>();

            for(int j = 0;j<s.length();j++){
                if(stack.size() != 0 && s.charAt(j) == ')' && stack.peek() == '('){
                    stack.pop();
                }
                else{
                    stack.push(s.charAt(j));
                }
            }

            if(stack.size() != 0){
                System.out.println("NO");
            }
            else{
                System.out.println("YES");
            }
        }
    }

}
