package 알고리즘기초1.b_수학1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 10872번 팩토리얼
public class boj_7_10872 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 1. 반복문
        int sum = 1;
        while (N != 0) {
            sum = sum * N;
            N--;
        }
        System.out.println(sum);
    }

    public static int factorial(int N) { // 2. 재귀
        if (N == 0 || N == 1) {
            return 1;
        }
        return N * factorial(N - 1);
    }
}
