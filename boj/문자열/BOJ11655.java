package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ' ') {
                sb.append(" ");
            } else if (input.charAt(i) >= '0' && input.charAt(i) <= '9') {
                sb.append(input.charAt(i));
            } else {
                if ((input.charAt(i) >= 'A' && input.charAt(i) <= 'M') ||
                        (input.charAt(i) >= 'a' && input.charAt(i) <= 'm')) {
                    sb.append((char) (input.charAt(i) + 13));
                } else {
                    sb.append((char) (input.charAt(i) - 13));
                }

            }
        }
        System.out.println(sb);

    }
}
