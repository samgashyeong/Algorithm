import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;

        ArrayList<Character> vowels = new ArrayList<>();
        vowels.add('a');
        vowels.add('o');
        vowels.add('e');
        vowels.add('i');
        vowels.add('u');

        while (!(input = br.readLine()).equals("end")) {
            String original = input;
            boolean containsVowel = false;
            boolean acceptable = true;
            int vowelCount = 0;
            int consonantCount = 0;

            for (int i = 0; i < input.length(); i++) {
                char current = input.charAt(i);

                if (vowels.contains(current)) {
                    containsVowel = true;
                    vowelCount++;
                    consonantCount = 0;
                } else {
                    consonantCount++;
                    vowelCount = 0;
                }

                if (vowelCount >= 3 || consonantCount >= 3) {
                    acceptable = false;
                    break;
                }

                if (i > 0 && current == input.charAt(i - 1) && !(current == 'e' || current == 'o')) {
                    acceptable = false;
                    break;
                }
            }

            if (!containsVowel) {
                acceptable = false;
            }

            if (acceptable) {
                System.out.println("<" + original + "> is acceptable.");
            } else {
                System.out.println("<" + original + "> is not acceptable.");
            }
        }
    }
}