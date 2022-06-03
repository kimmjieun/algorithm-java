package 수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10872 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n == 0) {
            System.out.println(1);
        } else {
            int sum = 1;
            for (int i = 1; i <= n; i++) {
                sum *= i;

            }
            System.out.println(sum);

        }

    }

}
