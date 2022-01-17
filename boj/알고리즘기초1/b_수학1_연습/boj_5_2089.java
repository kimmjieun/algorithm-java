package boj.알고리즘기초1.b_수학1_연습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2089번 -2진법
public class boj_5_2089 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int input = Integer.parseInt(br.readLine());

        if (input == 0)
            System.out.println(0);
        else {
            while (input != 1) {
                sb.append(Math.abs(input % -2));
                input = (int) Math.ceil((double) input / (-2));
            }
            sb.append(input);
            System.out.println(sb.reverse());
        }

    }
}
