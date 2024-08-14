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

        int[] a = new int[n + 1];  // 팀 번호는 1부터 시작하므로 크기는 n+1로

        Arrays.fill(a, 1);  // 모든 팀에 1개의 카약을 배정

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < s; i++) {
            int damagedTeam = Integer.parseInt(st.nextToken());
            a[damagedTeam] = 0;  // 손상된 팀의 카약 수를 0으로 설정
        }

        st = new StringTokenizer(br.readLine());
        ArrayList<Integer> reserveTeams = new ArrayList<>();
        for (int i = 0; i < r; i++) {
            int reserveTeam = Integer.parseInt(st.nextToken());
            if (a[reserveTeam] == 0) {
                a[reserveTeam] = 1;  // 손상된 팀이 여분의 카약을 가져온 경우, 바로 그 팀이 사용
            } else {
                reserveTeams.add(reserveTeam);
            }
        }

        // 남은 여분의 카약을 인접한 팀에게 빌려줄 수 있는지 확인
        Collections.sort(reserveTeams);
        for (int reserveTeam : reserveTeams) {
            if (reserveTeam > 1 && a[reserveTeam - 1] == 0) {
                a[reserveTeam - 1] = 1;  // 앞팀에게 빌려줌
            } else if (reserveTeam < n && a[reserveTeam + 1] == 0) {
                a[reserveTeam + 1] = 1;  // 뒷팀에게 빌려줌
            }
        }

        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (a[i] == 0) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
