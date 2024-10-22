import java.io.*;
import java.util.Arrays;

public class Main {
    static char[][] d;
    static int n = 0;
    static int max = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        n = Integer.parseInt(br.readLine());

        d = new char[n][n];

        for(int i=0;i<n;i++){
            String in = br.readLine();
            d[i] = in.toCharArray();
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<4;k++){
                    int nx = j + dx[k];
                    int ny = i + dy[k];

                    if((0<= nx && nx < n) && (0<= ny && ny < n)){
                        if(d[i][j] != d[ny][nx]){
                            char tmp = d[i][j];
                            d[i][j] = d[ny][nx];
                            d[ny][nx] = tmp;


                            chk('C');
                            chk('P');
                            chk('Z');
                            chk('Y');
                            chk1('C');
                            chk1('P');
                            chk1('Z');
                            chk1('Y');

                            char tmp1 = d[i][j];
                            d[i][j] = d[ny][nx];
                            d[ny][nx] = tmp1;
                        }
                    }
                }
            }
        }

        System.out.println(max);
    }

    private static void chk(char c) {
        for(int i=0;i<n;i++){
            int cnt = 0;
            for(int j=0;j<n;j++){
                if(d[i][j] == c){
                    cnt ++;
                }
                else{
                    max = Math.max(max, cnt);
                    cnt = 0;
                }
            }
            max = Math.max(max, cnt);
        }
    }

    private static void chk1(char c) {
        for(int i=0;i<n;i++){
            int cnt = 0;
            for(int j=0;j<n;j++){
                if(d[j][i] == c){
                    cnt ++;
                }
                else{
                    max = Math.max(max, cnt);
                    cnt = 0;
                }
            }
//            if(max < cnt){
//                for(char[] a : d){
//                    System.out.println(Arrays.toString(a));
//                }
//            }
            max = Math.max(max, cnt);
        }
    }
}