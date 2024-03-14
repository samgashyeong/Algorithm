import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
 
public class Main {
	
	static int[][] arr = new int[30][30];

    static int f(int n, int r) {
		if(arr[n][r] > 0) {
			return arr[n][r]; 
		}
		
		if(n == r || r == 0) {
			return arr[n][r] = 1;
		}
		
		return arr[n][r] = f(n - 1, r - 1) + f(n - 1, r);
	}
 
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < T; i++) {
			
			st = new StringTokenizer(br.readLine(), " ");
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			sb.append(f(M, N)).append('\n');
		}
		
		System.out.println(sb);
 
	}
	
	
}