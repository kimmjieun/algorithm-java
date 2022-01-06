package 알고리즘기초1.자료구조1_참고;

import java.io.*;
import java.util.Arrays;

// 11656번 접미사 배열
public class boj_9_11656 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        String[] strArray = new String[s.length()];

        for (int i = 0; i < s.length(); i++) {
            strArray[i] = s.substring(i, s.length());
        }

        Arrays.sort(strArray);
        for (String str : strArray) {
            bw.write(str);
            bw.write('\n');
        }

        bw.flush();
    }
}
