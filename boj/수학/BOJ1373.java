package 수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1373 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();

//        int decimal = Integer.parseInt(input, 2); // 여기 오류
//        String result = Integer.toString(decimal, 8);
//        System.out.println(result);

        StringBuilder sb = new StringBuilder();

        if (n.length() % 3 == 1) {
            sb.append(n.charAt(0));
        }
        if (n.length() % 3 == 2) {
            sb.append((n.charAt(0) - '0') * 2 + (n.charAt(1) - '0'));
        }
        for (int i = n.length() % 3; i < n.length(); i += 3) {
            sb.append((n.charAt(i) - '0') * 4 + (n.charAt(i + 1) - '0') * 2 + (n.charAt(i + 2) - '0'));


        }

        System.out.println(sb);
    }
}
