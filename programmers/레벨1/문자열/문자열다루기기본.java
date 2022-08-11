package 레벨1.문자열;

public class 문자열다루기기본 {
    public boolean solution(String s) {
        boolean answer = true;
        if (s.length() == 4 || s.length() == 6) {
            for (int i = 0; i < s.length(); i++) {
                // System.out.println(s.charAt(i));
                int n = s.charAt(i) - '0';
                if (n < 0 || n > 9) {
                    answer = false;
                    break;
                }
            }
        } else {
            answer = false;
        }
        return answer;
    }
}
