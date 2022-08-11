package 레벨1.수학;

public class 짝수와홀수 {
    public String solution(int num) {
        String answer = "";
        if (num % 2 == 0) {
            return "Even";
        } else {
            return "Odd";
        }
    }
}
