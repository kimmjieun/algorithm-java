package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10988 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s = br.readLine();
        String S = "";
        if (s.length() % 2 == 1)
            S = s.substring(s.length() / 2 + 1);
        else
            S = s.substring(s.length() / 2);


        if (s.substring(0, s.length() / 2).equals(sb.append(S).reverse().toString()))
            System.out.println(1);
        else
            System.out.println(0);

    }
}
