package boj.알고리즘기초1.b_수학1;

import java.io.*;

// 6588번 골드바흐의 추측
public class boj_6_6588 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 소수 구하기 = 소수 false
        boolean[] num = new boolean[1000001];
        num[0] = num[1] = true;
        for (int i = 2; i < num.length; i++) {
            if (!num[i]) {
                for (int j = i + i; j < num.length; j += i) {
                    num[j] = true;
                }
            }
        }

        int n = Integer.parseInt(br.readLine());

        while (n != 0) {
            boolean mProve = false;
            for (int j = 2; j <= n / 2; j++) {
                if (!num[j] && !num[n - j]) {
                    bw.write(n + " = " + j + " + " + (n - j));
                    bw.newLine();
                    mProve = true;
                    break;
                }
            }

            if (!mProve) {
                bw.write("Goldbach's conjecture is wrong.");
                bw.newLine();
            }
            n = Integer.parseInt(br.readLine());
        }

        bw.flush();
        bw.close();
    }
}
