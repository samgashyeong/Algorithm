import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] arrA, arrB;
		int[] subArrA, subArrB;
		StringTokenizer stA,stB;
		long total = 0;
		
		int T = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		stA = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(br.readLine());
		stB = new StringTokenizer(br.readLine());
		
		arrA = new int[N];
		arrB = new int[M];
				
		for (int i = 0; i < N; i++) {
			arrA[i] = Integer.parseInt(stA.nextToken());
		}
		for (int i = 0; i < M; i++) {
			arrB[i] = Integer.parseInt(stB.nextToken());
		}
		
		int size = 0;
		int idx = 0;
		
		for (int i = 1; i <= N; i++) {
			size += i;
		}
		subArrA = new int[size];
		for (int i = 0; i < N; i++) {
			int sum=0;
			int at = i;
			while (at < N) {
				sum += arrA[at++];
				subArrA[idx++] = sum;
			}
		}
		
		size = 0;
		idx = 0;
		for (int i = 1; i <= M; i++) {
			size += i;
		}
		subArrB = new int[size];
		for (int i = 0; i < M; i++) {
			int sum=0;
			int at = i;
			while (at < M) {
				sum += arrB[at++];
				subArrB[idx++] = sum;
			}
		}
		
		Arrays.sort(subArrB);
		

		for (int num : subArrA) {
			int tar = T - num;
						
			int left= lower_idx(tar ,subArrB);
            
			int right = upper_idx(tar ,subArrB);
			
			total +=(right - left);
			
		}
		
		System.out.println(total);
		
	}
	
	private static int lower_idx(int target, int[] arr) {
		
		int st = 0;
		int en = arr.length;
		
		while (st < en) {
			int mid = (st+en)/2;
			
			if(arr[mid] >= target) {
				en=mid;
			}else {
				st = mid+1;
			}
		}
		
		return st;
		
	}
	
	private static int upper_idx(int target, int[] arr) {
		
		int st = 0;
		int en = arr.length;
		
		while (st < en) {
			int mid = (st+en)/2;
			
			if(arr[mid] > target) {
				en=mid;
			}else {
				st = mid+1;
			}
		}
		
		return st;
	
	}
	
}