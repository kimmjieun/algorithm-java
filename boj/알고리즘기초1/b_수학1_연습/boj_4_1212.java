package 알고리즘기초1.b_수학1_연습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 1212번 8진수 2진수
public class boj_4_1212 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String N = br.readLine();
        for (int i = 0; i < N.length(); i++) {
            String a = Integer.toBinaryString(N.charAt(i) - '0'); // 문자인 숫자를 숫자로 바꿔줌
            if (a.length() == 2 && i != 0) a = "0" + a;
            else if (a.length() == 1 && i != 0) a = "00" + a;
            sb.append(a);
        }
        System.out.println(sb);
    }
}
