package boj.알고리즘기초1.b_수학1;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Math.sqrt;

// 1929번 소수 구하기
public class boj_5_1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        for (int i = M; i <= N; i++) {
            if(isPrime(i)) System.out.println(i);
        }
    }

    public static boolean isPrime(int num) {
        if (num == 1) return false;

        for (int i = 2; i <= sqrt(num); i++) {
            if (num % i == 0) return false;
        }

        return true;
    }
}
