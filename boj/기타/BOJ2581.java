package 기타;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class BOJ2581 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int min ;

        List<Integer> sum  = new ArrayList<>();

        for (int i = M; i <= N; i++) {

            int count = 0;
            if (i == 1) {
                continue;
            } else {
                for (int j = 1; j <= i; j++) {
                    if (i % j == 0) {
                        count++;
                    }
                }
            }
            if (count == 2) {
                sum.add(i);
            }
        }

        if(sum.isEmpty()){
            System.out.println(-1);
        }else {
            System.out.println(sum.stream().mapToInt(Integer::intValue).sum());
            System.out.println(sum.get(0));
        }

    }
}
