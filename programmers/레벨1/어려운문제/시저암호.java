package 레벨1.어려운문제;
// 문자열, 아스키코드
public class 시저암호 {
    public String solution(String s, int n) {
        String answer = "";

        for (int i = 0; i < s.length(); i++) {
            int tmp = s.charAt(i);
            if (tmp >= 'A' && tmp <= 'Z') {
                if (tmp + n > 'Z') {
                    answer += (char) (tmp + n - 26);
                } else {
                    answer += (char) (tmp + n);
                }
            } else if (tmp >= 'a' && tmp <= 'z') {
                if (tmp + n > 'z') {
                    answer += (char) (tmp + n - 26);
                } else {
                    answer += (char) (tmp + n);
                }
            } else if (tmp == ' ') {
                answer += " ";
            }
        }
        return answer;
    }
}
