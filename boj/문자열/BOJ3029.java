package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ3029 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input1 = br.readLine();
        String input2 = br.readLine();

        String[] s1 = input1.split(":");
        String[] s2 = input2.split(":");

        int[] n = new int[3];
        for (int i = 0; i < 3; i++) {
            n[i] = Integer.parseInt(s2[i]) - Integer.parseInt(s1[i]);
        }
        if (input1.equals(input2)) {
            System.out.println("24:00:00");
        } else {
            if (n[2] < 0) {
                n[2] += 60;
                n[1]--;
            }
            if (n[1] < 0) {
                n[1] += 60;
                n[0]--;
            }
            if (n[0] < 0) {
                n[0] += 24;

            }
            System.out.format("%02d:%02d:%02d", n[0], n[1], n[2]);
        }
    }
}
