package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1718 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String pwd = br.readLine();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') sb.append(" ");
            else if (c == pwd.charAt(i % pwd.length())) sb.append('z');
            else {
                sb.append((char) ((c - pwd.charAt(i % pwd.length()) + 26) % 26 + 96));
            }
        }
        System.out.println(sb);
    }
}
