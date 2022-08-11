package 레벨1.어려운문제;

public class 이상한문자만들기 {
    public String solution(String s) {
        String answer = "";
        String[] str = s.split("");
        int cnt = 0;
        for (String ss : str) {
            cnt = ss.contains(" ") ? 0 : cnt + 1;
            answer += cnt % 2 == 0 ? ss.toLowerCase() : ss.toUpperCase();
        }
        return answer;
    }
}
