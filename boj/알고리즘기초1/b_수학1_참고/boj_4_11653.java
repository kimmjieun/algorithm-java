package 알고리즘기초1.b_수학1_참고;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 11653번 소인수분해
public class boj_4_11653 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for(int i =2;i<=Math.sqrt(N);i++) {
            while (N % i == 0) {
                sb.append(i).append('\n');
                N/=i;
            }
        }

        if(N!=1){
            sb.append(N);
        }
        System.out.println(sb);

    }
}
