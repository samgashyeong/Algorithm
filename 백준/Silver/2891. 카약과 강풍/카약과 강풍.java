import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[] a = new int[15];

        Arrays.fill(a, 1);

        st = new StringTokenizer(br.readLine());

        for(int i=0;i<s;i++){
            a[Integer.parseInt(st.nextToken())] = 0;
        }

        st = new StringTokenizer(br.readLine());

        ArrayList<Integer> arr= new ArrayList<>();
        for(int i=0;i<r;i++){
            int num = Integer.parseInt(st.nextToken());
            if (a[num] == 0) {
                a[num] = 1;  // 손상된 팀이 여분의 카약을 가져온 경우, 바로 그 팀이 사용
            } else {
                arr.add(num);
            }
        }

        Collections.sort(arr);

        //System.out.println(arr);
        for(int i=0;i<arr.size();i++){
            int num = arr.get(i);
            if(num-1>=1 && a[num-1] == 0){
                a[num-1]++;
            }
            else if(num+1<=n && a[num+1] == 0){
                a[num+1]++;
            }
        }

        //System.out.println(Arrays.toString(Arrays.stream(a).toArray()));

        int sum = 0;
        for(int i=1;i<=n;i++){
            if(a[i] == 0){
                sum++;
            }
        }

        System.out.println(sum);

    }
}
