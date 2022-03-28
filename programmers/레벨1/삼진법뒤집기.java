package 레벨1;

import java.util.*;

public class 삼진법뒤집기 {

    public int solution(int n) {
        String str = "";
        int answer = 0;
        while (n != 0) {
            str += String.valueOf(n % 3);
            n = n / 3;
        }
        for (int i = 0; i < str.length(); i++) {

            answer += (str.charAt(i) - '0') * Math.pow(3, str.length() - i - 1);
            // System.out.println((str.charAt(i)-'0')+" " +Math.pow(3,str.length()-i-1));

        }
        return (int) answer;
    }
}
