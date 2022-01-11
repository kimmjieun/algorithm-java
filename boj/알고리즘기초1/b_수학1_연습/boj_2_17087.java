package 알고리즘기초1.b_수학1_연습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 17087번 숨바꼭질6
public class boj_2_17087 {
    public static int GCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(st2.nextToken());
            arr[i] = Math.abs(S - a);
        }

        int gcd = arr[0];
        for (int i = 1; i < arr.length; i++) {
            gcd = GCD(gcd, arr[i]);
        }
        System.out.println(gcd);
    }
}
