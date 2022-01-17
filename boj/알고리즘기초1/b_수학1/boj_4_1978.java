package boj.알고리즘기초1.b_수학1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Math.sqrt;

// 1978번 소수 찾기
public class boj_4_1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine(); // n 쓰지 않음

        int count = 0;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            if (isPrime(num)) count++;
        }

        System.out.println(count);
    }

    public static boolean isPrime(int num) {
        if (num == 1) return false;

        for (int i = 2; i <= sqrt(num); i++) {
            if (num % i == 0) return false;
        }

        return true;
    }
}
