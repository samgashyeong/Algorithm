import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    //이분탐색을 알아서 좀 나대었지만, 반례를 찾지 못해 조금 고생한 문제
    public static void main(String[] args) throws Exception {
        //BufferedReader로 입력 더 빠르게 하기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        long k = Long.parseLong(st.nextToken());
        ArrayList<Long> level = new ArrayList<>();
        long min = 1000000001;
        long max = 1000000001;
        for(int i =0;i<n;i++){
            long num = Long.parseLong(br.readLine());
            if(num<min){
                min = num;
            }
            level.add(num);
        }

    
        long avg = 0;
        while(min<=max){
            avg = (max+min)/2;
            int count = 0;
            long sum = 0;
            for(long i : level){
                if(avg > i){
                    sum+=i;
                    count++;
                }
            }

            sum+=k;
            if(avg*count <= sum){
                min = avg+1;
            }
            else if(avg*count > sum){
                max = avg-1;
            }
        }

        System.out.println(min-1);
    }
}
