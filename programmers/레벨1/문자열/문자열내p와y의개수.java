package 레벨1.문자열;

public class 문자열내p와y의개수 {
    boolean solution(String s) {
        boolean answer = true;

        s = s.toLowerCase();

        int p = 0;
        int y = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'p') {
                p++;
            } else if (s.charAt(i) == 'y') {
                y++;
            }
        }
        if (p == 0 && y == 0) answer = true;
        else {
            if (p == y) answer = true;
            else answer = false;
        }


        return answer;
    }
}
