package 알고리즘기초1.b_수학1_연습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// 17103번 골드바흐 파티션
public class boj_6_17103 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        ArrayList<Integer> prime = new ArrayList<>();
        boolean[] check = new boolean[1000001];

        // 소수 구하기
        check[0] = check[1] = true;
        for (int i = 2; i < 1000001; i++) {
            if (check[i] == false) {
                prime.add(i);
                for (int j = i + i; j < 1000001; j += i) {
                    check[j] = true;
                }
            }
        }

        // n/2까지만 탐색하는 법
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int result = 0;
            for (int i = 0; prime.get(i) <= n / 2; i++) {
                // 골드바흐가 맞다면
                if (check[n - prime.get(i)] == false) {
                    result++;
                }
            }
            System.out.println(result);
        }
    }

}
