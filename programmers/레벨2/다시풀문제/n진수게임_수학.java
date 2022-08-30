package 레벨2.다시풀문제;


import java.util.*;

class n진수게임_수학 {
    public String solution(int n, int t, int m, int p) {
        StringBuilder convert = new StringBuilder();
        StringBuilder answer = new StringBuilder();

        // convert의 길이가 미리 구할 숫자갯수 * 게임참가 인원만큼될때까지 n진수로 변환
        for (int i = 0; convert.length() <= t * m; i++) {
            //  System.out.println(i+" "+n);
            convert.append(Integer.toString(i, n));
        }

        for (int i = p - 1; answer.length() < t; i += m) {
            answer.append(convert.charAt(i));
        }
        return answer.toString().toUpperCase();
    }
}
