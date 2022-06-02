package 수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BOJ6588 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[] prime = new boolean[1000001];
        prime[0] = prime[1] = true;
        for (int i = 2; i < 1000001; i++) {
            if (!prime[i])
                for (int j = i + i; j < 1000001; j += i) {
                    prime[j] = true;
                }
        }

        while (true) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                break;
            }
            boolean flag = false;
            for (int i = 3; i < num - 2; i++) {
                if (!prime[i] && !prime[num - i] && i % 2 == 1 && (num - i) % 2 == 1) {
                    flag = true;
                    System.out.println(num + " = " + i + " + " + (num - i));
                    break;
                }
            }
            if (!flag) System.out.println("Goldbach's conjecture is wrong.");
        }
    }
}
