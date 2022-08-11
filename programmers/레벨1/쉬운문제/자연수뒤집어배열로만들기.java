package 레벨1.쉬운문제;

public class 자연수뒤집어배열로만들기 {
    public int[] solution(long n) {
        String s = String.valueOf(n);
        char[] c = s.toCharArray();
        int[] answer = new int[c.length];

        for (int i = c.length - 1; i >= 0; i--) {
            answer[c.length - i - 1] = c[i] - '0';
        }
        return answer;
    }
}
