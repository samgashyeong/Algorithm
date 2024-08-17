import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;

        while((input = br.readLine()) != null && !input.isEmpty()) {
            BigInteger n = new BigInteger(input);
            BigInteger currentNumber = BigInteger.ONE;
            int result = 1;

            while (!currentNumber.mod(n).equals(BigInteger.ZERO)) {
                currentNumber = currentNumber.multiply(BigInteger.TEN).add(BigInteger.ONE);
                result++;
            }

            System.out.println(result);
        }
    }
}
