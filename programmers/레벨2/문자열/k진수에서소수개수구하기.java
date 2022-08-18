package 레벨2.문자열;

import static java.lang.Math.sqrt;

public class k진수에서소수개수구하기 {
    public int solution2(int n, int k) {
        int answer = 0;

        String s = Integer.toString(n, k);
        s = s.replaceAll("[0]{1,}", "0");//중요!!!

        String[] arr = s.split("0");
        for (String a : arr) {
            System.out.println(a);
            if (isPrime(Long.parseLong(a))) {
                answer++;
            }

        }


        return answer;
    }


    public static int solution(int n, int k) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n % k);
            n = n / k;
        }

        String s = sb.reverse().toString();
        String[] split = s.split("0");

        for (String x : split) {
            if (x.equals("")) continue;
            if (isPrime(Long.parseLong(x))) count++;
        }

        return count;
    }

    public static boolean isPrime(long num) {
        if (num == 1) {
            return false;
        }
        for (int i = 2; i <= sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

}
