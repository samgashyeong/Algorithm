import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<Integer> arr = new ArrayList<>();

        for(int i=0;i<n;i++){
            arr.add(Integer.parseInt(st.nextToken()));
        }

        arr.add(-1);
        int targetArrange = 1;
        long sum = 0;
        for(int i=1;i<=n;i++){
            if(arr.get(i-1) < arr.get(i)){
                targetArrange++;
            }
            else{
                long fact  = ((long) (targetArrange + 1) *targetArrange)/2;
                sum += fact;
                targetArrange = 1;
            }
        }

        sum += (long) targetArrange * (targetArrange + 1) / 2;
        System.out.println(sum-1);
    }
}
