package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9046 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            String input = br.readLine();
            int[] result = new int[26];
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) >= 'a' && input.charAt(i) <= 'z') {
                    result[input.charAt(i) - 'a']++;
                }
            }

            int max = 0;
            for (int r : result) {
                if (r > max) {
                    max = r;
                }
            }

            int count = 0;
            int answer = 0;
            for (int j = 0; j < 26; j++) {
                if (max == result[j]) {
                    count++;
                    answer = j;
                }
            }

            System.out.println(count == 1 ? (char) (answer + 'a') : "?");
        }
    }
}
