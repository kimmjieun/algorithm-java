package 레벨1.수학;

import java.util.*;

public class 소수찾기 {
    public int solution(int n) {
        int answer = 0;

        // 1
        // for(int i=2;i<=n;i++){
        //     if(isPrime(i)) answer++;
        // }

        // 2
        boolean[] prime = new boolean[n + 1];
        prime[0] = prime[1] = true;
        for (int i = 2; i <= n; i++) {
            if (!prime[i]) {
                for (int j = i + i; j <= n; j += i) {
                    prime[j] = true;
                }
            }
        }

        for (int i = 0; i <= n; i++) {
            if (!prime[i]) answer++;
        }


        return answer;
    }

    public boolean isPrime(int n) {
        if (n == 0 || n == 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;

    }
}
