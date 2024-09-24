import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br;
        br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());



        PriorityQueue<int[]> arr = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    return o1[1]-o2[1];
                }
                return o1[0]-o2[0];
            }
        });
        for(int i=1;i<=n;i++){
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());

            while(cnt-->0){
                arr.add(new int[]{
                        Integer.parseInt(st.nextToken()),
                        i
                });
            }
        }

        st = new StringTokenizer(br.readLine());
        int[] cnt = new int[n+1];
        PriorityQueue<Integer> kind = new PriorityQueue<>();
        for(int i=0;i<m;i++){
            kind.add(Integer.parseInt(st.nextToken()));
        }


        while(!kind.isEmpty()){
            int crt = kind.poll();


            while(!arr.isEmpty() && crt > arr.peek()[0]){
                //System.out.println(arr.peek()[0]);
                arr.poll();
            }

            if(!arr.isEmpty() && crt == arr.peek()[0]){
                cnt[arr.peek()[1]] += 1;
                arr.poll();
            }
        }
        for(int i=1;i<=n;i++){
            System.out.print(cnt[i] + " ");
        }

    }
}