package 알고리즘기초1.b_수학1_연습;

import java.io.*;

// 9613번 GCD 합
public class boj_1_9613 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String[] inputs = br.readLine().split(" ");

            int n = Integer.parseInt(inputs[0]);

            int[] arr = new int[n];
            long answer = 0;

            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt((inputs[i + 1]));
            }

            for (int i = 0; i < arr.length - 1; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    answer += gcd(arr[i], arr[j]);
                }
            }
            bw.write(answer + "\n");

        }
        bw.flush();
        bw.close();
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

}
