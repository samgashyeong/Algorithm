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
        ArrayList<String> strList = new ArrayList<>();
        while(true){
            String str = br.readLine();
            if(str.equals(".")){
                break;
            }
            strList.add(str);
        }
        
        Stack<Character> stk = new Stack<>();
        //Stack<Character> stk1 = new Stack<>();

        for(int i =0;i<strList.size();i++){
            
            for(int j=0;j<strList.get(i).length();j++){
                if(strList.get(i).charAt(j) == ')' && stk.size() != 0 && stk.peek() == '('){
                    stk.pop();
                }
                else if(strList.get(i).charAt(j) == ']' && stk.size() != 0 && stk.peek() == '['){
                    stk.pop();
                }
                else if(strList.get(i).charAt(j) == '(' || strList.get(i).charAt(j) == '[' || strList.get(i).charAt(j) == ')' || strList.get(i).charAt(j) == ']'){
                    stk.push(strList.get(i).charAt(j));
                }
                // if(strList.get(i).charAt(j) == '['){
                //     stk.push(strList.get(i).charAt(j));
                // }
                // else if(strList.get(i).charAt(j) == ']' && stk.size() != 0 && stk.peek() == '['){
                //     stk.pop();
                // }
            }

            if(stk.size() == 0){
                System.out.println("yes");
            }
            else{
                System.out.println("no");
            }
            stk.clear();
        }
    }
}