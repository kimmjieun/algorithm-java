package 알고리즘기초1.c_다이나믹프로그래밍1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1912번 연속합
public class boj_12_1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int max = numbers[0];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += numbers[i];
            max = Math.max(max, sum);
            if (sum < 0) sum = 0;
        }
        System.out.println((max));

    }
}
