package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9093 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            String[] s = br.readLine().split(" ");
            String result = "";
            for (int j = 0; j < s.length; j++) {
                String word = s[j];
                for (int k = word.length() - 1; k >= 0; k--) {
                    result += word.charAt(k);
                }
                result += " ";

            }
            System.out.println(result);
        }


    }
}
