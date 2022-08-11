package 레벨1.쉬운문제;

public class 나머지가1이되는수찾기 {
    public int solution(int n) {
        int answer = 0;
        for (int i = 2; i < n; i++) {
            if (n % i == 1) {
                answer = i;
                break;
            }
        }
        return answer;
    }
}
