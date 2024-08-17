import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        while((input = br.readLine()) != null && !input.isEmpty()) {

            int result = 1;
            BigInteger integer = BigInteger.ONE;
            while(true) {
                if(integer.mod(new BigInteger(input)).equals(BigInteger.ZERO)){
                    System.out.println(result);
                    break;
                }
                integer = integer.multiply(BigInteger.TEN).add(BigInteger.ONE);
                result++;
            }
        }
    }
}
