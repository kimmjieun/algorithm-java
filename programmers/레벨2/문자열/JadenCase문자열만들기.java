package 레벨2.문자열;


class JadenCase문자열만들기 {
    public String solution(String s) {
        String answer = "";
        s = s.toLowerCase();
        answer += answer += (s.charAt(0) + "").toUpperCase();

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == ' ') {
                answer += (s.charAt(i) + "").toUpperCase();
            } else {
                answer += s.charAt(i);
            }
        }

        return answer;
    }
}