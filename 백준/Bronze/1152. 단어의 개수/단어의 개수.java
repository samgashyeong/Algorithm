import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{
        //BufferedReader로 입력 더 빠르게 하기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int cnt = 0;
        while(st.hasMoreTokens()){
            st.nextToken();
            cnt++;
        }
        System.out.println(cnt);
    }

}
