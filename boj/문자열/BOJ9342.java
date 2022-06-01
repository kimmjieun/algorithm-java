package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class BOJ9342 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            String s = br.readLine();
            String result = "";
            for (int i = 0; i < s.length(); i++) {
                if (!result.contains(s.charAt(i) + "")) {
                    result += s.charAt(i);
                }
            }
            String pattern = "[ABCDEF]*AFC[ABCEDF]*";
            if (Pattern.matches(pattern, result)) {
                System.out.println("Infected!");
            } else {
                System.out.println("Good");
            }
        }
    }
}
