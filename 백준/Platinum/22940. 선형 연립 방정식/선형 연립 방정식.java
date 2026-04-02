import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static double[][] matrix = new double[10][10];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= n; j++) {
                matrix[i][j] = Double.parseDouble(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            double div = matrix[i][i];
            for (int j = i; j <= n; j++) {
                matrix[i][j] /= div;
            }
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                double factor = -matrix[j][i];
                for (int k = 0; k <= n; k++) {
                    matrix[j][k] += matrix[i][k] * factor;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(Math.round(matrix[i][n])).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}