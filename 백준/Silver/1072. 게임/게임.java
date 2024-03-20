import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;
 
public class Main {
    static boolean[][] arr = new boolean[15][15];

	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //System.out.println(Math.floor(86f/106f*100));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long x = Long.parseLong(st.nextToken());
        long y = Long.parseLong(st.nextToken());

        long currentWinRate = (y * 100) / x;

        if (currentWinRate >= 99) {
            System.out.println(-1);
            return;
        }

        long min = 0;
        long max = 1000000001;
        long result = -1;

        while (min <= max) {
            long mid = (min + max) / 2;
            long newWinRate = ((y + mid) * 100) / (x + mid);

            if (newWinRate > currentWinRate) {
                result = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        System.out.println(result);
	}
}