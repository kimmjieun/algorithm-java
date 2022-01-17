package 알고리즘기초1.a_자료구조1_참고;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 10824번 네 수
public class boj_8_10824 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        System.out.println(Long.parseLong(input[0] + input[1]) + Long.parseLong(input[2] + input[3]));
    }
}
