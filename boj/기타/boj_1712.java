package 기타;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1712 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] numArr = br.readLine().split(" ");
        int result = 0;

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(numArr[i]);
            int count = 0;
            if (num == 1) {
                continue;
            } else {
                for (int j = 1; j <= num; j++) {
                    if (num % j == 0) {
                        count++;
                    }
                }
            }
            if (count == 2) {
                result++;
            }
        }
        System.out.println(result);
    }
}
