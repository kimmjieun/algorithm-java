package 알고리즘기초1.b_수학1;

import java.io.*;

// 6588번 골드바흐의 추측
public class boj_6_6588 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean[] check = new boolean[1000001];
        check[0] = check[1] = true;

        for (int i = 2; i < check.length; i++) {
            if (!check[i]) {
                for (int j = 2; i * j < check.length; j++) {
                    check[i * j] = true;
                }
            }
        }

        int n = Integer.parseInt(br.readLine());

        while (n != 0) {
            boolean mProve = false;

            for (int k = 2; k <= n; k++) {
                if(!check[k]){
                    if (!check[n-k]) {
                        bw.write(n + " = " + k + " + " + (n - k));
                        bw.newLine();
                        mProve = true;
                        break;
                    }
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
