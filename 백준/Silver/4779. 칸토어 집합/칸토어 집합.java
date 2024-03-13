import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static StringBuffer str = new StringBuffer();
    static StringBuilder sb = new StringBuilder();
    public static void f(int s, int start, int end){
        //System.out.println(s + " " + start + " " + end);
        if(s <= 1){
            return;
        }
        
        StringBuffer a = new StringBuffer();

        for(int i=0;i<((end+1)-start)/3;i++){
            a.append(" ");
        }

        //System.out.println(a);
    
        //str.replace(((end-start)+1)/3+start, (((end-start)+1)/3*2)+start, a.toString());
        int cut1 = (end-start)/3+start;
        int cut2 = ((end-start)*2)/3+start;
        str.replace(cut1, cut2, a.toString());
        
        //System.out.println(str);
        //System.out.println(str.substring(start, ((end+1)/3)+start));
        f(s/3, start, cut1);
        f(s/3, cut2, end);
    }

    public static void main(String[] args) throws Exception{
        //BufferedReader로 입력 더 빠르게 하기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt;

        int strNum = 1;
        String input = "";
        while((input = br.readLine()) != null){
            cnt = Integer.parseInt(input);
            if(cnt>0){
                
                for(int j=0;j<cnt;j++){
                    strNum*=3;
                }
                for(int j=0;j<strNum;j++){
                    str.append("-");
                }
                
            }
            else{
                str.append("-");
            }
            f(strNum, 0, str.length());
            System.out.println(str);
            strNum = 1;
            str = new StringBuffer("");
            
        }
    }
}
