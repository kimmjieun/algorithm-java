package 알고리즘기초1.자료구조1_참고;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 10820번 문자열 분석
public class boj_5_10820 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = "";
        while ((input = br.readLine()) != null) {
            char str[] = input.toCharArray();
            int small = 0, big = 0, num = 0, blank = 0;
            for (char ch : str) {
                if ('a' <= ch && ch <= 'z')
                    small++;
                else if ('A' <= ch && ch <= 'Z')
                    big++;
                else if ('0' <= ch && ch <= '9')
                    num++;
                else
                    blank++;
            }
            System.out.println(small + " " + big + " " + num + " " + blank);
        }

    }
}
