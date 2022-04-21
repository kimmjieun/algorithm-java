package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ3029 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //1. :으로 스플릿
        String input = br.readLine();
        String input2 = br.readLine();

        String[] s = input.split(":");
        String[] s2 = input2.split(":");

        int[] S = new int[3];
        int[] S2 = new int[3];
        for (int i = 0; i < 3; i++) {
            S[i] = Integer.parseInt(s[i]);
            S2[i] = Integer.parseInt(s2[i]);
        }

        //2. 시간 계산
        if (input.equals(input2)) {
            System.out.println("24:00:00");
        } else {
            int re1, re2, re3; // 시 분초

            if (S2[2] < S[2]) {
                S2[1]--;
                re3 = S2[2] + 60 - S[2];
            } else {
                re3 = S2[2] - S[2];
            }

            if (S2[1] < S[1]) {
                S2[0]--;
                re2 = S2[1] + 60 - S[1];
            } else {
                re2 = S2[1] - S[1];
            }

            if (S2[0] < S[0]) {
                re1 = S2[0] - S[0] + 24;
            } else {
                re1 = S2[0] - S[0];
            }

            // 3. 출력시 포맷팅
            System.out.format("%02d:%02d:%02d", re1, re2, re3);
        }

    }

}
