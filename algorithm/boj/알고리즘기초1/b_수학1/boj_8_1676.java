package boj.알고리즘기초1.b_수학1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 1676번 팩토리얼 0의 개수
public class boj_8_1676 {
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int count=0;

        while(num>=5){
            count += num/5;
            num/=5;
        }

        System.out.println(count);

    }
}
