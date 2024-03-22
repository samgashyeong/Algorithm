import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        //BufferedReader로 입력 더 빠르게 하기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        ArrayList<Long> a = new ArrayList<>();
        
        long max = 0;
        while(st1.hasMoreTokens()){
            long num = Long.parseLong(st1.nextToken());
            a.add(num);
            if(max<num){
                max = num;
            }
        }
        long min = 0;

    
        long avg = 0;
        while(min<max){
            avg = (max+min)/2;
            long sum = 0;
            for(long i : a){
                if(avg < i){
                    sum+=(i-avg);
                }
            }
            if(sum < m){
                max = avg;
            }
            else if(sum >= m){
                min = avg+1;
            }
        }

        System.out.println(min-1);
    }
}
