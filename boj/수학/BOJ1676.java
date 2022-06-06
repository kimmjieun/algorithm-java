package 수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1676 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int count2 = 0;
        int count5 = 0;
        for (int i = 1; i <= n; i++) {
            int tmp = i;
            while (tmp % 2 == 0) {
                tmp /= 2;
                count2++;
            }
            while (tmp % 5 == 0) {
                tmp /= 5;
                count5++;
            }
        }

        System.out.println(Math.min(count2, count5));

    }
}
