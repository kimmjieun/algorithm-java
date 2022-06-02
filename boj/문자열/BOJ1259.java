package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1259 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {

            String s = br.readLine();
            if (s.equals("0")) break;

            String S = "";
            if (s.length() % 2 == 1)
                S = s.substring(s.length() / 2 + 1);
            else
                S = s.substring(s.length() / 2);

            StringBuilder sb = new StringBuilder();
            if (s.substring(0, s.length() / 2).equals(sb.append(S).reverse().toString()))
                System.out.println("yes");
            else
                System.out.println("no");
        }

    }
}
