package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10820 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input;
        while ((input = br.readLine())!=null) {

            int upper = 0;
            int lower = 0;
            int num = 0;
            int space = 0;

            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                if (c == ' ') space++;
                else if (c >= 48 && c <= 58) num++;
                else if (c >= 65 && c <= 91) upper++;
                else if (c >= 97 && c <= 123) lower++;
            }

            System.out.println(lower + " " + upper + " " + num + " " + space);
        }
    }
}
