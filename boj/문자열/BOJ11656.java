package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ11656 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String[] result = new String[s.length()];
        for (int i = 0; i < s.length(); i++) {
            result[i] = s.substring(i);
        }
        Arrays.sort(result);

        for (int i = 0; i < s.length(); i++) {
            System.out.println(result[i]);
        }
    }
}
